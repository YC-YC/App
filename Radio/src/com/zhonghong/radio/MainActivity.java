package com.zhonghong.radio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.zhonghong.mcuservice.RadioInfo;
import android.zhonghong.mcuservice.RadioProxy;
import android.zhonghong.mcuservice.RegistManager.IRadioInfoChangedListener;

import com.zhonghong.radio.dialog.KeyboardDialog;
import com.zhonghong.radio.dialog.KeyboardDialog.OnClickCancleListener;
import com.zhonghong.radio.dialog.KeyboardDialog.OnClickConfirmListener;
import com.zhonghong.radio.list.MyAdapter;
import com.zhonghong.radio.utils.AM;
import com.zhonghong.radio.utils.FM;
import com.zhonghong.radio.utils.RadioDataUtils;
import com.zhonghong.radio.utils.RadioInterface;
import com.zhonghong.radio.utils.T;

public class MainActivity extends Activity implements OnSeekBarChangeListener, OnClickListener, OnLongClickListener{

	//final value
	private static final String TAG = "RadioMainActivity";
	
	//value
	
	private Handler mHandler = new Handler();
	
	private RadioInterface mRadio;
	private List<String> mListData = new ArrayList<String>();
	private MyAdapter mAdapter;
	
	private RadioProxy mRadioProxy ;
	
	//Ui Components
	private SeekBar mSeekBarFreq;
	private TextView mTvCurFreq;
	private ImageView mImgBand, mImgLoc, mImgSt, mImgStInd, mImgUnit;
	private Button mBtnMute, mBtnBand, mBtnSearch, mBtnKeyboard, mBtnScan, mBtnLoc;
	private Button mBtnLeft, mBtnRight;
	private ListView mLvFreq;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Transparent);	//设置主题
		setContentView(R.layout.activity_main);
		RadioDataUtils.getRadioAllInfo(this);
		getRadioInfoFreqJar();
//		RadioDataUtils.saveRadioAllInfo(this);
		if (isCurBandFM())
		{
			mRadio = new FM();
		}
		else
		{
			mRadio = new AM();
		}
		initView();
		setFreqToMcu(mRadio.getCurFreq());
	}

	@Override
	protected void onResume() {
		super.onResume();
		setListViewSelection();
	}
	
	public void doClick(View v)
	{
//		finish();
		backToHome(); 
	}

	/**
	 * 返回到主界面（Launcher监听）
	 */
	private void backToHome() {
		Intent i= new Intent(Intent.ACTION_MAIN);
	    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	    i.addCategory(Intent.CATEGORY_HOME);
	    startActivity(i);
	}
	
	@Override
	protected void onDestroy() {
		RadioDataUtils.saveRadioAllInfo(this);
		mRadioProxy.unregistRadioInfoChangedListener(mRadioInfoChangedListener);
		super.onDestroy();
	}
	
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}


	//Event
	private OnItemClickListener mItemClickListener = new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (T.mScanMode)
			{
				stopScan();
			}
			setListSelItem(position);
			UiDisplayTvCurFreq();
			UiDisplaySeekBarFreq();
			setFreqToMcu(mRadio.getCurFreq());
		}
		
	};
	
	private OnItemLongClickListener mItemLongClickListener = new OnItemLongClickListener() {
		@Override
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
			if (T.mScanMode)
			{
				stopScan();
			}
			mRadio.saveListItemFreq(position, mRadio.getCurFreq());
			mAdapter.setItemSel(position);
			refleshListViewData();
			return true;
		}
	};
	
	private OnTouchListener mTouchListener = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {

			switch (v.getId()) {
			case R.id.btn_left:
				if (event.getAction() == MotionEvent.ACTION_UP)//松开
				{
					if (T.mStepMode)
					{
						LOG("长按松开");
						mHandler.removeCallbacks(mDecreaseRunnable);
						mHandler.removeCallbacks(mStepModeRunnable);
						mHandler.postDelayed(mStepModeRunnable, T.STEP_MODE_TIME);
					}
				}
				break;
			case R.id.btn_right:
				if (event.getAction() == MotionEvent.ACTION_UP)//松开
				{
					
				}
				break;
			}
			
			return false;
		}
	};
	
	/**
	 * 步进处理,3S没按下取消步进模式
	 */
	private Runnable mStepModeRunnable = new Runnable() {
		
		@Override
		public void run() {
			T.mStepMode = false;
		}
	};
	
	/**
	 * 扫描处理
	 */
	private Runnable mScanModeRunnable = new Runnable() {
		
		@Override
		public void run() {
			long nowTime = SystemClock.elapsedRealtime();
			
			if (nowTime - T.mStartScanItemTime > T.SCAN_MODE_TIME)
			{
				if (T.mScanItem >= mRadio.getFreqListNum()-1)//最后一项
				{
					T.mScanMode = false;
					setListSelItem(0);
					UiDisplayTvCurFreq();
				}
				else//下一项
				{
					T.mScanItem++;
					startScanItem(T.mScanItem);
				}
			}
			else
			{
				T.mScanItemSel = !T.mScanItemSel;
				if (T.mScanItemSel)
				{
					setListSelItem(T.mScanItem);
				}
				else
				{
					setListSelItem(-1);
				}
				mHandler.postDelayed(this, T.SCAN_MODE_DIFF);
			}
		}

	};
	
	
	/**
	 * 长按增加
	 */
	private Runnable mIncreaseRunnable = new Runnable() {
		
		@Override
		public void run() {
			mRadio.setCurFreq(mRadio.getFreqForStep(true));
			UiDisplayTvCurFreq();
			setFreqToMcu(mRadio.getCurFreq());
			mHandler.postDelayed(this, T.STEP_MODE_DIFF);
		}
	};
	
	/**
	 * 长按减小
	 */
	private Runnable mDecreaseRunnable = new Runnable() {
		
		@Override
		public void run() {
			if (T.mStepMode)
			{
				LOG("DecreaseRunnable run");
				mRadio.setCurFreq(mRadio.getFreqForStep(false));
				UiDisplayTvCurFreq();
				setFreqToMcu(mRadio.getCurFreq());
				mHandler.postDelayed(this, T.STEP_MODE_DIFF);
			}
		}
	};

	private IRadioInfoChangedListener mRadioInfoChangedListener = new IRadioInfoChangedListener() {
		
		@Override
		public void notify(int[] arg0, final RadioInfo info) {
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					//loc
					if (info.isLoc() != T.RadioValue.mLoc)
					{
						T.RadioValue.mLoc = info.isLoc();
						UiDisplayImgLoc();
					}
					//ST
					if (info.isSt() != T.RadioValue.mSt)
					{
						T.RadioValue.mSt = info.isSt();
						UiDisplayImgSt();
					}
					//StInd
					if (info.isStInd() != T.RadioValue.mStInd)
					{
						T.RadioValue.mStInd = info.isStInd();
						UiDisplayImgStInd();
					}
					//Search
					/*T.RadioValue.mSearch = info.isSearch();
					if (T.RadioValue.mSearch)
					{
						mRadio.setFreq(info.getFreq());
						UiDisplayTvCurFreq();
						LOG("Search info.isHasLegalFreq() = " + info.isHasLegalFreq());
						if (info.isHasLegalFreq())
						{
							addOneItem(T.mSearchHadFreqNum, info.getLegalFreq(), true);
							T.mSearchHadFreqNum++;
							LOG("Search have freqNum = " + T.mSearchHadFreqNum + ", freq = " + info.getLegalFreq());
						}
					}*/
					
					LOG("info.isSearch() = " + info.isSearch());
					if (info.isSearch())
					{
						if (!T.RadioValue.mSearch)//开始搜台
						{
							if (T.mSearchReq)
							{
								mRadio.setDefaultFreq();
								refleshListViewData();
								setListSelItem(mRadio.getListSelItem());
								setListViewSelection();
								UiDisplayTvCurFreq();
								UiDisplayImgBand();
							}
						}
						if (T.mEnableReceiveFreq)
						{
							mRadio.setFreq(info.getFreq());
							UiDisplayTvCurFreq();
						}
//						LOG("Search info.isHasLegalFreq() = " + info.isHasLegalFreq());
						if (info.isHasLegalFreq())
						{
							addOneItem(T.mSearchHadFreqNum, info.getLegalFreq(), true);
							T.mSearchHadFreqNum++;
							LOG("Search have freqNum = " + T.mSearchHadFreqNum + ", freq = " + info.getLegalFreq());
						}
						
						/*{
							addOneItem(T.mSearchHadFreqNum, mRadio.getCurFreq(), true);
							T.mSearchHadFreqNum++;
							LOG("Search have freqNum = " + T.mSearchHadFreqNum + ", freq = " + info.getLegalFreq());
						}*/
					}
					else	
					{
//						LOG("Search T.RadioValue.mSearch = " + T.RadioValue.mSearch);
						if (T.RadioValue.mSearch)//搜索停止
						{
							if (T.mSearchReq)
							{
								LOG("Search Auto Stop");
								T.mSearchReq = false;
								T.mSearchHadFreqNum = 0;
								T.mSearchHadFreq = 0;
								setListSelItem(0);
								setListViewSelection();
								UiDisplayTvCurFreq();
								setFreqToMcu(mRadio.getCurFreq());
							}
						}
					}
					T.RadioValue.mSearch = info.isSearch();
				}
			});
		}
	}; 
	
	/**
	 * 从Jar包获取数据
	 */
	private void getRadioInfoFreqJar() {
		mRadioProxy	= new RadioProxy();	
		LOG("get RadioProxy is " + mRadioProxy.toString());
		RadioInfo radioInfo = mRadioProxy.getRadioInfo();
//		mRadioProxy.setFreq(band, freq);
		T.RadioValue.mLoc = radioInfo.isLoc();
		T.RadioValue.mSt = radioInfo.isSt();
		T.RadioValue.mStInd = radioInfo.isStInd();
		T.RadioValue.mSearch = radioInfo.isSearch();
		LOG("get RadioInfo = " + mRadioProxy.getRadioInfo().toString());
		mRadioProxy.registRadioInfoChangedListener(mRadioInfoChangedListener);
	}
	
	/**
	 * 初始化组件
	 */
	private void initView() {
			mSeekBarFreq = (SeekBar) findViewById(R.id.seekBar_freq);
			mSeekBarFreq.setOnSeekBarChangeListener(this);
			
			mTvCurFreq = (TextView) findViewById(R.id.tv_curFreq);
			
			mImgBand = (ImageView) findViewById(R.id.img_band);
			
			mImgUnit = (ImageView) findViewById(R.id.img_unit);
			mImgLoc = (ImageView) findViewById(R.id.img_loc);
			mImgSt = (ImageView) findViewById(R.id.img_st);
			mImgStInd = (ImageView) findViewById(R.id.img_oo);
			
			mBtnMute = (Button) findViewById(R.id.btn_mute);
			mBtnMute.setOnClickListener(this);
			
			mBtnBand = (Button) findViewById(R.id.btn_band);
			mBtnBand.setOnClickListener(this);
			
			mBtnSearch = (Button) findViewById(R.id.btn_search);
			mBtnSearch.setOnClickListener(this);
			
			mBtnKeyboard = (Button) findViewById(R.id.btn_keyboard);
			mBtnKeyboard.setOnClickListener(this);
			
			mBtnScan = (Button) findViewById(R.id.btn_scan);
			mBtnScan.setOnClickListener(this);
			
			mBtnLoc = (Button) findViewById(R.id.btn_loc);
			mBtnLoc.setOnClickListener(this);
			
			mBtnLeft = (Button) findViewById(R.id.btn_left);
			mBtnLeft.setOnClickListener(this);
			mBtnLeft.setOnLongClickListener(this);
			mBtnLeft.setOnTouchListener(mTouchListener);
			
			mBtnRight = (Button) findViewById(R.id.btn_right);
			mBtnRight.setOnClickListener(this);
			mBtnRight.setOnLongClickListener(this);
			mBtnRight.setOnTouchListener(mTouchListener);
			
			mLvFreq = (ListView) findViewById(R.id.freq_listView);
			
			RefreshView();
		}

	/**
	 *
	 */
	private boolean isScanUndoKey(int keyId)
	{
		switch (keyId) {
		case R.id.btn_mute:
		case R.id.btn_scan:
		case R.id.btn_loc:
			return true;
		}
		return false;
	}
	
	@Override
	public void onClick(View v) {
		// TODO onClick处理
		/*if (T.mScanMode && !isScanUndoKey(v.getId()))
		{
			stopScan();
		}*/
		switch (v.getId()) {
		case R.id.btn_mute:
			toggleMute();
			break;
		case R.id.btn_band:	//Band
			toggleBand();
			break;
		case R.id.btn_keyboard:	//键盘
			showKeyboardDialog();
			break;
		case R.id.btn_search:	//搜索
//			addOneItem(mRadio.getFreqListNum(), 8750, true);
			procSearch();
			break;
		case R.id.btn_loc:	//远程程
			procLoc();
			break;
		case R.id.btn_scan:	//浏览
			procScan();
			break;
		case R.id.btn_left:	//左、上
			procPre();
//			procPreCh();
			break;
		case R.id.btn_right:	//右、下
			procNext();
//			procNextCh();
			break;
		}
	}

	@Override
	public boolean onLongClick(View v) {
		switch (v.getId()) {
		case R.id.btn_left:	//长按左、上
			procPreLong();
			break;
		case R.id.btn_right: //长按右、下
			procNextLong();
			break;
		}
		return false;
	}

	/**
	 * @param position 插入位置
	 * @param freq 添加频率
	 * @param bSel 是否选中
	 */
	private void addOneItem(int position, int freq, boolean bSel) {
		mRadio.saveListItemFreq(position, freq);
		refleshListViewData();
		if (bSel)
		{
//			mAdapter.setItemSel(position);
			setListSelItem(position);
			setListViewSelection();
		}
	}

	private void toggleMute() {
		T.RadioValue.mMute = !T.RadioValue.mMute;
		UiDisplayBtnMute();
	}

	
	/**
	 * 切换Band
	 */
	private void toggleBand() {
		if (T.mScanMode)
		{
			stopScan();
			setListSelItem(T.mScanItem);
		}
		if (isCurBandFM())
		{
			T.RadioValue.mBand = T.AM_1;
			mRadio = new AM();
		}
		else
		{
			T.RadioValue.mBand = T.FM_1;
			mRadio = new FM();
		}
		RefreshView();
		mAdapter.setItemSel(mRadio.getListSelItem());
		setListViewSelection();
		setFreqToMcu(mRadio.getCurFreq());
	}

	/**
	 * position ListView
	 * 定位列表
	 */
	private void setListViewSelection() {
		int position = mRadio.getListSelItem();
		
		if (position < T.LIST_COUNT)
		{
			position = 0;
		}
		else
		{
			position = position - T.LIST_COUNT + 1;
		}
		final int postPosition = position;
		mHandler.post(new Runnable() {
			//通过Post解决setSelection无作用问题
			@Override
			public void run() {
				mLvFreq.setSelection(postPosition);
			}
		});
	}

	
	/*private int getListViewNum()
	{
		int firstVisiblePosition = mFreqList.getFirstVisiblePosition();
		View v = mFreqList.getChildAt(firstVisiblePosition);
		LOG("v.getHeight() = " + v.getHeight());

		int top = (v == null)?0 : v.getTop();
		int count = mFreqList.getLastVisiblePosition()-mFreqList.getFirstVisiblePosition();
		if (top > 0)
		{
			count--;
		}
		LOG("FirstVisiblePosition = " + firstVisiblePosition + ", top = " + top + ", count = " + count);
		LOG("LastVisiblePosition = " + mFreqList.getLastVisiblePosition());

		return count;
	}*/
	
	/**
	 * 显示键盘
	 */
	private void showKeyboardDialog() {
		KeyboardDialog keyboardDialog = new KeyboardDialog(this, mRadio);
		Window dialogWindow = keyboardDialog.getWindow();
//		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.RIGHT);
		/*
		* lp.x与lp.y表示相对于原始位置的偏移.
		* 当参数值包含Gravity.LEFT时,对话框出现在左边,所以lp.x就表示相对左边的偏移,负值忽略.
		* 当参数值包含Gravity.RIGHT时,对话框出现在右边,所以lp.x就表示相对右边的偏移,负值忽略.
		* 当参数值包含Gravity.TOP时,对话框出现在上边,所以lp.y就表示相对上边的偏移,负值忽略.
		* 当参数值包含Gravity.BOTTOM时,对话框出现在下边,所以lp.y就表示相对下边的偏移,负值忽略.
		* 当参数值包含Gravity.CENTER_HORIZONTAL时
		* ,对话框水平居中,所以lp.x就表示在水平居中的位置移动lp.x像素,正值向右移动,负值向左移动.
		* 当参数值包含Gravity.CENTER_VERTICAL时
		* ,对话框垂直居中,所以lp.y就表示在垂直居中的位置移动lp.y像素,正值向右移动,负值向左移动.
		* gravity的默认值为Gravity.CENTER,即Gravity.CENTER_HORIZONTAL |
		* Gravity.CENTER_VERTICAL.
		* 
		*/
//		lp.x = 100; // 新位置X坐标
//		lp.y = 100; // 新位置Y坐标
//		lp.width = 300; // 宽度
//		lp.height = 300; // 高度
//		lp.alpha = 0.7f; // 透明度
//		dialogWindow.setAttributes(lp);
		
		keyboardDialog.setOnClickCancleListener(new OnClickCancleListener() {
			
			@Override
			public void onCancle(Dialog dialog) {
				dialog.dismiss();
			}
		});
		keyboardDialog.setOnClickConfirmListener(new OnClickConfirmListener() {
			
			@Override
			public void onConfirm(Dialog dialog, int freq) {
				if (T.mScanMode)
				{
					stopScan();
				}
				mRadio.setFreq(freq);
				setFreqToMcu(freq);
				setListSelItem(-1);
				UiDisplayTvCurFreq();
				dialog.dismiss();
			}
		});
		keyboardDialog.show();
	}
	
	
	/**
	 * 搜索
	 */
	private void procSearch() {
		if (T.mScanMode)
		{
			stopScan();
		}
		if (!T.RadioValue.mSearch)
		{
			/*mRadio.setDefaultFreq();
			refleshListViewData();
			setListSelItem(mRadio.getListSelItem());
			setListViewSelection();
			UiDisplaySeekBarFreq();
			UiDisplayTvCurFreq();
			UiDisplayImgBand();*/
			T.mEnableReceiveFreq = true;
			T.mSearchReq = true;
		}
		else
		{
			T.mEnableReceiveFreq = false;
			setListSelItem(-1);
			T.mSearchReq = false;
		}
		T.mSearchHadFreqNum = 0;
		T.mSearchHadFreq = 0;
		mRadioProxy.setSearch();
	}
	
	/**
	 * St
	 */
	private void procSt()
	{
		mRadioProxy.setST();
	}
	
	/**
	 * LOC
	 */
	private void procLoc()
	{
		if (isCurBandFM())
		{
			mRadioProxy.setLOC();
//			UiDisplayImgLoc();
		}
	}
	
	/**
	 * 浏览
	 */
	private void procScan() {
		if (T.mScanMode)
		{
			stopScan();
			setListSelItem(T.mScanItem);
		}
		else
		{
			T.mScanMode = true;
			T.mScanItem = 0;
			startScanItem(T.mScanItem);
		}
	}

	
	
	/**
	 * 上、左
	 */
	private void procPre(){
		if (T.mScanMode)
		{
			stopScan();
		}
		if (T.mSearchReq)
		{
			T.mSearchReq = false;
		}
		setListSelItem(-1);
		if (T.mStepMode)
		{
			mHandler.removeCallbacks(mStepModeRunnable);
			mHandler.postDelayed(mStepModeRunnable, T.STEP_MODE_TIME);
			mRadio.setCurFreq(mRadio.getFreqForStep(false));
			UiDisplayTvCurFreq();
			setFreqToMcu(mRadio.getCurFreq());
		}
		else
		{
			T.mEnableReceiveFreq = true;
			mRadioProxy.setSearchLeft();
		}
	}
	
	/**
	 * 长按上、左
	 */
	private void procPreLong(){
		if (T.mScanMode)
		{
			stopScan();
		}
		setListSelItem(-1);
		T.mStepMode = true;
		mRadio.setCurFreq(mRadio.getFreqForStep(false));
		UiDisplayTvCurFreq();
		setFreqToMcu(mRadio.getCurFreq());
		mHandler.removeCallbacks(mStepModeRunnable);
		mHandler.postDelayed(mDecreaseRunnable, T.STEP_MODE_DIFF);
	}
	
	/**
	 * 上一频率
	 */
	private void procPreCh()
	{
		int item = mRadio.getListSelItem();
		if (item < 0)
		{
			item = 0;
		}
		else if (item == 0)
		{
			item = mRadio.getFreqListNum() - 1;
		}
		else
		{
			item--;
		}
		setListSelItem(item);
		setListViewSelection();
		UiDisplayTvCurFreq();
		setFreqToMcu(mRadio.getCurFreq());
	}
	
	/**
	 * 右、下
	 */
	private void procNext(){
		if (T.mScanMode)
		{
			stopScan();
		}
		if (T.mSearchReq)
		{
			T.mSearchReq = false;
		}
		setListSelItem(-1);
		if (T.mStepMode)
		{
			mHandler.removeCallbacks(mStepModeRunnable);
			mHandler.postDelayed(mStepModeRunnable, T.STEP_MODE_TIME);
			mRadio.setCurFreq(mRadio.getFreqForStep(true));
			UiDisplayTvCurFreq();
			setFreqToMcu(mRadio.getCurFreq());
		}
		else
		{
			T.mEnableReceiveFreq = true;
			mRadioProxy.setSearchRight();
		}
	}
	
	/**
	 *长按右、下
	 */
	private void procNextLong(){
		if (T.mScanMode)
		{
			stopScan();
		}
		setListSelItem(-1);
		T.mStepMode = true;
		mRadio.setCurFreq(mRadio.getFreqForStep(true));
		UiDisplayTvCurFreq();
		setFreqToMcu(mRadio.getCurFreq());
		mHandler.removeCallbacks(mStepModeRunnable);
		mHandler.postDelayed(mIncreaseRunnable, T.STEP_MODE_DIFF);
	}
	
 	private boolean isCurBandFM() {
		return T.RadioValue.mBand <= T.FM_3;
	}

 	/**
	 * 下一频率
	 */
	private void procNextCh()
	{
		int item = mRadio.getListSelItem();
		if (item < 0)
		{
			item = 0;
		}
		else if (item == mRadio.getFreqListNum() - 1)
		{
			item = 0;
		}
		else
		{
			item++;
		}
		setListSelItem(item);
		setListViewSelection();
		UiDisplayTvCurFreq();
		setFreqToMcu(mRadio.getCurFreq());
	}
	
	/**
	 * 刷新UI
	 */
	private void RefreshView()
	{
		UiDisplayTvCurFreq();
		UiDisplayImgBand();
		setSeekBarBackground();
		UiDisplayImgUnit();
		UiDisplayImgLoc();
		UiDisplayImgSt();
		UiDisplayImgStInd();
		setBtnLocState();
		UiDisplayBtnMute();
		refleshListViewData();
	}


	/**
	 * 更新列表
	 */
	private void refleshListViewData() {
		mListData = mRadio.getFreqList();
		if (mAdapter == null) {
			mLvFreq = (ListView) findViewById(R.id.freq_listView);
			mAdapter = new MyAdapter(this, mListData);
			mAdapter.setItemSel(mRadio.getListSelItem());
			mLvFreq.setAdapter(mAdapter);
			mLvFreq.setOnItemClickListener(mItemClickListener);
			mLvFreq.setOnItemLongClickListener(mItemLongClickListener);
		} else {
			mAdapter.OnDataChange(mListData);
		}
	}

	
	/**
	 * 切换SeekBar背景
	 */
	private void setSeekBarBackground() {
		mSeekBarFreq.setMax(mRadio.getSeekbarMax());
		if (isCurBandFM())
		{
			mSeekBarFreq.setProgressDrawable(getResources().getDrawable(R.drawable.seekbar_fm_horizontal));
		}
		else
		{
			mSeekBarFreq.setProgressDrawable(getResources().getDrawable(R.drawable.seekbar_am_horizontal));
		}
	}

	/**
	 * 设置Loc是否可点击
	 */
	private void setBtnLocState()
	{
		if (isCurBandFM())
		{
//			mLOC_bt.setEnabled(true);
			mBtnLoc.setClickable(true);
		}
		else
		{
//			mLOC_bt.setEnabled(false);
			mBtnLoc.setClickable(false);
		}
	}
	
	/**
	 * @param item ListView UI选中项
	 */
	private void setListSelItem(int item) {
		mRadio.selListItemFreq(item);
		mAdapter.setItemSel(item);
	}
	
	/**
	 * @param item 开始浏览项
	 */
	private void startScanItem(int item) {
		T.mStartScanItemTime = SystemClock.elapsedRealtime();
		T.mScanItemSel = true;
		setListSelItem(item);
		setListViewSelection();
		UiDisplayTvCurFreq();
		setFreqToMcu(mRadio.getCurFreq());
		mHandler.postDelayed(mScanModeRunnable, T.SCAN_MODE_DIFF);
	}
	
	/**
	 * 停止浏览
	 */
	private void stopScan()
	{
		T.mScanMode = false;
		mHandler.removeCallbacks(mScanModeRunnable);
	}
	
	/*
	 ----------------------SeekBar---------------------------- 
	 */
	private void UiDisplaySeekBarFreq() {
		mSeekBarFreq.setProgress(mRadio.getCurFreq() - mRadio.getMinFreq());
	}
	
	/*
	 ----------------------TextView---------------------------- 
	 */
	
	private void UiDisplayTvCurFreq()
	{
		mTvCurFreq.setText(mRadio.getDisplayFreq(mRadio.getCurFreq()));
		File file = new File("/ResidentFlash/ZuiLauncher/data/fonts/digital-7-italic.ttf");
		if (file.exists())
		{
//			LOG("file exists");
			Typeface typeface = Typeface.createFromFile(file);
			mTvCurFreq.setTypeface(typeface);
		}
		else
		{
//			LOG("file not exists");
		}
		/*Typeface typeface = Typeface.createFromAsset(getAssets(), "digital-7-italic.ttf");
		if (typeface != null)
		{
			mTvCurFreq.setTypeface(typeface);
		}*/
		UiDisplaySeekBarFreq();
	}
	
	/*
	 ----------------------Image---------------------------- 
	 */
	private void UiDisplayImgBand()
	{
		if (isCurBandFM())
		{
			mImgBand.setBackgroundResource(R.drawable.fm);
		}
		else
		{
			mImgBand.setBackgroundResource(R.drawable.am);
		}
	}
	
	private void UiDisplayImgUnit()
	{
		if (isCurBandFM())
		{
			mImgUnit.setBackgroundResource(R.drawable.mhz);
		}
		else
		{
			mImgUnit.setBackgroundResource(R.drawable.khz);
		}
	}
	
	private void UiDisplayImgLoc()
	{
		if (isCurBandFM() && T.RadioValue.mLoc)
		{
			mImgLoc.setBackgroundResource(R.drawable.loc_sel);
		}
		else
		{
			mImgLoc.setBackgroundResource(R.drawable.loc_inval);
		}
	}
	
	private void UiDisplayImgSt()
	{
		if (isCurBandFM() && T.RadioValue.mSt)
		{
			mImgSt.setBackgroundResource(R.drawable.st_sel);
		}
		else
		{
			mImgSt.setBackgroundResource(R.drawable.st_inval);
		}
	}
	
	private void UiDisplayImgStInd()
	{
		if (isCurBandFM() && T.RadioValue.mStInd)
		{
			mImgStInd.setBackgroundResource(R.drawable.stind_sel);
			mImgStInd.setVisibility(View.VISIBLE);
		}
		else
		{
			mImgStInd.setVisibility(View.INVISIBLE);
		}
	}
	
	/*
	 ----------------------Button---------------------------- 
	 */
	
	private void UiDisplayBtnMute() {
		mBtnMute.setSelected(T.RadioValue.mMute);
		/*if (T.RadioValue.mMute)
		{
//			mMute_bt.setBackgroundResource(R.drawable.mute_selector);
			mMute_bt.setSelected(true);
			
		}
		else
		{
//			mMute_bt.setBackgroundResource(R.drawable.unmute_selector);
			mMute_bt.setSelected(false);
		}*/
	}
	
	private void LOG(String string)
	{
		Log.i(TAG, string);
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
//		LOG("fromUser " + fromUser);
		if (fromUser)
		{
			int freq = mRadio.getMinFreq() + progress;
			if (Math.abs(freq - mRadio.getCurFreq()) >= mRadio.getFreqStep())
			{
				seekToFreq(freq/mRadio.getFreqStep()*mRadio.getFreqStep());
			}
		}
	}

	private void seekToFreq(int freq) {
		if (T.mScanMode)
		{
			stopScan();
		}
		
		mRadio.setCurFreq(freq);
		UiDisplayTvCurFreq();
		setListSelItem(-1);
		setFreqToMcu(freq);
	}

	/**
	 * 设频率到MCU
	 * @param freq
	 */
	private void setFreqToMcu(int freq) {
		
		if (T.mSearchReq)
		{
			T.mSearchReq = false;
		}
		
		T.mEnableReceiveFreq = false;
		
		if (mRadio.isFM())
		{
			mRadioProxy.setFreq(T.FM_1, freq);
		}
		else
		{
			mRadioProxy.setFreq(T.AM_1, freq);
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		
	}

	
	
}

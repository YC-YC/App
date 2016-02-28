package com.zhonghong.radio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

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
	private List<String> mListData = new ArrayList<String>();	//�б�����
	private MyAdapter mAdapter;
	
	//Ui Components
	private SeekBar mFreqSeekBar;
	private TextView mCurFreq_tv;
	private ImageView mBand_img, mLOC_img, mST_img, mOO_img;
	private ImageView mUnit_img;
	private Button mMute_bt, mBand_bt, mSearch_bt, mKeyboard_bt, mScan_bt, mLOC_bt;
	private Button mLeft_bt, mRight_bt;
	private ListView mFreqList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTheme(R.style.Transparent);	//͸������
		setContentView(R.layout.activity_main);
		
		RadioDataUtils.getRadioAllInfo(this);
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

	}

	@Override
	protected void onResume() {
		super.onResume();
		setListViewSelection();
	}
	
	@Override
	protected void onDestroy() {
		RadioDataUtils.saveRadioAllInfo(this);
		super.onDestroy();
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
			mRadio.selListItemFreq(position);
			mAdapter.setItemSel(position);
			UiDisplayTvCurFreq();
			setSeekBarValue();
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
			refleshListView();
			return true;
		}
	};
	
	private OnTouchListener mTouchListener = new OnTouchListener() {
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {

			switch (v.getId()) {
			case R.id.bt_left:
				if (event.getAction() == MotionEvent.ACTION_UP)//�ɿ�
				{
					if (T.mStepMode)
					{
						LOG("�����ɿ�");
						mHandler.removeCallbacks(mDecreaseRunnable);
						mHandler.removeCallbacks(mStepModeRunnable);
						mHandler.postDelayed(mStepModeRunnable, T.STEP_MODE_TIME);
					}
				}
				break;
			case R.id.bt_right:
				if (event.getAction() == MotionEvent.ACTION_UP)//�ɿ�
				{
					
				}
				break;
			}
			
			return false;
		}
	};
	
	/**
	 * ��������
	 */
	private Runnable mStepModeRunnable = new Runnable() {
		
		@Override
		public void run() {
			T.mStepMode = false;
			LOG("T.mStepMode = false");
		}
	};
	
	/**
	 * �������
	 */
	private Runnable mScanModeRunnable = new Runnable() {
		
		@Override
		public void run() {
			long nowTime = SystemClock.elapsedRealtime();
			
			if (nowTime - T.mStartScanItemTime > T.SCAN_MODE_TIME)
			{
				if (T.mScanItem >= mRadio.getFreqListNum()-1)//���һ��
				{
					T.mScanMode = false;
					mRadio.selListItemFreq(0);
					mAdapter.setItemSel(0);
					UiDisplayTvCurFreq();
				}
				else//��һ��
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
					mRadio.selListItemFreq(T.mScanItem);
					mAdapter.setItemSel(T.mScanItem);
				}
				else
				{
					mRadio.selListItemFreq(-1);
					mAdapter.setItemSel(-1);
				}
				mHandler.postDelayed(this, T.SCAN_MODE_DIFF);
			}
		}

	};
	
	
	/**
	 * ����
	 */
	private Runnable mIncreaseRunnable = new Runnable() {
		
		@Override
		public void run() {
			mRadio.setCurFreq(mRadio.getFreqForStep(true));
			UiDisplayTvCurFreq();
			mHandler.postDelayed(this, T.STEP_MODE_DIFF);
		}
	};
	
	//����
	private Runnable mDecreaseRunnable = new Runnable() {
		
		@Override
		public void run() {
			mRadio.setCurFreq(mRadio.getFreqForStep(false));
			UiDisplayTvCurFreq();
			mHandler.postDelayed(this, T.STEP_MODE_DIFF);
		}
	};
	


	
	

	//���ҿؼ��ͳ�ʼ���¼�
	private void initView() {
			mFreqSeekBar = (SeekBar) findViewById(R.id.seekBar_freq);
			mFreqSeekBar.setOnSeekBarChangeListener(this);
			
			mCurFreq_tv = (TextView) findViewById(R.id.tv_curFreq);
			
			mBand_img = (ImageView) findViewById(R.id.img_band);
			
			mUnit_img = (ImageView) findViewById(R.id.img_unit);
			mLOC_img = (ImageView) findViewById(R.id.img_loc);
			mST_img = (ImageView) findViewById(R.id.img_st);
			mOO_img = (ImageView) findViewById(R.id.img_oo);
			
			mMute_bt = (Button) findViewById(R.id.bt_mute);
			mMute_bt.setOnClickListener(this);
			
			mBand_bt = (Button) findViewById(R.id.bt_band);
			mBand_bt.setOnClickListener(this);
			
			mSearch_bt = (Button) findViewById(R.id.bt_search);
			mSearch_bt.setOnClickListener(this);
			
			mKeyboard_bt = (Button) findViewById(R.id.bt_keyboard);
			mKeyboard_bt.setOnClickListener(this);
			
			mScan_bt = (Button) findViewById(R.id.bt_scan);
			mScan_bt.setOnClickListener(this);
			
			mLOC_bt = (Button) findViewById(R.id.bt_loc);
			mLOC_bt.setOnClickListener(this);
			
			mLeft_bt = (Button) findViewById(R.id.bt_left);
			mLeft_bt.setOnClickListener(this);
			mLeft_bt.setOnLongClickListener(this);
			mLeft_bt.setOnTouchListener(mTouchListener);
			
			mRight_bt = (Button) findViewById(R.id.bt_right);
			mRight_bt.setOnClickListener(this);
			mRight_bt.setOnLongClickListener(this);
			mRight_bt.setOnTouchListener(mTouchListener);
			
			mFreqList = (ListView) findViewById(R.id.freq_listView);
			
			RefreshView();
		}

	/**
	 * ɨ��ʱ���жϵİ���
	 */
	private boolean isScanUndoKey(int keyId)
	{
		switch (keyId) {
		case R.id.bt_mute:
		case R.id.bt_scan:
		case R.id.bt_loc:
			return true;
		}
		return false;
	}
	
	@Override
	public void onClick(View v) {
		// TODO onClick������Ϣ
		if (T.mScanMode && !isScanUndoKey(v.getId()))
		{
			stopScan();
		}
		switch (v.getId()) {
		case R.id.bt_mute:
			T.RadioValue.mMute = !T.RadioValue.mMute;
			UiDisplayBtnMute();
			break;
		case R.id.bt_band:	//�в���
			changeToOtherBand();
			break;
		case R.id.bt_search:	//����
//			getListViewNum();
			break;
		case R.id.bt_keyboard:	//����
			showKeyboardDialog();
			break;
		case R.id.bt_loc:	//Զ����
			toggleLOC();
			break;
		case R.id.bt_scan:	//���
			procScan();
			break;
		case R.id.bt_left:	//�̰���
			procPre();
			break;
		case R.id.bt_right:	//�̰���
			procNext();
			break;
		}
	}

	

	private void showKeyboardDialog() {
		KeyboardDialog keyboardDialog = new KeyboardDialog(this, mRadio);
		Window dialogWindow = keyboardDialog.getWindow();
//		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.RIGHT);
		/*
		* lp.x��lp.y��ʾ�����ԭʼλ�õ�ƫ��.
		* ������ֵ����Gravity.LEFTʱ,�Ի�����������,����lp.x�ͱ�ʾ�����ߵ�ƫ��,��ֵ����.
		* ������ֵ����Gravity.RIGHTʱ,�Ի���������ұ�,����lp.x�ͱ�ʾ����ұߵ�ƫ��,��ֵ����.
		* ������ֵ����Gravity.TOPʱ,�Ի���������ϱ�,����lp.y�ͱ�ʾ����ϱߵ�ƫ��,��ֵ����.
		* ������ֵ����Gravity.BOTTOMʱ,�Ի���������±�,����lp.y�ͱ�ʾ����±ߵ�ƫ��,��ֵ����.
		* ������ֵ����Gravity.CENTER_HORIZONTALʱ
		* ,�Ի���ˮƽ����,����lp.x�ͱ�ʾ��ˮƽ���е�λ���ƶ�lp.x����,��ֵ�����ƶ�,��ֵ�����ƶ�.
		* ������ֵ����Gravity.CENTER_VERTICALʱ
		* ,�Ի���ֱ����,����lp.y�ͱ�ʾ�ڴ�ֱ���е�λ���ƶ�lp.y����,��ֵ�����ƶ�,��ֵ�����ƶ�.
		* gravity��Ĭ��ֵΪGravity.CENTER,��Gravity.CENTER_HORIZONTAL |
		* Gravity.CENTER_VERTICAL.
		* 
		*/
//		lp.x = 100; // ��λ��X����
//		lp.y = 100; // ��λ��Y����
//		lp.width = 300; // ���
//		lp.height = 300; // �߶�
//		lp.alpha = 0.7f; // ͸����
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
				mRadio.setFreq(freq);
				UiDisplayTvCurFreq();
				dialog.dismiss();
			}
		});
		keyboardDialog.show();
	}

	@Override
	public boolean onLongClick(View v) {
		switch (v.getId()) {
		case R.id.bt_left:	//������
			procPreLong();
			break;
		case R.id.bt_right:	//������
			procNextLong();
			break;
		}
		return false;
	}
	
	/**
	 * �в���
	 */
	private void changeToOtherBand() {
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
	}

	/**
	 * ��λ���б���
	 */
	private void setListViewSelection() {
		int position = mRadio.getListSelItem();
		if (position < T.LIST_COUNT)
		{
			position = 0;
		}
		mFreqList.setSelection(position);
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
	 * �����̨
	 */
	private void procScan() {
		if (T.mScanMode)
		{
			stopScan();
			mRadio.selListItemFreq(T.mScanItem);
			mAdapter.setItemSel(T.mScanItem);
		}
		else
		{
			T.mScanMode = true;
			T.mScanItem = 0;
			startScanItem(T.mScanItem);
		}
	}
	
	/**
	 * ��ʼɨ���item��
	 * @param item
	 */
	private void startScanItem(int item) {
		T.mStartScanItemTime = SystemClock.elapsedRealtime();
		T.mScanItemSel = true;
		mRadio.selListItemFreq(item);
		mAdapter.setItemSel(item);
		UiDisplayTvCurFreq();
		mHandler.postDelayed(mScanModeRunnable, T.SCAN_MODE_DIFF);
	}
	
	/**
	 * ֹͣɨ��
	 */
	private void stopScan()
	{
		T.mScanMode = false;
		mHandler.removeCallbacks(mScanModeRunnable);
	}
	
	/**
	 * ǰ/��
	 */
	private void procPre(){
		mRadio.selListItemFreq(-1);
		mAdapter.setItemSel(-1);
		if (T.mStepMode)
		{
			mHandler.removeCallbacks(mStepModeRunnable);
			mHandler.postDelayed(mStepModeRunnable, T.STEP_MODE_TIME);
			mRadio.setCurFreq(mRadio.getFreqForStep(false));
			UiDisplayTvCurFreq();
		}
		else
		{
			//TODO sendKeyToMCU
		}
	}
	
	//����ǰ/��
	private void procPreLong(){
		LOG("procPreLong");
		mRadio.selListItemFreq(-1);
		mAdapter.setItemSel(-1);
		T.mStepMode = true;
		mHandler.postDelayed(mDecreaseRunnable, T.STEP_MODE_DIFF);
	}
	
	//��/��
	private void procNext(){
		
	}
	
	//������/��
	private void procNextLong(){
		
	}
	
 	private boolean isCurBandFM() {
		return T.RadioValue.mBand <= T.FM_3;
	}

	//����LOC
	private void toggleLOC()
	{
		if (isCurBandFM())
		{
			
			T.RadioValue.mLoc = !T.RadioValue.mLoc;
			setLocImg();
		}
	}
	
	//ˢ��UI
	private void RefreshView()
	{
		UiDisplayTvCurFreq();
		setBandImg();
		setSeekBarBackground();
		setUnitImg();
		setLocImg();
		setSTImg();
		setOOImg();
		setLocButton();
		UiDisplayBtnMute();
		refleshListView();
	}

	

	//�����б�
	private void refleshListView() {
		mListData = mRadio.getFreqList();
		if (mAdapter == null) {
			mFreqList = (ListView) findViewById(R.id.freq_listView);
			mAdapter = new MyAdapter(this, mListData);
			mAdapter.setItemSel(mRadio.getListSelItem());
			mFreqList.setAdapter(mAdapter);
			mFreqList.setOnItemClickListener(mItemClickListener);
			mFreqList.setOnItemLongClickListener(mItemLongClickListener);
		} else {
			mAdapter.OnDataChange(mListData);
		}
	}
	private void setSeekBarValue() {
		mFreqSeekBar.setProgress(mRadio.getCurFreq() - mRadio.getMinFreq());
	}
	
	//��SeekBar����
	private void setSeekBarBackground() {
		mFreqSeekBar.setMax(mRadio.getSeekbarMax());
		if (isCurBandFM())
		{
			mFreqSeekBar.setProgressDrawable(getResources().getDrawable(R.drawable.seekbar_fm_horizontal));
		}
		else
		{
			mFreqSeekBar.setProgressDrawable(getResources().getDrawable(R.drawable.seekbar_am_horizontal));
		}
	}

	//�赱ǰƵ��
	private void UiDisplayTvCurFreq()
	{
		mCurFreq_tv.setText(mRadio.getDisplayFreq(mRadio.getCurFreq()));
		File file = new File("/ResidentFlash/ZuiLauncher/data/fonts/digital-7-italic.ttf");
		if (file.exists())
		{
			LOG("file exists");
			Typeface typeface = Typeface.createFromFile(file);
			mCurFreq_tv.setTypeface(typeface);
		}
		else
		{
			LOG("file not exists");
		}
		setSeekBarValue();
	}
	
	//����ͼƬ
	private void setBandImg()
	{
		if (isCurBandFM())
		{
			mBand_img.setBackgroundResource(R.drawable.fm);
		}
		else
		{
			mBand_img.setBackgroundResource(R.drawable.am);
		}
	}
	
	//��λͼƬ
	private void setUnitImg()
	{
		if (isCurBandFM())
		{
			mUnit_img.setBackgroundResource(R.drawable.mhz);
		}
		else
		{
			mUnit_img.setBackgroundResource(R.drawable.khz);
		}
	}
	
	//LOCͼƬ
	private void setLocImg()
	{
		if (isCurBandFM() && T.RadioValue.mLoc)
		{
			mLOC_img.setBackgroundResource(R.drawable.loc_sel);
		}
		else
		{
			mLOC_img.setBackgroundResource(R.drawable.loc_inval);
		}
	}
	
	//STͼƬ
	private void setSTImg()
	{
		if (isCurBandFM() && T.RadioValue.mST)
		{
			mST_img.setBackgroundResource(R.drawable.st_sel);
		}
		else
		{
			mST_img.setBackgroundResource(R.drawable.st_inval);
		}
	}
	
	//OOͼƬ
	private void setOOImg()
	{
		if (isCurBandFM() && T.RadioValue.mOO)
		{
			mOO_img.setBackgroundResource(R.drawable.oo_sel);
			mOO_img.setVisibility(View.VISIBLE);
		}
		else
		{
			mOO_img.setVisibility(View.INVISIBLE);
		}
	}
	
	//��Loc����
	private void setLocButton()
	{
		if (isCurBandFM())
		{
//			mLOC_bt.setEnabled(true);
			mLOC_bt.setClickable(true);
		}
		else
		{
//			mLOC_bt.setEnabled(false);
			mLOC_bt.setClickable(false);
		}
	}
	
	/**
	 * ��������
	 */
	private void UiDisplayBtnMute() {
		mMute_bt.setSelected(T.RadioValue.mMute);
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
//		LOG("fromUser�� " + fromUser);
		if (fromUser)
		{
			int freq = mRadio.getMinFreq() + progress;
			if (Math.abs(freq - mRadio.getCurFreq()) >= mRadio.getFreqStep())
			{
				mRadio.setCurFreq(freq/mRadio.getFreqStep()*mRadio.getFreqStep());
				UiDisplayTvCurFreq();
				mRadio.selListItemFreq(-1);
				mAdapter.setItemSel(-1);
				//TODO ����Ƶ��
//				LOG("��ǰƵ��Ϊ�� " + mRadio.getCurFreq());
			}
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		
	}

	
	
}

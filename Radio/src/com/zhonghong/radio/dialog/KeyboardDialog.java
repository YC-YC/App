package com.zhonghong.radio.dialog;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.zhonghong.radio.R;
import com.zhonghong.radio.area.AreaProcKey;
import com.zhonghong.radio.area.ChinaProcKey;
import com.zhonghong.radio.utils.RadioInterface;
import com.zhonghong.radio.utils.T;

/**
 * @author YC
 * @time 2016-2-25 下午8:21:20
 */
public class KeyboardDialog extends Dialog implements android.view.View.OnClickListener, OnLongClickListener{

	private static final int BIT0 = 0x0001<<0;
	private static final int BIT1 = 0x0001<<1;
	private static final int BIT2 = 0x0001<<2;
	private static final int BIT3 = 0x0001<<3;
	private static final int BIT4 = 0x0001<<4;
	private static final int BIT5 = 0x0001<<5;
	private static final int BIT6 = 0x0001<<6;
	private static final int BIT7 = 0x0001<<7;
	private static final int BIT8 = 0x0001<<8;
	private static final int BIT9 = 0x0001<<9;
	private static final int BIT_DEL = 0x0001<<10;
	private static final int BIT_CANCLE = 0x0001<<11;
	private static final int BIT_CONFIRM = 0x0001<<12;
	
	
	
	
	private Button mKeyboard_0, mKeyboard_1, mKeyboard_2, 
				   mKeyboard_3, mKeyboard_4, mKeyboard_5, 
				   mKeyboard_6, mKeyboard_7, mKeyboard_8,
				   mKeyboard_9, mKeyboard_del, mKeyboard_cancle, mKeyboard_confirm;
	
	private Button keyboards[] = {
			   mKeyboard_0, mKeyboard_1, mKeyboard_2, 
			   mKeyboard_3, mKeyboard_4, mKeyboard_5, 
			   mKeyboard_6, mKeyboard_7, mKeyboard_8,
			   mKeyboard_9, mKeyboard_del, mKeyboard_cancle, mKeyboard_confirm};
	private int keyboards_ID[] = {
			R.id.keyboard_0, R.id.keyboard_1, R.id.keyboard_2, 
			R.id.keyboard_3, R.id.keyboard_4, R.id.keyboard_5, 
			R.id.keyboard_6, R.id.keyboard_7, R.id.keyboard_8,
			R.id.keyboard_9, R.id.keyboard_del, R.id.keyboard_cancle, R.id.keyboard_confirm};
	private int keyboards_MASK[] = {
			BIT0, BIT1, BIT2, 
			BIT3, BIT4, BIT5, 
			BIT6, BIT7, BIT8,
			BIT9, BIT_DEL, BIT_CANCLE, BIT_CONFIRM};
	
	
	private TextView mInputFreq;
	
	private int mFreq = 0;
	private int keyCode = 0xffff;
	private RadioInterface mRadio;
	private AreaProcKey mAreaProcKey;
	/**
	 * @param context
	 */
	public KeyboardDialog(Context context, RadioInterface radio) {
		super(context,R.style.KeyboardDialog);
		this.mRadio = radio;
		mAreaProcKey = new ChinaProcKey();
		keyCode = getDefalutKeyCode();
		LOG("getDefalutKeyCode = " + keyCode);
		setCustomView();
	}

	
	/**
	 * @return
	 */
	private int getDefalutKeyCode() {
		int result = 0;
		if (mRadio.isFM())
		{
			result = T.KEYBOARD_EFFECTIVE_189;
		}
		else
		{
			result = T.KEYBOARD_EFFECTIVE_15_9;
		}
		if (mFreq > 0)
		{
			result |= T.KEYBOARD_EFFECTIVE_DEL;
		}
		else
		{
			result &= ~T.KEYBOARD_EFFECTIVE_DEL;
		}
		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		result &= ~T.KEYBOARD_EFFECTIVE_OK;
		return result;
	}

	/**
	 * 自定义界面
	 */
	private void setCustomView() {

		 View v = LayoutInflater.from(getContext()).inflate(R.layout.keyboare_dialog, null);
		
		 for (int i = 0; i < keyboards.length; i++)
		 {
			 keyboards[i] = (Button) v.findViewById(keyboards_ID[i]);
			 keyboards[i].setOnClickListener(this);
		 }
		 ((Button) v.findViewById(R.id.keyboard_del)).setOnLongClickListener(this);
		 mInputFreq = (TextView) v.findViewById(R.id.inputfreq);
		 super.setContentView(v);
		 
		 refreshAllView();
	}
	
	


	/**
	 * 刷新UI部件
	 */
	private void refreshAllView() {
		
		UiDisplayTVInputFreq(mFreq, mRadio.isFM());
		
		 for (int i = 0; i < keyboards.length; i++)
		 {
			if ((keyCode & keyboards_MASK[i]) > 0) {
				keyboards[i].setEnabled(true);
			} else {
				keyboards[i].setEnabled(false);
			}
		}
	}


	private void UiDisplayTVInputFreq(int freq, boolean bFM) {
		if (freq > 0)
		{
			if (bFM)
			{
				if (freq >= 87 && freq <= 108)
				{
					mInputFreq.setText(freq + ".");
				}
				else if (freq >= 875)
				{
					mInputFreq.setText(freq/10 + "." + freq%10);
				}
				else
				{
					mInputFreq.setText("" + freq);
				}
			}
			else
			{
				mInputFreq.setText("" + freq);
			}
		}
		else
		{
			mInputFreq.setText("");
		}
	}




	private OnClickCancleListener mCancleListener;
	public void setOnClickCancleListener(OnClickCancleListener cancleListener)
	{
		mCancleListener = cancleListener;
	}
	public interface OnClickCancleListener
	{
		void onCancle(Dialog dialog);
	}
	
	private OnClickConfirmListener mConfirmListener;
	public void setOnClickConfirmListener(OnClickConfirmListener confirmListener)
	{
		mConfirmListener = confirmListener;
	}
	public interface OnClickConfirmListener
	{
		void onConfirm(Dialog dialog, int freq);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.keyboard_0:
			mFreq *= 10;
			keyCode = mAreaProcKey.ProcKey_0(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_1:
			mFreq = mFreq*10 + 1;
			keyCode = mAreaProcKey.ProcKey_1(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_2:
			mFreq = mFreq*10 + 2;
			keyCode = mAreaProcKey.ProcKey_2(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_3:
			mFreq = mFreq*10 + 3;
			keyCode = mAreaProcKey.ProcKey_3(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_4:
			mFreq = mFreq*10 + 4;
			keyCode = mAreaProcKey.ProcKey_4(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_5:
			mFreq = mFreq*10 + 5;
			keyCode = mAreaProcKey.ProcKey_5(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_6:
			mFreq = mFreq*10 + 6;
			keyCode = mAreaProcKey.ProcKey_6(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_7:
			mFreq = mFreq*10 + 7;
			keyCode = mAreaProcKey.ProcKey_7(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_8:
			mFreq = mFreq*10 + 8;
			keyCode = mAreaProcKey.ProcKey_8(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_9:
			mFreq = mFreq*10 + 9;
			keyCode = mAreaProcKey.ProcKey_9(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_del:
			if (mFreq > 0)
			{
				mFreq = mFreq/10;
			}
			keyCode = mAreaProcKey.ProcKey_del(mFreq, mRadio.isFM());
			break;
		case R.id.keyboard_cancle:
			if (mCancleListener != null)
			{
				mCancleListener.onCancle(this);
			}
			break;
		case R.id.keyboard_confirm:
			mFreq = mAreaProcKey.ProcKey_confirm(mFreq, mRadio.isFM());
			if (mConfirmListener != null)
			{
				mConfirmListener.onConfirm(this, mFreq);
			}
			break;
		}
		if (mRadio.isFM())
		{
			if (mFreq > 0)
			{
				keyCode	|= T.KEYBOARD_EFFECTIVE_OK;	
			}
		}
		else
		{
			if (mFreq >= 522)
			{
				keyCode	|= T.KEYBOARD_EFFECTIVE_OK;	
			}
		}
		if (mFreq > 0)
		{
			keyCode	|= T.KEYBOARD_EFFECTIVE_DEL;
		}
		keyCode	|= T.KEYBOARD_EFFECTIVE_CANCLE;
		refreshAllView();
	}

	@Override
	public boolean onLongClick(View v) {
		switch (v.getId()) {
		case R.id.keyboard_del:
			mFreq = 0;
			keyCode = mAreaProcKey.ProcKey_del_all(mFreq, mRadio.isFM());
		}
		refreshAllView();
		return true;
	}
	
	private void LOG(String string)
	{
		Log.i("KeyboardDialog", string);
	}



	
}

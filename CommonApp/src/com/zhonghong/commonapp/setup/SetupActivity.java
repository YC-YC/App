package com.zhonghong.commonapp.setup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhonghong.commonapp.CommonAppHelper;
import com.zhonghong.commonapp.R;
import com.zhonghong.commonapp.utils.T;

public class SetupActivity extends Activity implements OnClickListener{

	private RelativeLayout mSelectcommontime;
	private TextView tv_Commontime;
	
	private long mCommonTime; 
	
	private String[] sel_list = {"1小时", "1天", "10天", "1个月"};
	private long[] sel_time = {T.Time.HOUR, T.Time.DAY, 10*T.Time.DAY, T.Time.MONTH};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.setup);
		if (T.mCommonAppHelper == null)
		{
			new CommonAppHelper(this);
		}
		initView();
	}

	private void initView() {
		mSelectcommontime = (RelativeLayout) findViewById(R.id.selectcommontime);
		mSelectcommontime.setOnClickListener(this);
		
		tv_Commontime = (TextView) findViewById(R.id.tv_commontime);
		tv_Commontime.setText(getCommonTime());
	}

	private String getCommonTime() {
		mCommonTime = T.mCommonAppHelper.getCommonAppTime();
		for (int i = 0; i < sel_time.length; i++)
		{
			if (mCommonTime == sel_time[i])
			{
				return sel_list[i];
			}
		}
		return null;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.selectcommontime:
				showSelDialog();
			break;
		}
	}
	
	private void showSelDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("多选按键对话框");
		getCheckItem();
		builder.setSingleChoiceItems(sel_list, getCheckItem(),
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
							T.mCommonAppHelper.setCommonAppTime(sel_time[which]);
							tv_Commontime.setText(getCommonTime());
						dialog.dismiss();
					}
				});
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	private int getCheckItem() {
		for (int i = 0; i < sel_time.length; i++)
		{
			if (sel_time[i] == mCommonTime)
			{
				return i;
			}
		}
		return 0;
	}
}

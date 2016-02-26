package com.zhonghong.radio.list;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhonghong.radio.R;

public class MyAdapter extends BaseAdapter {

	private Context mContext;
	private List<String> mListData;
	private LayoutInflater mInflater;
	private int mSelItem = -1;
	public MyAdapter(Context context, List<String> ListData) {
		this.mContext = context;
		this.mListData = ListData;
		mInflater = LayoutInflater.from(mContext);
	}
	
	//更新数据
	public void OnDataChange(List<String> list){
		this.mListData = list;
		this.notifyDataSetChanged();
	}
	
	//设置选中
	public void setItemSel(int selItem)
	{
		if (mSelItem != selItem)
		{
			mSelItem = selItem;
			this.notifyDataSetChanged();
		}
	}
	
	@Override
	public int getCount() {
		return mListData.size();
	}

	@Override
	public Object getItem(int position) {
		return mListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		String freq= mListData.get(position);
		ViewHolder holder = null;
		
		if (convertView == null){
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.freq_list_item, null);
			holder.freq = (TextView) convertView.findViewById(R.id.list_freq);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.freq.setText(freq);
		File file = new File("/ResidentFlash/ZuiLauncher/data/fonts/digital-7-italic.ttf");
		if (file.exists())
		{
			Typeface typeface = Typeface.createFromFile(file);
			holder.freq.setTypeface(typeface);
		}
		//列表文字选中状态
		if (mSelItem == position)
		{
			holder.freq.setTextColor(mContext.getResources().getColor(R.color.item_sel));
		}
		else
		{
			holder.freq.setTextColor(mContext.getResources().getColor(R.color.item_normal));
		}
		//列表选中状态
		if (mSelItem == position)
		{
			convertView.setBackgroundResource(R.drawable.freq_list_item_press);
		}
		else
		{
			convertView.setBackgroundResource(R.drawable.freq_list_item_normal);
		}
		return convertView;
	}
	
	class ViewHolder{
		TextView freq;
	}

}

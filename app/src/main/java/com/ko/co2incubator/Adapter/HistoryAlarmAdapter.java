package com.ko.co2incubator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ko.co2incubator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lxm
 * @version 2019/6/12-16:10
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class HistoryAlarmAdapter extends BaseAdapter {

	private Context mContext;
	private String[] mDatas;

	public HistoryAlarmAdapter(Context context, String[] datas) {
		this.mContext = context;
		this.mDatas = datas;
	}

	@Override
	public int getCount() {
		return mDatas.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder ;
		if (convertView == null) {

			mHolder = new ViewHolder(  );
			LayoutInflater inflater = LayoutInflater.from( mContext );
			convertView = inflater.inflate( R.layout.lv_co2_history_alarm_data_layout, null, true );
			convertView.setTag( mHolder );
		} else {
			mHolder = (ViewHolder) convertView.getTag( );
		}



		return convertView;
	}


	static class ViewHolder {
		@BindView(R.id.co2_lv)
		TextView mCo2Lv;
		@BindView(R.id.co2_alarm_time)
		TextView mCo2AlarmTime;
		@BindView(R.id.co2_alarm_time_hour)
		TextView mCo2AlarmTimeHour;

		ViewHolder(View view) {
			ButterKnife.bind( this, view );
		}

		public ViewHolder() {

		}
	}
}

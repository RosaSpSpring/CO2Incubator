package com.ko.co2incubator.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ko.co2incubator.R;
import com.ko.co2incubator.bean.CO2AlarmBean;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.List;

import static com.ko.co2incubator.fragments.EnvironmentParamFragment.TAG;

/**
 * @author lxm
 * @version 2019/6/12-16:10
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class HistoryAlarmAdapter extends BaseAdapter {

	private Context mContext;
	private List<CO2AlarmBean.ResultsBean> mDatas;
	private LayoutInflater mLayoutInflater;

	public HistoryAlarmAdapter(Context context, List<CO2AlarmBean.ResultsBean> co2_alarm) {
		this.mContext = context;
		mLayoutInflater = LayoutInflater.from( context );
		this.mDatas = co2_alarm;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return mDatas.get( position );
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder;
		mHolder = null;
		if (convertView == null) {
			LayoutInflater inflater = LayoutInflater.from( mContext );
			convertView = inflater.inflate( R.layout.lv_co2_history_alarm_data_layout, parent, false );
			mHolder = new ViewHolder();
			convertView.setTag( mHolder );
			mHolder.mCo2Lv = convertView.findViewById( R.id.co2_lv );
			mHolder.mCo2AlarmTime = convertView.findViewById( R.id.co2_alarm_time );

		} else {
			mHolder = (ViewHolder) convertView.getTag();
		}
		CO2AlarmBean.ResultsBean resultsBean = mDatas.get( position );
		Log.e(TAG, "CO2的值》》》》》》》》》》》》》》》》》》》》" + resultsBean.getCo2());
		mHolder.mCo2Lv.setText( resultsBean.getCo2() );
		mHolder.mCo2AlarmTime.setText( resultsBean.getDate() );

		return convertView;
	}


	static class ViewHolder {
		@BindView(R.id.co2_lv)
		TextView mCo2Lv;
		@BindView(R.id.co2_alarm_time)
		TextView mCo2AlarmTime;

		ViewHolder(View view) {
			ButterKnife.bind( this, view );
		}

		public ViewHolder() {

		}
	}
}

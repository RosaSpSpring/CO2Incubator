package com.ko.co2incubator.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ko.co2incubator.R;
import com.ko.co2incubator.bean.AlarmBean;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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
	private List<AlarmBean.DataBean> mDatas;
	private LayoutInflater mLayoutInflater;

	public HistoryAlarmAdapter(Context context, List<AlarmBean.DataBean> alarm) {
		this.mContext = context;
		mLayoutInflater = LayoutInflater.from( context );
		this.mDatas = alarm;
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
			mHolder.mTypeTv = convertView.findViewById( R.id.type_tv );
			mHolder.mTypeTvData = convertView.findViewById( R.id.type_tv_data );

			mHolder.mAlarmTime = convertView.findViewById( R.id.alarm_time );

		} else {
			mHolder = (ViewHolder) convertView.getTag();
		}
		Collections.sort( mDatas );
		AlarmBean.DataBean resultsBean = mDatas.get( position );

//		mHolder.mTypeTv.setText( resultsBean.getW_type() );
		//CO₂
        if (resultsBean.getW_type().equals( "mainTemperatureAnomaly" )){

			mHolder.mTypeTv.setText( "主温" );
			if (resultsBean.getW_num() > 0){
				mHolder.mTypeTvData.setText( "超温" );
			}else{
				mHolder.mTypeTvData.setText( "欠温" );
			}
			mHolder.mAlarmTime.setText( resultsBean.getW_date() );
		}else if (resultsBean.getW_type().equals( "doorTemperatureAnomaly" )) {
			mHolder.mTypeTv.setText( "门温" );
			if (resultsBean.getW_num() > 0){
				mHolder.mTypeTvData.setText( "超温" );
			}else{
				mHolder.mTypeTvData.setText( "欠温" );
			}
			mHolder.mAlarmTime.setText( resultsBean.getW_date() );
		} else if (resultsBean.getW_type().equals( "abnormalConcentration" )){
			mHolder.mTypeTv.setText( "浓度" );
			if (resultsBean.getW_num() > 0){
				mHolder.mTypeTvData.setText( "超浓度" );
			}else{
				mHolder.mTypeTvData.setText( "欠浓度" );
			}
			mHolder.mAlarmTime.setText( resultsBean.getW_date() );
		}

		return convertView;
	}


	static class ViewHolder {
		@BindView(R.id.type_tv)
		TextView mTypeTv;
		@BindView(R.id.type_tv_data)
		TextView mTypeTvData;
		@BindView(R.id.alarm_time)
		TextView mAlarmTime;

		ViewHolder(View view) {
			ButterKnife.bind( this, view );
		}

		public ViewHolder() {

		}
	}
}

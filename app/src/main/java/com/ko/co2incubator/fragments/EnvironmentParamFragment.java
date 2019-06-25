package com.ko.co2incubator.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ko.co2incubator.Adapter.HistoryAlarmAdapter;
import com.ko.co2incubator.R;
import com.ko.co2incubator.base.BaseFragment;
import com.ko.co2incubator.bean.CO2AlarmBean;
import com.ko.co2incubator.netinterface.EvironmentAPI;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxm
 * @version 2019/6/11-15:10
 * @des ${当前环境frangmet}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class EnvironmentParamFragment extends BaseFragment {
	public static final String TAG = EnvironmentParamFragment.class.getSimpleName();
	private ListView mListView;
	private String[] data;
	public String base_url = "http://192.168.104.175:8080/";
	private TextView mTextView;

	@Override
	protected View initView() {
		Log.e( TAG, "环境参数页面初始化了" );
		View view = View.inflate( mContext, R.layout.fragment_environmentparam_layout, null );
		mListView = view.findViewById( R.id.lv_his_alarm );
		mTextView = view.findViewById( R.id.co2_set_point_2 );
		return view;
	}

	@Override
	protected void initData() {
		super.initData();
		Log.e( TAG, "环境参数页面初始化了" );
		//准备数据
		data = new String[]{"11", "22", "33", "44", "55", "66", "77", "88", "11", "22", "33", "44", "55", "66", "77", "88"};
		getCO2AlarmData( base_url );




	}

	private void getCO2AlarmData(String base_url) {

		Retrofit retrofit = new Retrofit.Builder().baseUrl( "http://192.168.104.175:8080").addConverterFactory( GsonConverterFactory.create() ).build();
		EvironmentAPI evironmentAPI = retrofit.create( EvironmentAPI.class );
		Call<CO2AlarmBean> call = evironmentAPI.getCo2AlarmInfo();
		call.enqueue( new Callback<CO2AlarmBean>() {
			@Override
			public void onResponse(Call<CO2AlarmBean> call, Response<CO2AlarmBean> response) {
				List<CO2AlarmBean.ResultsBean> results = response.body().getResults();
				mListView.setAdapter( new HistoryAlarmAdapter( mContext, results ) );


				//准备适配器
			}

			@Override
			public void onFailure(Call<CO2AlarmBean> call, Throwable t) {

			}
		} );

	}


}

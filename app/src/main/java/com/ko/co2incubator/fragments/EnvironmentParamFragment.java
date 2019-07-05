package com.ko.co2incubator.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ko.co2incubator.Adapter.HistoryAlarmAdapter;
import com.ko.co2incubator.R;
import com.ko.co2incubator.base.BaseFragment;
import com.ko.co2incubator.bean.CO2AlarmBean;
import com.ko.co2incubator.bean.CO2Cls;
import com.ko.co2incubator.bean.CO2SetBean;
import com.ko.co2incubator.bean.HumidityBean;
import com.ko.co2incubator.bean.TemperatureBean;
import com.ko.co2incubator.bean.TempratureSetBean;
import com.ko.co2incubator.constant.Constants;
import com.ko.co2incubator.netinterface.CO2;
import com.ko.co2incubator.netinterface.CO2SetIn;
import com.ko.co2incubator.netinterface.EvironmentAPI;
import com.ko.co2incubator.netinterface.Humidity;
import com.ko.co2incubator.netinterface.TemperatureIn;
import com.ko.co2incubator.netinterface.TempratureSetIn;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lxm
 * @version 2019/6/11-15:10
 * @des ${当前环境frangmet}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class EnvironmentParamFragment extends BaseFragment {
	public static final String TAG = EnvironmentParamFragment.class.getSimpleName();
	@BindView(R.id.title_text)
	TextView mTitleText;
	@BindView(R.id.temperature_set_point)
	TextView mTemperatureSetPoint;
	@BindView(R.id.humidity)
	TextView mHumidity;
	@BindView(R.id.temperature_set_point_2)
	TextView mTemperatureSetPoint2;
	@BindView(R.id.co2_set_point)
	TextView mCo2SetPoint;
	Unbinder unbinder;
	private ListView mListView;
	private String[] data;
	public String base_url = "http://192.168.104.175:8080/";
	private TextView mCo2SetPoint2;

	@Override
	protected View initView() {
		Log.e( TAG, "环境参数页面初始化了" );
		View view = View.inflate( mContext, R.layout.fragment_environmentparam_layout, null );
		mListView = view.findViewById( R.id.lv_his_alarm );
		mCo2SetPoint2 = view.findViewById( R.id.co2_set_point_2 );
		return view;
	}

	@Override
	protected void initData() {
		super.initData();
		Log.e( TAG, "环境参数页面初始化了" );
		//准备数据
		data = new String[]{"11", "22", "33", "44", "55", "66", "77", "88", "11", "22", "33", "44", "55", "66", "77", "88"};
				getCO2AlarmData( base_url );
		getCO2();
		getCO2Set();
		getHumanity();
		getTemprature();
		getTempratureSet();


	}

	private void getTempratureSet() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl( Constants.PARAMSRADIUS).addConverterFactory( GsonConverterFactory.create() ).build();
		TempratureSetIn tempratureSetIn = retrofit.create( TempratureSetIn.class );
		Call<TempratureSetBean> call = tempratureSetIn.getTemperatureSet();
		call.enqueue( new Callback<TempratureSetBean>() {
			@Override
			public void onResponse(Call<TempratureSetBean> call, Response<TempratureSetBean> response) {
				String data = response.body().getData();
				mTemperatureSetPoint.setText( data );
				Log.e(TAG, response.body().getMsg() + "data" + data);

			}

			@Override
			public void onFailure(Call<TempratureSetBean> call, Throwable t) {
				Log.e(TAG, "数据请求出错" );
			}
		} );
	}

	private void getTemprature() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl( Constants.PARAMSRADIUS).addConverterFactory( GsonConverterFactory.create() ).build();
		TemperatureIn temperatureIn = retrofit.create( TemperatureIn.class );
		Call<TemperatureBean> call = temperatureIn.getTemperature();
		call.enqueue( new Callback<TemperatureBean>() {
			@Override
			public void onResponse(Call<TemperatureBean> call, Response<TemperatureBean> response) {
				String data = response.body().getData();
				mTemperatureSetPoint2.setText( data );
				Log.e(TAG, response.body().getMsg() + "data" + data);

			}

			@Override
			public void onFailure(Call<TemperatureBean> call, Throwable t) {
				Log.e(TAG, "数据请求出错" );
			}
		} );
	}

	private void getHumanity() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl( Constants.PARAMSRADIUS).addConverterFactory( GsonConverterFactory.create() ).build();
		Humidity humidity = retrofit.create( Humidity.class );
		Call<HumidityBean> call = humidity.getHumidity();
		call.enqueue( new Callback<HumidityBean>() {
			@Override
			public void onResponse(Call<HumidityBean> call, Response<HumidityBean> response) {
				String data = response.body().getData();
				mHumidity.setText( data );
				Log.e(TAG, response.body().getMsg() + "data" + data);
			}
			@Override
			public void onFailure(Call<HumidityBean> call, Throwable t) {
				Log.e(TAG, "数据请求出错" );
			}
		} );
	}

	private void getCO2Set() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl( Constants.PARAMSRADIUS).addConverterFactory( GsonConverterFactory.create() ).build();
		CO2SetIn co2SetIn = retrofit.create( CO2SetIn.class );
		Call<CO2SetBean> call = co2SetIn.getCO2Set();
		call.enqueue( new Callback<CO2SetBean>() {
			@Override
			public void onResponse(Call<CO2SetBean> call, Response<CO2SetBean> response) {
				String data = response.body().getData();
				mCo2SetPoint.setText( data );
				Log.e(TAG, response.body().getMsg() + "data" + data);
			}
			@Override
			public void onFailure(Call<CO2SetBean> call, Throwable t) {
				Log.e(TAG, "数据请求出错" );
			}
		} );
	}

	private void getCO2() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl( Constants.PARAMSRADIUS).addConverterFactory( GsonConverterFactory.create() ).build();
		CO2 co2 = retrofit.create( CO2.class );
		Call<CO2Cls> call = co2.getCO2();
		call.enqueue( new Callback<CO2Cls>() {
			@Override
			public void onResponse(Call<CO2Cls> call, Response<CO2Cls> response) {
				String data = response.body().getData();
				Log.e(TAG, "data" + data);
				mCo2SetPoint2.setText( data );
			}

			@Override
			public void onFailure(Call<CO2Cls> call, Throwable t) {
				Log.e(TAG, "数据请求出错" );
			}
		} );

	}

	private void getCO2AlarmData(String base_url) {

		Retrofit retrofit = new Retrofit.Builder().baseUrl( "http://192.168.104.155:8080/" ).addConverterFactory( GsonConverterFactory.create() ).build();
		EvironmentAPI evironmentAPI = retrofit.create( EvironmentAPI.class );
		Call<CO2AlarmBean> call = evironmentAPI.getCo2AlarmInfo();
		call.enqueue( new Callback<CO2AlarmBean>() {
			@Override
			public void onResponse(Call<CO2AlarmBean> call, Response<CO2AlarmBean> response) {
				List<CO2AlarmBean.ResultsBean> results = response.body().getResults();
				Log.e(TAG, "results" + results.get( 1 ).getCo2());
				mListView.setAdapter( new HistoryAlarmAdapter( mContext, results ) );


				//准备适配器
			}

			@Override
			public void onFailure(Call<CO2AlarmBean> call, Throwable t) {

			}
		} );

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO: inflate a fragment view
		View rootView = super.onCreateView( inflater, container, savedInstanceState );
		unbinder = ButterKnife.bind( this, rootView );
		return rootView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}

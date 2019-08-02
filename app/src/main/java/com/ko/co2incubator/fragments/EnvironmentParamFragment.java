package com.ko.co2incubator.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ko.co2incubator.Adapter.HistoryAlarmAdapter;
import com.ko.co2incubator.R;
import com.ko.co2incubator.Screen.ScreenAdapterUtils;
import com.ko.co2incubator.base.BaseFragment;
import com.ko.co2incubator.bean.AlarmBean;
import com.ko.co2incubator.bean.CO2Cls;
import com.ko.co2incubator.bean.CO2SetBean;
import com.ko.co2incubator.bean.HumidityBean;
import com.ko.co2incubator.bean.TemperatureBean;
import com.ko.co2incubator.bean.TempratureSetBean;
import com.ko.co2incubator.constant.Constants;
import com.ko.co2incubator.netinterface.AlarmIn;
import com.ko.co2incubator.netinterface.CO2;
import com.ko.co2incubator.netinterface.CO2SetIn;
import com.ko.co2incubator.netinterface.Humidity;
import com.ko.co2incubator.netinterface.TemperatureIn;
import com.ko.co2incubator.netinterface.TempratureSetIn;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
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
//	@BindView(R.id.temperature_set_point)
//	static TextView mTemperatureSetPoint;
//	@BindView(R.id.humidity)
//	static TextView mHumidity;
//	@BindView(R.id.temperature_set_point_2)
//	static TextView mTemperatureSetPoint2;
//	@BindView(R.id.co2_set_point)
//	static TextView mCo2SetPoint;
	private  TextView mTemperatureSetPoint;
	private  TextView mHumidity;
	private  TextView mTemperatureSetPoint2;
	private  TextView mCo2SetPoint;

	Unbinder unbinder;
	private ListView mListView;
	private  TextView mCo2SetPoint2;
	 Retrofit.Builder builder = new Retrofit.Builder();
//	private final MyHandler handler = new MyHandler( EnvironmentParamFragment.this );//在activity中声明handler
//
//	private static class MyHandler extends Handler {
//
//		private final WeakReference mFragmentReference;
//
//		MyHandler(Fragment fragment) {
//
//			this.mFragmentReference = new WeakReference<>( fragment );
//
//		}
//
//		@Override
//
//		public void handleMessage(Message msg) {
//
//			super.handleMessage( msg );
//
//			final EnvironmentParamFragment fragment = (EnvironmentParamFragment) mFragmentReference.get();
//
//			if (fragment != null) {
//
//				//获取消息，更新UI
//
//			}
//
//		}
//
//
//	}
//
//	private static final Runnable mRunnable = new Runnable() {
//		@Override
//		public void run() {
////			refreshUI();
//		}
//
//
//	};


	@Override
	protected View initView() {
		Log.e( TAG, "环境参数页面初始化了" );
		ScreenAdapterUtils.setCusomDensity( (Activity) mContext, Objects.requireNonNull( getActivity() ).getApplication() );
		View view = View.inflate( mContext, R.layout.fragment_environmentparam_layout, null );
		mListView = view.findViewById( R.id.lv_his_alarm );
		mCo2SetPoint2 = view.findViewById( R.id.co2_set_point_2 );
		mHumidity = view.findViewById( R.id.humidity );
		mTemperatureSetPoint2 = view.findViewById( R.id.temperature_set_point_2 );
		mTemperatureSetPoint = view.findViewById( R.id.temperature_set_point );
		mCo2SetPoint = view.findViewById( R.id.co2_set_point );


//		handler.postDelayed( mRunnable, 1000 );

//		handler.handleMessage( handler.obtainMessage() );



				@SuppressLint("HandlerLeak") Handler mhandler = new Handler(){
					   @Override
					   public void handleMessage(Message msg) {
						   super.handleMessage( msg );
						   refreshUI();
					   }
				   };

		            new Thread( () -> {
						while (true) {
							try {
								Thread.sleep( 2000 );
							mhandler.sendMessage( mhandler.obtainMessage() );
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} ).start();


		return view;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

//		handler.removeCallbacksAndMessages( mRunnable );
	}

	private  void refreshUI() {
		getCO2();
		getCO2Set();
		getHumanity();
		getTemprature();
		getTempratureSet();
		getAlarmData();
	}

	@Override
	protected void initData() {
		super.initData();
		Log.e( TAG, "环境参数页面初始化了" );
		//准备数据

	}

	private  void getTempratureSet() {
		Retrofit retrofit = builder.baseUrl( Constants.PARAMSRADIUS ).addConverterFactory( GsonConverterFactory.create() ).build();
		TempratureSetIn tempratureSetIn = retrofit.create( TempratureSetIn.class );
		Call<TempratureSetBean> call = tempratureSetIn.getTemperatureSet();
		call.enqueue( new Callback<TempratureSetBean>() {
			@Override
			public void onResponse(@NotNull Call<TempratureSetBean> call, @NotNull Response<TempratureSetBean> response) {
				String data = null;
				if (response.body() != null) {
					data = response.body().getData();
				}else{
					Toast.makeText(mContext,"温度数值请求失败", Toast.LENGTH_SHORT).show();
				}
				mTemperatureSetPoint.setText( data );
				assert response.body() != null;
				Log.e( TAG, response.body().getMsg() + "data" + data );

			}

			@Override
			public void onFailure(@NotNull Call<TempratureSetBean> call, @NotNull Throwable t) {
				Log.e( TAG, "数据请求出错" );
			}
		} );
	}

	private  void getTemprature() {
		Retrofit retrofit = builder.baseUrl( Constants.PARAMSRADIUS ).addConverterFactory( GsonConverterFactory.create() ).build();
		TemperatureIn temperatureIn = retrofit.create( TemperatureIn.class );
		Call<TemperatureBean> call = temperatureIn.getTemperature();
		call.enqueue( new Callback<TemperatureBean>() {
			@Override
			public void onResponse(@NotNull Call<TemperatureBean> call, @NotNull Response<TemperatureBean> response) {
				assert response.body() != null;
				String data = response.body().getData();
				mTemperatureSetPoint2.setText( data );
				Log.e( TAG, response.body().getMsg() + "data" + data );

			}

			@Override
			public void onFailure(@NotNull Call<TemperatureBean> call, @NotNull Throwable t) {
				Log.e( TAG, "数据请求出错" );
			}
		} );
	}

	private  void getHumanity() {
		Retrofit retrofit = builder.baseUrl( Constants.PARAMSRADIUS ).addConverterFactory( GsonConverterFactory.create() ).build();
		Humidity humidity = retrofit.create( Humidity.class );
		Call<HumidityBean> call = humidity.getHumidity();
		call.enqueue( new Callback<HumidityBean>() {
			@Override
			public void onResponse(@NotNull Call<HumidityBean> call, @NotNull Response<HumidityBean> response) {
				assert response.body() != null;
				String data = response.body().getData();
				mHumidity.setText( data );
				Log.e( TAG, response.body().getMsg() + "data" + data );
			}

			@Override
			public void onFailure(@NotNull Call<HumidityBean> call, @NotNull Throwable t) {
				Log.e( TAG, "数据请求出错" );
			}
		} );
	}

	private  void getCO2Set() {
		Retrofit retrofit = builder.baseUrl( Constants.PARAMSRADIUS ).addConverterFactory( GsonConverterFactory.create() ).build();
		CO2SetIn co2SetIn = retrofit.create( CO2SetIn.class );
		Call<CO2SetBean> call = co2SetIn.getCO2Set();
		call.enqueue( new Callback<CO2SetBean>() {
			@Override
			public void onResponse(@NotNull Call<CO2SetBean> call, @NotNull Response<CO2SetBean> response) {
				assert response.body() != null;
				String data = response.body().getData();
				mCo2SetPoint.setText( data );
				Log.e( TAG, response.body().getMsg() + "data" + data );
			}

			@Override
			public void onFailure(@NotNull Call<CO2SetBean> call, @NotNull Throwable t) {
				Log.e( TAG, "数据请求出错" );
			}
		} );
	}

	private  void getCO2() {
		Retrofit retrofit = builder.baseUrl( Constants.PARAMSRADIUS ).addConverterFactory( GsonConverterFactory.create() ).build();
		CO2 co2 = retrofit.create( CO2.class );
		Call<CO2Cls> call = co2.getCO2();

		call.enqueue( new Callback<CO2Cls>() {
			@Override
			public void onResponse(@NotNull Call<CO2Cls> call, @NotNull Response<CO2Cls> response) {
				assert response.body() != null;
				String data = response.body().getData();
				Log.e( TAG, "data" + data );
				mCo2SetPoint2.setText( data );
			}

			@Override
			public void onFailure(@NotNull Call<CO2Cls> call, @NotNull Throwable t) {
				Log.e( TAG, "数据请求出错" );
			}
		} );

	}

	private  void getAlarmData() {
		Retrofit retrofit = builder.baseUrl( Constants.BASEALARM ).addConverterFactory( GsonConverterFactory.create() ).build();
		//		EvironmentAPI evironmentAPI = retrofit.create( EvironmentAPI.class );
		//		Call<ResponseBody> call = evironmentAPI.getCo2AlarmInfo();
		AlarmIn alarmIn = retrofit.create( AlarmIn.class );
		Call<ResponseBody> call = alarmIn.getAlarmInfo();
		call.enqueue( new Callback<ResponseBody>() {
			@Override
			public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
				String result = null;
				try {
					assert response.body() != null;
					result = response.body().string();
					Log.e( TAG, "resp" + result );
					parseAlarmData( result );
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
				Log.e( TAG, "请求失败" );
			}
		} );
	}

	private void parseAlarmData(String result) {
		AlarmBean alarmBean = new AlarmBean();
		try {
			//第一层解析
			JSONObject jsonObject = new JSONObject( result );
			String msg = jsonObject.optString( "msg" );
			int code = jsonObject.optInt( "code" );
			JSONArray data = jsonObject.optJSONArray( "data" );
			//第一层封装
			alarmBean.setCode( code );
			alarmBean.setMsg( msg );
			List<AlarmBean.DataBean> databb = new ArrayList<>();
			alarmBean.setData( databb );
			//第二层解析
			for (int i = 0; i < data.length(); i++) {
				JSONObject jsonObject1 = data.optJSONObject( i );
				String w_type = jsonObject1.optString( "w_type" );
				String w_date = jsonObject1.optString( "w_date" );
				int w_id = jsonObject1.optInt( "w_id" );
				int w_num = jsonObject1.optInt( "w_num" );
				int mid = jsonObject1.optInt( "mid" );
				AlarmBean.DataBean dataBean = new AlarmBean.DataBean();
				//第二层封装
				dataBean.setMid( mid );
				dataBean.setW_date( w_date );
				dataBean.setW_id( w_id );
				dataBean.setW_num( w_num );
				dataBean.setW_type( w_type );
				databb.add( dataBean );

			}
			List<AlarmBean.DataBean> data1 = alarmBean.getData();
			HistoryAlarmAdapter historyAlarmAdapter = new HistoryAlarmAdapter( mContext, data1 );
			historyAlarmAdapter.notifyDataSetChanged();
			Log.e( TAG, "实时刷新adapter" );
			mListView.setAdapter( historyAlarmAdapter );

		} catch (JSONException e) {
			e.printStackTrace();
		}

	}


	@Override
	public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO: inflate a fragment view
		View rootView = super.onCreateView( inflater, container, savedInstanceState );
		unbinder = ButterKnife.bind( this, Objects.requireNonNull( rootView ) );
		return rootView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}

package com.ko.co2incubator.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.bruce.pickerview.popwindow.DatePickerPopWin;
import com.ko.co2incubator.R;
import com.ko.co2incubator.Screen.ScreenAdapterUtils;
import com.ko.co2incubator.bean.Cell;
import com.ko.co2incubator.bean.Result;
import com.ko.co2incubator.constant.Constants;
import com.ko.co2incubator.netinterface.HisDataSearchIn;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lxm
 * @version 2019/6/17-13:43
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class HistoryDataActivity extends Activity {
	public static final String TAG = HistoryDataActivity.class.getSimpleName();

	@BindView(R.id.iv_his_con_ser_back)
	ImageView mIvHisConSerBack;
	@BindView(R.id.his_title_text)
	TextView mHisTitleText;
	@BindView(R.id.et_his_input_pici)
	EditText mEtHisInputPici;
	@BindView(R.id.et_his_input_daici)
	EditText mEtHisInputDaici;
	@BindView(R.id.et_his_input_operator)
	EditText mEtHisInputOperator;
	@BindView(R.id.btn_his_input_start_date)
	Button mBtnHisInputStartDate;
	@BindView(R.id.btn_his_input_end_date)
	Button mBtnHisInputEndDate;
	@BindView(R.id.tv_his_reset)
	Button mTvHisReset;
	@BindView(R.id.tv_his_complete)
	Button mTvHisComplete;
	@BindView(R.id.tv_his_input_start_date)
	TextView mTvHisInputStartDate;
	@BindView(R.id.tv_his_input_end_date)
	TextView mTvHisInputEndDate;

	private String inputdaici;
	private String inputpihao;
	private String inputoperator;
	private String his_start_date;
	private String his_end_date;


	/**
	 * 历史数据gittest
	 *
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		ScreenAdapterUtils.setCusomDensity(this, getApplication());
		setContentView( R.layout.activity_history_data );
		ButterKnife.bind( this );

//点击返回上一界面
		mIvHisConSerBack.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				HistoryDataActivity.this.finish();
			}
		} );
	}

	@OnClick({R.id.tv_his_input_start_date, R.id.tv_his_input_end_date, R.id.tv_his_complete, R.id.tv_his_reset})
	public void onViewClicked(View view) {
		switch (view.getId()) {
			case R.id.tv_his_input_start_date:
				//添加日历控件
				if (mTvHisInputStartDate.getText().toString().trim().equals( "" )) {
					DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder( HistoryDataActivity.this, new DatePickerPopWin.OnDatePickedListener() {
						@Override
						public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
							mTvHisInputStartDate.setText( dateDesc );

						}
					} ).textConfirm( "确认" ) //text of confirm button
							.textCancel( "取消" ) //text of cancel button
							.btnTextSize( 16 ) // button text size
							.viewTextSize( 25 ) // pick view text size
							.colorCancel( Color.parseColor( "#999999" ) ) //color of cancel button
							.colorConfirm( Color.parseColor( "#303F9F" ) )//color of confirm button
							.minYear( 2018 ) //min year in loop
							.maxYear( 2550 ) // max year in loop
							.dateChose( "" ) // date chose when init popwindow
							.build();
					pickerPopWin.showPopWin( HistoryDataActivity.this );
				} else if (!mTvHisInputStartDate.getText().toString().trim().toLowerCase().equals( "" ) && mTvHisInputStartDate != null) {
					mBtnHisInputStartDate.setVisibility( View.VISIBLE );
					mBtnHisInputStartDate.setOnClickListener( new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							mTvHisInputStartDate.setText( "" );
							mBtnHisInputStartDate.setVisibility( View.GONE );
						}
					} );

				}

				break;
			case R.id.tv_his_input_end_date:
				//添加日历控件
				if (mTvHisInputEndDate.getText().toString().trim().equals( "" )) {
					DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder( HistoryDataActivity.this, new DatePickerPopWin.OnDatePickedListener() {
						@Override
						public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
							mTvHisInputEndDate.setText( dateDesc );

						}
					} ).textConfirm( "确认" ) //text of confirm button
							.textCancel( "取消" ) //text of cancel button
							.btnTextSize( 16 ) // button text size
							.viewTextSize( 25 ) // pick view text size
							.colorCancel( Color.parseColor( "#999999" ) ) //color of cancel button
							.colorConfirm( Color.parseColor( "#303F9F" ) )//color of confirm button
							.minYear( 2018 ) //min year in loop
							.maxYear( 2550 ) // max year in loop
							.dateChose( "" ) // date chose when init popwindow
							.build();
					pickerPopWin.showPopWin( HistoryDataActivity.this );
				} else if (!mTvHisInputEndDate.getText().toString().trim().toLowerCase().equals( "" ) && mTvHisInputEndDate != null) {
					mBtnHisInputEndDate.setVisibility( View.VISIBLE );
					mBtnHisInputEndDate.setOnClickListener( new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							mTvHisInputEndDate.setText( "" );
							mBtnHisInputEndDate.setVisibility( View.GONE );
						}
					} );

				}

				break;
				//重置按钮重置所有view
			case R.id.tv_his_reset:
				mEtHisInputPici.setText( "" );
				mEtHisInputDaici.setText( "" );
				mEtHisInputOperator.setText( "" );
				mTvHisInputStartDate.setText( "" );
				mTvHisInputEndDate.setText( "" );
				mBtnHisInputStartDate.setVisibility( View.INVISIBLE );
				mBtnHisInputEndDate.setVisibility( View.INVISIBLE );
				break;
				//完成按钮,开始联网请求数据
			case R.id.tv_his_complete:
				Log.e(TAG, "点击完成搞定");
                //之所以放在这里是当监听的时候,会发现文本是否变化才能得到确定的值
				inputdaici =  mEtHisInputDaici.getText().toString().trim();
				inputpihao =  mEtHisInputPici.getText().toString().trim();
				inputoperator =  mEtHisInputOperator.getText().toString().trim();
				his_start_date =  mTvHisInputStartDate.getText().toString().trim();
				his_end_date =  mTvHisInputEndDate.getText().toString().trim();
                //
				if (his_start_date == "" && his_end_date != ""){
					Toast.makeText(this,"请选择起始日期", Toast.LENGTH_SHORT).show();
				}else if (his_start_date != "" && his_end_date == ""){
					Toast.makeText(this,"请选择结束日期", Toast.LENGTH_SHORT).show();
				}else{
					dorequest();
				}

				break;
		}
	}

	private void dorequest() {
		Retrofit build = new Retrofit.Builder().baseUrl( Constants.BASEURL ).addConverterFactory( GsonConverterFactory.create() ).build();
		HisDataSearchIn hisDataSearchIn = build.create( HisDataSearchIn.class );
		Call<ResponseBody> call = hisDataSearchIn.getHisDataSearch(  inputpihao,inputdaici, inputoperator, his_start_date, his_end_date );
		call.enqueue( new Callback<ResponseBody>() {
			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				try {
					String json = response.body().string();
					Log.e(TAG, "jsonjsonjsonjson" + json);
					Log.e(TAG, "inputdaici" + inputdaici + "---------" + inputpihao + "-------------" + inputoperator + "---" + his_start_date + "-------" + his_end_date);
					initData(json);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				Log.e( TAG, "请求数据失败" );
			}
		} );

	}

	private void initData(String json) {
		Result res = JSON.parseObject( json, Result.class );
		Collections.sort( res.getData() );
		List<Cell> cells = new ArrayList<Cell>();
		for(Cell cell:res.getData()){
			if(cell.getCid().equalsIgnoreCase("0")){
				cells.add(cell);
				//                res.getData().remove(cell);
			}
		}
		for(Cell c :res.getData()){
			for(Cell root:cells){
				if(c.getCid().equalsIgnoreCase(root.getId())){
					root.getChildren().add(c);
					break;
				}
			}
		}
		if (cells.size() > 0) {
			Intent intent = new Intent(HistoryDataActivity.this,ShowHisDataActicity.class);
			intent.putExtra( "cells", (Serializable) cells );
			startActivity( intent);
		} else if (cells.size() == 0) {
			Toast.makeText( this, "您所检索的数据不存在,请选择适合的条件", Toast.LENGTH_SHORT ).show();
		} else {
			Toast.makeText( this, "请求数据错误", Toast.LENGTH_SHORT ).show();
		}


	}
}

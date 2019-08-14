package com.ko.co2incubator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.ko.co2incubator.R;
import com.ko.co2incubator.Screen.ScreenAdapterUtils;
import com.ko.co2incubator.bean.Cell;
import com.ko.co2incubator.bean.Result;
import com.ko.co2incubator.constant.Constants;
import com.ko.co2incubator.netinterface.CurDataSearchIn;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author lxm
 * @version 2019/6/15-14:19
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class ConditionalSearchActivity extends Activity {
	public static final String TAG = ConditionalSearchActivity.class.getSimpleName();
	@BindView(R.id.iv_con_ser_back)
	ImageView mIvConSerBack;
	@BindView(R.id.title_text)
	TextView mTitleText;
	@BindView(R.id.et_input_pici)
	EditText mEtInputPici;
	@BindView(R.id.et_input_daici)
	EditText mEtInputDaici;
	@BindView(R.id.tv_reset)
	Button mTvReset;
	@BindView(R.id.tv_complete)
	Button mTvComplete;
	@BindView(R.id.all_month)
	RadioButton mAllMonth;
	@BindView(R.id.one_month)
	RadioButton mOneMonth;
	@BindView(R.id.two_month)
	RadioButton mTwoMonth;
	@BindView(R.id.three_month)
	RadioButton mThreeMonth;
	@BindView(R.id.six_month)
	RadioButton mSixMonth;
	@BindView(R.id.rg1)
	RadioGroup mRg1;
	@BindView(R.id.rg2)
	RadioGroup mRg2;
	private int position;
	private String inputdaici;
	private String inputpici;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		ScreenAdapterUtils.setCusomDensity(this, getApplication());
		setContentView( R.layout.activity_conditonal_data );
		ButterKnife.bind( this );

		//实例化控件
		initView();
		//实例化数据
		initData();
		//调用接口
		initListener();
	}

	private void initListener() {
		//返回上一界面
		mIvConSerBack.setOnClickListener( v -> ConditionalSearchActivity.this.finish() );
	}

	private void initData() {

	}

	private void initView() {

		mRg1 = findViewById( R.id.rg1 );
		mRg2 = findViewById( R.id.rg2 );

		mRg1.clearCheck(); // this is so we can start fresh, with no selection on both RadioGroups
		mRg2.clearCheck();
		mRg1.setOnCheckedChangeListener( listener1 );
		mRg2.setOnCheckedChangeListener( listener2 );
		mRg1.check( R.id.all_month );

		int chkId1 = mRg1.getCheckedRadioButtonId();
		int chkId2 = mRg2.getCheckedRadioButtonId();
		int realCheck = chkId1 == -1 ? chkId2 : chkId1;
		//重置按钮,重置所有控件
		mTvReset.setOnClickListener( v -> {
			mEtInputPici.setText( "" );
			mEtInputDaici.setText( "" );
			mRg1.clearCheck(); // this is so we can start fresh, with no selection on both RadioGroups
			mRg2.clearCheck();

		} );

		//完成按钮,点击监听开始联网请求条件筛选数据
		mTvComplete.setOnClickListener( v -> {
			/*
			  文本放到这里是为了当监听触发的时候,会刷新文本,获取文本否则只是空字符串
			 */
			inputdaici= mEtInputDaici.getText().toString().trim();
			inputpici =  mEtInputPici.getText().toString().trim();
			Retrofit build = new Retrofit.Builder().baseUrl( Constants.BASEURL ).addConverterFactory( GsonConverterFactory.create() ).build();
			CurDataSearchIn curDataSearchIn = build.create( CurDataSearchIn.class );
			Call<ResponseBody> call = curDataSearchIn.getCurDataSearch( inputpici, inputdaici, position );
			call.enqueue( new Callback<ResponseBody>() {
				@Override
				public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
					try {
						String json = response.body().string();
						Log.e( TAG, "json" + json );
						Log.e( TAG, "inputpici" + inputpici + "---------inptdaici" + inputdaici + "-------------time" + position );
						initData( json );
					} catch (IOException e) {
						e.printStackTrace();
					}

				}

				@Override
				public void onFailure(Call<ResponseBody> call, Throwable t) {
					Log.e( TAG, "当前数据检索失败" );
				}
			} );

		} );


	}

	//解析条件检索数据
	private void initData(String json) {
		Result res = JSON.parseObject( json, Result.class );
		Collections.sort( res.getData() );
		List<Cell> cells = new ArrayList<>();
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
		//查看请求结果    如果没有数据(表明用户所输入的数据数据库内没有,或是用户所输入的条件有误)则提示用户重新选择合适条件再次查询
		if (cells.size() > 0) {
			Intent intent = new Intent( ConditionalSearchActivity.this, ShowCurrentDataActicity.class );
			intent.putExtra( "cells", (Serializable) cells );
			startActivity( intent );
		} else {
			Toast.makeText( this, "您所检索的数据不存在,请选择适合的条件", Toast.LENGTH_SHORT ).show();
		}

	}
//第一个ridiogroup包含全部月份,一月份,二月份选择
	private RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if (checkedId != -1) {
				mRg2.setOnCheckedChangeListener( null ); // remove the listener before clearing so we don't throw that stackoverflow exception(like Vladimir Volodin pointed out)
				mRg2.clearCheck(); // clear the second RadioGroup!
				mRg2.setOnCheckedChangeListener( listener2 ); //reset the listener
				Log.e( "XXX1", "do the work" );
			}
			switch (checkedId) {
				case R.id.all_month:
					position = 0;
					break;
				case R.id.one_month:
					position = 1;
					break;
				case R.id.two_month:
					position = 2;
					break;
				default:
					position = 0;
					break;
			}
		}
	};
//第二个rg 包含三月份和六月份
	private RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			if (checkedId != -1) {
				mRg1.setOnCheckedChangeListener( null );
				mRg1.clearCheck();
				mRg1.setOnCheckedChangeListener( listener1 );
				Log.e( "XXX2", "do the work" );

			}
			switch (checkedId) {
				case R.id.three_month:
					position = 3;
					break;
				case R.id.six_month:
					position = 6;
					break;
				default:
					break;
			}

		}
	};

}

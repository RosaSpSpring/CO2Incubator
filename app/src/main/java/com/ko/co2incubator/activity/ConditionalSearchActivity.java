package com.ko.co2incubator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ko.co2incubator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lxm
 * @version 2019/6/15-14:19
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class ConditionalSearchActivity extends Activity {
	@BindView(R.id.iv_con_ser_back)
	ImageView mIvConSerBack;
	@BindView(R.id.title_text)
	TextView mTitleText;
	@BindView(R.id.et_input_pici)
	EditText mEtInputPici;
	@BindView(R.id.et_input_daici)
	EditText mEtInputDaici;
	@BindView(R.id.all_month)
	TextView mAllMonth;
	@BindView(R.id.one_month)
	TextView mOneMonth;
	@BindView(R.id.two_month)
	TextView mTwoMonth;
	@BindView(R.id.three_month)
	TextView mThreeMonth;
	@BindView(R.id.six_month)
	TextView mSixMonth;
	@BindView(R.id.tv_reset)
	Button mTvReset;
	@BindView(R.id.tv_complete)
	Button mTvComplete;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
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
		mIvConSerBack.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ConditionalSearchActivity.this.finish();
			}
		} );

	}

	private void initData() {

	}

	private void initView() {

	}
}

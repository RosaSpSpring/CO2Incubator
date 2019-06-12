package com.ko.co2incubator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.ko.co2incubator.MainActivity;
import com.ko.co2incubator.R;

public class LaunchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_launch );
		new Handler(  ).postDelayed( new Runnable() {
			@Override
			public void run() {
				//此方法在主线程中运行
				startMainActivity();
			}
		} , 2000);

	}

	private void startMainActivity() {
		startActivity( new Intent( LaunchActivity.this, MainActivity.class ) );
		//关闭页面当点击返回键的时候此页面不会显示
		finish();

	}
}

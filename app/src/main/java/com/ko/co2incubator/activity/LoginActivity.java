package com.ko.co2incubator.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ko.co2incubator.MainActivity;
import com.ko.co2incubator.R;
import com.ko.co2incubator.Screen.ScreenAdapterUtils;

/**
 * @author lxm
 * @version 2019/6/18-12:45
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class LoginActivity extends Activity {
	public static final String TAG = LoginActivity.class.getSimpleName();
	private EditText mEditText;
	private Button mButton;
	private CheckBox mCheckBox;
	private SharedPreferences sharedPreferences;


	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		ScreenAdapterUtils.setCusomDensity(this, getApplication());
		requestWindowFeature( Window.FEATURE_NO_TITLE);
		//去掉Activity上面的状态栏
		getWindow().setFlags( WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
		setContentView( R.layout.activity_login );

		sharedPreferences  = PreferenceManager.getDefaultSharedPreferences( this );
		boolean isRemember = sharedPreferences.getBoolean( "isRemember",false );
		initView();
         if (isRemember){
         	//如果要记住的话就要报CheckBox设置成true
			 mCheckBox.setChecked( true );
			 //获取存储的密码值
			 String password1 = sharedPreferences.getString( "password" ,"");
			 Log.e(TAG, "password1" + password1 );
			 //将密码放到文本框
			 mEditText.setText( password1 );

		 }
         //监听判断复选框的状态
         mCheckBox.setOnCheckedChangeListener( (buttonView, isChecked) -> {
			 if (mCheckBox.isChecked()){
                  Log.e(TAG, "记住密码框未选中状态" );
                  sharedPreferences.edit().putBoolean( "isRemember",true ).apply();
			 }else {
                  Log.e(TAG, "记住密码框未选中");
                  sharedPreferences.edit().putBoolean( "isRemember",false ).apply();
			 }
		 } );

		mButton.setOnClickListener( v -> login() );
	}

	private void initView() {
		mEditText = findViewById( R.id.login_password );
		mButton = findViewById(R.id.btn_login);
		mCheckBox = findViewById(R.id.is_remember_pwd);
		mCheckBox.setTextColor( Color.GRAY );

	}

	private void login() {
		//密码
		String pwd = mEditText.getText().toString().trim();
		if (mCheckBox.isChecked()) {
		    SharedPreferences.Editor editor = sharedPreferences.edit();
		    editor.putString( "password",pwd );
		    Log.e(TAG, "mima" + pwd);
		    editor.apply();
		}
		loginCheck(pwd);

	}

	private void loginCheck(String pwd) {
		if ("".equals(pwd)) {
			Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show();
		}else {
			if ("keyone".equals( pwd )){
				startActivity( new Intent( LoginActivity.this, MainActivity.class ) );
				finish();
			}else{
				Toast.makeText(this,"密码错误", Toast.LENGTH_SHORT).show();
			}
		}
	}
}

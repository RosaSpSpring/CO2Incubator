package com.ko.co2incubator.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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
	private EditText mEditText;
	private Button mButton;

	@Override
	protected void onCreate( Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		ScreenAdapterUtils.setCusomDensity(this, getApplication());
		requestWindowFeature( Window.FEATURE_NO_TITLE);
		//去掉Activity上面的状态栏
		getWindow().setFlags( WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
		setContentView( R.layout.activity_login );
		mEditText = findViewById( R.id.login_password );
		mButton = findViewById(R.id.btn_login);
		mButton.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				login();
			}
		} );
	}

	private void login() {
		String pwd = mEditText.getText().toString().trim();
		if (pwd.equals( "" )) {

			Toast.makeText(this,"密码不能为空", Toast.LENGTH_SHORT).show();
		}else {
			if ("123" .equals( pwd )){
				startActivity( new Intent( LoginActivity.this, MainActivity.class ) );
				finish();
			}else{
				Toast.makeText(this,"密码错误", Toast.LENGTH_SHORT).show();
			}
		}
	}
}

package com.ko.co2incubator;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import cn.jpush.android.api.JPushInterface;

/**
 * @author lxm
 * @version 2019/6/18-10:01
 * @des ${代表整个软件 程序入口}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class CO2IncubatorApplication extends Application {
	/**
	 * 在所有组件被创建之前执行
	 */
	public Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		context = getApplicationContext();


		JPushInterface.setDebugMode( true );    // 设置开启日志,发布时请关闭日志
		JPushInterface.init( this ); // 初始化 JPush
	}
}

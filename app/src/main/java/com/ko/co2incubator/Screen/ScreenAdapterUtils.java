package com.ko.co2incubator.Screen;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * @author lxm
 * @version 2019/7/24-8:54
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class ScreenAdapterUtils {
	//三星pad宽度1280dp (是dp，是不px) ，SCREEN_WIDTH_DP根据不同的设计图修改，手机一般是360
	private final static int SCREEN_WEIDTH_DP = 428;
	private static float sNoncompatDensity;
	private static float sNoncompatScaleDensity;
	public static void setCusomDensity(final Activity activity, final Application application){
		final DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
		if (sNoncompatDensity == 0){
			sNoncompatDensity = appDisplayMetrics.density;
			sNoncompatScaleDensity = appDisplayMetrics.scaledDensity;
			//监听系统改变字体的大小
			application.registerComponentCallbacks(new ComponentCallbacks() {
				@Override
				public void onConfigurationChanged(Configuration newConfig) {
					if (newConfig !=null &&newConfig.fontScale>0){
						sNoncompatScaleDensity = application.getResources().getDisplayMetrics().scaledDensity;
						Log.e("tag","sNoncompatScaleDensity:"+sNoncompatScaleDensity);
					}
				}

				@Override
				public void onLowMemory() {

				}
			});
		}

		//根据参考的适配宽度 计算新的Density、ScaleDensity、DensityDpi
		float targetDensity = (float) appDisplayMetrics.widthPixels/SCREEN_WEIDTH_DP;
		float targetScaleDensity = (float)targetDensity*(sNoncompatScaleDensity/sNoncompatDensity);
		int targetDensityDpi = (int) (160*targetDensity);

		//修改全局的
		appDisplayMetrics.density = targetDensity;
		appDisplayMetrics.scaledDensity = targetScaleDensity;
		appDisplayMetrics.densityDpi = targetDensityDpi;

		//修改当前activity
		final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
		activityDisplayMetrics.density = targetDensity;
		activityDisplayMetrics.scaledDensity = targetScaleDensity;
		activityDisplayMetrics.densityDpi = targetDensityDpi;
	}
}

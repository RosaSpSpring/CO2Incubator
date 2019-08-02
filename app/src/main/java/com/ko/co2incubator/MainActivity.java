package com.ko.co2incubator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ko.co2incubator.Screen.ScreenAdapterUtils;
import com.ko.co2incubator.base.BaseFragment;
import com.ko.co2incubator.fragments.CurrentDataFragment;
import com.ko.co2incubator.fragments.EnvironmentParamFragment;
import com.ko.co2incubator.fragments.HistoryDataFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 主界面包括三个fragment页面
 */
public class MainActivity extends FragmentActivity {

	@BindView(R.id.rg_main)
	RadioGroup mRgMain;
	private ArrayList<BaseFragment> mBaseFragment;
	//选中的fragment对应的下标
	private int position;

	//上次切换的fragment
	private Fragment mFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		ScreenAdapterUtils.setCusomDensity(this, getApplication());
		initView();
		initFragment();
		//设置RadioGroup的监听
		setListener();

	}

	private void setListener() {
		mRgMain.setOnCheckedChangeListener( new MyCheckChangeListener() );
		mRgMain.check( R.id.rb_param_frame );
	}

	//初始化fragment
	private void initFragment() {
		mBaseFragment = new ArrayList<>();
		mBaseFragment.add( new EnvironmentParamFragment() );
		mBaseFragment.add( new CurrentDataFragment() );
		mBaseFragment.add( new HistoryDataFragment() );

	}

	/*
	  初始化view
	 */
	private void initView() {
		setContentView( R.layout.activity_main );
		ButterKnife.bind( this );

	}


	class MyCheckChangeListener implements RadioGroup.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			    case R.id.rb_param_frame :
			    	position = 0;
			        break;
			    case R.id.rb_curdata_frame :
					position = 1;
			        break;
			    case R.id.rb_hisdata_frame :
					position = 2;
			        break;
			    default:
			    	position = 0;
			        break;
			}
			//根据位置得到对应的fragment
			BaseFragment to = getFragment();
			//替换对应的fragment填充到帧布局中
			switchFragment(mFragment,to);
		}
	}

	/**
	 *
	 * @param from 刚显示的fragment,马上就要隐藏了
	 * @param to 马上要切换到的fragment,马上就要显示了
	 */
	private void switchFragment(Fragment from,Fragment to) {
		if (from != to){
			mFragment = to;
			//得到fragmentManager
			//开启事务
			FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
			//切换
			//判断有没有被添加
			if (!to.isAdded()){
				//to没有被添加
				//from隐藏
				if (from != null) {
					ft.hide( from );
				}
				//添加to显示to
				if (to != null) {
					ft.add( R.id.fl_content ,to).commit();
				}
			}else {
				//to已经被添加
				//隐藏from
				if (from != null){
					ft.hide( from );
				}

				//显示to
				if (to != null) {
					ft.show( to ).commit();
				}
			}
		}

	}

	//根据位置得到对应的fragment
	private BaseFragment getFragment() {
		BaseFragment fragment = mBaseFragment.get( position );
		return fragment;
	}




	//利用时间差实现双击回退键退出当前应用
	private long mExitTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exit();
			return false;
		} else {
			return super.onKeyDown( keyCode, event );
		}

	}

	public void exit() {
		if ((System.currentTimeMillis() - mExitTime) > 2000) {
			Toast.makeText( this, "再按一次退出程序", Toast.LENGTH_SHORT ).show();
			mExitTime = System.currentTimeMillis();
		} else {
			Intent intent = new Intent( Intent.ACTION_MAIN );
			intent.addCategory( Intent.CATEGORY_HOME );
			startActivity( intent );
			System.exit( 0 );
		}
	}
}

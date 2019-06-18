package com.ko.co2incubator.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ko.co2incubator.Adapter.HistoryAlarmAdapter;
import com.ko.co2incubator.R;
import com.ko.co2incubator.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lxm
 * @version 2019/6/11-15:10
 * @des ${当前环境frangmet}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class EnvironmentParamFragment extends BaseFragment {
	public static final String TAG = EnvironmentParamFragment.class.getSimpleName();
	private ListView mListView;
	private String[] data;

	@Override
	protected View initView() {
		Log.e(TAG, "环境参数页面初始化了");
		View view = View.inflate( mContext, R.layout.fragment_environmentparam_layout, null );
		mListView =  view.findViewById(R.id.lv_his_alarm);
		return view;
	}

	@Override
	protected void initData() {
		super.initData();
		Log.e(TAG, "环境参数页面初始化了" );
		//准备数据
		data = new String[]{"11","22","33","44","55","66","77","88","11","22","33","44","55","66","77","88"};


		//准备适配器
        mListView.setAdapter( new HistoryAlarmAdapter(mContext,data));

	}


}

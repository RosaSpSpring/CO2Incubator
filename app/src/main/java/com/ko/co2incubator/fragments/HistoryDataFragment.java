package com.ko.co2incubator.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ko.co2incubator.Adapter.MyHisDataAdapter;
import com.ko.co2incubator.R;
import com.ko.co2incubator.activity.HistoryDataActivity;
import com.ko.co2incubator.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author lxm
 * @version 2019/6/11-15:11
 * @des ${历史数据Fragment}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class HistoryDataFragment extends BaseFragment {
	public static final String TAG = HistoryDataFragment.class.getSimpleName();
	@BindView(R.id.title3_text)
	TextView mTitle3Text;
	@BindView(R.id.search_his)
	ImageView mSearchHis;
	@BindView(R.id.lv_cur_data)
	ListView mLvCurData;
	Unbinder unbinder;

	@Override
	protected View initView() {
		View view = View.inflate( mContext, R.layout.fragment_historydata_layout, null );
		mSearchHis = view.findViewById( R.id.search_his );
		mLvCurData = view.findViewById( R.id.lv_his_data );
		mSearchHis.setOnClickListener( new MyOnClickListener());
		Log.e( TAG, "历史数据页面初始化了" );
		return view;
	}

	@Override
	protected void initData() {
		super.initData();
//		mLvCurData.setAdapter(new MyHisDataAdapter());
	}


	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	private class MyOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			startActivity( new Intent( mContext, HistoryDataActivity.class));
		}
	}
}

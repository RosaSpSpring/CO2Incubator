package com.ko.co2incubator.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ko.co2incubator.R;
import com.ko.co2incubator.activity.ConditionalSearchActivity;
import com.ko.co2incubator.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author lxm
 * @version 2019/6/11-15:11
 * @des ${当前数据Fragment}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class CurrentDataFragment extends BaseFragment {
	public static final String TAG = CurrentDataFragment.class.getSimpleName();
	@BindView(R.id.title2_text)
	TextView mTitle2Text;
	@BindView(R.id.search_cur)
	ImageView mSearchCur;
	@BindView(R.id.lv_cur_data)
	ListView mLvCurData;
	Unbinder unbinder;

	@Override
	protected View initView() {
		View view = View.inflate( mContext, R.layout.fragment_currentdata_layout, null );
		ImageView mSear = view.findViewById( R.id.search_cur );
		//打开搜索当前数据的界面
		mSear.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity( new Intent( mContext,ConditionalSearchActivity.class ) );
			}
		} );
		return view;


	}

	@Override
	protected void initData() {
		super.initData();
	}



	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}


}

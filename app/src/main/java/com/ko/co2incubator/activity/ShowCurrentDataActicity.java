package com.ko.co2incubator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.ko.co2incubator.Adapter.MyExpandableViewListCurrentShowAdapter;
import com.ko.co2incubator.R;
import com.ko.co2incubator.Screen.ScreenAdapterUtils;
import com.ko.co2incubator.bean.Cell;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lxm
 * @version 2019/7/23-13:52
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class ShowCurrentDataActicity extends Activity {

	public static final String TAG = ShowHisDataActicity.class.getSimpleName();
	@BindView(R.id.iv_con_ser_back_show)
	ImageView mIvConSerBackShow;
	@BindView(R.id.myexpandablelv_current_search)
	ExpandableListView mMyexpandablelvCurrentSearch;
	@BindView(R.id.refreshLayout_cur_search)
	SmartRefreshLayout mRefreshLayoutCurSearch;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		ScreenAdapterUtils.setCusomDensity( this, getApplication() );
		setContentView( R.layout.activity_show_current_data );
		ButterKnife.bind( this );
		mIvConSerBackShow = findViewById( R.id.iv_con_ser_back_show );
		mMyexpandablelvCurrentSearch = findViewById( R.id.myexpandablelv_current_search );
		mRefreshLayoutCurSearch = findViewById(R.id.refreshLayout_cur_search);
		initListener();
		Bundle bundle = getIntent().getExtras();
		ArrayList<Cell> cells = (ArrayList<Cell>) bundle.getSerializable( "cells" );
		Log.e( TAG, "cellssssssssssss" + cells.toString() );
		mMyexpandablelvCurrentSearch.setAdapter( new MyExpandableViewListCurrentShowAdapter( ShowCurrentDataActicity.this, cells ) );
		//设置 Header 为 贝塞尔雷达 样式
		mRefreshLayoutCurSearch.setRefreshHeader( new ClassicsHeader( ShowCurrentDataActicity.this ).setEnableLastTime( true ) );
		//设置 Footer 为 球脉冲 样式
		mRefreshLayoutCurSearch.setRefreshFooter( new ClassicsFooter(ShowCurrentDataActicity.this  ).setSpinnerStyle( SpinnerStyle.Scale ) );

		//下拉刷新
		mRefreshLayoutCurSearch.setOnRefreshListener( new OnRefreshListener() {
			@Override
			public void onRefresh(RefreshLayout refreshlayout) {
				Bundle bundle = getIntent().getExtras();
				ArrayList<Cell> cells = (ArrayList<Cell>) bundle.getSerializable( "cells" );
				refreshlayout.finishRefresh( 2000/*,false*/ );//传入false表示刷新失败
				mMyexpandablelvCurrentSearch.setAdapter( new MyExpandableViewListCurrentShowAdapter( ShowCurrentDataActicity.this, cells ) );
			}
		} );
		mRefreshLayoutCurSearch.setOnLoadMoreListener( new OnLoadMoreListener() {
			@Override
			public void onLoadMore(RefreshLayout refreshlayout) {
				refreshlayout.finishLoadMore( 2000/*,false*/ );//传入false表示加载失败
			}
		} );



	}

	private void initListener() {
		mIvConSerBackShow.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ShowCurrentDataActicity.this.finish();
			}
		} );
	}
}

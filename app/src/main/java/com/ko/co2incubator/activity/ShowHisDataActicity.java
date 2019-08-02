package com.ko.co2incubator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.ko.co2incubator.Adapter.MyExpandableViewListCurrentShowAdapter;
import com.ko.co2incubator.Adapter.MyExpandableViewListHistoryShowAdapter;
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
 * @version 2019/7/22-17:14
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class ShowHisDataActicity extends Activity {

	public static final String TAG = ShowHisDataActicity.class.getSimpleName();
	@BindView(R.id.expand_lv_history_show)
	ExpandableListView mExpandLvHistoryShow;
	@BindView(R.id.iv_his_ser_back_show)
	ImageView mIvHisSerBackShow;
	@BindView(R.id.refreshLayout_his_search)
	SmartRefreshLayout mRefreshLayoutHisSearch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		ScreenAdapterUtils.setCusomDensity( this, getApplication() );
		setContentView( R.layout.activity_show_his_data );
		mExpandLvHistoryShow = findViewById( R.id.expand_lv_history_show );
		mIvHisSerBackShow = findViewById( R.id.iv_his_ser_back_show );
		mRefreshLayoutHisSearch =findViewById(R.id.refreshLayout_his_search);
		ButterKnife.bind( this );


		mIvHisSerBackShow.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ShowHisDataActicity.this.finish();
			}
		} );

		Bundle bundle = getIntent().getExtras();
		ArrayList<Cell> cells = (ArrayList<Cell>) bundle.getSerializable( "cells" );
		Log.e( TAG, "cells" + cells.toString() );
		mExpandLvHistoryShow.setAdapter( new MyExpandableViewListHistoryShowAdapter( ShowHisDataActicity.this, cells ) );
		//设置 Header 为 贝塞尔雷达 样式
		mRefreshLayoutHisSearch.setRefreshHeader( new ClassicsHeader( ShowHisDataActicity.this ).setEnableLastTime( true ) );
		//设置 Footer 为 球脉冲 样式
		mRefreshLayoutHisSearch.setRefreshFooter( new ClassicsFooter(ShowHisDataActicity.this  ).setSpinnerStyle( SpinnerStyle.Scale ) );

		//下拉刷新
		mRefreshLayoutHisSearch.setOnRefreshListener( new OnRefreshListener() {
			@Override
			public void onRefresh(RefreshLayout refreshlayout) {
				Bundle bundle = getIntent().getExtras();
				ArrayList<Cell> cells = (ArrayList<Cell>) bundle.getSerializable( "cells" );
				refreshlayout.finishRefresh( 2000/*,false*/ );//传入false表示刷新失败
				mExpandLvHistoryShow.setAdapter( new MyExpandableViewListHistoryShowAdapter( ShowHisDataActicity.this, cells ) );
			}
		} );
		mRefreshLayoutHisSearch.setEnableLoadMore( false );
		mRefreshLayoutHisSearch.setOnLoadMoreListener( new OnLoadMoreListener() {
			@Override
			public void onLoadMore(RefreshLayout refreshlayout) {
				refreshlayout.finishLoadMore( 2000/*,false*/ );//传入false表示加载失败
			}
		} );

	}
}

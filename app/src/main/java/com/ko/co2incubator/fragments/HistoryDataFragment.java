package com.ko.co2incubator.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.ko.co2incubator.Adapter.MyExpandableViewListHistoryAdapter;
import com.ko.co2incubator.R;
import com.ko.co2incubator.activity.HistoryDataActivity;
import com.ko.co2incubator.base.BaseFragment;
import com.ko.co2incubator.bean.Cell;
import com.ko.co2incubator.bean.Result;
import com.ko.co2incubator.constant.Constants;
import com.ko.co2incubator.netinterface.ResultInHis;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
	@BindView(R.id.expand_lv_history)
	ExpandableListView mExpandLvHistory;
	//	@BindView(R.id.title3_text)
	//	TextView mTitle3Text;
	//	@BindView(R.id.search_his)
	//	ImageView mSearchHis;
	//
	Unbinder unbinder;
	@BindView(R.id.refreshLayout_his)
	SmartRefreshLayout mRefreshLayoutHis;
	//	@BindView(R.id.expand_lv_history)
	//	ExpandableListView mExpandLvHistory;
	//	Unbinder unbinder1;

	private String url = Constants.BASEURL;

	@Override
	protected View initView() {
		View view = View.inflate( mContext, R.layout.fragment_historydata_layout, null );
		mSearchHis = view.findViewById( R.id.search_his );
		mExpandLvHistory = view.findViewById( R.id.expand_lv_history );
		mRefreshLayoutHis = view.findViewById(R.id.refreshLayout_his);
		//				mLvCurData = view.findViewById( R.id.lv_his_data );
		netData();
		mSearchHis.setOnClickListener( new MyOnClickListener() );
		Log.e( TAG, "历史数据页面初始化了" );

		//设置 Header 为 贝塞尔雷达 样式
		mRefreshLayoutHis.setRefreshHeader( new ClassicsHeader( mContext ).setEnableLastTime( true ) );
		//设置 Footer 为 球脉冲 样式
		mRefreshLayoutHis.setRefreshFooter( new ClassicsFooter( mContext ).setSpinnerStyle( SpinnerStyle.Scale ) );

		//下拉刷新
		mRefreshLayoutHis.setOnRefreshListener( new OnRefreshListener() {
			@Override
			public void onRefresh(RefreshLayout refreshlayout) {
				netData();
				refreshlayout.finishRefresh( 2000/*,false*/ );//传入false表示刷新失败
			}
		} );
		mRefreshLayoutHis.setOnLoadMoreListener( new OnLoadMoreListener() {
			@Override
			public void onLoadMore(RefreshLayout refreshlayout) {
				refreshlayout.finishLoadMore( 2000/*,false*/ );//传入false表示加载失败
			}
		} );


		return view;
	}

	private void netData() {
		Retrofit build = new Retrofit.Builder().baseUrl( url ).addConverterFactory( GsonConverterFactory.create() ).build();
		ResultInHis resultInHis = build.create( ResultInHis.class );
		//		CurrentDataIn currentDataIn = build.create( CurrentDataIn.class );
		//		Call<ResponseBody> call = currentDataIn.getCurData();
		Call<ResponseBody> call = resultInHis.getHisData();
		call.enqueue( new Callback<ResponseBody>() {

			@Override
			public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
				try {
					String json = response.body().string();
					initDatas( json );
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable t) {
				Log.e( TAG, "请求出错" );
			}
		} );


	}

	private void initDatas(String json) {
		Result res = JSON.parseObject( json, Result.class );
		Collections.sort( res.getData() );
		List<Cell> cells = new ArrayList<Cell>();
		for (Cell cell : res.getData()) {
			if (cell.getCid().equalsIgnoreCase( "0" )) {
				cells.add( cell );
				//                res.getData().remove(cell);
			}
		}
		for (Cell c : res.getData()) {
			for (Cell root : cells) {
				if (c.getCid().equalsIgnoreCase( root.getId() )) {
					root.getChildren().add( c );
					break;
				}
			}
		}
		mExpandLvHistory.setAdapter( new MyExpandableViewListHistoryAdapter( mContext, cells ) );
	}

	@Override
	protected void initData() {
		super.initData();
		//		netRequestData();
		//		mLvCurData.setAdapter(new MyHisDataAdapter());


	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO: inflate a fragment view
		View rootView = super.onCreateView( inflater, container, savedInstanceState );
		unbinder = ButterKnife.bind( this, rootView );
		return rootView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

	private class MyOnClickListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			startActivity( new Intent( mContext, HistoryDataActivity.class ) );
		}
	}
}

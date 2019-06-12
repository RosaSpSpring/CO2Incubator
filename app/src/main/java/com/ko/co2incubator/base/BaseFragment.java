package com.ko.co2incubator.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author lxm
 * @version 2019/6/11-14:11
 * @des ${基类\公共类 三个基本页面都要继承Fragment}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public abstract class BaseFragment extends Fragment {
	/**
	 * 上下文初始化视图时要用
	 */
	private Context mContext;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		//获取上下文
		mContext = getActivity();
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return initView();
	}

	/**
	 * 强制子类重写,实现子类特有ui
	 * @return
	 */
	protected abstract View initView();

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated( savedInstanceState );
		initData();
	}

	/**
	 * 当孩子需要初始化数据或者需要联网的时候绑定数据,展示数据等等可以重写该方法
	 */
	protected  void initData(){

	};
}

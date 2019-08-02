package com.ko.co2incubator.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ko.co2incubator.R;
import com.ko.co2incubator.activity.ShowHisDataActicity;
import com.ko.co2incubator.bean.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxm
 * @version 2019/7/23-10:34
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class MyExpandableViewListHistoryShowAdapter extends BaseExpandableListAdapter {
	public static final String TAG = MyExpandableViewListHistoryShowAdapter.class.getSimpleName();
	private Context mContext;

	private List<Cell> mHisData;

	public MyExpandableViewListHistoryShowAdapter(ShowHisDataActicity showHisDataActicity, ArrayList<Cell> cells) {
				this.mContext = showHisDataActicity;
				this.mHisData = cells;
	}
	@Override
	public int getGroupCount() {
		return mHisData.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return mHisData.get( groupPosition ).getChildren().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mHisData.get( groupPosition );
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return mHisData.get( groupPosition ).getChildren().get( childPosition );
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		GroupViewHolder groupViewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from( parent.getContext()).inflate( R.layout.first_all_his_show,parent,false );
			groupViewHolder = new GroupViewHolder();
			groupViewHolder.mNameShow = convertView.findViewById( R.id.tv_name_his_show );
			groupViewHolder.mCaozuoShow = convertView.findViewById( R.id.tv_caozuo_his_show );
			groupViewHolder.mDaiciShow = convertView.findViewById( R.id.tv_daici_his_show );
			groupViewHolder.mPinhshuShow = convertView.findViewById( R.id.tv_pingshu_his_show );
			groupViewHolder.mDateShow = convertView.findViewById( R.id.tv_date_his_show );
			groupViewHolder.mOperatorShow = convertView.findViewById(R.id.tv_operator_his_show );
			convertView.setTag( groupViewHolder );
		}else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}
		groupViewHolder.mNameShow.setText( mHisData.get( groupPosition ).getName() );
//		groupViewHolder.mCaozuoShow.setText( mHisData.get( groupPosition ).getOp_type());
		if ( "1".equals( mHisData.get( groupPosition ).getOp_type() )) {
			groupViewHolder.mCaozuoShow.setText( "新建" );
		} else if ("2".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoShow.setText( "换液" );
		} else if ("3".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoShow.setText( "传代" );
		}else if ("4".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoShow.setText( "观察" );
		}else if ("5".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoShow.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		groupViewHolder.mDaiciShow.setText( mHisData.get( groupPosition ).getGen());
		groupViewHolder.mPinhshuShow.setText( mHisData.get( groupPosition ).getNum() + "");
		groupViewHolder.mDateShow.setText( mHisData.get( groupPosition ).getOp_date());
		groupViewHolder.mOperatorShow.setText( mHisData.get( groupPosition ).getOper());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder childViewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_list_his_show,parent,false );
			childViewHolder = new ChildViewHolder();
			childViewHolder.mCaozuoCShow = convertView.findViewById( R.id.tv_item_caozuo_his_show);
			childViewHolder.mDaiciCShow = convertView.findViewById( R.id.tv_item_daici_his_show );
			childViewHolder.mPinhshuCShow = convertView.findViewById( R.id.tv_item_pingshu_his_show );
			childViewHolder.mOperatorCShow = convertView.findViewById( R.id.tv_item_operator_his_show );
			childViewHolder.mDateCShow = convertView.findViewById( R.id.tv_item_date_his_show );
			convertView.setTag( childViewHolder );
		} else {
			childViewHolder = (ChildViewHolder) convertView.getTag();

		}
//		childViewHolder.mCaozuoCShow.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() );
		if ( "1".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )) {
			childViewHolder.mCaozuoCShow.setText( "新建" );
		} else if ("2".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCShow.setText( "换液" );
		} else if ("3".equals(mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCShow.setText( "传代" );
		}else if ("4".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCShow.setText( "观察" );
		}else if ("5".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCShow.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		childViewHolder.mDaiciCShow.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getGen() );
		childViewHolder.mPinhshuCShow.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getNum() + "");
		childViewHolder.mOperatorCShow.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOper() );
		childViewHolder.mDateCShow.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_date() );
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	static class GroupViewHolder{

		private TextView mNameShow;
		private TextView mDaiciShow;
		private TextView mPinhshuShow;
		private TextView mOperatorShow;
		private TextView mDateShow;
		private TextView mCaozuoShow;
	}
	static class ChildViewHolder{
		private TextView mDaiciCShow;
		private TextView mPinhshuCShow;
		private TextView mOperatorCShow;
		private TextView mDateCShow;
		private TextView mCaozuoCShow;
	}
}

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
import com.ko.co2incubator.activity.ShowCurrentDataActicity;
import com.ko.co2incubator.bean.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxm
 * @version 2019/7/23-14:16
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class MyExpandableViewListCurrentShowAdapter extends BaseExpandableListAdapter {
	public static final String TAG = MyExpandableListViewAdapter.class.getSimpleName();

	private Context mContext;
	private List<Cell> mCurData;

	public MyExpandableViewListCurrentShowAdapter(ShowCurrentDataActicity showCurrentDataActicity, ArrayList<Cell> cells) {
		this.mContext = showCurrentDataActicity;
		this.mCurData = cells;
	}

	@Override
	public int getGroupCount() {
		return mCurData.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return mCurData.get( groupPosition ).getChildren().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return mCurData.get( groupPosition );
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return mCurData.get( groupPosition ).getChildren().get( childPosition );
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
		GroupViewHolder  groupViewHolder;
		if (convertView == null){
			convertView = LayoutInflater.from( parent.getContext()).inflate( R.layout.first_all_cur_show,parent,false );
			groupViewHolder = new GroupViewHolder();
			groupViewHolder.mNameCurShow = convertView.findViewById( R.id.tv_name_cur_show );
			groupViewHolder.mCaozuoCurShow = convertView.findViewById( R.id.tv_caozuo_cur_show );
			groupViewHolder.mDaiciCurShow = convertView.findViewById( R.id.tv_daici_cur_show );
			groupViewHolder.mPinhshuCurShow = convertView.findViewById( R.id.tv_pingshu_cur_show );
			groupViewHolder.mDateCurShow = convertView.findViewById( R.id.tv_date_cur_show );
			groupViewHolder.mOperatorCurShow = convertView.findViewById( R.id.tv_operator_cur_show );
			convertView.setTag( groupViewHolder );
		}else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}
		groupViewHolder.mNameCurShow.setText( mCurData.get( groupPosition ).getName());
//		groupViewHolder.mCaozuoCurShow.setText( mCurData.get( groupPosition ).getOp_type() );
		if ( "1".equals( mCurData.get( groupPosition ).getOp_type() )) {
			groupViewHolder.mCaozuoCurShow.setText( "新建" );
		} else if ("2".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoCurShow.setText( "换液" );
		} else if ("3".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoCurShow.setText( "传代" );
		}else if ("4".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoCurShow.setText( "观察" );
		}else if ("5".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuoCurShow.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		groupViewHolder.mDaiciCurShow.setText( mCurData.get( groupPosition ).getGen() );
		groupViewHolder.mPinhshuCurShow.setText( mCurData.get( groupPosition ).getNum()  + "");
		groupViewHolder.mDateCurShow.setText( mCurData.get( groupPosition ).getOp_date() );
		groupViewHolder.mOperatorCurShow.setText( mCurData.get( groupPosition ).getOper() );
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder childViewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_list_cur_show,parent,false );
			childViewHolder = new ChildViewHolder();
			childViewHolder.mCaozuoCurShowChild = convertView.findViewById( R.id.tv_item_caozuo_cur_show );
			childViewHolder.mDaiciCurShowChild = convertView.findViewById( R.id.tv_item_daici_cur_show );
			childViewHolder.mPinhshuCurShowChild = convertView.findViewById( R.id.tv_item_pingshu_cur_show );
			childViewHolder.mOperatorCurShowChild = convertView.findViewById( R.id.tv_item_operator_cur_show );
			childViewHolder.mDateCurShowChild = convertView.findViewById( R.id.tv_item_date_cur_show );
			convertView.setTag( childViewHolder );
		} else {
			childViewHolder = (ChildViewHolder) convertView.getTag();

		}
//		childViewHolder.mCaozuoCurShowChild.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() );
		if ( "1".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )) {
			childViewHolder.mCaozuoCurShowChild.setText( "新建" );
		} else if ("2".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCurShowChild.setText( "换液" );
		} else if ("3".equals(mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCurShowChild.setText( "传代" );
		}else if ("4".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCurShowChild.setText( "观察" );
		}else if ("5".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuoCurShowChild.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		childViewHolder.mDaiciCurShowChild.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getGen() );
		childViewHolder.mPinhshuCurShowChild.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getNum()  + "");
		childViewHolder.mOperatorCurShowChild.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOper() );
		childViewHolder.mDateCurShowChild.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_date() );
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}
	static class GroupViewHolder{

		private TextView mNameCurShow;
		private TextView mDaiciCurShow;
		private TextView mPinhshuCurShow;
		private TextView mOperatorCurShow;
		private TextView mDateCurShow;
		private TextView mCaozuoCurShow;
	}
	static class ChildViewHolder{
		private TextView mDaiciCurShowChild;
		private TextView mPinhshuCurShowChild;
		private TextView mOperatorCurShowChild;
		private TextView mDateCurShowChild;
		private TextView mCaozuoCurShowChild;
	}
}

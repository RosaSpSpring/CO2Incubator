package com.ko.co2incubator.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.ko.co2incubator.R;
import com.ko.co2incubator.bean.Cell;
import com.ko.co2incubator.bean.HistoryData;

import java.util.List;

/**
 * @author lxm
 * @version 2019/7/8-15:33
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class MyExpandableViewListHistoryAdapter extends BaseExpandableListAdapter {
	public static final String TAG = MyExpandableListViewAdapter.class.getSimpleName();

	private Context mContext;
	private List<Cell> mHisData;
	public MyExpandableViewListHistoryAdapter(Context context, List<Cell> mHData){
		this.mContext = context;
		this.mHisData = mHData;
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
			convertView = LayoutInflater.from( parent.getContext()).inflate( R.layout.first_all_his,parent,false );
			groupViewHolder = new GroupViewHolder();
			groupViewHolder.mName = convertView.findViewById( R.id.tv_name_his );
			groupViewHolder.mCaozuo = convertView.findViewById( R.id.tv_caozuo_his );
			groupViewHolder.mDaici = convertView.findViewById( R.id.tv_daici_his );
			groupViewHolder.mPinhshu = convertView.findViewById( R.id.tv_pingshu_his );
			groupViewHolder.mDate = convertView.findViewById( R.id.tv_date_his );
			groupViewHolder.mOperator = convertView.findViewById(R.id.tv_operator_his );
			convertView.setTag( groupViewHolder );
		}else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}
		groupViewHolder.mName.setText( mHisData.get( groupPosition ).getName() );
//		groupViewHolder.mCaozuo.setText( mHisData.get( groupPosition ).getOp_type());

		if ( "1".equals( mHisData.get( groupPosition ).getOp_type() )) {
			groupViewHolder.mCaozuo.setText( "新建" );
		} else if ("2".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "换液" );
		} else if ("3".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "传代" );
		}else if ("4".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "观察" );
		}else if ("5".equals( mHisData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		groupViewHolder.mDaici.setText( mHisData.get( groupPosition ).getGen());
		groupViewHolder.mPinhshu.setText( mHisData.get( groupPosition ).getNum() + "");
		groupViewHolder.mDate.setText( mHisData.get( groupPosition ).getOp_date());
		groupViewHolder.mOperator.setText( mHisData.get( groupPosition ).getOper());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder childViewHolder;
		if (convertView == null) {
			convertView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_list_his,parent,false );
			childViewHolder = new ChildViewHolder();
			childViewHolder.mCaozuo = convertView.findViewById( R.id.tv_item_caozuo_his);
			childViewHolder.mDaici = convertView.findViewById( R.id.tv_item_daici_his );
			childViewHolder.mPinhshu = convertView.findViewById( R.id.tv_item_pingshu_his );
			childViewHolder.mOperator = convertView.findViewById( R.id.tv_item_operator_his );
			childViewHolder.mDate = convertView.findViewById( R.id.tv_item_date_his );
			convertView.setTag( childViewHolder );
		} else {
			childViewHolder = (ChildViewHolder) convertView.getTag();

		}
//		childViewHolder.mCaozuo.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() );
		if ( "1".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )) {
			childViewHolder.mCaozuo.setText( "新建" );
		} else if ("2".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "换液" );
		} else if ("3".equals(mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "传代" );
		}else if ("4".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "观察" );
		}else if ("5".equals( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		childViewHolder.mDaici.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getGen() );
		childViewHolder.mPinhshu.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getNum() + "");
		childViewHolder.mOperator.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOper() );
		childViewHolder.mDate.setText( mHisData.get( groupPosition ).getChildren().get( childPosition ).getOp_date() );
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	static class GroupViewHolder{

		private TextView mName;
		private TextView mDaici;
		private TextView mPinhshu;
		private TextView mOperator;
		private TextView mDate;
		private TextView mCaozuo;
	}
	static class ChildViewHolder{
		private TextView mDaici;
		private TextView mPinhshu;
		private TextView mOperator;
		private TextView mDate;
		private TextView mCaozuo;
	}
}

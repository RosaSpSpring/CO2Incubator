package com.ko.co2incubator.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.ko.co2incubator.R;
import com.ko.co2incubator.bean.Cell;
import com.ko.co2incubator.bean.CurrentData;
import java.util.List;
/**
 * @author lxm
 * @version 2019/7/8-13:55
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class MyExpandableListViewAdapter extends BaseExpandableListAdapter {
	public static final String TAG = MyExpandableListViewAdapter.class.getSimpleName();

	private Context mContext;
	private List<Cell> mCurData;
	public MyExpandableListViewAdapter(Context context, List<Cell> mCData){
		this.mContext = context;
		this.mCurData = mCData;
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
			convertView = LayoutInflater.from( parent.getContext()).inflate( R.layout.first_all,parent,false );
			groupViewHolder = new GroupViewHolder();
			groupViewHolder.mName = convertView.findViewById( R.id.tv_name );
			groupViewHolder.mCaozuo = convertView.findViewById( R.id.tv_caozuo );
			groupViewHolder.mDaici = convertView.findViewById( R.id.tv_daici );
			groupViewHolder.mPinhshu = convertView.findViewById( R.id.tv_pingshu );
			groupViewHolder.mDate = convertView.findViewById( R.id.tv_date );
			groupViewHolder.mOperator = convertView.findViewById( R.id.tv_operator );
			convertView.setTag( groupViewHolder );
		}else {
			groupViewHolder = (GroupViewHolder) convertView.getTag();
		}
		groupViewHolder.mName.setText( mCurData.get( groupPosition ).getName());
		if ( "1".equals( mCurData.get( groupPosition ).getOp_type() )) {
			groupViewHolder.mCaozuo.setText( "新建" );
		} else if ("2".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "换液" );
		} else if ("3".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "传代" );
		}else if ("4".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "观察" );
		}else if ("5".equals( mCurData.get( groupPosition ).getOp_type() )){
			groupViewHolder.mCaozuo.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		groupViewHolder.mDaici.setText( mCurData.get( groupPosition ).getGen() );
		groupViewHolder.mPinhshu.setText( mCurData.get( groupPosition ).getNum()  + "");
		groupViewHolder.mDate.setText( mCurData.get( groupPosition ).getOp_date() );
		groupViewHolder.mOperator.setText( mCurData.get( groupPosition ).getOper() );
		Log.e(TAG, "Father" + mCurData.get( groupPosition ).getName());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder childViewHolder;
		if (convertView == null) {
		    convertView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.item_list,parent,false );
		    childViewHolder = new ChildViewHolder();
		    childViewHolder.mCaozuo = convertView.findViewById( R.id.tv_item_caozuo );
		    childViewHolder.mDaici = convertView.findViewById( R.id.tv_item_daici );
		    childViewHolder.mPinhshu = convertView.findViewById( R.id.tv_item_pingshu );
		    childViewHolder.mOperator = convertView.findViewById( R.id.tv_item_operator );
		    childViewHolder.mDate = convertView.findViewById( R.id.tv_item_date );
		    convertView.setTag( childViewHolder );
		} else {
			childViewHolder = (ChildViewHolder) convertView.getTag();

		}
		childViewHolder.mDaici.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getGen() );
		//		childViewHolder.mCaozuo.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() );
		if ( "1".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )) {
			childViewHolder.mCaozuo.setText( "新建" );
		} else if ("2".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "换液" );
		} else if ("3".equals(mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "传代" );
		}else if ("4".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "观察" );
		}else if ("5".equals( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_type() )){
			childViewHolder.mCaozuo.setText( "取出" );
		}else {
			Log.e(TAG, "找不到操作方式" );
		}
		childViewHolder.mPinhshu.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getNum()  + "");
		childViewHolder.mOperator.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOper() );
		childViewHolder.mDate.setText( mCurData.get( groupPosition ).getChildren().get( childPosition ).getOp_date() );
		Log.e(TAG, "Children*********" + mCurData.get( groupPosition ).getChildren().get( childPosition ).getName());
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

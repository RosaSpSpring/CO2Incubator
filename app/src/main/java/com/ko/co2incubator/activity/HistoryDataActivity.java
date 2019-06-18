package com.ko.co2incubator.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ko.co2incubator.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author lxm
 * @version 2019/6/17-13:43
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class HistoryDataActivity extends Activity {
	@BindView(R.id.iv_his_con_ser_back)
	ImageView mIvHisConSerBack;

	/**
	 * 历史数据gittest
	 * @param savedInstanceState
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate( savedInstanceState );
		setContentView( R.layout.activity_history_data );
		ButterKnife.bind( this );

		mIvHisConSerBack.setOnClickListener( new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				HistoryDataActivity.this.finish();
			}
		} );
	}
}

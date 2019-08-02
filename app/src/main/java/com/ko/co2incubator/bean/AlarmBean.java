package com.ko.co2incubator.bean;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author lxm
 * @version 2019/6/13-9:19
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class AlarmBean {

	/**
	 * code : 200
	 * msg : success
	 * data : [{"w_id":1,"w_type":"CO2","w_num":8,"w_date":"2019-07-08 16:30:28","mid":1},{"w_id":3,"w_type":"温度","w_num":0.2,"w_date":"2019-07-09 16:30:27","mid":1},{"w_id":6,"w_type":"温度","w_num":40,"w_date":"2019-07-10 15:11:05","mid":1},{"w_id":7,"w_type":"C02","w_num":70,"w_date":"2019-07-10 15:11:47","mid":1},{"w_id":8,"w_type":"内部温度","w_num":80,"w_date":"2019-07-10 15:12:39","mid":1},{"w_id":9,"w_type":"门内温度","w_num":70,"w_date":"2019-07-10 15:13:14","mid":1},{"w_id":10,"w_type":"湿度","w_num":10,"w_date":"2019-07-10 15:17:25","mid":1}]
	 */

	private int code;
	private String msg;
	private List<DataBean> data;

	public AlarmBean() {
	}

	public AlarmBean(int code, String msg, List<DataBean> data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<DataBean> getData() {
		return data;
	}

	public void setData(List<DataBean> data) {
		this.data = data;
	}

	public static class DataBean implements Comparable{
		/**
		 * w_id : 1
		 * w_type : CO2
		 * w_num : 8
		 * w_date : 2019-07-08 16:30:28
		 * mid : 1
		 */

		private int w_id;
		private String w_type;
		private int w_num;
		private String w_date;
		private int mid;

		public DataBean() {
		}

		public DataBean(int w_id, String w_type, int w_num, String w_date, int mid) {
			this.w_id = w_id;
			this.w_type = w_type;
			this.w_num = w_num;
			this.w_date = w_date;
			this.mid = mid;
		}

		public int getW_id() {
			return w_id;
		}

		public void setW_id(int w_id) {
			this.w_id = w_id;
		}

		public String getW_type() {
			return w_type;
		}

		public void setW_type(String w_type) {
			this.w_type = w_type;
		}

		public int getW_num() {
			return w_num;
		}

		public void setW_num(int w_num) {
			this.w_num = w_num;
		}

		public String getW_date() {
			return w_date;
		}

		public void setW_date(String w_date) {
			this.w_date = w_date;
		}

		public int getMid() {
			return mid;
		}

		public void setMid(int mid) {
			this.mid = mid;
		}

		@Override
		public int compareTo(@NonNull Object o) {
			if ( o instanceof DataBean){
				DataBean dataBean = (DataBean) o;
				return -this.w_date.compareTo(dataBean.w_date);
			}
			throw new RuntimeException("传入数据类型不一致");
		}
	}
}
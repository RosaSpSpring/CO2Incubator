package com.ko.co2incubator.bean;
import java.util.Date;
import java.util.List;
/**
 * @author lxm
 * @version 2019/6/13-9:19
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class CO2AlarmBean {
	private String msg;
	private List<Data> data;

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public List<Data> getData() {
		return data;
	}

	class Data {

		private String id;
		private String co2值;
		private Date time;
		private String hour;

		public void setId(String id) {
			this.id = id;
		}

		public String getId() {
			return id;
		}

		public void setCo2值(String co2值) {
			this.co2值 = co2值;
		}

		public String getCo2值() {
			return co2值;
		}

		public void setTime(Date time) {
			this.time = time;
		}

		public Date getTime() {
			return time;
		}

		public void setHour(String hour) {
			this.hour = hour;
		}

		public String getHour() {
			return hour;
		}

	}
}
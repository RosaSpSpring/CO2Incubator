package com.ko.co2incubator.bean;

import java.util.List;

/**
 * @author lxm
 * @version 2019/6/13-9:19
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class CO2AlarmBean {

	/**
	 * error : false
	 * results : [{"id":"1","co2":"6.0","date":"2019/06/24"},{"id":"2","co2":"6.0","date":"2019/06/25"},{"id":"3","co2":"6.0","date":"2019/06/26"},{"id":"4","co2":"6.0","date":"2019/06/26"},{"id":"5","co2":"6.0","date":"2019/06/27"},{"id":"6","co2":"6.0","date":"2019/06/27"},{"id":"7","co2":"6.0","date":"2019/06/27"},{"id":"8","co2":"6.0","date":"2019/06/27"},{"id":"9","co2":"6.0","date":"2019/06/28"},{"id":"10","co2":"6.0","date":"2019/06/29"}]
	 */

	private boolean error;
	private List<ResultsBean> results;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public List<ResultsBean> getResults() {
		return results;
	}

	public void setResults(List<ResultsBean> results) {
		this.results = results;
	}

	public static class ResultsBean {
		/**
		 * id : 1
		 * co2 : 6.0
		 * date : 2019/06/24
		 */

		private String id;
		private String co2;
		private String date;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getCo2() {
			return co2;
		}

		public void setCo2(String co2) {
			this.co2 = co2;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}
	}
}
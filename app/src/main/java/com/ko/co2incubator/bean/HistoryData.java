package com.ko.co2incubator.bean;

import java.util.List;

/**
 * @author lxm
 * @version 2019/7/8-15:35
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class HistoryData {
	/**
	 * msg : success
	 * data : [{"id":1,"pid":null,"name":"hela","daici":"P1","caozuo":"海拉0父","pingshu":"37","date":"2019/07/15","operator":"杨","children":[{"id":11,"pid":1,"name":"hela","daici":"P1","caozuo":"海拉1","pingshu":"37","date":"2019/07/15","operator":"杨"},{"id":12,"pid":1,"name":"hela","daici":"P1","caozuo":"海拉2","pingshu":"37","date":"2019/07/15","operator":"杨"}]},{"id":2,"pid":null,"name":"shenjing","daici":"P1","caozuo":"神经0","pingshu":"127","date":"2019/07/01","operator":"杨","children":[{"id":21,"pid":2,"name":"shenjing","daici":"P1","caozuo":"神经1","pingshu":"127","date":"2019/07/01","operator":"杨"},{"id":22,"pid":2,"name":"shenjing","daici":"P1","caozuo":"神经2","pingshu":"127","date":"2019/07/01","operator":"杨"}]},{"id":3,"pid":null,"name":"maonang","daici":"P4","caozuo":"毛囊0","pingshu":"15","date":"2019/07/09","operator":"杨","children":[{"id":31,"pid":3,"name":"maonang","daici":"P4","caozuo":"毛囊1","pingshu":"15","date":"2019/07/09","operator":"杨"},{"id":32,"pid":3,"name":"maonang","daici":"P4","caozuo":"毛囊2","pingshu":"15","date":"2019/07/09","operator":"杨"}]},{"id":4,"pid":null,"name":"gancell","daici":"P3","caozuo":"干细胞0","pingshu":"19","date":"2019/07/07","operator":"杨","children":[{"id":41,"pid":4,"name":"gancell","daici":"P3","caozuo":"干细胞1","pingshu":"19","date":"2019/07/07","operator":"杨"},{"id":42,"pid":4,"name":"gancell","daici":"P3","caozuo":"干细胞2","pingshu":"19","date":"2019/07/07","operator":"杨"}]},{"id":5,"pid":null,"name":"zhongliu","daici":"P2","caozuo":"肿瘤0","pingshu":"7","date":"2019/06/04","operator":"杨","children":[{"id":51,"pid":5,"name":"zhongliu","daici":"P2","caozuo":"肿瘤1","pingshu":"7","date":"2019/06/04","operator":"杨"},{"id":52,"pid":5,"name":"zhongliu","daici":"P2","caozuo":"肿瘤2","pingshu":"7","date":"2019/06/04","operator":"杨"}]}]
	 */

	private String msg;
	private List<DataBean> data;

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

	public static class DataBean {
		/**
		 * id : 1
		 * pid : null
		 * name : hela
		 * daici : P1
		 * caozuo : 海拉0父
		 * pingshu : 37
		 * date : 2019/07/15
		 * operator : 杨
		 * children : [{"id":11,"pid":1,"name":"hela","daici":"P1","caozuo":"海拉1","pingshu":"37","date":"2019/07/15","operator":"杨"},{"id":12,"pid":1,"name":"hela","daici":"P1","caozuo":"海拉2","pingshu":"37","date":"2019/07/15","operator":"杨"}]
		 */

		private int id;
		private Object pid;
		private String name;
		private String daici;
		private String caozuo;
		private String pingshu;
		private String date;
		private String operator;
		private List<ChildrenBean> children;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public Object getPid() {
			return pid;
		}

		public void setPid(Object pid) {
			this.pid = pid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDaici() {
			return daici;
		}

		public void setDaici(String daici) {
			this.daici = daici;
		}

		public String getCaozuo() {
			return caozuo;
		}

		public void setCaozuo(String caozuo) {
			this.caozuo = caozuo;
		}

		public String getPingshu() {
			return pingshu;
		}

		public void setPingshu(String pingshu) {
			this.pingshu = pingshu;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getOperator() {
			return operator;
		}

		public void setOperator(String operator) {
			this.operator = operator;
		}

		public List<ChildrenBean> getChildren() {
			return children;
		}

		public void setChildren(List<ChildrenBean> children) {
			this.children = children;
		}

		public static class ChildrenBean {
			/**
			 * id : 11
			 * pid : 1
			 * name : hela
			 * daici : P1
			 * caozuo : 海拉1
			 * pingshu : 37
			 * date : 2019/07/15
			 * operator : 杨
			 */

			private int id;
			private int pid;
			private String name;
			private String daici;
			private String caozuo;
			private String pingshu;
			private String date;
			private String operator;

			public int getId() {
				return id;
			}

			public void setId(int id) {
				this.id = id;
			}

			public int getPid() {
				return pid;
			}

			public void setPid(int pid) {
				this.pid = pid;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getDaici() {
				return daici;
			}

			public void setDaici(String daici) {
				this.daici = daici;
			}

			public String getCaozuo() {
				return caozuo;
			}

			public void setCaozuo(String caozuo) {
				this.caozuo = caozuo;
			}

			public String getPingshu() {
				return pingshu;
			}

			public void setPingshu(String pingshu) {
				this.pingshu = pingshu;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getOperator() {
				return operator;
			}

			public void setOperator(String operator) {
				this.operator = operator;
			}
		}
	}
}

package com.ko.co2incubator.constant;

/**
 * @author lxm
 * @version 2019/7/5-9:20
 * @des ${网络请求地址}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public class Constants {

	//培养箱参数地址
	public static final String PARAMSRADIUS = "http://keyonecn.com:8897/";
	//BaseUrl
//	public static final String BASEURL = "http://192.168.104.190:8080/";
//	public static final String BASEURL = "http://192.168.110.1:8080/";
//	public static final String BASEURL = "http://www.rosasp.club/";
	public static final String BASEURL = "http://192.168.104.163:8001/";
//	public static final String BASEURL = "http://www.rosasp.club/";

	//报警信息地址http://192.168.104.174:8080/warn/getByMacID?macID=1
	public static final String BASEALARM = "http://192.168.104.182:8001/";
//	public static final String BASEALARM = "http://www.rosasp.club/";
	//当前数据
//	public static final String CURRENTDATA = "co2Incubator/cur_data.json";
	public static final String CURRENTDATA = "cellrecord/getTemp";

	//历史数据
//	public static final String HISTORYDATA = "co2Incubator/his_data.json";
	public static final String HISTORYDATA = "cellrecord/getHistory";
	//报警数据
//	public static final String ALARMINFO = "co2Incubator/co2_alarm.json";
	public static final String ALARMINFO_T = "warn/getByMacID?macID=1";

	//条件检索历史数据cellrecord/getHis_Args
	public static final String HISDATASEARCH = "cellrecord/getHis_Args";

	//条件检索当前数据
	public static final String CURDATASEARCH = "cellrecord/getTemp_Args";
}

package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.AlarmBean;
import com.ko.co2incubator.constant.Constants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/11-9:34
 * @des ${请求报警数据}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface AlarmIn {
	@GET(Constants.ALARMINFO_T)
	Call<ResponseBody> getAlarmInfo();
}

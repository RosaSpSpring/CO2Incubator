package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.CO2AlarmBean;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

/**
 * @author lxm
 * @version 2019/6/24-12:34
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface EvironmentAPI {
	@GET("/co2Incubator/co2_alarm.json")
	Call<CO2AlarmBean> getCo2AlarmInfo();
}

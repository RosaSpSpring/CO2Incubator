package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.CO2SetBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/5-10:36
 * @des ${CO2的设定值接口}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface CO2SetIn {
	@GET("/redis/getValue?key=CO2Set" )
	Call<CO2SetBean> getCO2Set();
}

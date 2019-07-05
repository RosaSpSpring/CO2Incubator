package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.CO2Cls;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/5-9:23
 * @des ${请求CO2值接口}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface CO2 {
	@GET("/redis/getValue?key=CO2" )
	Call<CO2Cls> getCO2();
}

package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.TemperatureBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/5-10:35
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface TemperatureIn {
	@GET("/redis/getValue?key=temperature" )
	Call<TemperatureBean> getTemperature();
}

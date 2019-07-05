package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.TempratureSetBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/5-10:27
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface TempratureSetIn {
	@GET("/redis/getValue?key=temperatureSet" )
	Call<TempratureSetBean> getTemperatureSet();

}

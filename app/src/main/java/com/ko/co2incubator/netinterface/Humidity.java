package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.HumidityBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/5-10:44
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface Humidity {
	@GET("/redis/getValue?key=humidity ")
	Call<HumidityBean> getHumidity();
}

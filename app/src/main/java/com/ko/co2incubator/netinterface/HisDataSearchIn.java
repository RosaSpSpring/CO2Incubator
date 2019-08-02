package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.constant.Constants;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author lxm
 * @version 2019/7/22-16:46
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface HisDataSearchIn {
	@GET(Constants.HISDATASEARCH)
//	Call<ResponseBody> getHisDataSearch(@QueryMap Map<String,String> queryParams);
	Call<ResponseBody> getHisDataSearch(@Query("name") String name,@Query( "gen" ) String gen,@Query( "oper" ) String oper,@Query( "start_time" ) String start_time,@Query( "end_time" ) String end_time);
}

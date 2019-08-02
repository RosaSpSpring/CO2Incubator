package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.constant.Constants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author lxm
 * @version 2019/7/23-13:42
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface CurDataSearchIn {
	@GET(Constants.CURDATASEARCH)
	Call<ResponseBody> getCurDataSearch(@Query("name") String name, @Query( "gen" ) String gen,@Query( "time" ) int time);
}

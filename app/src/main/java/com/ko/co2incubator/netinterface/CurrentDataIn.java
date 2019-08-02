package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.constant.Constants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/8-14:50
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface CurrentDataIn {

	@GET(Constants.CURRENTDATA)
	Call<ResponseBody> getCurData();
}

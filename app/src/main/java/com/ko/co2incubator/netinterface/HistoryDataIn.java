package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.constant.Constants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author lxm
 * @version 2019/7/8-15:28
 * @des ${TODO}
 * @updateDes ${TODO}
 * @updateAuthor $Author$
 */
public interface HistoryDataIn {
	@GET(Constants.HISTORYDATA)
	Call<ResponseBody> getHistoryData();
}

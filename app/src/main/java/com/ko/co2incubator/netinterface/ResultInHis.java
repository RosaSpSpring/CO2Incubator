package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.constant.Constants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Admin
 * @version $Rev$
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDes ${TODO}
 */
public interface ResultInHis {
    @GET(Constants.HISTORYDATA)
    Call<ResponseBody> getHisData();
}

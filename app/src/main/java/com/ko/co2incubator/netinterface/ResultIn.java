package com.ko.co2incubator.netinterface;

import com.ko.co2incubator.bean.Result;
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
public interface ResultIn {
    @GET(Constants.CURRENTDATA)
    Call<ResponseBody> getCurData();
}

package com.release.ojass2022;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserClient {
    @POST("login")
    Call<ResponseBody> sendToken(@Body User user);
}

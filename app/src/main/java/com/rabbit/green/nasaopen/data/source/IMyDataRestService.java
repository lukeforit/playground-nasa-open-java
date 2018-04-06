package com.rabbit.green.nasaopen.data.source;

import com.rabbit.green.nasaopen.data.model.PojoObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMyDataRestService {
    @GET("apod")
    Call<PojoObject> getData(@Query("api_key") String apiKey);
}

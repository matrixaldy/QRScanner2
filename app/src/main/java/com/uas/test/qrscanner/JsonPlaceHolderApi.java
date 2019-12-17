package com.uas.test.qrscanner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    @GET("fri")
    Call<List<Fri>> getFris();

    @GET("fri/{id}")
    Call<Fri> showFri(@Path("id") int friId);
}

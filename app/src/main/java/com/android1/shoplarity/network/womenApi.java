package com.android1.shoplarity.network;

import com.android1.shoplarity.womenClothes.Womenclothesresponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface womenApi {
    @GET("businesses/search")
    Call<Womenclothesresponse>getWomenClothes(
            @Query("term") String term,
            @Query("location") String location,
            @Query("categories") String categories
    );
}

package com.artan.myglobe.network;

import com.artan.myglobe.models.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CountriesResponse {

    //  https://restcountries.eu/rest/v1/all

    @GET("rest/v1/all")
    Call<List<Countries>> schoolsData();
}

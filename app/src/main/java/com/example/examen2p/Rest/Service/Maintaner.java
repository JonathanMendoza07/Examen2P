package com.example.examen2p.Rest.Service;

import com.example.examen2p.Rest.Model.MaintanerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Maintaner {

    @GET("cats")
    Call<List<MaintanerModel>> getListMaintainer();
}

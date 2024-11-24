package com.example.nicestart.network;

import com.example.nicestart.models.LoginRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/login")
    Call<Void> loginUser(@Body LoginRequest request);
}

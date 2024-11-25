package com.example.nicestart.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://your-backend-url.com") // Replace with your backend URL
                    .addConverterFactory(GsonConverterFactory.create()) // Use Gson for JSON parsing
                    .build();
        }
        return retrofit;
    }
}

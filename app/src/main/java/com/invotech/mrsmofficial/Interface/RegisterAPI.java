package com.invotech.mrsmofficial.Interface;

import com.invotech.mrsmofficial.Model.Register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RegisterAPI {

    @POST("form")
    Call<Register> RegisterUser(
            @Path("name") String name,
            @Path("city") String city,
            @Path("address") String address,
            @Path("phone") String phone,
            @Path("fatherName") String fatherName,
            @Path("age") String age,
            @Path("qualification") String qualification,
            @Path("email") String email
    );
}

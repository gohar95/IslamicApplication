package com.invotech.mrsmofficial.Model;

import com.google.gson.annotations.SerializedName;

public class Register {

    @SerializedName("city")
    String city;
    @SerializedName("address")
    String address;
    @SerializedName("phone")
    String phone;
    @SerializedName("name")
    String name;
    @SerializedName("fatherName")
    String fatherName;
    @SerializedName("age")
    String age;
    @SerializedName("qualification")
    String qualification;
    @SerializedName("email")
    String email;

    public Register(String name, String fatherName, String age, String qualification, String email, String city, String address, String phone) {
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
        this.qualification = qualification;
        this.email = email;
        this.city = city;
        this.address = address;
        this.phone = phone;
    }


}

package com.chemo.anselmo.rest;


import com.chemo.anselmo.models.UserResponse;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;


public interface ApiService {
    @GET("/users/")
    Observable<List<UserResponse>> getUsers();
}

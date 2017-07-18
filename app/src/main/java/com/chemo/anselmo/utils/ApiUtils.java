package com.chemo.anselmo.utils;


import com.chemo.anselmo.rest.ApiService;
import com.chemo.anselmo.rest.RetrofitClient;



public class ApiUtils {
    public final static String LOCATIONS_ENDPOINT = "https://jsonplaceholder.typicode.com/";

    public static ApiService getUserService() {
        return RetrofitClient.getClient(LOCATIONS_ENDPOINT).create(ApiService.class);
    }
}

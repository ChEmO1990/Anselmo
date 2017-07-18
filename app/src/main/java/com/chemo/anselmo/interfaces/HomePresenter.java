package com.chemo.anselmo.interfaces;


import com.chemo.anselmo.models.UserResponse;

import java.util.List;


public interface HomePresenter {
    void getAllData();
    void onSucess(List<UserResponse> items);
    void onError(String error);
}

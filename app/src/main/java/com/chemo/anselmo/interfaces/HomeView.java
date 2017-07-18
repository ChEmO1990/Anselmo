package com.chemo.anselmo.interfaces;

import com.chemo.anselmo.models.UserResponse;

import java.util.List;



public interface HomeView {
    void showProgress();
    void hideProgress();
    void showError(String error);
    void finishFetch(List<UserResponse> items);
    void sendData( List<UserResponse> items );
}

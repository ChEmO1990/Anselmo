package com.chemo.anselmo.interactors;

import android.location.Location;

import com.chemo.anselmo.interfaces.HomeInteractor;
import com.chemo.anselmo.interfaces.HomePresenter;
import com.chemo.anselmo.models.UserResponse;
import com.chemo.anselmo.rest.ApiService;
import com.chemo.anselmo.utils.ApiUtils;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class HomeInteractorImpl implements HomeInteractor {
    private ApiService userService;
    private HomePresenter presenter;
    private List<UserResponse> items;


    public HomeInteractorImpl(HomePresenter presenter) {
        this.presenter = presenter;
        userService = ApiUtils.getUserService();

        items = new ArrayList<>();
    }

    @Override
    public void getAllData() {
        Observable<List<UserResponse>> list = userService.getUsers();

        list.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<UserResponse>>() {
                    @Override
                    public void onCompleted() {
                        presenter.onSucess(items);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        presenter.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<UserResponse> users) {
                        items.addAll(users);
                    }
                });
    }
}
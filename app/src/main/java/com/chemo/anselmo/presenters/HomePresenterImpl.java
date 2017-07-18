package com.chemo.anselmo.presenters;



import com.chemo.anselmo.interactors.HomeInteractorImpl;
import com.chemo.anselmo.interfaces.HomeInteractor;
import com.chemo.anselmo.interfaces.HomePresenter;
import com.chemo.anselmo.interfaces.HomeView;
import com.chemo.anselmo.models.UserResponse;

import java.util.List;


public class HomePresenterImpl implements HomePresenter {
    private HomeView view;
    private HomeInteractor interactor;

    public HomePresenterImpl(HomeView view) {
        this.view = view;
        interactor = new HomeInteractorImpl(this);
    }

    @Override
    public void getAllData() {
        if(view != null){
            view.showProgress();
            interactor.getAllData();
        }
    }


    @Override
    public void onSucess(List<UserResponse> items) {
        if(view != null){
            view.hideProgress();
            view.sendData(items);
        }
    }

    @Override
    public void onError(String error) {
        if(view != null){
            view.showError(error);
            view.hideProgress();
        }
    }
}

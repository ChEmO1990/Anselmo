package com.chemo.anselmo.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.chemo.anselmo.R;
import com.chemo.anselmo.adapters.HomeAdapter;
import com.chemo.anselmo.interfaces.HomePresenter;
import com.chemo.anselmo.interfaces.HomeView;
import com.chemo.anselmo.models.UserResponse;
import com.chemo.anselmo.presenters.HomePresenterImpl;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomeView {
    @BindView(R.id.btnGetData)
    Button recyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private HomePresenter presenter;
    private List<UserResponse> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Home");
        progressBar.setVisibility(View.GONE);
        presenter = new HomePresenterImpl(this);
    }

    @OnClick(R.id.btnGetData)
    public void get() {
        presenter.getAllData();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void finishFetch(List<UserResponse> items) {
        Toast.makeText(this, "OK" + items.size(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void sendData(List<UserResponse> items) {
        hideProgress();

        String names[] = new String[items.size()];
        for( int i = 0; i < names.length; i++ ) {
            names[i] = items.get(i).getName();
        }

        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("array", names);
        startActivity(i);
        items.clear();
    }
}
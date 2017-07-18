package com.chemo.anselmo.views;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chemo.anselmo.R;
import com.chemo.anselmo.adapters.HomeAdapter;
import com.chemo.anselmo.interfaces.HomePresenter;
import com.chemo.anselmo.models.UserResponse;
import com.chemo.anselmo.presenters.HomePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class DetailActivity extends BaseActivity {
    @BindView(R.id.recyclerHome)
    RecyclerView recyclerView;

    private HomeAdapter adapter;
    private List<UserResponse> items;
    private String values[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        setTitle("Detail");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            values = extras.getStringArray("array");
        }

        items = new ArrayList<>();
        adapter = new HomeAdapter(this, items);

        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        for( int i = 0; i < values.length; i++ ) {
            UserResponse user = new UserResponse();
            user.setName(values[i]);
            items.add(user);
        }

        adapter.notifyDataSetChanged();
    }
}

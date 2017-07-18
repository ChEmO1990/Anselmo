package com.chemo.anselmo.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chemo.anselmo.R;
import com.chemo.anselmo.models.UserResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.WebServiceHolder> {
    private Context mContext;
    private List<UserResponse> items;

    public class WebServiceHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textName)
        TextView name;

        public WebServiceHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    public HomeAdapter(Context mContext, List<UserResponse> itemsList) {
        this.mContext = mContext;
        this.items = itemsList;
    }

    @Override
    public WebServiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new WebServiceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WebServiceHolder holder, int position) {
        UserResponse currentLocation = items.get(position);
        String name = currentLocation.getName();
        holder.name.setText(name);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

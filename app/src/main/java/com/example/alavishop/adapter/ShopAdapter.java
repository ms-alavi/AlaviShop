package com.example.alavishop.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShopAdapter  extends RecyclerView.Adapter<ShopAdapter.ShopHolder> {
    @NonNull
    @Override
    public ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ShopHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ShopHolder extends RecyclerView.ViewHolder{

        public ShopHolder(@NonNull View itemView) {
            super(itemView);
        }
    }





}

package com.example.alavishop.view;

import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.alavishop.R;

public class ShopActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return HomePageFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

}
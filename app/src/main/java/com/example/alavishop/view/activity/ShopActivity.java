package com.example.alavishop.view.activity;

import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.alavishop.R;
import com.example.alavishop.view.fragment.HomePageFragment;

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


    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }


    }

}
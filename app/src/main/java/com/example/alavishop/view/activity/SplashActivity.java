package com.example.alavishop.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.alavishop.R;
import com.example.alavishop.view.fragment.SplashFragment;

public class SplashActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new SplashFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}
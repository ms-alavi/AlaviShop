package com.example.alavishop.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.alavishop.R;
import com.example.alavishop.view.fragment.ListOfCategoryFragment;

public class ListOfCategoryActivity extends SingleFragmentActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,ListOfCategoryActivity.class);
        return intent;
    }

    @Override
    public Fragment createFragment() {
        return ListOfCategoryFragment.newInstance();
    }


}
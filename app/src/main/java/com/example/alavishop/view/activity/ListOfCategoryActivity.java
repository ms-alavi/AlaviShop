package com.example.alavishop.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.alavishop.R;
import com.example.alavishop.networkmodel.product.ProductResponse;
import com.example.alavishop.view.fragment.ListOfCategoryFragment;
import com.example.alavishop.view.fragment.ProductDetailFragment;

public class ListOfCategoryActivity extends AppCompatActivity {
    public static final String EXTRA_CATEGORY_ID = "extraCategoryId";
    private int mCategoryId;


    public static Intent newIntent(Context context, int categoryId){
        Intent intent=new Intent(context,ListOfCategoryActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID,categoryId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Intent intent=getIntent();
        if (intent!=null){
            mCategoryId= getIntent().getIntExtra(EXTRA_CATEGORY_ID,0);
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        ListOfCategoryFragment listOfCategoryFragment =ListOfCategoryFragment.newInstance(mCategoryId);
        Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment==null) {
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, listOfCategoryFragment)
                    .commit();
        }


    }







}
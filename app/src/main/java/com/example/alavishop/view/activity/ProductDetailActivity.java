package com.example.alavishop.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.alavishop.R;
import com.example.alavishop.model.product.Product;
import com.example.alavishop.networkmodel.product.ProductResponse;
import com.example.alavishop.view.fragment.ProductDetailFragment;

public class ProductDetailActivity extends AppCompatActivity {

    private ProductResponse mProduct;
    public static final String EXTRA_PRODUCT = " com.example.alavishop.extraProduct";



    public static Intent newIntent(Context context, ProductResponse product) {
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra(EXTRA_PRODUCT,  product);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Intent intent=getIntent();
        if (intent!=null){
            mProduct= (ProductResponse) getIntent().getSerializableExtra(EXTRA_PRODUCT);
        }
        FragmentManager fragmentManager=getSupportFragmentManager();
        ProductDetailFragment playerFragment =ProductDetailFragment.newInstance(mProduct);
        Fragment fragment=fragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment==null) {
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, playerFragment)
                    .commit();
        }


    }

}
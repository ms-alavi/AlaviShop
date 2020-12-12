package com.example.alavishop.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alavishop.R;
import com.example.alavishop.adapter.ImagePagerAdapter;
import com.example.alavishop.databinding.FragmentProductDetailBinding;
import com.example.alavishop.model.Product;

public class ProductDetailFragment extends Fragment {
    public static final String PDF = "PDF";
    private Product mProduct;
    private FragmentProductDetailBinding mBinding;

    public static final String ARGS_PRODUCT = " com.example.alavishop.argsProduct";

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    public static ProductDetailFragment newInstance(Product product) {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARGS_PRODUCT, product);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mProduct = (Product) getArguments().getSerializable(ARGS_PRODUCT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_product_detail
                , container
                , false);
        ImagePagerAdapter adapter=new ImagePagerAdapter(
                getActivity()
                ,mProduct.getImages());
        mBinding.imageSlider.setAdapter(new ImagePagerAdapter(getActivity(),mProduct.getImages()));
        mBinding.setProduct(mProduct);
        return mBinding.getRoot();
    }
}
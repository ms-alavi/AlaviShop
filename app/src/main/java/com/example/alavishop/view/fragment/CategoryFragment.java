package com.example.alavishop.view.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alavishop.R;
import com.example.alavishop.adapter.CategoryAdapter;
import com.example.alavishop.databinding.FragmentCategoryBinding;
import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.Category.CategoryProduct;
import com.example.alavishop.networkmodel.category.CategoryResponse;
import com.example.alavishop.viewmodel.CategoryViewModel;
import com.example.alavishop.viewmodel.ShopViewModel;

import java.util.List;

public class CategoryFragment extends Fragment {
    public static final String CF = "CF";
    private FragmentCategoryBinding mBinding;
    private CategoryViewModel mViewModel;


    public CategoryFragment() {
        // Required empty public constructor
    }


    public static CategoryFragment newInstance() {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        mViewModel.fetchAllCategoriesAsync();
        mViewModel.fetchMainCategoriesAsync();
        setLiveDataObserver();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_category
                , container
                , false);
        initMethod();

        return mBinding.getRoot();
    }

    private void initMethod() {
        mBinding.categoryRecycleView.setLayoutManager(new GridLayoutManager(getActivity(),3));
    }

    private void setAdapter(List<CategoryResponse> categories){
        CategoryAdapter adapter=new CategoryAdapter(categories,getActivity());
        mBinding.categoryRecycleView.setAdapter(adapter);
    }
    private void setLiveDataObserver() {
        mViewModel.getAllCategories().observe(this, new Observer<List<CategoryResponse>>() {
            @Override
            public void onChanged(List<CategoryResponse> categories) {
                setAdapter(categories);
            }
        });
    }

}
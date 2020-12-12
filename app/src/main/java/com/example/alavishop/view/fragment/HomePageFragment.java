package com.example.alavishop.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.alavishop.R;
import com.example.alavishop.adapter.ShopAdapter;
import com.example.alavishop.databinding.FragmentHomePageBinding;
import com.example.alavishop.model.Product;
import com.example.alavishop.viewmodel.ShopViewModel;

import java.util.List;


public class HomePageFragment extends Fragment {
    public static final String HomePageFragment = "HomePageFragment";
    private FragmentHomePageBinding mBinding;
    private ShopViewModel mShopViewModel;

    public HomePageFragment() {
        // Required empty public constructor
    }


    public static HomePageFragment newInstance() {
        HomePageFragment fragment = new HomePageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mShopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);

        mShopViewModel.fetchItems(null);
        setLiveDataObservers();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_home_page,
                container,
                false);

        initViews();


        return mBinding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.app_bar_menu,menu);
        MenuItem item=menu.findItem(R.id.hamber_menu);
    }

    private void setUpAdapter(List<Product> items, int list) {
        ShopAdapter adapter = new ShopAdapter( items,getContext());
        switch (list){
            case 0:
                mBinding.recycleViewBest.setAdapter(adapter);
                break;
            case 1:
                mBinding.recycleViewNewest.setAdapter(adapter);
                break;
            case 2:
                mBinding.recycleViewMostVisited.setAdapter(adapter);
                break;

        }

    }

    private void initViews() {
        mBinding.recycleViewBest.setLayoutManager
                (new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL,
                        false));
        mBinding.recycleViewMostVisited.setLayoutManager
                (new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL,
                        false));
        mBinding.recycleViewNewest.setLayoutManager
                (new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL,
                        false));
    }

    private void setLiveDataObservers() {
        mShopViewModel.getBestRateProductsLiveData().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> items) {
                setUpAdapter(items,0);
            }
        });
        mShopViewModel.getNewestProductsLiveData().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> items) {
                setUpAdapter(items,1);
            }
        });
        mShopViewModel.getPopularProductsLiveData().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> items) {
                setUpAdapter(items,2);
            }
        });
     //ToDo: add search
    }
}
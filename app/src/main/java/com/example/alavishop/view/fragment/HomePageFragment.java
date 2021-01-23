package com.example.alavishop.view.fragment;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alavishop.R;
import com.example.alavishop.adapter.ShopAdapter;
import com.example.alavishop.databinding.FragmentHomePageBinding;
import com.example.alavishop.model.product.Product;
import com.example.alavishop.networkmodel.product.WebserviceProductModel;
import com.example.alavishop.view.activity.CategoryActivity;
import com.example.alavishop.viewmodel.ShopViewModel;
import com.google.android.material.navigation.NavigationView;

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

        onBackPressedInFragment();

        mShopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);

        mShopViewModel.fetchItems(null);

        setLiveDataObservers();

    }



    private void onBackPressedInFragment() {
        getActivity() .getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (mBinding.homePageDrawableLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mBinding.homePageDrawableLayout.closeDrawer(Gravity.RIGHT);
                }
                else getActivity().finish();

            }
        });
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

        setListeners();

        return mBinding.getRoot();
    }

    private void setListeners() {
        mBinding.navigationView.setNavigationItemSelectedListener(item -> {

            int id=item.getItemId();
            switch (id){
                case R.id.card_menu:
                    Toast.makeText(getActivity(), "health", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.category_menu:
                    getActivity().startActivity(CategoryActivity.newIntent(getActivity()));
                    break;
                case R.id.profile_menu:
                    //TODO
                    break;
            }
            mBinding.homePageDrawableLayout.closeDrawer(Gravity.RIGHT);
            return true;
        });
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.app_bar_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.hamber_menu:
                mBinding.homePageDrawableLayout.openDrawer(Gravity.RIGHT);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setUpAdapter(List<WebserviceProductModel> items, int list) {
        ShopAdapter adapter = new ShopAdapter( items,getActivity());
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
        mShopViewModel.getBestRateProductsLiveData().observe(this, items -> {
            Log.d(HomePageFragment,"items : "+items.toString());
            setUpAdapter(items,0);
        });
        mShopViewModel.getNewestProductsLiveData()
                .observe(this, items -> setUpAdapter(items,1));
        mShopViewModel.getPopularProductsLiveData()
                .observe(this, items -> setUpAdapter(items,2));
     //ToDo: add search
    }
}
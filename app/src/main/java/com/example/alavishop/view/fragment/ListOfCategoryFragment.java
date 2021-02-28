package com.example.alavishop.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alavishop.R;
import com.example.alavishop.adapter.HorizontalProductAdapter;
import com.example.alavishop.databinding.FragmentCategoryBinding;
import com.example.alavishop.databinding.FragmentListOfCategoryBinding;
import com.example.alavishop.network.NetworkParams;
import com.example.alavishop.networkmodel.product.ProductResponse;
import com.example.alavishop.viewmodel.ShopViewModel;

import java.util.List;


public class ListOfCategoryFragment extends Fragment {
    public static final String ARGS_CATEGORY = "argsCategory";
    private FragmentListOfCategoryBinding mBinding;
    private int mCategoryId;
    private ShopViewModel mShopViewModel;
    private int productListPage = 1;
    HorizontalProductAdapter mAdapter;

    private boolean isListEmpty=false;


    public ListOfCategoryFragment() {
        // Required empty public constructor
    }


    public static ListOfCategoryFragment newInstance(int categoryId) {
        ListOfCategoryFragment fragment = new ListOfCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(ARGS_CATEGORY, categoryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mCategoryId = getArguments().getInt(ARGS_CATEGORY);
        } else {
            mCategoryId = 0;
        }

        mShopViewModel = new ViewModelProvider(this).get(ShopViewModel.class);
        mShopViewModel.fetchSortedProductListWithCategoryAsync(mCategoryId
                , NetworkParams.OrderTag.MOST_NEWEST_PRODUCT
                , "desc"
                , ""
                , productListPage);
        setObserver();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater
                , R.layout.fragment_list_of_category
                , container
                , false);
        return mBinding.getRoot();
    }

    private void initRecyclerView(List<ProductResponse> responses) {
        if (mAdapter == null) {
            mAdapter = new HorizontalProductAdapter(responses, getActivity());
            mBinding.productsListRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == responses.size() - 1) {
                        if (isListEmpty) return;
                        mShopViewModel.fetchSortedProductListWithCategoryAsync(mCategoryId
                                , NetworkParams.OrderTag.MOST_NEWEST_PRODUCT
                                , "desc"
                                , ""
                                , ++productListPage);
                    }
                }
            });
            mBinding.productsListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            mBinding.productsListRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setProductList(responses);
            mAdapter.notifyDataSetChanged();
        }
        if (mAdapter.getProductsList().isEmpty()) {
            mBinding.emptyList.setVisibility(View.VISIBLE);
        } else {
            mBinding.emptyList.setVisibility(View.GONE);
        }

    }

    private void setObserver() {
        mShopViewModel.getSortProductsListMutableLiveDataWithCategory().observe(this
                , productResponses -> {
                    if (productResponses.isEmpty()){
                        isListEmpty=true;
                    }
                    initRecyclerView(productResponses);

                });
    }


}
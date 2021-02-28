package com.example.alavishop.adapter;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alavishop.R;
import com.example.alavishop.databinding.ProductsListItemBinding;
import com.example.alavishop.networkmodel.product.ProductResponse;
import com.example.alavishop.view.activity.ProductDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HorizontalProductAdapter extends RecyclerView.Adapter<HorizontalProductAdapter.ViewHolder> {

    private List<ProductResponse> mProductResponses;
    private Context mContext;
    private ProductsListItemBinding mBinding;

    public HorizontalProductAdapter(List<ProductResponse> productsList, Context context) {
        this.mProductResponses = productsList;
        this.mContext = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.products_list_item
                ,parent
                ,false);
        return new ViewHolder();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       ProductResponse productResponse=mProductResponses.get(position);
       holder.bindProductItem(productResponse);

    }

    @Override
    public int getItemCount() {
        return mProductResponses.size();
    }

    public void setProductList(List<ProductResponse> responses) {
        mProductResponses.addAll(responses);
        //mProductResponses=responses;
    }

    public List<ProductResponse>  getProductsList() {
        return mProductResponses;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ProductResponse mProduct;

        public ViewHolder() {
            super(mBinding.getRoot());
            mBinding.getRoot().setOnClickListener(view -> {
                mContext.startActivity(ProductDetailActivity.newIntent(mContext,mProduct));
            });

        }
        public void bindProductItem(ProductResponse response){
            mProduct=response;
            Picasso.get().load(response.getImages().get(0).getSrc()).
                    placeholder(R.drawable.ic_shopping_cart).into(mBinding.productImg);

            mBinding.titleProduct.setText(response.getName());
            if (!response.getShortDescription().isEmpty()){
                mBinding.shortDescription.setVisibility(View.VISIBLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    mBinding.shortDescription.setText(Html.fromHtml(response.getShortDescription(), Html.FROM_HTML_MODE_COMPACT));
                } else {
                    mBinding.shortDescription.setText(Html.fromHtml(response.getShortDescription()));
                }
            }else mBinding.shortDescription.setVisibility(View.INVISIBLE);



            mBinding.titleProduct.setText(response.getName());

            String str = String.format("%,d",Integer.parseInt(mProduct.getPrice()));

            mBinding.salePrice.setText(str   + " تومان");


        }
    }
}

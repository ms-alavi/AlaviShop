package com.example.alavishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alavishop.R;
import com.example.alavishop.databinding.RawOfListShopAdapterBinding;
import com.example.alavishop.model.product.Product;
import com.example.alavishop.networkmodel.product.WebserviceProductModel;
import com.example.alavishop.view.activity.ProductDetailActivity;
import com.example.alavishop.viewmodel.ProductViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopHolder> {
    private List<WebserviceProductModel> mProducts;
    private final Context mContext;

    public ShopAdapter(List<WebserviceProductModel> products, Context context) {
        mProducts = products;
        mContext = context;
    }

    @NonNull
    @Override
    public ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RawOfListShopAdapterBinding rawOfListBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext)
                , R.layout.raw_of_list_shop_adapter,
                parent,
                false);

        return new ShopHolder(rawOfListBinding, mProducts);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopHolder holder, int position) {
        WebserviceProductModel product = mProducts.get(position);
        holder.bindProductItem(product, position);

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ShopHolder extends RecyclerView.ViewHolder {
        private RawOfListShopAdapterBinding mRawOfListBinding;
        private WebserviceProductModel mProduct;

        public ShopHolder(@NonNull RawOfListShopAdapterBinding binding, List<WebserviceProductModel> products) {
            super(binding.getRoot());
            mRawOfListBinding = binding;
            mRawOfListBinding.setProductViewModel(new ProductViewModel(mProduct));
            mRawOfListBinding.getRoot()
                    .setOnClickListener(v -> mContext.startActivity(ProductDetailActivity
                            .newIntent(mContext,mProduct)));
        }


        public void bindProductItem(WebserviceProductModel product, int position) {
            mProduct = product;

            mRawOfListBinding.getProductViewModel().setProduct(mProduct);
            Picasso.get()
                    .load(product.getImages().get(0).getSrc())
                    .placeholder(R.drawable.ic_shopping_cart)
                    .into(mRawOfListBinding.imgProduct);


        }

    }
}

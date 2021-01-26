package com.example.alavishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alavishop.R;
import com.example.alavishop.databinding.RawOfListShopAdapterBinding;
import com.example.alavishop.networkmodel.product.ProductResponse;
import com.example.alavishop.view.activity.ProductDetailActivity;
import com.example.alavishop.viewmodel.ProductViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VerticalProductAdapter extends RecyclerView.Adapter<VerticalProductAdapter.ShopHolder> {
    private List<ProductResponse> mProducts;
    private final Context mContext;

    public VerticalProductAdapter(List<ProductResponse> products, Context context) {
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
        ProductResponse product = mProducts.get(position);
        holder.bindProductItem(product, position);

    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    public class ShopHolder extends RecyclerView.ViewHolder {
        private RawOfListShopAdapterBinding mRawOfListBinding;
        private ProductResponse mProduct;

        public ShopHolder(@NonNull RawOfListShopAdapterBinding binding, List<ProductResponse> products) {
            super(binding.getRoot());
            mRawOfListBinding = binding;
            mRawOfListBinding.setProductViewModel(new ProductViewModel(mProduct));
            mRawOfListBinding.getRoot()
                    .setOnClickListener(v -> mContext.startActivity(ProductDetailActivity
                            .newIntent(mContext,mProduct)));
        }


        public void bindProductItem(ProductResponse product, int position) {
            mProduct = product;

            mRawOfListBinding.getProductViewModel().setProduct(mProduct);
            mRawOfListBinding.txtName.setText(mProduct.getName());
            mRawOfListBinding.txtPrice.setText(mProduct.getPrice());
            Picasso.get()
                    .load(product.getImages().get(0).getSrc())
                    .placeholder(R.drawable.ic_shopping_cart)
                    .into(mRawOfListBinding.imgProduct);


        }

    }
}

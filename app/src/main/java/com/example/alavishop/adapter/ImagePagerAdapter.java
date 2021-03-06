package com.example.alavishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.example.alavishop.R;
import com.example.alavishop.databinding.ImagePagerBinding;
import com.example.alavishop.model.product.ProductImage;
import com.example.alavishop.networkmodel.product.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImagePagerAdapter extends PagerAdapter {
    private  Context mContext;
    private List<Image> mImages;
    private ImagePagerBinding mBinding;

    public ImagePagerAdapter(Context context, List<Image> images) {
        mContext=context;
        mImages=images;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.image_pager
                ,container,false );
        Picasso.get()
                .load(mImages.get(position).getSrc())
                .placeholder(R.drawable.ic_shopping_cart)
                .into(mBinding.imgProduct);
        container.addView(mBinding.getRoot());
        return mBinding.getRoot();

    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
}

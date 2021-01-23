package com.example.alavishop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alavishop.R;

import com.example.alavishop.databinding.RawOfListBindingCategoryAdapterBinding;
import com.example.alavishop.model.Category.Category;
import com.example.alavishop.model.Category.CategoryProduct;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {


        private List<Category> mCategories;
        private final Context mContext;

        public CategoryAdapter(List<Category> categories, Context context) {
            mCategories = categories;
            mContext = context;
        }

        @NonNull
        @Override
        public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            RawOfListBindingCategoryAdapterBinding binding=DataBindingUtil.inflate
                    (LayoutInflater.from(mContext),
                   R.layout.raw_of_list_binding_category_adapter,
                    parent,
                    false);

            return new CategoryHolder(binding,mCategories);
        }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = mCategories.get(position);
        holder.bindProductItem(category);
    }


        @Override
        public int getItemCount() {
            return mCategories.size();
        }

        public class CategoryHolder extends RecyclerView.ViewHolder {
            private RawOfListBindingCategoryAdapterBinding mBinding;
            private Category mCategory;

            public CategoryHolder(RawOfListBindingCategoryAdapterBinding binding,List<Category> categories) {
                super(binding.getRoot());
                mBinding=binding;

            }


            public void bindProductItem(Category category) {
                mCategory = category;

                Picasso.get()
                        .load(category.getImage().getUrl())
                        .placeholder(R.drawable.ic_shopping_cart)
                        .into(mBinding.imgCategory);


            }

        }
    }



package com.example.alavishop.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alavishop.R;


public class ListOfCategoryFragment extends Fragment {



    public ListOfCategoryFragment() {
        // Required empty public constructor
    }


    public static ListOfCategoryFragment newInstance() {
        ListOfCategoryFragment fragment = new ListOfCategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_category, container, false);
    }
}
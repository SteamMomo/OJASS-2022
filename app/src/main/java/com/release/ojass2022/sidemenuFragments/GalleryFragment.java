package com.release.ojass2022.sidemenuFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.ojass2022.GalleryItemAdapter;
import com.release.ojass2022.GalleryItemModel;
import com.release.ojass2022.MainViewModel;
import com.release.ojass2022.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }
    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gallery,container,false);
        configureRecyclerView(view);
        return view;
    }

    private void configureRecyclerView(View view){
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        ArrayList<GalleryItemModel> gallery = viewModel.getGallery();
        GalleryItemAdapter galleryItemAdapter = new GalleryItemAdapter(gallery,requireContext());
        RecyclerView recyclerView = view.findViewById(R.id.galleryRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(),2));
        recyclerView.setAdapter(galleryItemAdapter);

    }
}
package com.release.ojass2022.sidemenuFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.ojass2022.MainViewModel;
import com.release.ojass2022.PostItemAdapter;
import com.release.ojass2022.PostItemModel;
import com.release.ojass2022.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        configureRecyclerView();

        return view;
    }

    private void configureRecyclerView() {
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        ArrayList<PostItemModel> posts = viewModel.getPosts();
        PostItemAdapter postItemAdapter = new PostItemAdapter(posts, requireContext());
        RecyclerView recyclerView = view.findViewById(R.id.postRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postItemAdapter);
    }
}
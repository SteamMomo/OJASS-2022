package com.release.ojass2022.sidemenuFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.ojass2022.EventItemAdapter;
import com.release.ojass2022.MainViewModel;
import com.release.ojass2022.PostItemModel;
import com.release.ojass2022.R;
import com.release.ojass2022.myTeams_Developers.MyTeamsAdapter;
import com.release.ojass2022.myTeams_Developers.MyTeamsModel;

import java.util.ArrayList;


public class DevelopersFragment extends Fragment {

    public DevelopersFragment() {
        // Required empty public constructor


    }


    public static DevelopersFragment newInstance(String param1, String param2) {
       DevelopersFragment developersFragment = new DevelopersFragment();
       return developersFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_developers, container, false);
        configureRecyclerView();
        return view;
    }

    private void configureRecyclerView() {
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        ArrayList<MyTeamsModel> myteams = viewModel.getTeams();
        MyTeamsAdapter myTeamsAdapter = new MyTeamsAdapter(myteams, requireContext());
        RecyclerView recyclerView = view.findViewById(R.id.eventRecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()
                , LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myTeamsAdapter);
    }
}
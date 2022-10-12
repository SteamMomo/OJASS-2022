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
import com.release.ojass2022.PostItemAdapter;
import com.release.ojass2022.PostItemModel;
import com.release.ojass2022.R;

import java.util.ArrayList;

public class EventsFragment extends Fragment {
    public EventsFragment() {
    }
    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_events, container, false);
        configureRecyclerView();
        return view;
    }

    private void configureRecyclerView() {
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        ArrayList<PostItemModel> events = viewModel.getEvents();
        EventItemAdapter eventItemAdapter = new EventItemAdapter(events, requireContext());
        RecyclerView recyclerView = view.findViewById(R.id.eventRecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()
                , LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(eventItemAdapter);
    }
}
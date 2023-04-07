package com.release.ojass2022.sidemenuFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.release.ojass2022.EventItemAdapter;
import com.release.ojass2022.EventItemModel;
import com.release.ojass2022.MainViewModel;
import com.release.ojass2022.R;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    ArrayList<EventItemModel> events = new ArrayList<>();
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
        RecyclerView recyclerView = view.findViewById(R.id.eventRecyclerview);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("main_events");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        events = new ArrayList<>();
        EventItemAdapter adapter = new EventItemAdapter(events, getContext());
        recyclerView.setAdapter(adapter);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap: snapshot.getChildren()){
                    EventItemModel model = snap.getValue(EventItemModel.class);
                    events.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Error in fetching events.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
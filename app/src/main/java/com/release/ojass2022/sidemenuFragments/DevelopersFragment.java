package com.release.ojass2022.sidemenuFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.release.ojass2022.R;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_developers, container, false);
    }
}
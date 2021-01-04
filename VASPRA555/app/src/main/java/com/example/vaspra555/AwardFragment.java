package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AwardFragment extends Fragment {
    ImageButton image_back;
    public static AwardFragment newInstance() {
        return new AwardFragment();
    }


    public AwardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_award, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);

        ProgressBar progressBarCustom = (ProgressBar)view.findViewById(R.id.progressBar);
        progressBarCustom.setProgress(50000);

    }

}

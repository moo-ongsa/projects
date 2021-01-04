package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    Button btn_Bath,btn_Project,btn_Sub,btn_back;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn_Bath = (Button) view.findViewById(R.id.btn_historybath);
        btn_Project = (Button) view.findViewById(R.id.btn_historyproject);
        btn_Sub = (Button) view.findViewById(R.id.btn_historysub);

        btn_Bath.setOnClickListener(onClickOperHistoryBath);
        btn_Project.setOnClickListener(onClickOperHistoryProject);
        btn_Sub.setOnClickListener(onClickOperHistorySub);
    }
    private View.OnClickListener onClickOperHistoryBath = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Layout_History, HistoryBahtFragment.newInstance())
                    .commit();
        }
    };
    private View.OnClickListener onClickOperHistoryProject = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Layout_History,HistoryProjectFragment.newInstance())
                    .commit();
        }
    };    private View.OnClickListener onClickOperHistorySub = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.Layout_History,HistorySubFragment.newInstance())
                    .commit();
        }
    };
}

package com.example.vaspra555;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.vaspra555.R;
import com.example.vaspra555.app.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThankYouFragment extends Fragment {

    private Button btn_backtohome_thank;
    TextView tvThankyou;
    public static ThankYouFragment newInstance() {return  new ThankYouFragment();}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thank_you, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvThankyou = view.findViewById(R.id.tvThankyou);
        tvThankyou.setText("ขอบคุณคุณ "+ User.getName()+" ที่เลือกทำบุญกับ VASPRA ท่านสามารถตรวจสอบรายละเอียด การชำระเงินและทำบุญได้ที่ประวัติการทำบุญ");
        btn_backtohome_thank = (Button) view.findViewById (R.id.btn_backtohome_thank);
        btn_backtohome_thank.setOnClickListener (new OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent (getActivity (),MainActivity.class);
                startActivity (myIntent);
            }
        });

    }




}

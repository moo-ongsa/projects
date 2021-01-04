package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MonthlyFragment extends Fragment {

    ImageButton btn_back;
    Button btn_submit150,btn_submit300,btn_submit500,btn_submit1000;
    public static MonthlyFragment newInstance() {
        return new MonthlyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                            @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_monthly, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btn_back = (ImageButton) view.findViewById(R.id.btn_back_monthly);
        btn_submit150 = (Button) view.findViewById(R.id.btn_donatesubmitmonthly150);
        btn_submit300 = (Button) view.findViewById(R.id.btn_donatesubmitmonthly300);
        btn_submit500 = (Button) view.findViewById(R.id.btn_donatesubmitmonthly500);
        btn_submit1000 = (Button) view.findViewById(R.id.btn_donatesubmitmonthly1000);
        // edit text money amount

        paypalsumbmit();

        btn_back.setOnClickListener(onCloseClickListener);

    }
    private View.OnClickListener onCloseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .popBackStack();
        }
    };
    private void paypalsumbmit() {

        btn_submit150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext() ,"ระบบยังไม่เปิดใช้งาน", Toast.LENGTH_LONG).show();
                String amount = "150";
                if (amount.isEmpty()) {
                    Toast.makeText(getActivity(), "กรุณาใส่จำนวนเงิน", Toast.LENGTH_SHORT).show();
                }else
                {
                    PaypalFragment paypalFragment = new PaypalFragment();
                 /*  getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                            .addToBackStack("tag")
                            .replace(R.id.layout_paypal, PaypalFragment.newInstance(),"paypal")
                            .addToBackStack(null)
                            .commit();*/
                }
            }   // onclick
        });
        btn_submit300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = "300";
                Toast.makeText(getActivity().getApplicationContext() ,"ระบบยังไม่เปิดใช้งาน", Toast.LENGTH_LONG).show();

                if (amount.isEmpty()) {
                    Toast.makeText(getActivity(), "กรุณาใส่จำนวนเงิน", Toast.LENGTH_SHORT).show();
                }else
                {
                    PaypalFragment paypalFragment = new PaypalFragment();
                 /*  getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                            .addToBackStack("tag")
                            .replace(R.id.layout_paypal, PaypalFragment.newInstance(),"paypal")
                            .addToBackStack(null)
                            .commit();*/
                }
            }   // onclick
        });
        btn_submit500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amount = "500";
                Toast.makeText(getActivity().getApplicationContext() ,"ระบบยังไม่เปิดใช้งาน", Toast.LENGTH_LONG).show();

                if (amount.isEmpty()) {
                    Toast.makeText(getActivity(), "กรุณาใส่จำนวนเงิน", Toast.LENGTH_SHORT).show();
                }else
                {/*
                    PaypalFragment paypalFragment = new PaypalFragment();
                   getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                            .addToBackStack("tag")
                            .replace(R.id.layout_paypal, PaypalFragment.newInstance(),"paypal")
                            .addToBackStack(null)
                            .commit();*/
                }
            }   // onclick
        });
        btn_submit1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext() ,"ระบบยังไม่เปิดใช้งาน", Toast.LENGTH_LONG).show();
                String amount = "1000";
                if (amount.isEmpty()) {
                    Toast.makeText(getActivity(), "กรุณาใส่จำนวนเงิน", Toast.LENGTH_SHORT).show();
                }else
                {
                 /*  getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                            .addToBackStack("tag")
                            .replace(R.id.layout_paypal, PaypalFragment.newInstance(),"paypal")
                            .addToBackStack(null)
                            .commit();*/
                }
            }   // onclick
        });
    }
}

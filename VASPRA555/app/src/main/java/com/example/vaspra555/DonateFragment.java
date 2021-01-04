package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonateFragment extends Fragment {

    Button btn_donateBath,btn_donateConstruct,btn_donateFish,btn_donateCow,btn_donateCoffin,btn_donateMonthly;
    public static DonateFragment newInstance() {return  new DonateFragment();}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donate, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btn_donateConstruct = (Button) view.findViewById(R.id.btn_donate_construct);
        btn_donateConstruct.setOnClickListener(onClickOpenConstruct);
        btn_donateCoffin= (Button)view.findViewById(R.id.btn_donate_coffin);
        btn_donateCoffin.setOnClickListener(onClickOpenCoffin);
        btn_donateFish = (Button) view.findViewById(R.id.btn_donate_fish);
        btn_donateFish.setOnClickListener(onClickOpenFish);
        btn_donateCow = (Button) view.findViewById(R.id.btn_donate_cow);
        btn_donateCow.setOnClickListener(onClickOpenCow);
        btn_donateMonthly = (Button) view.findViewById(R.id.btn_donate_monthly);
        btn_donateMonthly.setOnClickListener(onClickOpenMonthly);
        btn_donateBath = (Button) view.findViewById(R.id.btn_donate_donate);
        btn_donateBath.setOnClickListener(onClickOpenBath);
    }
    private View.OnClickListener onClickOpenConstruct = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout,ConstructFragment.newInstance())
                    .addToBackStack("tag")
                    .commit();
        }
    };
    private View.OnClickListener onClickOpenCoffin = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout,CoffinFragment.newInstance())
                    .addToBackStack("tag")
                    .commit();
        }
    };
    private View.OnClickListener onClickOpenFish = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout,FishFragment .newInstance())
                    .addToBackStack("tag")
                    .commit();
        }
    };
    private View.OnClickListener onClickOpenCow = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout,CowFragment .newInstance())
                    .addToBackStack("tag")
                    .commit();
        }
    };
    private View.OnClickListener onClickOpenMonthly = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout,MonthlyFragment .newInstance())
                    .addToBackStack("tag")
                    .commit();
        }
    };
    private View.OnClickListener onClickOpenBath = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, DonationBahtFragment.newInstance())
                    .addToBackStack("tag")
                    .commit();
        }
    };
}

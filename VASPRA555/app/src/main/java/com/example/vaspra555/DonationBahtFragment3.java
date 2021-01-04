package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.vaspra555.List.HistoProject;
import com.example.vaspra555.List.Item;
import com.example.vaspra555.List.RecycleViewDonationItem;
import com.example.vaspra555.List.RycycleViewHistoProject;
import com.example.vaspra555.app.Cart;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonationBahtFragment3 extends Fragment {
    List<Item> listCont = new ArrayList<>();
    RecyclerView recyclerView;
    int item1,item2,item3,item4,item5,item6,item7,item8;
    TextView moneyAmount2,donateToVat;
    ImageButton btn_back_coffin2;

    public static DonationBahtFragment3 newInstance() { return  new DonationBahtFragment3(); }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_donation_baht3, null, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rcv_item);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        btn_back_coffin2 = (ImageButton)view.findViewById(R.id.btn_back_coffin2);
        btn_back_coffin2.setOnClickListener(onCloseClickListener);
        super.onViewCreated(view, savedInstanceState);
        moneyAmount2 = view.findViewById(R.id.moneyAmount2);
        donateToVat = view.findViewById(R.id.donateToVat);
        int total = Cart.getItem1()*100+Cart.getItem2()*22+Cart.getItem3()*140+Cart.getItem4()*8+Cart.getItem5()*24+Cart.getItem6()*70+Cart.getItem7()*40+Cart.getItem8()*50;
        if(Cart.getItem1() >0){
            listCont.add(new Item("ฉัตรอรุณ",Integer.toString(Cart.getItem1()),Integer.toString(Cart.getItem1()*100)));
        }
        if(Cart.getItem2() >0){
            listCont.add(new Item("เลย์",Integer.toString(Cart.getItem2()),Integer.toString(Cart.getItem2()*22)));
        }
        if(Cart.getItem3() >0){
            listCont.add(new Item("ออร่า",Integer.toString(Cart.getItem3()),Integer.toString(Cart.getItem3()*140)));
        }
        if(Cart.getItem4() >0){
            listCont.add(new Item("มาม่า",Integer.toString(Cart.getItem4()),Integer.toString(Cart.getItem4()*8)));
        }
        if(Cart.getItem5() >0){
            listCont.add(new Item("คอนเน็ตโต้",Integer.toString(Cart.getItem5()),Integer.toString(Cart.getItem5()*24)));
        }
        if(Cart.getItem6() >0){
            listCont.add(new Item("ปีโป้",Integer.toString(Cart.getItem6()),Integer.toString(Cart.getItem6()*70)));
        }
        if(Cart.getItem7() >0){
            listCont.add(new Item("อยัมแบรนด์",Integer.toString(Cart.getItem7()),Integer.toString(Cart.getItem7()*40)));
        }
        if(Cart.getItem8() >0){
            listCont.add(new Item("โปเต้",Integer.toString(Cart.getItem8()),Integer.toString(Cart.getItem8()*50)));
        }

        moneyAmount2.setText(Integer.toString(total)+"บาท");
        donateToVat.setText("ส่งบุญไปที่   "+Cart.getVat());
        RecycleViewDonationItem viewAdapter = new RecycleViewDonationItem(getContext(), listCont);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(viewAdapter);
    }
    private View.OnClickListener onCloseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .popBackStack();
        }
    };
}

package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaspra555.app.Cart;


/**
 * A simple {@link Fragment} subclass.
 */
public class DonationBahtFragment extends Fragment {
    Button bt_donatebahtNext1;
    ImageButton btn_back_coffin2;
    Button btn_minus1,btn_minus2,btn_minus3,btn_minus4,btn_minus5,btn_minus6,btn_minus7,btn_minus8;
    Button btn_plus1,btn_plus2,btn_plus3,btn_plus4,btn_plus5,btn_plus6,btn_plus7,btn_plus8;
    TextView text_count_1,text_count_2,text_count_3,text_count_4,text_count_5,text_count_6,text_count_7,text_count_8;
    int item1 = Cart.getItem1()
            ,item2 = Cart.getItem2()
            ,item3 = Cart.getItem3()
            ,item4 = Cart.getItem4()
            ,item5 = Cart.getItem5()
            ,item6 = Cart.getItem6()
            ,item7 = Cart.getItem7()
            ,item8 = Cart.getItem8();


    public static DonationBahtFragment newInstance() {
        return  new DonationBahtFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donation_baht, container, false);

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        btn_back_coffin2 = (ImageButton)view.findViewById(R.id.btn_back_coffin2);
        btn_back_coffin2.setOnClickListener(onCloseClickListener);

        btn_minus1 = (Button)view.findViewById(R.id.btn_minus_1);
        btn_minus1.setOnClickListener(onClickOpenMinus1);
        btn_plus1 = (Button)view.findViewById(R.id.btn_plus_1);
        btn_plus1.setOnClickListener(onClickOpenPlue1);
        text_count_1 = (TextView)view.findViewById(R.id.text_count_1);
        text_count_1.setText(Integer.toString(item1));

        btn_minus2 = (Button)view.findViewById(R.id.btn_minus_2);
        btn_minus2.setOnClickListener(onClickOpenMinus2);
        btn_plus2 = (Button)view.findViewById(R.id.btn_plus_2);
        btn_plus2.setOnClickListener(onClickOpenPlue2);
        text_count_2 = (TextView)view.findViewById(R.id.text_count_2);
        text_count_2.setText(Integer.toString(item2));

        btn_minus3 = (Button)view.findViewById(R.id.btn_minus_3);
        btn_minus3.setOnClickListener(onClickOpenMinus3);
        btn_plus3 = (Button)view.findViewById(R.id.btn_plus_3);
        btn_plus3.setOnClickListener(onClickOpenPlue3);
        text_count_3 = (TextView)view.findViewById(R.id.text_count_3);
        text_count_3.setText(Integer.toString(item3));

        btn_minus4 = (Button)view.findViewById(R.id.btn_minus_4);
        btn_minus4.setOnClickListener(onClickOpenMinus4);
        btn_plus4 = (Button)view.findViewById(R.id.btn_plus_4);
        btn_plus4.setOnClickListener(onClickOpenPlue4);
        text_count_4 = (TextView)view.findViewById(R.id.text_count_4);
        text_count_4.setText(Integer.toString(item4));

        btn_minus5 = (Button)view.findViewById(R.id.btn_minus_5);
        btn_minus5.setOnClickListener(onClickOpenMinus5);
        btn_plus5 = (Button)view.findViewById(R.id.btn_plus_5);
        btn_plus5.setOnClickListener(onClickOpenPlue5);
        text_count_5 = (TextView)view.findViewById(R.id.text_count_5);
        text_count_5.setText(Integer.toString(item5));

        btn_minus6 = (Button)view.findViewById(R.id.btn_minus_6);
        btn_minus6.setOnClickListener(onClickOpenMinus6);
        btn_plus6 = (Button)view.findViewById(R.id.btn_plus_6);
        btn_plus6.setOnClickListener(onClickOpenPlue6);
        text_count_6 = (TextView)view.findViewById(R.id.text_count_6);
        text_count_6.setText(Integer.toString(item6));

        btn_minus7 = (Button)view.findViewById(R.id.btn_minus_7);
        btn_minus7.setOnClickListener(onClickOpenMinus7);
        btn_plus7 = (Button)view.findViewById(R.id.btn_plus_7);
        btn_plus7.setOnClickListener(onClickOpenPlue7);
        text_count_7 = (TextView)view.findViewById(R.id.text_count_7);
        text_count_7.setText(Integer.toString(item7));

        btn_minus8 = (Button)view.findViewById(R.id.btn_minus_8);
        btn_minus8.setOnClickListener(onClickOpenMinus8);
        btn_plus8 = (Button)view.findViewById(R.id.btn_plus_8);
        btn_plus8.setOnClickListener(onClickOpenPlue8);
        text_count_8 = (TextView)view.findViewById(R.id.text_count_8);
        text_count_8.setText(Integer.toString(item8));

        bt_donatebahtNext1 = (Button)view.findViewById(R.id.bt_donatebahtNext1);
        bt_donatebahtNext1.setOnClickListener(onClickOpenNext);
    }
    private View.OnClickListener onClickOpenNext = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item1== 0 && item2==0 && item3==0 && item4 ==0 && item5==0 && item6==0&&item7==0&&item8==0 ){
                Toast.makeText(getActivity().getApplicationContext() ,"กรุณาเลือกสินค้า", Toast.LENGTH_LONG).show();

            }
            else{
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, DonationBahtFragment2.newInstance())
                    .addToBackStack("tag")
                    .commit();
            }
        }
    };

    private View.OnClickListener onClickOpenMinus1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           if(item1==0){
           }
           else{
               item1=item1-1;
               Cart.setItem1(item1);
               text_count_1.setText(Integer.toString(item1));
           }
        }
    };
    private View.OnClickListener onClickOpenPlue1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item1=item1+1;
            Cart.setItem1(item1);
            text_count_1.setText(Integer.toString(item1));
        }
    };

    private View.OnClickListener onClickOpenMinus2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item2==0){
            }
            else{
                item2=item2-1;
                Cart.setItem2(item2);
                text_count_2.setText(Integer.toString(item2));
            }
        }
    };
    private View.OnClickListener onClickOpenPlue2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item2=item2+1;
            Cart.setItem2(item2);
            text_count_2.setText(Integer.toString(item2));
        }
    };

    private View.OnClickListener onClickOpenMinus3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item3==0){
            }
            else{
                item3=item3-1;
                Cart.setItem3(item3);
                text_count_3.setText(Integer.toString(item3));
            }
        }
    };
    private View.OnClickListener onClickOpenPlue3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item3=item3+1;
            Cart.setItem3(item3);
            text_count_3.setText(Integer.toString(item3));
        }
    };

    private View.OnClickListener onClickOpenMinus4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item4==0){
            }
            else{
                item4=item4-1;
                Cart.setItem4(item4);
                text_count_4.setText(Integer.toString(item4));
            }
        }
    };
    private View.OnClickListener onClickOpenPlue4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item4=item4+1;
            Cart.setItem4(item4);
            text_count_4.setText(Integer.toString(item4));
        }
    };

    private View.OnClickListener onClickOpenMinus5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item5==0){
            }
            else{
                item5=item5-1;
                Cart.setItem5(item5);
                text_count_5.setText(Integer.toString(item5));
            }
        }
    };
    private View.OnClickListener onClickOpenPlue5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item5=item5+1;
            Cart.setItem5(item5);
            text_count_5.setText(Integer.toString(item5));
        }
    };

    private View.OnClickListener onClickOpenMinus6 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item6==0){
            }
            else{
                item6=item6-1;
                Cart.setItem6(item6);
                text_count_6.setText(Integer.toString(item6));
            }
        }
    };
    private View.OnClickListener onClickOpenPlue6 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item6=item6+1;
            Cart.setItem6(item6);
            text_count_6.setText(Integer.toString(item6));
        }
    };

    private View.OnClickListener onClickOpenMinus7 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item7==0){
            }
            else{
                item7=item7-1;
                Cart.setItem7(item7);
                text_count_7.setText(Integer.toString(item7));
            }
        }
    };
    private View.OnClickListener onClickOpenPlue7 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item7=item7+1;
            Cart.setItem7(item7);
            text_count_7.setText(Integer.toString(item7));
        }
    };

    private View.OnClickListener onClickOpenMinus8 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(item8==0){
            }
            else{
                item8=item8-1;
                Cart.setItem8(item8);
                text_count_8.setText(Integer.toString(item8));
            }
        }
    };
    private View.OnClickListener onClickOpenPlue8 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            item8=item8+1;
            Cart.setItem8(item8);
            text_count_8.setText(Integer.toString(item8));
        }
    };

    private View.OnClickListener onCloseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .popBackStack();
        }
    };
}



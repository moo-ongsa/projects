package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vaspra555.app.Cart;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */


public class DonationBahtFragment2 extends Fragment implements  OnMapReadyCallback{

    MapView mMapView;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    Spinner vat;
    LatLng vatLatlng;
    TextView tv_vatDetail ;
    Button bt_donatebahtNext2;
    ImageButton btn_back_coffin2;


    public static DonationBahtFragment2 newInstance() { return  new DonationBahtFragment2(); }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_donation_baht2, null, false);
       mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapView);
       if(mapFragment==null){
           FragmentManager fm = getFragmentManager();
           FragmentTransaction ft = fm.beginTransaction();
           mapFragment = SupportMapFragment.newInstance();
           ft.replace(R.id.mapView,mapFragment).commit();
       }
       mapFragment.getMapAsync( this);

        return rootView;
    }
    @Override
    public void onViewCreated  (View view, @Nullable Bundle savedInstanceState){
        btn_back_coffin2 = (ImageButton)view.findViewById(R.id.btn_back_coffin2);
        btn_back_coffin2.setOnClickListener(onCloseClickListener);
        tv_vatDetail  = (TextView)view.findViewById(R.id.tv_vatDetail);
        bt_donatebahtNext2 = (Button)view.findViewById(R.id.bt_donatebahtNext2);
        bt_donatebahtNext2.setOnClickListener(onClickOpenNext);
        vat = (Spinner)view.findViewById(R.id.spn_vat);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.vat));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(vat.getSelectedItemPosition() == 0){
                    tv_vatDetail.setText("35 เอกชัย 43 แขวง บางขุนเทียน เขตจอมทอง กรุงเทพมหานคร 10150");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.6823622,100.4457805);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดสิงห์"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 1){
                    tv_vatDetail.setText("วัดป่าอยู่ในกรุงเทพ");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.653030, 100.491503);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดป่า"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 2){
                    tv_vatDetail.setText("วัดวาอารามอยู่ใยกรุงเทพ");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.624690, 100.469197);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดวาอาราม"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 3){
                    tv_vatDetail.setText("วัดไทยอยู่ในกรุงเทพ");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.573423, 100.425171);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดไทย"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 4){
                    tv_vatDetail.setText("วัดไชยอยู่ในกรุงเทพ");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.590706, 100.443437);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดไชย"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 5){
                    tv_vatDetail.setText("9 หมู่ 5 ซอยประชาอุทิศ 84 แขวงทุ่งครุ เขตทุ่งครุ กรุงเทพมหานคร");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.618972, 100.510809);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดทุ่งครุ"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 6){
                    tv_vatDetail.setText("วัดค่าอยู่ในกรุงเทพ");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.572549, 100.463521);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดค่า"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 7){
                    tv_vatDetail.setText("วัดยูนิคอร์นอยู่ในกรุงเทพ");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.551875, 100.503447);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดยูนิคอร์น"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }
                else if(vat.getSelectedItemPosition() == 8){
                    tv_vatDetail.setText("วัดน่าอยู่ในกรุงเทพ");
                    Cart.setVat(vat.getSelectedItem().toString());
                    vatLatlng = new LatLng(13.650735, 100.501020);
                    mMap.addMarker(new MarkerOptions().position(vatLatlng).title("วัดน่า"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        vat.setAdapter(myAdapter);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Do stuff with the map here!
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        vatLatlng = new LatLng(13.6823622,100.4457805);
        mMap.addMarker(new MarkerOptions().position(vatLatlng).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vatLatlng,15));
    }

    private View.OnClickListener onClickOpenNext = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, DonationBahtFragment3.newInstance())
                    .addToBackStack("tag")
                    .commit();
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



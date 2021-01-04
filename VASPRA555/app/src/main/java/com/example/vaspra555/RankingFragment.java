package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.vaspra555.List.HistoProject;
import com.example.vaspra555.List.RycycleViewHistoProject;
import com.example.vaspra555.app.AppController;
import com.example.vaspra555.app.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment {

    TextView tv_number, tv_number1, tv_number2, tv_number3, tv_number4, tv_number5, tv_number6, tv_number7, tv_number8, tv_number9, tv_number10;
    TextView tv_name, tv_name1, tv_name2, tv_name3, tv_name4, tv_name5, tv_name6, tv_name7, tv_name8, tv_name9, tv_name10;
    TextView tv_Tambun, tv_Tambun1, tv_Tambun2, tv_Tambun3, tv_Tambun4, tv_Tambun5, tv_Tambun6, tv_Tambun7, tv_Tambun8, tv_Tambun9,tv_Tambun10 ;
    CircleImageView pic_profile, pic_profile1, pic_profile2, pic_profile3, pic_profile4, pic_profile5, pic_profile6, pic_profile7, pic_profile8, pic_profile9, pic_profile10;
    private String url = Server.URL + "vaspraPHP/ranking.php";


    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ranking, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated( view,savedInstanceState);

        tv_number = (TextView)view.findViewById(R.id.number);
        tv_number1 = (TextView)view.findViewById(R.id.number_1);
        tv_number2 = (TextView)view.findViewById(R.id.number_2);
        tv_number3 = (TextView)view.findViewById(R.id.number_3);
        tv_number4 = (TextView)view.findViewById(R.id.number_4);
        tv_number5 = (TextView)view.findViewById(R.id.number_5);
        tv_number6 = (TextView)view.findViewById(R.id.number_6);
        tv_number7 = (TextView)view.findViewById(R.id.number_7);
        tv_number8 = (TextView)view.findViewById(R.id.number_8);
        tv_number9 = (TextView)view.findViewById(R.id.number_9);
        tv_number10 = (TextView)view.findViewById(R.id.number_10);

        tv_name = (TextView)view.findViewById(R.id.name);
        tv_name1 = (TextView)view.findViewById(R.id.name_1);
        tv_name2 = (TextView)view.findViewById(R.id.name_2);
        tv_name3 = (TextView)view.findViewById(R.id.name_3);
        tv_name4 = (TextView)view.findViewById(R.id.name_4);
        tv_name5 = (TextView)view.findViewById(R.id.name_5);
        tv_name6 = (TextView)view.findViewById(R.id.name_6);
        tv_name7 = (TextView)view.findViewById(R.id.name_7);
        tv_name8 = (TextView)view.findViewById(R.id.name_8);
        tv_name9 = (TextView)view.findViewById(R.id.name_9);
        tv_name10 = (TextView)view.findViewById(R.id.name_10);

        tv_Tambun = (TextView)view.findViewById(R.id.tambun);
        tv_Tambun1 = (TextView)view.findViewById(R.id.tambun_1);
        tv_Tambun2 = (TextView)view.findViewById(R.id.tambun_2);
        tv_Tambun3 = (TextView)view.findViewById(R.id.tambun_3);
        tv_Tambun4 = (TextView)view.findViewById(R.id.tambun_4);
        tv_Tambun5 = (TextView)view.findViewById(R.id.tambun_5);
        tv_Tambun6 = (TextView)view.findViewById(R.id.tambun_6);
        tv_Tambun7 = (TextView)view.findViewById(R.id.tambun_7);
        tv_Tambun8 = (TextView)view.findViewById(R.id.tambun_8);
        tv_Tambun9 = (TextView)view.findViewById(R.id.tambun_9);
        tv_Tambun10 = (TextView)view.findViewById(R.id.tambun_10);

        pic_profile = (CircleImageView)view.findViewById(R.id.pic_profile);
        pic_profile1 = (CircleImageView)view.findViewById(R.id.pic_profile_1);
        pic_profile2 = (CircleImageView)view.findViewById(R.id.pic_profile_2);
        pic_profile3 = (CircleImageView)view.findViewById(R.id.pic_profile_3);
        pic_profile4 = (CircleImageView)view.findViewById(R.id.pic_profile_4);
        pic_profile5 = (CircleImageView)view.findViewById(R.id.pic_profile_5);
        pic_profile6 = (CircleImageView)view.findViewById(R.id.pic_profile_6);
        pic_profile7 = (CircleImageView)view.findViewById(R.id.pic_profile_7);
        pic_profile8 = (CircleImageView)view.findViewById(R.id.pic_profile_8);
        pic_profile9 = (CircleImageView)view.findViewById(R.id.pic_profile_9);
        pic_profile10 = (CircleImageView)view.findViewById(R.id.pic_profile_10);



        final JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.POST, url,null,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                ArrayList listNo = new ArrayList()
                        ,listFirstname = new ArrayList()
                        ,listLastname= new ArrayList()
                        ,listTambun= new ArrayList();
                try {
                    for(int i=0;i<response.length();i++) {
                        // Get current json object
                        JSONObject jObj = response.getJSONObject(i);
                        // Get the current student (json object) data
                        String No = jObj.getString("NO");
                        String firstname = jObj.getString("User_Firstname");
                        String lastname = jObj.getString("User_Lastname");
                        String tambun = jObj.getString("User_Tambun");
                        String userId = jObj.getString("User_ID");

                        listNo.add(No);
                        listFirstname.add(firstname);
                        listLastname.add(lastname);
                        listTambun.add(tambun);
                        if(userId.equals(User.getUser())==true){
                            tv_number.setText(listNo.get(i).toString());
                            tv_name.setText( listFirstname.get(i).toString()+" "+listLastname.get(0));
                            tv_Tambun.setText(listTambun.get(i).toString()+" แต้มบุญ");
                            pic_profile.setImageResource(R.drawable.profile);
                        }

                    }
                    tv_name1.setText( listFirstname.get(0).toString()+" "+listLastname.get(0));
                    tv_Tambun1.setText(listTambun.get(0).toString()+" แต้มบุญ");
                    pic_profile1.setImageResource(R.drawable.profile);
                    tv_name2.setText( listFirstname.get(1).toString()+" "+listLastname.get(1));
                    tv_Tambun2.setText(listTambun.get(1).toString()+" แต้มบุญ");
                    pic_profile2.setImageResource(R.drawable.profile);
                    tv_name3.setText( listFirstname.get(2).toString()+" "+listLastname.get(2));
                    tv_Tambun3.setText(listTambun.get(2).toString()+" แต้มบุญ");
                    pic_profile3.setImageResource(R.drawable.profile);
                    tv_name4.setText( listFirstname.get(3).toString()+" "+listLastname.get(3));
                    tv_Tambun4.setText(listTambun.get(3).toString()+" แต้มบุญ");
                    pic_profile4.setImageResource(R.drawable.profile);
                    tv_name5.setText( listFirstname.get(4).toString()+" "+listLastname.get(4));
                    tv_Tambun5.setText(listTambun.get(4).toString()+" แต้มบุญ");
                    pic_profile5.setImageResource(R.drawable.profile);
                    tv_name6.setText( listFirstname.get(5).toString()+" "+listLastname.get(5));
                    tv_Tambun6.setText(listTambun.get(5).toString()+" แต้มบุญ");
                    pic_profile6.setImageResource(R.drawable.profile);
                    tv_name7.setText( listFirstname.get(6).toString()+" "+listLastname.get(6));
                    tv_Tambun7.setText(listTambun.get(6).toString()+" แต้มบุญ");
                    pic_profile7.setImageResource(R.drawable.profile);
                    tv_name8.setText( listFirstname.get(7).toString()+" "+listLastname.get(7));
                    tv_Tambun8.setText(listTambun.get(7).toString()+" แต้มบุญ");
                    pic_profile8.setImageResource(R.drawable.profile);
                    tv_name9.setText( listFirstname.get(8).toString()+" "+listLastname.get(8));
                    tv_Tambun9.setText(listTambun.get(8).toString()+" แต้มบุญ");
                    pic_profile9.setImageResource(R.drawable.profile);
                    tv_name10.setText( listFirstname.get(9).toString()+" "+listLastname.get(9));
                    tv_Tambun10.setText(listTambun.get(9).toString()+" แต้มบุญ");
                    pic_profile10.setImageResource(R.drawable.profile);


                } catch (JSONException e) {
                    // JSON error
                    Toast.makeText(getActivity().getApplicationContext() ,"ERROR JSON = "+e, Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                 Toast.makeText(getActivity().getApplicationContext(), "Volley Error = "+error, Toast.LENGTH_LONG).show();

            }
        }) {/*

             @Override
             protected Map<String, String> getParams() {
                 // Posting parameters to login url
                 Map<String, String> params = new HashMap<String, String>();
                 //JSONArray m = new JSONArray();
                 params.put("username","A1");
                 return params;
             }*/

        };
        AppController.getInstance().addToRequestQueue(arrReq, "tag_json_obj");

    }


}

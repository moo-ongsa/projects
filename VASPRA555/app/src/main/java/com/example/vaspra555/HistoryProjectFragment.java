package com.example.vaspra555;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.vaspra555.List.HistoProject;
import com.example.vaspra555.List.RycycleViewHistoProject;
import com.example.vaspra555.app.AppController;
import com.example.vaspra555.app.User;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryProjectFragment extends Fragment {
    View v;
    RecyclerView recyclerView;
    List<HistoProject> listCont = new ArrayList<>();
    TextView test;
    String[] A = new String[50];
    String hsdonate ;
    String hstype ;
    String hsdate ;
    String TAE;
    JSONObject jObj = new JSONObject();
    public static ArrayList TEST;
    private String url = Server.URL + "vaspraPHP/HistoProject.php?username="+ User.getUser();
    public final static String TAG_HSDONATE = "Donation_TotalDonation";


    public static HistoryProjectFragment newInstance() {
        // Required empty public constructor
        return new HistoryProjectFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_history_project,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.product_recyclerViewHistory);

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated( view,savedInstanceState);
        final ArrayList<String>[] fin = new ArrayList[]{new ArrayList<>()};
        final ArrayList<String> wow = new ArrayList<>();
        test=(TextView)view.findViewById(R.id.tvHistoryprojectDonate);

         final JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.POST, url,null,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for(int i=0;i<response.length();i++) {
                        // Get current json object
                        jObj = response.getJSONObject(i);
                        // Get the current student (json object) data
                           hsdonate = jObj.getString("Donation_TotalDonation");
                          hstype = jObj.getString("Donation_Type");
                         hsdate = jObj.getString("Donation_Date");
                        listCont.add(new HistoProject(Integer.toString(i+1),hsdonate,hstype,hsdate));

                    }

                    RycycleViewHistoProject viewAdapter = new RycycleViewHistoProject(getContext(), listCont);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(viewAdapter);

                } catch (JSONException e) {
                    // JSON error
                    Toast.makeText(getActivity().getApplicationContext() ,"ERROR JSON = "+e, Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(getActivity().getApplicationContext(), "Volley Error = "+error, Toast.LENGTH_LONG).show();
                listCont.add(new HistoProject("        ","ไม่มีประวัติการทำบุญ ","","    "));
                RycycleViewHistoProject viewAdapter = new RycycleViewHistoProject(getContext(), listCont);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(viewAdapter);
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

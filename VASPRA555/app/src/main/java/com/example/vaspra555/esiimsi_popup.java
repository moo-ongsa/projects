package com.example.vaspra555;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.vaspra555.Suggestion_Logo.logo2_Fragment;
import com.example.vaspra555.app.AppController;
import com.example.vaspra555.app.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class esiimsi_popup extends Fragment {
    private Button btn_backto_esiimsi,btn_nothing;
    final String url = Server.URL+"vaspraPHP/esiimsi.php";
    TextView tv_LuckyShow;


    public static esiimsi_popup newInstance() {
        return new esiimsi_popup ();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate (R.layout.fragment_esiimsi_popup, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btn_backto_esiimsi = (Button) view.findViewById (R.id.btn_backto_esiimsi);
        btn_backto_esiimsi.setOnClickListener (onClickCloseEssimsiRandomPopup);
        tv_LuckyShow = (TextView)view.findViewById(R.id.tv_LuckyShow);

        final StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    String detail = jObj.getString("detail");
                    tv_LuckyShow.setText(detail);
                    // Check for error node in json

                } catch (JSONException e) {
                    // JSON error
                    Toast.makeText(getActivity().getApplicationContext() ,"ERROR JSON = "+response, Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext() ,"URL = "+url , Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext() ,"ERROR2", Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("luckynumber", User.getLucky());
                params.put("username", User.getUser());
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, "tag_json_obj");


    }

    private View.OnClickListener onClickCloseEssimsiRandomPopup = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .popBackStack ();
        }
    };




}

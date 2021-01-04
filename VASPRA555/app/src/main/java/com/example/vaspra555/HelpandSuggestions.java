package com.example.vaspra555;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.vaspra555.Suggestion_Logo.Rating;
import com.example.vaspra555.Suggestion_Logo.logo1_Fragment;
import com.example.vaspra555.app.AppController;
import com.example.vaspra555.app.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HelpandSuggestions extends Fragment {

    Button btn_send,btn_back;
    TextView textext;
    EditText detailFeedback;
    ProgressDialog pDialog;
    Intent intent;
    private String url = Server.URL+"vaspraPHP/feedback.php";
    private static final String TAG = HelpandSuggestions.class.getSimpleName();
    String tag_json_obj = "json_obj_req",id,username;
    int success;
    private  static final  String TAG_SUCCESS = "success";
    private  static final  String TAG_MASSAGE = "message";
    public static  String TAG_detailFeedback;
    public  static String TAG_feedbackRating;
    public static HelpandSuggestions newInstance() {
        return new HelpandSuggestions();
    }


    @Nullable


    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate (R.layout.fragment_helpand_suggestions, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btn_send = (Button) view.findViewById (R.id.btn_send);
        btn_send.setOnClickListener(btn_sendClick);
        textext = (TextView)view.findViewById (R.id.text_text);
        detailFeedback = (EditText) view.findViewById (R.id.detailFeedback);
       // btn_back = (Button) view.findViewById(R.id.btn_back);
       // btn_back.setOnClickListener(btn_backClick);

        // btn_send.setOnClickListener(OnClickOpenAward);

        getFragmentManager ().beginTransaction ()
                .add (R.id.FrameLayout_mainsuggest, logo1_Fragment.newInstance ())
                .commit ();
    }

    private View.OnClickListener btn_sendClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final String feedbackRating = Rating.getRating ();
            final String userName = User.getUser();

            //Intent myIntent = new Intent(getActivity(), sendFeedBack.class);
            // myIntent.putExtra (TAG_detailFeedback,detailFeedback.getText ().toString ());
            // Clear back stack
            // myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            // startActivity(myIntent);
            //Toast.makeText (getActivity (),"WOWOWWOW1",Toast.LENGTH_LONG).show();

            StringRequest strReq = new StringRequest (Request.Method.POST, url, new Listener<String> () {

                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jObj = new JSONObject (response);
                        success = jObj.getInt (TAG_SUCCESS);

                        if(success == 1){
                            Toast.makeText (getActivity (),"ขอบคุณสำหรับความคิดเห็น",Toast.LENGTH_LONG).show();
                            detailFeedback.setText ("");
                        }else{
                            Toast.makeText(getActivity (),jObj.getString (TAG_MASSAGE),Toast.LENGTH_LONG).show ();
                            //detailFeedback.setText("ERROR");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace ();
                        Toast.makeText(getActivity (),"Error JSON = "+response+" rateFeedback = "+feedbackRating+" detailFeedback = "+detailFeedback.getText().toString()+" uesrname = "+username,Toast.LENGTH_LONG).show ();
                        // Toast.makeText (getActivity (),"WOWOWWOW4",Toast.LENGTH_LONG).show();
                    }
                }
            } ,new Response.ErrorListener (){

                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText (getActivity (),error.getMessage (),Toast.LENGTH_SHORT).show();
                    //Toast.makeText (getActivity (),"WOWOWWOW5",Toast.LENGTH_LONG).show();

                }
            }){
                @Override
                protected Map<String,String> getParams(){
                    Map<String, String> params = new HashMap<String, String> ();
                    params.put("rateFeedback",feedbackRating);
                    params.put("detailFeedback",detailFeedback.getText ().toString ());
                    params.put("username",userName);
                    return params;
                }
            };
            // Toast.makeText (getActivity (),"test = "+url,Toast.LENGTH_SHORT).show();

            AppController.getInstance ().addToRequestQueue (strReq,tag_json_obj);
        }



    };

    private View.OnClickListener btn_backClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(getActivity(),
                    MainActivity.class);
            // Clear back stack
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(myIntent);
        }
    };
}





package com.example.vaspra555;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.vaspra555.app.AppController;


public class Register extends AppCompatActivity {

    ProgressDialog pDialog;
    Button btn_register, btn_login;
    EditText txt_username, txt_password, txt_confirm_password, txt_name, txt_surname, txt_date, txt_address;
    Intent intent;
    Calendar c;
    DatePickerDialog dpd;
    RadioButton radio_m ,radio_wm;
    RadioGroup radio_group;


    int success ,day ,month ,year;

    private String url = Server.URL + "vaspraPHP/register.php";

    private static final String TAG = Register.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        txt_username = (EditText) findViewById(R.id.txt_username);
        txt_password = (EditText) findViewById(R.id.txt_password);
        txt_confirm_password = (EditText) findViewById(R.id.txt_confirm_password);
        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_surname = (EditText) findViewById(R.id.txt_surname);
        txt_date = (EditText) findViewById(R.id.txt_date);
        txt_address = (EditText) findViewById(R.id.txt_address);
        radio_m = (RadioButton) findViewById(R.id.radio_m);
        radio_wm = (RadioButton) findViewById(R.id.radio_wm);
        radio_group = (RadioGroup) findViewById(R.id.radio_group);

        /*
        btn_login.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                intent = new Intent(Register.this, Login.class);
                finish();
                startActivity(intent);

            }
        });*/

        txt_date.setFocusable(false);
        txt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c= Calendar.getInstance();

                 day = c.get(Calendar.DAY_OF_MONTH);
                 month = c.get(Calendar.MONTH);
                 year = c.get(Calendar.YEAR);
                dpd = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                        txt_date.setText(mDay + "/" + (mMonth+1) + "/" + mYear);
                        day =mDay;
                        month = mMonth+1;
                        year = mYear;
                    }
                },year,month,day);

                dpd.show();
            }
        });


        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String username = txt_username.getText().toString();
                String password = txt_password.getText().toString();
                String confirm_password = txt_confirm_password.getText().toString();
                String name = txt_name.getText().toString();
                String surname = txt_surname.getText().toString();
                String date = txt_date.getText().toString();
                String sex = "";
                if(radio_group.getCheckedRadioButtonId() == radio_m.getId()){
                    sex = "M";
                }
                else if(radio_group.getCheckedRadioButtonId() == radio_wm.getId()) {
                    sex = "F";
                }
                String address = txt_address.getText().toString();
                checkRegister(username, password, confirm_password,name,surname,date,sex,address);
            }
        });



    }
    public void text_login(View View){
        // TODO Auto-generated method stub
        intent = new Intent(Register.this, Login.class);
        finish();
        startActivity(intent);
    }


    private void checkRegister(final String username, final String password, final String confirm_password, final String name, final String surname,
                               final String date, final String sex, final String address) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Register ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response);
                hideDialog();
                try {
                    JSONObject jObj = new JSONObject(response);
                    success = jObj.getInt(TAG_SUCCESS);

                    // Check for error node in json
                    if (success == 1) {
                        Log.e("Successfully Register!", jObj.toString());
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                        txt_username.setText("");
                        txt_password.setText("");
                        txt_confirm_password.setText("");
                        txt_name.setText("");
                        txt_surname.setText("");
                        txt_date.setText("");
                        txt_address.setText("");

                    } else {
                        Toast.makeText(getApplicationContext(),
                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    // JSON error
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext() ,"Error JSON = "+response, Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);
                params.put("confirm_password", confirm_password);
                params.put("name",name);
                params.put("surname",surname);
                params.put("date",date);
                params.put("sex",sex);
                params.put("address",address);
                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        intent = new Intent(Register.this, Login.class);
        finish();
        startActivity(intent);
    }
}

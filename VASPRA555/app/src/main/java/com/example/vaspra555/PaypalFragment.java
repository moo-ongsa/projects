package com.example.vaspra555;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInRequest;
import com.braintreepayments.api.dropin.DropInResult;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.example.vaspra555.app.AppController;
import com.example.vaspra555.app.DataHolder;
import com.example.vaspra555.app.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class PaypalFragment extends Fragment {

    private static final int REQUEST_CODE = 1234;
    final String API_CHECK_OUT = Server.URL+"braintree/checkout.php";
    final String url = Server.URL+"vaspraPHP/paymentinsert.php";
    String token = User.getToken(),amount,ProjectID,TempleID,DonationType;
    HashMap<String, String> paramsHash;
    ImageButton btn_back;
    Button btn_paypal;
    TextView moneyAmount;
    DataHolder jObj;
    int success;
    public static PaypalFragment newInstance(@Nullable DataHolder jObj) {
        PaypalFragment paypalFragment = new PaypalFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("paypal_obj", jObj);
        paypalFragment.setArguments(bundle);
        return paypalFragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Read From Argument
        jObj = (DataHolder) getArguments().getSerializable("paypal_obj");
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_paypal, container, false);
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btn_back = (ImageButton) view.findViewById(R.id.btn_backtoconstruct);
        // edit text money amount
        btn_paypal = (Button) view.findViewById(R.id.btn_paypalpayment);
        moneyAmount = (TextView) view.findViewById(R.id.moneyAmount2) ;

        amount = jObj.getamount();
        ProjectID = jObj.getDonation_ID();
        TempleID = jObj.getTempleID();
        DonationType = jObj.getDonationType();

        moneyAmount.setText(amount+" บาท");
        btn_back.setOnClickListener(onCloseClickListener);
        btn_paypal.setOnClickListener(onClickPaypal);


    }
    private View.OnClickListener onCloseClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getFragmentManager()
                    .popBackStack();
        }
    };
    private View.OnClickListener onClickPaypal = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            submitPayment();
        }
    };
    private void submitPayment(){


        if(amount.length() != 0)
        {
            DropInRequest dropInRequest=new DropInRequest().clientToken(token);
            PaypalFragment.this.startActivityForResult(dropInRequest.getIntent(getActivity()),REQUEST_CODE);
        }
        else {
            Toast.makeText(getActivity(), token, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        Log.d("onActivityResult", "requestCode = " + requestCode);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MainActivity.RESULT_OK) {
                DropInResult result = data.getParcelableExtra(DropInResult.EXTRA_DROP_IN_RESULT);
                PaymentMethodNonce nonce = result.getPaymentMethodNonce();
                String strNonce = nonce.getNonce();

                if (!amount.isEmpty()) {
                    paramsHash = new HashMap<>();
                    paramsHash.put("amount", amount);
                    paramsHash.put("nonce", strNonce);

                    sendPayments();
                } else {
                    Toast.makeText(getActivity(), "Please enter valid amount", Toast.LENGTH_SHORT).show();
                }
            } else if (resultCode == MainActivity.RESULT_CANCELED) {
                Toast.makeText(getActivity(), "User Cancel", Toast.LENGTH_SHORT).show();
                getFragmentManager()
                        .popBackStack();}
            else {
                Exception error = (Exception) data.getSerializableExtra(DropInActivity.EXTRA_ERROR);
                Log.d("EDMT_ERROR", error.toString());
            }
        }
    }

    private void sendPayments(){
        RequestQueue queue= Volley.newRequestQueue(getActivity());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, API_CHECK_OUT,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.toString().contains("Successful")){

                            final StringRequest strReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                                @Override
                                public void onResponse(String response) {
                                    try {
                                        JSONObject jObj = new JSONObject(response);
                                        success = jObj.getInt("success");
                                        //Toast.makeText(getApplicationContext() ,"ยินดีต้อนรับ" , Toast.LENGTH_LONG).show();
                                        //Toast.makeText(getApplicationContext() ,"SUCCESS = "+success , Toast.LENGTH_LONG).show();
                                        // Check for error node in json
                                        if (success == 1) {
                                            Log.e("Successfully Payment!", jObj.toString());

                                        } else {
                                            Toast.makeText(getActivity().getApplicationContext() ,"fail to insert database", Toast.LENGTH_LONG).show();

                                            //Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();

                                        }
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
                                    params.put("User_ID", User.getUser());
                                    params.put("Donation_ID", ProjectID);
                                    params.put("Donation_TotalDonation", amount);
                                    params.put("Donation_Type", DonationType);

                                    return params;
                                }

                            };

                            // Adding request to request queue
                            AppController.getInstance().addToRequestQueue(strReq, "tag_json_obj");

                            Toast.makeText(getActivity(), "Payment Success", Toast.LENGTH_SHORT).show();
                            getFragmentManager()
                                    .beginTransaction()
                                    .remove(PaypalFragment.this)
                                    .replace(R.id.frameLayout, ThankYouFragment.newInstance())
                                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                                    .commit();
                        }
                        else {
                            Toast.makeText(getActivity(), "Payment Failed", Toast.LENGTH_SHORT).show();
                        }
                        Log.d("EMDT_LOG",response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("EDMT_ERROR",error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(paramsHash==null)
                    return null;
                Map<String,String> params=new HashMap<>();
                for(String key:paramsHash.keySet())
                {
                    params.put(key,paramsHash.get(key));
                }
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("Content-type","application/x-www-form-urlencoded");
                return params;
            }
        };
        RetryPolicy mRetryPolicy=new DefaultRetryPolicy(0,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(mRetryPolicy);
        queue.add(stringRequest);
    }




}

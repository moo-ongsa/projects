package com.example.vaspra555;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.braintreepayments.api.dropin.DropInActivity;
import com.braintreepayments.api.dropin.DropInResult;
import com.braintreepayments.api.interfaces.HttpResponseCallback;
import com.braintreepayments.api.internal.HttpClient;
import com.braintreepayments.api.models.PaymentMethodNonce;
import com.example.vaspra555.app.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

import static com.example.vaspra555.app.User.setToken;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1234;
    final String API_GET_TOKEN = Server.URL+"braintree/main.php";
    final String API_CHECK_OUT = Server.URL+"braintree/checkout.php";
    public String token, amount;
    HashMap<String, String> paramsHash;

    BottomNavigationView navigation;
    FrameLayout frameLayout;
    // FRAGMENTS;
    private RankingFragment rankingFragment;
    private DonateFragment donateFragment;
    private EsiimsiFragment esiimsiFragment;
    private MenuFragment menuFragment;
    ImageButton btnMenu,btnHome;
    //Moo
    public final static String TAG_USERNAME = "userFirstname";
    public final static String TAG_ID = "userId";

    //Moo
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);
        new MainActivity.getToken().execute();
        // Fragment initialization
        rankingFragment = new RankingFragment();
        menuFragment = new MenuFragment();
        donateFragment = new DonateFragment();
        esiimsiFragment = new EsiimsiFragment();

        btnMenu = (ImageButton) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(onAddFragmentClickListener);
        // Home button
        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        MainActivity.class);
                // Clear back stack
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(myIntent);
            }
            });
        // 3 navi below
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                // Switch to select which case is choosen:

                switch (menuItem.getItemId()){
                    case R.id.navigation_ranking :
                        // code to be executed when item 1 is selected
                        InitializeFragment(rankingFragment);
                        return true;


                    case R.id.navigation_donate :
                        InitializeFragment(donateFragment);
                        return true;

                    case R.id.navigation_esiimsi :
                        InitializeFragment(esiimsiFragment);
                        return true;
                }
                return false;

            }
        });

    }
    // select navi
    private void InitializeFragment(Fragment fragment){

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();

    }
    // Menu button
    private View.OnClickListener onAddFragmentClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_left)
                    .addToBackStack("back_stack_home_fragment")
                    .add(R.id.layout_contain_menu, MenuFragment.newInstance())
                    .commit();
        }
    };

    public class getToken extends AsyncTask {
        ProgressDialog mDialog;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mDialog = new ProgressDialog(MainActivity.this,android.R.style.Theme_DeviceDefault_Dialog);
            mDialog.setCancelable(false);
            mDialog.setMessage("Please wait");
            mDialog.show();
        }

        @Override
        protected  Object doInBackground(Object[] objects) {
            HttpClient client = new HttpClient();
            client.get(API_GET_TOKEN, new HttpResponseCallback() {
                @Override
                public void success(final String responseBody) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            token = responseBody;
                            User.setToken(token);
                        }
                    });
                }

                @Override
                public void failure(Exception exception) {

                    Log.d("EDMT_ERROR",exception.toString());
                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            mDialog.dismiss();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("paypal");
        fragment.onActivityResult(requestCode, resultCode, data);
    }

}

package com.example.vaspra555;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.example.vaspra555.app.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryBahtFragment extends Fragment {


    public static HistoryBahtFragment newInstance() {
        return new HistoryBahtFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history_baht, container, false);
    }

    /**
     * A simple {@link Fragment} subclass.
     */
    public static class MenuFragment extends Fragment {
        private Button btnProfile, btnCart,btnHelp,btnAward,btnLogout,btnHistory;
        private ImageButton btnExit;
        private TextView userFullname;
        SharedPreferences sharedpreferences;

        public final static String TAG_USERNAME = "userFirstname";
        public final static String TAG_ID = "userId";
        public static MenuFragment newInstance() {
            return new MenuFragment();
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_menu, container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
            super.onViewCreated(view, savedInstanceState);
            userFullname=(TextView)view.findViewById(R.id.userFullname);
            userFullname.setText(User.getUser());
            btnExit = (ImageButton) view.findViewById(R.id.exitmenu);
            btnExit.setOnClickListener(onCloseClickListener);
            btnHelp = (Button) view.findViewById(R.id.btnHelp);
            btnHelp = (Button) view.findViewById (R.id.btnHelp);
            btnHelp.setOnClickListener(OnClickOpenHelp);
            btnAward = (Button) view.findViewById (R.id.btnGiveaway);
            btnAward.setOnClickListener(OnClickOpenAward);
            btnHistory = (Button)view.findViewById(R.id.btnHistory);
            btnHistory.setOnClickListener(OnClickOperHistoryt);
            btnLogout =(Button) view.findViewById(R.id.btnLogout);
            btnLogout.setOnClickListener(OnClickLogout);

        }
        private View.OnClickListener OnClickOperHistoryt = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace (R.id.frameLayout,HistoryFragment.newInstance ())
                        .remove(MenuFragment.this)
                        .commit();
            }
        };

        private View.OnClickListener onCloseClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(R.anim.enter_from_left,R.anim.exit_to_left)
                        .remove(MenuFragment.this)
                        .commit();
            }
        };
        private View.OnClickListener OnClickOpenHelp = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace (R.id.frameLayout,HelpandSuggestions.newInstance ())
                        .remove(MenuFragment.this)
                        .commit();
            }
        };
        private View.OnClickListener OnClickOpenAward = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace (R.id.frameLayout,AwardFragment.newInstance ())
                        .remove(MenuFragment.this)
                        .commit();
            }
        };

        private View.OnClickListener OnClickLogout = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedpreferences = getActivity().getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(Login.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.commit();
                String id = sharedpreferences.getString(TAG_ID, null);
                User.setUser(id);
                Toast.makeText(getActivity() ,"ขอบคุณที่ใช้บริการ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
            }
        };

    }
}

package com.example.vaspra555;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.security.SecureRandom;

import com.example.vaspra555.Suggestion_Logo.logo1_Fragment;
import com.example.vaspra555.app.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class EsiimsiFragment extends Fragment {
    private Button btn_esiimsi_random;
    SecureRandom random = new SecureRandom();

    int luckyNumber = random.nextInt(9) + 1;

    public static EsiimsiFragment newInstance() {
        return new EsiimsiFragment ();
    }
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_esiimsi, container, false);
    }


    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        btn_esiimsi_random = (Button) view.findViewById (R.id.btn_esiimsi_random);
        btn_esiimsi_random.setOnClickListener (onClickOpenEssimsiRandom);

    }
    private View.OnClickListener onClickOpenEssimsiRandom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            User.setLucky(Integer.toString(luckyNumber));

            getFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .replace(R.id.layout_esiimsi,esiimsi_popup.newInstance ())
                    .addToBackStack (null)
                    .commit();
        }
    };

}

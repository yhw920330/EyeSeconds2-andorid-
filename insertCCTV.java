package com.example.ryu_hw.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Ryu_hw on 2016-10-29.
 */

public class insertCCTV extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_cctv);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container_cctv_signup, new SignupCCTVInformationFragment());
        ft.commit();
    }

}

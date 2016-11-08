package com.example.ryu_hw.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Ryu_hw on 2016-10-29.
 */

public class SignupCCTVInformationFragment extends Fragment implements View.OnClickListener {

    public int view_id = 0;

    private DB_Manager db_manger;
    private ArrayList<String> results;

    private EditText et_lat;
    private EditText et_long;
    private EditText et_addr;
    private EditText et_phone;
    private EditText et_host;

    public SignupCCTVInformationFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sinup_cctv_infomation, container, false);
        et_lat = (EditText) rootView.findViewById(R.id.latitude);
        et_long = (EditText) rootView.findViewById(R.id.longitude);
        et_addr = (EditText) rootView.findViewById(R.id.address);
        et_phone = (EditText) rootView.findViewById(R.id.phone);
        et_host = (EditText) rootView.findViewById(R.id.host);
        Button btn_singupCCTV = (Button) rootView.findViewById(R.id.btn_signupCCTV);


        btn_singupCCTV.setOnClickListener(this);

        db_manger = new DB_Manager();
        results = new ArrayList<String>();

        return rootView;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signupCCTV:
                String latitude = et_lat.getText().toString();
                String longitude = et_long.getText().toString();
                String address = et_addr.getText().toString();
                String phone = et_phone.getText().toString();
                String host = et_host.getText().toString();
                String test = latitude + "," + longitude + "," + address;
                Log.d("Creation", test);
                db_manger.signup_cctv_info(latitude, longitude, address, phone, host);
                Intent mainIntent = new Intent(getActivity(), aroundMap.class);
                startActivity(mainIntent);
                break;
        }
    }
}

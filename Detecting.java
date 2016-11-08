package com.example.ryu_hw.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Ryu_hw on 2016-10-25.
 */

public class Detecting extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detecting);
    }

    public void onClick_End(View view) {

        finish();

    }

    public void onClick_CCTV(View view) {
        Toast.makeText(this, "CCTV 화면 구현", Toast.LENGTH_SHORT).show();
    }

    public void onClick_around(View view) {
        Toast.makeText(this, "주변 CCTV보기", Toast.LENGTH_SHORT).show();
        //액티비티간 이동
        Intent intent = new Intent(this, aroundMap.class);
        startActivity(intent);


    }
}

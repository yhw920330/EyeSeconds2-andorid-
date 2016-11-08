package com.example.ryu_hw.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 * Created by Ryu_hw on 2016-10-25.
 */

public class SubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void onClick_Start(View view) {
        Toast.makeText(this, "감지모드 시작", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Detecting.class);
        startActivity(intent);
    }
}

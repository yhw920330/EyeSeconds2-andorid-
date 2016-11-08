package com.example.ryu_hw.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //시스템적인 요소를 초기화
        setContentView(R.layout.activity_main);


        //무조건 type casting을 해줘서 뷰에 맞는걸로 해줘야함
        EditText userID = (EditText) findViewById(R.id.user_id);
        EditText userPW = (EditText) findViewById(R.id.user_pw);
        Button btnLogin = (Button) findViewById(R.id.btn_login);

    }

    public void onClickLogin(View view) {
        // 처리
        Toast.makeText(this, "Login시도", Toast.LENGTH_SHORT).show();
        //액티비티간 이동
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);

    }

    public void onClickCCTV_INSERT(View view) {
        Toast.makeText(this, "CCTV등록", Toast.LENGTH_SHORT).show();
        //액티비티간 이동
        Intent intent = new Intent(this, insertCCTV.class);
        startActivity(intent);
    }

    public void onClickCCTV_user_signup(View view) {

        Toast.makeText(this, "회원가입 구현", Toast.LENGTH_SHORT).show();

    }
}

package com.example.ryu_hw.myapplication;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Ryu_hw on 2016-11-15.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String tag = "myfirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(tag, "Refreshed token: " + token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {
        OkHttpClient client = new OkHttpClient();
        Log.d("여기여기", token);

        RequestBody body = new FormBody.Builder()
                .add("Token", token)
                .build();

        //
        Request request = new Request.Builder()
                .url("http://yhw920330.cafe24.com/fcm_register.php")
                .post(body)
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

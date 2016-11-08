package com.example.ryu_hw.myapplication;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Ryu_hw on 2016-10-29.
 */

public class DB_Manager {
    private final String signup_cctv_information_URLPath = "http://yhw920330.cafe24.com/cctv_signup/signup_cctv_information.php/";
    private String urlPath;
    private String latitude;
    private String longitude;
    private String address;
    private String phone;
    private String host;

    public ArrayList<String> signup_cctv_info(String latitude, String longitude, String address, String phone, String host) {
        ArrayList<String> results = null;
        urlPath = signup_cctv_information_URLPath;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.phone = phone;
        this.host = host;

        try {
            results = new SignupCCTVInfomation().execute().get();//

        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return results;
    }

    class SignupCCTVInfomation extends AsyncTask<Void, Void, ArrayList<String>> {
        @Override
        protected ArrayList<String> doInBackground(Void... params) {
            try {
                URL url = new URL(urlPath);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setDoInput(true);//write 가능하게 만듬
                con.setDoOutput(true);//read 가능하게 만듬
                con.setUseCaches(false);
                con.setRequestMethod("POST");

                String para = "latitude=" + latitude + "&longitude=" + longitude + "&address=" + address + "&phone=" + phone
                        + "&host=" + host;


                OutputStream outputStream = con.getOutputStream();
                outputStream.write(para.getBytes());
                outputStream.flush();
                outputStream.close();

                BufferedReader rd = null;
                rd = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String line = null;
                while ((line = rd.readLine()) != null) {
                    Log.d("BufferedReader:", line);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(ArrayList<String> qResults) {
            super.onPostExecute(qResults);
        }
    }

}


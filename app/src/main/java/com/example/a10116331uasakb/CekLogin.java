package com.example.a10116331uasakb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a10116331uasakb.Akun.LoginActivity;
import com.example.a10116331uasakb.ViewPager.ViewPagerActivity;

/**
 * 8 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

public class CekLogin extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private String loginSts = "0";

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String login = "loginSts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_login);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        loginSts = sharedPreferences.getString("loginSts", "login");

        if (loginSts.equals("1")) {
            Intent intent = new Intent(CekLogin.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(CekLogin.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

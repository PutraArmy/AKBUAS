package com.example.a10116331uasakb;

/**
 * 3 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.a10116331uasakb.Akun.LoginActivity;
import com.example.a10116331uasakb.ViewPager.ViewPagerActivity;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private String loginSts = "0";

    public static final String MyPREFERENCES = "ViewPager";
    public static final String skip = "skipSts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        loginSts = sharedPreferences.getString("skipSts", "skip");

        if (loginSts.equals("1")) {
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(SplashActivity.this, ViewPagerActivity.class);
            startActivity(intent);
            finish();
        }
        // langsung pindah ke MainActivity atau activity lain
        // begitu memasuki splash screen ini

    }
}

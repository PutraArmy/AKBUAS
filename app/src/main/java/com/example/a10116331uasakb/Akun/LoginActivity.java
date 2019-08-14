package com.example.a10116331uasakb.Akun;

/**
 * 3 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a10116331uasakb.MainActivity;
import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.presenter.AppDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin, btnDaftar;
    EditText edtUsername, edtPass;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String login = "loginSts";

    private AppDatabase db;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnDaftar = findViewById(R.id.btn_daftar);
        btnLogin  = findViewById(R.id.btn_login);

        edtUsername = findViewById(R.id.edt_username_login);
        edtPass = findViewById(R.id.edt_pass_login);

        btnDaftar.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

//        db = Room.databaseBuilder(getApplicationContext(),
//                AppDatabase.class, "akundb").build();

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db").allowMainThreadQueries().build();

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_daftar):
                Intent daftarIntent = new Intent(LoginActivity.this, signup.class);
                startActivity(daftarIntent);

                break;
            case (R.id.btn_login) :
                if ((edtUsername.length() == 0) || (edtPass.length() == 0) ) {
                    Toast.makeText(LoginActivity.this, "Pastikan Username dan Password telah teris", Toast.LENGTH_LONG).show();
                } else {
                    Akun akun = (Akun) db.dao().selectAkun(edtUsername.getText().toString());
                    if (akun != null) {
                        if (edtPass.getText().toString().equals(akun.getPassword())) {

                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putString(login, "1");
                            editor.commit();
                            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                            Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(loginIntent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Password Tidak Sesuai ", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(LoginActivity.this, "Username Tidak Ditemukan ", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}

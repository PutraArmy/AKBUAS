package com.example.a10116331uasakb.Akun;

/**
 * 3 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.presenter.AppDatabase;

public class signup extends AppCompatActivity implements View.OnClickListener {

    Button btnBack, btnSignUp, btnReadAkun;
    EditText edtDafUsername, edtDafPass;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnBack = findViewById(R.id.btn_back_login);
        btnSignUp = findViewById(R.id.btn_signup);
//        btnReadAkun = findViewById(R.id.btn_lihat_akun);

        edtDafUsername = findViewById(R.id.edt_daf_username);
        edtDafPass = findViewById(R.id.edt_daf_pass);


        btnBack.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);
//        btnReadAkun.setOnClickListener(this);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db").allowMainThreadQueries().build();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_back_login) :
                Intent backIntent = new Intent(signup.this, LoginActivity.class);
                finish();
                startActivity(backIntent);
                break;
            case (R.id.btn_signup) :
                //cek empty pada edit text
                if ((edtDafUsername.length() == 0) || (edtDafPass.length() == 0) ) {
                    Toast.makeText(signup.this, "Pastikan Username dan Password telah teris", Toast.LENGTH_LONG).show();
                } else {
                    //cek ketersediaan akun
                    Akun akun = (Akun) db.dao().selectAkun(edtDafUsername.getText().toString());
                    if (akun == null) {
                        //insert akun
                        Akun a = new Akun();
                        a.setUsername(edtDafUsername.getText().toString());
                        a.setPassword(edtDafPass.getText().toString());
                        insertData(a);

                        Intent signupSuccessIntent = new Intent(signup.this, LoginActivity.class);
                        finish();
                        startActivity(signupSuccessIntent);
                    } else {
                        Toast.makeText(signup.this, "Username telah digunakan", Toast.LENGTH_LONG).show();
                    }
                }
                break;
//            case (R.id.btn_lihat_akun) :
//                Intent akunIntent = new Intent(signup.this, ReadAkun.class);
//                startActivity(akunIntent);
        }
    }

    private void insertData(final Akun akun){

        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                // melakukan proses insert data
                long status = db.dao().insertAkun(akun);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(signup.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }
}

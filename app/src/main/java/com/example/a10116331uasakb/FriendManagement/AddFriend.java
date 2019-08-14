package com.example.a10116331uasakb.FriendManagement;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a10116331uasakb.Akun.signup;
import com.example.a10116331uasakb.Fragment.ListFriends;
import com.example.a10116331uasakb.MainActivity;
import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.model.Friend;
import com.example.a10116331uasakb.presenter.AppDatabase;

/**
 * 7 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

public class AddFriend extends AppCompatActivity implements View.OnClickListener {

    Button btnCancel, btnSave;
    EditText edtNim, edtNama, edtKelas, edtTelepon, edtEmail, edtSosmed;

    boolean adaData = false;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);

        btnCancel = findViewById(R.id.btn_add_cancel);
        btnSave = findViewById(R.id.btn_add_save);

        edtNim      = findViewById(R.id.edt_add_nim);
        edtNama     = findViewById(R.id.edt_add_nama);
        edtKelas    = findViewById(R.id.edt_add_kelas);
        edtTelepon  = findViewById(R.id.edt_add_telepon);
        edtEmail    = findViewById(R.id.edt_add_email);
        edtSosmed   = findViewById(R.id.edt_add_medsos);


        btnCancel.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db").allowMainThreadQueries().build();

        final Friend friend = (Friend) getIntent().getSerializableExtra("data");

        if (friend != null) {
            edtNim.setText(friend.getNim());
            edtNama.setText(friend.getNama());
            edtKelas.setText(friend.getKelas());
            edtTelepon.setText(friend.getTelepon());
            edtEmail.setText(friend.getEmail());
            edtSosmed.setText(friend.getMedsos());

            adaData = true;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.btn_add_cancel) :
                Intent cancelIntent = new Intent(AddFriend.this, MainActivity.class);
                finish();
                startActivity(cancelIntent);
                break;
            case (R.id.btn_add_save) :
                Friend a = new Friend();
                a.setNim(edtNim.getText().toString());
                a.setNama(edtNama.getText().toString());
                a.setKelas(edtKelas.getText().toString());
                a.setTelepon(edtTelepon.getText().toString());
                a.setEmail(edtEmail.getText().toString());
                a.setMedsos(edtSosmed.getText().toString());

                if (adaData == true) {
                    updateData(a);
                } else {
                    insertData(a);
                }

                Intent saveIntent = new Intent(AddFriend.this, MainActivity.class);
                finish();
                startActivity(saveIntent);

        }
    }

    private void updateData(final Friend friend){
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.dao().updateFriend(friend);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(AddFriend.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }


    private void insertData(final Friend friend){

        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                // melakukan proses insert data
                long status = db.dao().insertFriend(friend);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(AddFriend.this, "Add Friend Success "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, AddFriend.class);
    }
}

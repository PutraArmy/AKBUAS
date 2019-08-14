package com.example.a10116331uasakb.Akun;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.adapter.AkunAdapter;
import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.presenter.AppDatabase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 5 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

public class ReadAkun extends AppCompatActivity {

    private AppDatabase db;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Akun> daftarAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_akun);

        /**
         * Initialize ArrayList untuk data barang
         */
        daftarAkun = new ArrayList<>();

        /**
         * Initialize database
         * allow main thread queries
         */
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db").allowMainThreadQueries().build();

        /**
         * Initialize recyclerview dan layout manager
         */
        rvView = findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        /**
         * Add all data to arraylist
         */
        daftarAkun.addAll(Arrays.asList(db.dao().selectAllAkuns()));

        /**
         * Set all data ke adapter, dan menampilkannya
         */
        adapter = new AkunAdapter(daftarAkun, this);
        rvView.setAdapter(adapter);
    }

    public static Intent getActIntent(Activity activity) {
        // kode untuk pengambilan Intent
        return new Intent(activity, ReadAkun.class);
    }
}

package com.example.a10116331uasakb.adapter;

/**
 * 6 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.presenter.AppDatabase;

import java.util.ArrayList;

public class AkunAdapter extends RecyclerView.Adapter<AkunAdapter.ViewHolder>{
    private ArrayList<Akun> daftarAkun;
    private Context context;
    private AppDatabase db;

    public AkunAdapter(ArrayList<Akun> akuns, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarAkun = akuns;
        context = ctx;

        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "db").allowMainThreadQueries().build();

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle, tvPass;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
//            tvTitle = v.findViewById(R.id.tv_nama_akun);
            tvPass = v.findViewById(R.id.tv_pass_akun);
            cvMain = v.findViewById(R.id.cv_main);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_akun, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarAkun.get(position).getUsername();
        final String pass = daftarAkun.get(position).getPassword();

//        holder.tvTitle.setText(name);
        holder.tvPass.setText(pass);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarAkun.size();
    }
}

package com.example.a10116331uasakb.adapter;

/**
 * 6 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.app.Activity;
import android.app.Dialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.a10116331uasakb.Fragment.ListFriends;
import com.example.a10116331uasakb.FriendManagement.AddFriend;
import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.model.Friend;
import com.example.a10116331uasakb.presenter.AppDatabase;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder> {
    private ArrayList<Friend> daftarFriend;
    private Context context;
    private AppDatabase db;

    public FriendAdapter(ArrayList<Friend> friends, Context ctx) {
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarFriend = friends;
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
        TextView tvTitle;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_friend_nama);
            cvMain = v.findViewById(R.id.cv_friend);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarFriend.get(position).getNama();

        holder.tvTitle.setText(name);

        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.view_dialog);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button editButton = dialog.findViewById(R.id.bt_edit_data);
                Button delButton = dialog.findViewById(R.id.bt_delete_data);

                //apabila tombol edit diklik
                editButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                onEditBarang(position);
                            }
                        }
                );

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                onDeteleBarang(position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    private void onDeteleBarang(int position) {
        db.dao().deleteFriend(daftarFriend.get(position));
        daftarFriend.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeRemoved(position, daftarFriend.size());
    }

    private void onEditBarang(int position) {
        context.startActivity(AddFriend.getActIntent((Activity) context).putExtra("data", daftarFriend.get(position)));
    }


    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarFriend.size();
    }
}

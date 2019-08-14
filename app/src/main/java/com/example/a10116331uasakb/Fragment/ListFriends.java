package com.example.a10116331uasakb.Fragment;


import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a10116331uasakb.FriendManagement.AddFriend;
import com.example.a10116331uasakb.MainActivity;
import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.adapter.FriendAdapter;
import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.model.Friend;
import com.example.a10116331uasakb.presenter.AppDatabase;
import com.example.a10116331uasakb.view.ListFriendsView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * 19 Mei 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

public class ListFriends extends Fragment implements ListFriendsView {

//    private ListFriendsActivityPresenter presenter;

    Button addFriend;
    RecyclerView rvView;

    private ArrayList<Friend> daftarFriend;
    private AppDatabase db;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    public ListFriends() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_friends, container, false);
        // Inflate the layout for this fragment
//        presenter = new ListFriendsActivityPresenter(this);

        daftarFriend = new ArrayList<>();

        /**
         * Initialize database
         * allow main thread queries
         */
        this.db = MainActivity.db;

        final FragmentActivity c = getActivity();

        rvView = view.findViewById(R.id.rv_friend);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(c);
        rvView.setLayoutManager(layoutManager);

        daftarFriend.addAll(Arrays.asList(db.dao().selectAllFriend()));

        new Thread(new Runnable() {
            @Override
            public void run() {
                final FriendAdapter adapter = new FriendAdapter(daftarFriend, c);
                c.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rvView.setAdapter(adapter);
                    }
                });
            }
        }).start();


        addFriend = (Button) view.findViewById(R.id.btn_add_friend);

        addFriend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent addFriendIntent = new Intent(getActivity(), AddFriend.class);

                startActivity(addFriendIntent);
            }
        });

        return view;

    }



}

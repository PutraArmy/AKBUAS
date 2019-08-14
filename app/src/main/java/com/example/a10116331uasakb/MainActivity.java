package com.example.a10116331uasakb;

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
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.a10116331uasakb.Akun.LoginActivity;
import com.example.a10116331uasakb.Fragment.Profile;
import com.example.a10116331uasakb.Fragment.Contact;
import com.example.a10116331uasakb.Fragment.ListFriends;
import com.example.a10116331uasakb.adapter.AkunAdapter;
import com.example.a10116331uasakb.adapter.FriendAdapter;
import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.model.Friend;
import com.example.a10116331uasakb.presenter.AppDatabase;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static AppDatabase db;
    private TextView mTextMessage;

    BottomNavigationView bottomNavigationView;

    private ViewPager viewPager;

    Contact contact;
    Profile profile;
    ListFriends listFriends;
    MenuItem prevMenuItem;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String login = "loginSts";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        //Initializing the bottomNavigationView
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.prrofile:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.contact:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.list_friends:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.logout:
                                SharedPreferences.Editor editor = sharedPreferences.edit();

                                editor.putString(login, "0");
                                editor.commit();

                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                finish();
                                startActivity(intent);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

       /*  //Disable ViewPager Swipe

       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });

        */

        setupViewPager(viewPager);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db").allowMainThreadQueries().build();

//        rvView = findViewById(R.id.rv_friend);
//        rvView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        rvView.setLayoutManager(layoutManager);
//
//        /**
//         * Add all data to arraylist
//         */
//        daftarFriend.addAll(Arrays.asList(db.dao().selectAllFriend()));
//
//        /**
//         * Set all data ke adapter, dan menampilkannya
//         */
//        adapter = new FriendAdapter(daftarFriend, this);
//        rvView.setAdapter(adapter);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        profile     = new Profile();
        contact     = new Contact();
        listFriends = new ListFriends();

        adapter.addFragment(profile);
        adapter.addFragment(contact);
        adapter.addFragment(listFriends);
        viewPager.setAdapter(adapter);
    }

}

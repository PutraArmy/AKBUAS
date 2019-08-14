package com.example.a10116331uasakb.ViewPager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.a10116331uasakb.R;

/**
 * 10 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.view_pager_app);

        setupViewPager(viewPager);

    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAppAdapter adapter = new ViewPagerAppAdapter(getSupportFragmentManager());

        ViewPager1 VP1  = new ViewPager1();
        ViewPager2 VP2  = new ViewPager2();
        ViewPager3 VP3  = new ViewPager3();

        adapter.addFragment(VP1);
        adapter.addFragment(VP2);
        adapter.addFragment(VP3);
        viewPager.setAdapter(adapter);
    }
}

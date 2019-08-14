package com.example.a10116331uasakb.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a10116331uasakb.CekLogin;
import com.example.a10116331uasakb.R;

/**
 * 10 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

public class ViewPager3 extends Fragment {

    Button btnFinish, btnSkip;

    public static final String MyPREFERENCES = "ViewPager";
    public static final String skip = "skipSts";

    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager3, container, false);

        btnFinish = view.findViewById(R.id.btn_finish_vp);
        btnSkip = view.findViewById(R.id.btn_skip);

        sharedPreferences = getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishIntent = new Intent(getActivity(), CekLogin.class);
                startActivity(finishIntent);
                getActivity().finish();
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(skip, "1");
                editor.commit();

                Intent finishIntent = new Intent(getActivity(), CekLogin.class);
                startActivity(finishIntent);
                getActivity().finish();
            }
        });

        return view;
    }

}

package com.example.a10116331uasakb.Fragment;

/**
 * 16 Mei 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a10116331uasakb.R;
import com.example.a10116331uasakb.presenter.ProfileActivityPresenter;
import com.example.a10116331uasakb.view.ProfileView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile extends Fragment implements ProfileView {

    private ProfileActivityPresenter presenter;
    private TextView NIM, nama, kelas, desk;


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.profile, container, false);
        // Inflate the layout for this fragment
        presenter = new ProfileActivityPresenter(this);

        NIM = (TextView) view.findViewById(R.id.nim);
        nama = (TextView) view.findViewById(R.id.name);
        kelas = (TextView) view.findViewById(R.id.kelas);
        desk = (TextView) view.findViewById(R.id.desc);

        presenter.isiDataNIM("10116331");
        presenter.isiDataNama("Putra Army Yudha S.T.");
        presenter.isiDataKelas("Teknik Informatika - 8");
        presenter.isiDatadek("Indonesian computer university students \nmajoring in informatics engineering"); ;

        return view;

    }


    @Override
    public void isiProfileNIM(String info) {
        NIM.setText(info);
    }

    @Override
    public void isiProfileNama(String info) {
        nama.setText(info);
    }

    @Override
    public void isiProfileKelas(String info) {
        kelas.setText(info);
    }

    @Override
    public void isiProfileDesc(String info) {
        desk.setText(info);
    }
}

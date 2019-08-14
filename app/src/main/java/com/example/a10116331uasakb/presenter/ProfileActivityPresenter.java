package com.example.a10116331uasakb.presenter;

import com.example.a10116331uasakb.model.Profilemodel;
import com.example.a10116331uasakb.view.ProfileView;

/**
 * 16 Mei 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

public class ProfileActivityPresenter implements ProfilePresenter {

    private ProfileView profileView;
    private Profilemodel profile = new Profilemodel();

    public ProfileActivityPresenter(ProfileView profileView){
        this.profileView = profileView;
    }


    @Override
    public void isiDataNIM(String NIM) {
        profile.setNIM(NIM);
        profileView.isiProfileNIM(profile.getNIM());
    }

    @Override
    public void isiDataNama(String nama) {
        profile.setName(nama);
        profileView.isiProfileNama(profile.getName());
    }

    @Override
    public void isiDataKelas(String kelas) {
        profile.setKelas(kelas);
        profileView.isiProfileKelas(profile.getKelas());
    }

    @Override
    public void isiDatadek(String desk) {
        profile.setDesk(desk);
        profileView.isiProfileDesc(profile.getDesk());
    }
}

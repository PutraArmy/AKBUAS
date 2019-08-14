package com.example.a10116331uasakb.model;

/**
 * 19 Mei 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

import android.os.Parcel;
import android.os.Parcelable;

public class ListFriendsModel implements Parcelable {
    String nama, telepon, email, instagram, facebook;

    public ListFriendsModel(String nim, String nama, String kelas, String telepon, String email, String twitter, String instagram, String facebook) {
        this.nama = nama;
        this.telepon = telepon;
        this.email = email;
        this.instagram = instagram;
        this.facebook = facebook;
    }

    public ListFriendsModel() {
    }

    protected ListFriendsModel(Parcel in) {
        nama = in.readString();
        telepon = in.readString();
        email = in.readString();
        instagram = in.readString();
        facebook = in.readString();
    }

    public static final Creator<ListFriendsModel> CREATOR = new Creator<ListFriendsModel>() {
        @Override
        public ListFriendsModel createFromParcel(Parcel in) {
            return new ListFriendsModel(in);
        }

        @Override
        public ListFriendsModel[] newArray(int size) {
            return new ListFriendsModel[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(telepon);
        dest.writeString(email);
        dest.writeString(instagram);
        dest.writeString(facebook);
    }
}

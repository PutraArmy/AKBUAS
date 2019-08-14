package com.example.a10116331uasakb.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * 7 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

@Entity(tableName = "tFriend")
public class Friend implements Serializable {

    @PrimaryKey
    @NonNull
    public String nim;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "kelas")
    public String kelas;

    @ColumnInfo(name = "telepon")
    public String telepon;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "medsos")
    public String medsos;

    @NonNull
    public String getNim() {
        return nim;
    }

    public void setNim(@NonNull String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
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

    public String getMedsos() {
        return medsos;
    }

    public void setMedsos(String medsos) {
        this.medsos = medsos;
    }

}

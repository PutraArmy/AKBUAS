package com.example.a10116331uasakb.presenter;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.model.Friend;

/**
 * 3 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

@Database(entities = {Akun.class, Friend.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DAO dao();
}

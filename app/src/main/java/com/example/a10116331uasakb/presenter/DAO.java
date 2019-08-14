package com.example.a10116331uasakb.presenter;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.a10116331uasakb.model.Akun;
import com.example.a10116331uasakb.model.Friend;

/**
 * 3 Agustus 2019
 * 10116331
 * Putra Army Yudha Septa Triyono
 * IF-8
 */

@Dao
public interface DAO {


//  Akun
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertAkun(Akun akun);

    @Query("SELECT * FROM tAkun")
    Akun[] selectAllAkuns();

    @Query("SELECT * FROM tAkun WHERE username = :username LIMIT 1")
    Akun selectAkun(String username);

//  Friend
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertFriend(Friend friend);

    @Query("SELECT * FROM tFriend")
    Friend[] selectAllFriend();

    @Query("SELECT * FROM tFriend WHERE nim = :nim LIMIT 1")
    Friend selectFriend(String nim);

    @Update
    int updateFriend(Friend friend);

    @Delete
    int deleteFriend(Friend friend);
}


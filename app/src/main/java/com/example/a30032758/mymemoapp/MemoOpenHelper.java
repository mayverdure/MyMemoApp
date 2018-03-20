package com.example.a30032758.mymemoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 30032758 on 2018/03/19.
 */

public class MemoOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 1;

    public static final String CREATE_TABLE =
            "create table memos (" +
                    "_id integer primary key autoincrement, " +
                    "title text," +
                    "body text," +
                    "created datetime default current_timestamp, " +
                    "updated datetime default current_timestamp)";
    public static final String INIT_TABLE =
            "insert into memos (title, body) values " +
                    "('t1', 'b1'), " +
                    "('t2', 'b2'), " +
                    "('t3', 'b3')";
    public static final String DROP_TABLE =
            "drop table if exists " + MemoContract.Memos.TABLE_NAME;

    public MemoOpenHelper(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    // テーブルを作成するメソッドの定義
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(INIT_TABLE);
    }


    // データベースをアップグレードするメソッドの定義
    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion) {
        // 古いバージョンのテーブルが存在する場合はこれを削除
        db.execSQL(DROP_TABLE);
    }

}

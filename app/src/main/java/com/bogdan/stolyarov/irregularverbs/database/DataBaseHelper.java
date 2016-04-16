package com.bogdan.stolyarov.irregularverbs.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import com.bogdan.stolyarov.irregularverbs.MyApplication;
import com.bogdan.stolyarov.irregularverbs.util.Constants;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by bogdan on 14.04.2016.
 */
public class DataBaseHelper extends SQLiteAssetHelper {

    public static final String TAG = DataBaseHelper.class.getName();
    public static DataBaseHelper instance;

    public static final String DATABASE_NAME = "irregular_verbs.sqlite";
    public static final String TABLE_ISSUES = "irregular_verbs";
    private static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public Cursor getEmployees() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"0 _id", "INFINITIVE", "SECOND_FORM", "THIRD_FORM", "TRANSLATE"};
//        String [] sqlSelect = {"0 _id", "FullName"};

        qb.setTables(TABLE_ISSUES);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        c.moveToFirst();
        return c;

    }

}

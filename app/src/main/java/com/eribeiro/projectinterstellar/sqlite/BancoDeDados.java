package com.eribeiro.projectinterstellar.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lgpbentes on 03/09/15.
 */
public class BancoDeDados extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "AppInterstellar.db";

    private static final String SQL_CREATE_TABLE_DADOS = "CREATE TABLE Dados(" +
            "link TEXT PRIMARY KEY, data TEXT, status INTEGER)";

    private static final String SQL_DELETE_TABLE_DADOS = " DROP TABLE IF EXISTS Dados";

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_DADOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE_DADOS);
        onCreate(db);
    }
}

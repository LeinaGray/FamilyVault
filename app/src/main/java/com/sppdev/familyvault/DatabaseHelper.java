package com.sppdev.familyvault;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "FamilyVault.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "personal_info";
    private static final String ID = "ID";
    private static final String FIRST_NAME = "first_name";
    private static final String MIDDLE_NAME = "middle_name";
    private static final String LAST_NAME = "last_name";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + FIRST_NAME + " TEXT,"
                            + MIDDLE_NAME + " TEXT,"
                            + LAST_NAME + " TEXT"
                        + ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addMember(String first_name, String middle_name, String last_name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(FIRST_NAME, first_name);
        cv.put(MIDDLE_NAME, middle_name);
        cv.put(LAST_NAME, last_name);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result==-1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "New Family Member Added", Toast.LENGTH_SHORT).show();
        }
    }
}

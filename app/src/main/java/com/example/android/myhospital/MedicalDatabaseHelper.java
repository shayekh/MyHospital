package com.example.android.myhospital;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MedicalDatabaseHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME= "Medical Database";
    public static final int DATABASE_VERSION=2;
    public static final String TABLE_MEDICAL="tbl_medical";
    public static final String COL_ID="tbl_id";
    public static final String COL_NAME="tbl_doctor_name";
    public static final String COL_DETAILS="tbl_doctor_details";
    public static final String COL_DATE="tbl_date";
    public static final String COL_IMAGE="tbl_image";
    private Context context;


    public static final String CREATE_MEDICAL_TABLE= "create table "+TABLE_MEDICAL+"("+
            COL_ID+" integer primary key, "+
            COL_NAME+" text, "+
            COL_DETAILS+" text, "+
            COL_DATE+" text, "+
            COL_IMAGE+" text);";

    public MedicalDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_MEDICAL_TABLE);
        //Log.d("c","created");
        Toast.makeText(context,"Created", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+TABLE_MEDICAL);
        onCreate(db);
    }
}

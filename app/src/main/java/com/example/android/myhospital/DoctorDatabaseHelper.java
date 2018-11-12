package com.example.android.myhospital;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DoctorDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "Doctor Database";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_DOCTOR="tbl_doctor";
    public static final String COL_ID="tbl_id";
    public static final String COL_NAME="tbl_name";
    public static final String COL_DETAILS="tbl_details";
    public static final String COL_APPOINMENT="tbl_appoinment";
    public static final String COL_PHONE="tbl_phone";
    public static final String COL_EMAIL="tbl_email";
    private Context context;


    public static final String CREATE_DOCTOR_TABLE= "create table "+TABLE_DOCTOR+"("+
            COL_ID+" integer primary key, "+
            COL_NAME+" text, "+
            COL_DETAILS+" text, "+
            COL_APPOINMENT+" text, "+
            COL_PHONE+" text, "+
            COL_EMAIL+" text);";

    public DoctorDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DOCTOR_TABLE);
        //Log.d("c","created");
        Toast.makeText(context,"Created", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TABLE_DOCTOR);
        onCreate(db);

    }
}

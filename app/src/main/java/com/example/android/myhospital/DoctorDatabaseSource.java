package com.example.android.myhospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DoctorDatabaseSource {
    private DoctorDatabaseHelper doctorDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Doctors doctors;

    public DoctorDatabaseSource(Context context) {
         doctorDatabaseHelper=new DoctorDatabaseHelper(context);
    }

    public void open()
    {
      sqLiteDatabase=doctorDatabaseHelper.getWritableDatabase();
    }

    public void close()
    {
        sqLiteDatabase.close();

    }

    public boolean addDoctor(Doctors doctors)
    {
        this.open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DoctorDatabaseHelper.COL_NAME,doctors.getName());
        contentValues.put(DoctorDatabaseHelper.COL_DETAILS,doctors.getDetails());
        contentValues.put(DoctorDatabaseHelper.COL_APPOINMENT,doctors.getAppoinment());
        contentValues.put(DoctorDatabaseHelper.COL_PHONE,doctors.getPhone());
        contentValues.put(DoctorDatabaseHelper.COL_EMAIL,doctors.getEmail());
        long id=sqLiteDatabase.insert(DoctorDatabaseHelper.TABLE_DOCTOR,null,contentValues);
        this.close();
        if(id>0)
        {
            return true;
        }
        else {
            return false;
        }

    }

    public ArrayList<Doctors> getAllDoctor()
    {
        ArrayList<Doctors>doctorsArrayList=new ArrayList<>();
        this.open();
        Cursor cursor=sqLiteDatabase.query(DoctorDatabaseHelper.TABLE_DOCTOR,null,null,null,null,null,null);
        cursor.moveToFirst();
        if(cursor!=null && cursor.getCount()>0)
        {
            for(int i=0;i<cursor.getCount();i++)
            {
                int id=cursor.getInt(cursor.getColumnIndex(DoctorDatabaseHelper.COL_ID));
                String name=cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_NAME));
                String details=cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_DETAILS));
                String appoinment=cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_APPOINMENT));
                String phone=cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_PHONE));
                String email=cursor.getString(cursor.getColumnIndex(DoctorDatabaseHelper.COL_EMAIL));
                doctors=new Doctors(id,name,details,appoinment,phone,email);
                doctorsArrayList.add(doctors);
                cursor.moveToNext();


            }
        }
        cursor.close();
        this.close();
        return doctorsArrayList;
    }
}

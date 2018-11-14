package com.example.android.myhospital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MedicalDatabaseSource {

    private MedicalDatabaseHelper medicalDatabaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Medical medical;

    public MedicalDatabaseSource(Context context) {
        medicalDatabaseHelper=new MedicalDatabaseHelper(context);
    }

    public void open()
    {
        sqLiteDatabase=medicalDatabaseHelper.getWritableDatabase();
    }

    public void close()
    {
        sqLiteDatabase.close();

    }

    public boolean addMedical(Medical medical)
    {
        this.open();
        ContentValues contentValues=new ContentValues();
        contentValues.put(MedicalDatabaseHelper.COL_NAME,medical.getName());
        contentValues.put(MedicalDatabaseHelper.COL_DETAILS,medical.getDetails());
        contentValues.put(MedicalDatabaseHelper.COL_DATE,medical.getDate());
        contentValues.put(MedicalDatabaseHelper.COL_IMAGE,medical.getImage());
        long id=sqLiteDatabase.insert(MedicalDatabaseHelper.TABLE_MEDICAL,null,contentValues);
        this.close();
        if(id>0)
        {
            return true;
        }
        else {
            return false;
        }

    }

    public ArrayList<Medical> getAllMedical()
    {
        ArrayList<Medical>medicalArrayList=new ArrayList<>();
        this.open();
        Cursor cursor=sqLiteDatabase.query(MedicalDatabaseHelper.TABLE_MEDICAL,null,null,null,null,null,null);
        cursor.moveToFirst();
        if(cursor!=null && cursor.getCount()>0)
        {
            for(int i=0;i<cursor.getCount();i++)
            {
                int id=cursor.getInt(cursor.getColumnIndex(MedicalDatabaseHelper.COL_ID));
                String name=cursor.getString(cursor.getColumnIndex(MedicalDatabaseHelper.COL_NAME));
                String details=cursor.getString(cursor.getColumnIndex(MedicalDatabaseHelper.COL_DETAILS));
                String date=cursor.getString(cursor.getColumnIndex(MedicalDatabaseHelper.COL_DATE));
                String image=cursor.getString(cursor.getColumnIndex(MedicalDatabaseHelper.COL_IMAGE));
                medical=new Medical(id,name,details,date,image);
                medicalArrayList.add(medical);
                cursor.moveToNext();


            }
        }
        cursor.close();
        this.close();
        return medicalArrayList;
    }

}

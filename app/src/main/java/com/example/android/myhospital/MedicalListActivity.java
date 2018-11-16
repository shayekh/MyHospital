package com.example.android.myhospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MedicalListActivity extends AppCompatActivity {

    private ListView nListView;
    private MedicalAdapter medicalAdapter;
    private ArrayList<Medical> medicalArrayList;
    private MedicalDatabaseSource medicalDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_list);
        nListView=(ListView) findViewById(R.id.medicalListView);
        medicalDatabaseSource=new MedicalDatabaseSource(this);
        medicalArrayList=medicalDatabaseSource.getAllMedical();
        medicalAdapter=new MedicalAdapter(this,medicalArrayList);
        nListView.setAdapter(medicalAdapter);

    }

  
}

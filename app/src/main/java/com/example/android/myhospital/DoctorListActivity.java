package com.example.android.myhospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DoctorListActivity extends AppCompatActivity {
    private ListView mListView;
    private DoctorsAdapter doctorsAdapter;
    private ArrayList<Doctors>doctorsArrayList;
    private DoctorDatabaseSource doctorDatabaseSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);
        mListView=(ListView) findViewById(R.id.listView);
        doctorDatabaseSource=new DoctorDatabaseSource(this);
        doctorsArrayList=doctorDatabaseSource.getAllDoctor();
        doctorsAdapter=new DoctorsAdapter(this,doctorsArrayList);
        mListView.setAdapter(doctorsAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=doctorsArrayList.get(position).getName();
                String details=doctorsArrayList.get(position).getDetails();
                String appoinment=doctorsArrayList.get(position).getAppoinment();
                String phone=doctorsArrayList.get(position).getPhone();
                String email=doctorsArrayList.get(position).getEmail();
                int rowId=doctorsArrayList.get(position).getId();

                Intent intent=new Intent(DoctorListActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("id",rowId)
                        .putExtra("name",name)
                        .putExtra("details",details)
                        .putExtra("appoinment",appoinment)
                        .putExtra("phone",phone)
                        .putExtra("email",email);
                startActivity(intent);
            }
        });
    }
}

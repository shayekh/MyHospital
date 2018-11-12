package com.example.android.myhospital;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String name,details,appoinment,phone,email;
    private int rowId;
    private EditText name1,details1,appoinment1,phone1,email1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        name1=(EditText)findViewById(R.id.name);
        details1=(EditText)findViewById(R.id.details);
        appoinment1=(EditText)findViewById(R.id.appoinment);
        phone1=(EditText)findViewById(R.id.phone);
        email1=(EditText)findViewById(R.id.email);

        name=getIntent().getStringExtra("name");
        details=getIntent().getStringExtra("details");
        appoinment=getIntent().getStringExtra("appoinment");
        phone=getIntent().getStringExtra("phone");
        email=getIntent().getStringExtra("email");
        rowId=getIntent().getIntExtra("id",0);

        name1.setText(name);
        details1.setText(details);
        appoinment1.setText(appoinment);
        phone1.setText(phone);
        email1.setText(email);


    }
}

package com.example.android.myhospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddDoctors extends AppCompatActivity {

    private EditText nameET;
    private EditText detailsET;
    private EditText appointmentET;
    private EditText phoneET;
    private EditText emailET;
    private Doctors doctor;
    private DoctorDatabaseSource doctorDatabaseSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctors);
        nameET=(EditText)findViewById(R.id.name);
        detailsET=(EditText)findViewById(R.id.details);
        appointmentET=(EditText)findViewById(R.id.appoinment);
        phoneET=(EditText)findViewById(R.id.phone);
        emailET=(EditText)findViewById(R.id.email);
        doctorDatabaseSource=new DoctorDatabaseSource(this);
    }

    public void addDoctor()
    {
        String name=nameET.getText().toString();
        String details=detailsET.getText().toString();
        String appoinment=appointmentET.getText().toString();
        String phone=phoneET.getText().toString();
        String email=emailET.getText().toString();

        if(name.isEmpty())
        {
            nameET.setError("This field must not be empty");
        }
        else if(details.isEmpty())
        {
            detailsET.setError("This field must not be empty");
        }
        else if(appoinment.isEmpty())
        {
            appointmentET.setError("This field must not be empty");
        }
        else if(phone.isEmpty())
        {
            phoneET.setError("This field must not be empty");
        }
        else if(email.isEmpty())
        {
            emailET.setError("This field must not be empty");
        }

        else {
            doctor=new Doctors(name,details,appoinment,phone,email);
            boolean status=doctorDatabaseSource.addDoctor(doctor);
            if(status)
            {
                Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AddDoctors.this,DoctorListActivity.class);
                startActivity(intent);


            }
            else {
                Toast.makeText(this,"Could not save",Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.add_doctors, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_save_doctor:
                addDoctor();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

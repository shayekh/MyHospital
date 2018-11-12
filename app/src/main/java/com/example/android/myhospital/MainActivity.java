package com.example.android.myhospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewFlipper viewFlipper;
    CardView doctorsList;
    CardView medicalHistoryList;
    CardView addDoctors;
    CardView addMedicalHistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[]={R.drawable.heart,R.drawable.stethoscope,R.drawable.syringe};
        viewFlipper=findViewById(R.id.viewfilpper);
        doctorsList=findViewById(R.id.doctorslist);
        medicalHistoryList=findViewById(R.id.medicalList);
        addDoctors=findViewById(R.id.addDoctors);
        addMedicalHistory=findViewById(R.id.addMedicalHistory);

        doctorsList.setOnClickListener(this);
        medicalHistoryList.setOnClickListener(this);
        addDoctors.setOnClickListener(this);
        addMedicalHistory.setOnClickListener(this);
        for(int image:images)
        {
            flipperImages(image);
        }
    }

    private void flipperImages(int image) {

        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);

        //animation
        viewFlipper.setInAnimation(this,android.R.anim.fade_in);
        viewFlipper.setOutAnimation(this,android.R.anim.fade_out);

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.addDoctors)
        {
            Intent intent=new Intent(MainActivity.this,AddDoctors.class);
            startActivity(intent);
        }
        else if(view.getId()==R.id.addMedicalHistory)
        {
            Intent intent=new Intent(MainActivity.this,AddMedicalHistory.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.doctorslist)
        {
            Intent intent=new Intent(MainActivity.this,DoctorListActivity.class);
            startActivity(intent);

        }
        else if(view.getId()==R.id.medicalList)
        {

        }


    }
}

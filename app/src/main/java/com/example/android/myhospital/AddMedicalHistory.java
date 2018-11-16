package com.example.android.myhospital;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class AddMedicalHistory extends AppCompatActivity {
    private EditText doctorNameET;
    private EditText doctorDetailsET;
    private EditText dateET;
    private CardView cardView;
    private static final int REQUEST_CODE_FOR_CAMERA = 1;
    private String imageFromCamera;
    private ImageView imageView;
    private Medical medical;
    private MedicalDatabaseSource medicalDatabaseSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_medical_history);
        doctorNameET=(EditText)findViewById(R.id.dnameET);
        doctorDetailsET=(EditText)findViewById(R.id.ddetailsET);
        dateET=(EditText)findViewById(R.id.ddateET);
        cardView=(CardView)findViewById(R.id.takepres);
        imageView=(ImageView)findViewById(R.id.gallery);
        medicalDatabaseSource=new MedicalDatabaseSource(this);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) !=null);{
                    startActivityForResult(intent, REQUEST_CODE_FOR_CAMERA);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE_FOR_CAMERA && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageFromCamera = encodeImage(bitmap, Bitmap.CompressFormat.JPEG, 70);
            imageView.setImageBitmap(bitmap);
        }
    }

    public static String encodeImage(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int quality){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, quality, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);
    }

    public void addMedical()
    {
        String name=doctorNameET.getText().toString();
        String details=doctorDetailsET.getText().toString();
        String date=dateET.getText().toString();

        if(name.isEmpty())
        {
            doctorNameET.setError("This field must not be empty");
        }
        else if(details.isEmpty())
        {
            doctorDetailsET.setError("This field must not be empty");
        }
        else if(date.isEmpty())
        {
            dateET.setError("This field must not be empty");
        }
         else if(imageFromCamera==null)
        {
            Toast.makeText(this, "Take a Snap ", Toast.LENGTH_LONG).show();
        }
        else {
            medical=new Medical(name,details,date,imageFromCamera);
            boolean status=medicalDatabaseSource.addMedical(medical);
            if(status)
            {
                Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(AddMedicalHistory.this,MedicalListActivity.class);
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
                addMedical();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.android.myhospital;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MedicalAdapter extends ArrayAdapter<Medical> {

    public MedicalAdapter(Activity context, ArrayList<Medical> wa) {
        super(context, 0, wa);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.medical_list_row, parent, false);

        }
        Medical e = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.doctor);
        name.setText(e.getName());
        TextView details = (TextView) listItemView.findViewById(R.id.detailsDoctor);
        details.setText(e.getDetails());
        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(e.getDate());
        ImageView imageView=(ImageView)listItemView.findViewById(R.id.prescriptionImage);
        imageView.setImageBitmap(decodeImage(e.getImage()));
        return listItemView;
    }

    public static Bitmap decodeImage(String input){
        byte[] decodeByte = Base64.decode(input, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodeByte, 0, decodeByte.length);
    }


}

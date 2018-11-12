package com.example.android.myhospital;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DoctorsAdapter extends ArrayAdapter<Doctors> {

    public DoctorsAdapter(Activity context, ArrayList<Doctors> wa) {
        super(context, 0, wa);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.doctor_list_row, parent, false);

        }

        Doctors e = getItem(position);
        TextView name=(TextView)listItemView.findViewById(R.id.doctorNameText);
        name.setText(e.getName());
        TextView phoneNumber=(TextView)listItemView.findViewById(R.id.phoneText);
        phoneNumber.setText(e.getPhone());
        TextView email=(TextView)listItemView.findViewById(R.id.emailText);
        email.setText(e.getEmail());
        TextView details=(TextView)listItemView.findViewById(R.id.detailsText);
        details.setText(e.getDetails());
        TextView appointment=(TextView)listItemView.findViewById(R.id.dateText);
        appointment.setText(e.getAppoinment());
        return listItemView;
    }
}

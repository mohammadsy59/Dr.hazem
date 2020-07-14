package com.example.drhazem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyArrayAdapter extends BaseAdapter {
Context context;
ArrayList<Patient> arrayList;
public MyArrayAdapter(Context context,ArrayList<Patient> arrayList)
{
    this.context = context;
    this.arrayList = arrayList;


}

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    if(convertView == null)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.patient_list_view,null);
        TextView txt_name = convertView.findViewById(R.id.NameLayout);
        TextView txt_age = convertView.findViewById(R.id.AgeLayout);
        TextView txt_diagnose = convertView.findViewById(R.id.diagnoseLayout);
        TextView txt_department = convertView.findViewById(R.id.departmentLayout);
        Patient patient = arrayList.get(position);
        txt_name.setText(patient.getName());
        txt_age.setText(patient.getAge());
        txt_diagnose.setText(patient.getDiagnose());
        txt_department.setText(patient.getDepartment());


    }

        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }




    //    public MyArrayAdapter(Context context, ArrayList<Patient>  patients) {
//        super(context, 0,patients);
//    }
//    @Override
//    public View getView(int position, View convertView , ViewGroup parent){
//      Patient patient = getItem(position);
//      if (convertView == null){
//          convertView = LayoutInflater.from(getContext()).inflate(R.layout.patient_list_view,parent,false);
//      }
//
//        TextView tvName  = convertView.findViewById(R.id.NameLayout);
//        TextView tvAge  = convertView.findViewById(R.id.AgeLayout);
//        TextView tvDiagnose  = convertView.findViewById(R.id.diagnoseLayout);
//        TextView tvDepartment  = convertView.findViewById(R.id.departmentLayout);
//
//
//        tvName.setText(patient.name);
//        tvAge.setText(patient.age);
//        tvDiagnose.setText(patient.diagnose);
//        tvDepartment.setText(patient.department);
//        return  convertView;
//
//    }
//

}

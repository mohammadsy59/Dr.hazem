package com.example.drhazem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatient extends AppCompatActivity {
    EditText addNameEDT;
    EditText addAgeEDT;
    EditText addDiagnoseEDT;
    EditText addDepartmentEDT;
    Button saveBT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        addNameEDT = findViewById(R.id.patientNameEditTXT);
        addAgeEDT = findViewById(R.id.patientAgeEditTXT);
        addDiagnoseEDT = findViewById(R.id.patientDiagnoseEditTXT);
        addDepartmentEDT = findViewById(R.id.patientDepartmentEditTXT);
        saveBT = findViewById(R.id.savePatientBT);


    }

    public void saveNewPatientFun(View view) {
        DBConnections db = new DBConnections(this);
        db.insertRowPatient(
                addNameEDT.getText().toString(),
                addAgeEDT.getText().toString(),
                addDiagnoseEDT.getText().toString(),
                addDepartmentEDT.getText().toString());
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
        Toast.makeText(getApplicationContext(),
                "name : " + addNameEDT.getText() + "age :" + addAgeEDT.getText() + "diagnose :" + addDiagnoseEDT.getText() +
                "department :" +addDepartmentEDT.getText(),Toast.LENGTH_LONG).show();

    }
}

package com.example.drhazem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBConnections databaseHelper;
    ListView listView;
    ArrayList<Patient> arrayList;
    MyArrayAdapter myArrayAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =  findViewById(R.id.patientsListView);
        databaseHelper = new DBConnections(this);
        arrayList = new ArrayList<>();
        loadDatatoListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                databaseHelper.deleteRecord((int) l);
                databaseHelper.getAllrecord();
                myArrayAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), Integer.toString(i), Toast.LENGTH_SHORT).show();
            }
        });

















//        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                patients.add(new Patient("mohammad", "22", "schezo", "icu"));
//                Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_SHORT).show();
//                myArrayAdapter.notifyDataSetChanged();
//            }
//        });
//
//    }
//

    }
    public void NAVTOAddNewPatient(View view) {
        Intent intent = new Intent(this, AddPatient.class);
        startActivity(intent);}

    private void loadDatatoListView() {
        arrayList = databaseHelper.getAllrecord();

        myArrayAdapter = new MyArrayAdapter(this,arrayList);
        listView.setAdapter(myArrayAdapter);
        myArrayAdapter.notifyDataSetChanged();

    }


}





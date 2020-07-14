package com.example.drhazem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBConnections extends SQLiteOpenHelper {
    public static final int version=1;
    public static final String DBName= "drhazem.db";
    public DBConnections(Context context){
        super(context,DBName,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create table IF NOT EXISTS patients (id INTEGER primary key,name TEXT," +
             "age INTEGER,diagnose TEXT,department TEXt)");
     db.execSQL("create table IF NOT EXISTS descriptions (id INTEGER primary key,description TEXT," +
             "patientId INTEGER," +
             "foreign key (patientId) references patients(id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      db.execSQL("DROP table if EXISTS patients");
      onCreate(db);
    }
    public  void insertRowPatient (String name,String age,String diagnose,String department){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("diagnose",diagnose);
        contentValues.put("department",department);


        db.insert("patients",null,contentValues);
    }
    public ArrayList getAllPatients (){
        ArrayList arrayList  = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res  = db.rawQuery("select * from patients",null);
        res.moveToFirst();
        while (res.isAfterLast() == false){

//            arrayList.add(res.getString(res.getColumnIndex("name")));
            res.moveToNext();
        }
        return arrayList;
    }

    public ArrayList<Patient> getAllrecord (){
        ArrayList<Patient> arrayList = new ArrayList<>();
        SQLiteDatabase db  = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM patients",null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String age = cursor.getString(2);
            String diagnose = cursor.getString(3);
            String department = cursor.getString(4);

            Patient patient = new Patient(id,name,age,diagnose,department);
            arrayList.add(patient);
        }
        return arrayList;
    }

    public void deleteRecord (Integer id)
    {

        SQLiteDatabase db = this.getWritableDatabase();
//        db.execSQL("delete from patients where id=" +Integer.toString(id));
        db.delete("patients","id = ?",new String[]{Integer.toString(id)});


    }
}

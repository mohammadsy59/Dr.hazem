package com.example.drhazem;

import android.database.sqlite.SQLiteDatabase;

public class Patient {
    public int id;
    public String name;
    public String age;
    public String diagnose;
    public String department;





    Patient(int id,String name, String  age,String diagnose,String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.diagnose = diagnose;
        this.department = department;


    }
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public String getDepartment() {
        return department;
    }
}

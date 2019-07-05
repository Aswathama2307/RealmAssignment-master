package com.example.realmassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private EditText name;
    private EditText dept;
    private EditText roll;
    private EditText phone;
    private Switch sw;

    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        name = findViewById(R.id.main_name_et);
        dept = findViewById(R.id.main_dept_et);
        roll = findViewById(R.id.main_roll_et);
        phone = findViewById(R.id.main_phone_et);
        sw = findViewById(R.id.main_gender_sw);
        gender = "Male";
    }

    public void saveData(View view) {

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        try {

            Student student = realm.createObject(Student.class, System.currentTimeMillis() / 1000);
            student.setName(name.getText().toString());
            student.setDept(dept.getText().toString());
            student.setRoll(Integer.parseInt(String.valueOf(roll.getText())));
            student.setPhone((phone.getText().toString()));

            if(sw.isChecked()) {
                gender = "Female";
            } else {
                gender = "Male";
            }
            student.setGender(gender);

            realm.commitTransaction();
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            realm.cancelTransaction();
            Toast.makeText(context, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();

        }

        realm.close();

    }


    public void displayData(View view) {

        Intent intent = new Intent(context, DisplayActivity.class);
        startActivity(intent);

    }

}

package com.example.realmassignment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.Realm;
import io.realm.RealmResults;

public class DisplayActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_activity);

        recyclerView = findViewById(R.id.studentRecycler);
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Student> studentRealmResults = realm.where(Student.class).findAll();

        MyAdapter myAdapter = new MyAdapter(studentRealmResults, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);

    }
}

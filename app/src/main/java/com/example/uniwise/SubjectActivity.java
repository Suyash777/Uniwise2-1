package com.example.uniwise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class SubjectActivity extends AppCompatActivity {

    String[] ITsubjectList={"JAVA","CS","JS"};
    String[] COMPsubjectList={"Android","NMA","JSP"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Intent intent=getIntent();
        String Subject=intent.getStringExtra("ITkey");
        
        RecyclerView Subjects = findViewById(R.id.list_subs);
        Subjects.setLayoutManager(new LinearLayoutManager(this));



        switch (Subject) {
            case "IT":
            Subjects.setAdapter(new SubjectsAdapter(ITsubjectList));
            break;
            case "COMP":
                Subjects.setAdapter(new SubjectsAdapter(COMPsubjectList));
                break;
        }

    }




}

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

    String[] empty={"Empty List","Empty List"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        Intent intent = getIntent();
        String[] ITsubjectList = intent.getStringArrayExtra("ITkey");
        String[] COMPsubjectList = intent.getStringArrayExtra("COMPkey");
        String[] MECHsubjectList=intent.getStringArrayExtra("MECHkey");
        String[] CIVILsubjectList=intent.getStringArrayExtra("CIVILkey");
        String[] ELECTRICALsubjectList=intent.getStringArrayExtra("ELECkey");
        String[] ENTCsubjectList=intent.getStringArrayExtra("ENTCkey");
        String[] METAsubjectList=intent.getStringArrayExtra("METAkey");
        String[] DDGMsubjectList=intent.getStringArrayExtra("DDGMkey");
        String[] MATHsubjectList=intent.getStringArrayExtra("MATHkey");
        String[] ENGsubjectList=intent.getStringArrayExtra("ENGkey");
        String[] PHYSICSsubjectList=intent.getStringArrayExtra("PHYSICSkey");
        String[] CHEMsubjectList=intent.getStringArrayExtra("CHEMkey");

        RecyclerView Subjects = findViewById(R.id.list_subs);
        Subjects.setLayoutManager(new LinearLayoutManager(this));
        if(ITsubjectList!=null) {
            Subjects.setAdapter(new SubjectsAdapter(ITsubjectList));
        }
        else if(COMPsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(COMPsubjectList));
        }
        else if(MECHsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(MECHsubjectList));
        }
        else if(CIVILsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(CIVILsubjectList));
        }
        else if(ELECTRICALsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(ELECTRICALsubjectList));
        }
        else if(ENTCsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(ENTCsubjectList));
        }
        else if(METAsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(METAsubjectList));
        }
        else if(DDGMsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(DDGMsubjectList));
        }
        else if(MATHsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(MATHsubjectList));
        }
        else if(ENGsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(ENGsubjectList));
        }
        else if(PHYSICSsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(PHYSICSsubjectList));
        }
        else if(CHEMsubjectList!=null){
            Subjects.setAdapter(new SubjectsAdapter(CHEMsubjectList));
        }
        else {
            Subjects.setAdapter(new SubjectsAdapter(empty));
        }
    }

}






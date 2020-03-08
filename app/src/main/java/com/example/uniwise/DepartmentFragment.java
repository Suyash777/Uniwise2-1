package com.example.uniwise;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class DepartmentFragment extends Fragment {
    String[] IT={"JAVA","CS","JS"};
    String[] COMP={"Android","NMA","JSP"};




    public DepartmentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_department, container, false);

        CardView cdIT=(CardView)rootView.findViewById(R.id.itCard);
        CardView cdComp=(CardView)rootView.findViewById(R.id.compCard);
        CardView cdMech=(CardView)rootView.findViewById(R.id.mechanicalCard);
        CardView cdCivil=(CardView)rootView.findViewById(R.id.civilCard);
        CardView cdElectric=(CardView)rootView.findViewById(R.id.electricalCard);
        CardView cdENTC=(CardView)rootView.findViewById(R.id.entcCard);
        CardView cdMeta=(CardView)rootView.findViewById(R.id.metallurgyCard);
        CardView cdDDGM=(CardView)rootView.findViewById(R.id.ddgmCard);
        CardView cdMath=(CardView)rootView.findViewById(R.id.mathCard);
        CardView cdEng=(CardView)rootView.findViewById(R.id.englishCard);
        CardView cdPhy=(CardView)rootView.findViewById(R.id.physicsCard);
        CardView cdChem=(CardView)rootView.findViewById(R.id.chemCard);


        cdIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("ITkey",IT);
                getActivity().startActivity(intent);

            }
        });

        cdComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                intent.putExtra("COMPkey",COMP);
                getActivity().startActivity(intent);
            }
        });

        cdMech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdCivil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdElectric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdENTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdMeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdDDGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdPhy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });

        cdChem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent=new Intent(getActivity(),SubjectActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return rootView;
    }

}

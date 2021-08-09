package com.systrack.admission.fragment.Examination;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.Activity.ClassTimingBatchActivity;
import com.systrack.admission.Activity.ClassTimingSectionActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BroadsheetFragment extends Fragment {


    View view;
LinearLayout search;
    AppController appController;
    EditText course_edittext,medium_edittext,year_edittext,batch_edittext,section_edittext,division_edittext;
    TextView error;
    SharedPreferences sharedPreferences;
ImageView back_arrow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_broadsheet, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();
        sharedPreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);


        appController.setBroadSheet_batch_id(null);
        appController.setBroadSheet_batchName(null);
        appController.setBroadSheet_Medium(null);
        appController.setBroadSheet_sectionId(null);
        appController.setBroadSheet_sectionName(null);
        appController.setBroadSheet_streamId(null);
        appController.setBroadSheet_streamName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setModerator_affiliation_medium(null);

                appController.setManageEmpCourseFlag("BroadSheet");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appController.setManageEmpMediumFlag("BroadSheet");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });
        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("BroadSheet");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });
        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("BroadSheet");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });


        search=view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchData();
            }
        });
       back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ExaminationMenuFragment coursefragment = new ExaminationMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");
        if(appController.getBroadSheet_streamName()!=null){
            course_edittext.setText(appController.getBroadSheet_streamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getBroadSheet_Medium()!=null){
            medium_edittext.setText(appController.getBroadSheet_Medium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getBroadSheet_batchName()!=null){
            batch_edittext.setText(appController.getBroadSheet_batchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getBroadSheet_sectionName()!=null){
            section_edittext.setText(appController.getBroadSheet_sectionName());
        }else{
            section_edittext.setText("");
        }


    }

    private void SearchData() {

        if (course_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Course data required");
        } else if (medium_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Medium data required");
        } else if (batch_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Batch data required");
        } else if (section_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Section data required");
        }  else {


            SearchBroadSheetListFragement coursefragment = new SearchBroadSheetListFragement();
            FragmentTransaction country = getFragmentManager().beginTransaction();
            country.replace(R.id.frame, coursefragment);
            country.commit();


        }
    }

}

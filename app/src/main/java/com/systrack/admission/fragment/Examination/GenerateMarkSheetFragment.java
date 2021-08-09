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
import com.systrack.admission.Activity.CourseMgtDivisionActivity;
import com.systrack.admission.Activity.ExamTimetableAcademicYearActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.Activity.StudentAttendanceSubjectActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenerateMarkSheetFragment extends Fragment {


    View view;
LinearLayout search;
    AppController appController;
    EditText course_edittext,medium_edittext,subject_edittext,batch_edittext,section_edittext,division_edittext;
    TextView error;
    SharedPreferences sharedPreferences;
    boolean  ISALLOWDIVISION;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_generate_marksheet, container, false);

        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();
        sharedPreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        ISALLOWDIVISION = sharedPreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);

        appController.setGenerate_marksheet_batchId(null);
        appController.setGenerate_marksheet_batchName(null);
        appController.setGenerate_marksheet_divisionId(null);
        appController.setGenerate_marksheet_divisionName(null);
        appController.setGenerate_marksheet_medium(null);
        appController.setGenerate_marksheet_sectionName(null);
        appController.setGenerate_marksheet_streamId(null);
        appController.setGenerate_marksheet_streamName(null);
        appController.setGenerate_marksheet_subjectId(null);
        appController.setGenerate_marksheet_subjectName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setGenerate_marksheet_medium(null);

                appController.setManageEmpCourseFlag("GenerateMarkSheet");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appController.setManageEmpMediumFlag("GenerateMarkSheet");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });
        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("GenerateMarkSheet");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });
        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("GenerateMarkSheet");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });

        subject_edittext=view.findViewById(R.id.subject_edittext);
        subject_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setStuAttendanceSubFlag("GenerateMarkSheet");
                Intent i=new Intent(getActivity(), StudentAttendanceSubjectActivity.class);
                startActivity(i);
            }
        });
        division_edittext=view.findViewById(R.id.division_edittext);
        division_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setCourseMgtDivisionFlag("GenerateMarkSheet");
                Intent i=new Intent(getActivity(), CourseMgtDivisionActivity.class);
                startActivity(i);
            }
        });
        if(ISALLOWDIVISION){
            division_edittext.setVisibility(View.VISIBLE);
        }else{
            division_edittext.setVisibility(View.GONE);
        }

        search=view.findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SearchData();

            }
        });
       ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


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
        if(appController.getGenerate_marksheet_subjectName()!=null){
            subject_edittext.setText(appController.getGenerate_marksheet_subjectName());
        }else{
            subject_edittext.setText("");
        }

        if(appController.getGenerate_marksheet_streamName()!=null){
            course_edittext.setText(appController.getGenerate_marksheet_streamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getGenerate_marksheet_medium()!=null){
            medium_edittext.setText(appController.getGenerate_marksheet_medium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getGenerate_marksheet_batchId()!=null){
            batch_edittext.setText(appController.getGenerate_marksheet_batchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getGenerate_marksheet_sectionName()!=null){
            section_edittext.setText(appController.getGenerate_marksheet_sectionName());
        }else{
            section_edittext.setText("");
        }

        if(appController.getGenerate_marksheet_divisionName()!=null){
            division_edittext.setText(appController.getGenerate_marksheet_divisionName());
        }else{
            division_edittext.setText("");
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
        } else if (subject_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Subject data required");
        } else if (division_edittext.getText().toString().equals("") && ISALLOWDIVISION) {
            error.setVisibility(View.VISIBLE);
            error.setText("Division data required");
        } else {


            SearchGenerateMarksheetFragement coursefragment = new SearchGenerateMarksheetFragement();
            FragmentTransaction country = getFragmentManager().beginTransaction();
            country.replace(R.id.frame, coursefragment);
            country.commit();


        }
    }



}

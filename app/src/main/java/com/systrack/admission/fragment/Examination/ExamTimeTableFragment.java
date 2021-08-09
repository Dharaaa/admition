package com.systrack.admission.fragment.Examination;


import android.content.Intent;
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
import com.systrack.admission.Activity.ExamTimetableAcademicYearActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.Hr.HrMenuFragment;
import com.systrack.admission.fragment.Hr.SearchManageEmpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamTimeTableFragment extends Fragment {


    View view;
LinearLayout search_timetable;
AppController appController;
EditText course_edittext,medium_edittext,year_edittext,batch_edittext,section_edittext;
TextView error;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_exam_timetable, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();

        appController.setExamTimeTableYearName(null);
        appController.setExamTimeTableYearId(null);
        appController.setExamTimeTableMedium(null);
        appController.setExamTimetableStreamId(null);
        appController.setExamTimeTableStreamName(null);
        appController.setExamTimeTableBatchId(null);
        appController.setExamTimeTableBatchName(null);
        appController.setExamTimeTableSectionName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimeTableMedium(null);

                appController.setManageEmpCourseFlag("ExamTimeTable");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("ExamTimeTable");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });
        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("ExamTimeTable");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });
        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("ExamTimeTable");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });

        year_edittext=view.findViewById(R.id.academic_year_edittext);
        year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimetableYearFlag("ExamTimeTable");
                Intent i=new Intent(getActivity(), ExamTimetableAcademicYearActivity.class);
                startActivity(i);
            }
        });

        search_timetable=view.findViewById(R.id.search_timetable);
        search_timetable.setOnClickListener(new View.OnClickListener() {
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
        } else if (year_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Academic Year data required");
        } else {


            SearchExamTimeTableFragment coursefragment = new SearchExamTimeTableFragment();
            FragmentTransaction country = getFragmentManager().beginTransaction();
            country.replace(R.id.frame, coursefragment);
            country.commit();


        }
    }
        @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");
        if(appController.getExamTimeTableYearName()!=null){
            year_edittext.setText(appController.getExamTimeTableYearName());
        }else{
            year_edittext.setText("");
        }

        if(appController.getExamTimeTableStreamName()!=null){
            course_edittext.setText(appController.getExamTimeTableStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getExamTimeTableMedium()!=null){
            medium_edittext.setText(appController.getExamTimeTableMedium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getExamTimeTableBatchName()!=null){
            batch_edittext.setText(appController.getExamTimeTableBatchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getExamTimeTableSectionName()!=null){
            section_edittext.setText(appController.getExamTimeTableSectionName());
        }else{
            section_edittext.setText("");
        }
    }




}

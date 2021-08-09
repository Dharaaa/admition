package com.systrack.admission.fragment.Assignment;


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
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.Activity.ClassTimingBatchActivity;
import com.systrack.admission.Activity.ClassTimingSectionActivity;
import com.systrack.admission.Activity.CourseMgtDivisionActivity;
import com.systrack.admission.Activity.ExamTimetableAcademicYearActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.CourseManagement.CourseMgtMenuFragment;
import com.systrack.admission.fragment.ManageStudent.SearchManageStudentFragment;
import com.systrack.admission.fragment.StudentAttendance.SearchLectureAttendanceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AssignmentFragment extends Fragment {


    View view;
LinearLayout search_employee;
EditText course_edittext,medium_edittext,year_edittext,batch_edittext,section_edittext,division_edittext;
    AppController appController;
    TextView error;
boolean ISALLOWDIVISION;
SharedPreferences sharedpreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_assignment, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();

        appController.setAssignment_batchId(null);
        appController.setAssignment_batchName(null);
        appController.setAssignment_divId(null);
        appController.setAssignment_medium(null);
        appController.setAssignment_divName(null);
        appController.setAssignment_sectionId(null);
        appController.setAssignment_sectionName(null);
        appController.setAssignment_streamId(null);
        appController.setAssignment_streamName(null);
        appController.setAssignment_yearId(null);
        appController.setAssignment_yearName(null);
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);


        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setAssignment_medium(null);

                appController.setManageEmpCourseFlag("Assignment");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("Assignment");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("Assignment");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });
        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("Assignment");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });

        year_edittext=view.findViewById(R.id.academic_year_edittext);
        year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimetableYearFlag("Assignment");
                Intent i=new Intent(getActivity(), ExamTimetableAcademicYearActivity.class);
                startActivity(i);
            }
        });
        division_edittext=view.findViewById(R.id.division_edittext);
        division_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimetableYearFlag("Assignment");
                Intent i=new Intent(getActivity(), CourseMgtDivisionActivity.class);
                startActivity(i);
            }
        });

        if(ISALLOWDIVISION){
            division_edittext.setVisibility(View.VISIBLE);
        }else {
            division_edittext.setVisibility(View.GONE);
        }


        search_employee=view.findViewById(R.id.search_employee);
        search_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchData();

            }
        });
        ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                CourseMgtMenuFragment coursefragment = new CourseMgtMenuFragment();
//                FragmentTransaction country = getFragmentManager().beginTransaction();
//                country.replace(R.id.frame, coursefragment);
//                country.commit();

            }
        });

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");
        if(appController.getAssignment_yearName()!=null){
            year_edittext.setText(appController.getAssignment_yearName());
        }else{
            year_edittext.setText("");
        }

        if(appController.getAssignment_streamName()!=null){
            course_edittext.setText(appController.getAssignment_streamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getAssignment_medium()!=null){
            medium_edittext.setText(appController.getAssignment_medium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getManage_student_batchName()!=null){
            batch_edittext.setText(appController.getManage_student_batchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getAssignment_sectionName()!=null){
            section_edittext.setText(appController.getAssignment_sectionName());
        }else{
            section_edittext.setText("");
        }

        if(appController.getAssignment_divName()!=null){
            division_edittext.setText(appController.getAssignment_divName());
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
        } else if (year_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Academic Year data required");
        } else if (ISALLOWDIVISION && division_edittext.getText().toString().equals("")) {
            error.setVisibility(View.VISIBLE);
            error.setText("Division data required");
        } else {


            SearchAssignmentFragment searchManageEmpFragment = new SearchAssignmentFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,searchManageEmpFragment);
            transaction.commit();

        }
    }

}

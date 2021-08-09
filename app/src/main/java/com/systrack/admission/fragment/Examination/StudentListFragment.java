package com.systrack.admission.fragment.Examination;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.Activity.ExamTimetableAcademicYearActivity;
import com.systrack.admission.Activity.HallArrangementExamHallNoActivity;
import com.systrack.admission.Activity.HallArrangementExamNameActivity;
import com.systrack.admission.Activity.HallArrangementExamTimeActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentListFragment extends Fragment {


    View view;
LinearLayout search_student_list;
    EditText academic_year_edittext,exam_nm_edittext,hall_no_edittext,exam_time_edittext;
    AppController appController;
    TextView error;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_student_list, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();
        appController.setStudent_list_examId(null);
        appController.setStudent_list_examName(null);
        appController.setStudent_list_examTimeName(null);
        appController.setStudent_list_hallId(null);
        appController.setStudent_list_hallName(null);
        appController.setStudent_list_year_id(null);
        appController.setStudent_list_yearName(null);


        academic_year_edittext=view.findViewById(R.id.academic_year_edittext);
        academic_year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimetableYearFlag("StudentList");
                Intent i=new Intent(getActivity(), ExamTimetableAcademicYearActivity.class);
                startActivity(i);
            }
        });
        exam_nm_edittext=view.findViewById(R.id.exam_nm_edittext);
        exam_nm_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setStudent_list_examTimeName(null);
                appController.setHallArrangementExamNameFlag("StudentList");
                Intent i=new Intent(getActivity(), HallArrangementExamNameActivity.class);
                startActivity(i);
            }
        });


        hall_no_edittext=view.findViewById(R.id.hall_no_edittext);
        hall_no_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setStudent_list_examTimeName(null);

                appController.setHallArrangementExamNoFlag("StudentList");
                Intent i=new Intent(getActivity(), HallArrangementExamHallNoActivity.class);
                startActivity(i);
            }
        });

        exam_time_edittext=view.findViewById(R.id.exam_time_edittext);
        exam_time_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                appController.setHallArrangementExamNoFlag("StudentList");
                Intent i=new Intent(getActivity(), HallArrangementExamTimeActivity.class);
                startActivity(i);
            }
        });


        search_student_list=view.findViewById(R.id.search_student_list);
        search_student_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SearchData();
            }
        });

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");

        if(appController.getStudent_list_yearName()!=null){
            academic_year_edittext.setText(appController.getStudent_list_yearName());
        }else{
            academic_year_edittext.setText("");
        }

        if(appController.getStudent_list_examName()!=null){
            exam_nm_edittext.setText(appController.getStudent_list_examName());
        }else{
            exam_nm_edittext.setText("");
        }

        if(appController.getStudent_list_hallName()!=null){
            hall_no_edittext.setText(appController.getStudent_list_hallName());
        }else{
            hall_no_edittext.setText("");
        }
        if(appController.getStudent_list_examTimeName()!=null){
            exam_time_edittext.setText(appController.getStudent_list_examTimeName());
        }else{
            exam_time_edittext.setText("");
        }

    }
    private void SearchData() {

        if(academic_year_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Academic Year data required" );
        } else if(exam_nm_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Exam Name data required" );
        } else if(hall_no_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Hall No data required" );
        } else if(exam_time_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Exam Time data required" );
        }else {


            SearchStudentListFragement coursefragment = new SearchStudentListFragement();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,coursefragment);
            transaction.commit();

        }


    }


}

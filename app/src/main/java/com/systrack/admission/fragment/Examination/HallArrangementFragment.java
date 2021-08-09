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

import com.systrack.admission.Activity.ExamTimetableAcademicYearActivity;
import com.systrack.admission.Activity.HallArrangementExamHallNoActivity;
import com.systrack.admission.Activity.HallArrangementExamNameActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.Hr.SearchManageEmpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HallArrangementFragment extends Fragment {


    View view;
LinearLayout search_hall;
EditText academic_year_edittext,exam_nm_edittext,hall_no_edittext;
    AppController appController;
    TextView error;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_hall_arrangement, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();
        appController.setHall_arrangement_examId(null);
        appController.setHall_arrangement_examName(null);
        appController.setHall_arrangement_HallName(null);
        appController.setHall_arrangement_hallNo(null);
        appController.setHall_arrangement_yearId(null);
        appController.setHall_arrangement_yearName(null);

        academic_year_edittext=view.findViewById(R.id.academic_year_edittext);
        academic_year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimetableYearFlag("HallArrangement");
                Intent i=new Intent(getActivity(), ExamTimetableAcademicYearActivity.class);
                startActivity(i);
            }
        });
        exam_nm_edittext=view.findViewById(R.id.exam_nm_edittext);
        exam_nm_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setHallArrangementExamNameFlag("HallArrangement");
                Intent i=new Intent(getActivity(), HallArrangementExamNameActivity.class);
                startActivity(i);
            }
        });


        hall_no_edittext=view.findViewById(R.id.hall_no_edittext);
        hall_no_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setHallArrangementExamNoFlag("HallArrangement");
                Intent i=new Intent(getActivity(), HallArrangementExamHallNoActivity.class);
                startActivity(i);
            }
        });

        search_hall=view.findViewById(R.id.search_timetable);
        search_hall.setOnClickListener(new View.OnClickListener() {
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

        if(appController.getHall_arrangement_yearName()!=null){
            academic_year_edittext.setText(appController.getHall_arrangement_yearName());
        }else{
            academic_year_edittext.setText("");
        }

        if(appController.getHall_arrangement_examName()!=null){
            exam_nm_edittext.setText(appController.getHall_arrangement_examName());
        }else{
            exam_nm_edittext.setText("");
        }

        if(appController.getHall_arrangement_HallName()!=null){
            hall_no_edittext.setText(appController.getHall_arrangement_HallName());
        }else{
            hall_no_edittext.setText("");
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
        }else {


            SearchHallArrangementFragement coursefragment = new SearchHallArrangementFragement();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,coursefragment);
            transaction.commit();

        }


    }

}

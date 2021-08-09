package com.systrack.admission.fragment.TimeTable;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassTimingFragment extends Fragment {


    View view;
LinearLayout search_class_timing;
EditText course_edittext,medium_edittext,batch_edittext,section_edittext,division_edittext;
    AppController appController;
    SharedPreferences sharedpreferences;
    Boolean ISALLOWDIVISION;
TextView error;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_class_timing, container, false);

        appController = (AppController) getActivity().getApplicationContext();
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);
        error=view.findViewById(R.id.error);

        appController.setClassTimingStreamId(null);
        appController.setClassTimingStreamName(null);

        appController.setClassTimingMedium(null);

        appController.setClassTimingBatchId(null);
        appController.setClassTimingBatchName(null);

        appController.setClassTimingSemName(null);

        appController.setClassTimingDivisionId(null);
        appController.setClassTimingDivisionName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpCourseFlag("ClassTiming");
                appController.setClassTimingMedium(null);

                appController.setClassTimingBatchId(null);
                appController.setClassTimingBatchName(null);

                appController.setClassTimingSemName(null);

                appController.setClassTimingDivisionId(null);
                appController.setClassTimingDivisionName(null);


                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("ClassTiming");
                appController.setClassTimingBatchId(null);
                appController.setClassTimingBatchName(null);

                appController.setClassTimingSemName(null);

                appController.setClassTimingDivisionId(null);
                appController.setClassTimingDivisionName(null);


                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("ClassTiming");

                appController.setClassTimingSemName(null);

                appController.setClassTimingDivisionId(null);
                appController.setClassTimingDivisionName(null);


                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });

        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("ClassTiming");

                appController.setClassTimingDivisionId(null);
                appController.setClassTimingDivisionName(null);

                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });
        division_edittext=view.findViewById(R.id.division_edittext);
        division_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setCourseMgtDivisionFlag("ClassTiming");
                Intent i=new Intent(getActivity(), CourseMgtDivisionActivity.class);
                startActivity(i);
            }
        });

        if(ISALLOWDIVISION){
            division_edittext.setVisibility(View.VISIBLE);
        }else{
            division_edittext.setVisibility(View.GONE);
        }

        search_class_timing=view.findViewById(R.id.search_class_timing);
        search_class_timing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(course_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Course data required" );
                }else if(batch_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Batch data required" );
                }else if(section_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setVisibility(View.VISIBLE);
                }else if(division_edittext.getVisibility() == View.VISIBLE && division_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Division data required" );
                }else{

                    SearchClassTimingListFragment coursefragment = new SearchClassTimingListFragment();
                    FragmentTransaction country = getFragmentManager().beginTransaction();
                    country.replace(R.id.frame, coursefragment);
                    country.commit();

                }
            }
        });
       ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimeTableMenuFragment coursefragment = new TimeTableMenuFragment();
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
        if(appController.getClassTimingStreamName()!=null){
            course_edittext.setText(appController.getClassTimingStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getClassTimingMedium()!=null){
            medium_edittext.setText(appController.getClassTimingMedium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getClassTimingBatchName()!=null){
            batch_edittext.setText(appController.getClassTimingBatchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getClassTimingSemName()!=null){
            section_edittext.setText(appController.getClassTimingSemName());
        }else{
            section_edittext.setText("");
        }

        if(appController.getClassTimingDivisionName()!=null){
            division_edittext.setText(appController.getClassTimingDivisionName());
        }else{
            division_edittext.setText("");
        }
    }
}

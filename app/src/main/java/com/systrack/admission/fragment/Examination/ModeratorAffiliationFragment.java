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
import android.widget.ShareActionProvider;
import android.widget.TextView;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class ModeratorAffiliationFragment extends Fragment {


    View view;
     LinearLayout search;
    AppController appController;
    EditText course_edittext,medium_edittext,year_edittext,batch_edittext,section_edittext,division_edittext;
    TextView error;
    SharedPreferences sharedPreferences;
    boolean  ISALLOWDIVISION;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_moderator_affiliation, container, false);

        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();
        sharedPreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        ISALLOWDIVISION = sharedPreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);

        appController.setModerator_affiliation_batchId(null);
        appController.setModerator_affiliation_batchName(null);
        appController.setModerator_affiliation_divisionId(null);
        appController.setModerator_affiliation_divisionName(null);
        appController.setModerator_affiliation_medium(null);
        appController.setModerator_affiliation_sectionName(null);
        appController.setModerator_affiliation_streamId(null);
        appController.setModerator_affiliation_streamName(null);
        appController.setModerator_affiliation_yearId(null);
        appController.setModerator_affiliation_yearName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setModerator_affiliation_medium(null);

                appController.setManageEmpCourseFlag("ModeratorAffiliation");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appController.setManageEmpMediumFlag("ModeratorAffiliation");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });
        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("ModeratorAffiliation");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });
        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("ModeratorAffiliation");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });

        year_edittext=view.findViewById(R.id.academic_year_edittext);
        year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setExamTimetableYearFlag("ModeratorAffiliation");
                Intent i=new Intent(getActivity(), ExamTimetableAcademicYearActivity.class);
                startActivity(i);
            }
        });
        division_edittext=view.findViewById(R.id.division_edittext);
        division_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setCourseMgtDivisionFlag("ModeratorAffiliation");
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
        if(appController.getModerator_affiliation_yearName()!=null){
            year_edittext.setText(appController.getModerator_affiliation_yearName());
        }else{
            year_edittext.setText("");
        }

        if(appController.getModerator_affiliation_streamName()!=null){
            course_edittext.setText(appController.getModerator_affiliation_streamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getModerator_affiliation_medium()!=null){
            medium_edittext.setText(appController.getModerator_affiliation_medium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getModerator_affiliation_batchName()!=null){
            batch_edittext.setText(appController.getModerator_affiliation_batchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getModerator_affiliation_sectionName()!=null){
            section_edittext.setText(appController.getModerator_affiliation_sectionName());
        }else{
            section_edittext.setText("");
        }

        if(appController.getModerator_affiliation_divisionName()!=null){
            division_edittext.setText(appController.getModerator_affiliation_divisionName());
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
        } else if (division_edittext.getText().toString().equals("") && ISALLOWDIVISION) {
            error.setVisibility(View.VISIBLE);
            error.setText("Division data required");
        } else {


            SearchModeratorAffiliationFragment coursefragment = new SearchModeratorAffiliationFragment();
            FragmentTransaction country = getFragmentManager().beginTransaction();
            country.replace(R.id.frame, coursefragment);
            country.commit();


        }
    }


}

package com.systrack.admission.fragment.TelephoneDiary;


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
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeDepartmentActivity;
import com.systrack.admission.Activity.ManageEmployeeDesignationActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentContactFragment extends Fragment {


    View view;
LinearLayout search_employee;
EditText course_edittext,medium_edittext,batch_edittext,section_editext;
    AppController appController;
    TextView error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_student_contact, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();

        appController.setStudent_contact_streamId(null);
        appController.setStudent_contact_streamName(null);
        appController.setStudent_contact_batchId(null);
        appController.setStudent_contact_batchName(null);
        appController.setStudent_contact_medium(null);
        appController.setStudent_contact_sectionId(null);
        appController.setStudent_contact_sectionName(null);


        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                appController.setManageEmpMediumName(null);

                appController.setManageEmpCourseFlag("StudentContact");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("StudentContact");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        batch_edittext=view.findViewById(R.id.batch_edittext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("StudentContact");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });

        section_editext=view.findViewById(R.id.section_editext);
        section_editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("StudentContact");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);

            }
        });




        search_employee=view.findViewById(R.id.search_employee);
        search_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchEmployeeHeadData();

            }
        });
       ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TelephoneDiaryMenuFragment coursefragment = new TelephoneDiaryMenuFragment();
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

        if(appController.getStudent_contact_streamName()!=null){
            course_edittext.setText(appController.getStudent_contact_streamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getStudent_contact_medium()!=null){
            medium_edittext.setText(appController.getStudent_contact_medium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getStudent_contact_batchName()!=null){
            batch_edittext.setText(appController.getStudent_contact_batchName());
        }else{
            batch_edittext.setText("");
        }
        if(appController.getStudent_contact_sectionName()!=null){
            section_editext.setText(appController.getStudent_contact_sectionName());
        }else{
            section_editext.setText("");
        }

    }
    private void SearchEmployeeHeadData() {

        if(course_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Course data required" );
        } else if(medium_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Medium data required" );
        } else if(section_editext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Semster data required" );
        } else if(batch_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Batch data required" );

        }else {


//            SearchEmpContactFragment searchManageEmpFragment = new SearchEmpContactFragment();
//            FragmentTransaction transaction = getFragmentManager().beginTransaction();
//            transaction.replace(R.id.frame,searchManageEmpFragment);
//            transaction.commit();

        }


    }

}

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

import com.systrack.admission.Activity.ManageEmployeeCategoryActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeDepartmentActivity;
import com.systrack.admission.Activity.ManageEmployeeDesignationActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.Hr.HrMenuFragment;
import com.systrack.admission.fragment.Hr.SearchManageEmpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeeContactFragment extends Fragment {


    View view;
LinearLayout search_employee;
EditText course_edittext,medium_edittext,department_edittext,designation_editext;
    AppController appController;
    TextView error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_employee_contact, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();

        appController.setEmployeeContactStreamId(null);
        appController.setEmployeeContactStreamName(null);
        appController.setEmployeeContactDepartmentId(null);
        appController.setEmployeeContactDepartmentName(null);
        appController.setEmployeeContactDesignationName(null);
        appController.setEmployeeContactDesignationId(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                appController.setManageEmpMediumName(null);

                appController.setManageEmpCourseFlag("EmployeeContact");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

//        medium_edittext=view.findViewById(R.id.medium_edittext);
//        medium_edittext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                appController.setManageEmpMediumFlag("ManageEmployee");
//                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
//                startActivity(i);
//            }
//        });

        department_edittext=view.findViewById(R.id.department_edittext);
        department_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpDepartmentFlag("EmployeeContact");

                Intent i=new Intent(getActivity(), ManageEmployeeDepartmentActivity.class);
                startActivity(i);
            }
        });

        designation_editext=view.findViewById(R.id.designation_editext);
        designation_editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpDeSignationFlag("EmployeeContact");

                Intent i=new Intent(getActivity(), ManageEmployeeDesignationActivity.class);
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

        if(appController.getEmployeeContactStreamName()!=null){
            course_edittext.setText(appController.getEmployeeContactStreamName());
        }else{
            course_edittext.setText("");
        }

//        if(appController.getEmployeeContactDepartmentName()!=null){
//            medium_edittext.setText(appController.getManageEmpMediumName());
//        }else{
//            medium_edittext.setText("");
//        }

        if(appController.getEmployeeContactDepartmentName()!=null){
            department_edittext.setText(appController.getEmployeeContactDepartmentName());
        }else{
            department_edittext.setText("");
        }
        if(appController.getEmployeeContactDesignationName()!=null){
            designation_editext.setText(appController.getEmployeeContactDesignationName());
        }else{
            designation_editext.setText("");
        }

    }
    private void SearchEmployeeHeadData() {

        if(course_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Course data required" );
//        } else if(medium_edittext.getText().toString().equals("")){
//            error.setVisibility(View.VISIBLE);
//            error.setText("Medium data required" );
        } else if(department_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Department data required" );
        } else if(designation_editext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Designation data required" );

        }else {


            SearchEmpContactFragment searchManageEmpFragment = new SearchEmpContactFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,searchManageEmpFragment);
            transaction.commit();

        }


    }

}

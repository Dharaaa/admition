package com.systrack.admission.fragment.Hr;


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
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.Activity.ManageEmployeeCategoryActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeDepartmentActivity;
import com.systrack.admission.Activity.ManageEmployeeDesignationActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManageEmpFragment extends Fragment {


    View view;
LinearLayout search_employee;
EditText course_edittext,medium_edittext,department_edittext,designation_editext,category_edittext;
    AppController appController;
    TextView error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_manage_employee, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();

        appController.setManageEmpStreamId(null);
        appController.setManageEmpStreamName(null);
        appController.setManageEmpMediumName(null);
        appController.setManageEmpDepartmentId(null);
        appController.setManageEmpDepartmentName(null);
        appController.setManageEmpDesignationId(null);
        appController.setManageEmpDesignationName(null);
        appController.setManageEmpCategoryName(null);
        appController.setManageEmpCategoryId(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumName(null);

                appController.setManageEmpCourseFlag("ManageEmployee");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("ManageEmployee");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        department_edittext=view.findViewById(R.id.department_edittext);
        department_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpDepartmentFlag("ManageEmployee");

                Intent i=new Intent(getActivity(), ManageEmployeeDepartmentActivity.class);
                startActivity(i);
            }
        });

        designation_editext=view.findViewById(R.id.designation_editext);
        designation_editext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpDeSignationFlag("ManageEmployee");

                Intent i=new Intent(getActivity(), ManageEmployeeDesignationActivity.class);
                startActivity(i);
            }
        });

        category_edittext=view.findViewById(R.id.category_edittext);
        category_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(), ManageEmployeeCategoryActivity.class);
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


                HrMenuFragment coursefragment = new HrMenuFragment();
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

        if(appController.getManageEmpStreamName()!=null){
            course_edittext.setText(appController.getManageEmpStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getManageEmpMediumName()!=null){
            medium_edittext.setText(appController.getManageEmpMediumName());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getManageEmpDepartmentName()!=null){
            department_edittext.setText(appController.getManageEmpDepartmentName());
        }else{
            department_edittext.setText("");
        }
        if(appController.getManageEmpDesignationName()!=null){
            designation_editext.setText(appController.getManageEmpDesignationName());
        }else{
            designation_editext.setText("");
        }
        if(appController.getManageEmpCategoryName()!=null){
            category_edittext.setText(appController.getManageEmpCategoryName());
        }else{
            category_edittext.setText("");
        }
    }
    private void SearchEmployeeHeadData() {

        if(course_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Course data required" );
        } else if(medium_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Medium data required" );
        } else if(department_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Department data required" );
        } else if(designation_editext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Designation data required" );
        }else if(category_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Category data required" );
        }else {


            SearchManageEmpFragment searchManageEmpFragment = new SearchManageEmpFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame,searchManageEmpFragment);
            transaction.commit();

        }


    }

}

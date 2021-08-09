package com.systrack.admission.fragment.LeaveManagement;


import android.content.Intent;
import android.media.Image;
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

import com.systrack.admission.Activity.LeaveAssignLeaveYearActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeDepartmentActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaveAssignFragment extends Fragment {


    View view;
LinearLayout search_employee;
    EditText course_edittext,medium_edittext,department_edittext,leave_year_edittext;
    AppController appController;
    TextView error;
    ImageView back_arrow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_leave_assign, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        error=view.findViewById(R.id.error);
        appController.setLeaveAssignStreamId(null);
        appController.setLeaveAssignStreamName(null);
        appController.setLeaveAssignMedium(null);
        appController.setLeaveAssignDepartmentId(null);
        appController.setLeaveAssignDepartmentName(null);
        appController.setLeaveAssignLeaveYearID(null);
        appController.setLeaveAssignLeaveYearName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setLeaveAssignMedium(null);

                appController.setManageEmpCourseFlag("LeaveAssign");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("LeaveAssign");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        department_edittext=view.findViewById(R.id.department_edittext);
        department_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpDepartmentFlag("LeaveAssign");
                Intent i=new Intent(getActivity(), ManageEmployeeDepartmentActivity.class);
                startActivity(i);
            }
        });

        leave_year_edittext=view.findViewById(R.id.leave_year_edittext);
        leave_year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setLeaveAssignLeaveYearFlag("LeaveAssign");
                Intent i=new Intent(getActivity(), LeaveAssignLeaveYearActivity.class);
                startActivity(i);
            }
        });

        search_employee=view.findViewById(R.id.search_employee);
        search_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(course_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Course data required" );
                }else if(medium_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Medium data required" );
                }else if(department_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Department data required" );
                }else if(leave_year_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Leave Year data required" );
                }else{

                    SearchLeaveAssignFragment coursefragment = new SearchLeaveAssignFragment();
                    FragmentTransaction country = getFragmentManager().beginTransaction();
                    country.replace(R.id.frame, coursefragment);
                    country.commit();

                }

            }
        });


       back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LeaveMgtMenuFragment coursefragment = new LeaveMgtMenuFragment();
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
        if(appController.getLeaveAssignStreamName()!=null){
            course_edittext.setText(appController.getLeaveAssignStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getLeaveAssignMedium()!=null){
            medium_edittext.setText(appController.getLeaveAssignMedium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getLeaveAssignDepartmentName()!=null){
            department_edittext.setText(appController.getLeaveAssignDepartmentName());
        }else{
            department_edittext.setText("");
        }
        if(appController.getLeaveAssignLeaveYearName()!=null){
            leave_year_edittext.setText(appController.getLeaveAssignLeaveYearName());
        }else{
            leave_year_edittext.setText("");
        }

    }

}

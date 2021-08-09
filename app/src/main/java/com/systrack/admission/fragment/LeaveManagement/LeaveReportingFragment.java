package com.systrack.admission.fragment.LeaveManagement;


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

import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeDepartmentActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.Hr.HrMenuFragment;
import com.systrack.admission.fragment.Hr.SearchManageEmpFragment;
import com.systrack.admission.fragment.TimeTable.SearchClassTimingListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaveReportingFragment extends Fragment {


    View view;
    LinearLayout search_employee;
    EditText course_edittext,medium_edittext,department_edittext;
    AppController appController;
    TextView error;
    ImageView back_arrow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_leave_reporting, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        error=view.findViewById(R.id.error);
        appController.setLeaveReportingStreamId(null);
        appController.setLeaveReportingStreamName(null);
        appController.setLeaveReportingMedium(null);
        appController.setLeaveReportingDepartmentId(null);
        appController.setLeaveReportingDepartmentName(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setLeaveReportingMedium(null);

                appController.setManageEmpCourseFlag("LeaveReporting");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("LeaveReporting");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        department_edittext=view.findViewById(R.id.department_edittext);
        department_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpDepartmentFlag("LeaveReporting");
                Intent i=new Intent(getActivity(), ManageEmployeeDepartmentActivity.class);
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
                }else{

                    SearchLeaveReportingFragment coursefragment = new SearchLeaveReportingFragment();
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
        if(appController.getLeaveReportingStreamName()!=null){
            course_edittext.setText(appController.getLeaveReportingStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getLeaveReportingMedium()!=null){
            medium_edittext.setText(appController.getLeaveReportingMedium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getLeaveReportingDepartmentName()!=null){
            department_edittext.setText(appController.getLeaveReportingDepartmentName());
        }else{
            department_edittext.setText("");
        }

    }

}

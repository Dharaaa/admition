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

import com.systrack.admission.Activity.LeaveAssignLeaveYearActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.Hr.SearchManageEmpFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmpLeaveReportingFragment extends Fragment {


    View view;
LinearLayout search_employee;
EditText leave_year_edittext,employee_edittext;
TextView error;
    AppController appController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_emp_leave_reporting, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        error=view.findViewById(R.id.error);

        employee_edittext=view.findViewById(R.id.employee_edittext);

        leave_year_edittext=view.findViewById(R.id.leave_year_editext);
        leave_year_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setLeaveAssignLeaveYearFlag("EmpLeaveReporting");
                Intent i=new Intent(getActivity(), LeaveAssignLeaveYearActivity.class);
                startActivity(i);
            }
        });


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


                LeaveMgtMenuFragment coursefragment = new LeaveMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        return view;
    }

    private void SearchData() {

        if(leave_year_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Leave Year required" );
        } else if(employee_edittext.getText().toString().equals("")){
            error.setVisibility(View.VISIBLE);
            error.setText("Employee data required" );
        } else {


            SearchLeaveReportingFragment coursefragment = new SearchLeaveReportingFragment();
            FragmentTransaction country = getFragmentManager().beginTransaction();
            country.replace(R.id.frame, coursefragment);
            country.commit();

        }


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");

        if(appController.getManageEmpStreamName()!=null){
            employee_edittext.setText(appController.getManageEmpStreamName());
        }else{
            employee_edittext.setText("");
        }

        if(appController.getEmpLeaveReportingLeaveYearName()!=null){
            leave_year_edittext.setText(appController.getEmpLeaveReportingLeaveYearName());
        }else{
            leave_year_edittext.setText("");
        }


    }

}

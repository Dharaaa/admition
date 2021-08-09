package com.systrack.admission.fragment.AttendanceManagement;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
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

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManageAttendanceFragment extends Fragment {


    View view;
LinearLayout search_employee;
    EditText course_edittext,medium_edittext,department_edittext,date_edittext;
    AppController appController;
    TextView error;
    ImageView back_arrow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_manage_attendance, container, false);
        appController = (AppController) getActivity().getApplicationContext();
appController.setManageAttendanceSteamId(null);
appController.setManageAttendanceStreamName(null);
appController.setManageAttendanceMedium(null);
appController.setManageAttendanceDepartmetId(null);
appController.setManageAttendanceDepartmentName(null);

        date_edittext=view.findViewById(R.id.date_edittext);
        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageAttendanceMedium(null);

                appController.setManageEmpCourseFlag("ManageAttendance");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("ManageAttendance");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        department_edittext=view.findViewById(R.id.department_edittext);
        department_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpDepartmentFlag("ManageAttendance");
                Intent i=new Intent(getActivity(), ManageEmployeeDepartmentActivity.class);
                startActivity(i);
            }
        });
        date_edittext=view.findViewById(R.id.date_edittext);
        date_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                        int myYear = year;
                        int myday = dayOfMonth;
                        int myMonth = monthOfYear+1;
                        Calendar c = Calendar.getInstance();
                        appController.setManageAttendanceDate(myMonth+"/"+myday+"/"+myYear);
                        date_edittext.setText(myday+"/"+myMonth+"/"+myYear);
                    }
                },year, month,day);
                datePickerDialog.show();
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
                }else if(date_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Date required" );
                }else{

                    SearchManageAttendanceFragment coursefragment = new SearchManageAttendanceFragment();
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


                AttendanceMgtMenuFragment coursefragment = new AttendanceMgtMenuFragment();
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
        if(appController.getManageAttendanceStreamName()!=null){
            course_edittext.setText(appController.getManageAttendanceStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getManageAttendanceMedium()!=null){
            medium_edittext.setText(appController.getManageAttendanceMedium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getManageAttendanceDepartmentName()!=null){
            department_edittext.setText(appController.getManageAttendanceDepartmentName());
        }else{
            department_edittext.setText("");
        }

    }


}

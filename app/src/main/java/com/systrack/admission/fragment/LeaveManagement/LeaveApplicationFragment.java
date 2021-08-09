package com.systrack.admission.fragment.LeaveManagement;


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
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaveApplicationFragment extends Fragment {


    View view;
LinearLayout search_employee;
    EditText course_edittext,medium_edittext,date_range;
    AppController appController;
    TextView error;
    ImageView back_arrow;
    DatePickerDialog picker;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_leave_application, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        error=view.findViewById(R.id.error);
        appController.setLeaveApplicantStreamId(null);
        appController.setLeaveApplicantStreamName(null);
        appController.setLeaveApplicantMedium(null);

        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setLeaveApplicantMedium(null);

                appController.setManageEmpCourseFlag("LeaveApplicant");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("LeaveApplicant");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });


        search_employee=view.findViewById(R.id.search_employee);
        search_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (course_edittext.getText().toString().equals("")) {
                    error.setVisibility(View.VISIBLE);
                    error.setText("Course data required");
                } else if (medium_edittext.getText().toString().equals("")) {
                    error.setVisibility(View.VISIBLE);
                    error.setText("Medium data required");
                } else if (date_range.getText().toString().equals("")) {
                    error.setVisibility(View.VISIBLE);
                    error.setText("Date Range required");
                } else{

                    SearchLeaveApplicationFragment coursefragment = new SearchLeaveApplicationFragment();
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


                LeaveMgtMenuFragment coursefragment = new LeaveMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });
        appController.setCustomMonthText("null");
        appController.setDayofMonthCustom("null");

        date_range=view.findViewById(R.id.date_range);
        date_range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);


                // date picker dialog
                picker = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, final int year, int monthOfYear, int dayOfMonth) {

                                int month = monthOfYear + 1;
                                String formattedMonth = "" + month;
                                String formattedDayOfMonth = "" + dayOfMonth;
                                if(month < 10){

                                    formattedMonth = "0" + month;
                                }
                                if(dayOfMonth < 10){

                                    formattedDayOfMonth = "0" + dayOfMonth;
                                }

                                final String finalFormattedMonth = formattedMonth;
                                final String finalFormattedDayOfMonth = formattedDayOfMonth;

                                if(finalFormattedMonth.equals("01")){
                                    appController.setCustomMonthText("January");
                                    appController.setDayofMonthCustom("31");
                                }else if(finalFormattedMonth.equals("02")){
                                    appController.setCustomMonthText("February");
                                    if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
                                        appController.setDayofMonthCustom("29");
                                    }else{
                                        appController.setDayofMonthCustom("28");
                                        appController.setDayofMonthCustom("28");

                                    }
                                }
                                else if(finalFormattedMonth.equals("03")){
                                    appController.setCustomMonthText("March");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("04")){
                                    appController.setCustomMonthText("April");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("05")){
                                    appController.setCustomMonthText("May");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("06")){
                                    appController.setCustomMonthText("June");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("07")){
                                    appController.setCustomMonthText("July");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("08")){
                                    appController.setCustomMonthText("August");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("09")){
                                    appController.setCustomMonthText("September");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("10")){
                                    appController.setCustomMonthText("October");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("11")){
                                    appController.setCustomMonthText("November");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("12")){
                                    appController.setCustomMonthText("December");
                                    appController.setDayofMonthCustom("31");

                                }

                                date_range.setText(appController.getCustomMonthText() + " " + "01," + year + " - " +appController.getCustomMonthText()+  " " +appController.getDayofMonthCustom() + "," + year);


                                Log.e("month",finalFormattedMonth);
                                Log.e("EndDay",appController.getDayofMonthCustom());
                                Log.e("year", String.valueOf(year));


                                appController.setLeaveApplicationFromDate(finalFormattedMonth + "/" + "01" + "/" + year);
                                appController.setLeaveApplicationTodate(finalFormattedMonth + "/" + appController.getDayofMonthCustom() + "/" + year);

                                appController.setLeaveApplicationDateRange(String.valueOf(date_range.getText()));

                            }
                        }, year, month, day);
                picker.show();


            }
        });

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");
        if(appController.getLeaveApplicantStreamId()!=null){
            course_edittext.setText(appController.getLeaveApplicantStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getLeaveApplicantMedium()!=null){
            medium_edittext.setText(appController.getLeaveApplicantMedium());
        }else{
            medium_edittext.setText("");
        }


    }

}

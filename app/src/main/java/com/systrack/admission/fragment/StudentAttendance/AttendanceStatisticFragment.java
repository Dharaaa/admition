package com.systrack.admission.fragment.StudentAttendance;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.Activity.AttendanceStatisticSubjectActivity;
import com.systrack.admission.Activity.ClassTimingBatchActivity;
import com.systrack.admission.Activity.ClassTimingSectionActivity;
import com.systrack.admission.Activity.CourseMgtDivisionActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.Activity.StudentAttendanceSubjectActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttendanceStatisticFragment extends Fragment {


    View view;
LinearLayout search_employee,linear_switch;
TextView error;
    EditText course_edittext,medium_edittext,batch_edittext,date_range,subject_edittext,section_edittext,division_edittext;
    AppController appController;
    DatePickerDialog picker;
    SharedPreferences sharedpreferences;
boolean ISALLOWDIVISION,ENABLEPRACTICAL;
String ROLEID;
Switch Switch_lecture_type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_attendance_statistic, container, false);
        error=view.findViewById(R.id.error);
        appController = (AppController) getActivity().getApplicationContext();
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);
        ENABLEPRACTICAL = sharedpreferences.getBoolean(getString(R.string.ENABLEPRACTICAL), false);
        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");

        appController.setAttendanceStstisticDivName(null);
        appController.setAttendanceStstisticDivId(null);
        appController.setAttendanceStstisticStreamName(null);
        appController.setAttendanceStstisticSubName(null);
        appController.setAttendanceStstisticSubId(null);
        appController.setAttendanceStstisticSectionName(null);
        appController.setAttendanceStstisticBatchName(null);
        appController.setAttendanceStstisticBatchId(null);
        appController.setAttendanceStstisticMedium(null);
        appController.setAttendanceStstisticStreamId(null);
        appController.setAttendanceStatisticsRange(null);
        appController.setAttendanceStatsticsFromDate(null);
        appController.setAttendanceStatsticsToDate(null);


        linear_switch=view.findViewById(R.id.linear_switch);
        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpCourseFlag("AttendanceStatistic");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("AttendanceStatistic");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });
        batch_edittext=view.findViewById(R.id.batch_editext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("AttendanceStatistic");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });
        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("AttendanceStatistic");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });
        subject_edittext=view.findViewById(R.id.subject_edittext);
        subject_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ROLEID.equals("2")){
                appController.setStuAttendanceSubFlag("AttendanceStatistic");
                Intent i=new Intent(getActivity(), StudentAttendanceSubjectActivity.class);
                startActivity(i);
                }else{

                        Intent i=new Intent(getActivity(), AttendanceStatisticSubjectActivity.class);
                        startActivity(i);
                }
            }
        });

        division_edittext=view.findViewById(R.id.division_edittext);
        division_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appController.setCourseMgtDivisionFlag("AttendanceStatistic");
                Intent i=new Intent(getActivity(), CourseMgtDivisionActivity.class);
                startActivity(i);
            }
        });


        appController.setSwitchLectureTypeStatistics("T");
        Switch_lecture_type=view.findViewById(R.id.Switch_lecture_type);
        Switch_lecture_type.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    appController.setSwitchLectureTypeStatistics("T");
                }else{
                    appController.setSwitchLectureTypeStatistics("P");

                }
            }
        });

        if(ISALLOWDIVISION){
            division_edittext.setVisibility(View.VISIBLE);
        }else{
            division_edittext.setVisibility(View.GONE);
        }
        if(ENABLEPRACTICAL){
            linear_switch.setVisibility(View.VISIBLE);
        }else {
            linear_switch.setVisibility(View.GONE);
        }

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


                                appController.setAttendanceStatsticsFromDate(finalFormattedMonth + "/" + "01" + "/" + year);
                                appController.setAttendanceStatsticsToDate(finalFormattedMonth + "/" + appController.getDayofMonthCustom() + "/" + year);

                                appController.setAttendanceStatisticsRange(String.valueOf(date_range.getText()));

                            }
                        }, year, month, day);
                picker.show();


            }
        });



        search_employee=view.findViewById(R.id.search_employee);
        search_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(course_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Course data required" );
                } else if(medium_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Medium data required" );
                } else if(batch_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Batch data required" );
                } else if(section_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Section data required" );
                }else if(subject_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Subject data required" );
                }else if(date_range.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Date Range required" );
                }else {

                    error.setVisibility(View.GONE);
                    SearchAttendanceStatisticsFragement fragment = new SearchAttendanceStatisticsFragement();
                    FragmentTransaction country = getFragmentManager().beginTransaction();
                    country.replace(R.id.frame, fragment);
                    country.commit();
                }

            }
        });



        ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                StuAttendanceMenuFragment coursefragment = new StuAttendanceMenuFragment();
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
        if(appController.getAttendanceStstisticStreamName()!=null){
            course_edittext.setText(appController.getAttendanceStstisticStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getAttendanceStstisticMedium()!=null){
            medium_edittext.setText(appController.getAttendanceStstisticMedium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getAttendanceStstisticBatchName()!=null){
            batch_edittext.setText(appController.getAttendanceStstisticBatchName());
        }else{
            batch_edittext.setText("");
        }

        if(appController.getAttendanceStstisticSubName()!=null){
            subject_edittext.setText(appController.getAttendanceStstisticSubName());
        }else{
            subject_edittext.setText("");
        }
        if(appController.getAttendanceStstisticSectionName()!=null){
            section_edittext.setText(appController.getAttendanceStstisticSectionName());
        }else{
            section_edittext.setText("");
        }

        if(appController.getAttendanceStstisticDivName()!=null){
            division_edittext.setText(appController.getAttendanceStstisticDivName());
        }else{
            division_edittext.setText("");
        }
    }


}

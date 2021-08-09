package com.systrack.admission.fragment.StudentAttendance;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
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

import com.systrack.admission.Activity.ClassTimingBatchActivity;
import com.systrack.admission.Activity.ClassTimingSectionActivity;
import com.systrack.admission.Activity.CourseMgtDivisionActivity;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.Activity.StudentAttendanceClassTimingActivity;
import com.systrack.admission.Activity.StudentAttendanceSubjectActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.Hr.HrMenuFragment;
import com.systrack.admission.fragment.Hr.SearchManageEmpFragment;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class StudentAttendanceFragment extends Fragment {


    View view;
LinearLayout search_employee;
EditText course_edittext,medium_edittext,batch_edittext,division_edittext,et_lecture_date,subject_edittext,class_timing_edittext,section_edittext,class_batch_edittext;
    AppController appController;
SharedPreferences sharedpreferences;
boolean ISALLOWDIVISION;
LinearLayout linear_switch;
    Switch Switch_lecture_type;
    TextView error;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_student_attendance, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        sharedpreferences =getActivity().getApplicationContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        linear_switch=view.findViewById(R.id.linear_switch);
        class_batch_edittext=view.findViewById(R.id.class_batch_edittext);
        ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);

        appController.setStuAttendanceStreamName(null);
        appController.setStuAttendanceStreamId(null);
        appController.setStuAttendanceMedium(null);
        appController.setStuAttendanceBatchId(null);
        appController.setStuAttendanceBatchName(null);
        appController.setStuAttendanceSectionName(null);
        appController.setStuAttendanceDivId(null);
        appController.setStuAttendanceDivName(null);
        appController.setStuAttendanceLectureDate(null);
        appController.setStuAttendanceClassTimingId(null);
        appController.setStuAttendanceClassTimingName(null);
        appController.setStuAttendanceSubName(null);
        appController.setStuAttendanceSubId(null);
        error=view.findViewById(R.id.error);

// t==1  p==0
        course_edittext=view.findViewById(R.id.course_edittext);
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpCourseFlag("StudentAttendance");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);
            }
        });

        medium_edittext=view.findViewById(R.id.medium_edittext);
        medium_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setManageEmpMediumFlag("StudentAttendance");
                Intent i=new Intent(getActivity(), ManageEmployeeMediumByCourseActivity.class);
                startActivity(i);
            }
        });

        batch_edittext=view.findViewById(R.id.batch_editext);
        batch_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingBatchFlag("StudentAttendance");

                Intent i=new Intent(getActivity(), ClassTimingBatchActivity.class);
                startActivity(i);
            }
        });

        section_edittext=view.findViewById(R.id.section_edittext);
        section_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setClassTimingSectionFlag("StudentAttendance");
                Intent i=new Intent(getActivity(), ClassTimingSectionActivity.class);
                startActivity(i);
            }
        });

        division_edittext=view.findViewById(R.id.division_edittext);
        division_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appController.setCourseMgtDivisionFlag("StudentAttendance");
                Intent i=new Intent(getActivity(), CourseMgtDivisionActivity.class);
                startActivity(i);
            }
        });
        if(ISALLOWDIVISION){

            division_edittext.setVisibility(View.VISIBLE);
            linear_switch.setVisibility(View.VISIBLE);
        }else{
            division_edittext.setVisibility(View.GONE);
            linear_switch.setVisibility(View.GONE);
        }

        //T==1 , p ==0
        class_batch_edittext.setVisibility(View.GONE);
        appController.setSwitchLectureTypeStuAttendance("1");
        Switch_lecture_type=view.findViewById(R.id.Switch_lecture_type);
        Switch_lecture_type.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    appController.setSwitchLectureTypeStatistics("1");
                    class_batch_edittext.setVisibility(View.GONE);
                }else{
                    appController.setSwitchLectureTypeStatistics("0");
                    class_batch_edittext.setVisibility(View.VISIBLE);

                }
            }
        });

        et_lecture_date=view.findViewById(R.id.et_lecture_date);
        et_lecture_date.setOnClickListener(new View.OnClickListener() {
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
                       et_lecture_date.setText(myday+"/"+myMonth+"/"+myYear);
                    }
                },year, month,day);
                datePickerDialog.show();
            }
        });

        subject_edittext=view.findViewById(R.id.subject_edittext);
        subject_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setStuAttendanceSubFlag("StudentAttendance");
                 Intent i=new Intent(getActivity(), StudentAttendanceSubjectActivity.class);
                 startActivity(i);
            }
        });

        class_timing_edittext=view.findViewById(R.id.class_timing_edittext);
        class_timing_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setStuAttendanceLectureDate(et_lecture_date.getText().toString());
                appController.setStuAttendanceClassTimeFlag("StudentAttendance");
                Intent i=new Intent(getActivity(), StudentAttendanceClassTimingActivity.class);
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
                }else if(et_lecture_date.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Lecture Date required" );
                }else if(class_timing_edittext.getText().toString().equals("")){
                    error.setVisibility(View.VISIBLE);
                    error.setText("Class Timing required" );
                }else {

                    error.setVisibility(View.GONE);


                    SearchStudentAttendanceFragment coursefragment = new SearchStudentAttendanceFragment();
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

        if(appController.getStuAttendanceStreamName()!=null){
            course_edittext.setText(appController.getStuAttendanceStreamName());
        }else{
            course_edittext.setText("");
        }

        if(appController.getStuAttendanceMedium()!=null){
            medium_edittext.setText(appController.getStuAttendanceMedium());
        }else{
            medium_edittext.setText("");
        }

        if(appController.getStuAttendanceBatchName()!=null){
            batch_edittext.setText(appController.getStuAttendanceBatchName());
        }else{
            batch_edittext.setText("");
        }
        if(appController.getStuAttendanceDivName()!=null){
            division_edittext.setText(appController.getStuAttendanceDivName());
        }else{
            division_edittext.setText("");
        }
        if(appController.getStuAttendanceSubName()!=null){
            subject_edittext.setText(appController.getStuAttendanceSubName());
        }else{
            subject_edittext.setText("");
        }
        if(appController.getStuAttendanceClassTimingName()!=null){
            class_timing_edittext.setText(appController.getStuAttendanceClassTimingName());
        }else{
            class_timing_edittext.setText("");
        }

        if(appController.getStuAttendanceSectionName()!=null){
            section_edittext.setText(appController.getStuAttendanceSectionName());
        }else{
            section_edittext.setText("");
        }
    }


}

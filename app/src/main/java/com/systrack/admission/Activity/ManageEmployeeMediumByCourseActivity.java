package com.systrack.admission.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.hrAdapter.ManageEmployeeMediumAdapter;
import com.systrack.admission.pojo.ManageEmployeeCourseInformation;
import com.systrack.admission.pojo.ManageEmployeeCoursePojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ManageEmployeeMediumByCourseActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    String current_academicID,current_academicName;
    ArrayList<ManageEmployeeCourseInformation> arrayList;
    AppController appController;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;
    String courseId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_employee_course);

        final Typeface typeface_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-Regular.ttf");



        sharedpreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        Typeface font_icon = Typeface.createFromAsset(this.getAssets(), "fonts/fontawesome-webfont.ttf");
        linear_Search = (LinearLayout)findViewById(R.id.linear_Search);

        appController = (AppController)getApplicationContext();

        edt_search = (EditText)findViewById(R.id.edt_search_by_name);

        no_data = (TextView)findViewById(R.id.no_data);
        listView = (ListView)findViewById(R.id.listView_course_list);

        edt_search.setTypeface(typeface_semibold);
        no_data.setTypeface(typeface_semibold);


        if(appController.getManageEmpMediumFlag().equals("ManageEmployee")){
            if(appController.getManageEmpStreamName()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                courseId=appController.getManageEmpStreamId();
                getMediumList();
            }
        }else if(appController.getManageEmpMediumFlag().equals("ClassTiming")){
            if(appController.getClassTimingStreamName()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getClassTimingStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("TimeTable")){
            if(appController.getTimeTableStreamName()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getTimeTableStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("StudentAttendance")){
            if(appController.getStuAttendanceStreamName()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getStuAttendanceStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("AttendanceStatistic")){
            if(appController.getAttendanceStstisticStreamName()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getAttendanceStstisticStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("LectureAttendance")){
            if(appController.getLectureAttendanceStreamName()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getLectureAttendanceStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("LeaveReporting")){
            if(appController.getLeaveReportingStreamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getLeaveReportingStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("LeaveAssign")){
            if(appController.getLeaveAssignStreamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getLeaveAssignStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("LeaveApplicant")){
            if(appController.getLeaveApplicantStreamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getLeaveApplicantStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("ManageAttendance")){
            if(appController.getManageAttendanceSteamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getManageAttendanceSteamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("ExamTimeTable")){
            if(appController.getExamTimetableStreamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getExamTimetableStreamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("ModeratorAffiliation")){
            if(appController.getModerator_affiliation_streamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getModerator_affiliation_streamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("GenerateMarkSheet")){
            if(appController.getGenerate_marksheet_streamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getGenerate_marksheet_streamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("BroadSheet")){
            if(appController.getBroadSheet_streamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getBroadSheet_streamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("TeacherAllocation")){
            if(appController.getTeacher_allocation_streamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getTeacher_allocation_streamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("SubjectAllocation")){
            if(appController.getSubject_allocation_streamID()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getSubject_allocation_streamID();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("ManageStudent")){
            if(appController.getManage_student_streamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getManage_student_streamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("Assignment")){
            if(appController.getAssignment_streamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getAssignment_streamId();
                getMediumList();

            }
        }else if(appController.getManageEmpMediumFlag().equals("StudentContact")){
            if(appController.getStudent_contact_streamId()==null){
                Toast.makeText(ManageEmployeeMediumByCourseActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();

            }else{
                courseId=appController.getStudent_contact_streamId();
                getMediumList();

            }
        }








        ImageView back_arrow=findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");


                Call<ManageEmployeeCoursePojo> call = apiInterface.FillMediumList(entity_id,courseId,edt_search.getText().toString());
                call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
                    @Override
                    public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                        Log.e("Response  ", new Gson().toJson(response.body()));


                        ManageEmployeeCoursePojo pojoitem = response.body();

                        String StatusCode = pojoitem.getEmployeeInformation().get(0).getStatusCode();



                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getEmployeeInformation().size();

                            arrayList = new ArrayList<ManageEmployeeCourseInformation>();

                            for (int i = 1; i < Size; i++) {
                                ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                                pojo.setMEDIUM(pojoitem.getEmployeeInformation().get(i).getMEDIUM());


                                arrayList.add(pojo);

                            }
                            ManageEmployeeMediumAdapter  adapter = new ManageEmployeeMediumAdapter(ManageEmployeeMediumByCourseActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);
                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(ManageEmployeeMediumByCourseActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {

                        Log.e("Failure ", t.getMessage());
                    }
                });
            }


        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
if(appController.getManageEmpMediumFlag().equals("ClassTiming")){
    appController.setClassTimingMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("ManageEmployee")){
    appController.setManageEmpMediumName(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("TimeTable")){
    appController.setTimeTableMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("StudentAttendance")){
    appController.setStuAttendanceMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("AttendanceStatistic")){
    appController.setAttendanceStstisticMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("LectureAttendance")){
    appController.setLectureAttendanceMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("LeaveReporting")){
    appController.setLeaveReportingMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("LeaveAssign")){
    appController.setLeaveAssignMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("LeaveApplicant")){
    appController.setLeaveApplicantMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("ManageAttendance")){
    appController.setManageAttendanceMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("ExamTimeTable")){
    appController.setExamTimeTableMedium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("ModeratorAffiliation")){
    appController.setModerator_affiliation_medium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("GenerateMarkSheet")){
    appController.setGenerate_marksheet_medium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("BroadSheet")){
    appController.setBroadSheet_Medium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("TeacherAllocation")){
    appController.setTeacher_allocation_medium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("SubjectAllocation")){
    appController.setSubject_allocation_medium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("ManageStudent")){
    appController.setManage_student_medium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("Assignment")){
    appController.setAssignment_medium(arrayList.get(position).getMEDIUM());
    finish();
}else if(appController.getManageEmpMediumFlag().equals("StudentContact")){
    appController.setStudent_contact_medium(arrayList.get(position).getMEDIUM());
    finish();
}



            }
        });


    }




    private void getMediumList() {



            if (mProgressDialog == null)
                mProgressDialog = new TransparentProgressDialog(ManageEmployeeMediumByCourseActivity.this);
            if (mProgressDialog.isShowing())
                mProgressDialog.dismiss();
            //mProgressDialog = new TransparentProgressDialog(getActivity());
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
            String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");


            Call<ManageEmployeeCoursePojo> call = apiInterface.FillMediumList(entity_id,courseId,"");
            call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
                @Override
                public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                    Log.e("Response  ", new Gson().toJson(response.body()));


                    ManageEmployeeCoursePojo pojoitem = response.body();

                    String StatusCode = pojoitem.getEmployeeInformation().get(0).getStatusCode();

                    mProgressDialog.dismiss();

                    if (StatusCode.equals("200")) {
                        no_data.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        int Size = pojoitem.getEmployeeInformation().size();

                        arrayList = new ArrayList<ManageEmployeeCourseInformation>();

                        for (int i = 1; i < Size; i++) {
                            ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                            pojo.setMEDIUM(pojoitem.getEmployeeInformation().get(i).getMEDIUM());


                            arrayList.add(pojo);

                        }
                      ManageEmployeeMediumAdapter  adapter = new ManageEmployeeMediumAdapter(ManageEmployeeMediumByCourseActivity.this, arrayList);
                        listView.setAdapter(adapter);


                    } else {
                        no_data.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                        linear_Search.setVisibility(View.GONE);

                        String DisplayMsg = pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                        mProgressDialog.dismiss();
                        Toast.makeText(ManageEmployeeMediumByCourseActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
                    mProgressDialog.dismiss();
                    Log.e("Failure ", t.getMessage());
                }
            });
        }
    }









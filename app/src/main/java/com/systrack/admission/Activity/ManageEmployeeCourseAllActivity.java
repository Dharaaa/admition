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
import com.systrack.admission.adapter.hrAdapter.ManageEmployeeCourseAdapter;
import com.systrack.admission.pojo.ManageEmployeeCourseInformation;
import com.systrack.admission.pojo.ManageEmployeeCoursePojo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class ManageEmployeeCourseAllActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    Map<String, String> params;
    EditText edt_search_by_name;
    TextView no_data;
    ListView listView_course_list;
    ArrayList<ManageEmployeeCourseInformation> array_course_spinner;
    ManageEmployeeCourseAdapter courseAdapter;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;

    AppController appController;

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

        edt_search_by_name = (EditText)findViewById(R.id.edt_search_by_name);

        no_data = (TextView)findViewById(R.id.no_data);
        listView_course_list = (ListView)findViewById(R.id.listView_course_list);

        edt_search_by_name.setTypeface(typeface_semibold);
        no_data.setTypeface(typeface_semibold);
        getCourseList();

        ImageView back_arrow=findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

Log.e("Flag ",appController.getManageEmpCourseFlag()+ " ** ");


        edt_search_by_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");


                Call<ManageEmployeeCoursePojo> call=apiInterface.FillCourseList(entity_id,"0",edt_search_by_name.getText().toString());
                call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
                    @Override
                    public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                        Log.e("Response  ",new Gson().toJson(response.body()));
                        ManageEmployeeCoursePojo pojoitem=response.body();
                        String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();

                        if(StatusCode.equals("200"))
                        {
                            no_data.setVisibility(View.GONE);
                            listView_course_list.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getEmployeeInformation().size();

                            array_course_spinner = new ArrayList<ManageEmployeeCourseInformation>();

                            for(int i =1; i<Size; i++){
                                ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                                pojo.setSTREAMID(pojoitem.getEmployeeInformation().get(i).getSTREAMID());
                                pojo.setSTREAMNAME(pojoitem.getEmployeeInformation().get(i).getSTREAMNAME());
                                array_course_spinner.add(pojo);

                            }
                            courseAdapter = new ManageEmployeeCourseAdapter(ManageEmployeeCourseAllActivity.this,array_course_spinner);
                            listView_course_list.setAdapter(courseAdapter);
                        }else
                        {
                            no_data.setVisibility(View.VISIBLE);
                            listView_course_list.setVisibility(View.GONE);

                            String DisplayMsg=pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                            Toast.makeText(ManageEmployeeCourseAllActivity.this,DisplayMsg,Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
                        Log.e("Failure ",t.getMessage());
                    }
                });


            }
        });

        listView_course_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(appController.getManageEmpCourseFlag().equals("ManageEmployee")) {
                    appController.setManageEmpStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setManageEmpStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("ClassTiming")) {
                    appController.setClassTimingStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setClassTimingStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("TimeTable")) {
                    appController.setTimeTableStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setTimeTableStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("StudentAttendance")) {
                    appController.setStuAttendanceStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setStuAttendanceStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("AttendanceStatistic")) {
                    appController.setAttendanceStstisticStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setAttendanceStstisticStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("LectureAttendance")) {

                    appController.setLectureAttendanceStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setLectureAttendanceStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("LeaveReporting")) {
                    appController.setLeaveReportingStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setLeaveReportingStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("LeaveAssign")) {
                    appController.setLeaveAssignStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setLeaveAssignStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("LeaveApplicant")) {
                    appController.setLeaveApplicantStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setLeaveApplicantStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("ManageAttendance")) {
                    appController.setManageAttendanceSteamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setManageAttendanceStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("ExamTimeTable")) {
                    appController.setExamTimetableStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setExamTimeTableStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("ModeratorAffiliation")) {
                    appController.setModerator_affiliation_streamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setModerator_affiliation_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("GenerateMarkSheet")) {
                    appController.setGenerate_marksheet_streamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setGenerate_marksheet_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("BroadSheet")) {
                    appController.setBroadSheet_streamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setBroadSheet_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("TeacherAllocation")) {
                    appController.setTeacher_allocation_streamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setTeacher_allocation_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("SubjectAllocation")) {
                    appController.setSubject_allocation_streamID(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setSubject_allocation_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("ManageStudent")) {
                    appController.setManage_student_streamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setManage_student_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("Assignment")) {
                    appController.setAssignment_streamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setAssignment_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("Notice")) {
                    appController.setDashBoardMgtNoticeStreamID(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setDashBoardMgtNoticeStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("EmployeeContact")) {
                    appController.setEmployeeContactStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setEmployeeContactStreamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }else if(appController.getManageEmpCourseFlag().equals("StudentContact")) {
                    appController.setStudent_contact_streamId(array_course_spinner.get(position).getSTREAMID().toString());
                    appController.setStudent_contact_streamName(array_course_spinner.get(position).getSTREAMNAME());
                    finish();
                }




            }
        });
    }




    private void getCourseList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(ManageEmployeeCourseAllActivity.this);
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");


        Call<ManageEmployeeCoursePojo> call=apiInterface.FillCourseList(entity_id,"0","");
        call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
            @Override
            public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                ManageEmployeeCoursePojo pojoitem=response.body();

                String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView_course_list.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getEmployeeInformation().size();

                    array_course_spinner = new ArrayList<ManageEmployeeCourseInformation>();

                    for(int i =1; i<Size; i++){
                        ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                        pojo.setSTREAMID(pojoitem.getEmployeeInformation().get(i).getSTREAMID());
                        pojo.setSTREAMNAME(pojoitem.getEmployeeInformation().get(i).getSTREAMNAME());


                        array_course_spinner.add(pojo);

                    }
                    courseAdapter = new ManageEmployeeCourseAdapter(ManageEmployeeCourseAllActivity.this,array_course_spinner);
                    listView_course_list.setAdapter(courseAdapter);




                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView_course_list.setVisibility(View.GONE);
                    linear_Search.setVisibility(View.GONE);

                    String DisplayMsg=pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(ManageEmployeeCourseAllActivity.this,DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }

}

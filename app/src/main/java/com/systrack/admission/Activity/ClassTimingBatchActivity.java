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
import com.systrack.admission.adapter.TimeTableAdapter.ClassTimingBatchAdapter;
import com.systrack.admission.adapter.hrAdapter.ManageEmployeeDesignationAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.ManageEmployeeCourseInformation;
import com.systrack.admission.pojo.ManageEmployeeCoursePojo;
import com.systrack.admission.pojo.RoomCategoryInformation;
import com.systrack.admission.pojo.RoomCategoryInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClassTimingBatchActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    String currentAcademicYear;
    ArrayList<RoomCategoryInformation> arrayList;
    AppController appController;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;
    String CourseId,medium,error;


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

        if(appController.getClassTimingBatchFlag().equals("ClassTiming")){
           if(appController.getClassTimingStreamId()==null){
               error="Please Select Course";
           }else if(appController.getClassTimingMedium()==null){
               error="Please Select Medium";
            }else{
               CourseId=appController.getClassTimingStreamId();
               medium=appController.getClassTimingMedium();
           }
        }else if(appController.getClassTimingBatchFlag().equals("TimeTable")){
            if(appController.getTimeTableStreamId()==null){
                error="Please Select Course";
            }else if(appController.getTimeTableMedium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getTimeTableStreamId();
                medium=appController.getTimeTableMedium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("StudentAttendance")){
            if(appController.getStuAttendanceStreamId()==null){
                error="Please Select Course";
            }else if(appController.getStuAttendanceMedium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getStuAttendanceStreamId();
                medium=appController.getStuAttendanceMedium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("AttendanceStatistic")){
            if(appController.getAttendanceStstisticStreamId()==null){
                error="Please Select Course";
            }else if(appController.getAttendanceStstisticMedium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getAttendanceStstisticStreamId();
                medium=appController.getAttendanceStstisticMedium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("LectureAttendance")){
            if(appController.getLectureAttendanceStreamId()==null){
                error="Please Select Course";
            }else if(appController.getLectureAttendanceMedium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getLectureAttendanceStreamId();
                medium=appController.getLectureAttendanceMedium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("ExamTimeTable")){
            if(appController.getExamTimetableStreamId()==null){
                error="Please Select Course";
            }else if(appController.getExamTimeTableMedium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getExamTimetableStreamId();
                medium=appController.getExamTimeTableMedium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("ModeratorAffiliation")){
            if(appController.getModerator_affiliation_streamId()==null){
                error="Please Select Course";
            }else if(appController.getModerator_affiliation_medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getModerator_affiliation_streamId();
                medium=appController.getModerator_affiliation_medium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("GenerateMarkSheet")){
            if(appController.getGenerate_marksheet_streamId()==null){
                error="Please Select Course";
            }else if(appController.getGenerate_marksheet_medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getGenerate_marksheet_streamId();
                medium=appController.getGenerate_marksheet_medium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("BroadSheet")){
            if(appController.getBroadSheet_streamId()==null){
                error="Please Select Course";
            }else if(appController.getBroadSheet_Medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getBroadSheet_streamId();
                medium=appController.getBroadSheet_Medium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("TeacherAllocation")){
            if(appController.getTeacher_allocation_streamId()==null){
                error="Please Select Course";
            }else if(appController.getTeacher_allocation_medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getTeacher_allocation_streamId();
                medium=appController.getTeacher_allocation_medium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("SubjectAllocation")){
            if(appController.getSubject_allocation_streamID()==null){
                error="Please Select Course";
            }else if(appController.getSubject_allocation_medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getSubject_allocation_streamID();
                medium=appController.getSubject_allocation_medium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("ManageStudent")){
            if(appController.getManage_student_streamId()==null){
                error="Please Select Course";
            }else if(appController.getManage_student_medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getManage_student_streamId();
                medium=appController.getManage_student_medium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("Assignment")){
            if(appController.getAssignment_streamId()==null){
                error="Please Select Course";
            }else if(appController.getAssignment_medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getAssignment_streamId();
                medium=appController.getAssignment_medium();
            }
        }else if(appController.getClassTimingBatchFlag().equals("StudentContact")){
            if(appController.getStudent_contact_streamId()==null){
                error="Please Select Course";
            }else if(appController.getStudent_contact_medium()==null){
                error="Please Select Medium";
            }else{
                CourseId=appController.getStudent_contact_streamId();
                medium=appController.getStudent_contact_medium();
            }
        }






        getAdmissionYear();
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
                String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


                Call<RoomCategoryInformationPojo> call = apiInterface.FillBatchList(currentAcademicYear, entity_id, branch_id,"0",CourseId,
                        medium,edt_search.getText().toString().trim());
                call.enqueue(new Callback<RoomCategoryInformationPojo>() {
                    @Override
                    public void onResponse(Call<RoomCategoryInformationPojo> call, Response<RoomCategoryInformationPojo> response) {
                        Log.e("Response batch ", new Gson().toJson(response.body()));


                        RoomCategoryInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getRoomCategoryInformation().get(0).getStatusCode();


                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getRoomCategoryInformation().size();

                            arrayList = new ArrayList<RoomCategoryInformation>();

                            for (int i = 1; i < Size; i++) {
                                RoomCategoryInformation pojo = new RoomCategoryInformation();

                                pojo.setbATCHID(pojoitem.getRoomCategoryInformation().get(i).getbATCHID());
                                pojo.setbATCHNAME(pojoitem.getRoomCategoryInformation().get(i).getbATCHNAME());


                                arrayList.add(pojo);

                            }
                            ClassTimingBatchAdapter adapter = new ClassTimingBatchAdapter(ClassTimingBatchActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);

                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getRoomCategoryInformation().get(0).getDisplayMessage();
                            Toast.makeText(ClassTimingBatchActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<RoomCategoryInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(appController.getClassTimingBatchFlag().equals("ClassTiming")){
                appController.setClassTimingBatchId(String.valueOf(arrayList.get(position).getbATCHID()));
                appController.setClassTimingBatchName(arrayList.get(position).getbATCHNAME());

                finish();
                }else if(appController.getClassTimingBatchFlag().equals("TimeTable")){
                    appController.setTimeTableBatchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setTimeTableBatchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("StudentAttendance")){
                    appController.setStuAttendanceBatchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setStuAttendanceBatchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("AttendanceStatistic")){
                    appController.setAttendanceStstisticBatchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setAttendanceStstisticBatchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("LectureAttendance")){
                    appController.setLectureAttendanceBatchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setLectureAttendanceBatchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("ExamTimeTable")){
                    appController.setExamTimeTableBatchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setExamTimeTableBatchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("ModeratorAffiliation")){
                    appController.setModerator_affiliation_batchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setModerator_affiliation_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("GenerateMarkSheet")){
                    appController.setGenerate_marksheet_batchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setGenerate_marksheet_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("BroadSheet")){
                    appController.setBroadSheet_batch_id(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setBroadSheet_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("TeacherAllocation")){
                    appController.setTeacher_allocation_batchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setTeacher_allocation_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("SubjectAllocation")){
                    appController.setSubject_allocation_batchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setSubject_allocation_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("ManageStudent")){
                    appController.setManage_student_batchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setManage_student_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("Assignment")){
                    appController.setAssignment_batchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setAssignment_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }else if(appController.getClassTimingBatchFlag().equals("StudentContact")){
                    appController.setStudent_contact_batchId(String.valueOf(arrayList.get(position).getbATCHID()));
                    appController.setStudent_contact_batchName(arrayList.get(position).getbATCHNAME());

                    finish();
                }




            }
        });


    }


    private void getAdmissionYear() {


        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
        String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


        Call<AdmissionYearInformationPojo> call = apiInterface.FillAdmissionYearList(entity_id);
        call.enqueue(new Callback<AdmissionYearInformationPojo>() {
            @Override
            public void onResponse(Call<AdmissionYearInformationPojo> call, Response<AdmissionYearInformationPojo> response) {
                Log.e("Response  ", new Gson().toJson(response.body()));


                AdmissionYearInformationPojo pojoitem = response.body();

                String StatusCode = pojoitem.getAdmissionYearInformation().get(0).getStatusCode();


                if (StatusCode.equals("200")) {

                     currentAcademicYear= String.valueOf(pojoitem.getAdmissionYearInformation().get(1).getYEAR());
getBatchList();


                } else {

                    String DisplayMsg = pojoitem.getAdmissionYearInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(ClassTimingBatchActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AdmissionYearInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });

    }


    private void getBatchList() {

if(error!=null) {
    Toast.makeText(ClassTimingBatchActivity.this, error, Toast.LENGTH_SHORT).show();
}else{

    if (mProgressDialog == null)
        mProgressDialog = new TransparentProgressDialog(ClassTimingBatchActivity.this);
    if (mProgressDialog.isShowing())
        mProgressDialog.dismiss();
    //mProgressDialog = new TransparentProgressDialog(getActivity());
    mProgressDialog.setCancelable(false);
    mProgressDialog.show();

    String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
    String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


    Call<RoomCategoryInformationPojo> call = apiInterface.FillBatchList(currentAcademicYear, entity_id, branch_id,"0",CourseId,
            medium,"");
    call.enqueue(new Callback<RoomCategoryInformationPojo>() {
        @Override
        public void onResponse(Call<RoomCategoryInformationPojo> call, Response<RoomCategoryInformationPojo> response) {
            Log.e("Response batch ", new Gson().toJson(response.body()));


            RoomCategoryInformationPojo pojoitem = response.body();

            String StatusCode = pojoitem.getRoomCategoryInformation().get(0).getStatusCode();

            mProgressDialog.dismiss();

            if (StatusCode.equals("200")) {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                int Size = pojoitem.getRoomCategoryInformation().size();

                arrayList = new ArrayList<RoomCategoryInformation>();

                for (int i = 1; i < Size; i++) {
                    RoomCategoryInformation pojo = new RoomCategoryInformation();

                    pojo.setbATCHID(pojoitem.getRoomCategoryInformation().get(i).getbATCHID());
                    pojo.setbATCHNAME(pojoitem.getRoomCategoryInformation().get(i).getbATCHNAME());


                    arrayList.add(pojo);

                }
                ClassTimingBatchAdapter adapter = new ClassTimingBatchAdapter(ClassTimingBatchActivity.this, arrayList);
                listView.setAdapter(adapter);


            } else {
                no_data.setVisibility(View.VISIBLE);

                listView.setVisibility(View.GONE);
                linear_Search.setVisibility(View.GONE);

                String DisplayMsg = pojoitem.getRoomCategoryInformation().get(0).getDisplayMessage();
                mProgressDialog.dismiss();
                Toast.makeText(ClassTimingBatchActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<RoomCategoryInformationPojo> call, Throwable t) {
            mProgressDialog.dismiss();
            Log.e("Failure ", t.getMessage());
        }
    });
}

    }






}


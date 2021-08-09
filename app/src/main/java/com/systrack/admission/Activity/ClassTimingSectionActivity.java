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
import com.systrack.admission.adapter.TimeTableAdapter.ClassTimingSectionAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.CurrentTermInformationPojo;
import com.systrack.admission.pojo.RoomCategoryInformation;
import com.systrack.admission.pojo.RoomCategoryInformationPojo;
import com.systrack.admission.pojo.SectionInformation;
import com.systrack.admission.pojo.SectionInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClassTimingSectionActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    String currentAcademicYear;
    ArrayList<SectionInformation> arrayList;
    AppController appController;
    String currentActiveTerm;
    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;
    String CourseId;
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
        if (appController.getClassTimingSectionFlag().equals("ClassTiming")){
            if(appController.getClassTimingStreamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getClassTimingStreamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("TimeTable")){
            if(appController.getTimeTableStreamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getTimeTableStreamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("StudentAttendance")){
            if(appController.getStuAttendanceStreamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getStuAttendanceStreamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("AttendanceStatistic")){
            if(appController.getAttendanceStstisticStreamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getAttendanceStstisticStreamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("LectureAttendance")){
            if(appController.getLectureAttendanceStreamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getLectureAttendanceStreamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("ExamTimeTable")){
            if(appController.getExamTimetableStreamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getExamTimetableStreamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("ModeratorAffiliation")){
            if(appController.getModerator_affiliation_streamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getModerator_affiliation_streamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("GenerateMarkSheet")){
            if(appController.getGenerate_marksheet_streamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getGenerate_marksheet_streamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("BroadSheet")){
            if(appController.getBroadSheet_streamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getBroadSheet_streamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("TeacherAllocation")){
            if(appController.getTeacher_allocation_streamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getTeacher_allocation_streamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("SubjectAllocation")){
            if(appController.getSubject_allocation_streamID()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getSubject_allocation_streamID();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("ManageStudent")){
            if(appController.getManage_student_streamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getManage_student_streamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("Assignment")){
            if(appController.getAssignment_streamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getAssignment_streamId();
                getCurrentTerm();
            }
        }else if (appController.getClassTimingSectionFlag().equals("StudentContact")){
            if(appController.getStudent_contact_streamId()==null){
                Toast.makeText(ClassTimingSectionActivity.this, "Please Select Course", Toast.LENGTH_SHORT).show();
            }else{
                CourseId=appController.getStudent_contact_streamId();
                getCurrentTerm();
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
                String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


                Call<SectionInformationPojo> call = apiInterface.FillSemesterList(entity_id,CourseId,currentActiveTerm,edt_search.getText().toString());
                call.enqueue(new Callback<SectionInformationPojo>() {
                    @Override
                    public void onResponse(Call<SectionInformationPojo> call, Response<SectionInformationPojo> response) {
                        Log.e("Response batch ", new Gson().toJson(response.body()));


                        SectionInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getSemesterInformation().get(0).getStatusCode();


                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getSemesterInformation().size();

                            arrayList = new ArrayList<SectionInformation>();

                            for (int i = 1; i < Size; i++) {
                                SectionInformation pojo = new SectionInformation();

                                pojo.setSTREAMTYPE(pojoitem.getSemesterInformation().get(i).getSTREAMTYPE());


                                arrayList.add(pojo);

                            }
                            ClassTimingSectionAdapter adapter = new ClassTimingSectionAdapter(ClassTimingSectionActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);

                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getSemesterInformation().get(0).getDisplayMessage();
                            Toast.makeText(ClassTimingSectionActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<SectionInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(appController.getClassTimingSectionFlag().equals("ClassTiming")){
                appController.setClassTimingSemName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                finish();
                }else if(appController.getClassTimingSectionFlag().equals("TimeTable")){
                    appController.setTimeTableSemName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("StudentAttendance")){
                    appController.setStuAttendanceSectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("AttendanceStatistic")){
                    appController.setAttendanceStstisticSectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("LectureAttendance")){
                    appController.setLectureAttendanceSecName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("ExamTimeTable")){
                    appController.setExamTimeTableSectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("ModeratorAffiliation")){
                    appController.setModerator_affiliation_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("GenerateMarkSheet")){
                    appController.setGenerate_marksheet_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("BroadSheet")){
                    appController.setBroadSheet_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("TeacherAllocation")){
                    appController.setTeacher_allocation_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("SubjectAllocation")){
                    appController.setSubject_allocation_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("ManageStudent")){
                    appController.setManage_student_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("Assignment")){
                    appController.setAssignment_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }else if(appController.getClassTimingSectionFlag().equals("StudentContact")){
                    appController.setStudent_contact_sectionName(String.valueOf(arrayList.get(position).getSTREAMTYPE()));
                    finish();
                }





            }
        });




    }


    private void getCurrentTerm() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(ClassTimingSectionActivity.this);
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");


        Call<CurrentTermInformationPojo> call = apiInterface.FillCurrentTermList(entity_id);
        call.enqueue(new Callback<CurrentTermInformationPojo>() {
            @Override
            public void onResponse(Call<CurrentTermInformationPojo> call, Response<CurrentTermInformationPojo> response) {
                Log.e("Response batch ", new Gson().toJson(response.body()));


                CurrentTermInformationPojo pojoitem = response.body();

                String StatusCode = pojoitem.getCurrentTermInformation().get(0).getStatusCode();


                if (StatusCode.equals("200")) {
                    currentActiveTerm= String.valueOf(pojoitem.getCurrentTermInformation().get(1).getACTIVETERM());
                    getSectionList();
                } else {

                    String DisplayMsg = pojoitem.getCurrentTermInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(ClassTimingSectionActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<CurrentTermInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });
    }


    private void getSectionList() {

//    if (mProgressDialog == null)
//        mProgressDialog = new TransparentProgressDialog(ClassTimingSectionActivity.this);
//    if (mProgressDialog.isShowing())
//        mProgressDialog.dismiss();
//    //mProgressDialog = new TransparentProgressDialog(getActivity());
//    mProgressDialog.setCancelable(false);
//    mProgressDialog.show();

    String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
    String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


    Call<SectionInformationPojo> call = apiInterface.FillSemesterList(entity_id, CourseId,currentActiveTerm,"");
    call.enqueue(new Callback   <SectionInformationPojo>() {
        @Override
        public void onResponse(Call<SectionInformationPojo> call, Response<SectionInformationPojo> response) {
            Log.e("Response batch ", new Gson().toJson(response.body()));


            SectionInformationPojo pojoitem = response.body();

            String StatusCode = pojoitem.getSemesterInformation().get(0).getStatusCode();

            mProgressDialog.dismiss();

            if (StatusCode.equals("200")) {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                int Size = pojoitem.getSemesterInformation().size();

                arrayList = new ArrayList<SectionInformation>();

                for (int i = 1; i < Size; i++) {
                    SectionInformation pojo = new SectionInformation();

                    pojo.setSTREAMTYPE(pojoitem.getSemesterInformation().get(i).getSTREAMTYPE());


                    arrayList.add(pojo);

                }
                ClassTimingSectionAdapter adapter = new ClassTimingSectionAdapter(ClassTimingSectionActivity.this, arrayList);
                listView.setAdapter(adapter);


            } else {
                no_data.setVisibility(View.VISIBLE);

                listView.setVisibility(View.GONE);
                linear_Search.setVisibility(View.GONE);

                String DisplayMsg = pojoitem.getSemesterInformation().get(0).getDisplayMessage();
                mProgressDialog.dismiss();
                Toast.makeText(ClassTimingSectionActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<SectionInformationPojo> call, Throwable t) {
            mProgressDialog.dismiss();
            Log.e("Failure ", t.getMessage());
        }
    });
}








}


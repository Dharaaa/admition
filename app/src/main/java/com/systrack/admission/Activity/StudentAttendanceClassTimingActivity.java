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
import com.systrack.admission.adapter.StudentAttendanceAdapter.StudentAttendanceClassTimingAdapter;
import com.systrack.admission.adapter.StudentAttendanceAdapter.StudentAttendanceSubAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.ClassTimingInformation;
import com.systrack.admission.pojo.ClassTimingInformationPojo;
import com.systrack.admission.pojo.StudentAttendanceInformation;
import com.systrack.admission.pojo.StudentAttendanceInformationPojo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StudentAttendanceClassTimingActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    Map<String, String> params;
    EditText edt_search_by_name;
    TextView no_data;
    ListView listView;
    ArrayList<ClassTimingInformation> array_course_spinner;
    StudentAttendanceClassTimingAdapter adapter;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;

    AppController appController;
    String currentAcademicYear;
    String error;
    String CourseId,BatchId;
    String Medium,SectionId,DivisionId,EMPTIMETABLETYPE;
    boolean ISALLOWDIVISION;
    String SubjectId,Lecture_date;

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
        ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);
        EMPTIMETABLETYPE=sharedpreferences.getString(getString(R.string.EMPTIMETABLETYPE),"0");

        edt_search_by_name = (EditText)findViewById(R.id.edt_search_by_name);
      boolean  ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);

        no_data = (TextView)findViewById(R.id.no_data);
        listView = (ListView)findViewById(R.id.listView_course_list);

        edt_search_by_name.setTypeface(typeface_semibold);
        no_data.setTypeface(typeface_semibold);

        ImageView back_arrow=findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

//        if(appController.getStuAttendanceSubFlag().equals("StudentAttendance")){
//            if(appController.getStuAttendanceBatchId()==null){
//                error="Please Select Batch";
//            }else if(appController.getStuAttendanceSectionName()==null){
//                error="Please Select Section";
//            } else if(ISALLOWDIVISION){
//                if(appController.getStuAttendanceDivName()==null){
//                    error="Please Select Division";
//                }else{
//                  DivisionId=appController.getStuAttendanceDivId();
//                }
//
//            }else if(!ISALLOWDIVISION){
//                DivisionId="0";
//            }else{
//                BatchId=appController.getStuAttendanceBatchId();
//                SectionId=appController.getStuAttendanceSectionName();
//            }
//        }if(appController.getStuAttendanceSubFlag().equals("LectureAttendance")){
//            if(appController.getLectureAttendanceBatchId()==null){
//                error="Please Select Batch";
//            }else if(appController.getLectureAttendanceSecName()==null){
//                error="Please Select Section";
//            } else if(ISALLOWDIVISION){
//                if(appController.getLectureAttendanceDivId()==null){
//                    error="Please Select Division";
//                }else{
//                    DivisionId=appController.getLectureAttendanceDivId();
//                }
//
//            }else if(!ISALLOWDIVISION){
//                DivisionId="0";
//            }else{
//                BatchId=appController.getLectureAttendanceBatchId();
//                SectionId=appController.getLectureAttendanceSecName();
//            }
//        }


        edt_search_by_name.addTextChangedListener(new TextWatcher() {
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


                Call<ClassTimingInformationPojo> call = apiInterface.FillClassTimingList(entity_id, branch_id, BatchId,SubjectId,appController.getCurrentAcademicYear(),
                        SectionId,CourseId,Medium,Lecture_date,EMPTIMETABLETYPE,DivisionId);
                call.enqueue(new Callback<ClassTimingInformationPojo>() {
                    @Override
                    public void onResponse(Call<ClassTimingInformationPojo> call, Response<ClassTimingInformationPojo> response) {
                        Log.e("Response  ", new Gson().toJson(response.body()));


                        ClassTimingInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getClassTimingInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getClassTimingInformation().size();

                            array_course_spinner = new ArrayList<ClassTimingInformation>();

                            for (int i = 1; i < Size; i++) {
                                ClassTimingInformation pojo = new ClassTimingInformation();
                                pojo.setCLASSTIMEID(pojoitem.getClassTimingInformation().get(i).getCLASSTIMEID());
                                pojo.setClassTiming(pojoitem.getClassTimingInformation().get(i).getClassTiming());


                                array_course_spinner.add(pojo);

                            }
                            adapter = new StudentAttendanceClassTimingAdapter(StudentAttendanceClassTimingActivity.this, array_course_spinner);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);
                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getClassTimingInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(StudentAttendanceClassTimingActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ClassTimingInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });

            }
        });
        if(appController.getStuAttendanceClassTimeFlag().equals("StudentAttendance"))
        {
            if(appController.getStuAttendanceStreamId()==null){
                error="Please Select Course";
            }else if(appController.getStuAttendanceMedium()==null){
                error="Please Select Medium";
            }else if(appController.getStuAttendanceBatchId()==null){
                error="Please Select Batch";
            }else if(appController.getStuAttendanceSectionName()==null){
                error="Please Select Semester / Year";
            }else if(ISALLOWDIVISION && appController.getStuAttendanceDivId()==null){
                error="Please Select Division";
            }else if(appController.getStuAttendanceLectureDate()==null){
                error="Please Select Lecture Date";
            }else if(appController.getStuAttendanceSubName()==null){
                error="Please Select Subject";
            }else{
                SectionId=appController.getStuAttendanceSectionName();
                SubjectId=appController.getStuAttendanceSubId();
                BatchId=appController.getStuAttendanceBatchId();
                CourseId=appController.getStuAttendanceStreamId();
                Medium=appController.getStuAttendanceMedium();
                Lecture_date=appController.getStuAttendanceLectureDate();
                if (ISALLOWDIVISION){
                    DivisionId=appController.getStuAttendanceDivId();
                }else {
                    DivisionId="0";
                }
                Log.e("Param ",SectionId + " ** "+SubjectId +" ** "+BatchId +" ** "+CourseId +" ** "+Medium+" ** "+Lecture_date +" ** "+DivisionId+" **"+EMPTIMETABLETYPE);

            }
        }else if(appController.getStuAttendanceClassTimeFlag().equals("LectureAttendance")){
            if(appController.getLectureAttendanceStreamId()==null){
                error="Please Select Course";
            }else if(appController.getLectureAttendanceMedium()==null){
                error="Please Select Medium";
            }else if(appController.getLectureAttendanceBatchId()==null){
                error="Please Select Batch";
            }else if(appController.getLectureAttendanceSecName()==null){
                error="Please Select Semester / Year";
            }else if(ISALLOWDIVISION && appController.getLectureAttendanceDivId()==null){
                error="Please Select Division";
            }else if(appController.getLectureAttendanceLectureDate()==null){
                error="Please Select Lecture Date";
            }else if(appController.getLectureAttendanceSubId()==null){
                error="Please Select Subject";
            }else{
                SectionId=appController.getLectureAttendanceSecName();
                SubjectId=appController.getLectureAttendanceSubId();
                BatchId=appController.getLectureAttendanceBatchId();
                CourseId=appController.getLectureAttendanceStreamId();
                Medium=appController.getLectureAttendanceMedium();
                Lecture_date=appController.getLectureAttendanceLectureDate();
                if (ISALLOWDIVISION){
                    DivisionId=appController.getLectureAttendanceDivId();
                }else {
                    DivisionId="0";
                }
                Log.e("Param ",SectionId + " ** "+SubjectId +" ** "+BatchId +" ** "+CourseId +" ** "+Medium+" ** "+Lecture_date +" ** "+DivisionId+" **"+EMPTIMETABLETYPE);

            }
        }

        getClassTimingList();


//        getAdmissionYear();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if(appController.getStuAttendanceClassTimeFlag().equals("StudentAttendance")) {
                    appController.setStuAttendanceClassTimingId(array_course_spinner.get(position).getCLASSTIMEID());
                    appController.setStuAttendanceClassTimingName(array_course_spinner.get(position).getClassTiming());
                    finish();
                }if(appController.getStuAttendanceClassTimeFlag().equals("LectureAttendance")) {
                    appController.setLectureAttendanceClassTimingID(array_course_spinner.get(position).getCLASSTIMEID());
                    appController.setLectureAttendanceClassTimingName(array_course_spinner.get(position).getClassTiming());
                    finish();
                }
            }
        });
    }

    private void getAdmissionYear() {
        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(StudentAttendanceClassTimingActivity.this);
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();


        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
        String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


        Call<AdmissionYearInformationPojo> call = apiInterface.FillAdmissionYearList(entity_id);
        call.enqueue(new Callback<AdmissionYearInformationPojo>() {
            @Override
            public void onResponse(Call<AdmissionYearInformationPojo> call, Response<AdmissionYearInformationPojo> response) {
                Log.e("Response 255 ", new Gson().toJson(response.body()));


                AdmissionYearInformationPojo pojoitem = response.body();

                String StatusCode = pojoitem.getAdmissionYearInformation().get(0).getStatusCode();


                if (StatusCode.equals("200")) {

                    currentAcademicYear= String.valueOf(pojoitem.getAdmissionYearInformation().get(1).getYEAR());
                    getClassTimingList();


                } else {

                    String DisplayMsg = pojoitem.getAdmissionYearInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(StudentAttendanceClassTimingActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AdmissionYearInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });

    }



    private void getClassTimingList() {
        if(error==null) {

            if (mProgressDialog == null)
                mProgressDialog = new TransparentProgressDialog(StudentAttendanceClassTimingActivity.this);
            if (mProgressDialog.isShowing())
                mProgressDialog.dismiss();
            //mProgressDialog = new TransparentProgressDialog(getActivity());
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
            String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
            String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


            Call<ClassTimingInformationPojo> call = apiInterface.FillClassTimingList(entity_id, branch_id, BatchId,SubjectId,appController.getCurrentAcademicYear(),
                    SectionId,CourseId,Medium,Lecture_date,EMPTIMETABLETYPE,DivisionId);
            call.enqueue(new Callback<ClassTimingInformationPojo>() {
                @Override
                public void onResponse(Call<ClassTimingInformationPojo> call, Response<ClassTimingInformationPojo> response) {
                    Log.e("Response 309 ", new Gson().toJson(response.body()));


                    ClassTimingInformationPojo pojoitem = response.body();

                    String StatusCode = pojoitem.getClassTimingInformation().get(0).getStatusCode();

                    mProgressDialog.dismiss();

                    if (StatusCode.equals("200")) {
                        no_data.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        int Size = pojoitem.getClassTimingInformation().size();

                        array_course_spinner = new ArrayList<ClassTimingInformation>();

                        for (int i = 1; i < Size; i++) {
                            ClassTimingInformation pojo = new ClassTimingInformation();

                            pojo.setCLASSTIMEID(pojoitem.getClassTimingInformation().get(i).getCLASSTIMEID());
                            pojo.setClassTiming(pojoitem.getClassTimingInformation().get(i).getClassTiming());


                            array_course_spinner.add(pojo);

                        }
                        adapter = new StudentAttendanceClassTimingAdapter(StudentAttendanceClassTimingActivity.this, array_course_spinner);
                        listView.setAdapter(adapter);


                    } else {
                        no_data.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                        linear_Search.setVisibility(View.GONE);

                        String DisplayMsg = pojoitem.getClassTimingInformation().get(0).getDisplayMessage();
                        mProgressDialog.dismiss();
                        Toast.makeText(StudentAttendanceClassTimingActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<ClassTimingInformationPojo> call, Throwable t) {
                    mProgressDialog.dismiss();
                    Log.e("Failure ", t.getMessage());
                }
            });
        }else{
            Toast.makeText(StudentAttendanceClassTimingActivity.this, error , Toast.LENGTH_SHORT).show();
        }
    }



}

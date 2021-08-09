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
import com.systrack.admission.adapter.CourseMgtAdapter.CourseMgtDivisionAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.ClassTimingBatchAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.ClassDivisionInformation;
import com.systrack.admission.pojo.ClassDivisionInformationPojo;
import com.systrack.admission.pojo.RoomCategoryInformation;
import com.systrack.admission.pojo.RoomCategoryInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CourseMgtDivisionActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    ArrayList<ClassDivisionInformation> arrayList;
    AppController appController;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;
    String CourseId,medium,SectionId,BatchId,error;


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



        ImageView back_arrow=findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



if(appController.getCourseMgtDivisionFlag().equals("StudentAttendance")){
    if(appController.getStuAttendanceStreamId()==null){
        error="Please Select Course";
    }else if(appController.getStuAttendanceMedium()==null){
        error="Please Select Medium";
    }else if(appController.getStuAttendanceBatchId()==null){
        error="Please Select Batch";
    }else if(appController.getStuAttendanceSectionName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getStuAttendanceStreamId();
        medium=appController.getStuAttendanceMedium();
        BatchId=appController.getStuAttendanceBatchId();
        SectionId=appController.getStuAttendanceSectionName();
    }
}else if(appController.getCourseMgtDivisionFlag().equals("LectureAttendance")){
    if(appController.getLectureAttendanceStreamId()==null){
        error="Please Select Course";
    }else if(appController.getLectureAttendanceMedium()==null){
        error="Please Select Medium";
    }else if(appController.getLectureAttendanceBatchId()==null){
        error="Please Select Batch";
    }else if(appController.getLectureAttendanceSecName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getLectureAttendanceStreamId();
        medium=appController.getLectureAttendanceMedium();
        BatchId=appController.getLectureAttendanceBatchId();
        SectionId=appController.getLectureAttendanceSecName();
    }
}else if(appController.getCourseMgtDivisionFlag().equals("AttendanceStatistic")){
    if(appController.getAttendanceStstisticStreamId()==null){
        error="Please Select Course";
    }else if(appController.getAttendanceStstisticMedium()==null){
        error="Please Select Medium";
    }else if(appController.getAttendanceStstisticBatchId()==null){
        error="Please Select Batch";
    }else if(appController.getAttendanceStstisticSectionName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getAttendanceStstisticStreamId();
        medium=appController.getAttendanceStstisticMedium();
        BatchId=appController.getAttendanceStstisticBatchId();
        SectionId=appController.getAttendanceStstisticSectionName();
    }
}else if(appController.getCourseMgtDivisionFlag().equals("ClassTiming")){
    if(appController.getClassTimingStreamId()==null){
        error="Please Select Course";
    }else if(appController.getClassTimingMedium()==null){
        error="Please Select Medium";
    }else if(appController.getClassTimingBatchId()==null){
        error="Please Select Batch";
    }else if(appController.getClassTimingSemName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getClassTimingStreamId();
        medium=appController.getClassTimingMedium();
        BatchId=appController.getClassTimingBatchId();
        SectionId=appController.getClassTimingSemName();
    }
}else if(appController.getCourseMgtDivisionFlag().equals("TimeTable")){
    if(appController.getTimeTableStreamId()==null){
        error="Please Select Course";
    }else if(appController.getTimeTableMedium()==null){
        error="Please Select Medium";
    }else if(appController.getTimeTableBatchId()==null){
        error="Please Select Batch";
    }else if(appController.getTimeTableSemName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getTimeTableStreamId();
        medium=appController.getTimeTableMedium();
        BatchId=appController.getTimeTableBatchId();
        SectionId=appController.getTimeTableSemName();
    }
}else if(appController.getCourseMgtDivisionFlag().equals("ModeratorAffiliation")){
    if(appController.getModerator_affiliation_streamId()==null){
        error="Please Select Course";
    }else if(appController.getModerator_affiliation_medium()==null){
        error="Please Select Medium";
    }else if(appController.getModerator_affiliation_batchId()==null){
        error="Please Select Batch";
    }else if(appController.getModerator_affiliation_sectionName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getModerator_affiliation_streamId();
        medium=appController.getModerator_affiliation_medium();
        BatchId=appController.getModerator_affiliation_batchId();
        SectionId=appController.getModerator_affiliation_sectionName();
    }
}else if(appController.getCourseMgtDivisionFlag().equals("GenerateMarkSheet")){
    if(appController.getGenerate_marksheet_streamId()==null){
        error="Please Select Course";
    }else if(appController.getGenerate_marksheet_medium()==null){
        error="Please Select Medium";
    }else if(appController.getGenerate_marksheet_batchId()==null){
        error="Please Select Batch";
    }else if(appController.getGenerate_marksheet_sectionName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getGenerate_marksheet_streamId();
        medium=appController.getGenerate_marksheet_medium();
        BatchId=appController.getGenerate_marksheet_batchId();
        SectionId=appController.getGenerate_marksheet_sectionName();
    }
}else if(appController.getCourseMgtDivisionFlag().equals("Assignment")){
    if(appController.getAssignment_streamId()==null){
        error="Please Select Course";
    }else if(appController.getAssignment_medium()==null){
        error="Please Select Medium";
    }else if(appController.getAssignment_batchId()==null){
        error="Please Select Batch";
    }else if(appController.getAssignment_sectionName()==null){
        error="Please Select Semester/Year";
    }else{
        CourseId=appController.getAssignment_streamId();
        medium=appController.getAssignment_medium();
        BatchId=appController.getAssignment_batchId();
        SectionId=appController.getAssignment_sectionName();
    }
}




getDivisionList();
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

                Call<ClassDivisionInformationPojo> call = apiInterface.FillDivisionList(entity_id, branch_id,appController.getCurrentAcademicYear(),
                        BatchId,SectionId,medium,CourseId,edt_search.getText().toString());
                call.enqueue(new Callback<ClassDivisionInformationPojo>() {
                    @Override
                    public void onResponse(Call<ClassDivisionInformationPojo> call, Response<ClassDivisionInformationPojo> response) {
                        Log.e("Response Division ", new Gson().toJson(response.body()));


                        ClassDivisionInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getClassDivisionInformation().get(0).getStatusCode();


                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getClassDivisionInformation().size();

                            arrayList = new ArrayList<ClassDivisionInformation>();

                            for (int i = 1; i < Size; i++) {
                                ClassDivisionInformation pojo = new ClassDivisionInformation();

                                pojo.setDIVISIONNAME(pojoitem.getClassDivisionInformation().get(i).getDIVISIONNAME());
                                pojo.setDIVISIONID(pojoitem.getClassDivisionInformation().get(i).getDIVISIONID());


                                arrayList.add(pojo);

                            }
                            CourseMgtDivisionAdapter adapter = new CourseMgtDivisionAdapter(CourseMgtDivisionActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);

                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getClassDivisionInformation().get(0).getDisplayMessage();
                            Toast.makeText(CourseMgtDivisionActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ClassDivisionInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(appController.getCourseMgtDivisionFlag().equals("StudentAttendance")){
                appController.setStuAttendanceDivId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                appController.setStuAttendanceDivName(arrayList.get(position).getDIVISIONNAME());

                finish();
                }else if(appController.getCourseMgtDivisionFlag().equals("LectureAttendance")){
                    appController.setLectureAttendanceDivId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                    appController.setLectureAttendanceDivName(arrayList.get(position).getDIVISIONNAME());

                    finish();
                }else if(appController.getCourseMgtDivisionFlag().equals("AttendanceStatistic")){
                    appController.setAttendanceStstisticDivId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                    appController.setAttendanceStstisticDivName(arrayList.get(position).getDIVISIONNAME());

                    finish();
                }else if(appController.getCourseMgtDivisionFlag().equals("ClassTiming")){
                    appController.setClassTimingDivisionId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                    appController.setClassTimingDivisionName(arrayList.get(position).getDIVISIONNAME());

                    finish();
                }else if(appController.getCourseMgtDivisionFlag().equals("TimeTable")){
                    appController.setTimeTableDivisionId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                    appController.setTimeTableDivisionName(arrayList.get(position).getDIVISIONNAME());

                    finish();
                }else if(appController.getCourseMgtDivisionFlag().equals("GenerateMarkSheet")){
                    appController.setGenerate_marksheet_divisionId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                    appController.setGenerate_marksheet_divisionName(arrayList.get(position).getDIVISIONNAME());

                    finish();
                }else if(appController.getCourseMgtDivisionFlag().equals("ModeratorAffiliation")){
                    appController.setModerator_affiliation_divisionId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                    appController.setModerator_affiliation_divisionName(arrayList.get(position).getDIVISIONNAME());

                    finish();
                }else if(appController.getCourseMgtDivisionFlag().equals("Assignment")){
                    appController.setAssignment_divId(String.valueOf(arrayList.get(position).getDIVISIONID()));
                    appController.setAssignment_divName(arrayList.get(position).getDIVISIONNAME());

                    finish();
                }



            }
        });


    }




    private void getDivisionList() {

if(error!=null) {
    Toast.makeText(CourseMgtDivisionActivity.this, error, Toast.LENGTH_SHORT).show();
}else{

    if (mProgressDialog == null)
        mProgressDialog = new TransparentProgressDialog(CourseMgtDivisionActivity.this);
    if (mProgressDialog.isShowing())
        mProgressDialog.dismiss();
    //mProgressDialog = new TransparentProgressDialog(getActivcity());
    mProgressDialog.setCancelable(false);
    mProgressDialog.show();

    String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
    String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


    Call<ClassDivisionInformationPojo> call = apiInterface.FillDivisionList(entity_id, branch_id,appController.getCurrentAcademicYear(),
            BatchId,SectionId,medium,CourseId,"");
    call.enqueue(new Callback<ClassDivisionInformationPojo>() {
        @Override
        public void onResponse(Call<ClassDivisionInformationPojo> call, Response<ClassDivisionInformationPojo> response) {
            Log.e("Response Division ", new Gson().toJson(response.body()));


            ClassDivisionInformationPojo pojoitem = response.body();

            String StatusCode = pojoitem.getClassDivisionInformation().get(0).getStatusCode();

            mProgressDialog.dismiss();

            if (StatusCode.equals("200")) {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                int Size = pojoitem.getClassDivisionInformation().size();

                arrayList = new ArrayList<ClassDivisionInformation>();

                for (int i = 1; i < Size; i++) {
                    ClassDivisionInformation pojo = new ClassDivisionInformation();

                    pojo.setDIVISIONNAME(pojoitem.getClassDivisionInformation().get(i).getDIVISIONNAME());
                    pojo.setDIVISIONID(pojoitem.getClassDivisionInformation().get(i).getDIVISIONID());


                    arrayList.add(pojo);

                }
                CourseMgtDivisionAdapter adapter = new CourseMgtDivisionAdapter(CourseMgtDivisionActivity.this, arrayList);
                listView.setAdapter(adapter);


            } else {
                no_data.setVisibility(View.VISIBLE);

                listView.setVisibility(View.GONE);
                linear_Search.setVisibility(View.GONE);

                String DisplayMsg = pojoitem.getClassDivisionInformation().get(0).getDisplayMessage();
                mProgressDialog.dismiss();
                Toast.makeText(CourseMgtDivisionActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<ClassDivisionInformationPojo> call, Throwable t) {
            mProgressDialog.dismiss();
            Log.e("Failure ", t.getMessage());
        }
    });
}

    }






}


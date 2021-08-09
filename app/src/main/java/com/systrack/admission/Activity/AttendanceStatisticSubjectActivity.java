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
import com.systrack.admission.adapter.StudentAttendanceAdapter.StudentAttendanceSubAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.StudentAttendanceInformation;
import com.systrack.admission.pojo.StudentAttendanceInformationPojo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AttendanceStatisticSubjectActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    Map<String, String> params;
    EditText edt_search_by_name;
    TextView no_data;
    ListView listView;
    ArrayList<StudentAttendanceInformation> array_course_spinner;
    StudentAttendanceSubAdapter adapter;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;

    AppController appController;
    String currentAcademicYear;
    String error;
    String CourseId,BatchId;
    String Medium,SectionId;
    String EMPLOYEEID,ROLEID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_employee_course);

        final Typeface typeface_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-Regular.ttf");


        sharedpreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPLOYEEID = sharedpreferences.getString(getString(R.string.EMPLOYEEID), "0");
        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");

        apiInterface= ApiClient.getClient().create(APIInterface.class);
        Typeface font_icon = Typeface.createFromAsset(this.getAssets(), "fonts/fontawesome-webfont.ttf");
        linear_Search = (LinearLayout)findViewById(R.id.linear_Search);
        appController = (AppController)getApplicationContext();

        edt_search_by_name = (EditText)findViewById(R.id.edt_search_by_name);

        no_data = (TextView)findViewById(R.id.no_data);
        listView = (ListView)findViewById(R.id.listView_course_list);

        edt_search_by_name.setTypeface(typeface_semibold);
        no_data.setTypeface(typeface_semibold);
        getAdmissionYear();

        ImageView back_arrow=findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
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
                BatchId=appController.getAttendanceStstisticBatchId();
                Medium=appController.getAttendanceStstisticMedium();
                SectionId=appController.getAttendanceStstisticSectionName();
            }




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

                Call<StudentAttendanceInformationPojo> call = apiInterface.FillSubjectListForEmployee(entity_id, branch_id, currentAcademicYear, BatchId,
                        SectionId,CourseId,Medium,EMPLOYEEID,edt_search_by_name.getText().toString());
                call.enqueue(new Callback<StudentAttendanceInformationPojo>() {
                    @Override
                    public void onResponse(Call<StudentAttendanceInformationPojo> call, Response<StudentAttendanceInformationPojo> response) {
                        Log.e("Response  ", new Gson().toJson(response.body()));


                        StudentAttendanceInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getStudentAttendanceInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getStudentAttendanceInformation().size();

                            array_course_spinner = new ArrayList<StudentAttendanceInformation>();

                            for (int i = 1; i < Size; i++) {
                                StudentAttendanceInformation pojo = new StudentAttendanceInformation();

                                pojo.setSUBJECTID(pojoitem.getStudentAttendanceInformation().get(i).getSUBJECTID());
                                pojo.setSUBJECTNAME(pojoitem.getStudentAttendanceInformation().get(i).getSUBJECTNAME());


                                array_course_spinner.add(pojo);

                            }
                            adapter = new StudentAttendanceSubAdapter(AttendanceStatisticSubjectActivity.this, array_course_spinner);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);
                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getStudentAttendanceInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(AttendanceStatisticSubjectActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<StudentAttendanceInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    appController.setAttendanceStstisticSubId(array_course_spinner.get(position).getSUBJECTID().toString());
                    appController.setAttendanceStstisticSubName(array_course_spinner.get(position).getSUBJECTNAME());
                    finish();
//                }
            }
        });
    }




    private void getSubjectList() {
        if(error==null) {

            if (mProgressDialog == null)
                mProgressDialog = new TransparentProgressDialog(AttendanceStatisticSubjectActivity.this);
            if (mProgressDialog.isShowing())
                mProgressDialog.dismiss();
            //mProgressDialog = new TransparentProgressDialog(getActivity());
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
            String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
            String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");
Log.e("PAram ",BatchId + " ** "+SectionId + " ** "+CourseId + " ** "+Medium );

Call<StudentAttendanceInformationPojo> call = apiInterface.FillSubjectListForEmployee(entity_id, branch_id, currentAcademicYear, BatchId,
                    SectionId,CourseId,Medium,EMPLOYEEID,"");
            call.enqueue(new Callback<StudentAttendanceInformationPojo>() {
                @Override
                public void onResponse(Call<StudentAttendanceInformationPojo> call, Response<StudentAttendanceInformationPojo> response) {
                    Log.e("Response  ", new Gson().toJson(response.body()));


                    StudentAttendanceInformationPojo pojoitem = response.body();

                    String StatusCode = pojoitem.getStudentAttendanceInformation().get(0).getStatusCode();

                    mProgressDialog.dismiss();

                    if (StatusCode.equals("200")) {
                        no_data.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        int Size = pojoitem.getStudentAttendanceInformation().size();

                        array_course_spinner = new ArrayList<StudentAttendanceInformation>();

                        for (int i = 1; i < Size; i++) {
                            StudentAttendanceInformation pojo = new StudentAttendanceInformation();

                            pojo.setSUBJECTID(pojoitem.getStudentAttendanceInformation().get(i).getSUBJECTID());
                            pojo.setSUBJECTNAME(pojoitem.getStudentAttendanceInformation().get(i).getSUBJECTNAME());


                            array_course_spinner.add(pojo);

                        }
                        adapter = new StudentAttendanceSubAdapter(AttendanceStatisticSubjectActivity.this, array_course_spinner);
                        listView.setAdapter(adapter);


                    } else {
                        no_data.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                        linear_Search.setVisibility(View.GONE);

                        String DisplayMsg = pojoitem.getStudentAttendanceInformation().get(0).getDisplayMessage();
                        mProgressDialog.dismiss();
                        Toast.makeText(AttendanceStatisticSubjectActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<StudentAttendanceInformationPojo> call, Throwable t) {
                    mProgressDialog.dismiss();
                    Log.e("Failure ", t.getMessage());
                }
            });
        }else{
            Toast.makeText(AttendanceStatisticSubjectActivity.this, error, Toast.LENGTH_SHORT).show();
        }
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
                    getSubjectList();


                } else {

                    String DisplayMsg = pojoitem.getAdmissionYearInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(AttendanceStatisticSubjectActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AdmissionYearInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });

    }


}

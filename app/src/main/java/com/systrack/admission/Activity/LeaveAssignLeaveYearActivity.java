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
import com.systrack.admission.adapter.LeaveMgtAdapter.LeaveYearAdapter;
import com.systrack.admission.adapter.StudentAttendanceAdapter.StudentAttendanceSubAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.LeaveAssignInformation;
import com.systrack.admission.pojo.LeaveAssignInformationPojo;
import com.systrack.admission.pojo.LeaveAssignInformation;
import com.systrack.admission.pojo.LeaveAssignInformationPojo;
import com.systrack.admission.pojo.StudentAttendanceInformation;
import com.systrack.admission.pojo.LeaveAssignInformationPojo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LeaveAssignLeaveYearActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    Map<String, String> params;
    EditText edt_search_by_name;
    TextView no_data;
    ListView listView;
    ArrayList<LeaveAssignInformation> array_course_spinner;
    LeaveYearAdapter adapter;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;

    AppController appController;
    String currentAcademicYear;
    String error;
    String CourseId,BatchId;
    String Medium,SectionId;

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
        getSubjectList();

//        if(appController.getStuAttendanceSubFlag().equals("StudentAttendance")){
//            if(appController.getStuAttendanceStreamId()==null){
//                error="Please Select Course";
//            }else if(appController.getStuAttendanceMedium()==null){
//                error="Please Select Medium";
//            }else if(appController.getStuAttendanceBatchId()==null){
//                error="Please Select Batch";
//            }else if(appController.getStuAttendanceSectionName()==null){
//                error="Please Select Section";
//            }else{
//                CourseId=appController.getStuAttendanceStreamId();
//                BatchId=appController.getStuAttendanceBatchId();
//                Medium=appController.getStuAttendanceMedium();
//                SectionId=appController.getStuAttendanceSectionName();
//            }
//        }else  if(appController.getStuAttendanceSubFlag().equals("AttendanceStatistic")){
//            if(appController.getAttendanceStstisticStreamId()==null){
//                error="Please Select Course";
//            }else if(appController.getAttendanceStstisticMedium()==null){
//                error="Please Select Medium";
//            }else if(appController.getAttendanceStstisticBatchId()==null){
//                error="Please Select Batch";
//            }else if(appController.getAttendanceStstisticSectionName()==null){
//                error="Please Select Section";
//            }else{
//                CourseId=appController.getAttendanceStstisticStreamId();
//                BatchId=appController.getAttendanceStstisticBatchId();
//                Medium=appController.getAttendanceStstisticMedium();
//                SectionId=appController.getAttendanceStstisticSectionName();
//            }
//        }
//


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

                Call<LeaveAssignInformationPojo> call = apiInterface.FillLeaveDurationList(entity_id, branch_id,edt_search_by_name.getText().toString());
                call.enqueue(new Callback<LeaveAssignInformationPojo>() {
                    @Override
                    public void onResponse(Call<LeaveAssignInformationPojo> call, Response<LeaveAssignInformationPojo> response) {
                        Log.e("Response  ", new Gson().toJson(response.body()));


                        LeaveAssignInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getLeaveAssignInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getLeaveAssignInformation().size();

                            array_course_spinner = new ArrayList<LeaveAssignInformation>();

                            for (int i = 1; i < Size; i++) {
                                LeaveAssignInformation pojo = new LeaveAssignInformation();

                                pojo.setLEAVEDURATIONID(pojoitem.getLeaveAssignInformation().get(i).getLEAVEDURATIONID());
                                pojo.setDURATIONNAME(pojoitem.getLeaveAssignInformation().get(i).getDURATIONNAME());


                                array_course_spinner.add(pojo);

                            }
                            adapter = new LeaveYearAdapter(LeaveAssignLeaveYearActivity.this, array_course_spinner);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);
                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getLeaveAssignInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(LeaveAssignLeaveYearActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LeaveAssignInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(appController.getLeaveAssignLeaveYearFlag().equals("LeaveAssign")) {
                    appController.setLeaveAssignLeaveYearID(array_course_spinner.get(position).getLEAVEDURATIONID().toString());
                    appController.setLeaveAssignLeaveYearName(array_course_spinner.get(position).getDURATIONNAME());
                    finish();
                }else if(appController.getLeaveAssignLeaveYearFlag().equals("EmpLeaveReporting")) {
                    appController.setEmpLeaveReportingLeaveYearId(array_course_spinner.get(position).getLEAVEDURATIONID().toString());
                    appController.setEmpLeaveReportingLeaveYearName(array_course_spinner.get(position).getDURATIONNAME());
                    finish();
                }
            }
        });
    }




    private void getSubjectList() {

            if (mProgressDialog == null)
                mProgressDialog = new TransparentProgressDialog(LeaveAssignLeaveYearActivity.this);
            if (mProgressDialog.isShowing())
                mProgressDialog.dismiss();
            //mProgressDialog = new TransparentProgressDialog(getActivity());
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
            String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
            String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");

        Call<LeaveAssignInformationPojo> call = apiInterface.FillLeaveDurationList(entity_id, branch_id,"");
            call.enqueue(new Callback<LeaveAssignInformationPojo>() {
                @Override
                public void onResponse(Call<LeaveAssignInformationPojo> call, Response<LeaveAssignInformationPojo> response) {
                    Log.e("Response  ", new Gson().toJson(response.body()));


                    LeaveAssignInformationPojo pojoitem = response.body();

                    String StatusCode = pojoitem.getLeaveAssignInformation().get(0).getStatusCode();

                    mProgressDialog.dismiss();

                    if (StatusCode.equals("200")) {
                        no_data.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        int Size = pojoitem.getLeaveAssignInformation().size();

                        array_course_spinner = new ArrayList<LeaveAssignInformation>();

                        for (int i = 1; i < Size; i++) {
                            LeaveAssignInformation pojo = new LeaveAssignInformation();

                            pojo.setLEAVEDURATIONID(pojoitem.getLeaveAssignInformation().get(i).getLEAVEDURATIONID());
                            pojo.setDURATIONNAME(pojoitem.getLeaveAssignInformation().get(i).getDURATIONNAME());


                            array_course_spinner.add(pojo);

                        }

                        adapter = new LeaveYearAdapter(LeaveAssignLeaveYearActivity.this, array_course_spinner);
                        listView.setAdapter(adapter);


                    } else {
                        no_data.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                        linear_Search.setVisibility(View.GONE);

                        String DisplayMsg = pojoitem.getLeaveAssignInformation().get(0).getDisplayMessage();
                        mProgressDialog.dismiss();
                        Toast.makeText(LeaveAssignLeaveYearActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<LeaveAssignInformationPojo> call, Throwable t) {
                    mProgressDialog.dismiss();
                    Log.e("Failure ", t.getMessage());
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
                    getSubjectList();


                } else {

                    String DisplayMsg = pojoitem.getAdmissionYearInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(LeaveAssignLeaveYearActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
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

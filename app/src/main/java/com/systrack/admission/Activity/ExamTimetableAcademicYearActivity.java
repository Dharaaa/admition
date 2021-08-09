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
import com.systrack.admission.adapter.ExaminationAdapter.AcademicYearAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.ClassTimingBatchAdapter;
import com.systrack.admission.pojo.AcademicyearInformation;
import com.systrack.admission.pojo.AcademicyearInformationPojo;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.RoomCategoryInformation;
import com.systrack.admission.pojo.AcademicyearInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ExamTimetableAcademicYearActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    String currentAcademicYear;
    ArrayList<AcademicyearInformation> arrayList;
    AppController appController;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;


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

//        if(appController.getClassTimingBatchFlag().equals("ClassTiming")){
//           if(appController.getClassTimingStreamId()==null){
//               error="Please Select Course";
//           }else if(appController.getClassTimingMedium()==null){
//               error="Please Select Medium";
//            }else{
//               CourseId=appController.getClassTimingStreamId();
//               medium=appController.getClassTimingMedium();
//           }
//        }
        getYearList();
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


                Call<AcademicyearInformationPojo> call = apiInterface.FillAcademicyearList(entity_id,edt_search.getText().toString());
                call.enqueue(new Callback<AcademicyearInformationPojo>() {
                    @Override
                    public void onResponse(Call<AcademicyearInformationPojo> call, Response<AcademicyearInformationPojo> response) {
                        Log.e("Response batch ", new Gson().toJson(response.body()));


                        AcademicyearInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getAcademicyearInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getAcademicyearInformation().size();

                            arrayList = new ArrayList<AcademicyearInformation>();

                            for (int i = 1; i < Size; i++) {
                                AcademicyearInformation pojo = new AcademicyearInformation();

                                pojo.setYEAR(pojoitem.getAcademicyearInformation().get(i).getYEAR());
                                pojo.setCOMBINEYEAR(pojoitem.getAcademicyearInformation().get(i).getCOMBINEYEAR());


                                arrayList.add(pojo);

                            }
                            AcademicYearAdapter adapter = new AcademicYearAdapter(ExamTimetableAcademicYearActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);

                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getAcademicyearInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(ExamTimetableAcademicYearActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<AcademicyearInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });

                 }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(appController.getExamTimetableYearFlag().equals("ExamTimeTable")){
                appController.setExamTimeTableYearId(String.valueOf(arrayList.get(position).getYEAR()));
                appController.setExamTimeTableYearName(arrayList.get(position).getCOMBINEYEAR());
                finish();
                }else if(appController.getExamTimetableYearFlag().equals("HallArrangement")){
                    appController.setHall_arrangement_yearId(String.valueOf(arrayList.get(position).getYEAR()));
                    appController.setHall_arrangement_yearName(arrayList.get(position).getCOMBINEYEAR());
                    finish();
                }else if(appController.getExamTimetableYearFlag().equals("StudentList")){
                    appController.setStudent_list_year_id(String.valueOf(arrayList.get(position).getYEAR()));
                    appController.setStudent_list_yearName(arrayList.get(position).getCOMBINEYEAR());
                    finish();
                }else if(appController.getExamTimetableYearFlag().equals("ModeratorAffiliation")){
                    appController.setModerator_affiliation_yearId(String.valueOf(arrayList.get(position).getYEAR()));
                    appController.setModerator_affiliation_yearName(arrayList.get(position).getCOMBINEYEAR());
                    finish();
                }else if(appController.getExamTimetableYearFlag().equals("TeacherAllocation")){
                    appController.setTeacher_allocation_yearId(String.valueOf(arrayList.get(position).getYEAR()));
                    appController.setTeacher_allocation_yearName(arrayList.get(position).getCOMBINEYEAR());
                    finish();
                }else if(appController.getExamTimetableYearFlag().equals("SubjectAllocation")){
                    appController.setSubject_allocation_yearId(String.valueOf(arrayList.get(position).getYEAR()));
                    appController.setSubject_allocation_yearName(arrayList.get(position).getCOMBINEYEAR());
                    finish();
                }else if(appController.getExamTimetableYearFlag().equals("ManageStudent")){
                    appController.setManage_student_yearID(String.valueOf(arrayList.get(position).getYEAR()));
                    appController.setManage_student_yearName(arrayList.get(position).getCOMBINEYEAR());
                    finish();
                }else if(appController.getExamTimetableYearFlag().equals("Assignment")){
                    appController.setAssignment_yearId(String.valueOf(arrayList.get(position).getYEAR()));
                    appController.setAssignment_yearName(arrayList.get(position).getCOMBINEYEAR());
                    finish();
                }




            }
        });


    }




    private void getYearList() {


    if (mProgressDialog == null)
        mProgressDialog = new TransparentProgressDialog(ExamTimetableAcademicYearActivity.this);
    if (mProgressDialog.isShowing())
        mProgressDialog.dismiss();
    //mProgressDialog = new TransparentProgressDialog(getActivity());
    mProgressDialog.setCancelable(false);
    mProgressDialog.show();

    String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
    String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


    Call<AcademicyearInformationPojo> call = apiInterface.FillAcademicyearList(entity_id,"");
    call.enqueue(new Callback<AcademicyearInformationPojo>() {
        @Override
        public void onResponse(Call<AcademicyearInformationPojo> call, Response<AcademicyearInformationPojo> response) {
            Log.e("Response batch ", new Gson().toJson(response.body()));


            AcademicyearInformationPojo pojoitem = response.body();

            String StatusCode = pojoitem.getAcademicyearInformation().get(0).getStatusCode();

            mProgressDialog.dismiss();

            if (StatusCode.equals("200")) {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                int Size = pojoitem.getAcademicyearInformation().size();

                arrayList = new ArrayList<AcademicyearInformation>();

                for (int i = 1; i < Size; i++) {
                    AcademicyearInformation pojo = new AcademicyearInformation();

                    pojo.setYEAR(pojoitem.getAcademicyearInformation().get(i).getYEAR());
                    pojo.setCOMBINEYEAR(pojoitem.getAcademicyearInformation().get(i).getCOMBINEYEAR());


                    arrayList.add(pojo);

                }
                AcademicYearAdapter adapter = new AcademicYearAdapter(ExamTimetableAcademicYearActivity.this, arrayList);
                listView.setAdapter(adapter);


            } else {
                no_data.setVisibility(View.VISIBLE);

                listView.setVisibility(View.GONE);
                linear_Search.setVisibility(View.GONE);

                String DisplayMsg = pojoitem.getAcademicyearInformation().get(0).getDisplayMessage();
                mProgressDialog.dismiss();
                Toast.makeText(ExamTimetableAcademicYearActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<AcademicyearInformationPojo> call, Throwable t) {
            mProgressDialog.dismiss();
            Log.e("Failure ", t.getMessage());
        }
    });
}

    }








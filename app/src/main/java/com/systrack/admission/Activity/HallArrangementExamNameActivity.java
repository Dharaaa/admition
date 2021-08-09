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
import com.systrack.admission.adapter.ExaminationAdapter.ExamNameAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.ClassTimingBatchAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.HallArrangementStudentInformation;
import com.systrack.admission.pojo.HallArrangementStudentInformationPojo;
import com.systrack.admission.pojo.RoomCategoryInformation;
import com.systrack.admission.pojo.HallArrangementStudentInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HallArrangementExamNameActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    String currentAcademicYear;
    ArrayList<HallArrangementStudentInformation> arrayList;
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


        getExamNameList();
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


                Call<HallArrangementStudentInformationPojo> call = apiInterface.FillExamNameList(entity_id, branch_id,edt_search.getText().toString());
                call.enqueue(new Callback<HallArrangementStudentInformationPojo>() {
                    @Override
                    public void onResponse(Call<HallArrangementStudentInformationPojo> call, Response<HallArrangementStudentInformationPojo> response) {
                        Log.e("Response batch ", new Gson().toJson(response.body()));


                        HallArrangementStudentInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getHallArrangementStudentInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getHallArrangementStudentInformation().size();

                            arrayList = new ArrayList<HallArrangementStudentInformation>();

                            for (int i = 1; i < Size; i++) {
                                HallArrangementStudentInformation pojo = new HallArrangementStudentInformation();

                                pojo.setINTERNALEXAMID(pojoitem.getHallArrangementStudentInformation().get(i).getINTERNALEXAMID());
                                pojo.setEXAMNAME(pojoitem.getHallArrangementStudentInformation().get(i).getEXAMNAME());


                                arrayList.add(pojo);

                            }
                            ExamNameAdapter adapter = new ExamNameAdapter(HallArrangementExamNameActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);

                            listView.setVisibility(View.GONE);
                            linear_Search.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getHallArrangementStudentInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(HallArrangementExamNameActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<HallArrangementStudentInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 if(appController.getHallArrangementExamNameFlag().equals("HallArrangement")){
                    appController.setHall_arrangement_examId(String.valueOf(arrayList.get(position).getINTERNALEXAMID()));
                    appController.setHall_arrangement_examName(arrayList.get(position).getEXAMNAME());

                    finish();
                } if(appController.getHallArrangementExamNameFlag().equals("StudentList")){
                    appController.setStudent_list_examId(String.valueOf(arrayList.get(position).getINTERNALEXAMID()));
                    appController.setStudent_list_examName(arrayList.get(position).getEXAMNAME());

                    finish();
                }
            }
        });


    }




    private void getExamNameList() {

if(error!=null) {
    Toast.makeText(HallArrangementExamNameActivity.this, error, Toast.LENGTH_SHORT).show();
}else{

    if (mProgressDialog == null)
        mProgressDialog = new TransparentProgressDialog(HallArrangementExamNameActivity.this);
    if (mProgressDialog.isShowing())
        mProgressDialog.dismiss();
    //mProgressDialog = new TransparentProgressDialog(getActivity());
    mProgressDialog.setCancelable(false);
    mProgressDialog.show();

    String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
    String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


    Call<HallArrangementStudentInformationPojo> call = apiInterface.FillExamNameList(entity_id, branch_id,"");
    call.enqueue(new Callback<HallArrangementStudentInformationPojo>() {
        @Override
        public void onResponse(Call<HallArrangementStudentInformationPojo> call, Response<HallArrangementStudentInformationPojo> response) {
            Log.e("Response batch ", new Gson().toJson(response.body()));


            HallArrangementStudentInformationPojo pojoitem = response.body();

            String StatusCode = pojoitem.getHallArrangementStudentInformation().get(0).getStatusCode();

            mProgressDialog.dismiss();

            if (StatusCode.equals("200")) {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                int Size = pojoitem.getHallArrangementStudentInformation().size();

                arrayList = new ArrayList<HallArrangementStudentInformation>();

                for (int i = 1; i < Size; i++) {
                    HallArrangementStudentInformation pojo = new HallArrangementStudentInformation();

                    pojo.setINTERNALEXAMID(pojoitem.getHallArrangementStudentInformation().get(i).getINTERNALEXAMID());
                    pojo.setEXAMNAME(pojoitem.getHallArrangementStudentInformation().get(i).getEXAMNAME());


                    arrayList.add(pojo);

                }
                ExamNameAdapter adapter = new ExamNameAdapter(HallArrangementExamNameActivity.this, arrayList);
                listView.setAdapter(adapter);


            } else {
                no_data.setVisibility(View.VISIBLE);

                listView.setVisibility(View.GONE);
                linear_Search.setVisibility(View.GONE);

                String DisplayMsg = pojoitem.getHallArrangementStudentInformation().get(0).getDisplayMessage();
                mProgressDialog.dismiss();
                Toast.makeText(HallArrangementExamNameActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<HallArrangementStudentInformationPojo> call, Throwable t) {
            mProgressDialog.dismiss();
            Log.e("Failure ", t.getMessage());
        }
    });
}

    }






}


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
import com.systrack.admission.adapter.CourseMgtAdapter.EmployeeListAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.ClassTimingBatchAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.EmployeeInformation;
import com.systrack.admission.pojo.EmployeeInformationPojo;
import com.systrack.admission.pojo.RoomCategoryInformation;
import com.systrack.admission.pojo.RoomCategoryInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SubjectAllocationEmployeeListActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    ArrayList<EmployeeInformation> arrayList;
    AppController appController;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;
    String CourseId,medium,error,SectionId,BatchId;


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
           if(appController.getSubject_allocation_streamID()==null){
               error="Please Select Course";
           }else if(appController.getSubject_allocation_medium()==null){
               error="Please Select Medium";
            }else if(appController.getSubject_allocation_batchId()==null){
            error="Please Select Batch";
        }else if(appController.getSubject_allocation_sectionName()==null){
               error="Please Select Semester/Year";
           }else{
               CourseId=appController.getSubject_allocation_streamID();
               medium=appController.getSubject_allocation_medium();
               SectionId=appController.getSubject_allocation_sectionName();
               BatchId=appController.getSubject_allocation_batchId();
           }
//        }

        getEmpList();


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




                Call<EmployeeInformationPojo> call = apiInterface.FillEmployeeList(entity_id, branch_id,appController.getCurrentAcademicYear(),
                        BatchId,SectionId,medium,CourseId,edt_search.getText().toString());
                call.enqueue(new Callback<EmployeeInformationPojo>() {
                    @Override
                    public void onResponse(Call<EmployeeInformationPojo> call, Response<EmployeeInformationPojo> response) {
                        Log.e("Response batch ", new Gson().toJson(response.body()));


                        EmployeeInformationPojo pojoitem = response.body();

                        String StatusCode = pojoitem.getEmployeeInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getEmployeeInformation().size();

                            arrayList = new ArrayList<EmployeeInformation>();

                            for (int i = 1; i < Size; i++) {
                                EmployeeInformation pojo = new EmployeeInformation();

                                pojo.setEMPLOYEEID(pojoitem.getEmployeeInformation().get(i).getEMPLOYEEID());
                                pojo.setFULLNAME(pojoitem.getEmployeeInformation().get(i).getFULLNAME());


                                arrayList.add(pojo);

                            }
                            EmployeeListAdapter adapter = new EmployeeListAdapter(SubjectAllocationEmployeeListActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);

                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(SubjectAllocationEmployeeListActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<EmployeeInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                if(appController.getClassTimingBatchFlag().equals("ClassTiming")){
                appController.setSubject_allocation_empId(String.valueOf(arrayList.get(position).getEMPLOYEEID()));
                appController.setSubject_allocation_empName(arrayList.get(position).getFULLNAME());

                finish();
//                }

            }
        });


    }




    private void getEmpList() {

if(error!=null) {
    Toast.makeText(SubjectAllocationEmployeeListActivity.this, error, Toast.LENGTH_SHORT).show();
}else{

    if (mProgressDialog == null)
        mProgressDialog = new TransparentProgressDialog(SubjectAllocationEmployeeListActivity.this);
    if (mProgressDialog.isShowing())
        mProgressDialog.dismiss();
    //mProgressDialog = new TransparentProgressDialog(getActivity());
    mProgressDialog.setCancelable(false);
    mProgressDialog.show();

    String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
    String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


    Call<EmployeeInformationPojo> call = apiInterface.FillEmployeeList(entity_id, branch_id,appController.getCurrentAcademicYear(),
            BatchId,SectionId,medium,CourseId,"");
    call.enqueue(new Callback<EmployeeInformationPojo>() {
        @Override
        public void onResponse(Call<EmployeeInformationPojo> call, Response<EmployeeInformationPojo> response) {
            Log.e("Response batch ", new Gson().toJson(response.body()));


            EmployeeInformationPojo pojoitem = response.body();

            String StatusCode = pojoitem.getEmployeeInformation().get(0).getStatusCode();

            mProgressDialog.dismiss();

            if (StatusCode.equals("200")) {
                no_data.setVisibility(View.GONE);
                listView.setVisibility(View.VISIBLE);
                int Size = pojoitem.getEmployeeInformation().size();

                arrayList = new ArrayList<EmployeeInformation>();

                for (int i = 1; i < Size; i++) {
                    EmployeeInformation pojo = new EmployeeInformation();

                    pojo.setEMPLOYEEID(pojoitem.getEmployeeInformation().get(i).getEMPLOYEEID());
                    pojo.setFULLNAME(pojoitem.getEmployeeInformation().get(i).getFULLNAME());


                    arrayList.add(pojo);

                }
                EmployeeListAdapter adapter = new EmployeeListAdapter(SubjectAllocationEmployeeListActivity.this, arrayList);
                listView.setAdapter(adapter);


            } else {
                no_data.setVisibility(View.VISIBLE);

                listView.setVisibility(View.GONE);
                linear_Search.setVisibility(View.GONE);

                String DisplayMsg = pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                mProgressDialog.dismiss();
                Toast.makeText(SubjectAllocationEmployeeListActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onFailure(Call<EmployeeInformationPojo> call, Throwable t) {
            mProgressDialog.dismiss();
            Log.e("Failure ", t.getMessage());
        }
    });
}

    }






}


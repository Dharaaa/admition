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
import com.systrack.admission.adapter.hrAdapter.ManageEmployeeDepartmentAdapter;
import com.systrack.admission.adapter.hrAdapter.ManageEmployeeMediumAdapter;
import com.systrack.admission.pojo.ManageEmployeeCourseInformation;
import com.systrack.admission.pojo.ManageEmployeeCoursePojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ManageEmployeeDepartmentActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    EditText edt_search;
    TextView no_data;
    ListView listView;
    String current_academicID,current_academicName;
    ArrayList<ManageEmployeeCourseInformation> arrayList;
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
        getDepartmentList();




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


                Call<ManageEmployeeCoursePojo> call = apiInterface.FillDepartmentList(entity_id,branch_id,edt_search.getText().toString());
                call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
                    @Override
                    public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                        Log.e("Response  ", new Gson().toJson(response.body()));


                        ManageEmployeeCoursePojo pojoitem = response.body();

                        String StatusCode = pojoitem.getEmployeeInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if (StatusCode.equals("200")) {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getEmployeeInformation().size();

                            arrayList = new ArrayList<ManageEmployeeCourseInformation>();

                            for (int i = 1; i < Size; i++) {
                                ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                                pojo.setdEPARTMENTID(pojoitem.getEmployeeInformation().get(i).getdEPARTMENTID());
                                pojo.setdEPARTMENTNAME(pojoitem.getEmployeeInformation().get(i).getdEPARTMENTNAME());


                                arrayList.add(pojo);


                            }
                            if(appController.getManageEmpDepartmentFlag().equals("ManageAttendance")){
                                ManageEmployeeCourseInformation pojo1 = new ManageEmployeeCourseInformation();

                                pojo1.setdEPARTMENTID(0);
                                pojo1.setdEPARTMENTNAME("All");


                                arrayList.add(0,pojo1);


                            }

                            ManageEmployeeDepartmentAdapter adapter = new ManageEmployeeDepartmentAdapter(ManageEmployeeDepartmentActivity.this, arrayList);
                            listView.setAdapter(adapter);


                        } else {
                            no_data.setVisibility(View.VISIBLE);
                            listView.setVisibility(View.GONE);

                            String DisplayMsg = pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(ManageEmployeeDepartmentActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ", t.getMessage());
                    }
                });



            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(appController.getManageEmpDepartmentFlag().equals("ManageEmployee"))
                { appController.setManageEmpDepartmentId(String.valueOf(arrayList.get(position).getdEPARTMENTID()));
                    appController.setManageEmpDepartmentName(arrayList.get(position).getdEPARTMENTNAME().toString());
                }else if(appController.getManageEmpDepartmentFlag().equals("LeaveReporting"))
                { appController.setLeaveReportingDepartmentId(String.valueOf(arrayList.get(position).getdEPARTMENTID()));
                    appController.setLeaveReportingDepartmentName(arrayList.get(position).getdEPARTMENTNAME().toString());
                }else if(appController.getManageEmpDepartmentFlag().equals("LeaveAssign"))
                { appController.setLeaveAssignDepartmentId(String.valueOf(arrayList.get(position).getdEPARTMENTID()));
                    appController.setLeaveAssignDepartmentName(arrayList.get(position).getdEPARTMENTNAME().toString());
                }else if(appController.getManageEmpDepartmentFlag().equals("ManageAttendance"))
                { appController.setManageAttendanceDepartmetId(String.valueOf(arrayList.get(position).getdEPARTMENTID()));
                    appController.setManageAttendanceDepartmentName(arrayList.get(position).getdEPARTMENTNAME().toString());
                }else if(appController.getManageEmpDepartmentFlag().equals("EmployeeContact"))
                { appController.setEmployeeContactDepartmentId(String.valueOf(arrayList.get(position).getdEPARTMENTID()));
                    appController.setEmployeeContactDepartmentName(arrayList.get(position).getdEPARTMENTNAME().toString());
                }


                finish();
            }
        });


    }




    private void getDepartmentList() {


            if (mProgressDialog == null)
                mProgressDialog = new TransparentProgressDialog(ManageEmployeeDepartmentActivity.this);
            if (mProgressDialog.isShowing())
                mProgressDialog.dismiss();
            //mProgressDialog = new TransparentProgressDialog(getActivity());
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
            String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
            String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


            Call<ManageEmployeeCoursePojo> call = apiInterface.FillDepartmentList(entity_id,branch_id,"");
            call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
                @Override
                public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                    Log.e("Response  ", new Gson().toJson(response.body()));


                    ManageEmployeeCoursePojo pojoitem = response.body();

                    String StatusCode = pojoitem.getEmployeeInformation().get(0).getStatusCode();

                    mProgressDialog.dismiss();

                    if (StatusCode.equals("200")) {
                        no_data.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        int Size = pojoitem.getEmployeeInformation().size();

                        arrayList = new ArrayList<ManageEmployeeCourseInformation>();

                        for (int i = 1; i < Size; i++) {
                            ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                            pojo.setdEPARTMENTID(pojoitem.getEmployeeInformation().get(i).getdEPARTMENTID());
                            pojo.setdEPARTMENTNAME(pojoitem.getEmployeeInformation().get(i).getdEPARTMENTNAME());


                            arrayList.add(pojo);

                        }
                        if(appController.getManageEmpDepartmentFlag().equals("ManageAttendance")){
                            ManageEmployeeCourseInformation pojo1 = new ManageEmployeeCourseInformation();

                            pojo1.setdEPARTMENTID(0);
                            pojo1.setdEPARTMENTNAME("All");


                            arrayList.add(0,pojo1);


                        }

                        ManageEmployeeDepartmentAdapter adapter = new ManageEmployeeDepartmentAdapter(ManageEmployeeDepartmentActivity.this, arrayList);
                        listView.setAdapter(adapter);


                    } else {
                        no_data.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                        linear_Search.setVisibility(View.GONE);

                        String DisplayMsg = pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                        mProgressDialog.dismiss();
                        Toast.makeText(ManageEmployeeDepartmentActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
                    mProgressDialog.dismiss();
                    Log.e("Failure ", t.getMessage());
                }
            });

    }






}


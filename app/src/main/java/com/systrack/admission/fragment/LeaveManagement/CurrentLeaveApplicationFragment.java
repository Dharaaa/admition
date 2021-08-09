package com.systrack.admission.fragment.LeaveManagement;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.LeaveMgtAdapter.CurrentLeaveApplicationAdapter;
import com.systrack.admission.adapter.LeaveMgtAdapter.LeaveApplicationAdapter;
import com.systrack.admission.pojo.LeaveApplicationInformationPojo;
import com.systrack.admission.pojo.LeaveApplicationInformationPojo;
import com.systrack.admission.pojo.LeaveApplicationInformation;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentLeaveApplicationFragment extends Fragment {


    View view;
    EditText date_range;
    AppController appController;
    TextView error;
    ImageView back_arrow;
    DatePickerDialog picker;
    ListView listView;
    TextView no_data;
    TransparentProgressDialog mProgressDialog;
    SharedPreferences sharedpreferences;
    APIInterface apiInterface;
    String EMPLOYEEID,ROLEID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_current_application, container, false);
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPLOYEEID = sharedpreferences.getString(getString(R.string.EMPLOYEEID), "0");
        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");
listView=view.findViewById(R.id.listView);
no_data=view.findViewById(R.id.no_data);
        appController.setCurrent_Leave_Application_ToDate(null);
        appController.setCurrent_Leave_Application_FromDate(null);
        ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LeaveMgtMenuFragment coursefragment = new LeaveMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });
        appController.setCustomMonthText("null");
        appController.setDayofMonthCustom("null");

        date_range=view.findViewById(R.id.date_range);
        date_range.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);


                // date picker dialog
                picker = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, final int year, int monthOfYear, int dayOfMonth) {

                                int month = monthOfYear + 1;
                                String formattedMonth = "" + month;
                                String formattedDayOfMonth = "" + dayOfMonth;
                                if(month < 10){

                                    formattedMonth = "0" + month;
                                }
                                if(dayOfMonth < 10){

                                    formattedDayOfMonth = "0" + dayOfMonth;
                                }

                                final String finalFormattedMonth = formattedMonth;
                                final String finalFormattedDayOfMonth = formattedDayOfMonth;

                                if(finalFormattedMonth.equals("01")){
                                    appController.setCustomMonthText("January");
                                    appController.setDayofMonthCustom("31");
                                }else if(finalFormattedMonth.equals("02")){
                                    appController.setCustomMonthText("February");
                                    if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
                                        appController.setDayofMonthCustom("29");
                                    }else{
                                        appController.setDayofMonthCustom("28");
                                        appController.setDayofMonthCustom("28");

                                    }
                                }
                                else if(finalFormattedMonth.equals("03")){
                                    appController.setCustomMonthText("March");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("04")){
                                    appController.setCustomMonthText("April");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("05")){
                                    appController.setCustomMonthText("May");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("06")){
                                    appController.setCustomMonthText("June");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("07")){
                                    appController.setCustomMonthText("July");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("08")){
                                    appController.setCustomMonthText("August");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("09")){
                                    appController.setCustomMonthText("September");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("10")){
                                    appController.setCustomMonthText("October");
                                    appController.setDayofMonthCustom("31");

                                }else if(finalFormattedMonth.equals("11")){
                                    appController.setCustomMonthText("November");
                                    appController.setDayofMonthCustom("30");

                                }else if(finalFormattedMonth.equals("12")){
                                    appController.setCustomMonthText("December");
                                    appController.setDayofMonthCustom("31");

                                }

                                date_range.setText(appController.getCustomMonthText() + " " + "01," + year + " - " +appController.getCustomMonthText()+  " " +appController.getDayofMonthCustom() + "," + year);


                                Log.e("month",finalFormattedMonth);
                                Log.e("EndDay",appController.getDayofMonthCustom());
                                Log.e("year", String.valueOf(year));


                                appController.setCurrent_Leave_Application_FromDate(finalFormattedMonth + "/" + "01" + "/" + year);
                                appController.setCurrent_Leave_Application_ToDate(finalFormattedMonth + "/" + appController.getDayofMonthCustom() + "/" + year);
getCurrentLeaveDurationID();
//                                appController.setLeaveApplicationDateRange(String.valueOf(date_range.getText()));

                            }
                        }, year, month, day);
                picker.show();


            }
        });

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.e("OnREsume ","Calles ");


    }

    private void getCurrentLeaveDurationID() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
        String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");

Log.e("fromdate ",appController.getCurrent_Leave_Application_FromDate());
        Log.e("todate ",appController.getCurrent_Leave_Application_ToDate());

        Call<LeaveApplicationInformationPojo> call = apiInterface.GetLeaveApplicationListForEmployeeCurrent(entity_id,branch_id,EMPLOYEEID,"0",appController.getCurrent_Leave_Application_FromDate(),
                appController.getCurrent_Leave_Application_ToDate());
        call.enqueue(new Callback<LeaveApplicationInformationPojo>() {
            @Override
            public void onResponse(Call<LeaveApplicationInformationPojo> call, Response<LeaveApplicationInformationPojo> response) {
                Log.e("Response  ", new Gson().toJson(response.body()));


                LeaveApplicationInformationPojo pojoitem = response.body();

                String StatusCode = pojoitem.getLeaveApplicationInformation().get(0).getStatusCode();
mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getLeaveApplicationInformation().size();

                   ArrayList<LeaveApplicationInformation> arrayList = new ArrayList<LeaveApplicationInformation>();

                    for(int i =1; i<Size; i++){
                        LeaveApplicationInformation pojo = new LeaveApplicationInformation();

                        pojo.setLEAVEDATE(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEDATE());
                        pojo.setDURATIONNAME(pojoitem.getLeaveApplicationInformation().get(i).getDURATIONNAME());
                        pojo.setLEAVETYPENAME(pojoitem.getLeaveApplicationInformation().get(i).getLEAVETYPENAME());
                        pojo.setLEAVESTARTDATE(pojoitem.getLeaveApplicationInformation().get(i).getLEAVESTARTDATE());
                        pojo.setLEAVEENDDATE(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEENDDATE());
                        pojo.setLEAVEDAYS(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEDAYS());
                        pojo.setSTATUS(pojoitem.getLeaveApplicationInformation().get(i).getSTATUS());
                        pojo.setREMARKS(pojoitem.getLeaveApplicationInformation().get(i).getREMARKS());
                        pojo.setREASON(pojoitem.getLeaveApplicationInformation().get(i).getREASON());
                        pojo.setLEAVEDURATIONID(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEDURATIONID());
                        pojo.setLEAVEAPPID(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEAPPID());
                        pojo.setLEAVESTATUS(pojoitem.getLeaveApplicationInformation().get(i).getLEAVESTATUS());


                        arrayList.add(pojo);

                    }
                 CurrentLeaveApplicationAdapter adapter = new CurrentLeaveApplicationAdapter(getActivity(),arrayList);
                    listView.setAdapter(adapter);



                   


                } else {

                    String DisplayMsg = pojoitem.getLeaveApplicationInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getContext(), DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LeaveApplicationInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });

    }


}

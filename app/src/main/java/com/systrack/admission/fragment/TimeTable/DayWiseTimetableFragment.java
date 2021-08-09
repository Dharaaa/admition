package com.systrack.admission.fragment.TimeTable;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.AttendanceMgtAdapter.MonthlyAttendanceAdapter;
import com.systrack.admission.adapter.CourseMgtAdapter.SubjectAllocationAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.DayOfWeekAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.DayWiseTimeTableAdapter;
import com.systrack.admission.pojo.EmployeeAttendanceInformation;
import com.systrack.admission.pojo.EmployeeAttendanceInformationPojo;
import com.systrack.admission.pojo.SubjectAllocationInformation;
import com.systrack.admission.pojo.SubjectAllocationInformationPojo;
import com.systrack.admission.pojo.TimeTableInformation;
import com.systrack.admission.pojo.TimeTableInformationPojo;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayWiseTimetableFragment extends Fragment {


    View view;
    AppController appController;
    TextView no_data;
    ImageView back_arrow;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;
    SharedPreferences sharedpreferences;
ListView listView;
String EMPLOYEEID;
Spinner days_week;
CardView searchview;
LinearLayout search_day_wise;
FloatingActionButton search;
ListView list_lecture;
EditText search_text;
ImageView close;
    ArrayList<TimeTableInformation> arrayList;
    DayOfWeekAdapter dayOfWeekAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_day_wise, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        apiInterface= ApiClient.getClient().create(APIInterface.class);

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPLOYEEID = sharedpreferences.getString(getString(R.string.EMPLOYEEID), "0");


        days_week=view.findViewById(R.id.days_week);
        searchview =  view.findViewById(R.id.searchview);
        search = (FloatingActionButton) view.findViewById(R.id.fab_search);
        search_day_wise = (LinearLayout)view.findViewById(R.id.search_day_wise);
        list_lecture = (ListView)view.findViewById(R.id.list_lecture);

        search_day_wise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchGetDayWiseList();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchview.setVisibility(View.VISIBLE);
            }
        });
        search_text = (EditText)view.findViewById(R.id.search_text);
        close = (ImageView)view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchview.setVisibility(View.GONE);
                search_text.setText("");
            }
        });
        getWeekDays();
        no_data = (TextView) view.findViewById(R.id.no_data);
        days_week.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                appController.setMyTimeTableDayWiseSpinnerId(arrayList.get(position).getDAYID());
                appController.setMyTimeTableDayWiseSpinnerName(arrayList.get(position).getDAYNAME());

                appController.setTimeTable_WEEKDAY(arrayList.get(position).getDAYNAME());

                SearchGetDayWiseList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        search_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
                String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");


                Call<TimeTableInformationPojo> call=apiInterface.GetTimeTableDayWiseForEmployee(entity_id,branch_id,EMPLOYEEID,appController.getTimeTable_WEEKDAY(),
                        appController.getCurrentAcademicYear(),search_text.getText().toString());

                call.enqueue(new Callback<TimeTableInformationPojo>() {
                    @Override
                    public void onResponse(Call<TimeTableInformationPojo> call, Response<TimeTableInformationPojo> response) {
                        Log.e("Response  search ",new Gson().toJson(response.body()));



                        TimeTableInformationPojo pojoitem=response.body();

                        String StatusCode=pojoitem.getTimeTableInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if(StatusCode.equals("200"))
                        {
                            no_data.setVisibility(View.GONE);
                            list_lecture.setVisibility(View.VISIBLE);
                            int Size = pojoitem.getTimeTableInformation().size();

                            ArrayList<TimeTableInformation>    arrayList = new ArrayList<TimeTableInformation>();

                            for(int i =1; i<Size; i++){
                                TimeTableInformation pojo = new TimeTableInformation();

                                pojo.setCLASSTIME(pojoitem.getTimeTableInformation().get(i).getCLASSTIME());
                                pojo.setBATCHNAME(pojoitem.getTimeTableInformation().get(i).getBATCHNAME());
                                pojo.setSECTIONID(pojoitem.getTimeTableInformation().get(i).getSECTIONID());
                                pojo.setSUBJECTNAME(pojoitem.getTimeTableInformation().get(i).getSUBJECTNAME());
                                pojo.setEMPROOMLABTYPE(pojoitem.getTimeTableInformation().get(i).getEMPROOMLABTYPE());
                                pojo.setDIVISIONNAME(pojoitem.getTimeTableInformation().get(i).getDIVISIONNAME());
                                pojo.setSTARTTIME(pojoitem.getTimeTableInformation().get(i).getSTARTTIME());
                                pojo.setENDTIME(pojoitem.getTimeTableInformation().get(i).getENDTIME());
                                pojo.setCLASSTIMING(pojoitem.getTimeTableInformation().get(i).getCLASSTIMING());


                                arrayList.add(pojo);

                            }

                            DayWiseTimeTableAdapter categoryAdapter = new DayWiseTimeTableAdapter(getActivity(),arrayList);
                            list_lecture.setAdapter(categoryAdapter);






                        }else
                        {
                            no_data.setVisibility(View.VISIBLE);
                            list_lecture.setVisibility(View.GONE);

                            String DisplayMsg=pojoitem.getTimeTableInformation().get(0).getDisplayMessage();
                            mProgressDialog.dismiss();
                            Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<TimeTableInformationPojo> call, Throwable t) {
                        mProgressDialog.dismiss();
                        Log.e("Failure ",t.getMessage());
                    }
                });
            }
        });





                return view;
    }
    private void getWeekDays() {

//        if (mProgressDialog == null)
//            mProgressDialog = new TransparentProgressDialog(getActivity());
//        if (mProgressDialog.isShowing())
//            mProgressDialog.dismiss();
//        //mProgressDialog = new TransparentProgressDialog(getActivity());
//        mProgressDialog.setCancelable(false);
//        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");


        Call<TimeTableInformationPojo> call=apiInterface.FillWeekDays();

        call.enqueue(new Callback<TimeTableInformationPojo>() {
            @Override
            public void onResponse(Call<TimeTableInformationPojo> call, Response<TimeTableInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                TimeTableInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getTimeTableInformation().get(0).getStatusCode();


                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    list_lecture.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getTimeTableInformation().size();

                  arrayList = new ArrayList<TimeTableInformation>();

                    for(int i =1; i<Size; i++){
                        TimeTableInformation pojo = new TimeTableInformation();

                        pojo.setDAYID(pojoitem.getTimeTableInformation().get(i).getDAYID());
                        pojo.setDAYNAME(pojoitem.getTimeTableInformation().get(i).getDAYNAME());

                        arrayList.add(pojo);

                    }

                    appController.setTimeTable_WEEKDAY(pojoitem.getTimeTableInformation().get(0).getDAYNAME());

                    dayOfWeekAdapter  = new DayOfWeekAdapter(getActivity(),arrayList);
                    days_week.setAdapter(dayOfWeekAdapter);





                }else
                {

                    String DisplayMsg=pojoitem.getTimeTableInformation().get(0).getDisplayMessage();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<TimeTableInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }

    private void SearchGetDayWiseList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");


        Call<TimeTableInformationPojo> call=apiInterface.GetTimeTableDayWiseForEmployee(entity_id,branch_id,EMPLOYEEID,appController.getTimeTable_WEEKDAY(),
                appController.getCurrentAcademicYear(),"");

        call.enqueue(new Callback<TimeTableInformationPojo>() {
            @Override
            public void onResponse(Call<TimeTableInformationPojo> call, Response<TimeTableInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                TimeTableInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getTimeTableInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    list_lecture.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getTimeTableInformation().size();

                ArrayList<TimeTableInformation>    arrayList = new ArrayList<TimeTableInformation>();

                    for(int i =1; i<Size; i++){
                        TimeTableInformation pojo = new TimeTableInformation();

                        pojo.setBATCHNAME(pojoitem.getTimeTableInformation().get(i).getBATCHNAME());
                        pojo.setSECTIONID(pojoitem.getTimeTableInformation().get(i).getSECTIONID());
                        pojo.setSUBJECTNAME(pojoitem.getTimeTableInformation().get(i).getSUBJECTNAME());
                        pojo.setEMPROOMLABTYPE(pojoitem.getTimeTableInformation().get(i).getEMPROOMLABTYPE());
                        pojo.setDIVISIONNAME(pojoitem.getTimeTableInformation().get(i).getDIVISIONNAME());
                        pojo.setSTARTTIME(pojoitem.getTimeTableInformation().get(i).getSTARTTIME());
                        pojo.setENDTIME(pojoitem.getTimeTableInformation().get(i).getENDTIME());
                        pojo.setCLASSTIMING(pojoitem.getTimeTableInformation().get(i).getCLASSTIMING());


                        arrayList.add(pojo);

                    }

                    DayWiseTimeTableAdapter categoryAdapter = new DayWiseTimeTableAdapter(getActivity(),arrayList);
                    list_lecture.setAdapter(categoryAdapter);






                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    list_lecture.setVisibility(View.GONE);

                    String DisplayMsg=pojoitem.getTimeTableInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<TimeTableInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

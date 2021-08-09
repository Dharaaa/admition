package com.systrack.admission.fragment.TimeTable;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.TimeTableAdapter.Week;
import com.systrack.admission.adapter.TimeTableAdapter.WeekAdapter;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.TimeTableInformationPojo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WednesdayFragment extends Fragment {

    public static final String KEY_MONDAY_FRAGMENT = "Monday";
    private ListView listView;
    private WeekAdapter adapter;
    private ImageView popup;
    SharedPreferences sharedpreferences;
    AppController appController;
    Map<String, String> params;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;

    TextView no_data;
    private String ROLEID;
    String currentAcademicYear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_monday, container, false);


        popup = view.findViewById(R.id.popupbtn);

        sharedpreferences = getActivity().getApplicationContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        appController = (AppController) getActivity().getApplicationContext();
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        listView = view.findViewById(R.id.mondaylist);
        no_data = view.findViewById(R.id.no_data);
        ROLEID = String.valueOf(sharedpreferences.getString(getString(R.string.roleid),"0"));
        getAdmissionYear();
//        if(ROLEID.equals("4") || ROLEID.equals("5")){
//            ViewTimeTableForStudent(appController.getStudent_login_BatchID(),appController.getStudent_login_sectionID(),appController.getStudent_login_AcademicID(),appController.getStdent_login_DivisionId());
//        }else{
//            ViewTimeTableForStudent(appController.getClassTimingCreateBatchId(),appController.getClassTimingCreateSectionId(),appController.getClassTimingActiveAcademicID(),appController.getClassTimingCreateDivId());
//        }
        return view;
    }


        private void getTimeTableList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
        String divisionId;
if(appController.getClassTimingDivisionId()!=null){
    divisionId=appController.getClassTimingDivisionId();
}else{
    divisionId="0";
}

        Call<TimeTableInformationPojo> call=apiInterface.GetTimeTableList(entity_id,branch_id,appController.getTimeTableStreamId(),
                appController.getTimeTableMedium(), appController.getTimeTableBatchId(),
                appController.getTimeTableSemName(),currentAcademicYear,divisionId);

        call.enqueue(new Callback<TimeTableInformationPojo>() {
            @Override
            public void onResponse(Call<TimeTableInformationPojo> call, Response<TimeTableInformationPojo> response) {


                Log.e("Response monday ", new Gson().toJson(response.body()));

                TimeTableInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getTimeTableInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {

                    int Size = pojoitem.getTimeTableInformation().size();
//                    TOTAL_LIST_ITEMS= response.body().getClassTimingInformation().get(1).getTotalCount().toString();

                    ArrayList<Week> weeklist = new ArrayList<Week>();

                    for(int i =1; i<Size; i++){

                        Log.e("WeekDay ",pojoitem.getTimeTableInformation().get(i).getWEEKDAY() + " ** ");
                        if(pojoitem.getTimeTableInformation().get(i).getWEEKDAY() !=null){
                            if(pojoitem.getTimeTableInformation().get(i).getWEEKDAY().equals("Wednesday")){
                                Week week = new Week();
                                week.setSubject(pojoitem.getTimeTableInformation().get(i).getSUBJECTNAME()==null?"":pojoitem.getTimeTableInformation().get(i).getSUBJECTNAME());
                                week.setTeacher(pojoitem.getTimeTableInformation().get(i).getFULLNAME()==null?"":pojoitem.getTimeTableInformation().get(i).getFULLNAME());
                                week.setFromTime(pojoitem.getTimeTableInformation().get(i).getSTARTTIME()==null?"":pojoitem.getTimeTableInformation().get(i).getSTARTTIME());
                                week.setToTime(pojoitem.getTimeTableInformation().get(i).getENDTIME()==null?"":pojoitem.getTimeTableInformation().get(i).getENDTIME());
                                week.setRoom(pojoitem.getTimeTableInformation().get(i).getROOMALIASNAME()==null?"":pojoitem.getTimeTableInformation().get(i).getROOMALIASNAME());
                                week.setWEEKDAY(pojoitem.getTimeTableInformation().get(i).getWEEKDAY()==null?"":pojoitem.getTimeTableInformation().get(i).getWEEKDAY());
                                week.setCLASSTIMEID(pojoitem.getTimeTableInformation().get(i).getCLASSTIMEID());
                                week.setBATCHID(pojoitem.getTimeTableInformation().get(i).getBATCHID());
                                week.setSECTIONID(pojoitem.getTimeTableInformation().get(i).getSECTIONID());
                                week.setDIVISIONID(pojoitem.getTimeTableInformation().get(i).getDIVISIONID());
                                week.setACADEMICID(pojoitem.getTimeTableInformation().get(i).getACADEMICID());
                                week.setLABID(pojoitem.getTimeTableInformation().get(i).getLABID());
                                week.setROOMID(pojoitem.getTimeTableInformation().get(i).getROOMID());
                                if(pojoitem.getTimeTableInformation().get(i).getLABALIASNAME() !=null){
                                    week.setLABALIASNAME(pojoitem.getTimeTableInformation().get(i).getLABALIASNAME());}
                                if(pojoitem.getTimeTableInformation().get(i).getLEAVEDATE() != null){
                                    week.setLEAVEDATE(pojoitem.getTimeTableInformation().get(i).getLEAVEDATE());}
                                else{
                                    week.setLEAVEDATE("");
                                }
//    week.setIsDisplayPractical(jsonObject.getString("isDisplayPractical"));
//    week.setMERGECLASSTIME(jsonObject.getString("MERGECLASSTIME"));
                                weeklist.add(week);

                            }}





                    }
//                    classTimingAdapter = new ClassTimingAdapter(getActivity(),arrayList);
//                    listView.setAdapter(classTimingAdapter);


                    if(weeklist.isEmpty()){
                        no_data.setVisibility(View.VISIBLE);
                        listView.setVisibility(View.GONE);
                    }
                    else {
                        no_data.setVisibility(View.GONE);
                        listView.setVisibility(View.VISIBLE);
                        adapter = new WeekAdapter(getActivity(), listView, R.layout.listview_week_adapter, weeklist);
                        listView.setAdapter(adapter);
                    }

                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);

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
                    getTimeTableList();


                } else {

                    String DisplayMsg = pojoitem.getAdmissionYearInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(), DisplayMsg, Toast.LENGTH_SHORT).show();
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
package com.systrack.admission.fragment.LeaveManagement;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.LeaveMgtAdapter.CurrentLeaveApplicationAdapter;
import com.systrack.admission.adapter.LeaveMgtAdapter.HistoryLeaveApplicationAdapter;
import com.systrack.admission.pojo.ExamIdInformationPojo;
import com.systrack.admission.pojo.LeaveApplicationInformation;
import com.systrack.admission.pojo.LeaveApplicationInformationPojo;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryLeaveApplicationFragment extends Fragment {


    View view;
    AppController appController;
    TextView error;
    ImageView back_arrow;
    DatePickerDialog picker;
    TransparentProgressDialog mProgressDialog;
    SharedPreferences sharedpreferences;
    APIInterface apiInterface;
    TextView no_data;
    String EMPLOYEEID,ROLEID;
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_history_application, container, false);
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPLOYEEID = sharedpreferences.getString(getString(R.string.EMPLOYEEID), "0");

        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");
        listView=view.findViewById(R.id.listView);
        no_data=view.findViewById(R.id.no_data);

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

        getCurrentLeaveDurationID();
        return view;
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


        Call<LeaveApplicationInformationPojo> call = apiInterface.GetLeaveApplicationListForEmployeeHistory(entity_id,branch_id,EMPLOYEEID,"0"
                );
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
                        pojo.setSTARTDATE(pojoitem.getLeaveApplicationInformation().get(i).getSTARTDATE());
                        pojo.setENDDATE(pojoitem.getLeaveApplicationInformation().get(i).getENDDATE());
                        pojo.setLEAVEDAYS(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEDAYS());
                        pojo.setSTATUS(pojoitem.getLeaveApplicationInformation().get(i).getSTATUS());
                        pojo.setREMARKS(pojoitem.getLeaveApplicationInformation().get(i).getREMARKS());
                        pojo.setREASON(pojoitem.getLeaveApplicationInformation().get(i).getREASON());
                        pojo.setLEAVEDURATIONID(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEDURATIONID());
                        pojo.setLEAVEAPPID(pojoitem.getLeaveApplicationInformation().get(i).getLEAVEAPPID());


                        arrayList.add(pojo);

                    }
                    HistoryLeaveApplicationAdapter adapter = new HistoryLeaveApplicationAdapter(getActivity(),arrayList);
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

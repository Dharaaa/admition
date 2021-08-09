package com.systrack.admission.fragment.TimeTable;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.systrack.admission.adapter.TimeTableAdapter.ViewTimeTableWorkLoadAdjustAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.WorkLoadAdjustAdapter;
import com.systrack.admission.fragment.LeaveManagement.LeaveMgtMenuFragment;
import com.systrack.admission.pojo.LeaveApplicationInformation;
import com.systrack.admission.pojo.LeaveApplicationInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewTimeTableWorkLoadAdjustFragment extends Fragment {


    View view;
    AppController appController;
    TextView error;
    ImageView back_arrow;
    DatePickerDialog picker;
    TransparentProgressDialog mProgressDialog;
    SharedPreferences sharedpreferences;
    APIInterface apiInterface;
    TextView no_data;
    String EMPLOYEEID,ROLEID,shared_short_date;
    ListView listView;;
    LinearLayout ll_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_history_application, container, false);
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPLOYEEID = sharedpreferences.getString(getString(R.string.EMPLOYEEID), "0");
        shared_short_date=sharedpreferences.getString(getString(R.string.short_display_date),"dd/MM/yyyy");

        ll_back=view.findViewById(R.id.ll_back);
        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");
        listView=view.findViewById(R.id.listView);
        no_data=view.findViewById(R.id.no_data);
        ll_back.setVisibility(View.VISIBLE);

        ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                MyTimeTableTabFragement coursefragment = new MyTimeTableTabFragement();
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


        Call<LeaveApplicationInformationPojo> call = apiInterface.GetEmployeeTimeTableForLoadBalance(entity_id,branch_id,EMPLOYEEID,
                appController.getSelect_workloadAdjust_startDate(),appController.getSelect_workloadAdjust_endDate(),appController.getCurrentAcademicYear());
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

                        pojo.setdISPLAYDATE(pojoitem.getLeaveApplicationInformation().get(i).getdISPLAYDATE());
                        pojo.setdISPLAYSTARTTIME(pojoitem.getLeaveApplicationInformation().get(i).getdISPLAYSTARTTIME());
                        pojo.setBATCHNAME(pojoitem.getLeaveApplicationInformation().get(i).getBATCHNAME());
                        pojo.setSECTIONID(pojoitem.getLeaveApplicationInformation().get(i).getSECTIONID());
                        pojo.setSUBJECTNAME(pojoitem.getLeaveApplicationInformation().get(i).getSUBJECTNAME());
                        pojo.setDIVISIONNAME(pojoitem.getLeaveApplicationInformation().get(i).getDIVISIONNAME());
                        pojo.setEMPROOMLABTYPE(pojoitem.getLeaveApplicationInformation().get(i).getEMPROOMLABTYPE());
                        pojo.setEMPFULLNAME(pojoitem.getLeaveApplicationInformation().get(i).getEMPFULLNAME());
                        pojo.setSUBNAME(pojoitem.getLeaveApplicationInformation().get(i).getSUBNAME());
                        pojo.setwEEKDAY(pojoitem.getLeaveApplicationInformation().get(i).getwEEKDAY());


                        arrayList.add(pojo);

                    }
                    ViewTimeTableWorkLoadAdjustAdapter adapter = new ViewTimeTableWorkLoadAdjustAdapter(getActivity(),arrayList);
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

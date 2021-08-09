package com.systrack.admission.fragment.LeaveManagement;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.systrack.admission.adapter.LeaveMgtAdapter.HistoryLeaveApplicationAdapter;
import com.systrack.admission.pojo.LeaveApplicationInformation;
import com.systrack.admission.pojo.LeaveApplicationInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewLeaveApplicationFragment extends Fragment {


    View view;
    AppController appController;
    TextView current,history;
    ImageView back_arrow;
    TextView employee_name,leave_date,leave_type,start_Date,end_Date,days,reason,status_hod,remarks_hod,staus_principal,remarks_principal;
    String EMPLOYEEID,ROLEID,leaveDurationID;

    String selected_employee_name, selected_leave_date, selected_leaveType, selected_start_date, selected_end_date, selected_days, selected_reason,
            selected_hod_status,selected_hod_remark, selected_principal_status, selected_principal_remark,shared_short_date;

    SharedPreferences sharedpreferences;

LinearLayout ll_principal;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_view_leave_application, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPLOYEEID = sharedpreferences.getString(getString(R.string.EMPLOYEEID), "0");

        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");
leaveDurationID=appController.getSelected_current_Leave_DurationID();
        apiInterface= ApiClient.getClient().create(APIInterface.class);

       back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
       boolean issecondfactor=sharedpreferences.getBoolean(getString(R.string.issecondfactor),false);

        ll_principal=view.findViewById(R.id.ll_principal);
        if (!issecondfactor) {
            ll_principal.setVisibility(View.GONE);
        }
        employee_name = (TextView)view.findViewById(R.id.employee_name);
        leave_date = (TextView)view.findViewById(R.id.leave_date);
        leave_type = (TextView)view.findViewById(R.id.leave_type);
        start_Date = (TextView)view.findViewById(R.id.start_Date);
        end_Date = (TextView)view.findViewById(R.id.end_Date);
        days = (TextView)view.findViewById(R.id.days);
        reason = (TextView)view.findViewById(R.id.reason);



        status_hod = (TextView)view.findViewById(R.id.status_hod);
        remarks_hod = (TextView)view.findViewById(R.id.remarks_hod);

        staus_principal = (TextView)view.findViewById(R.id.staus_principal);
        remarks_principal = (TextView)view.findViewById(R.id.remarks_principal);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EmpLeaveApplicationTabFragment coursefragment = new EmpLeaveApplicationTabFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });
        getLeaveDetail();
        return view;
    }
    private void getLeaveDetail() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
        String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


        Call<LeaveApplicationInformationPojo> call = apiInterface.ViewLeaveApplicationListForEmployeeCurrent(entity_id,branch_id,appController.getSelected_current_Leave_AppID(),leaveDurationID
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

                    selected_employee_name = pojoitem.getLeaveApplicationInformation().get(1).getEMPNAME();
                    selected_leave_date = pojoitem.getLeaveApplicationInformation().get(1).getLEAVEDATE();
                    selected_leaveType =pojoitem.getLeaveApplicationInformation().get(1).getLEAVETYPENAME();
                    selected_start_date = pojoitem.getLeaveApplicationInformation().get(1).getSTARTDATE();
                    selected_end_date =pojoitem.getLeaveApplicationInformation().get(1).getENDDATE();
                    selected_days = pojoitem.getLeaveApplicationInformation().get(1).getLEAVEDAYS()+"";
                    selected_reason =pojoitem.getLeaveApplicationInformation().get(1).getREASON();
                    selected_hod_status =pojoitem.getLeaveApplicationInformation().get(1).getSTATUS();
                    selected_hod_remark =pojoitem.getLeaveApplicationInformation().get(1).getREMARKS();
                    selected_principal_status =pojoitem.getLeaveApplicationInformation().get(1).getSTATUS1();
                    selected_principal_remark =pojoitem.getLeaveApplicationInformation().get(1).getREMARKS1();

                    employee_name.setText(selected_employee_name);
                        leave_date.setText(selected_leave_date);
                    leave_type.setText(selected_leaveType);
                        start_Date.setText(selected_start_date);
                        end_Date.setText(selected_end_date);
                    days.setText(selected_days);
                    reason.setText(selected_reason);



                    status_hod.setText(selected_hod_status);
                    remarks_hod.setText(selected_hod_remark);

                    staus_principal.setText(selected_principal_status);
                    remarks_principal.setText(selected_principal_remark);

                    if(selected_hod_status.equals("Approved")){
                        status_hod.setBackgroundColor(Color.parseColor("#5cb85c"));
                    }

                    if(selected_principal_status!=null){
                        if(selected_principal_status.equals("Approved")){
                            staus_principal.setBackgroundColor(Color.parseColor("#5cb85c"));
                        }
                        if(selected_principal_status.equals("Pending")){
                            staus_principal.setBackgroundColor(Color.parseColor("#337ab7"));
                        }

                        if(selected_principal_status.equals("Reject")){
                            staus_principal.setBackgroundColor(Color.parseColor("#d9534f"));
                        }

//                        if(selected_principal_status.equals("null")){
//                            staus_principal.setText("Not Set");
//                            staus_principal.setTextColor(Color.RED);
//                            staus_principal.setTypeface(null, Typeface.ITALIC);
//                        }

                    }else{
                        staus_principal.setText("Not Set");
                        staus_principal.setTextColor(Color.RED);
                        staus_principal.setTypeface(null, Typeface.ITALIC);

                    }


                    if(selected_hod_status.equals("Pending")){
                        status_hod.setBackgroundColor(Color.parseColor("#337ab7"));
                    }

                    if(selected_hod_status.equals("Reject")){
                        status_hod.setBackgroundColor(Color.parseColor("#d9534f"));
                    }



                    if(selected_hod_status.equals("null")){
                        status_hod.setText("Not Set");
                        status_hod.setTextColor(Color.RED);
                        status_hod.setTypeface(null, Typeface.ITALIC);
                    }

                    if(selected_hod_remark.equals("null")){
                        remarks_hod.setText("Not Set");
                        remarks_hod.setTextColor(Color.RED);
                        remarks_hod.setTypeface(null, Typeface.ITALIC);
                    }



                    if(selected_principal_remark ==null){
                        remarks_principal.setText("Not Set");
                        remarks_principal.setTextColor(Color.RED);
                        remarks_principal.setTypeface(null, Typeface.ITALIC);
                    }





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

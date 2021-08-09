package com.systrack.admission.fragment.DashBoard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.DashBoardAdapter.GeneralNoticeAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.DashboardInformation;
import com.systrack.admission.pojo.DashboardInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentNoticeFragement extends Fragment {

    SharedPreferences sharedpreferences;
    AppController appController;
    ListView notice_general_list;
    FontAwesomeTextview no_data;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;
String student_courseID,ROLEID;
//    ArrayList<GeneralNoticePOJO> array_general_notice;
//    GeneralNoticeAdapter generalNoticeAdapter;

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragement_notice_general, container, false);

        apiInterface= ApiClient.getClient().create(APIInterface.class);

        final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-Regular.ttf");


        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        appController = (AppController) getActivity().getApplicationContext();
        student_courseID = sharedpreferences.getString(getString(R.string.STUDENTCOURSEID),"");
        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");


        no_data = (FontAwesomeTextview)view.findViewById(R.id.no_data);
        notice_general_list = (ListView)view.findViewById(R.id.notice_general_list);
        notice_general_list.setNestedScrollingEnabled(true);
        if(ROLEID.equals("2")){
            getAdminLoginNoticeBoarddata();
        }else{
            getNoticeData();

        }

        return view;
    }

    private void getAdminLoginNoticeBoarddata() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

        Call<DashboardInformationPojo> call=apiInterface.GetStudentNoticeBordData(entity_id,branch_id,"4","0","0");

        call.enqueue(new Callback<DashboardInformationPojo>() {
            @Override
            public void onResponse(Call<DashboardInformationPojo> call, Response<DashboardInformationPojo> response) {
                Log.e("Response 11 ",new Gson().toJson(response.body()));



                DashboardInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getDashboardInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    notice_general_list.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getDashboardInformation().size();

                    ArrayList<DashboardInformation> arrayList = new ArrayList<DashboardInformation>();

                    for(int i =1; i<Size; i++){
                        DashboardInformation pojo = new DashboardInformation();

                        pojo.setTITLE(pojoitem.getDashboardInformation().get(i).getTITLE());
                        pojo.setDESCRIPTION(pojoitem.getDashboardInformation().get(i).getDESCRIPTION());
                        pojo.setNOTICEDISPLAYDATE(pojoitem.getDashboardInformation().get(i).getNOTICEDISPLAYDATE());
                        pojo.setUSERTYPE(pojoitem.getDashboardInformation().get(i).getUSERTYPE());
                        arrayList.add(pojo);

                    }
                    GeneralNoticeAdapter adapter = new GeneralNoticeAdapter(getActivity(),arrayList);
                    notice_general_list.setAdapter(adapter);


                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    notice_general_list.setVisibility(View.GONE);

                    String DisplayMsg=pojoitem.getDashboardInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<DashboardInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }

    private void getNoticeData() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

        Call<DashboardInformationPojo> call=apiInterface.GetStudentNoticeBordData(entity_id,branch_id,"4",student_courseID,"4");

        call.enqueue(new Callback<DashboardInformationPojo>() {
            @Override
            public void onResponse(Call<DashboardInformationPojo> call, Response<DashboardInformationPojo> response) {
                Log.e("Response 11 ",new Gson().toJson(response.body()));



                DashboardInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getDashboardInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    notice_general_list.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getDashboardInformation().size();

                   ArrayList<DashboardInformation> arrayList = new ArrayList<DashboardInformation>();

                    for(int i =1; i<Size; i++){
                        DashboardInformation pojo = new DashboardInformation();

                        pojo.setTITLE(pojoitem.getDashboardInformation().get(i).getTITLE());
                        pojo.setDESCRIPTION(pojoitem.getDashboardInformation().get(i).getDESCRIPTION());
                        pojo.setNOTICEDISPLAYDATE(pojoitem.getDashboardInformation().get(i).getNOTICEDISPLAYDATE());
pojo.setUSERTYPE(pojoitem.getDashboardInformation().get(i).getUSERTYPE());
                        arrayList.add(pojo);

                    }
                  GeneralNoticeAdapter adapter = new GeneralNoticeAdapter(getActivity(),arrayList);
                    notice_general_list.setAdapter(adapter);


                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    notice_general_list.setVisibility(View.GONE);

                    String DisplayMsg=pojoitem.getDashboardInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<DashboardInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

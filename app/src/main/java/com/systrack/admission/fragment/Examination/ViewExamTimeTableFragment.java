package com.systrack.admission.fragment.Examination;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.systrack.admission.adapter.ExaminationAdapter.ExamMasterAdapter;
import com.systrack.admission.adapter.ExaminationAdapter.ViewPublishExamTimeTableAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.ExamIdInformationPojo;
import com.systrack.admission.pojo.ExamMasterInformation;
import com.systrack.admission.pojo.ExamMasterInformationPojo;
import com.systrack.admission.pojo.PublishExamTimeTableInformation;
import com.systrack.admission.pojo.PublishExamTimeTableInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewExamTimeTableFragment extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    ListView listView;
    TransparentProgressDialog mProgressDialog;
    AppController appController;

    TextView no_data;
    APIInterface apiInterface;

    ImageView back_arrow;
    String currentExamID,ROLEID,shared_short_date;
    ViewPublishExamTimeTableAdapter adapter;
    ListView list_exam_timetable;
    TextView exam_name,batch_name,section_name,start_date,end_Date,txt_section_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_view_exam_timetable, container, false);
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;

        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");
          shared_short_date=sharedpreferences.getString(getString(R.string.short_display_date),"dd/MM/yyyy");

        exam_name = (TextView)view.findViewById(R.id.exam_name);
        batch_name = (TextView)view.findViewById(R.id.batch_name);
        section_name = (TextView)view.findViewById(R.id.section_name);
        start_date = (TextView)view.findViewById(R.id.start_date);
        end_Date = (TextView)view.findViewById(R.id.end_Date);
        txt_section_name = view.findViewById(R.id.txt_section_name);
        no_data = (TextView)view.findViewById(R.id.no_data);
        listView = (ListView)view.findViewById(R.id.list_exam_timetable);
//        txt_section_name.setText(DYNAMICLABEL+": ");
        exam_name.setText(appController.getPublish_timeTable_examName());
        batch_name.setText(appController.getPublish_timetable_batchName());
        section_name.setText(appController.getPublish_timetable_sectionName());
//        start_date.setText(appController.getPublish_timeTable_minDate());
//        end_Date.setText(appController.getPublish_timeTable_maxDate());
//
        start_date.setText(appController.ConvertDate(appController.getPublish_timeTable_minDate(),"dd/MM/yyyy",shared_short_date));
        end_Date.setText(appController.ConvertDate(appController.getPublish_timeTable_maxDate(),"dd/MM/yyyy",shared_short_date));


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PublishExamTimeTableFragment coursefragment = new PublishExamTimeTableFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        getCurrentExamID();

        return view;
    }

    private void getCurrentExamID() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
        String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


        Call<ExamIdInformationPojo> call = apiInterface.GetExamIdList(entity_id,branch_id);
        call.enqueue(new Callback<ExamIdInformationPojo>() {
            @Override
            public void onResponse(Call<ExamIdInformationPojo> call, Response<ExamIdInformationPojo> response) {
                Log.e("Response  ", new Gson().toJson(response.body()));


                ExamIdInformationPojo pojoitem = response.body();

                String StatusCode = pojoitem.getExamIdInformation().get(0).getStatusCode();


                if (StatusCode.equals("200")) {

                    currentExamID= String.valueOf(pojoitem.getExamIdInformation().get(1).getCurrentInternalExamId());
                    getCategoryList();
                } else {

                    String DisplayMsg = pojoitem.getExamIdInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getContext(), DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ExamIdInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });

    }

    private void getCategoryList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

        Call<PublishExamTimeTableInformationPojo> call=apiInterface.ViewPublishedExamTimeTableById(entity_id,branch_id,appController.getPublish_timeTable_timeTableId(),
            appController.getPublish_timeTable_examName(),appController.getPublish_timeTable_batchId(),appController.getPublish_timeTable_sectionId(),
                appController.getPublish_timeTable_minDate(),appController.getPublish_timeTable_maxDate(),ROLEID,appController.getCurrentAcademicYear(),
                appController.getCurrentAcademicYear(),"0"
                );

        call.enqueue(new Callback<PublishExamTimeTableInformationPojo>() {
            @Override
            public void onResponse(Call<PublishExamTimeTableInformationPojo> call, Response<PublishExamTimeTableInformationPojo> response) {
                Log.e("Response 11 ",new Gson().toJson(response.body()));



                PublishExamTimeTableInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getPublishExamTimeTableInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getPublishExamTimeTableInformation().size();

                 ArrayList<PublishExamTimeTableInformation>   arrayList = new ArrayList<PublishExamTimeTableInformation>();

                    for(int i =1; i<Size; i++){
                        PublishExamTimeTableInformation pojo = new PublishExamTimeTableInformation();

                        pojo.setEXAMNAME(pojoitem.getPublishExamTimeTableInformation().get(i).getEXAMNAME());
                        pojo.seteXAMTIME(pojoitem.getPublishExamTimeTableInformation().get(i).geteXAMTIME());
                        pojo.setdISPLAYEXAMDATE(pojoitem.getPublishExamTimeTableInformation().get(i).getdISPLAYEXAMDATE());
                        pojo.sethALLNO(pojoitem.getPublishExamTimeTableInformation().get(i).gethALLNO());
                        pojo.setsUBJECTNAME(pojoitem.getPublishExamTimeTableInformation().get(i).getsUBJECTNAME());

                        arrayList.add(pojo);

                    }
                    adapter = new ViewPublishExamTimeTableAdapter(getActivity(),arrayList);
                    listView.setAdapter(adapter);




                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);

                    String DisplayMsg=pojoitem.getPublishExamTimeTableInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<PublishExamTimeTableInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

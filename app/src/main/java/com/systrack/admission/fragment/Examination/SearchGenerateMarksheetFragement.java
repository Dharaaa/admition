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
import com.systrack.admission.adapter.ExaminationAdapter.GenerateMarksheetAdapter;
import com.systrack.admission.adapter.ExaminationAdapter.PublishExamTimeTableAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.ExamIdInformationPojo;
import com.systrack.admission.pojo.GenerateMarksheetInformationPojo;
import com.systrack.admission.pojo.GenerateMarksheetInformation;
import com.systrack.admission.pojo.GenerateMarksheetInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchGenerateMarksheetFragement extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    FontAwesomeTextview Prev, Next;
    TextView display_item_count;
    public int NUM_ITEMS_PAGE   = 10;
    public String TOTAL_LIST_ITEMS;
    EditText searchView;
    ListView listView;
    TransparentProgressDialog mProgressDialog;
    AppController appController;
    String currentExamID,ROLEID,divisionId;

    TextView no_data;
    APIInterface apiInterface;

    ArrayList<GenerateMarksheetInformation> arrayList;
    GenerateMarksheetAdapter adapter;
    ImageView back_arrow;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_generate_marksheet, container, false);
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;

        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");
       boolean ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);

        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        Prev =  view.findViewById(R.id.txt_prev);
        Next =  view.findViewById(R.id.txt_next);
        display_item_count =  view.findViewById(R.id.display_number);
        display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));
        Prev.setEnabled(false);
        Next.setEnabled(false);

        searchView = (EditText) view.findViewById(R.id.searchView);

        listView = (ListView)view.findViewById(R.id.listView);

        no_data = (TextView)view.findViewById(R.id.no_data);
        if (ISALLOWDIVISION){
            divisionId=appController.getGenerate_marksheet_divisionId();
        }else{
            divisionId="0";
        }
getCurrentExamID();
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                GenerateMarkSheetFragment coursefragment = new GenerateMarkSheetFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total_count_from_API = sharedpreferences.getString("Total_count_marksheet","");
                if(NUM_ITEMS_PAGE >=10) {

                    if (Integer.valueOf(total_count_from_API) > Integer.valueOf(display_item_count.getText().toString())) {
                        NUM_ITEMS_PAGE += 10;
                        display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));

                        if (mProgressDialog == null)
                            mProgressDialog = new TransparentProgressDialog(getActivity());
                        if (mProgressDialog.isShowing())
                            mProgressDialog.dismiss();
                        //mProgressDialog = new TransparentProgressDialog(getActivity());
                        mProgressDialog.setCancelable(false);
                        mProgressDialog.show();
                        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
                        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
                        Call<GenerateMarksheetInformationPojo> call=apiInterface.GetGenerateMarksheetList(entity_id,branch_id,appController.getCurrentAcademicYear(),
                                currentExamID,appController.getGenerate_marksheet_batchId(),appController.getGenerate_marksheet_sectionName(),divisionId,
                                appController.getGenerate_marksheet_subjectId(),appController.getGenerate_marksheet_medium(),appController.getGenerate_marksheet_streamId(),
                                display_item_count.getText().toString(),"");


                        call.enqueue(new Callback<GenerateMarksheetInformationPojo>() {
                            @Override
                            public void onResponse(Call<GenerateMarksheetInformationPojo> call, Response<GenerateMarksheetInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                GenerateMarksheetInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getGenerateMarksheetInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getGenerateMarksheetInformation().size();
                                    TOTAL_LIST_ITEMS = response.body().getGenerateMarksheetInformation().get(0).getTotalCount().toString();

                                    arrayList = new ArrayList<GenerateMarksheetInformation>();

                                    for(int i =1; i<Size; i++){
                                        GenerateMarksheetInformation pojo = new GenerateMarksheetInformation();

                                        pojo.setSTUDENTNO(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNO());
                                        pojo.setSTUDENTNAME(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNAME());
                                        pojo.setOBTAINMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getOBTAINMARKS());
                                        pojo.setTOTALMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getTOTALMARKS());

                                        arrayList.add(pojo);

                                    }
                                    adapter = new GenerateMarksheetAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);



                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("UPDATED_Total_count_marksheet",TOTAL_LIST_ITEMS);
                                    editor.apply();
                                    editor.commit();
                                    Prev.setEnabled(true);



                                }else
                                {
                                    String DisplayMsg=pojoitem.getGenerateMarksheetInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<GenerateMarksheetInformationPojo> call, Throwable t) {
                                mProgressDialog.dismiss();
                                Log.e("Failure ",t.getMessage());
                            }
                        });
                    }else{
                        Next.setEnabled(false);
//                        Next.setTextColor(Color.parseColor("#e9e9e9"));
                        Toast.makeText(getActivity(), "End of Records..!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
//
        Prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total_count_from_API = sharedpreferences.getString("UPDATED_Total_count_marksheet","");
                if(NUM_ITEMS_PAGE >10) {

                    NUM_ITEMS_PAGE -= 10;
                    display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));

                    if (Integer.valueOf(total_count_from_API) > Integer.valueOf(display_item_count.getText().toString())) {
                        if (mProgressDialog == null)
                            mProgressDialog = new TransparentProgressDialog(getActivity());
                        if (mProgressDialog.isShowing())
                            mProgressDialog.dismiss();
                        //mProgressDialog = new TransparentProgressDialog(getActivity());
                        mProgressDialog.setCancelable(false);
                        mProgressDialog.show();
                        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
                        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

                        Call<GenerateMarksheetInformationPojo> call=apiInterface.GetGenerateMarksheetList(entity_id,branch_id,appController.getCurrentAcademicYear(),
                                currentExamID,appController.getGenerate_marksheet_batchId(),appController.getGenerate_marksheet_sectionName(),divisionId,
                                appController.getGenerate_marksheet_subjectId(),appController.getGenerate_marksheet_medium(),appController.getGenerate_marksheet_streamId(),
                                display_item_count.getText().toString(),"");


                        call.enqueue(new Callback<GenerateMarksheetInformationPojo>() {
                            @Override
                            public void onResponse(Call<GenerateMarksheetInformationPojo> call, Response<GenerateMarksheetInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                GenerateMarksheetInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getGenerateMarksheetInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getGenerateMarksheetInformation().size();
                                    int totalCount = response.body().getGenerateMarksheetInformation().get(0).getTotalCount();

                                    arrayList = new ArrayList<GenerateMarksheetInformation>();

                                    for(int i =1; i<Size; i++){
                                        GenerateMarksheetInformation pojo = new GenerateMarksheetInformation();

                                        pojo.setSTUDENTNO(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNO());
                                        pojo.setSTUDENTNAME(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNAME());
                                        pojo.setOBTAINMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getOBTAINMARKS());
                                        pojo.setTOTALMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getTOTALMARKS());

                                        arrayList.add(pojo);

                                    }
                                    adapter = new GenerateMarksheetAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);




                                    Next.setEnabled(true);
//                                    Next.setTextColor(Color.parseColor("#000000"));


                                }else
                                {
                                    String DisplayMsg=pojoitem.getGenerateMarksheetInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<GenerateMarksheetInformationPojo> call, Throwable t) {
                                mProgressDialog.dismiss();
                                Log.e("Failure ",t.getMessage());
                            }
                        });




                    }else{
                        Prev.setEnabled(false);
//                        Prev.setTextColor(Color.parseColor("#e9e9e9"));
                        Toast.makeText(getActivity(), "End of Records..!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        searchView.addTextChangedListener(new TextWatcher() {
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

                Call<GenerateMarksheetInformationPojo> call=apiInterface.GetGenerateMarksheetList(entity_id,branch_id,appController.getCurrentAcademicYear(),
                        currentExamID,appController.getGenerate_marksheet_batchId(),appController.getGenerate_marksheet_sectionName(),divisionId,
                        appController.getGenerate_marksheet_subjectId(),appController.getGenerate_marksheet_medium(),appController.getGenerate_marksheet_streamId(),
                        display_item_count.getText().toString(),searchView.getText().toString());


                call.enqueue(new Callback<GenerateMarksheetInformationPojo>() {
                    @Override
                    public void onResponse(Call<GenerateMarksheetInformationPojo> call, Response<GenerateMarksheetInformationPojo> response) {
                        Log.e("Response  ",new Gson().toJson(response.body()));



                        GenerateMarksheetInformationPojo pojoitem=response.body();

                        String StatusCode=pojoitem.getGenerateMarksheetInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if(StatusCode.equals("200"))
                        {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            Next.setEnabled(true);
                            int Size = pojoitem.getGenerateMarksheetInformation().size();
                            TOTAL_LIST_ITEMS = response.body().getGenerateMarksheetInformation().get(0).getTotalCount().toString();

                            arrayList = new ArrayList<GenerateMarksheetInformation>();

                            for(int i =1; i<Size; i++){
                                GenerateMarksheetInformation pojo = new GenerateMarksheetInformation();

                                pojo.setSTUDENTNO(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNO());
                                pojo.setSTUDENTNAME(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNAME());
                                pojo.setOBTAINMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getOBTAINMARKS());
                                pojo.setTOTALMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getTOTALMARKS());

                                arrayList.add(pojo);

                            }
                            adapter = new GenerateMarksheetAdapter(getActivity(),arrayList);
                            listView.setAdapter(adapter);



//                            SharedPreferences.Editor editor = sharedpreferences.edit();
//                            editor.putString("Total_count_designation",Count+"");
//                            editor.apply();
//                            editor.commit();



                        }else
                        {
                            no_data.setVisibility(View.VISIBLE);
                            listView.setVisibility(View.GONE);
                            Next.setEnabled(false);

                            String DisplayMsg=pojoitem.getGenerateMarksheetInformation().get(0).getDisplayMessage();
                            Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<GenerateMarksheetInformationPojo> call, Throwable t) {
                        Log.e("Failure ",t.getMessage());
                    }
                });





            }
        });


        return view;
    }

    private void getTimeTableList() {

        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

        Call<GenerateMarksheetInformationPojo> call=apiInterface.GetGenerateMarksheetList(entity_id,branch_id,appController.getCurrentAcademicYear(),
                currentExamID,appController.getGenerate_marksheet_batchId(),appController.getGenerate_marksheet_sectionName(),divisionId,
                appController.getGenerate_marksheet_subjectId(),appController.getGenerate_marksheet_medium(),appController.getGenerate_marksheet_streamId(),
                display_item_count.getText().toString(),"");

        call.enqueue(new Callback<GenerateMarksheetInformationPojo>() {
            @Override
            public void onResponse(Call<GenerateMarksheetInformationPojo> call, Response<GenerateMarksheetInformationPojo> response) {
                Log.e("Response 11 ",new Gson().toJson(response.body()));



                GenerateMarksheetInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getGenerateMarksheetInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    Next.setEnabled(true);
                    int Size = pojoitem.getGenerateMarksheetInformation().size();
                    TOTAL_LIST_ITEMS= response.body().getGenerateMarksheetInformation().get(0).getTotalCount().toString();

                    arrayList = new ArrayList<GenerateMarksheetInformation>();

                    for(int i =1; i<Size; i++){
                        GenerateMarksheetInformation pojo = new GenerateMarksheetInformation();

                        pojo.setSTUDENTNO(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNO());
                        pojo.setSTUDENTNAME(pojoitem.getGenerateMarksheetInformation().get(i).getSTUDENTNAME());
                        pojo.setOBTAINMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getOBTAINMARKS());
                        pojo.setTOTALMARKS(pojoitem.getGenerateMarksheetInformation().get(i).getTOTALMARKS());

                        arrayList.add(pojo);

                    }
                    adapter = new GenerateMarksheetAdapter(getActivity(),arrayList);
                    listView.setAdapter(adapter);

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Total_count_marksheet",TOTAL_LIST_ITEMS);
                    editor.apply();
                    editor.commit();



                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    Next.setEnabled(false);

                    String DisplayMsg=pojoitem.getGenerateMarksheetInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<GenerateMarksheetInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
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
                    getTimeTableList();
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

}

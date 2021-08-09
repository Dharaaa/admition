package com.systrack.admission.fragment.HolidayManagement;


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
import com.systrack.admission.adapter.HolidayAdapter.HolidayAdapter;
import com.systrack.admission.adapter.TimeTableAdapter.ClassTimingAdapter;
import com.systrack.admission.adapter.hrAdapter.ManageEmployeeAdapter;
import com.systrack.admission.fragment.Hr.ManageEmpFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.ClassTimingInformation;
import com.systrack.admission.pojo.ClassTimingInformationPojo;
import com.systrack.admission.pojo.HolidayInformation;
import com.systrack.admission.pojo.HolidayInformationPojo;
import com.systrack.admission.pojo.HolidayInformation;
import com.systrack.admission.pojo.HolidayInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NationalHolidayFragment extends Fragment {


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

    TextView no_data;
    APIInterface apiInterface;

    ArrayList<HolidayInformation> arrayList;
    HolidayAdapter adapter;
    ImageView back_arrow;
    String currentAcademicYear,ROLEID;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_national_holiday, container, false);
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(getString(R.string.roleid),"0");

        if(ROLEID.equals("2")){
            back_arrow.setVisibility(View.VISIBLE);
        }else{
            back_arrow.setVisibility(View.GONE);
        }

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


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HolidayMgtMenuFragment coursefragment = new HolidayMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        getAdmissionYear();

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total_count_from_API = sharedpreferences.getString("Total_count_national_holiday","");
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


                        Call<HolidayInformationPojo> call=apiInterface.GetAllHolidayList(entity_id,branch_id,currentAcademicYear,
                                display_item_count.getText().toString(),"");

                        call.enqueue(new Callback<HolidayInformationPojo>() {
                            @Override
                            public void onResponse(Call<HolidayInformationPojo> call, Response<HolidayInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                HolidayInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getHolidayInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getHolidayInformation().size();
                                    TOTAL_LIST_ITEMS = response.body().getHolidayInformation().get(1).getTotalCount().toString();

                                    arrayList = new ArrayList<HolidayInformation>();

                                    for(int i =1; i<Size; i++){
                                        HolidayInformation pojo = new HolidayInformation();

                                        pojo.setHOLIDAYNAME(pojoitem.getHolidayInformation().get(i).getHOLIDAYNAME());
                                        pojo.setDISPLAYHOLIDAYDATEDDMMMYYYY(pojoitem.getHolidayInformation().get(i).getDISPLAYHOLIDAYDATEDDMMMYYYY());
                                        pojo.setREMARKS(pojoitem.getHolidayInformation().get(i).getREMARKS());
                                        pojo.setDISPLAYSTATUS(pojoitem.getHolidayInformation().get(i).getDISPLAYSTATUS());
//                        pojo.setCLASSTIMINGID(pojoitem.getClassTimingInformation().get(i).getCLASSTIMINGID());


                                        arrayList.add(pojo);

                                    }
                                    adapter = new HolidayAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);



                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("UPDATED_Total_count_national_holiday",TOTAL_LIST_ITEMS);
                                    editor.apply();
                                    editor.commit();
                                    Prev.setEnabled(true);



                                }else
                                {
                                    String DisplayMsg=pojoitem.getHolidayInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<HolidayInformationPojo> call, Throwable t) {
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
                String total_count_from_API = sharedpreferences.getString("UPDATED_Total_count_national_holiday","");
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

                        Call<HolidayInformationPojo> call=apiInterface.GetAllHolidayList(entity_id,branch_id,currentAcademicYear,
                                display_item_count.getText().toString(),"");

                        call.enqueue(new Callback<HolidayInformationPojo>() {
                            @Override
                            public void onResponse(Call<HolidayInformationPojo> call, Response<HolidayInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                HolidayInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getHolidayInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getHolidayInformation().size();
                                    int totalCount = response.body().getHolidayInformation().get(1).getTotalCount();

                                    arrayList = new ArrayList<HolidayInformation>();

                                    for(int i =1; i<Size; i++){
                                        HolidayInformation pojo = new HolidayInformation();

                                        pojo.setHOLIDAYNAME(pojoitem.getHolidayInformation().get(i).getHOLIDAYNAME());
                                        pojo.setDISPLAYHOLIDAYDATEDDMMMYYYY(pojoitem.getHolidayInformation().get(i).getDISPLAYHOLIDAYDATEDDMMMYYYY());
                                        pojo.setREMARKS(pojoitem.getHolidayInformation().get(i).getREMARKS());
                                        pojo.setDISPLAYSTATUS(pojoitem.getHolidayInformation().get(i).getDISPLAYSTATUS());
//                        pojo.setCLASSTIMINGID(pojoitem.getClassTimingInformation().get(i).getCLASSTIMINGID());


                                        arrayList.add(pojo);

                                    }
                                    adapter = new HolidayAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);




                                    Next.setEnabled(true);
//                                    Next.setTextColor(Color.parseColor("#000000"));


                                }else
                                {
                                    String DisplayMsg=pojoitem.getHolidayInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<HolidayInformationPojo> call, Throwable t) {
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


                Call<HolidayInformationPojo> call=apiInterface.GetAllHolidayList(entity_id,branch_id,currentAcademicYear,
                        display_item_count.getText().toString(),searchView.getText().toString());

                call.enqueue(new Callback<HolidayInformationPojo>() {
                    @Override
                    public void onResponse(Call<HolidayInformationPojo> call, Response<HolidayInformationPojo> response) {
                        Log.e("Response  ",new Gson().toJson(response.body()));



                        HolidayInformationPojo pojoitem=response.body();

                        String StatusCode=pojoitem.getHolidayInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if(StatusCode.equals("200"))
                        {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            Next.setEnabled(true);
                            int Size = pojoitem.getHolidayInformation().size();
                            TOTAL_LIST_ITEMS = response.body().getHolidayInformation().get(1).getTotalCount().toString();

                            arrayList = new ArrayList<HolidayInformation>();

                            for(int i =1; i<Size; i++){
                                HolidayInformation pojo = new HolidayInformation();

                                pojo.setHOLIDAYNAME(pojoitem.getHolidayInformation().get(i).getHOLIDAYNAME());
                                pojo.setDISPLAYHOLIDAYDATEDDMMMYYYY(pojoitem.getHolidayInformation().get(i).getDISPLAYHOLIDAYDATEDDMMMYYYY());
                                pojo.setREMARKS(pojoitem.getHolidayInformation().get(i).getREMARKS());
                                pojo.setDISPLAYSTATUS(pojoitem.getHolidayInformation().get(i).getDISPLAYSTATUS());
//                        pojo.setCLASSTIMINGID(pojoitem.getClassTimingInformation().get(i).getCLASSTIMINGID());


                                arrayList.add(pojo);

                            }
                            adapter = new HolidayAdapter(getActivity(),arrayList);
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

                            String DisplayMsg=pojoitem.getHolidayInformation().get(0).getDisplayMessage();
                            Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<HolidayInformationPojo> call, Throwable t) {
                        Log.e("Failure ",t.getMessage());
                    }
                });





            }
        });


        return view;
    }
    private void getAdmissionYear() {
        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();


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
                    getHolidayList();


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

    private void getHolidayList() {

//        if (mProgressDialog == null)
//            mProgressDialog = new TransparentProgressDialog(getActivity());
//        if (mProgressDialog.isShowing())
//            mProgressDialog.dismiss();
//        //mProgressDialog = new TransparentProgressDialog(getActivity());
//        mProgressDialog.setCancelable(false);
//        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

        Call<HolidayInformationPojo> call=apiInterface.GetAllHolidayList(entity_id,branch_id,currentAcademicYear,
                display_item_count.getText().toString(),"");

        call.enqueue(new Callback<HolidayInformationPojo>() {
            @Override
            public void onResponse(Call<HolidayInformationPojo> call, Response<HolidayInformationPojo> response) {



                HolidayInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getHolidayInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    Next.setEnabled(true);
                    int Size = pojoitem.getHolidayInformation().size();
                    TOTAL_LIST_ITEMS= String.valueOf(response.body().getHolidayInformation().get(1).getTotalCount());

                    arrayList = new ArrayList<HolidayInformation>();

                    for(int i =1; i<Size; i++){
                        HolidayInformation pojo = new HolidayInformation();

                        pojo.setHOLIDAYNAME(pojoitem.getHolidayInformation().get(i).getHOLIDAYNAME());
                        pojo.setDISPLAYHOLIDAYDATEDDMMMYYYY(pojoitem.getHolidayInformation().get(i).getDISPLAYHOLIDAYDATEDDMMMYYYY());
                        pojo.setREMARKS(pojoitem.getHolidayInformation().get(i).getREMARKS());
                        pojo.setDISPLAYSTATUS(pojoitem.getHolidayInformation().get(i).getDISPLAYSTATUS());
//                        pojo.setCLASSTIMINGID(pojoitem.getClassTimingInformation().get(i).getCLASSTIMINGID());



                        arrayList.add(pojo);

                    }
                    adapter = new HolidayAdapter(getActivity(),arrayList);
                    listView.setAdapter(adapter);

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Total_count_national_holiday",TOTAL_LIST_ITEMS);
                    editor.apply();
                    editor.commit();



                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    Next.setEnabled(false);

                    String DisplayMsg=pojoitem.getHolidayInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<HolidayInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }

}

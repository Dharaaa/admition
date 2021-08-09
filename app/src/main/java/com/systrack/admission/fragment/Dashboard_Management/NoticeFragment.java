package com.systrack.admission.fragment.Dashboard_Management;


import android.content.Context;
import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.DashBoardMgtAdapter.MessageOfDayAdapter;
import com.systrack.admission.adapter.DashBoardMgtAdapter.NoticeAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.DashboardInformation;
import com.systrack.admission.pojo.DashboardInformationPojo;
import com.systrack.admission.pojo.MessageInformation;
import com.systrack.admission.pojo.DashboardInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticeFragment extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    FontAwesomeTextview Prev, Next;
    TextView display_item_count;
    public int NUM_ITEMS_PAGE   = 10;
    public String TOTAL_LIST_ITEMS,courseId="0";
    EditText search_text;
    ListView listView;
    TransparentProgressDialog mProgressDialog;
    CardView searchview;
    TextView no_data;
    APIInterface apiInterface;

    ArrayList<DashboardInformation> arrayList;
    NoticeAdapter adapter;
    ImageView back_arrow,close;
    EditText course_edittext;
    AppController appController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_dashboard_notice, container, false);
         back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;

        apiInterface= ApiClient.getClient().create(APIInterface.class);
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        Prev =  view.findViewById(R.id.txt_prev);
        Next =  view.findViewById(R.id.txt_next);
        display_item_count =  view.findViewById(R.id.display_number);
        display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));
        Prev.setEnabled(false);
        Next.setEnabled(false);

        searchview = view.findViewById(R.id.searchview);
        FloatingActionButton search;

search=view.findViewById(R.id.fab_search);
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


        course_edittext=view.findViewById(R.id.course_edittext);
        search_text = (EditText) view.findViewById(R.id.search_text);
        appController = (AppController) getActivity().getApplicationContext();

        listView = (ListView)view.findViewById(R.id.listView);

        no_data = (TextView)view.findViewById(R.id.no_data);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DashBoardMgtMenuFragment timeTableMenuFragment = new DashBoardMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, timeTableMenuFragment);
                country.commit();

            }
        });
        course_edittext = (EditText)view.findViewById(R.id.course_edittext);

        course_edittext.setText("");
        course_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appController.setManageEmpCourseFlag("Notice");
                Intent i=new Intent(getActivity(), ManageEmployeeCourseAllActivity.class);
                startActivity(i);

            }
        });

        getNoticeData();
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total_count_from_API = sharedpreferences.getString("Total_count_notice","");
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


                        Call<DashboardInformationPojo> call=apiInterface.GetAllNoticeData(entity_id,branch_id,courseId,"",display_item_count.getText().toString());

                        call.enqueue(new Callback<DashboardInformationPojo>() {
                            @Override
                            public void onResponse(Call<DashboardInformationPojo> call, Response<DashboardInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                DashboardInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getDashboardInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getDashboardInformation().size();
                                    TOTAL_LIST_ITEMS = response.body().getDashboardInformation().get(0).getTOTALCOUNT().toString();

                                    arrayList = new ArrayList<DashboardInformation>();

                                    for(int i =1; i<Size; i++){
                                        DashboardInformation pojo = new DashboardInformation();

                                        pojo.setTITLE(pojoitem.getDashboardInformation().get(i).getTITLE());
                                        pojo.setDESCRIPTION(pojoitem.getDashboardInformation().get(i).getDESCRIPTION());
                                        pojo.setUSERTYPE(pojoitem.getDashboardInformation().get(i).getUSERTYPE());
                                        pojo.setDISPLAYNOTICEDATE(pojoitem.getDashboardInformation().get(i).getDISPLAYNOTICEDATE());
                                        pojo.setNOTICESTATUS(pojoitem.getDashboardInformation().get(i).getNOTICESTATUS());


                                        arrayList.add(pojo);

                                    }
//                    roomLabMasterAdapter = new RoomLabMasterAdapter(getActivity(),arrayList);
//                    listView.setAdapter(roomLabMasterAdapter);

                                    adapter = new NoticeAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);



                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("UPDATED_Total_count_notice",TOTAL_LIST_ITEMS);
                                    editor.apply();
                                    editor.commit();
                                    Prev.setEnabled(true);



                                }else
                                {
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
                String total_count_from_API = sharedpreferences.getString("UPDATED_Total_count_notice","");
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

                        Call<DashboardInformationPojo> call=apiInterface.GetAllNoticeData(entity_id,branch_id,courseId,"",display_item_count.getText().toString());

                        call.enqueue(new Callback<DashboardInformationPojo>() {
                            @Override
                            public void onResponse(Call<DashboardInformationPojo> call, Response<DashboardInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                DashboardInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getDashboardInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getDashboardInformation().size();
                                    int totalCount = response.body().getDashboardInformation().get(0).getTOTALCOUNT();

                                    arrayList = new ArrayList<DashboardInformation>();

                                    for(int i =1; i<Size; i++){
                                        DashboardInformation pojo = new DashboardInformation();

                                        pojo.setTITLE(pojoitem.getDashboardInformation().get(i).getTITLE());
                                        pojo.setDESCRIPTION(pojoitem.getDashboardInformation().get(i).getDESCRIPTION());
                                        pojo.setUSERTYPE(pojoitem.getDashboardInformation().get(i).getUSERTYPE());
                                        pojo.setDISPLAYNOTICEDATE(pojoitem.getDashboardInformation().get(i).getDISPLAYNOTICEDATE());
                                        pojo.setNOTICESTATUS(pojoitem.getDashboardInformation().get(i).getNOTICESTATUS());


                                        arrayList.add(pojo);

                                    }
//                    roomLabMasterAdapter = new RoomLabMasterAdapter(getActivity(),arrayList);
//                    listView.setAdapter(roomLabMasterAdapter);

                                    adapter = new NoticeAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);




                                    Next.setEnabled(true);
//                                    Next.setTextColor(Color.parseColor("#000000"));


                                }else
                                {
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




                    }else{
                        Prev.setEnabled(false);
//                        Prev.setTextColor(Color.parseColor("#e9e9e9"));
                        Toast.makeText(getActivity(), "End of Records..!", Toast.LENGTH_SHORT).show();
                    }
                }
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


                Call<DashboardInformationPojo> call=apiInterface.GetAllNoticeData(entity_id,branch_id,courseId,search_text.getText().toString(),display_item_count.getText().toString());

                call.enqueue(new Callback<DashboardInformationPojo>() {
                    @Override
                    public void onResponse(Call<DashboardInformationPojo> call, Response<DashboardInformationPojo> response) {
                        Log.e("Response  ",new Gson().toJson(response.body()));



                        DashboardInformationPojo pojoitem=response.body();

                        String StatusCode=pojoitem.getDashboardInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if(StatusCode.equals("200"))
                        {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            Next.setEnabled(true);
                            int Size = pojoitem.getDashboardInformation().size();
                            TOTAL_LIST_ITEMS = response.body().getDashboardInformation().get(0).getTOTALCOUNT().toString();

                            arrayList = new ArrayList<DashboardInformation>();

                            for(int i =1; i<Size; i++){
                                DashboardInformation pojo = new DashboardInformation();

                                pojo.setTITLE(pojoitem.getDashboardInformation().get(i).getTITLE());
                                pojo.setDESCRIPTION(pojoitem.getDashboardInformation().get(i).getDESCRIPTION());
                                pojo.setUSERTYPE(pojoitem.getDashboardInformation().get(i).getUSERTYPE());
                                pojo.setDISPLAYNOTICEDATE(pojoitem.getDashboardInformation().get(i).getDISPLAYNOTICEDATE());
                                pojo.setNOTICESTATUS(pojoitem.getDashboardInformation().get(i).getNOTICESTATUS());


                                arrayList.add(pojo);

                            }
//                    roomLabMasterAdapter = new RoomLabMasterAdapter(getActivity(),arrayList);
//                    listView.setAdapter(roomLabMasterAdapter);

                            adapter = new NoticeAdapter(getActivity(),arrayList);
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

                            String DisplayMsg=pojoitem.getDashboardInformation().get(0).getDisplayMessage();
                            Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<DashboardInformationPojo> call, Throwable t) {
                        Log.e("Failure ",t.getMessage());
                    }
                });





            }
        });


        return view;
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

        Call<DashboardInformationPojo> call=apiInterface.GetAllNoticeData(entity_id,branch_id,courseId,"",display_item_count.getText().toString());

        call.enqueue(new Callback<DashboardInformationPojo>() {
            @Override
            public void onResponse(Call<DashboardInformationPojo> call, Response<DashboardInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                DashboardInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getDashboardInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    Next.setEnabled(true);
                    int Size = pojoitem.getDashboardInformation().size();
                    TOTAL_LIST_ITEMS= response.body().getDashboardInformation().get(0).getTOTALCOUNT().toString();

                    arrayList = new ArrayList<DashboardInformation>();

                    for(int i =1; i<Size; i++){
                        DashboardInformation pojo = new DashboardInformation();

                        pojo.setTITLE(pojoitem.getDashboardInformation().get(i).getTITLE());
                        pojo.setDESCRIPTION(pojoitem.getDashboardInformation().get(i).getDESCRIPTION());
                        pojo.setUSERTYPE(pojoitem.getDashboardInformation().get(i).getUSERTYPE());
                        pojo.setDISPLAYNOTICEDATE(pojoitem.getDashboardInformation().get(i).getDISPLAYNOTICEDATE());
                        pojo.setNOTICESTATUS(pojoitem.getDashboardInformation().get(i).getNOTICESTATUS());


                        arrayList.add(pojo);

                    }
//                    roomLabMasterAdapter = new RoomLabMasterAdapter(getActivity(),arrayList);
//                    listView.setAdapter(roomLabMasterAdapter);

                    adapter = new NoticeAdapter(getActivity(),arrayList);
                    listView.setAdapter(adapter);


                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Total_count_notice",TOTAL_LIST_ITEMS);
                    editor.apply();
                    editor.commit();



                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    Next.setEnabled(false);

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

    @Override
    public void onResume() {
        super.onResume();
        if(appController.getDashBoardMgtNoticeStreamName()!=null){
            course_edittext.setText(appController.getDashBoardMgtNoticeStreamName());
            courseId=appController.getDashBoardMgtNoticeStreamID();
            getNoticeData();
        }
    }
}

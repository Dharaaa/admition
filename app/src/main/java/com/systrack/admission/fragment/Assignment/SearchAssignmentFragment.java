package com.systrack.admission.fragment.Assignment;


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
import com.systrack.admission.adapter.ManageStudentAdapter;
import com.systrack.admission.fragment.ManageStudent.ManageStudentFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.StudentInformation;
import com.systrack.admission.pojo.StudentInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchAssignmentFragment extends Fragment {


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

    ArrayList<StudentInformation> arrayList;
    ManageStudentAdapter adapter;
    ImageView back_arrow;
boolean ISALLOWDIVISION;
String DivisionId;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_assignment, container, false);
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ISALLOWDIVISION = sharedpreferences.getBoolean(getString(R.string.ISALLOWDIVISION), false);
        if(ISALLOWDIVISION){
            DivisionId=appController.getStuAttendanceDivId();
        }else{
            DivisionId="0";
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


                AssignmentFragment coursefragment = new AssignmentFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

//        Next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String total_count_from_API = sharedpreferences.getString("Total_count_manage_student","");
//                if(NUM_ITEMS_PAGE >=10) {
//
//                    if (Integer.valueOf(total_count_from_API) > Integer.valueOf(display_item_count.getText().toString())) {
//                        NUM_ITEMS_PAGE += 10;
//                        display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));
//
//                        if (mProgressDialog == null)
//                            mProgressDialog = new TransparentProgressDialog(getActivity());
//                        if (mProgressDialog.isShowing())
//                            mProgressDialog.dismiss();
//                        //mProgressDialog = new TransparentProgressDialog(getActivity());
//                        mProgressDialog.setCancelable(false);
//                        mProgressDialog.show();
//                        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
//                        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
//
//
//
//                        Call<StudentInformationPojo> call=apiInterface.GetAllStudentList(entity_id,branch_id,appController.getCurrentAcademicYear(),
//                                appController.getManage_student_streamId(),
//                                appController.getManage_student_batchId(),appController.getManage_student_sectionName(), appController.getManage_student_medium(),
//                                display_item_count.getText().toString(),"");
//                        call.enqueue(new Callback<StudentInformationPojo>() {
//                            @Override
//                            public void onResponse(Call<StudentInformationPojo> call, Response<StudentInformationPojo> response) {
//                                Log.e("Response  ",new Gson().toJson(response.body()));
//
//
//
//                                StudentInformationPojo pojoitem=response.body();
//
//                                String StatusCode=pojoitem.getStudentInformation().get(0).getStatusCode();
//
//                                mProgressDialog.dismiss();
//
//                                if(StatusCode.equals("200"))
//                                {
//                                    no_data.setVisibility(View.GONE);
//                                    listView.setVisibility(View.VISIBLE);
//                                    Next.setEnabled(true);
//                                    int Size = pojoitem.getStudentInformation().size();
//                                    TOTAL_LIST_ITEMS = response.body().getStudentInformation().get(0).getTotalCount().toString();
//
//                                    arrayList = new ArrayList<StudentInformation>();
//                                    for(int i =1; i<Size; i++){
//                                        StudentInformation pojo = new StudentInformation();
//
//                                        pojo.setADMISSIONID(pojoitem.getStudentInformation().get(i).getADMISSIONID());
//                                        pojo.setSTUDENTNAME(pojoitem.getStudentInformation().get(i).getSTUDENTNAME());
//                                        pojo.setGENDER(pojoitem.getStudentInformation().get(i).getGENDER());
//                                        pojo.setMOBILENO(pojoitem.getStudentInformation().get(i).getMOBILENO());
//                                        pojo.setDATEOFBIRTH(pojoitem.getStudentInformation().get(i).getDATEOFBIRTH());
//                                        pojo.setUSERNAME(pojoitem.getStudentInformation().get(i).getUSERNAME());
//                                        pojo.setSTUDENTNO(pojoitem.getStudentInformation().get(i).getSTUDENTNO());
//
//                                        arrayList.add(pojo);
//
//                                    }
//                                    adapter =new ManageStudentAdapter (getActivity(),arrayList);
//                                    listView.setAdapter(adapter);
//                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);
//
//
//
//                                    SharedPreferences.Editor editor = sharedpreferences.edit();
//                                    editor.putString("UPDATED_Total_count_manage_student",TOTAL_LIST_ITEMS);
//                                    editor.apply();
//                                    editor.commit();
//                                    Prev.setEnabled(true);
//
//
//
//                                }else
//                                {
//                                    String DisplayMsg=pojoitem.getStudentInformation().get(0).getDisplayMessage();
//                                    mProgressDialog.dismiss();
//                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
//                                }
//
//                            }
//                            @Override
//                            public void onFailure(Call<StudentInformationPojo> call, Throwable t) {
//                                mProgressDialog.dismiss();
//                                Log.e("Failure ",t.getMessage());
//                            }
//                        });
//                    }else{
//                        Next.setEnabled(false);
////                        Next.setTextColor(Color.parseColor("#e9e9e9"));
//                        Toast.makeText(getActivity(), "End of Records..!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
////
//        Prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String total_count_from_API = sharedpreferences.getString("UPDATED_Total_count_manage_student","");
//                if(NUM_ITEMS_PAGE >10) {
//
//                    NUM_ITEMS_PAGE -= 10;
//                    display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));
//
//                    if (Integer.valueOf(total_count_from_API) > Integer.valueOf(display_item_count.getText().toString())) {
//                        if (mProgressDialog == null)
//                            mProgressDialog = new TransparentProgressDialog(getActivity());
//                        if (mProgressDialog.isShowing())
//                            mProgressDialog.dismiss();
//                        //mProgressDialog = new TransparentProgressDialog(getActivity());
//                        mProgressDialog.setCancelable(false);
//                        mProgressDialog.show();
//                        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
//                        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
//
//
//
//                        Call<StudentInformationPojo> call=apiInterface.GetAllStudentList(entity_id,branch_id,appController.getCurrentAcademicYear(),
//                                appController.getManage_student_streamId(),
//                                appController.getManage_student_batchId(),appController.getManage_student_sectionName(), appController.getManage_student_medium(),
//                                display_item_count.getText().toString(),"");
//                        call.enqueue(new Callback<StudentInformationPojo>() {
//                            @Override
//                            public void onResponse(Call<StudentInformationPojo> call, Response<StudentInformationPojo> response) {
//                                Log.e("Response  ",new Gson().toJson(response.body()));
//
//
//
//                                StudentInformationPojo pojoitem=response.body();
//
//                                String StatusCode=pojoitem.getStudentInformation().get(0).getStatusCode();
//
//                                mProgressDialog.dismiss();
//
//                                if(StatusCode.equals("200"))
//                                {
//                                    no_data.setVisibility(View.GONE);
//                                    listView.setVisibility(View.VISIBLE);
//                                    Next.setEnabled(true);
//                                    int Size = pojoitem.getStudentInformation().size();
//                                    int totalCount = response.body().getStudentInformation().get(0).getTotalCount();
//
//                                    arrayList = new ArrayList<StudentInformation>();
//
//                                    for(int i =1; i<Size; i++){
//                                        StudentInformation pojo = new StudentInformation();
//
//                                        pojo.setADMISSIONID(pojoitem.getStudentInformation().get(i).getADMISSIONID());
//                                        pojo.setSTUDENTNAME(pojoitem.getStudentInformation().get(i).getSTUDENTNAME());
//                                        pojo.setGENDER(pojoitem.getStudentInformation().get(i).getGENDER());
//                                        pojo.setMOBILENO(pojoitem.getStudentInformation().get(i).getMOBILENO());
//                                        pojo.setDATEOFBIRTH(pojoitem.getStudentInformation().get(i).getDATEOFBIRTH());
//                                        pojo.setUSERNAME(pojoitem.getStudentInformation().get(i).getUSERNAME());
//                                        pojo.setSTUDENTNO(pojoitem.getStudentInformation().get(i).getSTUDENTNO());
//
//                                        arrayList.add(pojo);
//
//                                    }
//                                    adapter =new ManageStudentAdapter (getActivity(),arrayList);
//                                    listView.setAdapter(adapter);
//                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);
//
//
//
//
//                                    Next.setEnabled(true);
////                                    Next.setTextColor(Color.parseColor("#000000"));
//
//
//                                }else
//                                {
//                                    String DisplayMsg=pojoitem.getStudentInformation().get(0).getDisplayMessage();
//                                    mProgressDialog.dismiss();
//                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
//                                }
//
//                            }
//                            @Override
//                            public void onFailure(Call<StudentInformationPojo> call, Throwable t) {
//                                mProgressDialog.dismiss();
//                                Log.e("Failure ",t.getMessage());
//                            }
//                        });
//
//
//
//
//                    }else{
//                        Prev.setEnabled(false);
////                        Prev.setTextColor(Color.parseColor("#e9e9e9"));
//                        Toast.makeText(getActivity(), "End of Records..!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });
//
//        searchView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//                String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
//                String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
//
//
//
//                Call<StudentInformationPojo> call=apiInterface.GetAllStudentList(entity_id,branch_id,appController.getCurrentAcademicYear(),
//                        appController.getManage_student_streamId(),
//                        appController.getManage_student_batchId(),appController.getManage_student_sectionName(), appController.getManage_student_medium(),
//                        display_item_count.getText().toString(),searchView.getText().toString());
//
//                call.enqueue(new Callback<StudentInformationPojo>() {
//                    @Override
//                    public void onResponse(Call<StudentInformationPojo> call, Response<StudentInformationPojo> response) {
//                        Log.e("Response  ",new Gson().toJson(response.body()));
//
//
//
//                        StudentInformationPojo pojoitem=response.body();
//
//                        String StatusCode=pojoitem.getStudentInformation().get(0).getStatusCode();
//
//                        mProgressDialog.dismiss();
//
//                        if(StatusCode.equals("200"))
//                        {
//                            no_data.setVisibility(View.GONE);
//                            listView.setVisibility(View.VISIBLE);
//                            Next.setEnabled(true);
//                            int Size = pojoitem.getStudentInformation().size();
//                            TOTAL_LIST_ITEMS = response.body().getStudentInformation().get(0).getTotalCount().toString();
//
//                            arrayList = new ArrayList<StudentInformation>();
//
//                            for(int i =1; i<Size; i++){
//                                StudentInformation pojo = new StudentInformation();
//
//                                pojo.setADMISSIONID(pojoitem.getStudentInformation().get(i).getADMISSIONID());
//                                pojo.setSTUDENTNAME(pojoitem.getStudentInformation().get(i).getSTUDENTNAME());
//                                pojo.setGENDER(pojoitem.getStudentInformation().get(i).getGENDER());
//                                pojo.setMOBILENO(pojoitem.getStudentInformation().get(i).getMOBILENO());
//                                pojo.setDATEOFBIRTH(pojoitem.getStudentInformation().get(i).getDATEOFBIRTH());
//                                pojo.setUSERNAME(pojoitem.getStudentInformation().get(i).getUSERNAME());
//                                pojo.setSTUDENTNO(pojoitem.getStudentInformation().get(i).getSTUDENTNO());
//
//                                arrayList.add(pojo);
//
//                            }
//                            adapter =new ManageStudentAdapter (getActivity(),arrayList);
//                            listView.setAdapter(adapter);
//
//
//
////                            SharedPreferences.Editor editor = sharedpreferences.edit();
////                            editor.putString("Total_count_designation",Count+"");
////                            editor.apply();
////                            editor.commit();
//
//
//
//                        }else
//                        {
//                            no_data.setVisibility(View.VISIBLE);
//                            listView.setVisibility(View.GONE);
//                            Next.setEnabled(false);
//
//                            String DisplayMsg=pojoitem.getStudentInformation().get(0).getDisplayMessage();
//                            Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                    @Override
//                    public void onFailure(Call<StudentInformationPojo> call, Throwable t) {
//                        Log.e("Failure ",t.getMessage());
//                    }
//                });
//
//
//
//
//
//            }
//        });

//        getDataList();

        return view;
    }

    private void getDataList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

        Call<StudentInformationPojo> call=apiInterface.GetAllAssignmentList(entity_id,branch_id,appController.getCurrentAcademicYear(),
                appController.getAssignment_streamId(),
                appController.getAssignment_medium(),appController.getAssignment_batchId(), appController.getAssignment_sectionId(),ISALLOWDIVISION+"",
                DivisionId,"",display_item_count.getText().toString());

        call.enqueue(new Callback<StudentInformationPojo>() {
            @Override
            public void onResponse(Call<StudentInformationPojo> call, Response<StudentInformationPojo> response) {
                Log.e("Response 11 ",new Gson().toJson(response.body()));



                StudentInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getStudentInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    Next.setEnabled(true);
                    int Size = pojoitem.getStudentInformation().size();
                    TOTAL_LIST_ITEMS= response.body().getStudentInformation().get(0).getTotalCount().toString();

                    arrayList = new ArrayList<StudentInformation>();

                    for(int i =1; i<Size; i++){
                        StudentInformation pojo = new StudentInformation();

                        pojo.setADMISSIONID(pojoitem.getStudentInformation().get(i).getADMISSIONID());
                        pojo.setSTUDENTNAME(pojoitem.getStudentInformation().get(i).getSTUDENTNAME());
                        pojo.setGENDER(pojoitem.getStudentInformation().get(i).getGENDER());
                        pojo.setMOBILENO(pojoitem.getStudentInformation().get(i).getMOBILENO());
                        pojo.setDATEOFBIRTH(pojoitem.getStudentInformation().get(i).getDATEOFBIRTH());
                        pojo.setUSERNAME(pojoitem.getStudentInformation().get(i).getUSERNAME());
                        pojo.setSTUDENTNO(pojoitem.getStudentInformation().get(i).getSTUDENTNO());

                        arrayList.add(pojo);

                    }
                    adapter =new ManageStudentAdapter (getActivity(),arrayList);
                    listView.setAdapter(adapter);

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Total_count_manage_student",TOTAL_LIST_ITEMS);
                    editor.apply();
                    editor.commit();



                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    Next.setEnabled(false);

                    String DisplayMsg=pojoitem.getStudentInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<StudentInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }




}

package com.systrack.admission.fragment.CourseManagement;


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
import com.systrack.admission.adapter.CourseMgtAdapter.BatchAdapter;
import com.systrack.admission.adapter.CourseMgtAdapter.ClassDivisionAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.ClassDivisionInformation;
import com.systrack.admission.pojo.ClassDivisionInformation;
import com.systrack.admission.pojo.ClassDivisionInformationPojo;
import com.systrack.admission.pojo.ClassDivisionInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassDivisionFragment extends Fragment {


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

    ArrayList<ClassDivisionInformation> arrayList;
    ClassDivisionAdapter adapter;
    ImageView back_arrow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_class_division, container, false);
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
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

        getCategoryList();





        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CourseMgtMenuFragment coursefragment = new CourseMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total_count_from_API = sharedpreferences.getString("Total_count_class_division","");
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


                        Call<ClassDivisionInformationPojo> call=apiInterface.GetDivisionList(entity_id,branch_id,appController.getCurrentAcademicYear(), display_item_count.getText().toString(),"");

                        call.enqueue(new Callback<ClassDivisionInformationPojo>() {
                            @Override
                            public void onResponse(Call<ClassDivisionInformationPojo> call, Response<ClassDivisionInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                ClassDivisionInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getClassDivisionInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getClassDivisionInformation().size();
                                    TOTAL_LIST_ITEMS = response.body().getClassDivisionInformation().get(1).getTotalCount().toString();

                                    arrayList = new ArrayList<ClassDivisionInformation>();

                                    for(int i =1; i<Size; i++){
                                        ClassDivisionInformation pojo = new ClassDivisionInformation();

                                        pojo.setDIVISIONNAME(pojoitem.getClassDivisionInformation().get(i).getDIVISIONNAME());
                                        pojo.setBATCHNAME(pojoitem.getClassDivisionInformation().get(i).getBATCHNAME());
                                        pojo.setSECTIONNAME(pojoitem.getClassDivisionInformation().get(i).getSECTIONNAME());
                                        pojo.setcOURSENAME(pojoitem.getClassDivisionInformation().get(i).getcOURSENAME());
                                        arrayList.add(pojo);

                                    }
                                    adapter = new ClassDivisionAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);



                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("UPDATED_Total_count_class_division",TOTAL_LIST_ITEMS);
                                    editor.apply();
                                    editor.commit();
                                    Prev.setEnabled(true);



                                }else
                                {
                                    String DisplayMsg=pojoitem.getClassDivisionInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<ClassDivisionInformationPojo> call, Throwable t) {
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
                String total_count_from_API = sharedpreferences.getString("UPDATED_Total_count_class_division","");
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

                        Call<ClassDivisionInformationPojo> call=apiInterface.GetDivisionList(entity_id,branch_id,appController.getCurrentAcademicYear(), display_item_count.getText().toString(),"");

                        call.enqueue(new Callback<ClassDivisionInformationPojo>() {
                            @Override
                            public void onResponse(Call<ClassDivisionInformationPojo> call, Response<ClassDivisionInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                ClassDivisionInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getClassDivisionInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    listView.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getClassDivisionInformation().size();
                                    int totalCount = response.body().getClassDivisionInformation().get(1).getTotalCount();

                                    arrayList = new ArrayList<ClassDivisionInformation>();

                                    for(int i =1; i<Size; i++){
                                        ClassDivisionInformation pojo = new ClassDivisionInformation();

                                        pojo.setDIVISIONNAME(pojoitem.getClassDivisionInformation().get(i).getDIVISIONNAME());
                                        pojo.setBATCHNAME(pojoitem.getClassDivisionInformation().get(i).getBATCHNAME());
                                        pojo.setSECTIONNAME(pojoitem.getClassDivisionInformation().get(i).getSECTIONNAME());
                                        pojo.setcOURSENAME(pojoitem.getClassDivisionInformation().get(i).getcOURSENAME());
                                        arrayList.add(pojo);

                                    }
                                    adapter = new ClassDivisionAdapter(getActivity(),arrayList);
                                    listView.setAdapter(adapter);
                                    listView.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);




                                    Next.setEnabled(true);
//                                    Next.setTextColor(Color.parseColor("#000000"));


                                }else
                                {
                                    String DisplayMsg=pojoitem.getClassDivisionInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<ClassDivisionInformationPojo> call, Throwable t) {
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


                Call<ClassDivisionInformationPojo> call=apiInterface.GetDivisionList(entity_id,branch_id,appController.getCurrentAcademicYear(), display_item_count.getText().toString(),searchView.getText().toString());

                call.enqueue(new Callback<ClassDivisionInformationPojo>() {
                    @Override
                    public void onResponse(Call<ClassDivisionInformationPojo> call, Response<ClassDivisionInformationPojo> response) {
                        Log.e("Response  ",new Gson().toJson(response.body()));



                        ClassDivisionInformationPojo pojoitem=response.body();

                        String StatusCode=pojoitem.getClassDivisionInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if(StatusCode.equals("200"))
                        {
                            no_data.setVisibility(View.GONE);
                            listView.setVisibility(View.VISIBLE);
                            Next.setEnabled(true);
                            int Size = pojoitem.getClassDivisionInformation().size();
                            TOTAL_LIST_ITEMS = response.body().getClassDivisionInformation().get(1).getTotalCount().toString();

                            arrayList = new ArrayList<ClassDivisionInformation>();

                            for(int i =1; i<Size; i++){
                                ClassDivisionInformation pojo = new ClassDivisionInformation();

                                pojo.setDIVISIONNAME(pojoitem.getClassDivisionInformation().get(i).getDIVISIONNAME());
                                pojo.setBATCHNAME(pojoitem.getClassDivisionInformation().get(i).getBATCHNAME());
                                pojo.setSECTIONNAME(pojoitem.getClassDivisionInformation().get(i).getSECTIONNAME());
                                pojo.setcOURSENAME(pojoitem.getClassDivisionInformation().get(i).getcOURSENAME());
                                arrayList.add(pojo);

                            }
                            adapter = new ClassDivisionAdapter(getActivity(),arrayList);
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

                            String DisplayMsg=pojoitem.getClassDivisionInformation().get(0).getDisplayMessage();
                            Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<ClassDivisionInformationPojo> call, Throwable t) {
                        Log.e("Failure ",t.getMessage());
                    }
                });





            }
        });


        return view;
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

        Call<ClassDivisionInformationPojo> call=apiInterface.GetDivisionList(entity_id,branch_id,appController.getCurrentAcademicYear(), display_item_count.getText().toString(),"");

        call.enqueue(new Callback<ClassDivisionInformationPojo>() {
            @Override
            public void onResponse(Call<ClassDivisionInformationPojo> call, Response<ClassDivisionInformationPojo> response) {
                Log.e("Response 11 ",new Gson().toJson(response.body()));



                ClassDivisionInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getClassDivisionInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    Next.setEnabled(true);
                    int Size = pojoitem.getClassDivisionInformation().size();
                    TOTAL_LIST_ITEMS= response.body().getClassDivisionInformation().get(1).getTotalCount().toString();

                    arrayList = new ArrayList<ClassDivisionInformation>();

                    for(int i =1; i<Size; i++){
                        ClassDivisionInformation pojo = new ClassDivisionInformation();

                        pojo.setDIVISIONNAME(pojoitem.getClassDivisionInformation().get(i).getDIVISIONNAME());
                        pojo.setBATCHNAME(pojoitem.getClassDivisionInformation().get(i).getBATCHNAME());
                        pojo.setSECTIONNAME(pojoitem.getClassDivisionInformation().get(i).getSECTIONNAME());
                        pojo.setcOURSENAME(pojoitem.getClassDivisionInformation().get(i).getcOURSENAME());
                        arrayList.add(pojo);

                    }
                    adapter = new ClassDivisionAdapter(getActivity(),arrayList);
                    listView.setAdapter(adapter);

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Total_count_class_division",TOTAL_LIST_ITEMS);
                    editor.apply();
                    editor.commit();



                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    Next.setEnabled(false);

                    String DisplayMsg=pojoitem.getClassDivisionInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ClassDivisionInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

package com.systrack.admission.Activity;

import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.hrAdapter.ManageEmployeeCourseAdapter;
import com.systrack.admission.pojo.ManageEmployeeCourseInformation;
import com.systrack.admission.pojo.ManageEmployeeCoursePojo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ManageEmployeeCourseAllActivityNew extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    Map<String, String> params;
    EditText edt_search_by_name;
    TextView no_data;
    ListView listView_course_list;
    String current_academicID,current_academicName;
    ArrayList<ManageEmployeeCourseInformation> array_course_spinner;
    ManageEmployeeCourseAdapter courseAdapter;

    LinearLayout linear_Search;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;

    AppController appController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_employee_course_new);

        final Typeface typeface_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-Regular.ttf");


        sharedpreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        Typeface font_icon = Typeface.createFromAsset(this.getAssets(), "fonts/fontawesome-webfont.ttf");
//        linear_Search = (LinearLayout)findViewById(R.id.linear_Search);
        appController = (AppController)getApplicationContext();

//        edt_search_by_name = (EditText)findViewById(R.id.edt_search_by_name);

//        no_data = (TextView)findViewById(R.id.no_data);
        listView_course_list = (ListView)findViewById(R.id.listView_course_list);

//        edt_search_by_name.setTypeface(typeface_semibold);
//        no_data.setTypeface(typeface_semibold);
        getCourseList();






//        edt_search_by_name.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
//
//
//                Call<ManageEmployeeCoursePojo> call=apiInterface.FillCourseList(entity_id,"0",edt_search_by_name.getText().toString());
//                call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
//                    @Override
//                    public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
//                        Log.e("Response  ",new Gson().toJson(response.body()));
//                        ManageEmployeeCoursePojo pojoitem=response.body();
//                        String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();
//
//                        if(StatusCode.equals("200"))
//                        {
//                            no_data.setVisibility(View.GONE);
//                            listView_course_list.setVisibility(View.VISIBLE);
//                            int Size = pojoitem.getEmployeeInformation().size();
//
//                            array_course_spinner = new ArrayList<ManageEmployeeCourseInformation>();
//
//                            for(int i =1; i<Size; i++){
//                                ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();
//
//                                pojo.setSTREAMID(pojoitem.getEmployeeInformation().get(i).getSTREAMID());
//                                pojo.setSTREAMNAME(pojoitem.getEmployeeInformation().get(i).getSTREAMNAME());
//                                array_course_spinner.add(pojo);
//
//                            }
//                            courseAdapter = new ManageEmployeeCourseAdapter(ManageEmployeeCourseAllActivityNew.this,array_course_spinner);
//                            listView_course_list.setAdapter(courseAdapter);
//                        }else
//                        {
//                            no_data.setVisibility(View.VISIBLE);
//                            listView_course_list.setVisibility(View.GONE);
//
//                            String DisplayMsg=pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
//                            Toast.makeText(ManageEmployeeCourseAllActivityNew.this,DisplayMsg,Toast.LENGTH_SHORT).show();
//                        }
//
//                    }
//                    @Override
//                    public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
//                        Log.e("Failure ",t.getMessage());
//                    }
//                });
//
//
//            }
//        });

        listView_course_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                appController.setManageEmpStreamId(array_course_spinner.get(position).getSTREAMID().toString());
                appController.setManageEmpStreamName(array_course_spinner.get(position).getSTREAMNAME());
                finish();
            }
        });
    }




    private void getCourseList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(ManageEmployeeCourseAllActivityNew.this);
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");


        Call<ManageEmployeeCoursePojo> call=apiInterface.FillCourseList(entity_id,"0","");
        call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
            @Override
            public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                ManageEmployeeCoursePojo pojoitem=response.body();

                String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
//                    no_data.setVisibility(View.GONE);
                    listView_course_list.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getEmployeeInformation().size();

                    array_course_spinner = new ArrayList<ManageEmployeeCourseInformation>();

                    for(int i =1; i<Size; i++){
                        ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                        pojo.setSTREAMID(pojoitem.getEmployeeInformation().get(i).getSTREAMID());
                        pojo.setSTREAMNAME(pojoitem.getEmployeeInformation().get(i).getSTREAMNAME());


                        array_course_spinner.add(pojo);

                    }
                    courseAdapter = new ManageEmployeeCourseAdapter(ManageEmployeeCourseAllActivityNew.this,array_course_spinner);
                    listView_course_list.setAdapter(courseAdapter);




                }else
                {
//                    no_data.setVisibility(View.VISIBLE);
                    listView_course_list.setVisibility(View.GONE);
//                    linear_Search.setVisibility(View.GONE);

                    String DisplayMsg=pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(ManageEmployeeCourseAllActivityNew.this,DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) getApplicationContext().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(ManageEmployeeCourseAllActivityNew.this.getComponentName()));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                public boolean onQueryTextChange(String newText) {
                    String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");


                    Call<ManageEmployeeCoursePojo> call=apiInterface.FillCourseList(entity_id,"0",newText.toString());
                    call.enqueue(new Callback<ManageEmployeeCoursePojo>() {
                        @Override
                        public void onResponse(Call<ManageEmployeeCoursePojo> call, Response<ManageEmployeeCoursePojo> response) {
                            Log.e("Response  ",new Gson().toJson(response.body()));
                            ManageEmployeeCoursePojo pojoitem=response.body();
                            String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();

                            if(StatusCode.equals("200"))
                            {
//                                no_data.setVisibility(View.GONE);
                                listView_course_list.setVisibility(View.VISIBLE);
                                int Size = pojoitem.getEmployeeInformation().size();

                                array_course_spinner = new ArrayList<ManageEmployeeCourseInformation>();

                                for(int i =1; i<Size; i++){
                                    ManageEmployeeCourseInformation pojo = new ManageEmployeeCourseInformation();

                                    pojo.setSTREAMID(pojoitem.getEmployeeInformation().get(i).getSTREAMID());
                                    pojo.setSTREAMNAME(pojoitem.getEmployeeInformation().get(i).getSTREAMNAME());
                                    array_course_spinner.add(pojo);

                                }
                                courseAdapter = new ManageEmployeeCourseAdapter(ManageEmployeeCourseAllActivityNew.this,array_course_spinner);
                                listView_course_list.setAdapter(courseAdapter);
                            }else
                            {
//                                no_data.setVisibility(View.VISIBLE);
                                listView_course_list.setVisibility(View.GONE);

                                String DisplayMsg=pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                                Toast.makeText(ManageEmployeeCourseAllActivityNew.this,DisplayMsg,Toast.LENGTH_SHORT).show();
                            }

                        }
                        @Override
                        public void onFailure(Call<ManageEmployeeCoursePojo> call, Throwable t) {
                            Log.e("Failure ",t.getMessage());
                        }
                    });


                    return true;
                }

                public boolean onQueryTextSubmit(String query) {
                    return true;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

}

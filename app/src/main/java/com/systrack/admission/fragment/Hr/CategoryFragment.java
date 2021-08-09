package com.systrack.admission.fragment.Hr;


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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.hrAdapter.CategoryAdapter;
import com.systrack.admission.adapter.hrAdapter.DepartmentAdapter;
import com.systrack.admission.fragment.Hr.HrMenuFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.CategoryInformation;
import com.systrack.admission.pojo.CategoryInformationPojo;
import com.systrack.admission.pojo.CategoryInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    FontAwesomeTextview Prev, Next;
    TextView display_item_count;
    public int NUM_ITEMS_PAGE   = 10;
    public String TOTAL_LIST_ITEMS;
    EditText searchView;
    ListView list_category;
    TransparentProgressDialog mProgressDialog;

    TextView no_data;
    APIInterface apiInterface;

    ArrayList<CategoryInformation> array_category;
    CategoryAdapter categoryAdapter;
    ImageView back_arrow;
    LinearLayout ll_title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_category, container, false);
        final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-Regular.ttf");

        apiInterface= ApiClient.getClient().create(APIInterface.class);

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        ll_title=view.findViewById(R.id.ll_title);
        Prev =  view.findViewById(R.id.txt_prev);
        Next =  view.findViewById(R.id.txt_next);
        display_item_count =  view.findViewById(R.id.display_number);
        display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));
        Prev.setEnabled(false);
        Next.setEnabled(false);

        searchView = (EditText) view.findViewById(R.id.searchView);

        list_category = (ListView)view.findViewById(R.id.list_category);

        no_data = (TextView)view.findViewById(R.id.no_data);

        getCategoryList();


        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                HrMenuFragment coursefragment = new HrMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String total_count_from_API = sharedpreferences.getString("Total_count_category","");
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


                        Call<CategoryInformationPojo> call=apiInterface.GetCategoryList(entity_id,branch_id,display_item_count.getText().toString(),"");

                        call.enqueue(new Callback<CategoryInformationPojo>() {
                            @Override
                            public void onResponse(Call<CategoryInformationPojo> call, Response<CategoryInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                CategoryInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getCategoryInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    list_category.setVisibility(View.VISIBLE);
                                    ll_title.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getCategoryInformation().size();
                                    TOTAL_LIST_ITEMS = response.body().getCategoryInformation().get(1).getTotalCount().toString();

                                    array_category = new ArrayList<CategoryInformation>();

                                    for(int i =1; i<Size; i++){
                                        CategoryInformation pojo = new CategoryInformation();

                                        pojo.setCATEGORYID(pojoitem.getCategoryInformation().get(i).getCATEGORYID());
                                        pojo.setCATEGORYNAME(pojoitem.getCategoryInformation().get(i).getCATEGORYNAME());
                                        pojo.setCATEGORYALIAS(pojoitem.getCategoryInformation().get(i).getCATEGORYALIAS());


                                        array_category.add(pojo);

                                    }
                                    categoryAdapter = new CategoryAdapter(getActivity(),array_category);
                                    list_category.setAdapter(categoryAdapter);
                                    list_category.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);



                                    SharedPreferences.Editor editor = sharedpreferences.edit();
                                    editor.putString("Updated_Total_count_category",TOTAL_LIST_ITEMS);
                                    editor.apply();
                                    editor.commit();
                                    Prev.setEnabled(true);



                                }else
                                {
                                    String DisplayMsg=pojoitem.getCategoryInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<CategoryInformationPojo> call, Throwable t) {
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
                String total_count_from_API = sharedpreferences.getString("Updated_Total_count_category","");
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

                        Call<CategoryInformationPojo> call=apiInterface.GetCategoryList(entity_id,branch_id,display_item_count.getText().toString(),"");

                        call.enqueue(new Callback<CategoryInformationPojo>() {
                            @Override
                            public void onResponse(Call<CategoryInformationPojo> call, Response<CategoryInformationPojo> response) {
                                Log.e("Response  ",new Gson().toJson(response.body()));



                                CategoryInformationPojo pojoitem=response.body();

                                String StatusCode=pojoitem.getCategoryInformation().get(0).getStatusCode();

                                mProgressDialog.dismiss();

                                if(StatusCode.equals("200"))
                                {
                                    no_data.setVisibility(View.GONE);
                                    list_category.setVisibility(View.VISIBLE);
                                    ll_title.setVisibility(View.VISIBLE);
                                    Next.setEnabled(true);
                                    int Size = pojoitem.getCategoryInformation().size();
                                    int totalCount = response.body().getCategoryInformation().get(1).getTotalCount();

                                    array_category = new ArrayList<CategoryInformation>();

                                    for(int i =1; i<Size; i++){
                                        CategoryInformation pojo = new CategoryInformation();

                                        pojo.setCATEGORYID(pojoitem.getCategoryInformation().get(i).getCATEGORYID());
                                        pojo.setCATEGORYNAME(pojoitem.getCategoryInformation().get(i).getCATEGORYNAME());
                                        pojo.setCATEGORYALIAS(pojoitem.getCategoryInformation().get(i).getCATEGORYALIAS());

                                        array_category.add(pojo);

                                    }
                                    categoryAdapter = new CategoryAdapter(getActivity(),array_category);
                                    list_category.setAdapter(categoryAdapter);
                                    list_category.setSelection(Integer.valueOf(display_item_count.getText().toString())-10);




                                    Next.setEnabled(true);
//                                    Next.setTextColor(Color.parseColor("#000000"));


                                }else
                                {
                                    String DisplayMsg=pojoitem.getCategoryInformation().get(0).getDisplayMessage();
                                    mProgressDialog.dismiss();
                                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                                }

                            }
                            @Override
                            public void onFailure(Call<CategoryInformationPojo> call, Throwable t) {
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


                Call<CategoryInformationPojo> call=apiInterface.GetCategoryList(entity_id,branch_id,display_item_count.getText().toString(),searchView.getText().toString());

                call.enqueue(new Callback<CategoryInformationPojo>() {
                    @Override
                    public void onResponse(Call<CategoryInformationPojo> call, Response<CategoryInformationPojo> response) {
                        Log.e("Response  ",new Gson().toJson(response.body()));



                        CategoryInformationPojo pojoitem=response.body();

                        String StatusCode=pojoitem.getCategoryInformation().get(0).getStatusCode();

                        mProgressDialog.dismiss();

                        if(StatusCode.equals("200"))
                        {
                            no_data.setVisibility(View.GONE);
                            list_category.setVisibility(View.VISIBLE);
                            ll_title.setVisibility(View.VISIBLE);
                            Next.setEnabled(true);
                            int Size = pojoitem.getCategoryInformation().size();
                            TOTAL_LIST_ITEMS = response.body().getCategoryInformation().get(1).getTotalCount().toString();

                            array_category = new ArrayList<CategoryInformation>();

                            for(int i =1; i<Size; i++){
                                CategoryInformation pojo = new CategoryInformation();

                                pojo.setCATEGORYID(pojoitem.getCategoryInformation().get(i).getCATEGORYID());
                                pojo.setCATEGORYNAME(pojoitem.getCategoryInformation().get(i).getCATEGORYNAME());
                                pojo.setCATEGORYALIAS(pojoitem.getCategoryInformation().get(i).getCATEGORYALIAS());

                                array_category.add(pojo);

                            }
                            categoryAdapter = new CategoryAdapter(getActivity(),array_category);
                            list_category.setAdapter(categoryAdapter);



//                            SharedPreferences.Editor editor = sharedpreferences.edit();
//                            editor.putString("Total_count_designation",Count+"");
//                            editor.apply();
//                            editor.commit();



                        }else
                        {
                            no_data.setVisibility(View.VISIBLE);
                            list_category.setVisibility(View.GONE);
                            ll_title.setVisibility(View.GONE);
                            Next.setEnabled(false);

                            String DisplayMsg=pojoitem.getCategoryInformation().get(0).getDisplayMessage();
                            Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                        }

                    }
                    @Override
                    public void onFailure(Call<CategoryInformationPojo> call, Throwable t) {
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


        Call<CategoryInformationPojo> call=apiInterface.GetCategoryList(entity_id,branch_id,display_item_count.getText().toString(),"");

        call.enqueue(new Callback<CategoryInformationPojo>() {
            @Override
            public void onResponse(Call<CategoryInformationPojo> call, Response<CategoryInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                CategoryInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getCategoryInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    list_category.setVisibility(View.VISIBLE);
                    ll_title.setVisibility(View.VISIBLE);
                    Next.setEnabled(true);
                    int Size = pojoitem.getCategoryInformation().size();
                    TOTAL_LIST_ITEMS= response.body().getCategoryInformation().get(1).getTotalCount().toString();

                    array_category = new ArrayList<CategoryInformation>();

                    for(int i =1; i<Size; i++){
                        CategoryInformation pojo = new CategoryInformation();

                        pojo.setCATEGORYID(pojoitem.getCategoryInformation().get(i).getCATEGORYID());
                        pojo.setCATEGORYNAME(pojoitem.getCategoryInformation().get(i).getCATEGORYNAME());
                        pojo.setCATEGORYALIAS(pojoitem.getCategoryInformation().get(i).getCATEGORYALIAS());

                        array_category.add(pojo);

                    }
                    categoryAdapter = new CategoryAdapter(getActivity(),array_category);
                    list_category.setAdapter(categoryAdapter);



                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Total_count_category",TOTAL_LIST_ITEMS);
                    editor.apply();
                    editor.commit();



                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    list_category.setVisibility(View.GONE);
                    ll_title.setVisibility(View.GONE);
                    Next.setEnabled(false);

                    String DisplayMsg=pojoitem.getCategoryInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<CategoryInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }

}

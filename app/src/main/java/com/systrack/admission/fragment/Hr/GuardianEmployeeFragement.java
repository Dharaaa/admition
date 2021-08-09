package com.systrack.admission.fragment.Hr;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.pojo.ManageEmployeeInformationPojo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuardianEmployeeFragement extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    TextView full_name,relation,qualification,occupation,total_income,mobile_no,phone_no,email,office_address,home_address;


    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_employee_guardian_tab, container, false);
        final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-Regular.ttf");

        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        t1=view.findViewById(R.id.t1);   t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);   t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);   t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);   t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);   t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);   t6.setTypeface(typeface_semibold);
        t7=view.findViewById(R.id.t7);   t7.setTypeface(typeface_semibold);
        t8=view.findViewById(R.id.t8);   t8.setTypeface(typeface_semibold);
        t9=view.findViewById(R.id.t9);   t9.setTypeface(typeface_semibold);
        t10 =view.findViewById(R.id.t10);   t10.setTypeface(typeface_semibold);


        full_name=view.findViewById(R.id.full_name);
        relation=view.findViewById(R.id.relation);
        qualification=view.findViewById(R.id.qualification);
        occupation=view.findViewById(R.id.occupation);
        total_income=view.findViewById(R.id.total_income);
        mobile_no=view.findViewById(R.id.mobile_no);
        phone_no=view.findViewById(R.id.phone_no);
        email=view.findViewById(R.id.email);
        office_address=view.findViewById(R.id.office_address);
        home_address=view.findViewById(R.id.home_address);

        qualification.setTypeface(typeface_regular);
        occupation.setTypeface(typeface_regular);
        total_income.setTypeface(typeface_regular);
        mobile_no.setTypeface(typeface_regular);
        phone_no.setTypeface(typeface_regular);
        email.setTypeface(typeface_regular);
        office_address.setTypeface(typeface_regular);
        home_address.setTypeface(typeface_regular);


        relation.setTypeface(typeface_regular);
        full_name.setTypeface(typeface_regular);

getGuardianInfo();


        return view;
    }

    private void getGuardianInfo() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
        Log.e("EmployeeId ",appController.getEmployee_Profile_EmployeeID());


        Call<ManageEmployeeInformationPojo> call=apiInterface.GetEmployeeGuardianInfo(entity_id,branch_id,appController.getEmployee_Profile_EmployeeID());

        call.enqueue(new Callback<ManageEmployeeInformationPojo>() {
            @Override
            public void onResponse(Call<ManageEmployeeInformationPojo> call, Response<ManageEmployeeInformationPojo> response) {
                Log.e("Response  Guardian",new Gson().toJson(response.body()));



                ManageEmployeeInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {

                    String sel_guardian_name,sel_relation,sel_qualification,sel_occupation,sel_total_incom,sel_mob_no,sel_phone_no,sel_email,sel_office_address,sel_home_address;
                    sel_guardian_name=pojoitem.getEmployeeInformation().get(1).getgUARDIANFULLNAME();
                    sel_relation=pojoitem.getEmployeeInformation().get(1).getrELATION();
                    sel_qualification=pojoitem.getEmployeeInformation().get(1).getgUARDIANQUALIFICATION();
                    sel_occupation=pojoitem.getEmployeeInformation().get(1).getoCCUPATION();
                    sel_total_incom=pojoitem.getEmployeeInformation().get(1).gettOTALINCOME();
                    sel_mob_no=pojoitem.getEmployeeInformation().get(1).getgUARDIANMOBILENO();
                    sel_phone_no=pojoitem.getEmployeeInformation().get(1).getgUARDIANPHONENO();
                    sel_email=pojoitem.getEmployeeInformation().get(1).getgUARDIANMAILID();
                    sel_office_address=pojoitem.getEmployeeInformation().get(1).getoFFICEADDRESS();
                    sel_home_address=pojoitem.getEmployeeInformation().get(1).gethOMEADDRESS();

//                    if(sel_guardian_name == null){
//                        full_name.setText("");
//                    }else {
//                        full_name.setText(sel_guardian_name);
//                    }
                    if(!(sel_guardian_name==null)){
                        full_name.setText(sel_guardian_name);
                    }
                    if(!(sel_relation==null)){
                        relation.setText(sel_relation);
                    }
                    if(!(sel_qualification==null)){
                        qualification.setText(sel_qualification);
                    }
                    if(!(sel_occupation==null)){
                        occupation.setText(sel_occupation);
                    }
                    if(!(sel_total_incom==null)){
                        total_income.setText(sel_total_incom);
                    }
                    if(!(sel_mob_no==null)){
                        mobile_no.setText(sel_mob_no);
                    }
                    if(!(sel_phone_no==null)){
                        phone_no.setText(sel_phone_no);
                    }
                    if(!(sel_email==null)){
                        email.setText(sel_email);
                    }
                    if(!(sel_office_address==null)){
                        office_address.setText(sel_office_address);
                    }
                        if(!(sel_home_address==null)){
                        home_address.setText(sel_home_address);
                    }


                }else
                {
                    String DisplayMsg=pojoitem.getEmployeeInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<ManageEmployeeInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }

    public static boolean isEmptyString(String text) {
        return (text == null || text.trim().equals("null") || TextUtils.isEmpty(text));
    }

}

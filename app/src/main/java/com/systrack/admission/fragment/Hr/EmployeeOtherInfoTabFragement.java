package com.systrack.admission.fragment.Hr;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.pojo.ManageEmployeeInformationPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EmployeeOtherInfoTabFragement extends Fragment {


    SharedPreferences sharedpreferences;
    AppController appController;
    APIInterface apiInterface;

    TransparentProgressDialog mProgressDialog;

TextView t1,t2,t3,t4,t5,t6,t7,t8;
TextView attendance_card_id,account_no,mother_name,reference,specialization,language,hobbies,qualification;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragement_employee_otherinfo_tab, container, false);
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        apiInterface= ApiClient.getClient().create(APIInterface.class);

        appController = (AppController) getActivity().getApplicationContext();


        final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-Regular.ttf");

        t1=view.findViewById(R.id.t1);   t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);   t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);   t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);   t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);   t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);   t6.setTypeface(typeface_semibold);
        t7=view.findViewById(R.id.t7);   t7.setTypeface(typeface_semibold);
        t8=view.findViewById(R.id.t8);   t8.setTypeface(typeface_semibold);

        TextView attendance_card_id,account_no,mother_name,reference,specialization,language,hobbies,qualification;
        attendance_card_id=view.findViewById(R.id.attendance_card_id);
        account_no=view.findViewById(R.id.account_no);
        mother_name=view.findViewById(R.id.mother_name);
        reference=view.findViewById(R.id.reference);
        specialization=view.findViewById(R.id.specialization);
        language=view.findViewById(R.id.language);

        hobbies=view.findViewById(R.id.hobbies);
        qualification=view.findViewById(R.id.qualification);

        attendance_card_id.setTypeface(typeface_regular);
        account_no.setTypeface(typeface_regular);
        mother_name.setTypeface(typeface_regular);
        reference.setTypeface(typeface_regular);
        specialization.setTypeface(typeface_regular);
        language.setTypeface(typeface_regular);
        hobbies.setTypeface(typeface_regular);
        qualification.setTypeface(typeface_regular);


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


        Call<ManageEmployeeInformationPojo> call=apiInterface.GetEmployeeOtherInfo(entity_id,branch_id,appController.getEmployee_Profile_EmployeeID());

        call.enqueue(new Callback<ManageEmployeeInformationPojo>() {
            @Override
            public void onResponse(Call<ManageEmployeeInformationPojo> call, Response<ManageEmployeeInformationPojo> response) {
                Log.e("Response  Guardian",new Gson().toJson(response.body()));



                ManageEmployeeInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {

                    String sel_card_id,sel_acc_no,sel_mother_name,sel_reference,selspecialisation,sel_lang,sel_hobbies,sel_qualification,sel_office_address,sel_home_address;
                    sel_card_id=pojoitem.getEmployeeInformation().get(1).getATTENDANCECARDID();
                    sel_acc_no=pojoitem.getEmployeeInformation().get(1).getBANKACCOUNTNO();
                    sel_mother_name=pojoitem.getEmployeeInformation().get(1).getMOTHERNAME();
                    sel_reference=pojoitem.getEmployeeInformation().get(1).getREFERENCE();
                    selspecialisation=pojoitem.getEmployeeInformation().get(1).getSPECIALIZATION();
                    sel_lang=pojoitem.getEmployeeInformation().get(1).getLANGUAGES();
                    sel_hobbies=pojoitem.getEmployeeInformation().get(1).getHOBBIES();
                    sel_qualification=pojoitem.getEmployeeInformation().get(1).getqUALIFICATION();

//                    if(sel_card_id == null){
//                        full_name.setText("");
//                    }else {
//                        full_name.setText(sel_card_id);
//                    }
                    if(!(sel_card_id==null)){
                        attendance_card_id.setText(sel_card_id);
                    }
                    if(!(sel_acc_no==null)){
                        account_no.setText(sel_acc_no);
                    }
                    if(!(sel_mother_name==null)){
                        mother_name.setText(sel_mother_name);
                    }
                    if(!(sel_reference==null)){
                        reference.setText(sel_reference);
                    }
                    if(!(selspecialisation==null)){
                        specialization.setText(selspecialisation);
                    }
                    if(!(sel_lang==null)){
                        language.setText(sel_lang);
                    }
                    if(!(sel_hobbies==null)){
                        hobbies.setText(sel_hobbies);
                    }
                    if(!(sel_qualification==null)){
                        qualification.setText(sel_qualification);
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




}

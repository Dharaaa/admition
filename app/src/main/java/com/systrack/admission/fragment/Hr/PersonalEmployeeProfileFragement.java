package com.systrack.admission.fragment.Hr;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.hrAdapter.CategoryAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.CategoryInformation;
import com.systrack.admission.pojo.CategoryInformationPojo;
import com.systrack.admission.pojo.ManageEmployeeInformationPojo;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalEmployeeProfileFragement extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    Map<String,String> params;
    AppController appController;

    DatePickerDialog picker;
    String default_month,default_date,default_year,date_birth_employee_str,joining_date_str;

    Switch switch_gender,switch_notify,switch_status,switch_manager,switch_attendance,switch_allow_login;
    String select_marital_status,select_region,select_experiance,select_blood_group,selected_course,selected_medium,selected_department,
            selected_designation,selected_category,selected_address,selected_role,selected_email,selected_mobileNo;

    TextView employee_no,surname,firstname,lastname,name_alias,date_birth_employee,email_add,mobile_no,region,marital_status,experiance,blood_group,offer_salary,joining_date,
            course_name,medium,department,designation,category,address,sel_role;

    String selected_employeeNo,selected_surname,selected_firstname,selected_lastname, selected_gender,
            selected_name_alias,selected_joining_date,selected_offer_salary;

    String EMPTIMETABLETYPE,shared_short_date;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_employee_personal_tab, container, false);
        final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-Regular.ttf");

        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPTIMETABLETYPE=sharedpreferences.getString(getString(R.string.EMPTIMETABLETYPE),"0");
        shared_short_date=sharedpreferences.getString(getString(R.string.short_display_date),"dd/MM/yyyy");


        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");

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
        t11=view.findViewById(R.id.t11);   t11.setTypeface(typeface_semibold);
        t12=view.findViewById(R.id.t12);   t12.setTypeface(typeface_semibold);
        t13=view.findViewById(R.id.t13);   t13.setTypeface(typeface_semibold);
        t14=view.findViewById(R.id.t14);   t14.setTypeface(typeface_semibold);
        t15=view.findViewById(R.id.t15);   t15.setTypeface(typeface_semibold);
        t16=view.findViewById(R.id.t16);   t16.setTypeface(typeface_semibold);
        t17=view.findViewById(R.id.t17);   t17.setTypeface(typeface_semibold);
        t18=view.findViewById(R.id.t18);   t18.setTypeface(typeface_semibold);
        t19=view.findViewById(R.id.t19);   t19.setTypeface(typeface_semibold);
        t25=view.findViewById(R.id.t25);   t25.setTypeface(typeface_semibold);
        t20=view.findViewById(R.id.t20);   t20.setTypeface(typeface_semibold);
        t21=view.findViewById(R.id.t21);   t21.setTypeface(typeface_semibold);
        t22=view.findViewById(R.id.t22);   t22.setTypeface(typeface_semibold);
        t23=view.findViewById(R.id.t23);   t23.setTypeface(typeface_semibold);
        t24=view.findViewById(R.id.t24);   t24.setTypeface(typeface_semibold);
        t26=view.findViewById(R.id.t26);   t26.setTypeface(typeface_semibold);
        t27=view.findViewById(R.id.t27);   t27.setTypeface(typeface_semibold);
        t28=view.findViewById(R.id.t28);   t28.setTypeface(typeface_semibold);



        employee_no=view.findViewById(R.id.employee_no);          employee_no.setTypeface(typeface_regular);
        surname=view.findViewById(R.id.surname);                  surname.setTypeface(typeface_regular);
        firstname=view.findViewById(R.id.firstname);              firstname.setTypeface(typeface_regular);
        lastname=view.findViewById(R.id.lastname);                lastname.setTypeface(typeface_regular);
        name_alias=view.findViewById(R.id.name_alias);            name_alias.setTypeface(typeface_regular);
        date_birth_employee=view.findViewById(R.id.date_birth_employee);   date_birth_employee.setTypeface(typeface_regular);
        email_add=view.findViewById(R.id.email_add);              email_add.setTypeface(typeface_regular);
        mobile_no=view.findViewById(R.id.mobile_no);              mobile_no.setTypeface(typeface_regular);
        region=view.findViewById(R.id.region);                    region.setTypeface(typeface_regular);
        marital_status=view.findViewById(R.id.marital_status);    marital_status.setTypeface(typeface_regular);
        experiance=view.findViewById(R.id.experiance);            experiance.setTypeface(typeface_regular);
        blood_group=view.findViewById(R.id.blood_group);          blood_group.setTypeface(typeface_regular);
        offer_salary=view.findViewById(R.id.offer_salary);        offer_salary.setTypeface(typeface_regular);
        joining_date=view.findViewById(R.id.joining_date);        joining_date.setTypeface(typeface_regular);
        course_name=view.findViewById(R.id.course_name);          course_name.setTypeface(typeface_regular);
        medium=view.findViewById(R.id.medium);                    medium.setTypeface(typeface_regular);
        department=view.findViewById(R.id.department);            department.setTypeface(typeface_regular);
        designation=view.findViewById(R.id.designation);          designation.setTypeface(typeface_regular);
        category=view.findViewById(R.id.category);                category.setTypeface(typeface_regular);
        address=view.findViewById(R.id.address);                  address.setTypeface(typeface_regular);
        sel_role=view.findViewById(R.id.sel_role);                      sel_role.setTypeface(typeface_regular);


        switch_gender=view.findViewById(R.id.switch_gender);
        switch_notify=view.findViewById(R.id.switch_notify);
        switch_status=view.findViewById(R.id.switch_status);
        switch_manager=view.findViewById(R.id.switch_manager);
        switch_attendance=view.findViewById(R.id.switch_attendance);
        switch_allow_login=view.findViewById(R.id.switch_allow_login);


        getEmpPersonalInfo();



        return view;
    }
    private void getEmpPersonalInfo() {

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


        Call<ManageEmployeeInformationPojo> call=apiInterface.GetEmployeePersonalInfo(entity_id,branch_id,appController.getEmployee_Profile_EmployeeID());

        call.enqueue(new Callback<ManageEmployeeInformationPojo>() {
            @Override
            public void onResponse(Call<ManageEmployeeInformationPojo> call, Response<ManageEmployeeInformationPojo> response) {
                Log.e("Response  personal",new Gson().toJson(response.body()));



                ManageEmployeeInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getEmployeeInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                 selected_employeeNo=pojoitem.getEmployeeInformation().get(1).getEMPLOYEENO();
                    selected_surname=pojoitem.getEmployeeInformation().get(1).getLASTNAME();
                    selected_firstname=pojoitem.getEmployeeInformation().get(1).getFIRSTNAME();
                    selected_lastname=pojoitem.getEmployeeInformation().get(1).getMIDDLENAME();
                    selected_gender=pojoitem.getEmployeeInformation().get(1).getGENDER();
                    selected_name_alias=pojoitem.getEmployeeInformation().get(1).getNAMEALIAS();
                    date_birth_employee_str=pojoitem.getEmployeeInformation().get(1).getDOB();
                    select_region=pojoitem.getEmployeeInformation().get(1).getRELIGION();
                    select_marital_status=pojoitem.getEmployeeInformation().get(1).getMARITALSTATUS();
                    select_experiance=pojoitem.getEmployeeInformation().get(1).geteXPERIENCEREPORT();
                    select_blood_group=pojoitem.getEmployeeInformation().get(1).getBLLODGROUP();
                    selected_offer_salary=pojoitem.getEmployeeInformation().get(1).getOFFERSALARY().toString();
                    selected_joining_date=pojoitem.getEmployeeInformation().get(1).getJOININGDATE();
                    selected_course=pojoitem.getEmployeeInformation().get(1).getsTREAMNAME();
                    selected_medium=pojoitem.getEmployeeInformation().get(1).getmEDIUM();
                    selected_department=pojoitem.getEmployeeInformation().get(1).getDEPARTMENTNAME();
                    selected_designation=pojoitem.getEmployeeInformation().get(1).getDESIGNATIONNAME();
                    selected_category=pojoitem.getEmployeeInformation().get(1).getCATEGORYNAME();
                    selected_address=pojoitem.getEmployeeInformation().get(1).getEMPADDRESS();
                    selected_role=pojoitem.getEmployeeInformation().get(1).getnAME();
                    boolean isNotifyAttandance=pojoitem.getEmployeeInformation().get(1).isiSNOTIFYATTENDANCE();
                    String empStatus =pojoitem.getEmployeeInformation().get(1).getEMPLOYEESTATUS();
                    boolean isManager=pojoitem.getEmployeeInformation().get(1).getISMANAGER();
                    selected_email=pojoitem.getEmployeeInformation().get(1).getEMAIL();
                    selected_mobileNo=pojoitem.getEmployeeInformation().get(1).getMOBILE();

                    Log.e("date birth ",date_birth_employee_str);
                    Log.e("date birth ",selected_joining_date);


employee_no.setText(selected_employeeNo);
surname.setText(selected_surname);
firstname.setText(selected_firstname);
lastname.setText(selected_lastname);
if(!(selected_name_alias==null)){
    name_alias.setText(selected_name_alias);
}

Log.e("religion ",select_region +"**");
                    Log.e("Blood group ",select_blood_group +"*");

                    if(!(date_birth_employee_str==null)){
//                        date_birth_employee.setText(date_birth_employee_str);
                        date_birth_employee.setText(appController.ConvertDate(date_birth_employee_str,"MM-dd-yyyy",shared_short_date));

                    }

                    if(!(selected_email==null)){
                        email_add.setText(selected_email);

                    }
                    if(!(selected_mobileNo==null)){
                        mobile_no.setText(selected_mobileNo);

                    }
                    if(!(select_region==null)){
                    if(select_region.equals("--- Select Religion ---")){
                        region.setText("Not set");
                    }else {
                        region.setText(select_region);
                    }}
                    if(!(select_marital_status==null)){
                        marital_status.setText(select_marital_status);
                    }
                    if(!(select_experiance==null)){
                        experiance.setText(select_experiance);
                    }
                    if(!(select_blood_group==null)){
                        if(select_blood_group.equals("Select")){
                        blood_group.setText("Not set");
                    }else{
                        blood_group.setText(select_blood_group);
                    }}
                    if(!(selected_offer_salary==null)){
                        offer_salary.setText(selected_offer_salary);
                    }
                    if(!(selected_joining_date==null)){
//                        joining_date.setText(selected_joining_date);
                        joining_date.setText(appController.ConvertDate(selected_joining_date,"MM-dd-yyyy",shared_short_date));

                    }
                    if(!(selected_course==null)){
                        course_name.setText(selected_course);
                    }
                    if(!(selected_medium==null)){
                    medium.setText(selected_medium);
                }
                    if(!(selected_department==null)){
                    department.setText(selected_department);
                }if(!(selected_designation==null)){
                    designation.setText(selected_designation);
                }
                    if(!(selected_category==null)){
                        category.setText(selected_category);
                    }if(!(selected_address==null)){
                    address.setText(selected_address);
                }if(!(selected_role==null)){
                    sel_role.setText(selected_role);
                }

switch_gender.setClickable(false);
                    switch_notify.setClickable(false);
                    switch_status.setClickable(false);
                    switch_manager.setClickable(false);
                    switch_attendance.setClickable(false);
if(selected_gender.equals("Male")){
    switch_gender.setChecked(true);
}else{
    switch_gender.setChecked(false);
}
if(isNotifyAttandance){
    switch_notify.setChecked(true);
}else{
    switch_notify.setChecked(false);
}
if(empStatus.equals("Active")){
    switch_status.setChecked(true);
}else{
    switch_status.setChecked(false);
}
if(isManager){
    switch_manager.setChecked(true);
}else {
    switch_manager.setChecked(false);
}
if(EMPTIMETABLETYPE.equals("1")){
    switch_attendance.setChecked(true);
}else {
    switch_attendance.setChecked(false);
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

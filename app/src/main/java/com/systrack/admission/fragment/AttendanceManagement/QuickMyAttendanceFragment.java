package com.systrack.admission.fragment.AttendanceManagement;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeDepartmentActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.AttendanceMgtAdapter.MonthlyAttendanceAdapter;
import com.systrack.admission.adapter.hrAdapter.CategoryAdapter;
import com.systrack.admission.pojo.CategoryInformation;
import com.systrack.admission.pojo.CategoryInformationPojo;
import com.systrack.admission.pojo.EmployeeAttendanceInformation;
import com.systrack.admission.pojo.EmployeeAttendanceInformationPojo;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuickMyAttendanceFragment extends Fragment {


    View view;
LinearLayout search_employee;
    EditText course_edittext,medium_edittext,department_edittext,date_edittext;
    AppController appController;
    TextView no_data;
    ImageView back_arrow;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;
    SharedPreferences sharedpreferences;
ListView listView;
String EMPLOYEEID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_my_attendance, container, false);
        appController = (AppController) getActivity().getApplicationContext();
        apiInterface= ApiClient.getClient().create(APIInterface.class);

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        EMPLOYEEID = sharedpreferences.getString(getString(R.string.EMPLOYEEID), "0");

        listView=view.findViewById(R.id.list_my_attendance);
        no_data=view.findViewById(R.id.no_data);
        date_edittext=view.findViewById(R.id.date_edittext);
        date_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                        int myYear = year;
                        int myday = dayOfMonth;
                        int myMonth = monthOfYear+1;
                        Calendar c = Calendar.getInstance();
//                        appController.setManageAttendanceDate(myMonth+"/"+myday+"/"+myYear);
                        date_edittext.setText(myMonth+"/"+myYear);
                        getAttendanceList();
                    }
                },year, month,day);
                datePickerDialog.show();
            }
        });




        return view;
    }

    private void getAttendanceList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");


        Call<EmployeeAttendanceInformationPojo> call=apiInterface.GetEmployeeMonthlyAttendanceForEmployee(entity_id,branch_id,EMPLOYEEID,date_edittext.getText().toString(),
                appController.getCurrentAcademicYear());

        call.enqueue(new Callback<EmployeeAttendanceInformationPojo>() {
            @Override
            public void onResponse(Call<EmployeeAttendanceInformationPojo> call, Response<EmployeeAttendanceInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                EmployeeAttendanceInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getEmployeeAttendanceInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    int Size = pojoitem.getEmployeeAttendanceInformation().size();

                ArrayList<EmployeeAttendanceInformation>    arrayList = new ArrayList<EmployeeAttendanceInformation>();

                    for(int i =1; i<Size; i++){
                        EmployeeAttendanceInformation pojo = new EmployeeAttendanceInformation();

                        pojo.setEMPLOYEEID(pojoitem.getEmployeeAttendanceInformation().get(i).getEMPLOYEEID());
                        pojo.setFULLNAME(pojoitem.getEmployeeAttendanceInformation().get(i).getFULLNAME());
                        pojo.setDATEARRAY(pojoitem.getEmployeeAttendanceInformation().get(i).getDATEARRAY());

                        arrayList.add(pojo);

                    }
                    String DateArray = arrayList.get(0).getDATEARRAY();
                    appController.setDateArray_Api(DateArray);


//                        appController.setMyAttendance_DateArray(DateArray);

                    String[] split_array = DateArray.split("\\,");
//                        appController.setMy_attendance_splitQuick(split_array);

                    appController.setMonthly_attendance_Array(split_array);


                    MonthlyAttendanceAdapter categoryAdapter = new MonthlyAttendanceAdapter(getActivity(),arrayList);
                    listView.setAdapter(categoryAdapter);






                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);

                    String DisplayMsg=pojoitem.getEmployeeAttendanceInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<EmployeeAttendanceInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

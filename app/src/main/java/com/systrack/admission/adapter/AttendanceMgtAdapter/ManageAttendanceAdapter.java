package com.systrack.admission.adapter.AttendanceMgtAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.AppController;
import com.systrack.admission.EmployeeProfileActivity;
import com.systrack.admission.R;
import com.systrack.admission.pojo.EmployeeAttendanceInformation;
import com.systrack.admission.pojo.ManageEmployeeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ManageAttendanceAdapter extends BaseAdapter {
    ArrayList<EmployeeAttendanceInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;

    TextView date,employee_name,attendance,attendance_remark;
    TextView t1,t2,t3,t4,t5,t6,t7;
    String ROLEID;
    public ManageAttendanceAdapter(Context context, ArrayList<EmployeeAttendanceInformation> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(final int i, View convertview, ViewGroup viewGroup) {
        inflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.item_manage_attendance,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        TextView date,employee_name,attendance,attendance_remark;

        date= (TextView)view.findViewById(R.id.date);
        employee_name = (TextView)view.findViewById(R.id.employee_name);
        attendance = (TextView)view.findViewById(R.id.attendance);
        attendance_remark = (TextView)view.findViewById(R.id.attendance_remark);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);

//        if(arrayList.get(i).getEMPLOYEESTATUS().equals("Active")){
//            status_employee.setBackgroundColor(Color.parseColor("#5cb85c"));
//
//        }else{
//            status_employee.setBackgroundColor(Color.parseColor("#d9534f"));
//
//        }






        date.setTypeface(typeface_regular);
        employee_name.setTypeface(typeface_regular);
        attendance.setTypeface(typeface_regular);
        attendance_remark.setTypeface(typeface_regular);

        date.setText(arrayList.get(i).getEMPATTDATE());
        employee_name.setText(arrayList.get(i).getFULLNAME());
        attendance.setText(arrayList.get(i).getPRESENTREMARK());
        attendance_remark.setText(arrayList.get(i).getABSENTREMARK());


        if(arrayList.get(i).getABSENTREMARK()==null){
            attendance_remark.setText("Not Set");
            attendance_remark.setTextColor(Color.RED);
            attendance_remark.setTypeface(null, Typeface.ITALIC);
        }
        if(arrayList.get(i).getPRESENTREMARK().equals("A")){
            attendance.setTextColor(Color.RED);

        }else if(arrayList.get(i).getPRESENTREMARK().equals("H")){
            attendance.setTextColor(Color.BLUE);

        }else if(arrayList.get(i).getPRESENTREMARK().equals("P")){
            attendance.setTextColor(Color.GREEN);

        }



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

package com.systrack.admission.adapter;

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
import com.systrack.admission.pojo.ManageEmployeeInformation;
import com.systrack.admission.pojo.StudentInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ManageStudentAdapter extends BaseAdapter {
    ArrayList<StudentInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView admission_no,student_name,gender,mobile,birth_date,user_name;
    TextView t1,t2,t3,t4,t5,t6;
    String ROLEID;
    public ManageStudentAdapter(Context context, ArrayList<StudentInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_manage_student,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        admission_no= (TextView)view.findViewById(R.id.admission_no);
        student_name = (TextView)view.findViewById(R.id.student_name);
        gender = (TextView)view.findViewById(R.id.gender);
        mobile = (TextView)view.findViewById(R.id.mobile);
        birth_date = (TextView)view.findViewById(R.id.birth_date);
        user_name = (TextView)view.findViewById(R.id.user_name);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);        t6.setTypeface(typeface_semibold);



        admission_no.setTypeface(typeface_regular);
        student_name.setTypeface(typeface_regular);
        gender.setTypeface(typeface_regular);
        mobile.setTypeface(typeface_regular);
        birth_date.setTypeface(typeface_regular);
        user_name.setTypeface(typeface_regular);

        admission_no.setText(arrayList.get(i).getSTUDENTNO()+"");
        student_name.setText(arrayList.get(i).getSTUDENTNAME());
        gender.setText(arrayList.get(i).getGENDER());
        mobile.setText(arrayList.get(i).getMOBILENO());
        birth_date.setText(arrayList.get(i).getDATEOFBIRTH());
        user_name.setText(arrayList.get(i).getUSERNAME());



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

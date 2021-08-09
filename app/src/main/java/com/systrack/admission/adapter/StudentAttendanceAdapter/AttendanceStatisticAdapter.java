package com.systrack.admission.adapter.StudentAttendanceAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.AppController;
import com.systrack.admission.EmployeeProfileActivity;
import com.systrack.admission.R;
import com.systrack.admission.pojo.AttendanceStatisticInformation;
import com.systrack.admission.pojo.ManageEmployeeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class AttendanceStatisticAdapter extends BaseAdapter {
    ArrayList<AttendanceStatisticInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;

    TextView student_no,student_name,lecture,present,percentage;
    TextView t1,t2,t3,t4,t5;

    public AttendanceStatisticAdapter(Context context, ArrayList<AttendanceStatisticInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_attedance_statistic,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        student_no= (TextView)view.findViewById(R.id.student_no);
        student_name = (TextView)view.findViewById(R.id.student_name);
        lecture = (TextView)view.findViewById(R.id.lecture);
        present = (TextView)view.findViewById(R.id.present);
        percentage = (TextView)view.findViewById(R.id.percentage);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t1);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t1);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t1);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t1);        t5.setTypeface(typeface_semibold);

        student_no.setTypeface(typeface_regular);
        student_name.setTypeface(typeface_regular);
        lecture.setTypeface(typeface_regular);
        present.setTypeface(typeface_regular);
        percentage.setTypeface(typeface_regular);

        student_no.setText(arrayList.get(i).getSTUDENTNO());
        student_name.setText(arrayList.get(i).getSTUDENTNAME());
        lecture.setText(arrayList.get(i).getTotalLecture()+"");
        present.setText(arrayList.get(i).getPresentLecture()+"");
        percentage.setText(arrayList.get(i).getAverage()+"");



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

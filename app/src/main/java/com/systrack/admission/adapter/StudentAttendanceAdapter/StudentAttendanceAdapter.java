package com.systrack.admission.adapter.StudentAttendanceAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.pojo.AttendanceStatisticInformation;
import com.systrack.admission.pojo.StudentAttendanceInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class StudentAttendanceAdapter extends BaseAdapter {
    ArrayList<StudentAttendanceInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;

    TextView student_no,student_name,date,attendance,absent_remark;
    TextView t1,t2,t3,t4,t5;

    public StudentAttendanceAdapter(Context context, ArrayList<StudentAttendanceInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_student_attendance,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        student_no= (TextView)view.findViewById(R.id.student_no);
        student_name = (TextView)view.findViewById(R.id.student_name);
        date = (TextView)view.findViewById(R.id.date);
        attendance = (TextView)view.findViewById(R.id.attendance);
        absent_remark = (TextView)view.findViewById(R.id.absent_remark);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t1);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t1);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t1);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t1);        t5.setTypeface(typeface_semibold);

        student_no.setTypeface(typeface_regular);
        student_name.setTypeface(typeface_regular);
        date.setTypeface(typeface_regular);
        attendance.setTypeface(typeface_regular);
        absent_remark.setTypeface(typeface_regular);

        student_no.setText(arrayList.get(i).getSTUDENTNO());
        student_name.setText(arrayList.get(i).getFULLNAME());
        date.setText(arrayList.get(i).getDate()+"");
        attendance.setText(arrayList.get(i).getPA()+"");
        absent_remark.setText(arrayList.get(i).getABSENTREMARK()+"");

        if(arrayList.get(i).getABSENTREMARK()==null){
            absent_remark.setText("Not Set");
            absent_remark.setTextColor(Color.RED);
            absent_remark.setTypeface(null, Typeface.ITALIC);
        }

        if(arrayList.get(i).getPA().equals("A")){
            attendance.setBackgroundColor(Color.RED);
        }else{
            attendance.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

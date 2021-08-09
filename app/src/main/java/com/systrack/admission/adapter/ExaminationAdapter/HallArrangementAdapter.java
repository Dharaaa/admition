package com.systrack.admission.adapter.ExaminationAdapter;

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
import com.systrack.admission.pojo.HallArrangementStudentInformation;
import com.systrack.admission.pojo.ManageEmployeeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class HallArrangementAdapter extends BaseAdapter {
    ArrayList<HallArrangementStudentInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;

    TextView tv_hall_no,tv_examTime,tv_supervisor,tv_total_seat,tv_allocated_sear;
    TextView t1,t2,t3,t4,t5;
    String ROLEID;
    public HallArrangementAdapter(Context context, ArrayList<HallArrangementStudentInformation > arrayList){
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
        final View view = inflater.inflate(R.layout.item_hall_arrangement,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        tv_hall_no= (TextView)view.findViewById(R.id.tv_hall_no);
        tv_examTime = (TextView)view.findViewById(R.id.tv_examTime);
        tv_supervisor = (TextView)view.findViewById(R.id.tv_supervisor);
        tv_total_seat = (TextView)view.findViewById(R.id.tv_total_seat);
        tv_allocated_sear = (TextView)view.findViewById(R.id.tv_allocated_sear);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);




        tv_hall_no.setTypeface(typeface_regular);
        tv_examTime.setTypeface(typeface_regular);
        tv_supervisor.setTypeface(typeface_regular);
        tv_allocated_sear.setTypeface(typeface_regular);
        tv_total_seat.setTypeface(typeface_regular);

        tv_hall_no.setText(arrayList.get(i).gethALLNO());
        tv_examTime.setText(arrayList.get(i).getdISPLAYEXAMTIME());
        tv_supervisor.setText(arrayList.get(i).getsUPERVISORNAME());
        tv_total_seat.setText(arrayList.get(i).getsEATCAPACITY()+"");
        tv_allocated_sear.setText(arrayList.get(i).getaLLOCATEDSEAT()+"");



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

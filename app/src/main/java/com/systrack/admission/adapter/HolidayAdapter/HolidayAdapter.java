package com.systrack.admission.adapter.HolidayAdapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import com.systrack.admission.pojo.HolidayInformation;
import com.systrack.admission.pojo.ManageEmployeeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class HolidayAdapter extends BaseAdapter {
    ArrayList<HolidayInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;

    TextView name,date,remark,status;
    TextView t1,t2,t3,t4;

    public HolidayAdapter(Context context, ArrayList<HolidayInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_holiday,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();



        name= (TextView)view.findViewById(R.id.name);
        date = (TextView)view.findViewById(R.id.date);
        remark = (TextView)view.findViewById(R.id.remark);
        status = (TextView)view.findViewById(R.id.status);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t1);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t1);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t1);        t4.setTypeface(typeface_semibold);

        name.setTypeface(typeface_regular);
        date.setTypeface(typeface_regular);
        remark.setTypeface(typeface_regular);
        status.setTypeface(typeface_regular);

        name.setText(arrayList.get(i).getHOLIDAYNAME());
        date.setText(arrayList.get(i).getDISPLAYHOLIDAYDATEDDMMMYYYY());
        remark.setText(arrayList.get(i).getREMARKS());
        status.setText(arrayList.get(i).getDISPLAYSTATUS());

        if(arrayList.get(i).getDISPLAYSTATUS().equals("Active")){
            status.setBackgroundColor(Color.parseColor("#5cb85c"));
        }else{
            status.setBackgroundColor(Color.parseColor("#d9534f"));

        }

        if(arrayList.get(i).getREMARKS().equals("")){
            remark.setText("Not Set");
            remark.setTextColor(Color.RED);
            remark.setTypeface(null, Typeface.ITALIC);
        }



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

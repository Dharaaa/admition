package com.systrack.admission.adapter.TimeTableAdapter;

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
import com.systrack.admission.pojo.ClassTimingInformation;
import com.systrack.admission.pojo.ManageEmployeeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ClassTimingAdapter extends BaseAdapter {
    ArrayList<ClassTimingInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;

    TextView tv_name,tv_start_time,tv_end_time,tv_is_break;
    TextView t1,t2,t3,t4,t5,t6,t7;

    public ClassTimingAdapter(Context context, ArrayList<ClassTimingInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_class_timing,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        tv_name= (TextView)view.findViewById(R.id.tv_name);
        tv_start_time = (TextView)view.findViewById(R.id.tv_start_time);
        tv_end_time = (TextView)view.findViewById(R.id.tv_end_time);
        tv_is_break = (TextView)view.findViewById(R.id.tv_is_break);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t1);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t1);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t1);        t4.setTypeface(typeface_semibold);


        tv_name.setTypeface(typeface_regular);
        tv_start_time.setTypeface(typeface_regular);
        tv_end_time.setTypeface(typeface_regular);
        tv_is_break.setTypeface(typeface_regular);

        tv_name.setText(arrayList.get(i).getNAME());
        tv_start_time.setText(arrayList.get(i).getSTARTTIME());
        tv_end_time.setText(arrayList.get(i).getENDTIME());
        tv_is_break.setText(arrayList.get(i).getISBREAK());

        if(arrayList.get(i).getISBREAK().equals("No")){
            tv_is_break.setBackgroundColor(Color.parseColor("#d9534f"));
        }
        if(arrayList.get(i).getISBREAK().equals("Yes")){
            tv_is_break.setBackgroundColor(Color.parseColor("#5cb85c"));
        }


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

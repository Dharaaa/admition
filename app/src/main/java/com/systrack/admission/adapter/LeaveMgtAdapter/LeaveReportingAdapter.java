package com.systrack.admission.adapter.LeaveMgtAdapter;

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
import com.systrack.admission.pojo.LeaveDurationInformation;
import com.systrack.admission.pojo.LeaveReportInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class LeaveReportingAdapter extends BaseAdapter {
    ArrayList<LeaveReportInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView employee_no,designation,employee_name,mobile_no,manager,manager_designation;
    TextView t1,t2,t3,t4,t5,t6;

    public LeaveReportingAdapter(Context context, ArrayList<LeaveReportInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_leave_reporting,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        employee_no= (TextView)view.findViewById(R.id.employee_no);
        designation = (TextView)view.findViewById(R.id.designation);
        employee_name = (TextView)view.findViewById(R.id.employee_name);
        mobile_no = (TextView)view.findViewById(R.id.mobile_no);
        manager = (TextView)view.findViewById(R.id.manager);
        manager_designation = (TextView)view.findViewById(R.id.manager_designation);




        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);        t6.setTypeface(typeface_semibold);


        employee_no.setTypeface(typeface_regular);
        designation.setTypeface(typeface_regular);
        employee_name.setTypeface(typeface_regular);
        mobile_no.setTypeface(typeface_regular);
        manager.setTypeface(typeface_regular);
        manager_designation.setTypeface(typeface_regular);




        employee_no.setText(arrayList.get(i).getEMPLOYEENO());
        designation.setText(arrayList.get(i).getDESIGNATIONNAME());
        employee_name.setText(arrayList.get(i).getFULLNAME());
        mobile_no.setText(arrayList.get(i).getMOBILE());
        manager.setText(arrayList.get(i).getREPORTINGEMPNAME());
        manager_designation.setText(arrayList.get(i).getMANAGERDESNAME());


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

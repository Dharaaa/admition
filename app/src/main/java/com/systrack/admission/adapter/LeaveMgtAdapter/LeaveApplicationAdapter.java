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
import com.systrack.admission.pojo.LeaveInformation;
import com.systrack.admission.pojo.LeaveReportInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class LeaveApplicationAdapter extends BaseAdapter {
    ArrayList<LeaveInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView leave_date,employee_name,duration,leave_type,start_date,end_date,days,status;
    TextView t1,t2,t3,t4,t5,t6,t7,t8;

    public LeaveApplicationAdapter(Context context, ArrayList<LeaveInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_leave_application,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        leave_date= (TextView)view.findViewById(R.id.leave_date);
        duration = (TextView)view.findViewById(R.id.duration);
        employee_name = (TextView)view.findViewById(R.id.employee_name);
        leave_type = (TextView)view.findViewById(R.id.leave_type);
        start_date = (TextView)view.findViewById(R.id.start_date);
        end_date = (TextView)view.findViewById(R.id.end_date);
        days = (TextView)view.findViewById(R.id.days);
        status = (TextView)view.findViewById(R.id.status);




        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);        t6.setTypeface(typeface_semibold);
        t7=view.findViewById(R.id.t7);        t7.setTypeface(typeface_semibold);
        t8=view.findViewById(R.id.t8);        t8.setTypeface(typeface_semibold);



        leave_date.setTypeface(typeface_regular);
        duration.setTypeface(typeface_regular);
        employee_name.setTypeface(typeface_regular);
        leave_type.setTypeface(typeface_regular);
        start_date.setTypeface(typeface_regular);
        end_date.setTypeface(typeface_regular);
        days.setTypeface(typeface_regular);
        status.setTypeface(typeface_regular);





        leave_date.setText(arrayList.get(i).getDLEAVETAKENDATE());
        duration.setText(arrayList.get(i).getDURATIONNAME());
        employee_name.setText(arrayList.get(i).getEMPNAME());
        leave_type.setText(arrayList.get(i).getLEAVETYPENAME());
        start_date.setText(arrayList.get(i).getDSTARTDATE());
        end_date.setText(arrayList.get(i).getDENDDATE());
        days.setText(arrayList.get(i).getLEAVEDAYS()+"");
        status.setText(arrayList.get(i).getSTATUS());

        if(status.getText().equals("Pending")){

            status.setBackgroundColor(Color.parseColor("#337ab7"));
        }else if(status.getText().toString().equals("Approved")){
            status.setBackgroundColor(Color.parseColor("#5cb85c"));

        }else if(status.getText().toString().equals("Reject")){
            status.setBackgroundColor(Color.parseColor("#d9534f"));

        }



        return view;

    }
}

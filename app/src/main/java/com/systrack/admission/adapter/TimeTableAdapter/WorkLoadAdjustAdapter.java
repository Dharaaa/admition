package com.systrack.admission.adapter.TimeTableAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.LeaveManagement.ViewLeaveApplicationFragment;
import com.systrack.admission.fragment.TimeTable.ViewTimeTableWorkLoadAdjustFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.LeaveApplicationInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class WorkLoadAdjustAdapter extends BaseAdapter {
    ArrayList<LeaveApplicationInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView leave_date,leave_duration,leave_type,start_date,end_date,days,status;
    TextView t1,t2,t3,t4,t5,t6,t7;
    FontAwesomeTextview view_leave_application;
    LinearLayout ll_icon;
    public WorkLoadAdjustAdapter(Context context, ArrayList<LeaveApplicationInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_workload_adjust,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
       String shared_short_date=sharedpreferences.getString(context.getString(R.string.short_display_date),"dd/MM/yyyy");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        leave_date= (TextView)view.findViewById(R.id.leave_date);
        leave_duration = (TextView)view.findViewById(R.id.leave_duration);
        leave_type = (TextView)view.findViewById(R.id.leave_type);
        start_date=view.findViewById(R.id.start_date);
        end_date=view.findViewById(R.id.end_date);
        days=view.findViewById(R.id.days);
        status=view.findViewById(R.id.status);
        view_leave_application=view.findViewById(R.id.view_leave_application);
        ll_icon=view.findViewById(R.id.ll_icon);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);        t6.setTypeface(typeface_semibold);
        t7=view.findViewById(R.id.t7);        t7.setTypeface(typeface_semibold);



        leave_date.setTypeface(typeface_regular);
        leave_duration.setTypeface(typeface_regular);
        leave_type.setTypeface(typeface_regular);
        start_date.setTypeface(typeface_regular);
        end_date.setTypeface(typeface_regular);
        days.setTypeface(typeface_regular);
        status.setTypeface(typeface_regular);



        leave_date.setText(arrayList.get(i).getLEAVEDATE());
        leave_duration.setText(arrayList.get(i).getDURATIONNAME());
        leave_type.setText(arrayList.get(i).getLEAVETYPENAME());
//        start_date.setText(arrayList.get(i).getSTARTDATE());
//        end_date.setText(arrayList.get(i).getENDDATE());
        days.setText(arrayList.get(i).getLEAVEDAYS()+"");
        status.setText(arrayList.get(i).getLEAVESTATUS());

        start_date.setText(appController.ConvertDate(arrayList.get(i).getSTARTDATE(),"dd/MM/yyyy",shared_short_date));
        end_date.setText(appController.ConvertDate(arrayList.get(i).getENDDATE(),"dd/MM/yyyy",shared_short_date));


        if(status.getText().equals("Pending")){

            status.setBackgroundColor(Color.parseColor("#337ab7"));
        }else if(status.getText().toString().equals("Approved")){
            status.setBackgroundColor(Color.parseColor("#5cb85c"));


        }else if(status.getText().toString().equals("Reject")){
            status.setBackgroundColor(Color.parseColor("#d9534f"));
            ll_icon.setVisibility(View.GONE);

        }
        view_leave_application.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appController.setSelect_workloadAdjust_startDate(arrayList.get(i).getdISPLAYSTARTDATE());
                appController.setSelect_workloadAdjust_endDate(arrayList.get(i).getdISPLAYENDDATE());



//
                ViewTimeTableWorkLoadAdjustFragment leaveapplication = new ViewTimeTableWorkLoadAdjustFragment();
                FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,leaveapplication);
                transaction.commit();

            }
        });

//        if(arrayList.get(i).getLEAVETYPEDETAIL().equals("")){
//            0detail.setText("Not Set");
//            detail.setTextColor(Color.RED);
//            detail.setTypeface(null, Typeface.ITALIC);
//        }


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

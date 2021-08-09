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
import com.systrack.admission.pojo.LeaveTypeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class LeaveDurationAdapter extends BaseAdapter {
    ArrayList<LeaveDurationInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView leave_name,start_date,end_date,status;
    TextView t1,t2,t3,t4;

    public LeaveDurationAdapter(Context context, ArrayList<LeaveDurationInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_leave_duration,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        TextView leave_name,start_date,end_date,status;

        leave_name= (TextView)view.findViewById(R.id.leave_name);
        start_date = (TextView)view.findViewById(R.id.start_date);
        end_date = (TextView)view.findViewById(R.id.end_date);
        status = (TextView)view.findViewById(R.id.status);


        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t3);        t4.setTypeface(typeface_semibold);

        leave_name.setTypeface(typeface_regular);
        start_date.setTypeface(typeface_regular);
        end_date.setTypeface(typeface_regular);
        status.setTypeface(typeface_regular);


        leave_name.setText(arrayList.get(i).getDURATIONNAME());
        start_date.setText(arrayList.get(i).getDISPLAYSTARTDATE());
        end_date.setText(arrayList.get(i).getDISPLAYENDDATE());
        status.setText(arrayList.get(i).getLEAVESTATUS());

        if(arrayList.get(i).getLEAVESTATUS().equals("Active")){
            status.setBackgroundColor(Color.parseColor("#5cb85c"));
        }else{
            status.setBackgroundColor(Color.parseColor("#d9534f"));

        }
//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

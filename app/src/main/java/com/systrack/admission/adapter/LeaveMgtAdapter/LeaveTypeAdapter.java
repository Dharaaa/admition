package com.systrack.admission.adapter.LeaveMgtAdapter;

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
import com.systrack.admission.pojo.LeaveTypeInformation;
import com.systrack.admission.pojo.ManageEmployeeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class LeaveTypeAdapter extends BaseAdapter {
    ArrayList<LeaveTypeInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView leave_name,detail,eligible;
    TextView t1,t2,t3;

    public LeaveTypeAdapter(Context context, ArrayList<LeaveTypeInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_leave_type,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        leave_name= (TextView)view.findViewById(R.id.leave_name);
        detail = (TextView)view.findViewById(R.id.detail);
        eligible = (TextView)view.findViewById(R.id.eligible);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t1);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t1);        t3.setTypeface(typeface_semibold);

        leave_name.setTypeface(typeface_regular);
        detail.setTypeface(typeface_regular);
        eligible.setTypeface(typeface_regular);

        leave_name.setText(arrayList.get(i).getLEAVETYPENAME());
        detail.setText(arrayList.get(i).getLEAVETYPEDETAIL());
        eligible.setText(arrayList.get(i).getGENDER());

        if(arrayList.get(i).getLEAVETYPEDETAIL().equals("")){
            detail.setText("Not Set");
            detail.setTextColor(Color.RED);
            detail.setTypeface(null, Typeface.ITALIC);
        }


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

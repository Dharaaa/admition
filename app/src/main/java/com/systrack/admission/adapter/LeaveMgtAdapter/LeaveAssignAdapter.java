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
import com.systrack.admission.pojo.LeaveAssignInformation;
import com.systrack.admission.pojo.LeaveTypeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class LeaveAssignAdapter extends BaseAdapter {
    ArrayList<LeaveAssignInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView employee_no,employee_name,mobile_no,designation,leave_duration;
    TextView t1,t2,t3,t4,t5;

    public LeaveAssignAdapter(Context context, ArrayList<LeaveAssignInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_leave_assign,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        employee_no= (TextView)view.findViewById(R.id.employee_no);
        employee_name = (TextView)view.findViewById(R.id.employee_name);
        mobile_no = (TextView)view.findViewById(R.id.mobile_no);
        designation=view.findViewById(R.id.designation);
        leave_duration=view.findViewById(R.id.leave_duration);


        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);


        employee_no.setTypeface(typeface_regular);
        employee_name.setTypeface(typeface_regular);
        mobile_no.setTypeface(typeface_regular);
        designation.setTypeface(typeface_regular);
        leave_duration.setTypeface(typeface_regular);


        employee_no.setText(arrayList.get(i).getEMPLOYEENO());
        employee_name.setText(arrayList.get(i).getFULLNAME());
        mobile_no.setText(arrayList.get(i).getMOBILE());
        designation.setText(arrayList.get(i).getDESIGNATIONNAME());
        leave_duration.setText(arrayList.get(i).getDURATIONNAME());


//        if(arrayList.get(i).getLEAVETYPEDETAIL().equals("")){
//            detail.setText("Not Set");
//            detail.setTextColor(Color.RED);
//            detail.setTypeface(null, Typeface.ITALIC);
//        }


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

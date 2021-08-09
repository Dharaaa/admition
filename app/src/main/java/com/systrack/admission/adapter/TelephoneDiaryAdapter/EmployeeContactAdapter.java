package com.systrack.admission.adapter.TelephoneDiaryAdapter;

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
import com.systrack.admission.pojo.EmployeeContactInformation;
import com.systrack.admission.pojo.ManageEmployeeInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class EmployeeContactAdapter extends BaseAdapter {
    ArrayList<EmployeeContactInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView employee_no,employee_name,mobile_no,email,department_name,designation_name;
    TextView t1,t2,t3,t4,t5,t6;
    String ROLEID;
    public EmployeeContactAdapter(Context context, ArrayList<EmployeeContactInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_employee_contact,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        employee_no= (TextView)view.findViewById(R.id.employee_no);
        employee_name = (TextView)view.findViewById(R.id.employee_name);
        mobile_no = (TextView)view.findViewById(R.id.mobile_no);
        email = (TextView)view.findViewById(R.id.email);
        department_name = (TextView)view.findViewById(R.id.department_name);
        designation_name = (TextView)view.findViewById(R.id.designation_name);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);        t6.setTypeface(typeface_semibold);




        employee_no.setTypeface(typeface_regular);
        employee_name.setTypeface(typeface_regular);
        mobile_no.setTypeface(typeface_regular);
        email.setTypeface(typeface_regular);
        department_name.setTypeface(typeface_regular);
        designation_name.setTypeface(typeface_regular);

        employee_no.setText(arrayList.get(i).getEMPLOYEENO());
        employee_name.setText(arrayList.get(i).getFULLNAME());
        mobile_no.setText(arrayList.get(i).getMOBILE());
        email.setText(arrayList.get(i).getEMAIL());
        designation_name.setText(arrayList.get(i).getDESIGNATIONNAME());
        department_name.setText(arrayList.get(i).getDEPARTMENTNAME());



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

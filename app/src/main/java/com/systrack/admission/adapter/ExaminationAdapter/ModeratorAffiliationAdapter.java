package com.systrack.admission.adapter.ExaminationAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.pojo.HallArrangementStudentInformation;
import com.systrack.admission.pojo.ModeratorAffiliationInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ModeratorAffiliationAdapter extends BaseAdapter {
    ArrayList<ModeratorAffiliationInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView tv_subject_name,tv_emp_name;
    AppController appController;

    TextView t1,t2;
    String ROLEID;
    public ModeratorAffiliationAdapter(Context context, ArrayList<ModeratorAffiliationInformation > arrayList){
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
        final View view = inflater.inflate(R.layout.item_moderator_affiliation,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        tv_emp_name= (TextView)view.findViewById(R.id.tv_emp_name);
        tv_subject_name = (TextView)view.findViewById(R.id.tv_subject_name);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);

        tv_emp_name.setTypeface(typeface_regular);
        tv_subject_name.setTypeface(typeface_regular);

        tv_emp_name.setText(arrayList.get(i).getEMPLOYEENAME());
        tv_subject_name.setText(arrayList.get(i).getSUBJECTNAME());



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

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
import com.systrack.admission.pojo.GenerateMarksheetInformation;
import com.systrack.admission.pojo.ModeratorAffiliationInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class GenerateMarksheetAdapter extends BaseAdapter {
    ArrayList<GenerateMarksheetInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView no,tv_student_name,tv_total_mark,tv_obtain_mark;
    AppController appController;

    TextView t1,t2,t3,t4;
    String ROLEID;
    public GenerateMarksheetAdapter(Context context, ArrayList<GenerateMarksheetInformation > arrayList){
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
        final View view = inflater.inflate(R.layout.item_generate_marksheet,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();



        no= (TextView)view.findViewById(R.id.no);
        tv_student_name = (TextView)view.findViewById(R.id.tv_student_name);
        tv_total_mark = (TextView)view.findViewById(R.id.tv_total_mark);
        tv_obtain_mark = (TextView)view.findViewById(R.id.tv_obtain_mark);


        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t2);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t2);        t4.setTypeface(typeface_semibold);


        no.setTypeface(typeface_regular);
        tv_student_name.setTypeface(typeface_regular);
        tv_total_mark.setTypeface(typeface_regular);
        tv_obtain_mark.setTypeface(typeface_regular);


        no.setText(arrayList.get(i).getSTUDENTNO());
        tv_student_name.setText(arrayList.get(i).getSTUDENTNAME());
        tv_total_mark.setText(arrayList.get(i).getTOTALMARKS());
        tv_obtain_mark.setText(arrayList.get(i).getOBTAINMARKS());




//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

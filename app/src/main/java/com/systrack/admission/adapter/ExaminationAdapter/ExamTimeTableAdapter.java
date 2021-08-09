package com.systrack.admission.adapter.ExaminationAdapter;

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
import com.systrack.admission.pojo.ExamMasterInformation;
import com.systrack.admission.pojo.ExamTimeTableInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ExamTimeTableAdapter extends BaseAdapter {
    ArrayList<ExamTimeTableInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;

    TextView name,tv_endDate,tv_startDate;
    TextView t1,t2,t3;
    String ROLEID;
    public ExamTimeTableAdapter(Context context, ArrayList<ExamTimeTableInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_exam_time_table,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        name= (TextView)view.findViewById(R.id.name);
        tv_endDate = (TextView)view.findViewById(R.id.tv_endDate);
        tv_startDate = (TextView)view.findViewById(R.id.tv_startDate);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);


        name.setTypeface(typeface_regular);
        tv_endDate.setTypeface(typeface_regular);
        tv_startDate.setTypeface(typeface_regular);

        name.setText(arrayList.get(i).getEXAMNAME());
        tv_startDate.setText(arrayList.get(i).getMINDATE());
        tv_endDate.setText(arrayList.get(i).getMAXDATE());


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

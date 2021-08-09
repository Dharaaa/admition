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

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class StudentListAdapter extends BaseAdapter {
    ArrayList<HallArrangementStudentInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView tv_student_no,tv_name,tv_batch_nm,tv_section_nm;
    TextView t1,t2,t3,t4;
    String ROLEID;
    public StudentListAdapter(Context context, ArrayList<HallArrangementStudentInformation > arrayList){
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
        final View view = inflater.inflate(R.layout.item_student_list,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        TextView tv_student_no,tv_name,tv_batch_nm,tv_section_nm;

        tv_student_no= (TextView)view.findViewById(R.id.tv_student_no);
        tv_name = (TextView)view.findViewById(R.id.tv_name);
        tv_batch_nm = (TextView)view.findViewById(R.id.tv_batch_nm);
        tv_section_nm = (TextView)view.findViewById(R.id.tv_section_nm);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);




        tv_student_no.setTypeface(typeface_regular);
        tv_name.setTypeface(typeface_regular);
        tv_batch_nm.setTypeface(typeface_regular);
        tv_section_nm.setTypeface(typeface_regular);

        tv_student_no.setText(arrayList.get(i).getSTUDENTNO());
        tv_name.setText(arrayList.get(i).getSTUDENTNAME());
        tv_batch_nm.setText(arrayList.get(i).getBATCHNAME());
        tv_section_nm.setText(arrayList.get(i).getSECTIONNAME()+"");



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

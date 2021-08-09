package com.systrack.admission.adapter.CourseMgtAdapter;

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
import com.systrack.admission.pojo.SubjectAllocationInformation;
import com.systrack.admission.pojo.TeacherAllocationInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class SubjectAllocationAdapter extends BaseAdapter {
    ArrayList<SubjectAllocationInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView subject_name,emp_name,batch_name;
    AppController appController;

    TextView t1,t2,t3;

    public SubjectAllocationAdapter(Context context, ArrayList<SubjectAllocationInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_subject_allocation,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();



        subject_name= (TextView)view.findViewById(R.id.subject_name);
        emp_name = (TextView)view.findViewById(R.id.emp_name);
        batch_name = (TextView)view.findViewById(R.id.batch_name);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t1);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t1);        t3.setTypeface(typeface_semibold);

        subject_name.setTypeface(typeface_regular);
        emp_name.setTypeface(typeface_regular);
        batch_name.setTypeface(typeface_regular);

        subject_name.setText(arrayList.get(i).getSUBJECTNAME());
        emp_name.setText(arrayList.get(i).getFULLNAME());
        batch_name.setText(arrayList.get(i).getBATCHNAME());






//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

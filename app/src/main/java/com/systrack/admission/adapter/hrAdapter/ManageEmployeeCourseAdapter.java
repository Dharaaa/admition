package com.systrack.admission.adapter.hrAdapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.pojo.ManageEmployeeCourseInformation;


import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ManageEmployeeCourseAdapter extends BaseAdapter {

    ArrayList<ManageEmployeeCourseInformation> array_course_spinner;
    Context context;
    LayoutInflater inflater;
    TextView spinner_item_academic;

    public ManageEmployeeCourseAdapter(Context context, ArrayList<ManageEmployeeCourseInformation> array_course_spinner){
        this.context = context;
        this.array_course_spinner = array_course_spinner;
    }


    @Override
    public int getCount() {
        return array_course_spinner.size();
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
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        inflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_course,viewGroup,false);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        spinner_item_academic = (TextView)view.findViewById(R.id.spinner_item_country);
        spinner_item_academic.setTypeface(typeface_regular);
        spinner_item_academic.setText(array_course_spinner.get(i).getSTREAMNAME());

        return view;
    }
}

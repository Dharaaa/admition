package com.systrack.admission.adapter.TimeTableAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.pojo.TimeTableInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DayOfWeekAdapter extends BaseAdapter {

    ArrayList<TimeTableInformation> array_days;
    Context context;

    LayoutInflater inflater;
    SharedPreferences sharedpreferences;
    TextView spinner_item_academic;


    public DayOfWeekAdapter(Context context, ArrayList<TimeTableInformation> array_days){
        this.context = context;
        this.array_days = array_days;
    }

    @Override
    public int getCount() {
        return array_days.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.spinner,parent,false);


        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        spinner_item_academic = (TextView)view.findViewById(R.id.txt_name);
        spinner_item_academic.setText(array_days.get(position).getDAYNAME());
        spinner_item_academic.setTypeface(typeface_regular);


        return view;
    }
}

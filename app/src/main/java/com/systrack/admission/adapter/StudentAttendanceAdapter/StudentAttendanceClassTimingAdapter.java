package com.systrack.admission.adapter.StudentAttendanceAdapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.pojo.ClassTimingInformation;
import com.systrack.admission.pojo.StudentAttendanceInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class StudentAttendanceClassTimingAdapter extends BaseAdapter {

    ArrayList<ClassTimingInformation> arrayList;
    Context context;
    LayoutInflater inflater;
    TextView name;

    public StudentAttendanceClassTimingAdapter(Context context, ArrayList<ClassTimingInformation> arrayList){
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
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        inflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_course,viewGroup,false);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        name = (TextView)view.findViewById(R.id.spinner_item_country);
        name.setTypeface(typeface_regular);
        name.setText(arrayList.get(i).getClassTiming());

        return view;
    }
}

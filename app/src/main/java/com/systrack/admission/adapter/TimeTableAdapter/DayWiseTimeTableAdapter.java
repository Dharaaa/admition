package com.systrack.admission.adapter.TimeTableAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.TimeTable.ViewTimeTableWorkLoadAdjustFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.LeaveApplicationInformation;
import com.systrack.admission.pojo.TimeTableInformation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DayWiseTimeTableAdapter extends BaseAdapter {
    ArrayList<TimeTableInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView type,subject_name,section_name,batch_name,class_timing,division;
    TextView t1,t2,t3,t4,t5,t6;
    FontAwesomeTextview view_leave_application;
    LinearLayout ll_division,ll_line_division;
    public DayWiseTimeTableAdapter(Context context, ArrayList<TimeTableInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_daywise_timetable,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        boolean  ISALLOWDIVISION = sharedpreferences.getBoolean(context.getString(R.string.ISALLOWDIVISION), false);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        type= (TextView)view.findViewById(R.id.type);
        subject_name = (TextView)view.findViewById(R.id.subject_name);
        section_name = (TextView)view.findViewById(R.id.section_name);
        batch_name=view.findViewById(R.id.batch_name);
        class_timing=view.findViewById(R.id.class_timing);
        division=view.findViewById(R.id.division);
        ll_division=view.findViewById(R.id.ll_division);
        ll_line_division=view.findViewById(R.id.ll_line_division);

        if(ISALLOWDIVISION){
            ll_division.setVisibility(View.VISIBLE);
            ll_line_division.setVisibility(View.VISIBLE);
        }else {
            ll_division.setVisibility(View.GONE);
            ll_line_division.setVisibility(View.GONE);
        }

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t5);        t6.setTypeface(typeface_semibold);



        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        SimpleDateFormat sdfs = new SimpleDateFormat("hh:mm a");
String startTime=arrayList.get(i).getSTARTTIME();
String endTime=arrayList.get(i).getENDTIME();
Log.e("StartTime ",startTime + " ** "+endTime);

Date dStartTime,dEndTime;
        try {
//                        dt = sdf.parse(time);
//                        Log.e("Time get ",time);
            dStartTime=sdf.parse(startTime);
            dEndTime=sdf.parse(endTime);


//                        Log.e("Time Display: " , sdfs.format(dt)); // <-- I got result here
//                        Log.e("Start Time ", sdfs.format(dtStart));
//                        Log.e("End Time ", sdfs.format(dtEnd));

            class_timing.setText(sdfs.format(dStartTime) + " - "+sdfs.format(dEndTime));


        } catch (ParseException e) {
            e.printStackTrace();
        }








        type.setTypeface(typeface_regular);
        subject_name.setTypeface(typeface_regular);
        section_name.setTypeface(typeface_regular);
        batch_name.setTypeface(typeface_regular);
        class_timing.setTypeface(typeface_regular);
        division.setTypeface(typeface_regular);



        type.setText(arrayList.get(i).getEMPROOMLABTYPE());
        subject_name.setText(arrayList.get(i).getSUBJECTNAME());
        section_name.setText(arrayList.get(i).getSECTIONID());
        batch_name.setText(arrayList.get(i).getBATCHNAME());
//        class_timing.setText(arrayList.get(i).getCLASSTIMING());
        division.setText(arrayList.get(i).getDIVISIONNAME());

//        if(arrayList.get(i).getLEAVETYPEDETAIL().equals("")){
//            0detail.setText("Not Set");
//            detail.setTextColor(Color.RED);
//            detail.setTypeface(null, Typeface.ITALIC);
//        }


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

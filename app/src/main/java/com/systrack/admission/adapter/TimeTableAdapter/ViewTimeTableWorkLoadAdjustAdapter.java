package com.systrack.admission.adapter.TimeTableAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.LeaveApplicationInformation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ViewTimeTableWorkLoadAdjustAdapter extends BaseAdapter {

    ArrayList<LeaveApplicationInformation> array_load_balancing;

    Context context;
    LayoutInflater inflater;
    private String blockCharacterSet = "~#^|$%&*!@0123456789_;-:";
    TextView error;
    SharedPreferences sharedpreferences;
    Map<String,String> params;
    AppController appController;

    Date date1,date2;

    TextView date,day,time,batch_name,section_name,subject_name,div_name,type,assign_lecture,assign_subject;

    FontAwesomeTextview timetable_exchange,reset_timetable;
    String Current_LeaveDurationID,current_LeaveDurationNAme,LeaveAssignedEmplyeeNAme;

    String LeaveAssignedEMplyeeID;
    Spinner subject_spinner,employee_spinner;
    ImageView close;
    EditText subject_edittext;


    LinearLayout assign_btn_lecture;
    String BatchID, SectionID;
    String formattedMonth,formattedDayOfMonth,TodayDate,shared_short_date;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;

    public ViewTimeTableWorkLoadAdjustAdapter(Context context, ArrayList<LeaveApplicationInformation> array_load_balancing ){

        this.context = context;
        this.array_load_balancing = array_load_balancing;
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        shared_short_date=sharedpreferences.getString(context.getString(R.string.short_display_date),"dd/MM/yyyy");


    }


    @Override
    public int getCount() {
        return array_load_balancing.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        inflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.item_view_timetable_workload,parent,false);


        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");




        final Typeface font_icon = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");
        appController = (AppController)context.getApplicationContext();

        final Calendar cldr = Calendar.getInstance();
        int day_calender = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH) + 1;
        int year = cldr.get(Calendar.YEAR);


        t1=(TextView)  view.findViewById(R.id.t1); t1.setTypeface(typeface_semibold);
        t2=(TextView)  view.findViewById(R.id.t2); t2.setTypeface(typeface_semibold);
        t3=(TextView)  view.findViewById(R.id.t3); t3.setTypeface(typeface_semibold);
        t4=(TextView)  view.findViewById(R.id.t4); t4.setTypeface(typeface_semibold);
        t5=(TextView)  view.findViewById(R.id.t5); t5.setTypeface(typeface_semibold);
        t6=(TextView)  view.findViewById(R.id.t6); t6.setTypeface(typeface_semibold);
        t7=(TextView)  view.findViewById(R.id.t7); t7.setTypeface(typeface_semibold);
        t8=(TextView)  view.findViewById(R.id.t8); t8.setTypeface(typeface_semibold);
        t9=(TextView)  view.findViewById(R.id.t9); t9.setTypeface(typeface_semibold);
        t10=(TextView)  view.findViewById(R.id.t10); t10.setTypeface(typeface_semibold);
        LinearLayout ll_division = view.findViewById(R.id.ll_division);


        String isAllowDiv =  String.valueOf(sharedpreferences.getBoolean(context.getString(R.string.ISALLOWDIVISION), false));

        if(isAllowDiv.equals("true")){
            ll_division.setVisibility(View.VISIBLE);
        }else{
            ll_division.setVisibility(View.GONE);
        }
        date = (TextView)view.findViewById(R.id.date);
        day = (TextView)view.findViewById(R.id.day);
        time = (TextView)view.findViewById(R.id.time);
        batch_name = (TextView)view.findViewById(R.id.batch_name);
        section_name = (TextView)view.findViewById(R.id.section_name);
        subject_name = (TextView)view.findViewById(R.id.subject_name);
        div_name = (TextView)view.findViewById(R.id.div_name);
        type = (TextView)view.findViewById(R.id.type);
        assign_lecture = (TextView)view.findViewById(R.id.assign_lecture);
        assign_subject = (TextView)view.findViewById(R.id.assign_subject);

        date.setTypeface(typeface_regular);
        day.setTypeface(typeface_regular);
        time.setTypeface(typeface_regular);
        batch_name.setTypeface(typeface_regular);
        section_name.setTypeface(typeface_regular);
        subject_name.setTypeface(typeface_regular);
        div_name.setTypeface(typeface_regular);
        type.setTypeface(typeface_regular);
        assign_lecture.setTypeface(typeface_regular);
        assign_subject.setTypeface(typeface_regular);



//        date.setText(array_load_balancing.get(position).getdISPLAYDATE());
        date.setText(appController.ConvertDate(array_load_balancing.get(position).getdISPLAYDATE(),"MM/dd/yyyy",shared_short_date));

        day.setText(array_load_balancing.get(position).getwEEKDAY());
        time.setText(array_load_balancing.get(position).getdISPLAYSTARTTIME());
        batch_name.setText(array_load_balancing.get(position).getBATCHNAME());
        section_name.setText(array_load_balancing.get(position).getSECTIONID());
        subject_name.setText(array_load_balancing.get(position).getSUBJECTNAME());
        if(array_load_balancing.get(position).getDIVISIONNAME()!=null){
        div_name.setText(array_load_balancing.get(position).getDIVISIONNAME());}
        type.setText(array_load_balancing.get(position).getEMPROOMLABTYPE());


        if(array_load_balancing.get(position).getEMPFULLNAME()==null) {
            assign_lecture.setText("Not Set");
            assign_lecture.setTextColor(Color.RED);
            assign_lecture.setTypeface(null, Typeface.ITALIC);
        }else{
            assign_lecture.setText(array_load_balancing.get(position).getEMPFULLNAME());
        }



//        timetable_exchange = (FontAwesomeTextview)view.findViewById(R.id.timetable_exchange);
//        reset_timetable = (FontAwesomeTextview)view.findViewById(R.id.reset_timetable);
//
//        timetable_exchange.setTypeface(font_icon);
//        reset_timetable.setTypeface(font_icon);



        if(array_load_balancing.get(position).getSUBNAME()==null){
            assign_subject.setText("Not Set");
            assign_subject.setTextColor(Color.RED);
            assign_subject.setTypeface(null,Typeface.ITALIC);
//            reset_timetable.setEnabled(false);
        }else{

            assign_subject.setText(array_load_balancing.get(position).getSUBNAME());


        }






        return view;
    }


}

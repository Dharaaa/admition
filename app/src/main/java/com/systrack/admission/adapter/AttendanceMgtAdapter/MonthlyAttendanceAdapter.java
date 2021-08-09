package com.systrack.admission.adapter.AttendanceMgtAdapter;

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

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.pojo.EmployeeAttendanceInformation;

import java.util.ArrayList;
import java.util.Map;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class MonthlyAttendanceAdapter extends BaseAdapter {

    ArrayList<EmployeeAttendanceInformation> array_monthly_list;
    Context context;
    LayoutInflater inflater;
    private String blockCharacterSet = "~#^|$%&*!@0123456789_;-:";
    TextView error;
    SharedPreferences sharedpreferences;
    Map<String, String> params;
    AppController appController;

    TextView date,day_calender,attendance_remark,employee_name;

    TextView date1,date2,date3,date4,date5,date6,date7,date8,date9,date10,date11,date12,date13,date14,date15,date16,date17,date18,date19,date20,date21,
            date22,date23,date24,date25,date26,date27,date28,date29,date30,date31;

    TextView day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,
            day24,day25,day26,day27,day28,day29,day30,day31;

    LinearLayout linear1,linear2,linear3,linear4,linear5,linear6,linear7,linear8,linear9,linear10,linear11,linear12,linear13,linear14,linear15,linear16,linear17,
            linear18,linear19,linear20,linear21,linear22,linear23,linear24,linear25,linear26,linear27,linear28,linear29,linear30,linear31;


    TextView attendance_remark1,attendance_remark2,attendance_remark3,attendance_remark4,attendance_remark5,attendance_remark6,attendance_remark7,attendance_remark8,attendance_remark9,
            attendance_remark10,attendance_remark11,attendance_remark12,attendance_remark13,attendance_remark14,attendance_remark15,attendance_remark16,attendance_remark17,
            attendance_remark18,attendance_remark19,attendance_remark20,attendance_remark21,attendance_remark22,attendance_remark23,attendance_remark24,attendance_remark25,
            attendance_remark26,attendance_remark27,attendance_remark28,attendance_remark29,attendance_remark30,attendance_remark31;

    ArrayList<String> dateArrayList=new ArrayList<>();

    public MonthlyAttendanceAdapter(Context context, ArrayList<EmployeeAttendanceInformation> array_monthly_list ){

        this.context = context;
        this.array_monthly_list = array_monthly_list;



    }

    @Override
    public int getCount() {
        return array_monthly_list.size();
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
        final View view = inflater.inflate(R.layout.list_monthly_attendance,parent,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        Typeface font_icon = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");

        appController = (AppController)context.getApplicationContext();

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");


        Log.e(" Adapter " ,"Called " );

//        date = (TextView)view.findViewById(R.id.date);
//        day_calender = (TextView)view.findViewById(R.id.day_calender);
//        attendance_remark = (TextView)view.findViewById(R.id.attendance_remark);
        employee_name = (TextView)view.findViewById(R.id.employee_name);

        linear1= (LinearLayout)view.findViewById(R.id.linear1);
        linear2= (LinearLayout)view.findViewById(R.id.linear2);
        linear3= (LinearLayout)view.findViewById(R.id.linear3);
        linear4= (LinearLayout)view.findViewById(R.id.linear4);
        linear5= (LinearLayout)view.findViewById(R.id.linear5);
        linear6= (LinearLayout)view.findViewById(R.id.linear6);
        linear7= (LinearLayout)view.findViewById(R.id.linear7);
        linear8= (LinearLayout)view.findViewById(R.id.linear8);
        linear9= (LinearLayout)view.findViewById(R.id.linear9);
        linear10= (LinearLayout)view.findViewById(R.id.linear10);
        linear11= (LinearLayout)view.findViewById(R.id.linear11);
        linear12= (LinearLayout)view.findViewById(R.id.linear12);
        linear13= (LinearLayout)view.findViewById(R.id.linear13);
        linear14= (LinearLayout)view.findViewById(R.id.linear14);
        linear15= (LinearLayout)view.findViewById(R.id.linear15);
        linear16= (LinearLayout)view.findViewById(R.id.linear16);
        linear17= (LinearLayout)view.findViewById(R.id.linear17);
        linear18= (LinearLayout)view.findViewById(R.id.linear18);
        linear19= (LinearLayout)view.findViewById(R.id.linear19);
        linear20= (LinearLayout)view.findViewById(R.id.linear20);
        linear21= (LinearLayout)view.findViewById(R.id.linear21);
        linear22= (LinearLayout)view.findViewById(R.id.linear22);
        linear23= (LinearLayout)view.findViewById(R.id.linear23);
        linear24= (LinearLayout)view.findViewById(R.id.linear24);
        linear25= (LinearLayout)view.findViewById(R.id.linear25);
        linear26= (LinearLayout)view.findViewById(R.id.linear26);
        linear27= (LinearLayout)view.findViewById(R.id.linear27);
        linear28= (LinearLayout)view.findViewById(R.id.linear28);
        linear29= (LinearLayout)view.findViewById(R.id.linear29);
        linear30= (LinearLayout)view.findViewById(R.id.linear30);
        linear31= (LinearLayout)view.findViewById(R.id.linear31);



        date1 = (TextView)view.findViewById(R.id.date1);
        date2 = (TextView)view.findViewById(R.id.date2);
        date3 = (TextView)view.findViewById(R.id.date3);
        date4 = (TextView)view.findViewById(R.id.date4);
        date5 = (TextView)view.findViewById(R.id.date5);
        date6 = (TextView)view.findViewById(R.id.date6);
        date7 = (TextView)view.findViewById(R.id.date7);
        date8 = (TextView)view.findViewById(R.id.date8);
        date9 = (TextView)view.findViewById(R.id.date9);
        date10 = (TextView)view.findViewById(R.id.date10);
        date11 = (TextView)view.findViewById(R.id.date11);
        date12 = (TextView)view.findViewById(R.id.date12);
        date13 = (TextView)view.findViewById(R.id.date13);
        date14 = (TextView)view.findViewById(R.id.date14);
        date15 = (TextView)view.findViewById(R.id.date15);
        date16 = (TextView)view.findViewById(R.id.date16);
        date17 = (TextView)view.findViewById(R.id.date17);
        date18 = (TextView)view.findViewById(R.id.date18);
        date19 = (TextView)view.findViewById(R.id.date19);
        date20 = (TextView)view.findViewById(R.id.date20);
        date21 = (TextView)view.findViewById(R.id.date21);
        date22 = (TextView)view.findViewById(R.id.date22);
        date23 = (TextView)view.findViewById(R.id.date23);
        date24 = (TextView)view.findViewById(R.id.date24);
        date25 = (TextView)view.findViewById(R.id.date25);
        date26 = (TextView)view.findViewById(R.id.date26);
        date27 = (TextView)view.findViewById(R.id.date27);
        date28 = (TextView)view.findViewById(R.id.date28);
        date29 = (TextView)view.findViewById(R.id.date29);
        date30 = (TextView)view.findViewById(R.id.date30);
        date31 = (TextView)view.findViewById(R.id.date31);


        day1 = (TextView)view.findViewById(R.id.day1);
        day2 = (TextView)view.findViewById(R.id.day2);
        day3 = (TextView)view.findViewById(R.id.day3);
        day4 = (TextView)view.findViewById(R.id.day4);
        day5 = (TextView)view.findViewById(R.id.day5);
        day6 = (TextView)view.findViewById(R.id.day6);
        day7 = (TextView)view.findViewById(R.id.day7);
        day8 = (TextView)view.findViewById(R.id.day8);
        day9 = (TextView)view.findViewById(R.id.day9);
        day10 = (TextView)view.findViewById(R.id.day10);
        day11 = (TextView)view.findViewById(R.id.day11);
        day12 = (TextView)view.findViewById(R.id.day12);
        day13 = (TextView)view.findViewById(R.id.day13);
        day14 = (TextView)view.findViewById(R.id.day14);
        day15 = (TextView)view.findViewById(R.id.day15);
        day16 = (TextView)view.findViewById(R.id.day16);
        day17 = (TextView)view.findViewById(R.id.day17);
        day18 = (TextView)view.findViewById(R.id.day18);
        day19 = (TextView)view.findViewById(R.id.day19);
        day20 = (TextView)view.findViewById(R.id.day20);
        day21 = (TextView)view.findViewById(R.id.day21);
        day22 = (TextView)view.findViewById(R.id.day22);
        day23 = (TextView)view.findViewById(R.id.day23);
        day24 = (TextView)view.findViewById(R.id.day24);
        day25 = (TextView)view.findViewById(R.id.day25);
        day26 = (TextView)view.findViewById(R.id.day26);
        day27 = (TextView)view.findViewById(R.id.day27);
        day28 = (TextView)view.findViewById(R.id.day28);
        day29 = (TextView)view.findViewById(R.id.day29);
        day30 = (TextView)view.findViewById(R.id.day30);
        day31 = (TextView)view.findViewById(R.id.day31);




        attendance_remark1 = (TextView)view.findViewById(R.id.attendance_remark1);
        attendance_remark2 = (TextView)view.findViewById(R.id.attendance_remark2);
        attendance_remark3 = (TextView)view.findViewById(R.id.attendance_remark3);
        attendance_remark4 = (TextView)view.findViewById(R.id.attendance_remark4);
        attendance_remark5 = (TextView)view.findViewById(R.id.attendance_remark5);
        attendance_remark6 = (TextView)view.findViewById(R.id.attendance_remark6);
        attendance_remark7 = (TextView)view.findViewById(R.id.attendance_remark7);
        attendance_remark8 = (TextView)view.findViewById(R.id.attendance_remark8);
        attendance_remark9 = (TextView)view.findViewById(R.id.attendance_remark9);
        attendance_remark10 = (TextView)view.findViewById(R.id.attendance_remark10);
        attendance_remark11 = (TextView)view.findViewById(R.id.attendance_remark11);
        attendance_remark12 = (TextView)view.findViewById(R.id.attendance_remark12);
        attendance_remark13 = (TextView)view.findViewById(R.id.attendance_remark13);
        attendance_remark14 = (TextView)view.findViewById(R.id.attendance_remark14);
        attendance_remark15 = (TextView)view.findViewById(R.id.attendance_remark15);
        attendance_remark16 = (TextView)view.findViewById(R.id.attendance_remark16);
        attendance_remark17 = (TextView)view.findViewById(R.id.attendance_remark17);
        attendance_remark18 = (TextView)view.findViewById(R.id.attendance_remark18);
        attendance_remark19 = (TextView)view.findViewById(R.id.attendance_remark19);
        attendance_remark20 = (TextView)view.findViewById(R.id.attendance_remark20);
        attendance_remark21 = (TextView)view.findViewById(R.id.attendance_remark21);
        attendance_remark22 = (TextView)view.findViewById(R.id.attendance_remark22);
        attendance_remark23 = (TextView)view.findViewById(R.id.attendance_remark23);
        attendance_remark24 = (TextView)view.findViewById(R.id.attendance_remark24);
        attendance_remark25 = (TextView)view.findViewById(R.id.attendance_remark25);
        attendance_remark26 = (TextView)view.findViewById(R.id.attendance_remark26);
        attendance_remark27 = (TextView)view.findViewById(R.id.attendance_remark27);
        attendance_remark28 = (TextView)view.findViewById(R.id.attendance_remark28);
        attendance_remark29 = (TextView)view.findViewById(R.id.attendance_remark29);
        attendance_remark30 = (TextView)view.findViewById(R.id.attendance_remark30);
        attendance_remark31 = (TextView)view.findViewById(R.id.attendance_remark31);








        date1.setTypeface(typeface_semibold);
        date2.setTypeface(typeface_semibold);
        date3 .setTypeface(typeface_semibold);
        date4.setTypeface(typeface_semibold);
        date5.setTypeface(typeface_semibold);
        date6.setTypeface(typeface_semibold);
        date7.setTypeface(typeface_semibold);
        date8 .setTypeface(typeface_semibold);
        date9 .setTypeface(typeface_semibold);
        date10.setTypeface(typeface_semibold);
        date11.setTypeface(typeface_semibold);
        date12.setTypeface(typeface_semibold);
        date13.setTypeface(typeface_semibold);
        date14.setTypeface(typeface_semibold);
        date15.setTypeface(typeface_semibold);
        date16.setTypeface(typeface_semibold);
        date17.setTypeface(typeface_semibold);
        date18.setTypeface(typeface_semibold);
        date19.setTypeface(typeface_semibold);
        date20.setTypeface(typeface_semibold);
        date21.setTypeface(typeface_semibold);
        date22.setTypeface(typeface_semibold);
        date23.setTypeface(typeface_semibold);
        date24.setTypeface(typeface_semibold);
        date25.setTypeface(typeface_semibold);
        date26.setTypeface(typeface_semibold);
        date27.setTypeface(typeface_semibold);
        date28.setTypeface(typeface_semibold);
        date29.setTypeface(typeface_semibold);
        date30.setTypeface(typeface_semibold);
        date31.setTypeface(typeface_semibold);


        attendance_remark1.setTypeface(typeface_regular);
        attendance_remark2 .setTypeface(typeface_regular);
        attendance_remark3 .setTypeface(typeface_regular);
        attendance_remark4 .setTypeface(typeface_regular);
        attendance_remark5 .setTypeface(typeface_regular);
        attendance_remark6 .setTypeface(typeface_regular);
        attendance_remark7 .setTypeface(typeface_regular);
        attendance_remark8 .setTypeface(typeface_regular);
        attendance_remark9 .setTypeface(typeface_regular);
        attendance_remark10.setTypeface(typeface_regular);
        attendance_remark11.setTypeface(typeface_regular);
        attendance_remark12 .setTypeface(typeface_regular);
        attendance_remark13 .setTypeface(typeface_regular);
        attendance_remark14 .setTypeface(typeface_regular);
        attendance_remark15 .setTypeface(typeface_regular);
        attendance_remark16 .setTypeface(typeface_regular);
        attendance_remark17 .setTypeface(typeface_regular);
        attendance_remark18 .setTypeface(typeface_regular);
        attendance_remark19 .setTypeface(typeface_regular);
        attendance_remark20 .setTypeface(typeface_regular);
        attendance_remark21 .setTypeface(typeface_regular);
        attendance_remark22 .setTypeface(typeface_regular);
        attendance_remark23 .setTypeface(typeface_regular);
        attendance_remark24 .setTypeface(typeface_regular);
        attendance_remark25 .setTypeface(typeface_regular);
        attendance_remark26 .setTypeface(typeface_regular);
        attendance_remark27 .setTypeface(typeface_regular);
        attendance_remark28 .setTypeface(typeface_regular);
        attendance_remark29 .setTypeface(typeface_regular);
        attendance_remark30 .setTypeface(typeface_regular);
        attendance_remark31 .setTypeface(typeface_regular);









        day1.setTypeface(typeface_regular);
        day2 .setTypeface(typeface_regular);
        day3 .setTypeface(typeface_regular);
        day4 .setTypeface(typeface_regular);
        day5 .setTypeface(typeface_regular);
        day6 .setTypeface(typeface_regular);
        day7 .setTypeface(typeface_regular);
        day8 .setTypeface(typeface_regular);
        day9 .setTypeface(typeface_regular);
        day10.setTypeface(typeface_regular);
        day11.setTypeface(typeface_regular);
        day12.setTypeface(typeface_regular);
        day13.setTypeface(typeface_regular);
        day14.setTypeface(typeface_regular);
        day15 .setTypeface(typeface_regular);
        day16 .setTypeface(typeface_regular);
        day17 .setTypeface(typeface_regular);
        day18 .setTypeface(typeface_regular);
        day19 .setTypeface(typeface_regular);
        day20 .setTypeface(typeface_regular);
        day21 .setTypeface(typeface_regular);
        day22 .setTypeface(typeface_regular);
        day23 .setTypeface(typeface_regular);
        day24 .setTypeface(typeface_regular);
        day25 .setTypeface(typeface_regular);
        day26 .setTypeface(typeface_regular);
        day27 .setTypeface(typeface_regular);
        day28 .setTypeface(typeface_regular);
        day29 .setTypeface(typeface_regular);
        day30 .setTypeface(typeface_regular);
        day31 .setTypeface(typeface_regular);

        employee_name.setText(array_monthly_list.get(position).getFULLNAME());
        employee_name.setTypeface(typeface_regular);


       String DateArray= array_monthly_list.get(position).getDATEARRAY();

       String[] split_array = DateArray.split("\\,");
        int size_1 = split_array.length;

        String[] split_array_monthly = DateArray.split("\\,");


        String[] store_Data = split_array_monthly;

        int size = store_Data.length;
        Log.e("Monthly attendance ","Store data size "+store_Data.length);

        ArrayList<String> attnedance = new ArrayList<String>();

        if(size == 30){

            linear31.setVisibility(View.GONE);

            ArrayList<String> Date_array = new ArrayList<String>();
            ArrayList<String> Day_array = new ArrayList<String>();

            for(int j=0; j<split_array.length ;j++){

                String[] date_day = split_array[j].split("\\|");
                Date_array.add(date_day[0]);
                Day_array.add(date_day[1]);

            }


            for(int k=0; k<Date_array.size(); k++){
                date1.setText(Date_array.get(0));
                date2.setText(Date_array.get(1));
                date3.setText(Date_array.get(2));
                date4.setText(Date_array.get(3));
                date5.setText(Date_array.get(4));
                date6.setText(Date_array.get(5));
                date7.setText(Date_array.get(6));
                date8.setText(Date_array.get(7));
                date9.setText(Date_array.get(8));
                date10.setText(Date_array.get(9));
                date11.setText(Date_array.get(10));
                date12.setText(Date_array.get(11));
                date13.setText(Date_array.get(12));
                date14.setText(Date_array.get(13));
                date15.setText(Date_array.get(14));
                date16.setText(Date_array.get(15));
                date17.setText(Date_array.get(16));
                date18.setText(Date_array.get(17));
                date19.setText(Date_array.get(18));
                date20.setText(Date_array.get(19));
                date21.setText(Date_array.get(20));
                date22.setText(Date_array.get(21));
                date23.setText(Date_array.get(22));
                date24.setText(Date_array.get(23));
                date25.setText(Date_array.get(24));
                date26.setText(Date_array.get(25));
                date27.setText(Date_array.get(26));
                date28.setText(Date_array.get(27));
                date29.setText(Date_array.get(28));
                date30.setText(Date_array.get(29));

            }

            for(int k=0; k<Day_array.size(); k++){
                day1.setText(Day_array.get(0).substring(0,3));
                day2.setText(Day_array.get(1).substring(0,3));
                day3.setText(Day_array.get(2).substring(0,3));
                day4.setText(Day_array.get(3).substring(0,3));
                day5.setText(Day_array.get(4).substring(0,3));
                day6.setText(Day_array.get(5).substring(0,3));
                day7.setText(Day_array.get(6).substring(0,3));
                day8.setText(Day_array.get(7).substring(0,3));
                day9.setText(Day_array.get(8).substring(0,3));
                day10.setText(Day_array.get(9).substring(0,3));
                day11.setText(Day_array.get(10).substring(0,3));
                day12.setText(Day_array.get(11).substring(0,3));
                day13.setText(Day_array.get(12).substring(0,3));
                day14.setText(Day_array.get(13).substring(0,3));
                day15.setText(Day_array.get(14).substring(0,3));
                day16.setText(Day_array.get(15).substring(0,3));
                day17.setText(Day_array.get(16).substring(0,3));
                day18.setText(Day_array.get(17).substring(0,3));
                day19.setText(Day_array.get(18).substring(0,3));
                day20.setText(Day_array.get(19).substring(0,3));
                day21.setText(Day_array.get(20).substring(0,3));
                day22.setText(Day_array.get(21).substring(0,3));
                day23.setText(Day_array.get(22).substring(0,3));
                day24.setText(Day_array.get(23).substring(0,3));
                day25.setText(Day_array.get(24).substring(0,3));
                day26.setText(Day_array.get(25).substring(0,3));
                day27.setText(Day_array.get(26).substring(0,3));
                day28.setText(Day_array.get(27).substring(0,3));
                day29.setText(Day_array.get(28).substring(0,3));
                day30.setText(Day_array.get(29).substring(0,3));

            }


            attendance_remark31.setVisibility(View.GONE);

            for(int j=0; j<store_Data.length ;j++){

                String[] date_day = store_Data[j].split("\\|");
                attnedance.add(date_day[2]);

            }




            for(int i=0; i<attnedance.size(); i++){



                //For 0 position
                if(attnedance.get(0).equals("H")){
                    attendance_remark1.setTextColor(Color.BLUE);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("HL")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("A")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("P")){
                    attendance_remark1.setTextColor(Color.GREEN);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("WO")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("0")){
                    attendance_remark1.setText("-");

                }

                //For 1 position
                if(attnedance.get(1).equals("H")){
                    attendance_remark2.setTextColor(Color.BLUE);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("HL")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("A")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("P")){
                    attendance_remark2.setTextColor(Color.GREEN);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("WO")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("0")){
                    attendance_remark2.setText("-");

                }

                //For 2 position
                if(attnedance.get(2).equals("H")){
                    attendance_remark3.setTextColor(Color.BLUE);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("HL")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("A")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("P")){
                    attendance_remark3.setTextColor(Color.GREEN);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("WO")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("0")){
                    attendance_remark3.setText("-");

                }

                //For postion 4
                if(attnedance.get(3).equals("H")){
                    attendance_remark4.setTextColor(Color.BLUE);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("HL")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("A")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("P")){
                    attendance_remark4.setTextColor(Color.GREEN);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("WO")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("0")){
                    attendance_remark4.setText("-");

                }

                //for position5
                if(attnedance.get(4).equals("H")){
                    attendance_remark5.setTextColor(Color.BLUE);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("HL")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("A")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("P")){
                    attendance_remark5.setTextColor(Color.GREEN);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("WO")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("0")){
                    attendance_remark5.setText("-");

                }

                //for position6

                if(attnedance.get(5).equals("H")){
                    attendance_remark6.setTextColor(Color.BLUE);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("HL")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("A")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("P")){
                    attendance_remark6.setTextColor(Color.GREEN);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("WO")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("0")){
                    attendance_remark6.setText("-");

                }

                //for position 7
                if(attnedance.get(6).equals("H")){
                    attendance_remark7.setTextColor(Color.BLUE);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("HL")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("A")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("P")){
                    attendance_remark7.setTextColor(Color.GREEN);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("WO")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("0")){
                    attendance_remark7.setText("-");
                }


                //for position 8
                if(attnedance.get(7).equals("H")){
                    attendance_remark8.setTextColor(Color.BLUE);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("HL")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("A")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("P")){
                    attendance_remark8.setTextColor(Color.GREEN);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("WO")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("0")){
                    attendance_remark8.setText("-");
                }


                //for position 9
                if(attnedance.get(8).equals("H")){
                    attendance_remark9.setTextColor(Color.BLUE);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("HL")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("A")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("P")){
                    attendance_remark9.setTextColor(Color.GREEN);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("WO")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("0")){
                    attendance_remark9.setText("-");
                }



                //for position 10
                if(attnedance.get(9).equals("H")){
                    attendance_remark10.setTextColor(Color.BLUE);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("HL")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("A")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("P")){
                    attendance_remark10.setTextColor(Color.GREEN);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("WO")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("0")){
                    attendance_remark10.setText("-");
                }

                //for postion 11
                if(attnedance.get(10).equals("H")){
                    attendance_remark11.setTextColor(Color.BLUE);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("HL")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("A")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("P")){
                    attendance_remark11.setTextColor(Color.GREEN);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("WO")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("0")){
                    attendance_remark11.setText("-");
                }

                //for position 12
                if(attnedance.get(11).equals("H")){
                    attendance_remark12.setTextColor(Color.BLUE);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(12).equals("HL")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("A")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("P")){
                    attendance_remark12.setTextColor(Color.GREEN);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("WO")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("0")){
                    attendance_remark12.setText("-");
                }

                //for position 13
                if(attnedance.get(12).equals("H")){
                    attendance_remark13.setTextColor(Color.BLUE);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("HL")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("A")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("P")){
                    attendance_remark13.setTextColor(Color.GREEN);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("WO")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("0")){
                    attendance_remark13.setText("-");
                }

                //for position 14
                if(attnedance.get(13).equals("H")){
                    attendance_remark14.setTextColor(Color.BLUE);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("HL")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("A")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("P")){
                    attendance_remark14.setTextColor(Color.GREEN);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("WO")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("0")){
                    attendance_remark14.setText("-");
                }

                //for posirion 15
                if(attnedance.get(14).equals("H")){
                    attendance_remark15.setTextColor(Color.BLUE);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("HL")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("A")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("P")){
                    attendance_remark15.setTextColor(Color.GREEN);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("WO")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("0")){
                    attendance_remark15.setText("-");
                }

                //for position 16
                if(attnedance.get(15).equals("H")){
                    attendance_remark16.setTextColor(Color.BLUE);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("HL")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("A")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("P")){
                    attendance_remark16.setTextColor(Color.GREEN);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("WO")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("0")){
                    attendance_remark16.setText("-");
                }

                //for position 17
                if(attnedance.get(16).equals("H")){
                    attendance_remark17.setTextColor(Color.BLUE);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("HL")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("A")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("P")){
                    attendance_remark17.setTextColor(Color.GREEN);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("WO")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("0")){
                    attendance_remark17.setText("-");
                }

                //for position 18
                if(attnedance.get(17).equals("H")){
                    attendance_remark18.setTextColor(Color.BLUE);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("HL")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("A")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("P")){
                    attendance_remark18.setTextColor(Color.GREEN);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("WO")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("0")){
                    attendance_remark18.setText("-");
                }

                //for position 19
                if(attnedance.get(18).equals("H")){
                    attendance_remark19.setTextColor(Color.BLUE);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("HL")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("A")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("P")){
                    attendance_remark19.setTextColor(Color.GREEN);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("WO")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("0")){
                    attendance_remark19.setText("-");
                }

                //fpr position 20
                if(attnedance.get(19).equals("H")){
                    attendance_remark20.setTextColor(Color.BLUE);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("HL")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("A")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("P")){
                    attendance_remark20.setTextColor(Color.GREEN);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("WO")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("0")){
                    attendance_remark20.setText("-");
                }

                //for position 21
                if(attnedance.get(20).equals("H")){
                    attendance_remark21.setTextColor(Color.BLUE);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("HL")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("A")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("P")){
                    attendance_remark21.setTextColor(Color.GREEN);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("WO")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("0")){
                    attendance_remark21.setText("-");
                }

                //for [position 22
                if(attnedance.get(21).equals("H")){
                    attendance_remark22.setTextColor(Color.BLUE);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("HL")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("A")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("P")){
                    attendance_remark22.setTextColor(Color.GREEN);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("WO")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("0")){
                    attendance_remark22.setText("-");
                }

                //for position 23
                if(attnedance.get(22).equals("H")){
                    attendance_remark23.setTextColor(Color.BLUE);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("HL")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("A")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("P")){
                    attendance_remark23.setTextColor(Color.GREEN);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("WO")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("0")){
                    attendance_remark23.setText("-");
                }

                //for position 24
                if(attnedance.get(23).equals("H")){
                    attendance_remark24.setTextColor(Color.BLUE);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("HL")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("A")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("P")){
                    attendance_remark24.setTextColor(Color.GREEN);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("WO")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("0")){
                    attendance_remark24.setText("-");
                }

                //for position 25
                if(attnedance.get(24).equals("H")){
                    attendance_remark25.setTextColor(Color.BLUE);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("HL")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("A")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("P")){
                    attendance_remark25.setTextColor(Color.GREEN);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("WO")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("0")){
                    attendance_remark25.setText("-");
                }

                //for position 26
                if(attnedance.get(25).equals("H")){
                    attendance_remark26.setTextColor(Color.BLUE);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("HL")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("A")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("P")){
                    attendance_remark26.setTextColor(Color.GREEN);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("WO")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("0")){
                    attendance_remark26.setText("-");
                }

                //for position 27
                if(attnedance.get(26).equals("H")){
                    attendance_remark27.setTextColor(Color.BLUE);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("HL")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("A")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("P")){
                    attendance_remark27.setTextColor(Color.GREEN);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("WO")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("0")){
                    attendance_remark27.setText("-");
                }

                //for position 28
                if(attnedance.get(27).equals("H")){
                    attendance_remark28.setTextColor(Color.BLUE);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("HL")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("A")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("P")){
                    attendance_remark28.setTextColor(Color.GREEN);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("WO")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("0")){
                    attendance_remark28.setText("-");
                }

                //for postision 28
                if(attnedance.get(28).equals("H")){
                    attendance_remark29.setTextColor(Color.BLUE);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("HL")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("A")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("P")){
                    attendance_remark29.setTextColor(Color.GREEN);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("WO")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("0")){
                    attendance_remark29.setText("-");
                }


                //for position 29
                if(attnedance.get(29).equals("H")){
                    attendance_remark30.setTextColor(Color.BLUE);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("HL")){
                    attendance_remark30.setTextColor(Color.RED);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("A")){
                    attendance_remark30.setTextColor(Color.RED);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("P")){
                    attendance_remark30.setTextColor(Color.GREEN);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("WO")){
                    attendance_remark30.setTextColor(Color.RED);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("0")){
                    attendance_remark30.setText("-");
                }



            }

        }if(size ==31){

            linear31.setVisibility(View.VISIBLE);

            ArrayList<String> Date_array = new ArrayList<String>();
            ArrayList<String> Day_array = new ArrayList<String>();

            for(int j=0; j<split_array.length ;j++){

                String[] date_day = split_array[j].split("\\|");
                Date_array.add(date_day[0]);
                Day_array.add(date_day[1]);

            }


            for(int k=0; k<Date_array.size(); k++){
                date1.setText(Date_array.get(0));
                date2.setText(Date_array.get(1));
                date3.setText(Date_array.get(2));
                date4.setText(Date_array.get(3));
                date5.setText(Date_array.get(4));
                date6.setText(Date_array.get(5));
                date7.setText(Date_array.get(6));
                date8.setText(Date_array.get(7));
                date9.setText(Date_array.get(8));
                date10.setText(Date_array.get(9));
                date11.setText(Date_array.get(10));
                date12.setText(Date_array.get(11));
                date13.setText(Date_array.get(12));
                date14.setText(Date_array.get(13));
                date15.setText(Date_array.get(14));
                date16.setText(Date_array.get(15));
                date17.setText(Date_array.get(16));
                date18.setText(Date_array.get(17));
                date19.setText(Date_array.get(18));
                date20.setText(Date_array.get(19));
                date21.setText(Date_array.get(20));
                date22.setText(Date_array.get(21));
                date23.setText(Date_array.get(22));
                date24.setText(Date_array.get(23));
                date25.setText(Date_array.get(24));
                date26.setText(Date_array.get(25));
                date27.setText(Date_array.get(26));
                date28.setText(Date_array.get(27));
                date29.setText(Date_array.get(28));
                date30.setText(Date_array.get(29));
                date31.setText(Date_array.get(30));

            }

            for(int k=0; k<Day_array.size(); k++){
                day1.setText(Day_array.get(0).substring(0,3));
                day2.setText(Day_array.get(1).substring(0,3));
                day3.setText(Day_array.get(2).substring(0,3));
                day4.setText(Day_array.get(3).substring(0,3));
                day5.setText(Day_array.get(4).substring(0,3));
                day6.setText(Day_array.get(5).substring(0,3));
                day7.setText(Day_array.get(6).substring(0,3));
                day8.setText(Day_array.get(7).substring(0,3));
                day9.setText(Day_array.get(8).substring(0,3));
                day10.setText(Day_array.get(9).substring(0,3));
                day11.setText(Day_array.get(10).substring(0,3));
                day12.setText(Day_array.get(11).substring(0,3));
                day13.setText(Day_array.get(12).substring(0,3));
                day14.setText(Day_array.get(13).substring(0,3));
                day15.setText(Day_array.get(14).substring(0,3));
                day16.setText(Day_array.get(15).substring(0,3));
                day17.setText(Day_array.get(16).substring(0,3));
                day18.setText(Day_array.get(17).substring(0,3));
                day19.setText(Day_array.get(18).substring(0,3));
                day20.setText(Day_array.get(19).substring(0,3));
                day21.setText(Day_array.get(20).substring(0,3));
                day22.setText(Day_array.get(21).substring(0,3));
                day23.setText(Day_array.get(22).substring(0,3));
                day24.setText(Day_array.get(23).substring(0,3));
                day25.setText(Day_array.get(24).substring(0,3));
                day26.setText(Day_array.get(25).substring(0,3));
                day27.setText(Day_array.get(26).substring(0,3));
                day28.setText(Day_array.get(27).substring(0,3));
                day29.setText(Day_array.get(28).substring(0,3));
                day30.setText(Day_array.get(29).substring(0,3));
                day31.setText(Day_array.get(30).substring(0,3));

            }





            attendance_remark31.setVisibility(View.VISIBLE);
            for(int j=0; j<store_Data.length ;j++){

                String[] date_day = store_Data[j].split("\\|");
                attnedance.add(date_day[2]);

            }
            Log.e(" emp name ",array_monthly_list.get(position).getFULLNAME());


            for(int i=0; i<attnedance.size(); i++){

                Log.e(" date i ",i+1+ " "+attnedance.get(i));
                //For 0 position
                if(attnedance.get(0).equals("HL")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("H")){
                    attendance_remark1.setTextColor(Color.BLUE);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("A")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("P")){
                    attendance_remark1.setTextColor(Color.GREEN);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("WO")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("0")){
                    attendance_remark1.setText("-");
                }

                //For 1 position
                if(attnedance.get(1).equals("HL")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("H")){
                    attendance_remark2.setTextColor(Color.BLUE);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("A")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("P")){
                    attendance_remark2.setTextColor(Color.GREEN);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("WO")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("0")){
                    attendance_remark2.setText("-");

                }

                //For 2 position
                if(attnedance.get(2).equals("HL")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("H")){
                    attendance_remark3.setTextColor(Color.BLUE);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("A")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("P")){
                    attendance_remark3.setTextColor(Color.GREEN);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("WO")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("0")){
                    attendance_remark3.setText("-");

                }

                //For postion 4
                if(attnedance.get(3).equals("HL")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("H")){
                    attendance_remark4.setTextColor(Color.BLUE);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("A")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("P")){
                    attendance_remark4.setTextColor(Color.GREEN);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("WO")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("0")){
                    attendance_remark4.setText("-");

                }

                //for position5
                if(attnedance.get(4).equals("HL")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("H")){
                    attendance_remark5.setTextColor(Color.BLUE);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("A")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("P")){
                    attendance_remark5.setTextColor(Color.GREEN);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("WO")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("0")){
                    attendance_remark5.setText("-");

                }

                //for position6

                if(attnedance.get(5).equals("HL")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("H")){
                    attendance_remark6.setTextColor(Color.BLUE);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("A")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("P")){
                    attendance_remark6.setTextColor(Color.GREEN);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("WO")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("0")){
                    attendance_remark6.setText("-");
                }

                //for position 7
                if(attnedance.get(6).equals("HL")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("H")){
                    attendance_remark7.setTextColor(Color.BLUE);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("A")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("P")){
                    attendance_remark7.setTextColor(Color.GREEN);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("WO")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("0")){
                    attendance_remark7.setText("-");
                }


                //for position 8
                if(attnedance.get(7).equals("HL")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("H")){
                    attendance_remark8.setTextColor(Color.BLUE);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("A")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("P")){
                    attendance_remark8.setTextColor(Color.GREEN);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("WO")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("0")){
                    attendance_remark8.setText("-");
                }


                //for position 9
                if(attnedance.get(8).equals("HL")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("H")){
                    attendance_remark9.setTextColor(Color.BLUE);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("A")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("P")){
                    attendance_remark9.setTextColor(Color.GREEN);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("WO")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("0")){
                    attendance_remark9.setText("-");
                }
                //for position 10
                if(attnedance.get(9).equals("HL")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("H")){
                    attendance_remark10.setTextColor(Color.BLUE);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("A")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("P")){
                    attendance_remark10.setTextColor(Color.GREEN);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("WO")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("0")){
                    attendance_remark10.setText("-");
                }

                //for postion 11
                if(attnedance.get(10).equals("HL")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("H")){
                    attendance_remark11.setTextColor(Color.BLUE);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("A")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("P")){
                    attendance_remark11.setTextColor(Color.GREEN);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("WO")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("0")){
                    attendance_remark11.setText("-");
                }

                //for position 12
                if(attnedance.get(11).equals("HL")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("H")){
                    attendance_remark12.setTextColor(Color.BLUE);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("A")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("P")){
                    attendance_remark12.setTextColor(Color.GREEN);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("WO")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("0")){
                    attendance_remark12.setText("-");
                }

                //for position 13
                if(attnedance.get(12).equals("HL")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("H")){
                    attendance_remark13.setTextColor(Color.BLUE);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("A")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("P")){
                    attendance_remark13.setTextColor(Color.GREEN);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("WO")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("0")){
                    attendance_remark13.setText("-");
                }

                //for position 14
                if(attnedance.get(13).equals("HL")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("H")){
                    attendance_remark14.setTextColor(Color.BLUE);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("A")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("P")){
                    attendance_remark14.setTextColor(Color.GREEN);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("WO")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("0")){
                    attendance_remark14.setText("-");
                }

                //for posirion 15
                if(attnedance.get(14).equals("HL")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("H")){
                    attendance_remark15.setTextColor(Color.BLUE);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("A")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("P")){
                    attendance_remark15.setTextColor(Color.GREEN);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("WO")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("0")){
                    attendance_remark15.setText("-");
                }

                //for position 16
                if(attnedance.get(15).equals("HL")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("H")){
                    attendance_remark16.setTextColor(Color.BLUE);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("A")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("P")){
                    attendance_remark16.setTextColor(Color.GREEN);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("WO")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("0")){
                    attendance_remark16.setText("-");
                }

                //for position 17
                if(attnedance.get(16).equals("HL")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("H")){
                    attendance_remark17.setTextColor(Color.BLUE);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("A")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("P")){
                    attendance_remark17.setTextColor(Color.GREEN);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("WO")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("0")){
                    attendance_remark17.setText("-");
                }

                //for position 18
                if(attnedance.get(17).equals("HL")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("H")){
                    attendance_remark18.setTextColor(Color.BLUE);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("A")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("P")){
                    attendance_remark18.setTextColor(Color.GREEN);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("WO")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("0")){
                    attendance_remark18.setText("-");
                }

                //for position 19
                if(attnedance.get(18).equals("HL")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("H")){
                    attendance_remark19.setTextColor(Color.BLUE);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("A")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("P")){
                    attendance_remark19.setTextColor(Color.GREEN);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("WO")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("0")){
                    attendance_remark19.setText("-");
                }

                //fpr position 20
                if(attnedance.get(19).equals("HL")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("H")){
                    attendance_remark20.setTextColor(Color.BLUE);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("A")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("P")){
                    attendance_remark20.setTextColor(Color.GREEN);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("WO")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("0")){
                    attendance_remark20.setText("-");
                }

                //for position 21
                if(attnedance.get(20).equals("HL")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("H")){
                    attendance_remark21.setTextColor(Color.BLUE);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("A")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("P")){
                    attendance_remark21.setTextColor(Color.GREEN);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("WO")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("0")){
                    attendance_remark21.setText("-");
                }

                //for [position 22
                if(attnedance.get(21).equals("HL")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("H")){
                    attendance_remark22.setTextColor(Color.BLUE);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("A")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("P")){
                    attendance_remark22.setTextColor(Color.GREEN);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("WO")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("0")){
                    attendance_remark22.setText("-");
                }

                //for position 23
                if(attnedance.get(22).equals("HL")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("H")){
                    attendance_remark23.setTextColor(Color.BLUE);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("A")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("P")){
                    attendance_remark23.setTextColor(Color.GREEN);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("WO")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("0")){
                    attendance_remark23.setText("-");
                }

                //for position 24
                if(attnedance.get(23).equals("HL")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("H")){
                    attendance_remark24.setTextColor(Color.BLUE);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("A")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("P")){
                    attendance_remark24.setTextColor(Color.GREEN);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("WO")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("0")){
                    attendance_remark24.setText("-");
                }

                //for position 25
                if(attnedance.get(24).equals("HL")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("H")){
                    attendance_remark25.setTextColor(Color.BLUE);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("A")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("P")){
                    attendance_remark25.setTextColor(Color.GREEN);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("WO")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("0")){
                    attendance_remark25.setText("-");
                }

                //for position 26
                if(attnedance.get(25).equals("HL")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("H")){
                    attendance_remark26.setTextColor(Color.BLUE);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("A")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("P")){
                    attendance_remark26.setTextColor(Color.GREEN);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("WO")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("0")){
                    attendance_remark26.setText("-");
                }

                //for position 27
                if(attnedance.get(26).equals("HL")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("H")){
                    attendance_remark27.setTextColor(Color.BLUE);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("A")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("P")){
                    attendance_remark27.setTextColor(Color.GREEN);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("WO")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("0")){
                    attendance_remark27.setText("-");
                }

                //for position 28
                if(attnedance.get(27).equals("HL")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("H")){
                    attendance_remark28.setTextColor(Color.BLUE);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("A")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("P")){
                    attendance_remark28.setTextColor(Color.GREEN);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("WO")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("0")){
                    attendance_remark28.setText("-");
                }

                //for postision 28
                if(attnedance.get(28).equals("HL")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("H")){
                    attendance_remark29.setTextColor(Color.BLUE);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("A")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("P")){
                    attendance_remark29.setTextColor(Color.GREEN);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("WO")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("0")){
                    attendance_remark29.setText("-");
                }


                //for position 29
                if(attnedance.get(29).equals("HL")){
                    attendance_remark30.setTextColor(Color.RED);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("H")){
                    attendance_remark30.setTextColor(Color.BLUE);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("A")){
                    attendance_remark30.setTextColor(Color.RED);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("P")){
                    attendance_remark30.setTextColor(Color.GREEN);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("WO")){
                    attendance_remark30.setTextColor(Color.RED);
                    attendance_remark30.setText(attnedance.get(29));
                }else if(attnedance.get(29).equals("0")){
                    attendance_remark30.setText("-");
                }


                //for position 30
                if(attnedance.get(30).equals("HL")){
                    attendance_remark31.setTextColor(Color.RED);
                    attendance_remark31.setText(attnedance.get(30));
                }else if(attnedance.get(30).equals("H")){
                    attendance_remark31.setTextColor(Color.BLUE);
                    attendance_remark31.setText(attnedance.get(30));
                }else if(attnedance.get(30).equals("A")){
                    attendance_remark31.setTextColor(Color.RED);
                    attendance_remark31.setText(attnedance.get(30));
                }else if(attnedance.get(30).equals("P")){
                    attendance_remark31.setTextColor(Color.GREEN);
                    attendance_remark31.setText(attnedance.get(30));
                }else if(attnedance.get(30).equals("WO")){
                    attendance_remark31.setTextColor(Color.RED);
                    attendance_remark31.setText(attnedance.get(30));
                }else if(attnedance.get(30).equals("0")){
                    attendance_remark31.setText("-");
                }

            }

        }if(size ==29){

            linear30.setVisibility(View.GONE);
            linear31.setVisibility(View.GONE);

            ArrayList<String> Date_array = new ArrayList<String>();
            ArrayList<String> Day_array = new ArrayList<String>();

            for(int j=0; j<split_array.length ;j++){

                String[] date_day = split_array[j].split("\\|");
                Date_array.add(date_day[0]);
                Day_array.add(date_day[1]);

            }


            for(int k=0; k<Date_array.size(); k++){
                date1.setText(Date_array.get(0));
                date2.setText(Date_array.get(1));
                date3.setText(Date_array.get(2));
                date4.setText(Date_array.get(3));
                date5.setText(Date_array.get(4));
                date6.setText(Date_array.get(5));
                date7.setText(Date_array.get(6));
                date8.setText(Date_array.get(7));
                date9.setText(Date_array.get(8));
                date10.setText(Date_array.get(9));
                date11.setText(Date_array.get(10));
                date12.setText(Date_array.get(11));
                date13.setText(Date_array.get(12));
                date14.setText(Date_array.get(13));
                date15.setText(Date_array.get(14));
                date16.setText(Date_array.get(15));
                date17.setText(Date_array.get(16));
                date18.setText(Date_array.get(17));
                date19.setText(Date_array.get(18));
                date20.setText(Date_array.get(19));
                date21.setText(Date_array.get(20));
                date22.setText(Date_array.get(21));
                date23.setText(Date_array.get(22));
                date24.setText(Date_array.get(23));
                date25.setText(Date_array.get(24));
                date26.setText(Date_array.get(25));
                date27.setText(Date_array.get(26));
                date28.setText(Date_array.get(27));
                date29.setText(Date_array.get(28));


            }

            for(int k=0; k<Day_array.size(); k++){
                day1.setText(Day_array.get(0).substring(0,3));
                day2.setText(Day_array.get(1).substring(0,3));
                day3.setText(Day_array.get(2).substring(0,3));
                day4.setText(Day_array.get(3).substring(0,3));
                day5.setText(Day_array.get(4).substring(0,3));
                day6.setText(Day_array.get(5).substring(0,3));
                day7.setText(Day_array.get(6).substring(0,3));
                day8.setText(Day_array.get(7).substring(0,3));
                day9.setText(Day_array.get(8).substring(0,3));
                day10.setText(Day_array.get(9).substring(0,3));
                day11.setText(Day_array.get(10).substring(0,3));
                day12.setText(Day_array.get(11).substring(0,3));
                day13.setText(Day_array.get(12).substring(0,3));
                day14.setText(Day_array.get(13).substring(0,3));
                day15.setText(Day_array.get(14).substring(0,3));
                day16.setText(Day_array.get(15).substring(0,3));
                day17.setText(Day_array.get(16).substring(0,3));
                day18.setText(Day_array.get(17).substring(0,3));
                day19.setText(Day_array.get(18).substring(0,3));
                day20.setText(Day_array.get(19).substring(0,3));
                day21.setText(Day_array.get(20).substring(0,3));
                day22.setText(Day_array.get(21).substring(0,3));
                day23.setText(Day_array.get(22).substring(0,3));
                day24.setText(Day_array.get(23).substring(0,3));
                day25.setText(Day_array.get(24).substring(0,3));
                day26.setText(Day_array.get(25).substring(0,3));
                day27.setText(Day_array.get(26).substring(0,3));
                day28.setText(Day_array.get(27).substring(0,3));
                day29.setText(Day_array.get(28).substring(0,3));

            }



            attendance_remark30.setVisibility(View.GONE);
            attendance_remark31.setVisibility(View.GONE);

            for(int j=0; j<store_Data.length ;j++){

                String[] date_day = store_Data[j].split("\\|");
                attnedance.add(date_day[2]);

            }

            for(int i=0; i<attnedance.size(); i++){



                //For 0 position
                if(attnedance.get(0).equals("HL")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("H")){
                    attendance_remark1.setTextColor(Color.BLUE);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("A")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("P")){
                    attendance_remark1.setTextColor(Color.GREEN);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("WO")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("0")){
                    attendance_remark1.setText("-");

                }

                //For 1 position
                if(attnedance.get(1).equals("HL")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("H")){
                    attendance_remark2.setTextColor(Color.BLUE);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("A")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("P")){
                    attendance_remark2.setTextColor(Color.GREEN);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("WO")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("0")){
                    attendance_remark2.setText("-");

                }

                //For 2 position
                if(attnedance.get(2).equals("HL")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("H")){
                    attendance_remark3.setTextColor(Color.BLUE);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("A")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("P")){
                    attendance_remark3.setTextColor(Color.GREEN);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("WO")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("0")){
                    attendance_remark3.setText("-");

                }

                //For postion 4
                if(attnedance.get(3).equals("HL")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("H")){
                    attendance_remark4.setTextColor(Color.BLUE);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("A")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("P")){
                    attendance_remark4.setTextColor(Color.GREEN);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("WO")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("0")){
                    attendance_remark4.setText("-");

                }

                //for position5
                if(attnedance.get(4).equals("HL")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("H")){
                    attendance_remark5.setTextColor(Color.BLUE);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("A")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("P")){
                    attendance_remark5.setTextColor(Color.GREEN);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("WO")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("0")){
                    attendance_remark5.setText("-");

                }

                //for position6

                if(attnedance.get(5).equals("HL")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("H")){
                    attendance_remark6.setTextColor(Color.BLUE);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("A")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("P")){
                    attendance_remark6.setTextColor(Color.GREEN);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("WO")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("0")){
                    attendance_remark6.setText("-");

                }

                //for position 7
                if(attnedance.get(6).equals("HL")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("H")){
                    attendance_remark7.setTextColor(Color.BLUE);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("A")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("P")){
                    attendance_remark7.setTextColor(Color.GREEN);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("WO")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("0")){
                    attendance_remark7.setText("-");
                }


                //for position 8
                if(attnedance.get(7).equals("HL")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("H")){
                    attendance_remark8.setTextColor(Color.BLUE);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("A")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("P")){
                    attendance_remark8.setTextColor(Color.GREEN);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("WO")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("0")){
                    attendance_remark8.setText("-");
                }


                //for position 9
                if(attnedance.get(8).equals("HL")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("H")){
                    attendance_remark9.setTextColor(Color.BLUE);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("A")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("P")){
                    attendance_remark9.setTextColor(Color.GREEN);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("WO")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("0")){
                    attendance_remark9.setText("-");
                }

                //for position 10
                if(attnedance.get(9).equals("HL")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("H")){
                    attendance_remark10.setTextColor(Color.BLUE);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("A")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("P")){
                    attendance_remark10.setTextColor(Color.GREEN);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("WO")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("0")){
                    attendance_remark10.setText("-");
                }

                //for postion 11
                if(attnedance.get(10).equals("HL")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("H")){
                    attendance_remark11.setTextColor(Color.BLUE);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("A")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("P")){
                    attendance_remark11.setTextColor(Color.GREEN);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("WO")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("0")){
                    attendance_remark11.setText("-");
                }

                //for position 12
                if(attnedance.get(11).equals("HL")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("H")){
                    attendance_remark12.setTextColor(Color.BLUE);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("A")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("P")){
                    attendance_remark12.setTextColor(Color.GREEN);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("WO")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("0")){
                    attendance_remark12.setText("-");
                }

                //for position 13
                if(attnedance.get(12).equals("HL")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("H")){
                    attendance_remark13.setTextColor(Color.BLUE);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("A")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("P")){
                    attendance_remark13.setTextColor(Color.GREEN);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("WO")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("0")){
                    attendance_remark13.setText("-");
                }

                //for position 14
                if(attnedance.get(13).equals("HL")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("H")){
                    attendance_remark14.setTextColor(Color.BLUE);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("A")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("P")){
                    attendance_remark14.setTextColor(Color.GREEN);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("WO")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("0")){
                    attendance_remark14.setText("-");
                }

                //for posirion 15
                if(attnedance.get(14).equals("HL")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("H")){
                    attendance_remark15.setTextColor(Color.BLUE);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("A")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("P")){
                    attendance_remark15.setTextColor(Color.GREEN);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("WO")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("0")){
                    attendance_remark15.setText("-");
                }

                //for position 16
                if(attnedance.get(15).equals("HL")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("H")){
                    attendance_remark16.setTextColor(Color.BLUE);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("A")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("P")){
                    attendance_remark16.setTextColor(Color.GREEN);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("WO")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("0")){
                    attendance_remark16.setText("-");
                }

                //for position 17
                if(attnedance.get(16).equals("HL")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("H")){
                    attendance_remark17.setTextColor(Color.BLUE);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("A")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("P")){
                    attendance_remark17.setTextColor(Color.GREEN);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("WO")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("0")){
                    attendance_remark17.setText("-");
                }

                //for position 18
                if(attnedance.get(17).equals("HL")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("H")){
                    attendance_remark18.setTextColor(Color.BLUE);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("A")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("P")){
                    attendance_remark18.setTextColor(Color.GREEN);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("WO")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("0")){
                    attendance_remark18.setText("-");
                }

                //for position 19
                if(attnedance.get(18).equals("HL")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("H")){
                    attendance_remark19.setTextColor(Color.BLUE);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("A")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("P")){
                    attendance_remark19.setTextColor(Color.GREEN);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("WO")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("0")){
                    attendance_remark19.setText("-");
                }

                //fpr position 20
                if(attnedance.get(19).equals("HL")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("H")){
                    attendance_remark20.setTextColor(Color.BLUE);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("A")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("P")){
                    attendance_remark20.setTextColor(Color.GREEN);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("WO")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("0")){
                    attendance_remark20.setText("-");
                }

                //for position 21
                if(attnedance.get(20).equals("HL")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("H")){
                    attendance_remark21.setTextColor(Color.BLUE);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("A")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("P")){
                    attendance_remark21.setTextColor(Color.GREEN);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("WO")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("0")){
                    attendance_remark21.setText("-");
                }

                //for [position 22
                if(attnedance.get(21).equals("HL")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("H")){
                    attendance_remark22.setTextColor(Color.BLUE);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("A")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("P")){
                    attendance_remark22.setTextColor(Color.GREEN);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("WO")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("0")){
                    attendance_remark22.setText("-");
                }

                //for position 23
                if(attnedance.get(22).equals("HL")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("H")){
                    attendance_remark23.setTextColor(Color.BLUE);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("A")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("P")){
                    attendance_remark23.setTextColor(Color.GREEN);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("WO")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("0")){
                    attendance_remark23.setText("-");
                }

                //for position 24
                if(attnedance.get(23).equals("HL")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("H")){
                    attendance_remark24.setTextColor(Color.BLUE);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("A")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("P")){
                    attendance_remark24.setTextColor(Color.GREEN);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("WO")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("0")){
                    attendance_remark24.setText("-");
                }

                //for position 25
                if(attnedance.get(24).equals("HL")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("H")){
                    attendance_remark25.setTextColor(Color.BLUE);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("A")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("P")){
                    attendance_remark25.setTextColor(Color.GREEN);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("WO")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("0")){
                    attendance_remark25.setText("-");
                }

                //for position 26
                if(attnedance.get(25).equals("HL")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("H")){
                    attendance_remark26.setTextColor(Color.BLUE);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("A")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("P")){
                    attendance_remark26.setTextColor(Color.GREEN);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("WO")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("0")){
                    attendance_remark26.setText("-");
                }

                //for position 27
                if(attnedance.get(26).equals("HL")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("H")){
                    attendance_remark27.setTextColor(Color.BLUE);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("A")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("P")){
                    attendance_remark27.setTextColor(Color.GREEN);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("WO")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("0")){
                    attendance_remark27.setText("-");
                }

                //for position 28
                if(attnedance.get(27).equals("HL")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("H")){
                    attendance_remark28.setTextColor(Color.BLUE);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("A")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("P")){
                    attendance_remark28.setTextColor(Color.GREEN);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("WO")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("0")){
                    attendance_remark28.setText("-");
                }

                //for postision 28
                if(attnedance.get(28).equals("HL")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("H")){
                    attendance_remark29.setTextColor(Color.BLUE);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("A")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("P")){
                    attendance_remark29.setTextColor(Color.GREEN);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("WO")){
                    attendance_remark29.setTextColor(Color.RED);
                    attendance_remark29.setText(attnedance.get(28));
                }else if(attnedance.get(28).equals("0")){
                    attendance_remark29.setText("-");
                }



            }

        }if(size ==28){

            linear29.setVisibility(View.GONE);
            linear30.setVisibility(View.GONE);
            linear31.setVisibility(View.GONE);

            ArrayList<String> Date_array = new ArrayList<String>();
            ArrayList<String> Day_array = new ArrayList<String>();

            for(int j=0; j<split_array.length ;j++){

                String[] date_day = split_array[j].split("\\|");
                Date_array.add(date_day[0]);
                Day_array.add(date_day[1]);

            }


            for(int k=0; k<Date_array.size(); k++){
                date1.setText(Date_array.get(0));
                date2.setText(Date_array.get(1));
                date3.setText(Date_array.get(2));
                date4.setText(Date_array.get(3));
                date5.setText(Date_array.get(4));
                date6.setText(Date_array.get(5));
                date7.setText(Date_array.get(6));
                date8.setText(Date_array.get(7));
                date9.setText(Date_array.get(8));
                date10.setText(Date_array.get(9));
                date11.setText(Date_array.get(10));
                date12.setText(Date_array.get(11));
                date13.setText(Date_array.get(12));
                date14.setText(Date_array.get(13));
                date15.setText(Date_array.get(14));
                date16.setText(Date_array.get(15));
                date17.setText(Date_array.get(16));
                date18.setText(Date_array.get(17));
                date19.setText(Date_array.get(18));
                date20.setText(Date_array.get(19));
                date21.setText(Date_array.get(20));
                date22.setText(Date_array.get(21));
                date23.setText(Date_array.get(22));
                date24.setText(Date_array.get(23));
                date25.setText(Date_array.get(24));
                date26.setText(Date_array.get(25));
                date27.setText(Date_array.get(26));
                date28.setText(Date_array.get(27));

            }

            for(int k=0; k<Day_array.size(); k++){
                day1.setText(Day_array.get(0).substring(0,3));
                day2.setText(Day_array.get(1).substring(0,3));
                day3.setText(Day_array.get(2).substring(0,3));
                day4.setText(Day_array.get(3).substring(0,3));
                day5.setText(Day_array.get(4).substring(0,3));
                day6.setText(Day_array.get(5).substring(0,3));
                day7.setText(Day_array.get(6).substring(0,3));
                day8.setText(Day_array.get(7).substring(0,3));
                day9.setText(Day_array.get(8).substring(0,3));
                day10.setText(Day_array.get(9).substring(0,3));
                day11.setText(Day_array.get(10).substring(0,3));
                day12.setText(Day_array.get(11).substring(0,3));
                day13.setText(Day_array.get(12).substring(0,3));
                day14.setText(Day_array.get(13).substring(0,3));
                day15.setText(Day_array.get(14).substring(0,3));
                day16.setText(Day_array.get(15).substring(0,3));
                day17.setText(Day_array.get(16).substring(0,3));
                day18.setText(Day_array.get(17).substring(0,3));
                day19.setText(Day_array.get(18).substring(0,3));
                day20.setText(Day_array.get(19).substring(0,3));
                day21.setText(Day_array.get(20).substring(0,3));
                day22.setText(Day_array.get(21).substring(0,3));
                day23.setText(Day_array.get(22).substring(0,3));
                day24.setText(Day_array.get(23).substring(0,3));
                day25.setText(Day_array.get(24).substring(0,3));
                day26.setText(Day_array.get(25).substring(0,3));
                day27.setText(Day_array.get(26).substring(0,3));
                day28.setText(Day_array.get(27).substring(0,3));

            }


            attendance_remark29.setVisibility(View.GONE);
            attendance_remark30.setVisibility(View.GONE);
            attendance_remark31.setVisibility(View.GONE);

            for(int j=0; j<store_Data.length ;j++){

                String[] date_day = store_Data[j].split("\\|");
                attnedance.add(date_day[2]);

            }

            for(int i=0; i<attnedance.size(); i++){

                //For 0 position
                if(attnedance.get(0).equals("HL")){
                    attendance_remark1.setTextColor(Color.BLUE);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("A")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("P")){
                    attendance_remark1.setTextColor(Color.GREEN);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("WO")){
                    attendance_remark1.setTextColor(Color.RED);
                    attendance_remark1.setText(attnedance.get(0));
                }else if(attnedance.get(0).equals("0")){
                    attendance_remark1.setText("-");

                }

                //For 1 position
                if(attnedance.get(1).equals("HL")){
                    attendance_remark2.setTextColor(Color.BLUE);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("A")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("P")){
                    attendance_remark2.setTextColor(Color.GREEN);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("WO")){
                    attendance_remark2.setTextColor(Color.RED);
                    attendance_remark2.setText(attnedance.get(1));
                }else if(attnedance.get(1).equals("0")){
                    attendance_remark2.setText("-");

                }

                //For 2 position
                if(attnedance.get(2).equals("HL")){
                    attendance_remark3.setTextColor(Color.BLUE);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("A")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("P")){
                    attendance_remark3.setTextColor(Color.GREEN);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("WO")){
                    attendance_remark3.setTextColor(Color.RED);
                    attendance_remark3.setText(attnedance.get(2));
                }else if(attnedance.get(2).equals("0")){
                    attendance_remark3.setText("-");

                }

                //For postion 4
                if(attnedance.get(3).equals("HL")){
                    attendance_remark4.setTextColor(Color.BLUE);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("A")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("P")){
                    attendance_remark4.setTextColor(Color.GREEN);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("WO")){
                    attendance_remark4.setTextColor(Color.RED);
                    attendance_remark4.setText(attnedance.get(3));
                }else if(attnedance.get(3).equals("0")){
                    attendance_remark4.setText("-");

                }

                //for position5
                if(attnedance.get(4).equals("HL")){
                    attendance_remark5.setTextColor(Color.BLUE);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("A")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("P")){
                    attendance_remark5.setTextColor(Color.GREEN);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("WO")){
                    attendance_remark5.setTextColor(Color.RED);
                    attendance_remark5.setText(attnedance.get(4));
                }else if(attnedance.get(4).equals("0")){
                    attendance_remark5.setText("-");

                }

                //for position6

                if(attnedance.get(5).equals("HL")){
                    attendance_remark6.setTextColor(Color.BLUE);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("A")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("P")){
                    attendance_remark6.setTextColor(Color.GREEN);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("WO")){
                    attendance_remark6.setTextColor(Color.RED);
                    attendance_remark6.setText(attnedance.get(5));
                }else if(attnedance.get(5).equals("0")){
                    attendance_remark6.setText("-");

                }

                //for position 7
                if(attnedance.get(6).equals("HL")){
                    attendance_remark7.setTextColor(Color.BLUE);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("A")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("P")){
                    attendance_remark7.setTextColor(Color.GREEN);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("WO")){
                    attendance_remark7.setTextColor(Color.RED);
                    attendance_remark7.setText(attnedance.get(6));
                }else if(attnedance.get(6).equals("0")){
                    attendance_remark7.setText("-");
                }


                //for position 8
                if(attnedance.get(7).equals("HL")){
                    attendance_remark8.setTextColor(Color.BLUE);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("A")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("P")){
                    attendance_remark8.setTextColor(Color.GREEN);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("WO")){
                    attendance_remark8.setTextColor(Color.RED);
                    attendance_remark8.setText(attnedance.get(7));
                }else if(attnedance.get(7).equals("0")){
                    attendance_remark8.setText("-");
                }


                //for position 9
                if(attnedance.get(8).equals("HL")){
                    attendance_remark9.setTextColor(Color.BLUE);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("A")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("P")){
                    attendance_remark9.setTextColor(Color.GREEN);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("WO")){
                    attendance_remark9.setTextColor(Color.RED);
                    attendance_remark9.setText(attnedance.get(8));
                }else if(attnedance.get(8).equals("0")){
                    attendance_remark9.setText("-");
                }

                //for position 10
                if(attnedance.get(9).equals("HL")){
                    attendance_remark10.setTextColor(Color.BLUE);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("A")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("P")){
                    attendance_remark10.setTextColor(Color.GREEN);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("WO")){
                    attendance_remark10.setTextColor(Color.RED);
                    attendance_remark10.setText(attnedance.get(9));
                }else if(attnedance.get(9).equals("0")){
                    attendance_remark10.setText("-");
                }

                //for postion 11
                if(attnedance.get(10).equals("HL")){
                    attendance_remark11.setTextColor(Color.BLUE);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("A")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("P")){
                    attendance_remark11.setTextColor(Color.GREEN);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("WO")){
                    attendance_remark11.setTextColor(Color.RED);
                    attendance_remark11.setText(attnedance.get(10));
                }else if(attnedance.get(10).equals("0")){
                    attendance_remark11.setText("-");
                }

                //for position 12
                if(attnedance.get(11).equals("HL")){
                    attendance_remark12.setTextColor(Color.BLUE);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("A")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("P")){
                    attendance_remark12.setTextColor(Color.GREEN);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("WO")){
                    attendance_remark12.setTextColor(Color.RED);
                    attendance_remark12.setText(attnedance.get(11));
                }else if(attnedance.get(11).equals("0")){
                    attendance_remark12.setText("-");
                }

                //for position 13
                if(attnedance.get(12).equals("HL")){
                    attendance_remark13.setTextColor(Color.BLUE);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("A")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("P")){
                    attendance_remark13.setTextColor(Color.GREEN);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("WO")){
                    attendance_remark13.setTextColor(Color.RED);
                    attendance_remark13.setText(attnedance.get(12));
                }else if(attnedance.get(12).equals("0")){
                    attendance_remark13.setText("-");
                }

                //for position 14
                if(attnedance.get(13).equals("HL")){
                    attendance_remark14.setTextColor(Color.BLUE);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("A")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("P")){
                    attendance_remark14.setTextColor(Color.GREEN);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("WO")){
                    attendance_remark14.setTextColor(Color.RED);
                    attendance_remark14.setText(attnedance.get(13));
                }else if(attnedance.get(13).equals("0")){
                    attendance_remark14.setText("-");
                }

                //for posirion 15
                if(attnedance.get(14).equals("HL")){
                    attendance_remark15.setTextColor(Color.BLUE);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("A")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("P")){
                    attendance_remark15.setTextColor(Color.GREEN);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("WO")){
                    attendance_remark15.setTextColor(Color.RED);
                    attendance_remark15.setText(attnedance.get(14));
                }else if(attnedance.get(14).equals("0")){
                    attendance_remark15.setText("-");
                }

                //for position 16
                if(attnedance.get(15).equals("HL")){
                    attendance_remark16.setTextColor(Color.BLUE);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("A")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("P")){
                    attendance_remark16.setTextColor(Color.GREEN);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("WO")){
                    attendance_remark16.setTextColor(Color.RED);
                    attendance_remark16.setText(attnedance.get(15));
                }else if(attnedance.get(15).equals("0")){
                    attendance_remark16.setText("-");
                }

                //for position 17
                if(attnedance.get(16).equals("HL")){
                    attendance_remark17.setTextColor(Color.BLUE);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("A")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("P")){
                    attendance_remark17.setTextColor(Color.GREEN);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("WO")){
                    attendance_remark17.setTextColor(Color.RED);
                    attendance_remark17.setText(attnedance.get(16));
                }else if(attnedance.get(16).equals("0")){
                    attendance_remark17.setText("-");
                }

                //for position 18
                if(attnedance.get(17).equals("HL")){
                    attendance_remark18.setTextColor(Color.BLUE);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("A")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("P")){
                    attendance_remark18.setTextColor(Color.GREEN);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("WO")){
                    attendance_remark18.setTextColor(Color.RED);
                    attendance_remark18.setText(attnedance.get(17));
                }else if(attnedance.get(17).equals("0")){
                    attendance_remark18.setText("-");
                }

                //for position 19
                if(attnedance.get(18).equals("HL")){
                    attendance_remark19.setTextColor(Color.BLUE);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("A")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("P")){
                    attendance_remark19.setTextColor(Color.GREEN);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("WO")){
                    attendance_remark19.setTextColor(Color.RED);
                    attendance_remark19.setText(attnedance.get(18));
                }else if(attnedance.get(18).equals("0")){
                    attendance_remark19.setText("-");
                }

                //fpr position 20
                if(attnedance.get(19).equals("HL")){
                    attendance_remark20.setTextColor(Color.BLUE);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("A")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("P")){
                    attendance_remark20.setTextColor(Color.GREEN);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("WO")){
                    attendance_remark20.setTextColor(Color.RED);
                    attendance_remark20.setText(attnedance.get(19));
                }else if(attnedance.get(19).equals("0")){
                    attendance_remark20.setText("-");
                }

                //for position 21
                if(attnedance.get(20).equals("HL")){
                    attendance_remark21.setTextColor(Color.BLUE);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("A")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("P")){
                    attendance_remark21.setTextColor(Color.GREEN);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("WO")){
                    attendance_remark21.setTextColor(Color.RED);
                    attendance_remark21.setText(attnedance.get(20));
                }else if(attnedance.get(20).equals("0")){
                    attendance_remark21.setText("-");
                }

                //for [position 22
                if(attnedance.get(21).equals("HL")){
                    attendance_remark22.setTextColor(Color.BLUE);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("A")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("P")){
                    attendance_remark22.setTextColor(Color.GREEN);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("WO")){
                    attendance_remark22.setTextColor(Color.RED);
                    attendance_remark22.setText(attnedance.get(21));
                }else if(attnedance.get(21).equals("0")){
                    attendance_remark22.setText("-");
                }

                //for position 23
                if(attnedance.get(22).equals("HL")){
                    attendance_remark23.setTextColor(Color.BLUE);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("A")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("P")){
                    attendance_remark23.setTextColor(Color.GREEN);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("WO")){
                    attendance_remark23.setTextColor(Color.RED);
                    attendance_remark23.setText(attnedance.get(22));
                }else if(attnedance.get(22).equals("0")){
                    attendance_remark23.setText("-");
                }

                //for position 24
                if(attnedance.get(23).equals("HL")){
                    attendance_remark24.setTextColor(Color.BLUE);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("A")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("P")){
                    attendance_remark24.setTextColor(Color.GREEN);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("WO")){
                    attendance_remark24.setTextColor(Color.RED);
                    attendance_remark24.setText(attnedance.get(23));
                }else if(attnedance.get(23).equals("0")){
                    attendance_remark24.setText("-");
                }

                //for position 25
                if(attnedance.get(24).equals("HL")){
                    attendance_remark25.setTextColor(Color.BLUE);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("A")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("P")){
                    attendance_remark25.setTextColor(Color.GREEN);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("WO")){
                    attendance_remark25.setTextColor(Color.RED);
                    attendance_remark25.setText(attnedance.get(24));
                }else if(attnedance.get(24).equals("0")){
                    attendance_remark25.setText("-");
                }

                //for position 26
                if(attnedance.get(25).equals("HL")){
                    attendance_remark26.setTextColor(Color.BLUE);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("A")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("P")){
                    attendance_remark26.setTextColor(Color.GREEN);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("WO")){
                    attendance_remark26.setTextColor(Color.RED);
                    attendance_remark26.setText(attnedance.get(25));
                }else if(attnedance.get(25).equals("0")){
                    attendance_remark26.setText("-");
                }

                //for position 27
                if(attnedance.get(26).equals("HL")){
                    attendance_remark27.setTextColor(Color.BLUE);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("A")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("P")){
                    attendance_remark27.setTextColor(Color.GREEN);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("WO")){
                    attendance_remark27.setTextColor(Color.RED);
                    attendance_remark27.setText(attnedance.get(26));
                }else if(attnedance.get(26).equals("0")){
                    attendance_remark27.setText("-");
                }

                //for position 28
                if(attnedance.get(27).equals("HL")){
                    attendance_remark28.setTextColor(Color.BLUE);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("A")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("P")){
                    attendance_remark28.setTextColor(Color.GREEN);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("WO")){
                    attendance_remark28.setTextColor(Color.RED);
                    attendance_remark28.setText(attnedance.get(27));
                }else if(attnedance.get(27).equals("0")){
                    attendance_remark28.setText("-");
                }


            }


        }


        return view;
    }
}

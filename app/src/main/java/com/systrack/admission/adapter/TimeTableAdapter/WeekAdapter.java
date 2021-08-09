package com.systrack.admission.adapter.TimeTableAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import java.util.ArrayList;


public class WeekAdapter extends ArrayAdapter<Week> {

    private Context mActivity;
    private int mResource;
    private ArrayList<Week> weeklist;
    private Week week;
    private ListView mListView;
    AppController appController;
    private String ROLEID;
    SharedPreferences sharedpreferences;

    private static class ViewHolder {
        TextView subject;
        TextView teacher;
        TextView time;
        TextView room;
        ImageView popup;
        CardView cardView;
    }

    public WeekAdapter(Activity activity, ListView listView, int resource, ArrayList<Week> objects) {
        super(activity, resource, objects);
        mActivity = activity;
        mResource = resource;
        weeklist = objects;
        mListView = listView;
    }

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        String subject = getItem(position).getSubject();
        String teacher = getItem(position).getTeacher();
        String time_from = getItem(position).getFromTime();
        String time_to = getItem(position).getToTime();
        String room = getItem(position).getRoom();
        int color = getItem(position).getColor();
        int labid = getItem(position).getLABID();
        int roomid = getItem(position).getROOMID();
        String labname = getItem(position).getLABALIASNAME();

        String LEAVEDATE = getItem(position).getLEAVEDATE();
//        String Mergetime=getItem(position).getMERGECLASSTIME().equals("null")?"":getItem(position).getMERGECLASSTIME();

        week = new Week(subject, teacher, room, time_from, time_to, color,labid,roomid,labname,LEAVEDATE);
        final ViewHolder holder;
        sharedpreferences = mActivity.getApplicationContext().getSharedPreferences(mActivity.getString(R.string.preference_file_key), Context.MODE_PRIVATE);


        appController = (AppController)mActivity.getApplicationContext();
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mActivity);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.subject = convertView.findViewById(R.id.subject);
            holder.teacher = convertView.findViewById(R.id.teacher);
            holder.time = convertView.findViewById(R.id.time);
            holder.room = convertView.findViewById(R.id.room);
            holder.popup = convertView.findViewById(R.id.popupbtn);
            holder.cardView = convertView.findViewById(R.id.cardView);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        ROLEID = sharedpreferences.getString(mActivity.getString(R.string.roleid),"0");

        holder.time.setText(week.getFromTime() + " - " + week.getToTime());

//        Log.e(" merge time ",Mergetime+" ** ");
////        if(Mergetime !=null ){
//        if(Mergetime != null && !Mergetime.isEmpty()){
//
//                String s1=week.getFromTime();
//            String[] mergrtime = Mergetime.split("-");
////            int size = AddedEmployee.length;
//
//            holder.time.setText(week.getFromTime() + " - " + mergrtime[1]);
//Log.e("set Time ",week.getFromTime() + " - " + mergrtime[1] +" ****");
//        }

        holder.subject.setText(week.getSubject());
        holder.teacher.setText(week.getTeacher());

        if(week.getLABID() == 1){
            if(weeklist.get(position).getIsDisplayPractical().equals("1")){
                holder.cardView.setVisibility(View.VISIBLE);
            }else{
                holder.cardView.setVisibility(View.GONE);
            }
            holder.room.setText(week.getLABALIASNAME());
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFC2C2C2"));

        }else if(!week.getLEAVEDATE().equals("")){
            holder.room.setText(week.getRoom());
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFff7f7f"));


        }else {
            holder.room.setText(week.getRoom());
        }


       // holder.room.setText(week.getLABALIASNAME());


        return convertView;
    }

    public ArrayList<Week> getWeekList() {
        return weeklist;
    }

    public Week getWeek() {
        return week;
    }

}

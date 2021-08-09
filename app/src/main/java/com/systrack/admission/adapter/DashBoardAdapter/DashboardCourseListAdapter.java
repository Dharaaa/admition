package com.systrack.admission.adapter.DashBoardAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.pojo.CourseList;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DashboardCourseListAdapter extends BaseAdapter {
    ArrayList<CourseList> array_course_list;

    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView course_name,no_student;


    public DashboardCourseListAdapter(Context context,ArrayList<CourseList> array_course_list){
        this.context = context;
        this.array_course_list = array_course_list;
    }

    @Override
    public int getCount() {
        return array_course_list.size();
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
        View view = inflater.inflate(R.layout.list_dashboard_courses,viewGroup,false);

        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);



        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");


        Typeface font_icon = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");

        course_name = (TextView)view.findViewById(R.id.course_name);
        no_student = (TextView)view.findViewById(R.id.no_student);

        course_name.setText(array_course_list.get(i).getCOURSENAME());
        no_student.setText(array_course_list.get(i).getSTUDENTCNT()+"");

        course_name.setTypeface(typeface_regular);
        no_student.setTypeface(typeface_semibold);


        return view;
    }
}

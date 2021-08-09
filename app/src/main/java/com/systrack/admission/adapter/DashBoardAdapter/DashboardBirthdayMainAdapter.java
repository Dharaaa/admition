package com.systrack.admission.adapter.DashBoardAdapter;

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
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.BirthDayList;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DashboardBirthdayMainAdapter extends BaseAdapter {


    ArrayList<BirthDayList> array_dashboard_birthday;
    Context context;
    LayoutInflater inflater;
    AppController appController;
    SharedPreferences sharedpreferences;
    FontAwesomeTextview birthday_icon;
    TextView full_name,role_name;

    public DashboardBirthdayMainAdapter(Context context, ArrayList<BirthDayList> array_dashboard_birthday){
        this.context = context;
        this.array_dashboard_birthday = array_dashboard_birthday;
    }


    @Override
    public int getCount() {
        return array_dashboard_birthday.size();
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
        inflater=(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_birthday,viewGroup,false);
        Typeface font_icon = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");




        full_name = (TextView)view.findViewById(R.id.full_name);
        role_name = (TextView)view.findViewById(R.id.role_name);

        full_name.setTypeface(typeface_semibold);
        role_name.setTypeface(typeface_regular);


        birthday_icon = (FontAwesomeTextview)view.findViewById(R.id.birthday_icon);
        birthday_icon.setTypeface(font_icon);

        full_name.setText(array_dashboard_birthday.get(i).getFULLNAME());
        role_name.setText(array_dashboard_birthday.get(i).getDESIGNATIONNAME());


        return view;
    }
}

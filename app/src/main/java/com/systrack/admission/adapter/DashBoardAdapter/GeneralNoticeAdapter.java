package com.systrack.admission.adapter.DashBoardAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.pojo.DashboardInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class GeneralNoticeAdapter extends BaseAdapter {


    ArrayList<DashboardInformation> array_general_notice;
    Context context;
    LayoutInflater inflater;
    SharedPreferences sharedpreferences;
    TextView circule_g,circule_s,circule_e,circule_p;
    TextView title,notice_date,description;


    public GeneralNoticeAdapter(Context context, ArrayList<DashboardInformation> array_general_notice){
        this.context = context;
        this.array_general_notice = array_general_notice;
    }


    @Override
    public int getCount() {
        return array_general_notice.size();
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
        View view = inflater.inflate(R.layout.list_general,viewGroup,false);
        Typeface font_icon = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");


        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");



        circule_g = (TextView) view.findViewById(R.id.circule_g);
        circule_s = (TextView)view.findViewById(R.id.circule_s);
        circule_e = (TextView)view.findViewById(R.id.circule_e);
        circule_p = (TextView)view.findViewById(R.id.circule_p);

        circule_g.setTypeface(typeface_semibold);
        circule_s.setTypeface(typeface_semibold);
        circule_e.setTypeface(typeface_semibold);
        circule_p.setTypeface(typeface_semibold);

        title = (TextView)view.findViewById(R.id.title);
        notice_date = (TextView)view.findViewById(R.id.notice_date);
        description = (TextView)view.findViewById(R.id.description);

        title.setTypeface(typeface_regular);
        notice_date.setTypeface(typeface_regular);
        description.setTypeface(typeface_regular);


        title.setText(array_general_notice.get(i).getTITLE());
        notice_date.setText(array_general_notice.get(i).getNOTICEDISPLAYDATE());
        description.setText(array_general_notice.get(i).getDESCRIPTION());
        if(array_general_notice.get(i).getDESCRIPTION().equals("")) {
             description.setText("Not Set");
            description.setTextColor(Color.RED);
            description.setTypeface(null, Typeface.ITALIC);
        }
        int userType = array_general_notice.get(i).getUSERTYPE();
        if(userType==0){
            circule_g.setVisibility(View.VISIBLE);
            circule_s.setVisibility(View.GONE);
        }
        else if(userType==4){
            circule_g.setVisibility(View.GONE);
            circule_s.setVisibility(View.VISIBLE);
        }else if(userType==3){
            circule_e.setVisibility(View.VISIBLE);
        }else if(userType==5){
            circule_p.setVisibility(View.VISIBLE);
        }

        return view;

    }
}

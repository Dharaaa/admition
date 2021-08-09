package com.systrack.admission.adapter.ExaminationAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.pojo.ExamTimeTableInformation;
import com.systrack.admission.pojo.PublishExamTimeTableInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ViewPublishExamTimeTableAdapter extends BaseAdapter {
    ArrayList<PublishExamTimeTableInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView category_name,category_alias;
    AppController appController;
    LinearLayout hall_no_linear;

    TextView exam_date,exam_time,subject,hall_no;
    TextView t1,t2,t3,t4;
    String ROLEID;
    public ViewPublishExamTimeTableAdapter(Context context, ArrayList<PublishExamTimeTableInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_view_publish_timetable,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");
        String  shared_short_date=sharedpreferences.getString(context.getString(R.string.short_display_date),"dd/MM/yyyy");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        exam_date= (TextView)view.findViewById(R.id.exam_date);
        exam_time = (TextView)view.findViewById(R.id.exam_time);
        subject = (TextView)view.findViewById(R.id.subject);
        hall_no = (TextView)view.findViewById(R.id.hall_no);
        hall_no_linear=view.findViewById(R.id.hall_no_linear);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);



        exam_date.setTypeface(typeface_regular);
        exam_time.setTypeface(typeface_regular);
        subject.setTypeface(typeface_regular);
        hall_no.setTypeface(typeface_regular);


//        exam_date.setText(arrayList.get(i).getdISPLAYEXAMDATE());
        exam_time.setText(arrayList.get(i).geteXAMTIME());
        subject.setText(arrayList.get(i).getsUBJECTNAME());
        hall_no.setText(arrayList.get(i).gethALLNO());

        exam_date.setText(appController.ConvertDate(arrayList.get(i).getdISPLAYEXAMDATE(),"MM/dd/yyyy",shared_short_date));


        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        if(ROLEID.equals("4") || ROLEID.equals("5")){
            hall_no_linear.setVisibility(View.VISIBLE);
        }else {
            hall_no_linear.setVisibility(View.GONE);
        }
        if(hall_no.getText().toString().equals("") || hall_no.getText().toString().equals(null) ){
            hall_no.setText("-");
        }


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

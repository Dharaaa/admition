package com.systrack.admission.adapter.ExaminationAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.fragment.Examination.ViewExamTimeTableFragment;
import com.systrack.admission.fragment.LeaveManagement.ViewLeaveApplicationFragment;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.HallArrangementStudentInformation;
import com.systrack.admission.pojo.PublishExamTimeTableInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PublishExamTimeTableAdapter extends BaseAdapter {
    ArrayList<PublishExamTimeTableInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    AppController appController;

    TextView name,tv_batch,section,tv_publish_date,tv_start_date,tv_end_date;
    TextView t1,t2,t3,t4,t5,t6;
    String ROLEID;
    FontAwesomeTextview view_timetable,view_marksheet;
    public PublishExamTimeTableAdapter(Context context, ArrayList<PublishExamTimeTableInformation > arrayList){
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
        final View view = inflater.inflate(R.layout.item_publish_exam_timetable,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");
      String  shared_short_date=sharedpreferences.getString(context.getString(R.string.short_display_date),"dd/MM/yyyy");


        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();


        name= (TextView)view.findViewById(R.id.name);
        tv_batch = (TextView)view.findViewById(R.id.tv_batch);
        section = (TextView)view.findViewById(R.id.section);
        tv_publish_date = (TextView)view.findViewById(R.id.tv_publish_date);
        tv_start_date = (TextView)view.findViewById(R.id.tv_start_date);
        tv_end_date = (TextView)view.findViewById(R.id.tv_end_date);

        view_marksheet=view.findViewById(R.id.view_marksheet);
        view_timetable=view.findViewById(R.id.view_timetable);


        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);        t5.setTypeface(typeface_semibold);
        t6=view.findViewById(R.id.t6);        t6.setTypeface(typeface_semibold);




        name.setTypeface(typeface_regular);
        tv_batch.setTypeface(typeface_regular);
        section.setTypeface(typeface_regular);
        tv_publish_date.setTypeface(typeface_regular);
        tv_start_date.setTypeface(typeface_regular);
        tv_end_date.setTypeface(typeface_regular);


        name.setText(arrayList.get(i).getEXAMNAME());
        tv_batch.setText(arrayList.get(i).getBATCHNAME());
        section.setText(arrayList.get(i).getSECTIONNAME());
//        tv_publish_date.setText(arrayList.get(i).getDISPLAYPUBLISHDATE());
//        tv_start_date.setText(arrayList.get(i).getMINDATE());
//        tv_end_date.setText(arrayList.get(i).getMAXDATE());

        tv_publish_date.setText(appController.ConvertDate(arrayList.get(i).getDISPLAYPUBLISHDATE(),"dd/MM/yyyy",shared_short_date));
        tv_start_date.setText(appController.ConvertDate(arrayList.get(i).getMINDATE(),"dd/MM/yyyy",shared_short_date));
        tv_end_date.setText(appController.ConvertDate(arrayList.get(i).getMAXDATE(),"dd/MM/yyyy",shared_short_date));


        view_timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appController.setPublish_timeTable_timeTableId(String.valueOf(arrayList.get(i).getTIMETABLEID()));
                appController.setPublish_timeTable_examName(arrayList.get(i).getEXAMNAME());
                appController.setPublish_timeTable_batchId(String.valueOf(arrayList.get(i).getBATCHID()));
                appController.setPublish_timeTable_sectionId(arrayList.get(i).getSECTIONID());
                appController.setPublish_timeTable_maxDate(arrayList.get(i).getMAXDATE());
                appController.setPublish_timeTable_minDate(arrayList.get(i).getMINDATE());

                appController.setPublish_timetable_batchName(arrayList.get(i).getBATCHNAME());
                appController.setPublish_timetable_sectionName(arrayList.get(i).getSECTIONNAME());



                ViewExamTimeTableFragment leaveapplication = new ViewExamTimeTableFragment();
                FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,leaveapplication);
                transaction.commit();

            }
        });


//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

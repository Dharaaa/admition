package com.systrack.admission.adapter.ExaminationAdapter;

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
import com.systrack.admission.pojo.HallArrangementStudentInformation;
import com.systrack.admission.pojo.PublishMarkSheetInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class PublishMarkSheetAdapter extends BaseAdapter {
    ArrayList<PublishMarkSheetInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView name,tv_batch_nm,tv_semester,tv_publish_date;
    AppController appController;

    TextView t1,t2,t3,t4;
    String ROLEID;
    public PublishMarkSheetAdapter(Context context, ArrayList<PublishMarkSheetInformation > arrayList){
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
        final View view = inflater.inflate(R.layout.item_publish_marksheet,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        ROLEID = sharedpreferences.getString(context.getString(R.string.roleid), "0");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");
        appController = (AppController)context.getApplicationContext();

        TextView name,tv_batch_nm,tv_semester,tv_publish_date;

        name= (TextView)view.findViewById(R.id.name);
        tv_batch_nm = (TextView)view.findViewById(R.id.tv_batch_nm);
        tv_semester = (TextView)view.findViewById(R.id.tv_semester);
        tv_publish_date = (TextView)view.findViewById(R.id.tv_publish_date);

        t1=view.findViewById(R.id.t1);        t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);        t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);        t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);        t4.setTypeface(typeface_semibold);




        name.setTypeface(typeface_regular);
        tv_batch_nm.setTypeface(typeface_regular);
        tv_semester.setTypeface(typeface_regular);
        tv_publish_date.setTypeface(typeface_regular);

        name.setText(arrayList.get(i).getEXAMNAME());
        tv_batch_nm.setText(arrayList.get(i).getBATCHNAME());
        tv_semester.setText(arrayList.get(i).getSECTIONNAME());
        tv_publish_date.setText(arrayList.get(i).getPUBLISHDATE()+"");



//        category_name.setText(array_category.get(i).getCATEGORYNAME());
//        category_alias.setText(array_category.get(i).getCATEGORYALIAS());


        return view;

    }
}

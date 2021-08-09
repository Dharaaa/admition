package com.systrack.admission.adapter.DashBoardMgtAdapter;

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
import com.systrack.admission.pojo.MessageInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class NoticeAdapter extends BaseAdapter {
    ArrayList<DashboardInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView description,title,userType,validTo,status;
    TextView t1,t2,t3,t4,t5;


    public NoticeAdapter(Context context, ArrayList<DashboardInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_notice,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");


        description= (TextView)view.findViewById(R.id.description);
        title= (TextView)view.findViewById(R.id.title);
        userType= (TextView)view.findViewById(R.id.userType);
        validTo= (TextView)view.findViewById(R.id.validTo);
        status= (TextView)view.findViewById(R.id.status);

        t1=view.findViewById(R.id.t1);     t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);     t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);     t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);     t4.setTypeface(typeface_semibold);
        t5=view.findViewById(R.id.t5);     t5.setTypeface(typeface_semibold);



        description.setTypeface(typeface_regular);
        title.setTypeface(typeface_regular);
        userType.setTypeface(typeface_regular);
        validTo.setTypeface(typeface_regular);
        status.setTypeface(typeface_regular);



        title.setText(arrayList.get(i).getTITLE());
        description.setText(arrayList.get(i).getDESCRIPTION());
        validTo.setText(arrayList.get(i).getDISPLAYNOTICEDATE());
        status.setText(arrayList.get(i).getNOTICESTATUS());
        if(arrayList.get(i).getUSERTYPE()==0){
            userType.setText("All");
        }else  if(arrayList.get(i).getUSERTYPE()==3){
            userType.setText("Employee");
        }else  if(arrayList.get(i).getUSERTYPE()==4){
            userType.setText("Student");
        }

        if(status.getText().toString().equals("Active")){
            status.setBackgroundColor(Color.parseColor("#5cb85c"));
        }else if(status.getText().toString().equals("In-Active")){
            status.setBackgroundColor(Color.RED);
        }

        if(arrayList.get(i).getDESCRIPTION().equals("")){
            description.setText("Not Set");
            description.setTextColor(Color.RED);
            description.setTypeface(null, Typeface.ITALIC);
        }






            return view;

    }
}

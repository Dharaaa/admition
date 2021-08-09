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
import com.systrack.admission.pojo.MessageInformation;
import com.systrack.admission.pojo.RoomCategoryInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class MessageOfDayAdapter extends BaseAdapter {
    ArrayList<MessageInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView status,userType,detail;
    TextView t1,t2,t3,t4;


    public MessageOfDayAdapter(Context context, ArrayList<MessageInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_msg_of_day,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        detail= (TextView)view.findViewById(R.id.detail);
        userType= (TextView)view.findViewById(R.id.userType);
        status= (TextView)view.findViewById(R.id.status);



        t1=view.findViewById(R.id.t1);     t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);     t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);     t3.setTypeface(typeface_semibold);


        detail.setTypeface(typeface_regular);
        userType.setTypeface(typeface_regular);
        status.setTypeface(typeface_regular);


        detail.setText(arrayList.get(i).getDETAIL());
        status.setText(arrayList.get(i).getMESSAGESTATUS());
        if(arrayList.get(i).getUSERTYPE().equals("0")){
            userType.setText("All");
        }else  if(arrayList.get(i).getUSERTYPE().equals("3")){
            userType.setText("Employee");
        }else  if(arrayList.get(i).getUSERTYPE().equals("4")){
            userType.setText("Student");
        }

        if(status.getText().toString().equals("Active")){
            status.setBackgroundColor(Color.parseColor("#5cb85c"));
        }else if(status.getText().toString().equals("In-Active")){
            status.setBackgroundColor(Color.RED);
        }





        return view;

    }
}

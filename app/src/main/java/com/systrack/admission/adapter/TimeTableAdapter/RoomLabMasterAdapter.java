package com.systrack.admission.adapter.TimeTableAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.pojo.RoomCategoryInformation;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class RoomLabMasterAdapter extends BaseAdapter {
    ArrayList<RoomCategoryInformation> arrayList;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView tv_name,tv_category,tv_capacity,location;
    TextView t1,t2,t3,t4;


    public RoomLabMasterAdapter(Context context, ArrayList<RoomCategoryInformation> arrayList){
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
        final View view = inflater.inflate(R.layout.item_room_lab,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        tv_name= (TextView)view.findViewById(R.id.tv_name);
        tv_capacity= (TextView)view.findViewById(R.id.tv_capacity);
        tv_category= (TextView)view.findViewById(R.id.tv_category);
        location= (TextView)view.findViewById(R.id.location);

        t1=view.findViewById(R.id.t1);     t1.setTypeface(typeface_semibold);
        t2=view.findViewById(R.id.t2);     t2.setTypeface(typeface_semibold);
        t3=view.findViewById(R.id.t3);     t3.setTypeface(typeface_semibold);
        t4=view.findViewById(R.id.t4);     t4.setTypeface(typeface_semibold);


        tv_name.setTypeface(typeface_regular);
        tv_capacity.setTypeface(typeface_regular);
        tv_category.setTypeface(typeface_regular);
        location.setTypeface(typeface_regular);


        tv_name.setText(arrayList.get(i).getROOMMASTERNAME());
        tv_category.setText(arrayList.get(i).getROOMCATEGORYNAME());
        tv_capacity.setText(arrayList.get(i).getSEATCAPACITY().toString());
        location.setText(arrayList.get(i).getLOCATION());






        return view;

    }
}

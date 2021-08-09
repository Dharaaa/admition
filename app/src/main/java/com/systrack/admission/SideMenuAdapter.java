package com.systrack.admission;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.systrack.admission.helpers.FontAwesomeTextview;


public class SideMenuAdapter extends BaseAdapter {

    String[] arraylist_menu;
    Context context;
    LayoutInflater inflater;

    public SideMenuAdapter(Context context, String[] arrayList) {

        this.context=context;
        this.arraylist_menu=arrayList;

    }

    @Override
    public int getCount() {
        return arraylist_menu.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view=inflater.inflate(R.layout.item_menu,parent,false);

        Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Regular.ttf");
        Typeface typeface_bold = Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-SemiBold.ttf");

        TextView txt_name=(TextView) view.findViewById(R.id.txt_manage_payroll_name);
        txt_name.setTypeface(typeface_regular);
        FontAwesomeTextview txt_manage_Icon=(FontAwesomeTextview) view.findViewById(R.id.txt_manage_payroll_icon);

        txt_name.setText(arraylist_menu[position]);
        txt_manage_Icon.setText(context.getResources().getString(R.string.HandBook_icon));



        return view;

    }
}

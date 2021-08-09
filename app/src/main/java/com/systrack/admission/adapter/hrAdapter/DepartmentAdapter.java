package com.systrack.admission.adapter.hrAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.systrack.admission.R;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.DepartmentInformation;
import com.systrack.admission.pojo.DesignationInformation;

import java.util.ArrayList;
import java.util.Map;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DepartmentAdapter extends BaseAdapter {
    ArrayList<DepartmentInformation> array_designation;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    TextView department_name,department_alias;


    public DepartmentAdapter(Context context, ArrayList<DepartmentInformation> array_designation){
        this.context = context;
        this.array_designation = array_designation;
    }

    @Override
    public int getCount() {
        return array_designation.size();
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
        final View view = inflater.inflate(R.layout.item_department,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        department_name= (TextView)view.findViewById(R.id.department_name);
        department_alias = (TextView)view.findViewById(R.id.department_alias);

        department_name.setTypeface(typeface_semibold);
        department_alias.setTypeface(typeface_regular);



        department_name.setText(array_designation.get(i).getDEPARTMENTNAME());
        department_alias.setText(array_designation.get(i).getDEPARTMENTALIAS());


        return view;

    }
}

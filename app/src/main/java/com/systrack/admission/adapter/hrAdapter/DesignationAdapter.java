package com.systrack.admission.adapter.hrAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.systrack.admission.R;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.DesignationInformation;
import com.systrack.admission.pojo.DesignationInformationPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DesignationAdapter extends BaseAdapter {
    ArrayList<DesignationInformation> array_designation;
    LayoutInflater inflater;
    Context context;
    SharedPreferences sharedpreferences;
    Map<String,String> params;
    TextView designationt_name,designation_alias;

    FontAwesomeTextview edit_designation,delete_designation;
    EditText new_designation_name,new_designation_alias;

    public DesignationAdapter(Context context, ArrayList<DesignationInformation> array_designation){
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
        final View view = inflater.inflate(R.layout.item_designation,viewGroup,false);
        sharedpreferences = context.getSharedPreferences(context.getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        Typeface font_icon = Typeface.createFromAsset(context.getAssets(), "fonts/fontawesome-webfont.ttf");

        final Typeface typeface_semibold = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-SemiBold.ttf");

        final Typeface typeface_regular = Typeface.createFromAsset(context.getAssets(),
                "fonts/Raleway-Regular.ttf");

        designationt_name = (TextView)view.findViewById(R.id.tv_designation_nm);
        designation_alias = (TextView)view.findViewById(R.id.tv_designation_alias);

        designationt_name.setTypeface(typeface_semibold);
        designation_alias.setTypeface(typeface_regular);



        designationt_name.setText(array_designation.get(i).getDESIGNATIONNAME());
        designation_alias.setText(array_designation.get(i).getDESIGNATIONALIAS());


        return view;

    }
}

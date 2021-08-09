package com.systrack.admission.fragment.Hr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.systrack.admission.AppController;
import com.systrack.admission.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class AddressEmployeeProfileFragement extends Fragment {

    SharedPreferences sharedpreferences;
    Map<String, String> params;
    AppController appController;

    TextView error;
    Spinner country_spinner,state_spinner,city_spinner;
    EditText pincode,house_no,mob_num,address;


    String selected_countryID, selected_country_name, selected_stateId, selected_stateName, selected_cityId, selected_cityNAme,selected_pincode,
            selected_houseno,selected_phone_no , selected_address;


    LinearLayout update_employee_address;


    EditText country_edittext,state_edittext,city_edittext;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragement_employee_address_tab, container, false);
        final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-Regular.ttf");




        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        appController = (AppController) getActivity().getApplicationContext();
        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");


//        country_spinner = (Spinner) view.findViewById(R.id.country_spinner);
//        state_spinner = (Spinner) view.findViewById(R.id.state_spinner);
//        city_spinner = (Spinner) view.findViewById(R.id.city_spinner);

//        pincode = (EditText) view.findViewById(R.id.pincode);
//        house_no = (EditText) view.findViewById(R.id.house_no);
//        mob_num = (EditText) view.findViewById(R.id.mob_num);
//        address = (EditText) view.findViewById(R.id.address);
//
//
//        country_edittext = (EditText)view.findViewById(R.id.country_edittext);
//        state_edittext = (EditText)view.findViewById(R.id.state_edittext);
//        city_edittext = (EditText)view.findViewById(R.id.city_edittext);
//





        return view;

    }

    @Override
    public void onResume() {
        super.onResume();

    }







}

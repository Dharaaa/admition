package com.systrack.admission.fragment.TimeTable;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.pojo.WeekDaysInformationPojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeekDaysFragment extends Fragment {


    View view;
    CheckBox monday_checkbox,tuesday_checkbox,wed_checkbox,thur_checkbox,fri_checkbox,saturday_checkbox,sunday_checkbox;
    Spinner spinner_monday,spinner_tuesday,spinner_wednesday,spinner_thursday,spinner_friday,spinner_saturday,spinner_sunday;
    TransparentProgressDialog mProgressDialog;
    SharedPreferences sharedpreferences;
    APIInterface apiInterface;

    TextView start_time_firsthalf,end_time_firsthalf,start_time_secondhalf,end_time_secondhalf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_week_days, container, false);
        ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        monday_checkbox=view.findViewById(R.id.monday_checkbox);
        tuesday_checkbox=view.findViewById(R.id.tuesday_checkbox);
        wed_checkbox=view.findViewById(R.id.wed_checkbox);
        thur_checkbox=view.findViewById(R.id.thur_checkbox);
        fri_checkbox=view.findViewById(R.id.fri_checkbox);
        saturday_checkbox=view.findViewById(R.id.saturday_checkbox);
        sunday_checkbox=view.findViewById(R.id.sunday_checkbox);

        start_time_firsthalf=view.findViewById(R.id.start_time_firsthalf);
        end_time_firsthalf=view.findViewById(R.id.end_time_firsthalf);
        start_time_secondhalf=view.findViewById(R.id.start_time_secondhalf);
        end_time_secondhalf=view.findViewById(R.id.end_time_secondhalf);

        spinner_sunday=view.findViewById(R.id.spinner_sunday);
        spinner_monday=view.findViewById(R.id.spinner_monday);
        spinner_tuesday=view.findViewById(R.id.spinner_tuesday);
        spinner_wednesday=view.findViewById(R.id.spinner_wednesday);
        spinner_thursday=view.findViewById(R.id.spinner_thursday);
        spinner_friday=view.findViewById(R.id.spinner_friday);
        spinner_saturday=view.findViewById(R.id.spinner_saturday);

        spinner_sunday.setEnabled(false);
        spinner_monday.setEnabled(false);
        spinner_tuesday.setEnabled(false);
        spinner_wednesday.setEnabled(false);
        spinner_thursday.setEnabled(false);
        spinner_friday.setEnabled(false);
        spinner_saturday.setEnabled(false);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.weekofftype, R.layout.spinner);
        adapter.setDropDownViewResource(R.layout.spinner);
        spinner_sunday.setAdapter(adapter);
        spinner_monday.setAdapter(adapter);
        spinner_tuesday.setAdapter(adapter);
        spinner_wednesday.setAdapter(adapter);
        spinner_thursday.setAdapter(adapter);
        spinner_friday.setAdapter(adapter);
        spinner_saturday.setAdapter(adapter);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimeTableMenuFragment timeTableMenuFragment = new TimeTableMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, timeTableMenuFragment);
                country.commit();

            }
        });
getWeekDayList();
        return view;
    }

    private void getWeekDayList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
        Log.e("Entity id ",entity_id + "  "+branch_id);

        Call<WeekDaysInformationPojo> call=apiInterface.FillWeekDaysList(entity_id,branch_id/*,display_item_count.getText().toString(),""*/);

        call.enqueue(new Callback<WeekDaysInformationPojo>() {
            @Override
            public void onResponse(Call<WeekDaysInformationPojo> call, Response<WeekDaysInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                WeekDaysInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getWeekDaysInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    int Size = pojoitem.getWeekDaysInformation().size();
//                    TOTAL_LIST_ITEMS= response.body().getRoomCategoryInformation().get(1).getTotalCount().toString();


                  boolean Monday=  pojoitem.getWeekDaysInformation().get(1).getMONDAY();
                    boolean tuesday=  pojoitem.getWeekDaysInformation().get(1).getTUESDAY();
                    boolean wednesday=  pojoitem.getWeekDaysInformation().get(1).getWEDNESDAY();
                    boolean thursday=  pojoitem.getWeekDaysInformation().get(1).getTHURSEDAY();
                    boolean friday=  pojoitem.getWeekDaysInformation().get(1).getFRIDAY();
                    boolean saturday=  pojoitem.getWeekDaysInformation().get(1).getSATURDAY();
                    boolean sunday=  pojoitem.getWeekDaysInformation().get(1).getSUNDAY();

                    String fStartTime=pojoitem.getWeekDaysInformation().get(1).getFHSTARTTIME();
                    String fEndTime=pojoitem.getWeekDaysInformation().get(1).getFHENDTIME();
String sStartTime=pojoitem.getWeekDaysInformation().get(1).getSHSTARTTIME();
String sEndTime=pojoitem.getWeekDaysInformation().get(1).getSHENDTIME();

Log.e("fStartTime ",fStartTime);
                        Log.e("fEndTime ",fEndTime);
                    Log.e("sStartTime   ",sStartTime);
                    Log.e("sEndTime ",sEndTime);

                        String weekofftype_sun,weekofftype_mon,weekofftype_tue,weekofftype_wed,weekofftype_thurs,weekofftype_fri,weekofftype_sat;
                    weekofftype_sun=pojoitem.getWeekDaysInformation().get(1).getWEEKOFFTYPESUN();
                    weekofftype_mon=pojoitem.getWeekDaysInformation().get(1).getWEEKOFFTYPEMON();
                    weekofftype_tue=pojoitem.getWeekDaysInformation().get(1).getWEEKOFFTYPETUE();
                    weekofftype_wed=pojoitem.getWeekDaysInformation().get(1).getWEEKOFFTYPEWED();
                    weekofftype_thurs=pojoitem.getWeekDaysInformation().get(1).getWEEKOFFTYPETHU();
                    weekofftype_fri=pojoitem.getWeekDaysInformation().get(1).getWEEKOFFTYPEFRI();
                    weekofftype_sat=pojoitem.getWeekDaysInformation().get(1).getWEEKOFFTYPESAT();

//                   String  startTime = "2013-02-27 21:06";
//                    StringTokenizer tk = new StringTokenizer(startTime);
//                    String date = tk.nextToken();
//                    String time = tk.nextToken();

                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
                    SimpleDateFormat sdfs = new SimpleDateFormat("hh:mm a");
                    Date dt,dtFStart,dtFEnd,dtSStart,dtSEnd;
                    try {
//                        dt = sdf.parse(time);
//                        Log.e("Time get ",time);
                        dtFStart=sdf.parse(fStartTime);
                        dtFEnd=sdf.parse(fEndTime);

                        dtSStart=sdf.parse(sStartTime);
                        dtSEnd=sdf.parse(sEndTime);

//                        Log.e("Time Display: " , sdfs.format(dt)); // <-- I got result here
//                        Log.e("Start Time ", sdfs.format(dtStart));
//                        Log.e("End Time ", sdfs.format(dtEnd));

                        start_time_firsthalf.setText(sdfs.format(dtFStart));
                        end_time_firsthalf.setText(sdfs.format(dtFEnd));

                        start_time_secondhalf.setText(sdfs.format(dtSStart));
                        end_time_secondhalf.setText(sdfs.format(dtSEnd));


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if(weekofftype_sun==null){
                        spinner_sunday.setSelection(0);
                    }else if(weekofftype_sun.equals("All")){
                        spinner_sunday.setSelection(0);
                    }else if(weekofftype_sun.equals("Odd")){
                        spinner_sunday.setSelection(2);
                    }else if(weekofftype_sun.equals("Even")){
                        spinner_sunday.setSelection(1);
                    }


                    if(weekofftype_mon==null){
                        spinner_monday.setSelection(0);
                    }else if(weekofftype_mon.equals("All")){
                        spinner_monday.setSelection(0);
                    }else if(weekofftype_mon.equals("Odd")){
                        spinner_monday.setSelection(2);
                    }else if(weekofftype_mon.equals("Even")){
                        spinner_monday.setSelection(1);
                    }


                    if(weekofftype_tue==null){
                        spinner_tuesday.setSelection(0);
                    }else if(weekofftype_tue.equals("All")){
                        spinner_tuesday.setSelection(0);
                    }else if(weekofftype_tue.equals("Odd")){
                        spinner_tuesday.setSelection(2);
                    }else if(weekofftype_tue.equals("Even")){
                        spinner_tuesday.setSelection(1);
                    }


                    if(weekofftype_wed==null){
                        spinner_wednesday.setSelection(0);
                    }else if(weekofftype_wed.equals("All")){
                        spinner_wednesday.setSelection(0);
                    }else if(weekofftype_wed.equals("Odd")){
                        spinner_wednesday.setSelection(2);
                    }else if(weekofftype_wed.equals("Even")){
                        spinner_wednesday.setSelection(1);
                    }


                    if(weekofftype_thurs==null){
                        spinner_thursday.setSelection(0);
                    }else if(weekofftype_thurs.equals("All")){
                        spinner_thursday.setSelection(0);
                    }else if(weekofftype_thurs.equals("Odd")){
                        spinner_thursday.setSelection(2);
                    }else if(weekofftype_thurs.equals("Even")){
                        spinner_thursday.setSelection(1);
                    }

                    if(weekofftype_fri==null){
                        spinner_friday.setSelection(0);
                    }else if(weekofftype_fri.equals("All")){
                        spinner_friday.setSelection(0);
                    }else if(weekofftype_fri.equals("Odd")){
                        spinner_friday.setSelection(2);
                    }else if(weekofftype_fri.equals("Even")){
                        spinner_friday.setSelection(1);
                    }

                    if(weekofftype_sat==null){
                        spinner_saturday.setSelection(0);
                    }else if(weekofftype_sat.equals("All")){
                        spinner_saturday.setSelection(0);
                    }else if(weekofftype_sat.equals("Odd")){
                        spinner_saturday.setSelection(2);
                    }else if(weekofftype_sat.equals("Even")){
                        spinner_saturday.setSelection(1);
                    }

                    if(Monday){
    monday_checkbox.setChecked(true);
}if(tuesday){
    tuesday_checkbox.setChecked(true);
}if(wednesday){
    wed_checkbox.setChecked(true);
}if(thursday){
    thur_checkbox.setChecked(true);
}if(friday){
    fri_checkbox.setChecked(true);
}if (saturday){
    saturday_checkbox.setChecked(true);
}if(sunday){
    sunday_checkbox.setChecked(true);
}
//                    start_time_firsthalf.setText(fStartTime);
//                    end_time_firsthalf.setText(fEndTime);
//                    start_time_secondhalf.setText(sStartTime);
//                    end_time_secondhalf.setText(sEndTime);


                }else
                {

                    String DisplayMsg=pojoitem.getWeekDaysInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<WeekDaysInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

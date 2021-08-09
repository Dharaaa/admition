package com.systrack.admission.fragment.TimeTable;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.systrack.admission.Activity.ClassTimingBatchActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.TimeTableAdapter.FragmentsTabAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.ClassTimingInformation;
import com.systrack.admission.pojo.ClassTimingInformationPojo;
import com.systrack.admission.pojo.TimeTableInformation;
import com.systrack.admission.pojo.TimeTableInformationPojo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchTimeTableFragment extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    APIInterface apiInterface;
    private FragmentsTabAdapter adapter;
    private ViewPager viewPager;
    private boolean switchSevenDays;
    public static final String
            KEY_SEVEN_DAYS_SETTING = "sevendays";
    TabLayout tabLayout;
    AppController appController;
    ArrayList<TimeTableInformation> arrayList;
    ImageView back_arrow;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_timetable_view_search, container, false);
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();
        adapter = new FragmentsTabAdapter(getActivity().getSupportFragmentManager());
        viewPager = view.findViewById(R.id.viewPager);
        tabLayout = view.findViewById(R.id.tabLayout);

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");

//getClassTimingList();
        setupFragments();
        setupSevenDaysPref();
        if(switchSevenDays) changeFragments(true);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeTableFragment coursefragment = new TimeTableFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });


        return view;
    }
    private void setupFragments() {

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        adapter.addFragment(new MondayFragment(), "Monday");
        adapter.addFragment(new TuesdayFragment(), "Tuesday");
        adapter.addFragment(new WednesdayFragment(), "Wednesday");
        adapter.addFragment(new ThursdayFragment(), "Thursday");
        adapter.addFragment(new FridayFragment(), "Friday");
        adapter.addFragment(new SaturdayFragment(), "Saturday");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(day == 1 ? 6 : day-2, true);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void changeFragments(boolean isChecked) {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(day == 1 ? 6 : day-2, true);
        tabLayout.setupWithViewPager(viewPager);
        adapter.notifyDataSetChanged();
    }

    private void setupSevenDaysPref() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        switchSevenDays = sharedPref.getBoolean(KEY_SEVEN_DAYS_SETTING, false);
    }


}

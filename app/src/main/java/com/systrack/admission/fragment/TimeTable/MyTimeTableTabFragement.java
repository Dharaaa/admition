package com.systrack.admission.fragment.TimeTable;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.R;
import com.systrack.admission.fragment.Examination.ExaminationMenuFragment;
import com.systrack.admission.fragment.Examination.HallArrangementFragment;
import com.systrack.admission.fragment.Examination.StudentListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyTimeTableTabFragement extends Fragment {


    View view;
    TextView daywise_tab,workload_tab;
    View hall_view,student_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_tab_my_timetable, container, false);
        workload_tab=view.findViewById(R.id.workload_tab);
        daywise_tab=view.findViewById(R.id.daywise_tab);



        DayWiseTimetableFragment hallArrangementFragement = new DayWiseTimetableFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.hall_allocation_frame,hallArrangementFragement);
        transaction.commit();


        workload_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                workload_tab.setBackgroundColor(getResources().getColor(R.color.dark_orange));
                daywise_tab.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                workload_tab.setTextColor(Color.WHITE);
                daywise_tab.setTextColor(getResources().getColor(R.color.background_color_black));

                WorkLoadAdjustFragment hallArrangementFragement = new WorkLoadAdjustFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.hall_allocation_frame,hallArrangementFragement);
                transaction.commit();

            }
        });

        daywise_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workload_tab.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                daywise_tab.setBackgroundColor(getResources().getColor(R.color.dark_orange));

                workload_tab.setTextColor(getResources().getColor(R.color.background_color_black));
                daywise_tab.setTextColor(Color.WHITE);

                DayWiseTimetableFragment hallArrangementFragement = new DayWiseTimetableFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.hall_allocation_frame,hallArrangementFragement);
                transaction.commit();

            }
        });



        return view;
    }

}

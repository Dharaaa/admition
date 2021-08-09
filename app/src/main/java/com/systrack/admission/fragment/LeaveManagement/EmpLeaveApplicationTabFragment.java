package com.systrack.admission.fragment.LeaveManagement;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.Activity.ManageEmployeeCourseAllActivity;
import com.systrack.admission.Activity.ManageEmployeeMediumByCourseActivity;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.adapter.LeaveMgtAdapter.CurrentLeaveApplicationAdapter;
import com.systrack.admission.fragment.Examination.HallArrangementFragment;
import com.systrack.admission.fragment.Examination.StudentListFragment;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmpLeaveApplicationTabFragment extends Fragment {


    View view;
    AppController appController;
    TextView current,history;
    ImageView back_arrow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_emp_leave_application_tab, container, false);
        appController = (AppController) getActivity().getApplicationContext();

        current=view.findViewById(R.id.current);
        history=view.findViewById(R.id.history);
       back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        CurrentLeaveApplicationFragment hallArrangementFragement = new CurrentLeaveApplicationFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.hall_allocation_frame,hallArrangementFragement);
        transaction.commit();

        current.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                current.setBackgroundColor(getResources().getColor(R.color.dark_orange));
                history.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                current.setTextColor(Color.WHITE);
                history.setTextColor(getResources().getColor(R.color.background_color_black));

                CurrentLeaveApplicationFragment hallArrangementFragement = new CurrentLeaveApplicationFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.hall_allocation_frame,hallArrangementFragement);
                transaction.commit();

            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                current.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                history.setBackgroundColor(getResources().getColor(R.color.dark_orange));

                current.setTextColor(getResources().getColor(R.color.background_color_black));
                history.setTextColor(Color.WHITE);

                HistoryLeaveApplicationFragment studentListFragement = new HistoryLeaveApplicationFragment();
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.replace(R.id.hall_allocation_frame,studentListFragement);
                transaction1.commit();

            }
        });


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LeaveMgtMenuFragment coursefragment = new LeaveMgtMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        return view;
    }

}

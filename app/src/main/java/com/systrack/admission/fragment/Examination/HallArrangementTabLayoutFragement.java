package com.systrack.admission.fragment.Examination;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.systrack.admission.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HallArrangementTabLayoutFragement extends Fragment {


    View view;
    TextView student_list,hall_arrangement;
    View hall_view,student_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_tab_hall_arrangement, container, false);
        hall_arrangement=view.findViewById(R.id.hall_arrangement);
        student_list=view.findViewById(R.id.student_list);

ImageView back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;


        HallArrangementFragment hallArrangementFragement = new HallArrangementFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.hall_allocation_frame,hallArrangementFragement);
        transaction.commit();


        hall_arrangement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hall_arrangement.setBackgroundColor(getResources().getColor(R.color.dark_orange));
                student_list.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                hall_arrangement.setTextColor(Color.WHITE);
                student_list.setTextColor(getResources().getColor(R.color.background_color_black));

                HallArrangementFragment hallArrangementFragement = new HallArrangementFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.hall_allocation_frame,hallArrangementFragement);
                transaction.commit();

            }
        });

        student_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hall_arrangement.setBackgroundColor(getResources().getColor(R.color.colorGrey));
                student_list.setBackgroundColor(getResources().getColor(R.color.dark_orange));

                hall_arrangement.setTextColor(getResources().getColor(R.color.background_color_black));
                student_list.setTextColor(Color.WHITE);

                StudentListFragment studentListFragement = new StudentListFragment();
                FragmentTransaction transaction1 = getFragmentManager().beginTransaction();
                transaction1.replace(R.id.hall_allocation_frame,studentListFragement);
                transaction1.commit();

            }
        });


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ExaminationMenuFragment coursefragment = new ExaminationMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });

        return view;
    }

}

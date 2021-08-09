package com.systrack.admission;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.systrack.admission.fragment.Hr.EmployeeOtherInfoTabFragement;
import com.systrack.admission.fragment.Hr.GuardianEmployeeFragement;
import com.systrack.admission.fragment.Hr.PersonalEmployeeProfileFragement;

import java.util.Map;

public class EmployeeProfileActivity extends AppCompatActivity {

    LinearLayout backBtn;
    TextView employee_name,employee_designation;
    TextView txt_personal,txt_academic,txt_guardians,other_info_tab;
    ImageView user_image;
    AppController appController;
    Map<String,String> params;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_profile_new);

        appController = (AppController)this.getApplicationContext();
        final Typeface typeface_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-Regular.ttf");



        backBtn = (LinearLayout)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        user_image = (ImageView)findViewById(R.id.user_image);

        employee_name = (TextView)findViewById(R.id.employee_name);
        employee_designation = (TextView)findViewById(R.id.employee_designation);
        sharedpreferences = getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);


        txt_personal = (TextView)findViewById(R.id.txt_personal);
        txt_guardians = (TextView)findViewById(R.id.txt_guardians);
        other_info_tab = (TextView)findViewById(R.id.other_info_tab);
        txt_personal.setTextColor(Color.WHITE);

        employee_name.setText(appController.getEmployee_Profile_FullNAme());
        employee_designation.setText(appController.getEmployee_Profile_DesignationNAme());
        if(savedInstanceState ==null){

//            txt_personal.setBackgroundColor(getResources().getColor(R.color.darkTextColor));
//            txt_guardians.setBackgroundColor(Color.TRANSPARENT);
//            other_info_tab.setBackgroundColor(Color.TRANSPARENT);
            txt_personal.setTextColor(getResources().getColor(R.color.dark_orange));
            txt_guardians.setTextColor(getResources().getColor(R.color.black));
            other_info_tab.setTextColor(getResources().getColor(R.color.black));
//

            PersonalEmployeeProfileFragement personalEmployeeProfileFragement = new PersonalEmployeeProfileFragement();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.employee_profile_frame,personalEmployeeProfileFragement);
            transaction.commit();

        }

        txt_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                txt_personal.setBackgroundColor(getResources().getColor(R.color.darkTextColor));
//                txt_guardians.setBackgroundColor(Color.TRANSPARENT);
//                other_info_tab.setBackgroundColor(Color.TRANSPARENT);
                txt_personal.setTextColor(getResources().getColor(R.color.dark_orange));
            txt_guardians.setTextColor(getResources().getColor(R.color.black));
            other_info_tab.setTextColor(getResources().getColor(R.color.black));

                PersonalEmployeeProfileFragement personalEmployeeProfileFragement = new PersonalEmployeeProfileFragement();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.employee_profile_frame,personalEmployeeProfileFragement);
                transaction.commit();



            }
        });
        txt_guardians.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                txt_guardians.setBackgroundColor(getResources().getColor(R.color.darkTextColor));
//                txt_personal.setBackgroundColor(Color.TRANSPARENT);
//                other_info_tab.setBackgroundColor(Color.TRANSPARENT);
               txt_personal.setTextColor(getResources().getColor(R.color.black));
            txt_guardians.setTextColor(getResources().getColor(R.color.dark_orange));
            other_info_tab.setTextColor(getResources().getColor(R.color.black));


                GuardianEmployeeFragement guardianEmployeeFragement = new GuardianEmployeeFragement();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.employee_profile_frame,guardianEmployeeFragement);
                transaction.commit();

            }
        });

        other_info_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                other_info_tab.setBackgroundColor(getResources().getColor(R.color.darkTextColor));
//                txt_personal.setBackgroundColor(Color.TRANSPARENT);
//                txt_guardians.setBackgroundColor(Color.TRANSPARENT);
                txt_personal.setTextColor(getResources().getColor(R.color.black));
            txt_guardians.setTextColor(getResources().getColor(R.color.black));
            other_info_tab.setTextColor(getResources().getColor(R.color.dark_orange));
////
                EmployeeOtherInfoTabFragement employeeOtherInfoTabFragement = new EmployeeOtherInfoTabFragement();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.employee_profile_frame,employeeOtherInfoTabFragement);
                transaction.commit();

            }
        });




    }
}

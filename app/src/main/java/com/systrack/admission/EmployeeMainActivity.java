package com.systrack.admission;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.fragment.AttendanceManagement.QuickMyAttendanceFragment;
import com.systrack.admission.fragment.ChangePasswordFragment;
import com.systrack.admission.fragment.DashBoardFragment;
import com.systrack.admission.fragment.Examination.ExaminationMenuFragment;
import com.systrack.admission.fragment.HolidayManagement.NationalHolidayFragment;
import com.systrack.admission.fragment.Hr.HrMenuFragment;
import com.systrack.admission.fragment.LeaveManagement.LeaveMgtMenuFragment;
import com.systrack.admission.fragment.StudentAttendance.StuAttendanceMenuFragment;
import com.systrack.admission.fragment.TimeTable.MyTimeTableTabFragement;
import com.systrack.admission.fragment.TimeTable.TimeTableMenuFragment;
import com.systrack.admission.pojo.AdmissionYearInformationPojo;
import com.systrack.admission.pojo.LoginInformationPojo;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    Toolbar toolbar;
    TextView toolbar_title,count_notification;
    RelativeLayout test_layout;
    String navMenuTitels[];
    DrawerLayout drawer_layout;
    ListView nav_emp_item_listview;
    ViewGroup header, manage_header, master_header;
TextView txt_header_username,text_header_email;
CircleImageView nav_header_image;
    APIInterface apiInterface;
    TransparentProgressDialog mProgressDialog;

    LayoutAnimationController animation;
    SideMenuAdapter sideMenuAdapter;
    DrawerLayout drawer;
    SharedPreferences sharedpreferences;
    Typeface typeface_semibold,typeface_regular;
    AppController appController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_emp_item_listview=findViewById(R.id.nav_emp_item_listview);
        appController = (AppController)getApplicationContext();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText("Dashboard ");
        setSupportActionBar(toolbar);

          typeface_semibold = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-SemiBold.ttf");
          typeface_regular = Typeface.createFromAsset(getAssets(),
                "fonts/Raleway-Regular.ttf");
        apiInterface= ApiClient.getClient().create(APIInterface.class);

        LayoutInflater inflater = getLayoutInflater();
        //Main Navigation ListView
        header = (ViewGroup) inflater.inflate(R.layout.navheader, nav_emp_item_listview, false);
        nav_emp_item_listview.addHeaderView(header, null, false);

        DashBoardFragment payroll_sal_head_fragment = new DashBoardFragment();
        FragmentTransaction payroll_emp_transaction = getSupportFragmentManager().beginTransaction();
        payroll_emp_transaction.replace(R.id.frame, payroll_sal_head_fragment);
        payroll_emp_transaction.commit();


        sharedpreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        getAdmissionYear();
//        test_layout = findViewById(R.id.test_layout);
//        count_notification = findViewById(R.id.count_notification);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        txt_header_username=(TextView) header.findViewById(R.id.txt_username) ;
        text_header_email=(TextView) findViewById(R.id.txt_head_email);
        nav_header_image=(CircleImageView) header.findViewById(R.id.img_user);

        String full_name=sharedpreferences.getString(getString(R.string.fullname),"0");
        String email=sharedpreferences.getString(getString(R.string.Email),"0");

        txt_header_username.setText(full_name);
        text_header_email.setText(email);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //notification_count_function();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                //notification_count_function();

            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

//        DashBoardFragment payroll_sal_head_fragment = new DashBoardFragment();
//        FragmentTransaction payroll_emp_transaction = getSupportFragmentManager().beginTransaction();
//        payroll_emp_transaction.replace(R.id.frame, payroll_sal_head_fragment);
//        payroll_emp_transaction.commit();

        ManageMenu();
        displaySelectedScreen(R.id.nav_home);


    }
    public void ManageMenu() {

        //nav_item_listview.removeHeaderView(manage_header) ;


        final String[] managePayroll_subTitlesName_array = getResources().getStringArray(R.array.nav_item_emp_titles);

        sideMenuAdapter = new SideMenuAdapter(EmployeeMainActivity.this, managePayroll_subTitlesName_array);
        nav_emp_item_listview.setAdapter(sideMenuAdapter);
        nav_emp_item_listview.setLayoutAnimation(animation);


        nav_emp_item_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String managePayroll_subTitlesName = managePayroll_subTitlesName_array[position-1];
Log.e("Menu name ",managePayroll_subTitlesName);
                switch (managePayroll_subTitlesName) {
                    case "Dashboard":

                        drawer.closeDrawer(GravityCompat.START);

                        toolbar_title.setText("Dashboard");


                        DashBoardFragment dashBoardFragment = new DashBoardFragment();
                        FragmentTransaction dashBoard_transaction = getSupportFragmentManager().beginTransaction();
                        dashBoard_transaction.replace(R.id.frame, dashBoardFragment);
                        dashBoard_transaction.commit();

                        break;

                    case "HR":

                        toolbar_title.setText("HR");



                        drawer.closeDrawer(GravityCompat.START);
                        HrMenuFragment hrMenuFragment = new HrMenuFragment();
                        FragmentTransaction hrMenu_transaction = getSupportFragmentManager().beginTransaction();
                        hrMenu_transaction.replace(R.id.frame, hrMenuFragment);
                        hrMenu_transaction.commit();

                        break;

                    case "My Attendance":

                        toolbar_title.setText("My Attendance");


                        QuickMyAttendanceFragment courseMgtMenuFragment = new QuickMyAttendanceFragment();
                        FragmentTransaction course_transaction = getSupportFragmentManager().beginTransaction();
                        course_transaction.replace(R.id.frame, courseMgtMenuFragment);
                        course_transaction.commit();
                        drawer.closeDrawer(GravityCompat.START);


                        break;

                    case "Time Table":

                        toolbar_title.setText("Time Table");
                        drawer.closeDrawer(GravityCompat.START);
                        TimeTableMenuFragment timeTableMenuFragment = new TimeTableMenuFragment();
                        FragmentTransaction timeTable_transaction = getSupportFragmentManager().beginTransaction();
                        timeTable_transaction.replace(R.id.frame, timeTableMenuFragment);
                        timeTable_transaction.commit();

                        break;
                    case "Student Attendance":
                        toolbar_title.setText("Student Attendance");
                        drawer.closeDrawer(GravityCompat.START);
                        StuAttendanceMenuFragment stuAttendanceMenuFragment = new StuAttendanceMenuFragment();
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame, stuAttendanceMenuFragment);
                        transaction.commit();

                        break;
                    case "Leave Management":
                        toolbar_title.setText("Leave Management");
                        drawer.closeDrawer(GravityCompat.START);
                        LeaveMgtMenuFragment leaveMgtMenuFragment = new LeaveMgtMenuFragment();
                        FragmentTransaction leave_transaction = getSupportFragmentManager().beginTransaction();
                        leave_transaction.replace(R.id.frame, leaveMgtMenuFragment);
                        leave_transaction.commit();

                        break;
                    case "My TimeTable":
                        toolbar_title.setText("My TimeTable");
                        drawer.closeDrawer(GravityCompat.START);
                        MyTimeTableTabFragement attendanceMgtMenuFragment = new MyTimeTableTabFragement();
                        FragmentTransaction attendance_transaction = getSupportFragmentManager().beginTransaction();
                        attendance_transaction.replace(R.id.frame, attendanceMgtMenuFragment);
                        attendance_transaction.commit();

                        break;
                    case "National Holiday":
                        toolbar_title.setText("National Holiday");
                        drawer.closeDrawer(GravityCompat.START);
                        NationalHolidayFragment holidayMgtMenuFragment = new NationalHolidayFragment();
                        FragmentTransaction holiday_transaction = getSupportFragmentManager().beginTransaction();
                        holiday_transaction.replace(R.id.frame, holidayMgtMenuFragment);
                        holiday_transaction.commit();

                        break;

                    case "Examination":
                        toolbar_title.setText("Examination");
                        drawer.closeDrawer(GravityCompat.START);
                        ExaminationMenuFragment examinationMenuFragment = new ExaminationMenuFragment();
                        FragmentTransaction examination_transaction = getSupportFragmentManager().beginTransaction();
                        examination_transaction.replace(R.id.frame, examinationMenuFragment);
                        examination_transaction.commit();

                        break;

                    case "Log Out":
                        OnClickLogOut();
                        break;
                        default:
                            break;
                    case "Change Password":
                        toolbar_title.setText("Change Password");
                        drawer.closeDrawer(GravityCompat.START);

                        ChangePasswordFragment changePasswordFragment = new ChangePasswordFragment();
                        FragmentTransaction psw_transaction = getSupportFragmentManager().beginTransaction();
                        psw_transaction.replace(R.id.frame, changePasswordFragment);
                        psw_transaction.commit();


                        break;

                }

            }
        });

    }

    public void OnClickLogOut(){
        Log.e("click ","Logout");
        AlertDialog.Builder mbuilder = new AlertDialog.Builder(EmployeeMainActivity.this);
        LayoutInflater inflater = (LayoutInflater) EmployeeMainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);

        View deleteView = inflater.inflate(R.layout.layout_logout,null);
        mbuilder.setView(deleteView);
        final AlertDialog dialog = mbuilder.create();
        dialog.show();

        final ImageView cancel_popup = (ImageView)deleteView.findViewById(R.id.closepopup);
        final Button cancel_delete_action = (Button)deleteView.findViewById(R.id.cancel);
        final Button okay_delete_item = (Button)deleteView.findViewById(R.id.okay_delete_item);

        TextView title=(TextView)  deleteView.findViewById(R.id.title); title.setTypeface(typeface_semibold);
        TextView description=(TextView)  deleteView.findViewById(R.id.description);  description.setTypeface(typeface_regular);
        cancel_delete_action.setTypeface(typeface_semibold);
        okay_delete_item.setTypeface(typeface_semibold);

        cancel_popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        cancel_delete_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        okay_delete_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogOutApiCall();
                dialog.dismiss();
            }
        });
    }
    private void LogOutApiCall() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(EmployeeMainActivity.this);
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
      String  shared_UserId = sharedpreferences.getString(getResources().getString(R.string.userid),"");

        Call<LoginInformationPojo> call=apiInterface.Logout(shared_UserId);

        call.enqueue(new Callback<LoginInformationPojo>() {
            @Override
            public void onResponse(Call<LoginInformationPojo> call, Response<LoginInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                LoginInformationPojo pojoitem=response.body();

                assert pojoitem != null;
                String StatusCode=pojoitem.getLoginInformation().get(0).getStatusCode();
                String displayMsg=pojoitem.getLoginInformation().get(0).getDisplayMessage();


                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {

                    Toast.makeText(EmployeeMainActivity.this,displayMsg,Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.remove(getResources().getString(R.string.userid));
                    editor.remove(getResources().getString(R.string.username));
                    editor.remove(getResources().getString(R.string.usertype));
                    editor.remove(getResources().getString(R.string.entityid));
                    editor.remove(getResources().getString(R.string.branchId));
                    editor.remove(getResources().getString(R.string.fullname));
                    editor.remove(getResources().getString(R.string.Email));
//                    editor.putString(getResources().getString(R.string.StudentClassId),String.valueOf(pojoitem.getLoginInformation().get(1).getSTUDENTCLASSID()));
                    editor.remove(getResources().getString(R.string.profile_url));
//                    editor.putString(getResources().getString(R.string.ISALLOWVIDEOUPLOAD),String.valueOf(pojoitem.getLoginInformation().get(1).getISALLOWVIDEOUPLOAD()));
//                    editor.putString(getResources().getString(R.string.feedbackEmail),String.valueOf(pojoitem.getLoginInformation().get(1).getFeedbackEmail()));
                    editor.commit();
                    finish();
                    startActivity(new Intent(EmployeeMainActivity.this,LoginActivity.class));


                }else
                {
                    String DisplayMsg=pojoitem.getLoginInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(EmployeeMainActivity.this,DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<LoginInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_home:
                Toast.makeText(EmployeeMainActivity.this, "nav_home select", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(EmployeeMainActivity.this, "nav_gallary select", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_slideshow:
                Toast.makeText(EmployeeMainActivity.this, "nav_slideshow select", Toast.LENGTH_SHORT).show();
                break;
        }

        //replacing the fragment
//        if (fragment != null) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.content_frame, fragment);
//            ft.commit();
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        //make this method blank
        return true;
    }

    private void getAdmissionYear() {


        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
        String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


        Call<AdmissionYearInformationPojo> call = apiInterface.FillAdmissionYearList(entity_id);
        call.enqueue(new Callback<AdmissionYearInformationPojo>() {
            @Override
            public void onResponse(Call<AdmissionYearInformationPojo> call, Response<AdmissionYearInformationPojo> response) {
                Log.e("Response  ", new Gson().toJson(response.body()));


                AdmissionYearInformationPojo pojoitem = response.body();

                String StatusCode = pojoitem.getAdmissionYearInformation().get(0).getStatusCode();


                if (StatusCode.equals("200")) {

                    String  currentAcademicYear= String.valueOf(pojoitem.getAdmissionYearInformation().get(1).getYEAR());
                    appController.setCurrentAcademicYear(currentAcademicYear);

                } else {

                    String DisplayMsg = pojoitem.getAdmissionYearInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(EmployeeMainActivity.this, DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AdmissionYearInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });

    }

}



package com.systrack.admission.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.DashBoardAdapter.DashboardBirthdayMainAdapter;
import com.systrack.admission.adapter.DashBoardAdapter.DashboardCourseListAdapter;
import com.systrack.admission.adapter.HolidayAdapter.HolidayAdapter;
import com.systrack.admission.fragment.DashBoard.EmpNoticeFragement;
import com.systrack.admission.fragment.DashBoard.GeneralNoticeFragement;
import com.systrack.admission.fragment.DashBoard.StudentNoticeFragement;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.BirthDayList;
import com.systrack.admission.pojo.CourseList;
import com.systrack.admission.pojo.DashboardInformationPojo;
import com.systrack.admission.pojo.HolidayInformation;
import com.systrack.admission.pojo.HolidayInformationPojo;
import com.systrack.admission.pojo.MainDashBoardInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashBoardFragment extends Fragment {


    View view;
    TextView employee_notice,student_notice,general_notice;
    APIInterface apiInterface;
    SharedPreferences sharedpreferences;
    AppController appController;
    String ROLEID;
FontAwesomeTextview message_ofDay,birthday_no_data;
CardView card_birthday;
TextView total_students,total_employee,marque;
ListView list_birthday,list_courses_available;
    TransparentProgressDialog mProgressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_dashboard, container, false);

        final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-SemiBold.ttf");
        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Raleway-Regular.ttf");


        message_ofDay = (FontAwesomeTextview)view.findViewById(R.id.message_ofDay);
        Typeface font_icon = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(), "fonts/fontawesome-webfont.ttf");
        message_ofDay.setTypeface(font_icon);

        card_birthday = (CardView)view.findViewById(R.id.card_birthday);

        total_students = (TextView)view.findViewById(R.id.total_students);

        list_birthday = (ListView)view.findViewById(R.id.list_birthday);
        list_birthday.setNestedScrollingEnabled(true);


        list_courses_available = (ListView)view.findViewById(R.id.list_courses_available);
        list_courses_available.setNestedScrollingEnabled(true);

        total_employee = (TextView)view.findViewById(R.id.total_employee);
        total_students = (TextView)view.findViewById(R.id.total_students);

        birthday_no_data = (FontAwesomeTextview) view.findViewById(R.id.birthday_no_data);

        marque = (TextView)view.findViewById(R.id.MarqueeText);
        marque.setSelected(true);
        marque.setTypeface(typeface_regular);
        TextView course_name=(TextView)  view.findViewById(R.id.course_name);
        course_name.setTypeface(typeface_semibold);
        TextView no_student=(TextView)  view.findViewById(R.id.no_student);
        no_student.setTypeface(typeface_semibold);



        general_notice=view.findViewById(R.id.general_notice);
        student_notice=view.findViewById(R.id.student_notice);
        employee_notice=view.findViewById(R.id.employee_notice);
        general_notice.setTypeface(typeface_semibold);

        sharedpreferences = getActivity().getApplicationContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        appController = (AppController) getActivity().getApplicationContext();
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        ROLEID = sharedpreferences.getString(getString(R.string.roleid),"0");
        //Log.e("RoleId",role_id);

        if(ROLEID.equals("2")){
            //Administrator role id
            student_notice.setVisibility(View.VISIBLE);
            employee_notice.setVisibility(View.VISIBLE);

        }else if(ROLEID.equals("3")){
            //employee role id
            student_notice.setVisibility(View.GONE);
            employee_notice.setVisibility(View.VISIBLE);
        }else if(ROLEID.equals("4")){
            //student role id
            student_notice.setVisibility(View.VISIBLE);
            employee_notice.setVisibility(View.GONE);
        }
        GeneralNoticeFragement generalNoticeFragement = new GeneralNoticeFragement();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_notice,generalNoticeFragement);
        transaction.commit();

        general_notice.setBackground(getResources().getDrawable(R.drawable.button_background_blue));
        student_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                general_notice.setBackground(null);
                employee_notice.setBackground(null);
                student_notice.setBackground(getResources().getDrawable(R.drawable.button_background_blue));
                student_notice.setTextColor(getResources().getColor(R.color.whiteTextColor));
                general_notice.setTextColor(getResources().getColor(R.color.black));
                employee_notice.setTextColor(getResources().getColor(R.color.black));
                student_notice.setTypeface(typeface_semibold);
                employee_notice.setTypeface(typeface_regular);
                general_notice.setTypeface(typeface_regular);
                StudentNoticeFragement generalNoticeFragement = new StudentNoticeFragement();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_notice,generalNoticeFragement);
                transaction.commit();



            }
        });

        general_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employee_notice.setBackground(null);
                student_notice.setBackground(null);
                general_notice.setBackground(getResources().getDrawable(R.drawable.button_background_blue));
                general_notice.setTextColor(getResources().getColor(R.color.whiteTextColor));
                student_notice.setTextColor(getResources().getColor(R.color.black));
                employee_notice.setTextColor(getResources().getColor(R.color.black));
                general_notice.setTypeface(typeface_semibold);
                employee_notice.setTypeface(typeface_regular);
                student_notice.setTypeface(typeface_regular);

                GeneralNoticeFragement generalNoticeFragement = new GeneralNoticeFragement();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_notice,generalNoticeFragement);
                transaction.commit();



            }
        });
        employee_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                general_notice.setBackground(null);
                student_notice.setBackground(null);
                employee_notice.setBackground(getResources().getDrawable(R.drawable.button_background_blue));
                employee_notice.setTextColor(getResources().getColor(R.color.whiteTextColor));
                student_notice.setTextColor(getResources().getColor(R.color.black));
                general_notice.setTextColor(getResources().getColor(R.color.black));

                employee_notice.setTypeface(typeface_semibold);
                student_notice.setTypeface(typeface_regular);
                general_notice.setTypeface(typeface_regular);

                EmpNoticeFragement generalNoticeFragement = new EmpNoticeFragement();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_notice,generalNoticeFragement);
                transaction.commit();


            }
        });

        getAllDashBoardData();


        return view;
    }

    private void getAllDashBoardData() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
        String ROLEID = sharedpreferences.getString(getString(R.string.roleid), "0");
        String  shared_UserId = sharedpreferences.getString(getResources().getString(R.string.userid),"");

        String sectionId="0";


        Call<MainDashBoardInformationPojo> call=apiInterface.GetAllDashboardData(entity_id,branch_id,ROLEID,sectionId,shared_UserId);

        call.enqueue(new Callback<MainDashBoardInformationPojo>() {
            @Override
            public void onResponse(Call<MainDashBoardInformationPojo> call, Response<MainDashBoardInformationPojo> response) {
                Log.e("Response  Dashboard ", new Gson().toJson(response.body()));



                MainDashBoardInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getDashBoardInformation().getStatusCode();



                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {


                    // Birthday List
                    String statusCodeBirthday=pojoitem.getDashBoardInformation().getBirthDayList().get(0).getStatusCode();
                    if(statusCodeBirthday.equals("200")){
                        birthday_no_data.setVisibility(View.GONE);
                        list_birthday.setVisibility(View.VISIBLE);

                       ArrayList<BirthDayList> array_dashboard_birthday = new ArrayList<BirthDayList>();
                        int Size = pojoitem.getDashBoardInformation().getBirthDayList().size();
                        for(int i=1;i<Size;i++){
                            BirthDayList pojo=new BirthDayList();
                            pojo.setFULLNAME(pojoitem.getDashBoardInformation().getBirthDayList().get(i).getFULLNAME());
                            pojo.setDESIGNATIONNAME(pojoitem.getDashBoardInformation().getBirthDayList().get(i).getDESIGNATIONNAME());
                            array_dashboard_birthday.add(pojo);
                        }
                        DashboardBirthdayMainAdapter adapter=new DashboardBirthdayMainAdapter(getContext(),array_dashboard_birthday);
                        list_birthday.setAdapter(adapter);



                    }else{
                        String msgBirthDay=pojoitem.getDashBoardInformation().getBirthDayList().get(0).getMessage();
                        birthday_no_data.setVisibility(View.VISIBLE);
                        list_birthday.setVisibility(View.GONE);

                    }

                    //Employee Student Count
                    String statusCodeCount=pojoitem.getDashBoardInformation().getEmployeeStudentCount().get(0).getStatusCode();
                    if(statusCodeCount.equals("200")){
                        int employeeCount=pojoitem.getDashBoardInformation().getEmployeeStudentCount().get(0).getEmployeeData();
                        int studentCount=pojoitem.getDashBoardInformation().getEmployeeStudentCount().get(0).getStudentData();
                          total_employee.setText(employeeCount+"");
                          total_students.setText(studentCount+"");

                    }

                      //CourseList
                    String statusCodeCourseList=pojoitem.getDashBoardInformation().getCourseList().get(0).getStatusCode();
                    if(statusCodeCourseList.equals("200")){
                        list_courses_available.setVisibility(View.VISIBLE);
                       ArrayList<CourseList> courseLists=new ArrayList<>();
                        int Size = pojoitem.getDashBoardInformation().getCourseList().size();
                        for(int i=1;i<Size;i++){
                            CourseList pojo=new CourseList();
                            pojo.setCOURSENAME(pojoitem.getDashBoardInformation().getCourseList().get(i).getCOURSENAME());
                            pojo.setSTUDENTCNT(pojoitem.getDashBoardInformation().getCourseList().get(i).getSTUDENTCNT());
                            courseLists.add(pojo);
                        }
                        DashboardCourseListAdapter adapter=new DashboardCourseListAdapter(getContext(),courseLists);
                        list_courses_available.setAdapter(adapter);



                    }else{
                        list_courses_available.setVisibility(View.GONE);
                    }

                    // Messafe of Day
                    String statusCodeMsgOfDay=pojoitem.getDashBoardInformation().getMesageOfDay().get(0).getStatusCode();
                    if(statusCodeMsgOfDay.equals("200")){
                        String msgOfDay=pojoitem.getDashBoardInformation().getMesageOfDay().get(0).getDisplayMessage();
                        marque.setText(msgOfDay);

                    }




                }else
                {
//                    no_data.setVisibility(View.VISIBLE);
//                    listView.setVisibility(View.GONE);
//                    Next.setEnabled(false);

                    String DisplayMsg=pojoitem.getDashBoardInformation().getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<MainDashBoardInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

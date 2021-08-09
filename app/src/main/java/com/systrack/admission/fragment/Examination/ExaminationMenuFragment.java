package com.systrack.admission.fragment.Examination;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.systrack.admission.R;
import com.systrack.admission.adapter.ExamMenuAdapter;
import com.systrack.admission.adapter.HrMenuAdapter;


public class ExaminationMenuFragment extends Fragment {
    TextView titleacademic;
    RecyclerView academic_list_item;
    SharedPreferences sharedpreferences;
    ProgressDialog mprogress;
    private String[] ListMenu;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragement_hr_menu, container, false);


//        Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
//                "fonts/Raleway-SemiBold.ttf");
//
//
//
//        final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
//                "fonts/Raleway-Regular.ttf");


        titleacademic = (TextView)view.findViewById(R.id.titleacademic);
//        titleacademic.setTypeface(typeface_semibold);
//        titleacademic.setText( "Path : // "+ sharedpreferences.getString("first_menu_name","")+" / Course Management");

        academic_list_item = (RecyclerView)view.findViewById(R.id.academic_itemlist);
        ListMenu = getResources().getStringArray(R.array.examination_titles);


//        sideMenuAdapter = new SideMenuAdapter(MainActivity.this, managePayroll_subTitlesName_array);
//        nav_emp_item_listview.setAdapter(sideMenuAdapter);
//        nav_emp_item_listview.setLayoutAnimation(animation);
        ExamMenuAdapter adapter = new ExamMenuAdapter(getContext(),ListMenu);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        academic_list_item.setLayoutManager(layoutManager);
        academic_list_item.setAdapter(adapter);


        return view;
    }



}























//
//                        RequestQueue queue = Volley.newRequestQueue(getActivity());
//        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.BASE_URL + "MenuService.asmx/GetChildMenu", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try{
//                    JSONObject obj = new JSONObject(response);
//                    JSONArray menuinformation = obj.getJSONArray("MenuListInforamtion");
//                    JSONObject statuscode = menuinformation.getJSONObject(0);
//                    String code = statuscode.getString("StatusCode");
//                    if(code.equals("200")){
//                        mprogress.hide();
//
//                        JSONObject menuobject = menuinformation.getJSONObject(1);
//                        JSONArray menuarray = menuobject.getJSONArray("Menu");
//                        JSONObject inner_menu = menuarray.getJSONObject(0);
//                        JSONArray submenuarray = inner_menu.getJSONArray("SubMenu");
//                        final JSONArray childemenuarray = submenuarray.getJSONObject(0).getJSONArray("ChildMenu");
//                        final  JSONArray timetablearray = submenuarray.getJSONObject(1).getJSONArray("ChildMenu");
////
////                        for(int i = 0;i<submenuarray.length(); i++){
////                            if(submenuarray.getJSONObject(i).getString("Title").equals("Course Management")){
////                                Log.e("title","couser");
////                                JSONArray courseArray = submenuarray.getJSONObject(i).getJSONArray("ChildMenu");
////                                Log.e("courseArray", String.valueOf(courseArray));
//                                ArrayList<ChildMenuListPOJO> array = new ArrayList<ChildMenuListPOJO>();
//
//                                    for(int j=0; j<childemenuarray.length(); j++){
//                                        JSONObject childobject = childemenuarray.getJSONObject(j);
//                                        ChildMenuListPOJO child = new ChildMenuListPOJO();
//                                        child.setItemtitle(childobject.getString("Title"));
//                                        child.setItemicon(childobject.getString("Icon"));
//                                        array.add(child);
//                                    }
//                                    CourseAdapter adapter = new CourseAdapter(getContext(),array);
//                                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
//                                    academic_list_item.setLayoutManager(layoutManager);
//                                    academic_list_item.setAdapter(adapter);
//
//                        academic_list_item.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), academic_list_item, new RecyclerTouchListener.ClickListener(){
//
//                            @Override
//                            public void onClick(View view, int position) {
//
//                                switch (position){
//                                    case 0:
//                                        AcademicYearFragement academicYearFragement = new AcademicYearFragement();
//                                        FragmentTransaction country = getFragmentManager().beginTransaction();
//                                        country.replace(R.id.frame, academicYearFragement);
//                                        country.commit();
//                                        break;
//
//                                    case 1:
//                                        CourseAcademicFragement courseAcademicFragement = new CourseAcademicFragement();
//                                        FragmentTransaction course = getFragmentManager().beginTransaction();
//                                        course.replace(R.id.frame, courseAcademicFragement);
//                                        course.commit();
//                                        break;
//                                    case 2:
//                                        YearWiseCourseFragement yearWiseCourseFragement = new YearWiseCourseFragement();
//                                        FragmentTransaction year = getFragmentManager().beginTransaction();
//                                        year.replace(R.id.frame, yearWiseCourseFragement);
//                                        year.commit();
//                                        break;
//                                    case 3:
//                                        BatchFragement batchFragement = new BatchFragement();
//                                        FragmentTransaction batch = getFragmentManager().beginTransaction();
//                                        batch.replace(R.id.frame, batchFragement);
//                                        batch.commit();
//                                        break;
//                                    case 4:
//                                        SectionFragement sectionFragement = new SectionFragement();
//                                        FragmentTransaction section = getFragmentManager().beginTransaction();
//                                        section.replace(R.id.frame, sectionFragement);
//                                        section.commit();
//                                        break;
//                                    case 5:
//                                        //class division
//                                        ClassDivisionFragement classDivisionFragement = new ClassDivisionFragement();
//                                        FragmentTransaction division = getFragmentManager().beginTransaction();
//                                        division.replace(R.id.frame, classDivisionFragement);
//                                        division.commit();
//
//                                        break;
//                                    case 6:
//                                        SubjectMasterFragement subjectMasterFragement = new SubjectMasterFragement();
//                                        FragmentTransaction subject = getFragmentManager().beginTransaction();
//                                        subject.replace(R.id.frame, subjectMasterFragement);
//                                        subject.commit();
//                                        break;
//                                }
//
//                            }
//
//                            @Override
//                            public void onLongClick(View view, int position) {
//
//                            }
//                        }));
//
//
//                    }
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        },new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                if (error instanceof NetworkError) {
//                    String message = "Cannot connect to Internet...Please check your connection!";
//                    Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
////                    no_data.setVisibility(View.VISIBLE);
//                }else{
//                    Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("entityID", String.valueOf(sharedpreferences.getInt(getString(R.string.key_login_entityid),0)));
//                params.put("branchID", String.valueOf(sharedpreferences.getInt(getString(R.string.key_login_branchid),0)));
//                params.put("userid", String.valueOf(sharedpreferences.getInt(getString(R.string.key_login_userid),0)));
//                params.put("username", sharedpreferences.getString(getString(R.string.key_login_username),""));
//                params.put("roleID", String.valueOf(sharedpreferences.getInt(getString(R.string.key_login_roleid),0)));
//                params.put("menuName",Menuname);
//                params.put("isMultipleBranch", String.valueOf(sharedpreferences.getBoolean(getString(R.string.key_login_ismultiplebranch),false)));
//                params.put("IsElectiveEnabled", String.valueOf(sharedpreferences.getBoolean(getString(R.string.key_login_iselective),false)));
//                params.put("AllowDivision", String.valueOf(sharedpreferences.getBoolean(getString(R.string.key_login_allowvision),false)));
//                params.put("IsPracticalEnabled", String.valueOf(sharedpreferences.getBoolean(getString(R.string.key_login_ispractical),false)));
//                params.put("IsAllowedEmployeeLogIn", String.valueOf(sharedpreferences.getBoolean(getString(R.string.key_login_isemployeelogin),false)));
//                params.put("IsAllowedStudentLogIn", String.valueOf(sharedpreferences.getBoolean(getString(R.string.key_login_isstudentlogin),false)));
//                return params;
//            }
//        };
////        AppController.getInstance(getActivity()).addToRequestQueue(stringRequest);
//        queue.add(stringRequest);





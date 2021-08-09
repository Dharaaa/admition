package com.systrack.admission.fragment.Examination;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.gson.Gson;
import com.systrack.admission.AppController;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.Constant;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.ExaminationAdapter.StudentListAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.helpers.GetJSONListener;
import com.systrack.admission.helpers.PostCallWSTask;
import com.systrack.admission.pojo.BroadSheetInformation;
import com.systrack.admission.pojo.BroadSheetInformationPojo;
import com.systrack.admission.pojo.ExamIdInformationPojo;
import com.systrack.admission.pojo.HallArrangementStudentInformation;
import com.systrack.admission.pojo.HallArrangementStudentInformationPojo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchBroadSheetListFragement extends Fragment {


    View view;
    LinearLayout linear_list;

    Map<String, String> params;
    ArrayList<String> collection_object = new ArrayList<String>();

    SharedPreferences sharedpreferences;
    FontAwesomeTextview Prev, Next;
    TextView display_item_count;
    public int NUM_ITEMS_PAGE   = 10;
    public String TOTAL_LIST_ITEMS;
    EditText searchView;
    ListView listView;
    TransparentProgressDialog mProgressDialog;
    AppController appController;
String currentExamID;
    TextView no_data;
    APIInterface apiInterface;

    ArrayList<HallArrangementStudentInformation> arrayList;
    StudentListAdapter adapter;
    ImageView back_arrow;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragement_search_broadsheet, container, false);
        back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        appController = (AppController) getActivity().getApplicationContext();

        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");

        searchView = (EditText) view.findViewById(R.id.searchView);

        linear_list = (LinearLayout) view.findViewById(R.id.linear_list);

        no_data = (TextView)view.findViewById(R.id.no_data);
        getCurrentExamID();


        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                BroadsheetFragment coursefragment = new BroadsheetFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, coursefragment);
                country.commit();

            }
        });


        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {






            }
        });



        return view;
    }
//    private void getDataList() {
//
//        if (mProgressDialog == null)
//            mProgressDialog = new TransparentProgressDialog(getActivity());
//        if (mProgressDialog.isShowing())
//            mProgressDialog.dismiss();
//        //mProgressDialog = new TransparentProgressDialog(getActivity());
//        mProgressDialog.setCancelable(false);
//        mProgressDialog.show();
//        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
//        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");
//
//        Call<BroadSheetInformationPojo> call=apiInterface.GetAllBroadSheetList(entity_id,branch_id,appController.getBroadSheet_batch_id(),
//                appController.getBroadSheet_sectionName(),appController.getCurrentAcademicYear(),currentExamID,appController.getBroadSheet_streamId(),
//                appController.getBroadSheet_Medium(),"");
//
//        call.enqueue(new Callback<BroadSheetInformationPojo>() {
//            @Override
//            public void onResponse(Call<BroadSheetInformationPojo> call, Response<BroadSheetInformationPojo> response) {
//                Log.e("Response 11 ",new Gson().toJson(response.body()));
//
//                ArrayList<String> collection_object = new ArrayList<String>();
//
//
//                BroadSheetInformationPojo pojoitem=response.body();
////                JSONArray BroadSheetInformation = pojoitem.getJSONArray("BroadSheetInformation");
//
//                String StatusCode=pojoitem.getBroadSheetInformation().get(0).getStatusCode();
//
//                mProgressDialog.dismiss();
//
//                if(StatusCode.equals("200"))
//                {
//
//                    int Size = pojoitem.getBroadSheetInformation().size();
//
//                    for(int i =1; i<Size; i++){
//
//
//                        BroadSheetInformation p = pojoitem.getBroadSheetInformation().get(i);
//                        collection_object.add(p.toString());
//
//                    }
//                    appController.setCollection_saved(collection_object);
//
//                    Log.e("collection_object.size ",collection_object.size()+ " * ");
//                    for (int i = 0; i < collection_object.size(); i++) {
//
//                        String first = collection_object.get(i);
//                        String replace = first.replaceAll(",", "\n");
//
////                            List<String> list_student = Arrays.asList(replace.split(","));
//
//                        final TextView[] textViews = new TextView[collection_object.size()];
//                        final View[] views = new View[collection_object.size()];
//
////                            for(int j=0; j<list_student.size(); j++){
//
//                        final TextView rowtextview = new TextView(getActivity());
//                        final View rowview = new View(getActivity());
//
//                        String curlsRemove = replace.replaceAll("[\\.$|{|}|']", "");
//                        String inverted = curlsRemove.replace("\"", "");
//
//
////                            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
//
//                        View line = new View(getActivity());
//                        RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
////                            lineParams.setMargins(0,0,10,0);
////                            lineParams.addRule(RelativeLayout.BELOW,5);
////                            lineParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
////                            lineParams.width=200;
//////                            line.setId(6);
////                            line.setBackgroundColor(0xFF808080);
////                            line.setLayoutParams(lineParams);
//                        lineParams.addRule(RelativeLayout.BELOW, rowtextview.getId());
//                        LinearLayout.LayoutParams params = new
//                                LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                        params.setMargins(10,10,10,10); // setMargins(left, top, right, bottom)
//                        rowtextview.setLayoutParams(params);
//                        rowtextview.setText(inverted);
//                        rowtextview.setTextSize(14);
//
//
//                        linear_list.addView(rowtextview);
//
////                                linear_list.addView(line);
//
//
////                                linear_list.addView(rowview);
//
//                        textViews[i] = rowtextview;
//
//                        View dividerView = new View(getContext());
//                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                                ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                        dividerView.setLayoutParams(lp);
//
//                        TypedArray array = getContext().getTheme()
//                                .obtainStyledAttributes(new int[]{android.R.attr.listDivider});
//                        Drawable draw = array.getDrawable(0);
//                        array.recycle();
//
//                        dividerView.setBackgroundDrawable(draw);
//                        linear_list.addView(dividerView);
////                                views[i] = rowview;
////                            }
//
////            textview.setText(list_student.get(i));
//                    }
//
//
//                    SharedPreferences.Editor editor = sharedpreferences.edit();
//                    editor.putString("Total_count_student_list",TOTAL_LIST_ITEMS);
//                    editor.apply();
//                    editor.commit();
//
//
//
//                }else
//                {
//                    no_data.setVisibility(View.VISIBLE);
//                    listView.setVisibility(View.GONE);
//                    Next.setEnabled(false);
//
//                    String DisplayMsg=pojoitem.getBroadSheetInformation().get(0).getDisplayMessage();
//                    mProgressDialog.dismiss();
//                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
//                }
//
//            }
//            @Override
//            public void onFailure(Call<BroadSheetInformationPojo> call, Throwable t) {
//                mProgressDialog.dismiss();
//                Log.e("Failure ",t.getMessage());
//            }
//        });
//    }

    private void getCurrentExamID() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        String entity_id = sharedpreferences.getString(getString(R.string.entityid), "0");
        String branch_id = sharedpreferences.getString(getString(R.string.branchId), "0");


        Call<ExamIdInformationPojo> call = apiInterface.GetExamIdList(entity_id,branch_id);
        call.enqueue(new Callback<ExamIdInformationPojo>() {
            @Override
            public void onResponse(Call<ExamIdInformationPojo> call, Response<ExamIdInformationPojo> response) {
                Log.e("Response  ", new Gson().toJson(response.body()));


                ExamIdInformationPojo pojoitem = response.body();

                String StatusCode = pojoitem.getExamIdInformation().get(0).getStatusCode();


                if (StatusCode.equals("200")) {

                    currentExamID= String.valueOf(pojoitem.getExamIdInformation().get(1).getCurrentInternalExamId());
                    getBroadSheetStudentData();
                } else {

                    String DisplayMsg = pojoitem.getExamIdInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getContext(), DisplayMsg, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ExamIdInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ", t.getMessage());
            }
        });

    }

    private void getBroadSheetStudentData() {


        String sourceType_url = ApiClient.Base_url + "ExaminationService.asmx/GetAllBroadSheetList";
        params = new HashMap<String, String>();
        params.put("collegeId", String.valueOf(sharedpreferences.getString(getString(R.string.entityid), "0")));
        params.put("branchId", String.valueOf(sharedpreferences.getString(getString(R.string.branchId), "0")));
        params.put("batchId", appController.getBroadSheet_batch_id());
        params.put("sectionId", appController.getBroadSheet_sectionName());
        params.put("academicyearId", appController.getCurrentAcademicYear());
        params.put("examId", currentExamID);
        params.put("courseId", appController.getBroadSheet_streamId());
        params.put("medium", appController.getBroadSheet_Medium());
        params.put("searchKey", "");


        PostCallWSTask postcalltask = new PostCallWSTask(getActivity(), params, new GetJSONListener() {
            @Override
            public void onRemoteCallComplete(String jsonFromWSCall) throws JSONException {
                try {
                    JSONObject obj = new JSONObject(jsonFromWSCall);
                    JSONArray BroadSheetInformation = obj.getJSONArray("BroadSheetInformation");
                    String statuscode = BroadSheetInformation.getJSONObject(0).getString("StatusCode");
                    mProgressDialog.dismiss();
                    if (statuscode.equals("200")) {

//                        no_data.setVisibility(View.GONE);
//                        list_marksheet.setVisibility(View.VISIBLE);
//                        Next.setEnabled(true);

//                        array_publish_marksheet = new ArrayList<PublishMarksheetPOJO>();

                        for (int i = 1; i < BroadSheetInformation.length(); i++) {
                            JSONObject jsonObject = BroadSheetInformation.getJSONObject(i);

                            collection_object.add(jsonObject.toString());

                        }

                        appController.setCollection_saved(collection_object);


                        for (int i = 0; i < collection_object.size(); i++) {

                            String first = collection_object.get(i);
                            String replace = first.replaceAll(",", "\n");

//                            List<String> list_student = Arrays.asList(replace.split(","));

                            final TextView[] textViews = new TextView[collection_object.size()];

                            final View[] views = new View[collection_object.size()];

//                            for(int j=0; j<list_student.size(); j++){

                            final TextView rowtextview = new TextView(getActivity());

                            final View rowview = new View(getActivity());

                            String curlsRemove = replace.replaceAll("[\\.$|{|}|']", "");
                            String inverted = curlsRemove.replace("\"", "");
                            inverted = inverted.replaceAll(":"," :  "); // or "\\.", it doesn't matter...
                            String arrayString[] = inverted.split("\\n+");
                            Log.e("Inverted ",inverted );
                            Log.e("1 arrayString",arrayString[1]);
                            Log.e("2 arrayString",arrayString[2]);


//                            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

//                            View line = new View(getActivity());
//                            RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
//                            lineParams.setMargins(0,0,10,0);
//                            lineParams.addRule(RelativeLayout.BELOW,5);
//                            lineParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
//                            lineParams.width=200;
////                            line.setId(6);
//                            line.setBackgroundColor(0xFF808080);
//                            line.setLayoutParams(lineParams);
//                            lineParams.addRule(RelativeLayout.BELOW, rowtextview.getId());

                            CardView c1=new CardView(getContext());
                            int width = LinearLayout.LayoutParams.MATCH_PARENT;
                            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
                            parms.setMargins(5,10,5,15);
                            c1.setLayoutParams(parms);
                            c1.setRadius(5f);
                            c1.setCardElevation(3f);



                            LinearLayout l1 = new LinearLayout(getActivity());
                           l1.setOrientation(LinearLayout.VERTICAL);



                            int width1 = LinearLayout.LayoutParams.MATCH_PARENT;
                            int height1 = LinearLayout.LayoutParams.WRAP_CONTENT;
                            LinearLayout.LayoutParams parms1 = new LinearLayout.LayoutParams(width1, height1);
                            parms1.setMargins(10,5,5,10);
                            l1.setLayoutParams(parms1);

                            for (int j=0;j<arrayString.length;j++){

                                LinearLayout l2 = new LinearLayout(getActivity());
                                l2.setOrientation(LinearLayout.HORIZONTAL);

                                final Typeface typeface_semibold = Typeface.createFromAsset(getActivity().getAssets(),
                                        "fonts/Raleway-SemiBold.ttf");
                                final Typeface typeface_regular = Typeface.createFromAsset(getActivity().getAssets(),
                                        "fonts/Raleway-Regular.ttf");

                                int width2 = LinearLayout.LayoutParams.MATCH_PARENT;
                                int height2 = LinearLayout.LayoutParams.WRAP_CONTENT;
                                LinearLayout.LayoutParams parms2 = new LinearLayout.LayoutParams(width2, height2);

                                l2.setLayoutParams(parms2);

                                String data[] = arrayString[j].split(":");
                                TextView  t1 = new TextView(getActivity());
                                TextView  t2= new TextView(getActivity());
                                t1.setText(data[0]);
                                t2.setText(data[1]);
                                t1.setTypeface(typeface_semibold);
                                t2.setTypeface(typeface_regular);

                                if(j==0 || j==1){
                                    t1.setWidth(300);

                                    l2.setBackgroundColor(getResources().getColor(R.color.grey_dark));
                                    parms2.setMargins(0,0,0,0);
                                    t1.setPadding(10,10,10,10);
                                    t2.setPadding(10,10,10,10);

                                }else{
                                    t1.setWidth(500);

                                    if(i==3){
                                        parms2.setMargins(10,10,5,10);


                                    }else{
                                        parms2.setMargins(10,5,5,10);

                                    }
                                    l2.setBackgroundColor(getResources().getColor(R.color.whiteTextColor));


                                }


                                l2.addView(t1);
                                l2.addView(t2);
                                l1.addView(l2);

                            }
//                            TableLayout TV = new TableLayout(getActivity());
//                            int widthT = LinearLayout.LayoutParams.MATCH_PARENT;
//                            int heightT = LinearLayout.LayoutParams.WRAP_CONTENT;
//                            LinearLayout.LayoutParams parmsT = new LinearLayout.LayoutParams(widthT, heightT);
//                            parmsT.setMargins(10,5,5,10);
//
//                            TV.setLayoutParams(parmsT);
//
//
//                            /* Create a new row to be added. */
//
//                            for (int j=2;j<arrayString.length;j++){
//                                String data[] = arrayString[j].split(":");
//
//                                TableRow tr = new TableRow(getActivity());
//                                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
//tr.setBackgroundResource(R.drawable.round_rectangle);
//TextView  t1 = new TextView(getActivity());
//                                TextView  t3= new TextView(getActivity());
//                                t1.setWidth(300);
//                                t1.setText(data[0]);
//                                t3.setText(data[1]);
//                                tr.addView(t1);
//                                tr.addView(t3);
//                                /* Add row to TableLayout. */
////tr.setBackgroundResource(R.drawable.sf_gradient_03);
//                                TV.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
//
//
//                            }

//                            l1.addView(TV);

c1.addView(l1);
                            linear_list.addView(c1);




//                            LinearLayout.LayoutParams params = new
//                                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                            params.setMargins(10,10,10,10); // setMargins(left, top, right, bottom)
//                            rowtextview.setLayoutParams(params);
//
//                            rowtextview.setText(inverted);
//                            rowtextview.setTextSize(14);
//
//
//                            linear_list.addView(rowtextview);
//                                linear_list.addView(line);


//                                linear_list.addView(rowview);

//                            textViews[i] = rowtextview;

//                            View dividerView = new View(getContext());
//                            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                                    ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//                            dividerView.setLayoutParams(lp);
//
//
//                            TypedArray array = getContext().getTheme()
//                                    .obtainStyledAttributes(new int[]{android.R.attr.listDivider});
//                            Drawable draw = array.getDrawable(0);
//                            array.recycle();
//
//                            dividerView.setBackgroundDrawable(draw);
//                            linear_list.addView(dividerView);
//                                views[i] = rowview;
//                            }

//            textview.setText(list_student.get(i));
                        }

//                        searchBroadSheetAdapter = new SearchBroadSheetAdapter(getActivity(),collection_object);
//                        list_marksheet.setAdapter(searchBroadSheetAdapter);


                    } else {
//                        no_data.setVisibility(View.VISIBLE);
//                        list_marksheet.setVisibility(View.GONE);
//                        Next.setEnabled(false);

                        JSONObject displaymessage = BroadSheetInformation.getJSONObject(0);
                        String error = displaymessage.getString("DisplayMessage");
                        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
                    }
                    mProgressDialog.dismiss();


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        });
        postcalltask.execute(sourceType_url);

    }


}


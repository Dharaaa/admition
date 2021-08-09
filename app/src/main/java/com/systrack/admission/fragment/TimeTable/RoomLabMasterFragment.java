package com.systrack.admission.fragment.TimeTable;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
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

import com.google.gson.Gson;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.TimeTableAdapter.RoomLabMasterAdapter;
import com.systrack.admission.helpers.FontAwesomeTextview;
import com.systrack.admission.pojo.RoomCategoryInformation;
import com.systrack.admission.pojo.RoomCategoryInformationPojo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomLabMasterFragment extends Fragment {


    View view;
    SharedPreferences sharedpreferences;
    FontAwesomeTextview Prev, Next;
    TextView display_item_count;
    public int NUM_ITEMS_PAGE   = 10;
    public String TOTAL_LIST_ITEMS;
    EditText searchView;
    ListView listView;
    TransparentProgressDialog mProgressDialog;

    TextView no_data;
    APIInterface apiInterface;

    ArrayList<RoomCategoryInformation> arrayList;
    RoomLabMasterAdapter roomLabMasterAdapter;
    ImageView back_arrow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_room_lab, container, false);
         back_arrow=(ImageView)  view.findViewById(R.id.back_arrow) ;

        apiInterface= ApiClient.getClient().create(APIInterface.class);
        sharedpreferences = getContext().getSharedPreferences(getResources().getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        Typeface font_icon = Typeface.createFromAsset(getActivity().getAssets(), "fonts/fontawesome-webfont.ttf");
        Prev =  view.findViewById(R.id.txt_prev);
        Next =  view.findViewById(R.id.txt_next);
        display_item_count =  view.findViewById(R.id.display_number);
        display_item_count.setText(String.valueOf(NUM_ITEMS_PAGE));
        Prev.setEnabled(false);
        Next.setEnabled(false);

        searchView = (EditText) view.findViewById(R.id.searchView);

        listView = (ListView)view.findViewById(R.id.listView);

        no_data = (TextView)view.findViewById(R.id.no_data);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TimeTableMenuFragment timeTableMenuFragment = new TimeTableMenuFragment();
                FragmentTransaction country = getFragmentManager().beginTransaction();
                country.replace(R.id.frame, timeTableMenuFragment);
                country.commit();

            }
        });
getRoomCategoryList();
        return view;
    }

    private void getRoomCategoryList() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String entity_id=sharedpreferences.getString(getString(R.string.entityid),"0");
        String branch_id=sharedpreferences.getString(getString(R.string.branchId),"0");

        Call<RoomCategoryInformationPojo> call=apiInterface.FillRoomCategoryList(entity_id,branch_id/*,display_item_count.getText().toString(),""*/);

        call.enqueue(new Callback<RoomCategoryInformationPojo>() {
            @Override
            public void onResponse(Call<RoomCategoryInformationPojo> call, Response<RoomCategoryInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                RoomCategoryInformationPojo pojoitem=response.body();

                String StatusCode=pojoitem.getRoomCategoryInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {
                    no_data.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    Next.setEnabled(true);
                    int Size = pojoitem.getRoomCategoryInformation().size();
//                    TOTAL_LIST_ITEMS= response.body().getRoomCategoryInformation().get(1).getTotalCount().toString();

                    arrayList = new ArrayList<RoomCategoryInformation>();

                    for(int i =1; i<Size; i++){
                        RoomCategoryInformation pojo = new RoomCategoryInformation();

                        pojo.setROOMCATEGORYID(pojoitem.getRoomCategoryInformation().get(i).getROOMCATEGORYID());
                        pojo.setROOMCATEGORYNAME(pojoitem.getRoomCategoryInformation().get(i).getROOMCATEGORYNAME());
                        pojo.setLOCATION(pojoitem.getRoomCategoryInformation().get(i).getLOCATION());
                        pojo.setROOMMASTERNAME(pojoitem.getRoomCategoryInformation().get(i).getROOMMASTERNAME());
                        pojo.setSEATCAPACITY(pojoitem.getRoomCategoryInformation().get(i).getSEATCAPACITY());

                        arrayList.add(pojo);

                    }
                    roomLabMasterAdapter = new RoomLabMasterAdapter(getActivity(),arrayList);
                    listView.setAdapter(roomLabMasterAdapter);



                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("Total_count_roommaster",TOTAL_LIST_ITEMS);
                    editor.apply();
                    editor.commit();



                }else
                {
                    no_data.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    Next.setEnabled(false);

                    String DisplayMsg=pojoitem.getRoomCategoryInformation().get(0).getDisplayMessage();
                    mProgressDialog.dismiss();
                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<RoomCategoryInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}

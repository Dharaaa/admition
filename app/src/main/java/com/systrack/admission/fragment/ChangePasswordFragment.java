package com.systrack.admission.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.systrack.admission.LoginActivity;
import com.systrack.admission.MainActivity;
import com.systrack.admission.R;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.adapter.TimeTableMenuAdapter;
import com.systrack.admission.pojo.LoginInformationPojo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ChangePasswordFragment extends Fragment {
    SharedPreferences sharedpreferences;
    EditText current_psw_edittext,new_psw_edittext,conf_psw_edittext;
    LinearLayout btn_change_pass;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.change_password_fragement, container, false);
        current_psw_edittext=view.findViewById(R.id.current_psw_edittext);
        new_psw_edittext=view.findViewById(R.id.new_psw_edittext);
        conf_psw_edittext=view.findViewById(R.id.conf_psw_edittext);
        btn_change_pass=view.findViewById(R.id.btn_change_pass);
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        sharedpreferences = getActivity().getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        btn_change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current_psw_edittext.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Please enter Current Password", Toast.LENGTH_SHORT).show();
                }else if(new_psw_edittext.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Please enter New Password", Toast.LENGTH_SHORT).show();
                }else if(conf_psw_edittext.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Please enter Confirm Password", Toast.LENGTH_SHORT).show();
                }else{
                    changePassword();
                }
            }
        });

        ImageView img_back = view.findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void changePassword() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(getActivity());
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        String username=sharedpreferences.getString(getString(R.string.username),"0");
        String userid=sharedpreferences.getString(getString(R.string.userid),"0");

        Call<LoginInformationPojo> call=apiInterface.ChangePassword(userid,username,current_psw_edittext.getText().toString().trim(),new_psw_edittext.getText().toString().trim(),
                conf_psw_edittext.getText().toString().trim());

        call.enqueue(new Callback<LoginInformationPojo>() {
            @Override
            public void onResponse(Call<LoginInformationPojo> call, Response<LoginInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                LoginInformationPojo pojoitem=response.body();

                assert pojoitem != null;
                String StatusCode=pojoitem.getLoginInformation().get(0).getStatusCode();
                String DisplayMsg=pojoitem.getLoginInformation().get(0).getDisplayMessage();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {

                    Toast.makeText(getActivity(),DisplayMsg,Toast.LENGTH_SHORT).show();
                    DashBoardFragment changePasswordFragment = new DashBoardFragment();
                    FragmentTransaction psw_transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    psw_transaction.replace(R.id.frame, changePasswordFragment);
                    psw_transaction.commit();



                }else
                {
                    mProgressDialog.dismiss();
                    Toast.makeText(getContext(),DisplayMsg,Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onFailure(Call<LoginInformationPojo> call, Throwable t) {
                mProgressDialog.dismiss();
                Log.e("Failure ",t.getMessage());
            }
        });
    }


}





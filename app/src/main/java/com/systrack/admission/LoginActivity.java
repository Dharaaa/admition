package com.systrack.admission;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.systrack.admission.Retrofit.APIInterface;
import com.systrack.admission.Retrofit.ApiClient;
import com.systrack.admission.Utils.TransparentProgressDialog;
import com.systrack.admission.pojo.LoginInformationPojo;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.systrack.admission.Utils.Constant.checkInternetConnection;


public class LoginActivity extends AppCompatActivity {

    Button loginBtn;
    EditText et_userName,et_Password;
    TransparentProgressDialog mProgressDialog;
    APIInterface apiInterface;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String shared_usertype,shared_UserId,ROLEID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
        apiInterface= ApiClient.getClient().create(APIInterface.class);
        sharedPref = getApplicationContext().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        shared_usertype = sharedPref.getString(getResources().getString(R.string.usertype),"");
        shared_UserId = sharedPref.getString(getResources().getString(R.string.userid),"");
        ROLEID = sharedPref.getString(getString(R.string.roleid), "0");

        if(!shared_UserId.equals("") ) {
            // if (shared_usertype.equals("S")) {
            String shared_usertype = sharedPref.getString(getResources().getString(R.string.usertype), "");
            if (ROLEID.equals("2")) {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }else{
                startActivity(new Intent(LoginActivity.this,EmployeeMainActivity.class));
                finish();

            }


            //}
            /*else {
                Intent i = new Intent(LoginActivity.this, MenuDrawerSimpleLightEmp.class);
                startActivity(i);
                finish();


            }*/
        }

        et_userName=findViewById(R.id.et_userName);
        et_Password=findViewById(R.id.et_Password);
        loginBtn=findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Clickkkkk", Toast.LENGTH_SHORT).show();
                if(et_userName.getText().toString().equals(""))
                {
                    Toast.makeText(LoginActivity.this,"Please enter Username",Toast.LENGTH_SHORT).show();
                }else if(et_Password.getText().toString().equals(""))
                {
                    Toast.makeText(LoginActivity.this,"Please enter Password",Toast.LENGTH_SHORT).show();
                }else{
                    if(checkInternetConnection(LoginActivity.this)){
                        LoginApiCall();
                    }else{
                        Toast.makeText(LoginActivity.this, "Internet Not Available", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    private void LoginApiCall() {

        if (mProgressDialog == null)
            mProgressDialog = new TransparentProgressDialog(LoginActivity.this);
        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();
        //mProgressDialog = new TransparentProgressDialog(getActivity());
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();

        Call<LoginInformationPojo> call=apiInterface.User_Login(et_userName.getText().toString().trim(),et_Password.getText().toString().trim()/*,!BuildConfig.DEBUG*/);

        call.enqueue(new Callback<LoginInformationPojo>() {
            @Override
            public void onResponse(Call<LoginInformationPojo> call, Response<LoginInformationPojo> response) {
                Log.e("Response  ",new Gson().toJson(response.body()));



                LoginInformationPojo pojoitem=response.body();

                assert pojoitem != null;
                String StatusCode=pojoitem.getLoginInformation().get(0).getStatusCode();

                mProgressDialog.dismiss();

                if(StatusCode.equals("200"))
                {

                    Toast.makeText(LoginActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();

                    editor.putString(getResources().getString(R.string.userid),String.valueOf(pojoitem.getLoginInformation().get(1).getUSERID()));
                    editor.putString(getResources().getString(R.string.username),String.valueOf(pojoitem.getLoginInformation().get(1).getUSERNAME()));
                    editor.putString(getResources().getString(R.string.usertype),String.valueOf(pojoitem.getLoginInformation().get(1).getUSERTYPE()));
                    editor.putString(getResources().getString(R.string.entityid),String.valueOf(pojoitem.getLoginInformation().get(1).getCOLLEGEID()));
                    editor.putString(getResources().getString(R.string.branchId),String.valueOf(pojoitem.getLoginInformation().get(1).getBRANCHID()));
                    editor.putString(getResources().getString(R.string.fullname),String.valueOf(pojoitem.getLoginInformation().get(1).getFULLNAME()));
                    editor.putString(getResources().getString(R.string.Email),String.valueOf(pojoitem.getLoginInformation().get(1).getEMAIL()));
                    editor.putString(getResources().getString(R.string.EMPTIMETABLETYPE),String.valueOf(pojoitem.getLoginInformation().get(1).getEMPTIMETABLETYPE()));
                    editor.putString(getResources().getString(R.string.profile_url),pojoitem.getLoginInformation().get(1).getPROFILEURL());
                    editor.putBoolean(getResources().getString(R.string.ISALLOWDIVISION),pojoitem.getLoginInformation().get(1).getISALLOWDIVISION());
                    editor.putBoolean(getResources().getString(R.string.ENABLEPRACTICAL),pojoitem.getLoginInformation().get(1).getENABLEPRACTICAL());
                    editor.putString(getResources().getString(R.string.EMPLOYEEID),String.valueOf(pojoitem.getLoginInformation().get(1).getEMPLOYEEID()));
                    editor.putString(getResources().getString(R.string.roleid),String.valueOf(pojoitem.getLoginInformation().get(1).getROLEID()));
                    editor.putBoolean(getString(R.string.issecondfactor), pojoitem.getLoginInformation().get(1).getISSECONDFECTOR());
                    editor.putString(getString(R.string.courseid), String.valueOf(pojoitem.getLoginInformation().get(1).getCOURSEID()));
                    editor.putString(getString(R.string.STUDENTCOURSEID), String.valueOf(pojoitem.getLoginInformation().get(1).getCOURSEID()));

                    editor.putString(getResources().getString(R.string.short_display_date), "dd/MM/yyyy");


                    editor.commit();
                    editor.apply();

                    String shared_usertype = sharedPref.getString(getResources().getString(R.string.usertype), "");
                    ROLEID = String.valueOf(sharedPref.getString(getString(R.string.roleid),"0"));
                    if (ROLEID.equals("2")) {
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();
                    }else{
                        startActivity(new Intent(LoginActivity.this,EmployeeMainActivity.class));
                        finish();

                    }


                  /*  if(pojoitem.getLoginInformation().get(1).getUSERTYPE()==1)
                    {

                        Intent i=new Intent(LoginActivity.this,MenuDrawerSimpleLight.class);
                        startActivity(i);
                        finish();

                    }else
                    {

                        Intent i=new Intent(LoginActivity.this,MenuDrawerSimpleLightEmp.class);
                        startActivity(i);
                        finish();

                    }
*/
                }else
                {
                    String DisplayMsg=pojoitem.getLoginInformation().get(0).getDisplayMessage();
                    Toast.makeText(LoginActivity.this,DisplayMsg,Toast.LENGTH_SHORT).show();

                    mProgressDialog.dismiss();
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

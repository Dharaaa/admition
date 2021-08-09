package com.systrack.admission.helpers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;


import com.systrack.admission.R;
import com.systrack.admission.Utils.Constant;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by Crowded on 26-01-2016.
 */
public class PostCallWSTask extends AsyncTask<Object, Integer, String> {
    private GetJSONListener getJSONListener;
    private String responseStr = "";
    private Context mContext;
    ProgressDialog dialog;

    private Handler mHandler;
    private Map<String, String> params;


    public PostCallWSTask(Context context, Map<String, String> params, GetJSONListener listener) {
        this.getJSONListener = listener;
        this.mContext = context;
        this.params = params;

    }

    @Override
    protected String doInBackground(Object... urls) {


        HttpURLConnection urlConnection;

        for (Object urlObj : urls) {

            try {
                URL url = new URL(urlObj.toString());
                urlConnection = HttpUtility.sendPostRequest(url.toString(), params);
                int statusCode = urlConnection.getResponseCode();
                if (statusCode == 200) {
                    responseStr = HttpUtility.readSingleLineRespone();
                } else {
                    //"Failed to fetch data!";
                }
                System.out.println(responseStr);
            } catch (UnknownHostException sb) {
               /* Snackbar.make(this.view, "Could not load data, please Try again later!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }







        /*if (!Utilities.Isconnetcted(mContext)) {
         *//* Snackbar.make(this.view, "Could not load data, please Try again later!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();*//*
            mHandler=new Handler(Looper.getMainLooper());
            mHandler.post(
                    new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            Toast.makeText(mContext, "Could not load data, please Try again later!", Toast.LENGTH_SHORT).show();
                        }
                    }
            );


        } else {
            for (Object urlObj : urls) {

                try {
                    URL url = new URL(urlObj.toString());
                    urlConnection = HttpUtility.sendPostRequest(url.toString(), params);
                    int statusCode = urlConnection.getResponseCode();
                    if (statusCode == 200) {
                        responseStr = HttpUtility.readSingleLineRespone();
                    } else {
                        //"Failed to fetch data!";
                    }
                    System.out.println(responseStr);
                } catch (UnknownHostException sb) {
               *//* Snackbar.make(this.view, "Could not load data, please Try again later!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*//*
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/


        return responseStr;
    }


    @Override
    protected void onPreExecute() {

        dialog = new ProgressDialog(mContext, R.style.MyAlertDialogStyle);

        dialog.setMessage("Loading...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        if (!Constant.checkInternetConnection(mContext)) {

            Toast.makeText(mContext, "Could not load data, please Check Network Connection!", Toast.LENGTH_LONG).show();
dialog.dismiss();
        } else {
//            dialog=new ProgressDialog(mContext);

//            dialog.setMessage("Loading...");
//            dialog.setCanceledOnTouchOutside(false);
//            dialog.show();
            super.onPreExecute();
        }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            this.getJSONListener.onRemoteCallComplete(responseStr);
            dialog.dismiss();

        } catch (JSONException e) {
            e.printStackTrace();
            if (!Constant.checkInternetConnection(mContext)) {
                dialog.dismiss();

            } else {
                dialog.dismiss();
            }
        }
    }
}

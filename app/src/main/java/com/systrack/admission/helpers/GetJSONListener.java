package com.systrack.admission.helpers;

import org.json.JSONException;

/**
 * Created by Kevin on 10/29/2015.
 */
public interface GetJSONListener {
    public void onRemoteCallComplete(String jsonFromWSCall) throws JSONException;
}

package Data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.app.cricket.CricketAppManager;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

import Utility.VolleyAppController;

import static android.content.ContentValues.TAG;

public class DownloadManager
{
    public static HashMap<String,String> mDownload=new HashMap<String,String>();
    public void download(String Url,Context context)
    {
        try {
            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    Url, (JSONObject) null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, response.toString());
                    try {
                        if (response != null)
                        {
                            CricketAppManager.GetInstance().clear();
                            JSONObject scoredata = (JSONObject) response.getJSONObject("scoredata");

                            Iterator<?> keys = scoredata.keys();
                            while( keys.hasNext() ){
                                String key = (String)keys.next();
                                String value = scoredata.getString(key);
                                mDownload.put(key, value);
                            }
                            JSONObject bat_one=scoredata.getJSONObject("batsman_one");
                            Iterator<?> key_set_one = bat_one.keys();
                            while( key_set_one.hasNext() ){
                                String key = (String)key_set_one.next();
                                String value = bat_one.getString(key);
                                mDownload.put(key, value);
                            }
                            JSONObject bat_second=scoredata.getJSONObject("batsman_two");
                            Iterator<?> key_set_second = bat_second.keys();
                            while( key_set_second.hasNext() ){
                                String key = (String)key_set_second.next();
                                String value = bat_second.getString(key);
                                mDownload.put(key, value);
                            }
                            JSONObject bowler_one=scoredata.getJSONObject("bowler_one");
                            Iterator<?> key_sets_one = bowler_one.keys();
                            while( key_sets_one.hasNext() ){
                                String key = (String)key_sets_one.next();
                                String value = bowler_one.getString(key);
                                mDownload.put(key, value);
                            }
                            JSONObject bowler_second=scoredata.getJSONObject("bowler_two");
                            Iterator<?> key_sets_second = bowler_second.keys();
                            while( key_sets_second.hasNext() ){
                                String key = (String)key_sets_second.next();
                                String value = bowler_second.getString(key);
                                mDownload.put(key, value);
                            }

                            System.out.println(mDownload);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            // Adding request to request queue
            VolleyAppController.getInstance(context).addToRequestQueue(jsonObjReq);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

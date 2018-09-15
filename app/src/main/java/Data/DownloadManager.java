package Data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.app.cricket.CricketAppManager;
import com.app.cricket.ScoreActivity;
import com.app.cricket.ScoreCardFragment;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Utility.VolleyAppController;

import static android.content.ContentValues.TAG;

public class DownloadManager
{

    public static HashMap<String,String> mDownload=new HashMap<String,String>();
    public static ScoreCardData mScoreCardData;
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
    public void downloadScoreCard(String Url,Context context)
    {
        ScoreActivity.scoreModels=new ArrayList<>();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                Url, (JSONObject) null, new Response.Listener<JSONObject>()
        {
            @Override
            public void onResponse(JSONObject response)
            {
                Log.d(TAG, response.toString());
                if(response!=null)
                {
                    JSONArray jsonArray=response.optJSONArray("scoreCard");
                    if(jsonArray.length()>0)
                    {
                        try
                        {
                            Gson gson = new Gson();
                            ScoreActivity.scoreModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<ScoreCardData>>(){}.getType());
                            try {
                                ScoreActivity temp=new ScoreActivity();
                                temp.update();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(ScoreActivity.scoreModels);
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {

            }
        });

        // Adding request to request queue
        VolleyAppController.getInstance(context).addToRequestQueue(jsonObjReq);
    }
}

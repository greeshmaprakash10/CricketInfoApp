package Data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.cricket.CricketAppManager;
import com.app.cricket.ScoreActivity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import Model.ScoreCardData;
import Utility.VolleyAppController;

import static android.content.ContentValues.TAG;

public class DownloadManager
{
    boolean ready=false;

   public void download(final String Url, final Context mContext)
   {
       ready=false;
       JsonObjectRequest objectRequest=new JsonObjectRequest(Request.Method.GET, Url,null, new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response)
           {
               Log.d(TAG, response.toString());
               try
               {
                   JSONObject obj=response.getJSONObject("cricketData");
                   Iterator<?> keys = obj.keys();

                   while( keys.hasNext() )
                   {
                       String key = (String)keys.next();
                       String value = obj.getString(key);
                       CricketAppManager.GetInstance().addData(key, value);
                   }
                   ready=true;

               }
               catch (JSONException e)
               {
                   e.printStackTrace();
               }
           }
       }, new Response.ErrorListener()
       {
           @Override
           public void onErrorResponse(VolleyError error)
           {
               VolleyLog.d(TAG, "Error: " + error.getMessage());
               Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();

           }
       });

       VolleyAppController.getInstance(mContext).addToRequestQueue(objectRequest);
   }

   public void downloadScoreCard(String Url, final Context mContext)
   {

      StringRequest stringRequest=new StringRequest(Request.Method.GET, Url, new Response.Listener<String>()
      {
          @Override
          public void onResponse(String response)
          {
              ScoreActivity.scoreModels=new ArrayList<ScoreCardData>();
              try {
                  JSONObject jsonObject=new JSONObject(response);
                  JSONArray jsonArray=jsonObject.getJSONArray("scoreCard");
                  if(jsonArray.length()>0)
                  {
                      Gson gson = new Gson();
                      ScoreActivity.scoreModels= gson.fromJson(jsonArray.toString(),new TypeToken<ArrayList<ScoreCardData>>(){}.getType());
                  }
                  System.out.println(ScoreActivity.scoreModels);
                  CricketAppManager.GetInstance().refresh();
              } catch (JSONException e) {
                  e.printStackTrace();
              }
          }
      }, new Response.ErrorListener()
      {
          @Override
          public void onErrorResponse(VolleyError error)
          {
              Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
          }
      });

       RequestQueue requestQueue = Volley.newRequestQueue(mContext);

       //adding the string request to request queue
       requestQueue.add(stringRequest);
   }
   public boolean isReady()
   {
       return ready;
   }

}

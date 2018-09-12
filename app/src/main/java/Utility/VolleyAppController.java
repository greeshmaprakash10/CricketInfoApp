package Utility;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by NyesteVenture3 on 3/30/2018.
 */

public class VolleyAppController
{
    private RequestQueue mRequestQueue;
    private static Context mContext;
    private static VolleyAppController mInstance;

    public VolleyAppController(Context context)
    {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized VolleyAppController getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyAppController(context);
        }
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }

        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}

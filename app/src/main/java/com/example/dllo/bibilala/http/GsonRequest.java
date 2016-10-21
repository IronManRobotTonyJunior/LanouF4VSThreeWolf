package com.example.dllo.bibilala.http;


import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class GsonRequest<T> extends Request<T> {
    private final Response.Listener<T> mListener;
    private Class<T> clazz;

    public GsonRequest(int method, String url, Class<T> clazz, Response.Listener<T> mListener, Response.ErrorListener listener) {
        super(method, url, listener);
        this.clazz = clazz;
        this.mListener = mListener;
    }

    public GsonRequest(String url, Class<T> clazz, Response.Listener<T> mListener, Response.ErrorListener listener) {
        this(Method.GET, url, clazz, mListener, listener);
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }
        Gson gson = new Gson();
        return Response.success(gson.fromJson(parsed, clazz), HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(T response) {
        mListener.onResponse(response);
    }

    public void deliverError(VolleyError error) {
        if (error instanceof NoConnectionError) {
            Cache.Entry entry = this.getCacheEntry();
            if (entry != null) {
                Response<T> response = parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
                deliverResponse(response.result);
                return;
            }
        }
        super.deliverError(error);
    }
}

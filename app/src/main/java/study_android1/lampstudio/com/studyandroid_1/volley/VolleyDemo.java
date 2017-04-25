package study_android1.lampstudio.com.studyandroid_1.volley;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import study_android1.lampstudio.com.studyandroid_1.R;
import study_android1.lampstudio.com.studyandroid_1.volley.app.AppController;

public class VolleyDemo extends AppCompatActivity implements View.OnClickListener {
    Button btnJsonRequest;
    Button btnArayRequest;
    Button btnStringRequest;
    Button btnPostParamRequest;
    Button btnRequestHeader;
    Button btnRequestImage;
    Button btnVoleyCache;
    Button btnVoleyCancelRequest;
    Button btnVoleyRequestPriotiri;

    String TAG = VolleyDemo.class.getName();
    TextView voleyDemo;
    ImageView voleyImage;
    ProgressDialog pDialog;
    String tag_json_obj;
    // Tag used to cancel the request
    String tag_json_arry = "json_array_req";
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_demo);
        voleyDemo = (TextView) findViewById(R.id.volleyDemo);
        // Tag used to cancel the request
        tag_json_obj = "json_obj_req";
        url = "http://api.androidhive.info/volley/person_object.json";
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();
        btnJsonRequest = (Button) findViewById(R.id.btn_object_request);
        btnArayRequest = (Button) findViewById(R.id.btn_array_request);
        btnStringRequest = (Button) findViewById(R.id.btn_string_request);
        btnPostParamRequest = (Button) findViewById(R.id.btn_post_param);
        btnRequestHeader = (Button) findViewById(R.id.btn_request_headr);
        btnRequestImage = (Button) findViewById(R.id.btn_request_image);
        btnVoleyCache = (Button) findViewById(R.id.btn_voley_cache);
        btnVoleyCancelRequest = (Button) findViewById(R.id.btn_cancel_request);
        btnVoleyRequestPriotiri = (Button) findViewById(R.id.btn_prioritization_request);

        voleyImage = (ImageView) findViewById(R.id.voley_image);

        btnJsonRequest.setOnClickListener(this);
        btnArayRequest.setOnClickListener(this);
        btnStringRequest.setOnClickListener(this);
        btnPostParamRequest.setOnClickListener(this);
        btnRequestHeader.setOnClickListener(this);
        btnRequestImage.setOnClickListener(this);
        btnVoleyCache.setOnClickListener(this);
        btnVoleyCancelRequest.setOnClickListener(this);
        btnVoleyRequestPriotiri.setOnClickListener(this);


    }

    public void JSONRequest() {
        Toast.makeText(this, "touch JSONRequest", Toast.LENGTH_SHORT).show();
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        voleyDemo.setText(response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    public void JSONArrayRequest() {
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG + "himhim", response.toString());
                        pDialog.hide();
                        voleyDemo.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error:" + error.getMessage());
                pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pDialog.dismiss();
    }

    @Override
    public void onClick(View view) {
        voleyDemo.setText("");
        switch (view.getId()) {
            case R.id.btn_object_request:
                JSONRequest();
                break;
            case R.id.btn_array_request:
                JSONArrayRequest();
                break;
            case R.id.btn_string_request:
                StringRequest();
                break;
            case R.id.btn_post_param:
                AddingPostParameters();
                break;
            case R.id.btn_request_headr:
                AddingRequestHeaders();
                break;
            case R.id.btn_request_image:
                MakingImageRequest();
                break;
            case R.id.btn_voley_cache:
                HandlingTheVolleyCache();
                break;
            case R.id.btn_cancel_request:
                JSONRequest();
                break;
            case R.id.btn_prioritization_request:
                JSONRequest();
                break;
        }
    }

    private void HandlingTheVolleyCache() {
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(url);
        if (entry != null) {
            try {
                String data = new String(entry.data, "UTF-8");
                // handle data, like converting it to xml, json, bitmap etc.,
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else {
            // Cached response doesn't exists. Make network call here
        }
    }

    private void MakingImageRequest() {
        ImageLoader imageLoader = AppController.getInstance().getImageLoader();

// If you are using normal ImageView
        imageLoader.get("https://pbs.twimg.com/media/Bm-dYM_IMAE29od.jpg", new ImageLoader.ImageListener() {

            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                if (response.getBitmap() != null) {
                    // load image into imageview
                    voleyImage.setImageBitmap(response.getBitmap());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Image Load Error: " + error.getMessage());
            }

        });
    }

    private void AddingRequestHeaders() {
        String tag_json_obj = "json_obj_req";

        String url = "http://api.androidhive.info/volley/person_object.json";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.hide();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("apiKey", "xxxxxxxxxxxxxxx");
                return headers;
            }

        };

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    private void AddingPostParameters() {
        String tag_json_obj = "json_obj_req";

        String url = "http://api.androidhive.info/volley/person_object.json";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.hide();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("password", "password123");

                return params;
            }

        };

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

    private void StringRequest() {
        String tag_string_req = "string_req";

        String url = "http://api.androidhive.info/volley/string_response.html";
        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, response.toString());
                voleyDemo.setText(response.toString());
                pDialog.hide();

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }
}

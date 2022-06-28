package com.sunitawebapp.learnmvvm.Retrofit.models;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;


import com.sunitawebapp.learnmvvm.Models.UserDetailsList;
import com.sunitawebapp.learnmvvm.Retrofit.interfaces.ApiInterface;
import com.sunitawebapp.learnmvvm.Retrofit.interfaces.OnCallBackListner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRequest {
    private Context context;
    private OnCallBackListner listner;
   // public static final String BASE_URL = "http://45.77.244.128:8089/";
    public ProgressDialog progressDialog;

    public ApiRequest(Context context, OnCallBackListner listner) {
        this.context = context;
        this.listner = listner;

    }

    private void loader() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);


    }


    // for credential
    public void callPOST(String url,HashMap<String, String> params, String tag) {

        if (NetWorkChecker.check(context)) {

            loader();

            if (progressDialog != null) {
                progressDialog.show();
            }

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<String> callMethod = apiInterface.getPostFormData(url, params, tag);
            callMethod.enqueue(new Callback<String>() {



                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    if (response.body()!=null) {

                        try {
                            Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        onCallBackSuccess(call, response);

                    }
                    else {
                        progressDialog.dismiss();

                        Toast.makeText(context, "Response is null", Toast.LENGTH_SHORT).show();
                    }

                }


                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("_responsedata", t.getMessage() + call.request().header("tag"));
                    onCallBackFaild(call, t);
                }


            });
        }

    }


    // for credential
    public void postWithJson(String url, HashMap<String, String> params, String tag) {


        if (NetWorkChecker.check(context)) {

            loader();

            if (progressDialog != null) {
                progressDialog.show();
            }

            String token = "";

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<String> callMethod = token.isEmpty() ?  apiInterface.getPostJsonBody(url, params, tag) : apiInterface.getPostJsonBody(url, params,token ,tag);
            callMethod.enqueue(new Callback<String>() {



                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    if (response.body()!=null) {

                        try {
                            Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        onCallBackSuccess(call, response);

                    }
                    else {
                        progressDialog.dismiss();

                        Toast.makeText(context, "Response is null", Toast.LENGTH_SHORT).show();
                    }

                }


                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("_responsedata", t.getMessage() + call.request().header("tag"));
                    onCallBackFaild(call, t);
                }


            });
        }

    }



    // for credential
    public void callPOSTJSON_OBJECT(String url,HashMap<String, String> params, String tag) {

        if (NetWorkChecker.check(context)) {

            loader();

            if (progressDialog != null) {
                progressDialog.show();
            }

            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<String> callMethod = apiInterface.getPostFormData(url, params, tag);
            callMethod.enqueue(new Callback<String>() {



                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.body()!=null) {

                        try {
                            Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        onCallBackSuccessJsonObject(call, response);

                    }
                    else {
                        progressDialog.dismiss();

                        Toast.makeText(context, "Response is null", Toast.LENGTH_SHORT).show();
                    }


                }


                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("_responsedata", t.getMessage() + call.request().header("tag"));
                    onCallBackFaild(call, t);
                }


            });
        }

    }


    public void callGET(String url, String tag) {

        if (NetWorkChecker.check(context)) {

            loader();

            if (progressDialog != null) {
                progressDialog.show();
            }
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<String> callMethod = apiInterface.get(url, tag);
            callMethod.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.body()!=null) {
                        try {
                            Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        onCallBackSuccess(call, response);
                    }
                    else {
                        progressDialog.dismiss();

                        Toast.makeText(context, "Response is null", Toast.LENGTH_SHORT).show();
                    }
                }@Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("_responsedata", t.getMessage() + call.request().header("tag"));
                    onCallBackFaild(call, t);
                }

            });
        }

    }




    public void callGETJsonBody(String url,String authorization, String tag) {

        if (NetWorkChecker.check(context)) {

            loader();

            if (progressDialog != null) {
                progressDialog.show();
            }
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<String> callMethod = apiInterface.get(url,authorization, tag);
            callMethod.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.body()!=null) {
                        try {
                            Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        onCallBackSuccess(call, response);
                    }
                    else {
                        progressDialog.dismiss();

                        Toast.makeText(context, "Response is null", Toast.LENGTH_SHORT).show();
                    }
                }@Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("_responsedata", t.getMessage() + call.request().header("tag"));
                    onCallBackFaild(call, t);
                }

            });
        }

    }



    //for call post request with url

    public void callPOSTwithUrl(String url, HashMap<String, String> params, String tag) {
        if (NetWorkChecker.check(context)) {
            loader();
            if (progressDialog != null) {
                progressDialog.show();
            }
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<String> callMethod = apiInterface.getPostFormData(url, params, tag);
            callMethod.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                try {
                    Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                    onCallBackSuccess(call, response);

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.e("_responsedata", t.getMessage() + call.request().header("tag"));
                    onCallBackFaild(call, t);
                }
            });
        }

    }

   // FOR FILE UPLOADING

    public void callFileUpload(String url, @NonNull HashMap<String, String> param, @NonNull PART part, final String tag)
    {

        if (NetWorkChecker.check(context)) {
            loader();
            if (progressDialog != null) {
                progressDialog.show();
            }

            ApiInterface service = ApiClient.getClient().create(ApiInterface.class);

            Call<String> stringCall = service.getPostFormData(url, getParam(param), Params.createMultiPart(part), tag);
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

                    try {
                        Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                // onCallBackSuccessJsonObject(call,response);
                    onCallBackSuccess(call, response);
                }

                @Override
                public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

                    onCallBackFaild(call, t);

                }
            });
        }

    }


    // FOR FILE UPLOADING

    public void callMultiFileUpload(String url, @NonNull HashMap<String, String> param, @NonNull Collection<PART> list, final String tag)
    {

        if (NetWorkChecker.check(context)) {
            loader();
            if (progressDialog != null) {
                progressDialog.show();
            }
            ApiInterface service = ApiClient.getClient().create(ApiInterface.class);

            Call<String> stringCall = service.getPostUploadMultiFileFormData(url, getParam(param), Params.createPartList(list), tag);
            stringCall.enqueue(new Callback<String>() {
                @Override
                public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

                    try {
                        Log.e(tag + "_responsedata", String.valueOf(new JSONObject(response.body())));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // onCallBackSuccessJsonObject(call,response);
                    onCallBackSuccess(call, response);
                }

                @Override
                public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

                    onCallBackFaild(call, t);

                }
            });
        }

    }


    public void onCallBackSuccess(Call<String> call, Response<String> response) {
        if (response.isSuccessful()){

            if (progressDialog != null) {
                progressDialog.dismiss();
            }

            Log.e("response_body" + call.request().header("tag"), response.body());

            try {
                listner.OnCallBackSuccess(call.request().header("tag"), response.body());
            } catch (Exception e) {
                listner.OnCallBackError(call.request().header("tag"), "failed", -1);
                e.printStackTrace();
            }
        }

        else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();

        }



    }


    public void onCallBackSuccessJsonObject(Call<String> call, Response<String> response) {
        Log.d("response", "onCallBackSuccessJsonObject: "+response);

        if (response.isSuccessful()){

            if (progressDialog != null) {
                progressDialog.dismiss();
            }

            Log.e("response_body" + call.request().header("tag"), response.body());

            try {
                listner.OnCallBackSuccess(call.request().header("tag"), new JSONObject(response.body()));
            } catch (JSONException e) {
                listner.OnCallBackError(call.request().header("tag"), "failed", -1);
                e.printStackTrace();
            }
        }

        else {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();

        }





    }


    public void onCallBackFaild(Call<String> call, Throwable t) {


        try
        {
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            if (listner != null) {
                listner.OnCallBackError(call.request().header("tag"), t.getMessage(), -1);
            }


        }
        catch (Exception e){

            listner.OnCallBackError(call.request().header("tag"), e.getMessage(), -1);


        }




    }




    private HashMap<String, RequestBody> getParam(HashMap<String, String> param) {
        HashMap<String, RequestBody> tempParam = new HashMap<>();
        for (String key : param.keySet()) {
            tempParam.put(key, toRequestBody(param.get(key)));
        }

        return tempParam;
    }


    private static RequestBody toRequestBody(String value) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, value);
    }


}


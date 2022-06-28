package com.sunitawebapp.learnmvvm.Retrofit.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.sunitawebapp.learnmvvm.Models.UserDetailsList;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Url;

public interface ApiInterface {

    @Headers({"Content-Type: application/json"})
    @GET()
    Call<String> get(@Url String url, @Header("Authorization") String authorization, @Header("tag") String tag);

    @GET()
    Call<String> get(@Url String url, @Header("tag") String tag);


    // For posting from data

    @FormUrlEncoded
    @POST()
    Call<String> getPostFormData(@Url String url, @FieldMap HashMap<String, String> params , @Header("tag") String tag);

    @Multipart
    @POST()
    Call<String> getPostFormData(@Url String url, @PartMap HashMap<String, RequestBody> param, @Part MultipartBody.Part file, @Header("tag") String tag);


    @Multipart
    @POST()
    Call<String> getPostUploadMultiFileFormData(@Url String url, @PartMap HashMap<String, RequestBody> param, @Part List<MultipartBody.Part> file, @Header("tag") String tag);

    // For posting json data


    @Headers({"Content-Type: application/json"})
    @POST()
    Call<String> getPostJsonBody(@Url String url, @Body HashMap<String, String> params,  @Header("Authorization") String authorization,
                                 @Header("tag") String tag);

    @Headers({"Content-Type: application/json"})
    @POST()
    Call<String> getPostJsonBody(@Url String url, @Body HashMap<String, String> params,
                                 @Header("tag") String tag);


  /*  @Multipart
    @POST()
    Call<String> getPost(@Url String url, @PartMap HashMap<String, RequestBody> param, @Part MultipartBody.Part file, @Header("tag") String tag);
*/

}

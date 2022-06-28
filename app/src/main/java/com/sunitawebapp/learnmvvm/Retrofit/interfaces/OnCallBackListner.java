package com.sunitawebapp.learnmvvm.Retrofit.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.sunitawebapp.learnmvvm.Models.UserDetailsList;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Response;


public interface OnCallBackListner {

    void OnCallBackSuccess(String tag, String body);

    void OnCallBackSuccess(String tag, JSONObject jsonObject);



    void OnCallBackError(String tag, String error, int i);



}

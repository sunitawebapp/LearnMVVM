package com.sunitawebapp.learnmvvm.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunitawebapp.learnmvvm.Interface.getResponse
import com.sunitawebapp.learnmvvm.Models.UserDetailsList
import com.sunitawebapp.learnmvvm.Network.Resource
import com.sunitawebapp.learnmvvm.Retrofit.interfaces.OnCallBackListner
import com.sunitawebapp.learnmvvm.Retrofit.models.ApiRequest
import com.sunitawebapp.learnmvvm.utils.ApiLinks
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response


class LoginViewModel : ViewModel()
    , OnCallBackListner {
    var userDetailsLiveData : MutableLiveData<String> = MutableLiveData()

    lateinit var apiRequest: ApiRequest
    var EmailAddress : MutableLiveData<String>?=null
    var Password: MutableLiveData<String>?=null
    /*  var EmailAddress =""
     var Password =""*/
    lateinit  var res :Response<UserDetailsList>






    fun getApiCallForUserDetails(context: Context){
       viewModelScope.launch {
           getUserDetails(context)
       }
   }

    fun getUserDetails(context : Context){
        apiRequest=ApiRequest(context,this)
     //   userDetailsLiveData.postValue(Resource.Loading())
        apiRequest.callGET(ApiLinks.Userdetails_Url,ApiLinks.Userdetails_Url)
    //  res=  apiRequest.callGETResponse(ApiLinks.Userdetails_Url,ApiLinks.Userdetails_Url)

    }



    override fun OnCallBackSuccess(tag: String?, body: String) {

        userDetailsLiveData.postValue(body)

    }

    override fun OnCallBackSuccess(tag: String?, jsonObject: JSONObject?) {

    }




    override fun OnCallBackError(tag: String?, error: String?, i: Int) {

    }


}


package com.sunitawebapp.learnmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunitawebapp.learnmvvm.Models.DetailsLists
import com.sunitawebapp.learnmvvm.Models.UserDetailsList
import com.sunitawebapp.learnmvvm.Network.Resource
import com.sunitawebapp.learnmvvm.utils.DataLoad
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
     var detailsListslivedata: MutableLiveData<MutableList<DetailsLists>> = MutableLiveData()
    var detailslist : MutableList<DetailsLists> =ArrayList();

  fun  getDetailsList() : MutableLiveData<MutableList<DetailsLists>>{

      viewModelScope.launch {

          DataLoad.DetailsData(detailslist)

          detailsListslivedata.value=detailslist
        //  detailsListslivedata.postValue(res)

      }


     return detailsListslivedata
  }

}

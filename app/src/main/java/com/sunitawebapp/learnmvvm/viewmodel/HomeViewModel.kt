package com.sunitawebapp.learnmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunitawebapp.learnmvvm.Models.DetailsLists
import com.sunitawebapp.learnmvvm.Network.Resource
import com.sunitawebapp.learnmvvm.utils.DataLoad
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
     var detailsListslivedata: MutableLiveData<List<DetailsLists>> = MutableLiveData()
    var detailslist : MutableList<DetailsLists> =ArrayList();

  fun  getDetailsList(){
      viewModelScope.launch {
          DataLoad.DetailsData(detailslist)

      }

   //   detailsListslivedata.postValue(List<DetailsLists>)
  }

}

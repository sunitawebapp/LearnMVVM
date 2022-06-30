package com.sunitawebapp.learnmvvm.utils

import com.sunitawebapp.learnmvvm.Models.DetailsLists

object DataLoad {

    fun DetailsData( detailslist : MutableList<DetailsLists>){
        detailslist.add( 0, DetailsLists("Prabir Chowdhury"))
        detailslist.add(1, DetailsLists("Ashru Chowdhury"))
        detailslist.add(2, DetailsLists("Dipanwita Chowdhury"))
        detailslist.add(3, DetailsLists("Sunita Chowdhury"))
        detailslist.add(4, DetailsLists("Khukumoni Chowdhury"))
        detailslist.add(5, DetailsLists("Dipa Chowdhury"))
        detailslist.add(6, DetailsLists("Runa Chowdhury"))
        detailslist.add(7, DetailsLists("Bishu Chowdhury"))
        detailslist.add(8, DetailsLists("Suniti Chowdhury"))
        detailslist.add(9, DetailsLists("Juthika Chowdhury"))
    }
}

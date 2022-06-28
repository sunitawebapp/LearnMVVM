package com.sunitawebapp.learnmvvm.utils

import android.content.Intent
import android.os.Handler
import androidx.core.content.ContextCompat.startActivity


object MethodClass {

    fun postDelayed(navigate: Unit) {
        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
            navigate
        }, 3000) // 3000 is the delayed time in milliseconds.

    }
}

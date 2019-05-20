package com.captain.ak.zomato

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

class AppExecutors {

    private val mNetworkIO = Executors.newScheduledThreadPool(3)

    fun networkIO(): ScheduledExecutorService {
        return mNetworkIO
    }

    companion object {

        private var instance: AppExecutors? = null

        fun getInstance(): AppExecutors {
            if (instance == null) {
                instance = AppExecutors()
            }
            return this.instance!!
        }
    }
}
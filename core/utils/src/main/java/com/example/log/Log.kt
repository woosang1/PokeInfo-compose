package com.example.log

import android.util.Log

var LOG_TAG = "Logger"

fun DebugLog(logData: String) {
    Log.d(LOG_TAG, logData)
}
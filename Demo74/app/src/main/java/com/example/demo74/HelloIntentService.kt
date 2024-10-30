package com.example.demo74

import android.app.IntentService
import android.content.Intent
import android.util.Log

class HelloIntentService : IntentService("HelloIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        try {
            Log.d("HelloIntentService", "Doing background work...")
            Thread.sleep(5000)
            Log.d("HelloIntentService", "Work is done.")
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
            Log.e("HelloIntentService", "Service was interrupted", e)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HelloIntentService", "Service is being destroyed.")
    }
}
package com.example.demo74

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class HelloCoroutineService : Service() {

    // Sử dụng CoroutineScope cho service
    private val serviceJob = Job()

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        CoroutineScope(Dispatchers.IO + serviceJob).launch {
            try {
                Log.d("HelloCoroutineService", "Doing background work...")
                delay(5000)
                Log.d("HelloCoroutineService", "Work is done.")
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
                Log.e("HelloCoroutineService", "Service was interrupted", e)
            } finally {
                // Dừng service sau khi hoàn thành công việc
                stopSelf()
            }
        }
        return START_NOT_STICKY // Không khởi động lại service nếu bị hủy
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HelloCoroutineService", "Service is being destroyed.")
        Thread.sleep(3000)
        serviceJob.cancel()
        Log.d("HelloCoroutineService", "All coroutines have been cancelled.")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
package com.example.demo82

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@SuppressLint("ScheduleExactAlarm")
@Composable
fun AlarmManagerDemo2() {
    val context = LocalContext.current

    // Tạo Intent để gửi đi khi alarm dc kích hoạt
    val intent = Intent(context, AlarmReceiver::class.java)

    // Kiểm tra xem alarm đã tồn tại hay chưa
    val alarmExists = PendingIntent.getBroadcast(
        context,
        0,
        intent,
        PendingIntent.FLAG_NO_CREATE or PendingIntent.FLAG_IMMUTABLE
    ) != null

    if(!alarmExists) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = PendingIntent.getBroadcast(
            context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        //Thiết lập Alarm chỉ chạy 1 lần khi ứng dụng dc kích hoạt
        alarmManager.setExact(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime(),
            pendingIntent
        )
        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            SystemClock.elapsedRealtime(),
            pendingIntent
        )
        alarmManager.cancel(pendingIntent)
    }
}
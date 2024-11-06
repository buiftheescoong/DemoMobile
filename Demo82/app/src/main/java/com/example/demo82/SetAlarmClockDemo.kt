package com.example.demo82

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@SuppressLint("ScheduleExactAlarm")
@Composable
fun SetAlarmClockDemo() {
    val context = LocalContext.current
    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    val intent = Intent(context, AlarmReceiver2::class.java)
    val pendingIntent = PendingIntent.getBroadcast(
        context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
    )

    alarmManager.setAlarmClock(
        AlarmManager.AlarmClockInfo(System.currentTimeMillis() + 60000, pendingIntent),
        pendingIntent
    )

    val nextAlarm = alarmManager.nextAlarmClock
    if (nextAlarm != null) {
        Toast.makeText(context, "Next alarm is set for: ${nextAlarm.triggerTime}", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context, "No next alarm is set", Toast.LENGTH_SHORT).show()
    }
}

class AlarmReceiver2 : BroadcastReceiver() {
    @SuppressLint("ScheduleExactAlarm")
    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "Alarm triggered!", Toast.LENGTH_SHORT).show()

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val nextAlarmIntent = Intent(context, AlarmReceiver::class.java)
        val nextPendingIntent = PendingIntent.getBroadcast(
            context, 0, nextAlarmIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )

        alarmManager.setAlarmClock(
            AlarmManager.AlarmClockInfo(System.currentTimeMillis() + 60000, nextPendingIntent),
            nextPendingIntent
        )

        Toast.makeText(context, "Next alarm is set!", Toast.LENGTH_SHORT).show()
    }
}
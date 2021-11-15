package ua.motionman.activitylecture

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ScreenStateBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Intent.ACTION_SCREEN_ON -> Log.e("ScreenState", "onReceive: ACTION_SCREEN_ON")
            Intent.ACTION_SCREEN_OFF -> Log.e("ScreenState", "onReceive: ACTION_SCREEN_OFF")
        }
    }
}
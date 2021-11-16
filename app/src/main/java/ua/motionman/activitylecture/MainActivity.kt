package ua.motionman.activitylecture

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import ua.motionman.activitylecture.model.UserModalParcelable
import ua.motionman.activitylecture.model.UserModel

class MainActivity : AppCompatActivity() {

    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val code = result.resultCode
        val data = result.data

        when (code) {
            RESULT_OK -> Log.e(
                "activityResultLauncher",
                "result: ${data?.getStringExtra("RESULT_EXTRA")}"
            )
            else -> Log.e("activityResultLauncher", "operation cancel")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<AppCompatButton>(R.id.nextActivityButton).setOnClickListener {
            navigateToSecondActivity()
        }

        Log.i("MainActivityLifecycle", "onCreate")
    }

    private fun navigateToSecondActivity() {
        val user = UserModel("1", "First", "Last")

        Intent(this, SecondActivity::class.java).apply {
            putExtra("STRING_EXTRA", "Hello from MainActivity")
            putExtra("USER_EXTRA", user)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(this)
        }
    }

    private fun navigateWithParcelable() {
        val user = UserModalParcelable("1", "First", "Last")

        Intent(this, SecondActivity::class.java).apply {
            putExtra("PARCELABLE_EXTRA", user)
            startActivity(this)
        }
    }

    private fun activityForResult() {
        val user = UserModel("1", "First", "Last")

        Intent(this, SecondActivity::class.java).apply {
            putExtra("STRING_EXTRA", "Hello from MainActivity")
            putExtra("USER_EXTRA", user)
            activityResultLauncher.launch(this)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainActivityLifecycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        try {
            registerReceiver(
                ScreenStateBroadcastReceiver(),
                IntentFilter().apply {
                    addAction(Intent.ACTION_SCREEN_ON)
                    addAction(Intent.ACTION_SCREEN_OFF)
                }
            )
        } catch (e: Exception) {
            // handle exception
        }
        Log.i("MainActivityLifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivityLifecycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        try {
            unregisterReceiver(ScreenStateBroadcastReceiver())
        } catch (e: Exception) {
            // handle exception
        }
        Log.i("MainActivityLifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainActivityLifecycle", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivityLifecycle", "onDestroy")
    }
}
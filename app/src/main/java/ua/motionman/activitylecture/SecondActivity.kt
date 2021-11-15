package ua.motionman.activitylecture

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import ua.motionman.activitylecture.model.UserModel

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intentStringValue = intent.getStringExtra("STRING_EXTRA")
        val user = intent.getSerializableExtra("USER_EXTRA") as UserModel

        findViewById<AppCompatTextView>(R.id.textView).text = "${user.firstName} ${user.lastName}"
        findViewById<AppCompatButton>(R.id.resultButton).setOnClickListener {
            Intent().apply {
                putExtra("RESULT_EXTRA", "Here is result from second activity")
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}
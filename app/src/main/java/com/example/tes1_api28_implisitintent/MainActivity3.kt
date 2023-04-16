package com.example.tes1_api28_implisitintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var _buttonSMS = findViewById<Button>(R.id.buttonSMS)
        var _buttonOpenWebsite = findViewById<Button>(R.id.buttonOpenWebsite)

        _buttonSMS.setOnClickListener {
            val _sendIntentTo = Intent()
            _sendIntentTo.action = Intent.ACTION_SENDTO
            _sendIntentTo.data = Uri.parse("smsto:555-5555")
            _sendIntentTo.putExtra("sms_body", "Permisi Pizza")
            startActivity(Intent.createChooser(_sendIntentTo,"PILIH APLIKASI"))
        }

        _buttonOpenWebsite.setOnClickListener {
            val _webIntent = Intent(
                Intent.ACTION_VIEW, Uri.parse("http://pizzahut.co.id")
            )
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(_webIntent)
            }
        }
    }
}
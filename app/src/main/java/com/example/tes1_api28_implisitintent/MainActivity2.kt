package com.example.tes1_api28_implisitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val _buttonEditTopping = findViewById<Button>(R.id.buttonEditTopping)
        val _buttonFinish = findViewById<Button>(R.id.buttonFinish)
        val _buttonBackScene2 = findViewById<ImageView>(R.id.buttonBackScreen2)
        val _descriptionTotalHarga = findViewById<TextView>(R.id.descriptionTotalHarga)
        val _descriptionToppings = findViewById<TextView>(R.id.descriptionToppings)

        val intentPesanan = intent.getParcelableArrayListExtra<Pesanan>(companion2)

        var textTopping = ""
        var totalHarga = 0

        //for loop parcalable
        for (i in intentPesanan!!){
            textTopping += "${i.Jumlah}\t\t\t" + "${i.Topping.toString()}\t\t\t\t\t\t\t" + "${i.Harga}\n"
            totalHarga += i.Harga
        }
        _descriptionToppings.text = textTopping
        _descriptionTotalHarga.text ="Total Harga:\t\t\t\t\t\t\t\t\t\t\t " + totalHarga

        _buttonEditTopping.setOnClickListener {
            val eIntent = Intent(this@MainActivity2, MainActivity::class.java).apply {
                putExtra(MainActivity.companion1, intentPesanan)
                putExtra(MainActivity.edit, "True")
            }
            startActivity(eIntent)
        }

        _buttonFinish.setOnClickListener {
            val eIntent = Intent(this@MainActivity2, MainActivity3::class.java).apply {
            }
            startActivity(eIntent)
        }

        _buttonBackScene2.setOnClickListener {
            val eIntent = Intent(this@MainActivity2, MainActivity::class.java).apply {
                putExtra(MainActivity.companion1, intentPesanan)
                putExtra(MainActivity.edit, "True")
            }
            startActivity(eIntent)
        }
    }

    companion object {
        val companion2 = "Activity2"
    }
}
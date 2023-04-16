package com.example.tes1_api28_implisitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dataPesanan : ArrayList<Pesanan> = arrayListOf()

        //textview pesanannya
        val _textViewPizzaSauce = findViewById<TextView>(R.id.textViewPizzaSauce)
        val _textViewMint = findViewById<TextView>(R.id.textViewMint)
        val _textViewPepperoni = findViewById<TextView>(R.id.textViewPepperoni)
        val _textViewMushroom = findViewById<TextView>(R.id.textViewMushroom)
        val _textViewOlives = findViewById<TextView>(R.id.textViewOlives)
        val _textViewTomato = findViewById<TextView>(R.id.textViewTomato)
        val _textViewCheese = findViewById<TextView>(R.id.textViewCheese)

        //textview quantity pesanan
        val _quantityPizzaSauce = findViewById<TextView>(R.id.quantityPizzaSauce)
        val _quantityMint = findViewById<TextView>(R.id.quantityMint)
        val _quantityPepperoni = findViewById<TextView>(R.id.quantityPepperoni)
        val _quantityMushroom = findViewById<TextView>(R.id.quantityMushroom)
        val _quantityOlives = findViewById<TextView>(R.id.quantityOlives)
        val _quantityTomato = findViewById<TextView>(R.id.quantityTomato)
        val _quantityCheese = findViewById<TextView>(R.id.quantityCheese)

        //edit topping, dipanggil diatas
        val editTopping = intent.getStringExtra(edit)
        if(editTopping == "True"){
            val intentPesanan = intent.getParcelableArrayListExtra<Pesanan>(MainActivity.companion1)

            for(i in intentPesanan!!){
                if(i.Topping.toString() == "Pizza Sauce"){
                    _quantityPizzaSauce.setText(i.Jumlah.toString())
                }
                if(i.Topping.toString() == "Mint       "){
                    _quantityMint.setText(i.Jumlah.toString())
                }
                if(i.Topping.toString() == "Pepperoni  "){
                    _quantityPepperoni.setText(i.Jumlah.toString())
                }
                if(i.Topping.toString() == "Mushroom   "){
                    _quantityMushroom.setText(i.Jumlah.toString())
                }
                if(i.Topping.toString() == "Olives     "){
                    _quantityOlives.setText(i.Jumlah.toString())
                }
                if(i.Topping.toString() == "Tomato     "){
                    _quantityTomato.setText(i.Jumlah.toString())
                }
                if(i.Topping.toString() == "Cheese     "){
                    _quantityCheese.setText(i.Jumlah.toString())
                }
            }
        }

        //variabel pesanan masing"
        var _jumlahPizzaSauce = Integer.parseInt(_quantityPizzaSauce.text.toString())
        var _jumlahMint = Integer.parseInt(_quantityMint.text.toString())
        var _jumlahPepperoni = Integer.parseInt(_quantityPepperoni.text.toString())
        var _jumlahMushroom = Integer.parseInt(_quantityMushroom.text.toString())
        var _jumlahOlives = Integer.parseInt(_quantityOlives.text.toString())
        var _jumlahTomato = Integer.parseInt(_quantityTomato.text.toString())
        var _jumlahCheese = Integer.parseInt(_quantityCheese.text.toString())

        //button continue dan profile
        var _buttonProfile = findViewById<ImageView>(R.id.profile)
        var _buttonContinue = findViewById<Button>(R.id.buttonContinue)

        //if statement untuk setiap button di klik: akan menambahkan quantity dan variabelnya
        _textViewPizzaSauce.setOnClickListener{
            _jumlahPizzaSauce += 1
            _quantityPizzaSauce.setText(_jumlahPizzaSauce.toString())
        }

        _textViewMint.setOnClickListener{
            _jumlahMint += 1
            _quantityMint.setText(_jumlahMint.toString())
        }

        _textViewPepperoni.setOnClickListener{
            _jumlahPepperoni += 1
            _quantityPepperoni.setText(_jumlahPepperoni.toString())
        }

        _textViewMushroom.setOnClickListener{
            _jumlahMushroom += 1
            _quantityMushroom.setText(_jumlahMushroom.toString())
        }

        _textViewOlives.setOnClickListener{
            _jumlahOlives += 1
            _quantityOlives.setText(_jumlahOlives.toString())
        }

        _textViewTomato.setOnClickListener{
            _jumlahTomato += 1
            _quantityTomato.setText(_jumlahTomato.toString())
        }

        _textViewCheese.setOnClickListener{
            _jumlahCheese += 1
            _quantityCheese.setText(_jumlahCheese.toString())
        }

        //if statement untuk setiap topping, jika tidak 0 ditambahkan di array list dataPesanan
        //kenapa diluar perlu juga???
        _buttonContinue.setOnClickListener {
            val intent_activity2 = Intent(this@MainActivity, MainActivity2::class.java).apply {
                putExtra(MainActivity2.companion2, dataPesanan)
            }

            //if statement untuk setiap topping, jika tidak 0 ditambahkan di array list dataPesanan
            if(_jumlahPizzaSauce > 0){
                dataPesanan.add(Pesanan(_jumlahPizzaSauce, "Pizza Sauce", (_jumlahPizzaSauce * 5000)))
            }
            if(_jumlahMint > 0){
                dataPesanan.add(Pesanan(_jumlahMint, "Mint       ", (_jumlahMint * 0)))
            }
            if(_jumlahPepperoni > 0){
                dataPesanan.add(Pesanan(_jumlahPepperoni, "Pepperoni  ", (_jumlahPepperoni * 15000)))
            }
            if(_jumlahMushroom > 0){
                dataPesanan.add(Pesanan(_jumlahMushroom, "Mushroom   ", (_jumlahMushroom * 8000)))
            }
            if(_jumlahOlives > 0){
                dataPesanan.add(Pesanan(_jumlahOlives, "Olives     ", (_jumlahOlives * 3000)))
            }
            if(_jumlahTomato > 0){
                dataPesanan.add(Pesanan(_jumlahTomato, "Tomato     ", (_jumlahTomato * 3000)))
            }
            if(_jumlahCheese > 0){
                dataPesanan.add(Pesanan(_jumlahCheese, "Cheese     ", (_jumlahCheese * 10000)))
            }

            startActivity(intent_activity2)
        }

        _buttonProfile.setOnClickListener{
            val _fragment = fProfile()

            val fragmentTransaction = supportFragmentManager
            fragmentTransaction.beginTransaction().apply {
                replace(R.id.mainActivity, _fragment, fProfile::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }

    companion object {
        val companion1 = "Activity1"
        val edit = "false"
    }
}
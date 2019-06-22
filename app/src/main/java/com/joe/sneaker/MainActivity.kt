package com.joe.sneaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import com.irozon.sneaker.Sneaker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager.beginTransaction()) {
            this.add(R.id.fragment, MainFragment())
            this.commit()
        }

        btn_show_error.setOnClickListener {
            Sneaker.with(this)
                .setTitle("Error!!!")
                .setMessage("This is the error message.")
                .sneakError()
        }

        btn_show_success.setOnClickListener { 
            val sneaker = Sneaker.with(view_group)
            val view = LayoutInflater.from(this).inflate(R.layout.custom_view, sneaker.getView(), false)
            view.findViewById<TextView>(R.id.textViewInstall).setOnClickListener {
                Toast.makeText(this, "Clicked.", Toast.LENGTH_SHORT).show()
            }
            sneaker.sneakCustom(view)
        }
    }

}

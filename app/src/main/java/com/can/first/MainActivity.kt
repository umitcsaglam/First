package com.can.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.can.first.databinding.ActivityMain2Binding
import com.can.first.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun giris1(view: View)
    {
        val gec=Intent(this@MainActivity,MainActivity3::class.java)
        startActivity(gec)

    }
    fun gecis3(view: View)
    {
        val gec=Intent(this@MainActivity,MainActivity4::class.java)
        startActivity(gec)

    }
}
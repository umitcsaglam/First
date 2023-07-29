package com.can.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.can.first.databinding.ActivityMain3Binding
import com.can.first.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity3 : AppCompatActivity() {
    private  lateinit var  binding: ActivityMain3Binding
    private  lateinit var email:String
    private  lateinit var passaword:String
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
    }
    fun giris2(view: View)
    {
        email=binding.birinci.text.toString()
        passaword=binding.ikinci.text.toString()
        if(email.equals("")||passaword.equals(""))
        {
            Toast.makeText(this@MainActivity3, "Email veya parola boş girilemez!", Toast.LENGTH_SHORT).show()
        }
        else
        {
            auth.signInWithEmailAndPassword(email,passaword).addOnSuccessListener {
                val gecis=Intent(this@MainActivity3,MainActivity2::class.java)
                startActivity(gecis)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity3, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }



    }
}
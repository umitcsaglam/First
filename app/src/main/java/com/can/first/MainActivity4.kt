package com.can.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.can.first.databinding.ActivityMain4Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private lateinit var auth: FirebaseAuth
    private lateinit var email:String
    private lateinit var passaword:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=Firebase.auth
    }
    fun giris2(view: View)
    {
        email=binding.birinci2.text.toString()
        passaword=binding.ikinci2.text.toString()
        if(email.equals("")||passaword.equals(""))
        {
            Toast.makeText(this, "Değerler boş girilemez!", Toast.LENGTH_SHORT).show()
        }
        else
        {
            auth.createUserWithEmailAndPassword(email,passaword).addOnSuccessListener {
                var gecis=Intent(this@MainActivity4,MainActivity2::class.java)
                startActivity(gecis)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        }


    }
}
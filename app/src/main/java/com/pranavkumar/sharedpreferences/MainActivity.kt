package com.pranavkumar.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pranavkumar.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        if(sharedPreferences.contains("Pranav")){
            binding.etEnterValue.setText(sharedPreferences.getString("Pranav",""))
        }

        binding.btnSave.setOnClickListener {
            if(binding.etEnterValue.text.isNullOrEmpty()){
                binding.etEnterValue.error = "Enter value to save"
            }else{
                editor.putString("Pranav", binding.etEnterValue.text.toString())
                var intent = Intent(this,MainActivity2::class.java)
                startActivity(intent)
                editor.commit()
            }
        }



    }
}
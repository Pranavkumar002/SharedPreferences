package com.pranavkumar.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pranavkumar.sharedpreferences.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding : ActivityMain2Binding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(resources.getString(R.string.app_name), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        if(sharedPreferences.contains("Pranav")){
            binding.tvName.setText(sharedPreferences.getString("Pranav",""))
        }
        binding.btnRemove.setOnClickListener {
            editor.clear()
            editor.remove("Pranav")
            editor.commit()
        }

    }
}
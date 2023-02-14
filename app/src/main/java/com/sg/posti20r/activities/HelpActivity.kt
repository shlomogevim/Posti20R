package com.sg.posti20r.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sg.posti20r.R
import com.sg.posti20r.databinding.ActivityHelpActvityBinding

class HelpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHelpActvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHelpActvityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
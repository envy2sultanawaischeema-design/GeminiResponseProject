package com.example.geminidemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geminidemo.databinding.ActivityDemoMainBinding
import com.example.chatwithgiminibypass.MainActivity as GeminiActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDemoMainBinding

    // ★ Activity Result launcher — response wapas lene ke liye
    private val geminiLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val response = result.data?.getStringExtra("extra_response") ?: "No response"
            val userMsg  = result.data?.getStringExtra("extra_user_message") ?: ""

            // Response card dikhao
            binding.cardResponse.visibility = View.VISIBLE
            binding.tvResponse.text = "Tumhara sawaal: $userMsg\n\nGemini ka jawab:\n$response"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDemoMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ★ Button 1 — Sirf open karo (normal Intent, no result)
        binding.btnOpenOnly.setOnClickListener {
            val intent = Intent(this, GeminiActivity::class.java)
            startActivity(intent)
        }

        // ★ Button 2 — Open karo + response wapas lo
        binding.btnGetResult.setOnClickListener {
            val intent = Intent(this, GeminiActivity::class.java)
            geminiLauncher.launch(intent)
        }
    }
}

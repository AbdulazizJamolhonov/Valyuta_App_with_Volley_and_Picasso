package developer.abdulaziz.myvalyuta

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import developer.abdulaziz.myvalyuta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.home1.setOnClickListener { startActivity(Intent(this, MainActivity2::class.java)) }
        binding.home2.setOnClickListener { startActivity(Intent(this, MainActivity3::class.java)) }
    }
}
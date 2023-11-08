package uz.turgunboyevjurabek.daggerhiltbasic

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.turgunboyevjurabek.daggerhiltbasic.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.daggerhiltbasic.network.ApiService
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}
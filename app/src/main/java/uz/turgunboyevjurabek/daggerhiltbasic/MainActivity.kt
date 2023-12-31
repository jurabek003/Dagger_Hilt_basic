package uz.turgunboyevjurabek.daggerhiltbasic

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.turgunboyevjurabek.daggerhiltbasic.adapter.RvAdapter
import uz.turgunboyevjurabek.daggerhiltbasic.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.daggerhiltbasic.utils.Status
import uz.turgunboyevjurabek.daggerhiltbasic.vm.ViewModule
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModule:ViewModule by viewModels()

    @Inject
    lateinit var rvAdapter: RvAdapter

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        lifecycleScope.launch{
            withContext(Dispatchers.Main){
                viewModule.getAllClients().observe(this@MainActivity, Observer {
                    when (it.status) {
                        Status.LOADING -> {
                            binding.progressCircular.visibility = View.VISIBLE
                        }

                        Status.SUCCESS -> {
                                binding.progressCircular.visibility = View.GONE
                                rvAdapter.upDateData(it.data!!)
                                binding.rvAdapter.adapter = rvAdapter
                        }

                        Status.ERROR -> {
                           Toast.makeText(this@MainActivity, "${it.massage}", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }


        }
    }
}
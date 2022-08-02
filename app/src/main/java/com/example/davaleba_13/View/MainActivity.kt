package com.example.davaleba_13.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.davaleba_13.Model.Product
import com.example.davaleba_13.ViewModel.ProductsViewModel
import com.example.davaleba_13.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val likusmodel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        infoGetting()
    }

    private fun infoGetting(){
        lifecycleScope.launch {
            likusmodel.infoGett()
            likusmodel.flow.collect{
                set(it)
            }
        }
    }

    private fun set (item:Product){
        binding.text.text = item.toString()
    }

}
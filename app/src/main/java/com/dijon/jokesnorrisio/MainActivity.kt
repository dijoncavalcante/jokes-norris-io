package com.dijon.jokesnorrisio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dijon.jokesnorrisio.databinding.ActivityMainBinding
import com.dijon.jokesnorrisio.presentation.CategoryAdapter
import com.dijon.jokesnorrisio.presentation.ResultViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: ResultViewModel =
            ViewModelProviders.of(this).get(ResultViewModel::class.java)

        viewModel.resultLiveData.observe(this, {
            it?.let { categories ->
                with(binding.rvCategory) {
                    layoutManager = GridLayoutManager(this@MainActivity, 2)
                    setHasFixedSize(true)
                    adapter = CategoryAdapter(categories) { categoria ->
                        val intent = DetailCategoryActivity.getStartIntent(
                            this@MainActivity,
                            categoria
                        )
                        this@MainActivity.startActivity(intent)
                    }
                }
            }

        })

        viewModel.viewFlipperLiveData.observe(this, Observer {
            it?.let { viewFlipper ->
                binding.viewFliperBooks.displayedChild = viewFlipper.first

                viewFlipper.second?.let { errorMessageResId ->
                    binding.textViewError.text = getString(errorMessageResId)
                }
            }


        })
        viewModel.getCategory()
    }
}
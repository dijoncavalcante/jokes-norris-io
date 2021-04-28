package com.dijon.jokesnorrisio

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.dijon.jokesnorrisio.databinding.ActivityDetailCategoryBinding
import com.dijon.jokesnorrisio.databinding.ActivityMainBinding
import com.dijon.jokesnorrisio.presentation.DetailCategoryViewModel
import com.dijon.jokesnorrisio.presentation.ResultViewModel

class DetailCategoryActivity : AppCompatActivity() {

    lateinit var bindingDetail: ActivityDetailCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingDetail = ActivityDetailCategoryBinding.inflate(layoutInflater)
        setContentView(bindingDetail.root)

        val category: String = intent.getSerializableExtra(EXTRA_CATEGORY) as String

        val viewModel: DetailCategoryViewModel =
            ViewModelProviders.of(this).get(DetailCategoryViewModel::class.java)

        viewModel.detailCategoryLiveData.observe(this, {
            it?.let { jokes ->
                run {
                    bindingDetail.tvJoke.text = jokes[0].value
                    bindingDetail.tvCreated.getEditText()?.setText(jokes[0].created_at)
                    bindingDetail.tvUpdated.getEditText()?.setText(jokes[0].updated_at)
                    bindingDetail.tvCategory.text = jokes[0].categories.joinToString(",")
                }
            }
        })

        viewModel.getRandonJokeByCategory()

    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_CATEGORY = "EXTRA_CATEGORY"

        fun getStartIntent(context: Context, category: String): Intent {
            return Intent(context, DetailCategoryActivity::class.java).apply {
                putExtra(EXTRA_CATEGORY, category)
            }
        }
    }
}
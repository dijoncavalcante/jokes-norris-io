package com.dijon.jokesnorrisio

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dijon.jokesnorrisio.databinding.ActivityDetailCategoryBinding
import com.dijon.jokesnorrisio.databinding.ActivityMainBinding

class DetailCategoryActivity : AppCompatActivity() {

    lateinit var bindingDetail: ActivityDetailCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail_category)
        bindingDetail = ActivityDetailCategoryBinding.inflate(layoutInflater)
        setContentView(bindingDetail.root)

    }

    companion object {
        private const val EXTRA_TITLE = "EXTRA_TITLE"
        private const val EXTRA_DESCRIPTION = "EXTRA_DESCRIPTION"

        fun getStartIntent(context: Context, category: String): Intent {
            return Intent(context, DetailCategoryActivity::class.java).apply {
                putExtra(EXTRA_TITLE, category)
            }
        }
    }
}
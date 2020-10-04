package com.brizaldi.moviebrowser.view.ui.details.genre

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager.widget.ViewPager
import com.brizaldi.moviebrowser.R
import com.brizaldi.moviebrowser.compose.ViewModelActivity
import com.brizaldi.moviebrowser.extension.simpleToolbarWithHome
import com.brizaldi.moviebrowser.models.entity.Genre
import com.skydoves.whatif.whatIfNotNull
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_genre_detail.*
import kotlinx.android.synthetic.main.activity_genre_detail.view.*
import kotlinx.android.synthetic.main.activity_main.main_viewpager
import javax.inject.Inject

class GenreDetailActivity : ViewModelActivity(), HasAndroidInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = fragmentInjector

    private val viewModel: GenreDetailActivityViewModel by injectViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre_detail)

        viewModel.setGenre(getGenreFromIntent()!!)
        initializeUI()
    }

    private fun initializeUI() {
        simpleToolbarWithHome(genre_detail_toolbar, getGenreFromIntent()!!.name)

        with(main_viewpager) {
            adapter = GenreDetailPagerAdapter(supportFragmentManager)
            offscreenPageLimit = 2
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrollStateChanged(state: Int) = Unit
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) = Unit

                override fun onPageSelected(position: Int) = Unit
            })
            tab_layout.setupWithViewPager(this)
        }
    }

    private fun getGenreFromIntent() = intent.getParcelableExtra(GENRE) as Genre?

    companion object {
        const val GENRE = "genre"
        fun startActivityModel(context: Context?, genre: Genre) {
            context.whatIfNotNull {
                val intent = Intent(it, GenreDetailActivity::class.java).apply { putExtra(
                    GENRE, genre) }
                it.startActivity(intent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return false
    }
}
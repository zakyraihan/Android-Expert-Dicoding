package com.zaky.androidexpertdicoding.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.zaky.androidexpertdicoding.R
import com.zaky.androidexpertdicoding.core.domain.model.Teams
import com.zaky.androidexpertdicoding.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailTeamsViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val detailTeams = intent.getParcelableExtra<Teams>(EXTRA_DATA)
        showDetail(detailTeams)

    }

    private fun showDetail(detailTeams: Teams?) {
        detailTeams?.let {
            supportActionBar?.title = detailTeams.strTeam
            binding.content.descTeam.text = detailTeams.strDescriptionEN
            Glide.with(this)
                .load(detailTeams.strTeamBadge)
                .into(binding.imageDetail)
            binding.content.stadiumLocation.text = detailTeams.strStadiumLocation

            var stateFavorite = detailTeams.isFavorite
            setFavoriteState(stateFavorite)
            binding.favButton.setOnClickListener {
                stateFavorite = !stateFavorite
                detailTeamsViewModel.setFavoriteTeams(detailTeams, stateFavorite)
                setFavoriteState(stateFavorite)
            }
        }
    }

    private fun setFavoriteState(status: Boolean) {
        if (status) {
            binding.favButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_favorite
                )
            )
        } else {
            binding.favButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.ic_not_favorite
                )
            )
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
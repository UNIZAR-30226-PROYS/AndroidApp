package com.spreadyourmusic.spreadyourmusic.activities

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.bumptech.glide.Glide

import com.spreadyourmusic.spreadyourmusic.R
import com.spreadyourmusic.spreadyourmusic.adapters.RecomendationsVerticalRecyclerViewAdapter
import com.spreadyourmusic.spreadyourmusic.controller.*
import com.spreadyourmusic.spreadyourmusic.models.Playlist
import com.spreadyourmusic.spreadyourmusic.models.Recommendation
import com.spreadyourmusic.spreadyourmusic.models.Song
import com.spreadyourmusic.spreadyourmusic.models.User

class SystemlistActivity : BaseActivity() {
    var values: Pair<String, List<Recommendation>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_list)

        val systemPlaylistId = intent.getIntExtra(resources.getString(R.string.system_list_id), 0)
        values = obtainSystemGeneratedPlaylist(systemPlaylistId,this)

        //App bar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.title = values!!.first

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val lista = findViewById<RecyclerView>(R.id.recyclerView)
        val recyclerViewAdapter = RecomendationsVerticalRecyclerViewAdapter(this)

        lista.adapter = recyclerViewAdapter
        lista.setHasFixedSize(true)

        lista.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        lista.itemAnimator = DefaultItemAnimator()

        recyclerViewAdapter.setOnClickListener(onRecomendationSelected)
        recyclerViewAdapter.changeData(values!!.second)

        val image = findViewById<ImageView>(R.id.image)

        Glide.with(this).load(obtainCurrentUser().pictureLocationUri).into(image)
    }

    private val onRecomendationSelected: (Recommendation) -> Unit = {
        when (it) {
            is Song -> onSongFromPlaylistSelected(it, obtainFavoriteSongsPlaylist(), this)
            is User -> onUserSelected(it, this)
            is Playlist -> onPlaylistSelected(it, this)
        }
    }

}
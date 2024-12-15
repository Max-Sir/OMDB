package com.max.sir.omdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.selectedMovie.observe(viewLifecycleOwner) { movie ->
            view.findViewById<TextView>(R.id.title).text = movie?.title
            view.findViewById<TextView>(R.id.year).text = movie?.year
            val poster = view.findViewById<ImageView>(R.id.poster)
            Glide.with(this).load(movie?.poster).into(poster)
        }
    }
}

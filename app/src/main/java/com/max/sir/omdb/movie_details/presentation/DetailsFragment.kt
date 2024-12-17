package com.max.sir.omdb.movie_details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.max.sir.omdb.R
import com.max.sir.omdb.core.ImageLoader
import com.max.sir.omdb.databinding.FragmentDetailsBinding
import com.max.sir.omdb.search.presentation.SearchSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private val sharedViewModel: SearchSharedViewModel by activityViewModels()

    private val detailsViewModel: DetailsViewModel by viewModels()

    @Inject
    lateinit var imageLoader: ImageLoader

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.movie.observe(viewLifecycleOwner){
            detailsViewModel.loadMovieDetails(it)
        }

        detailsViewModel.isLoading.observe(viewLifecycleOwner){
            binding.progress.isVisible = it
        }

        detailsViewModel.data.observe(viewLifecycleOwner){
            imageLoader.loadImage(it.poster, binding.poster)
            binding.plot.text = it.plot
            binding.year.text = it.year
            binding.title.text = it.title
            binding.release.text = it.released
        }

        lifecycleScope.launch {
            detailsViewModel.error.collect {
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG)
            }
        }
        binding.addToFavoritesButton.setOnClickListener {
            //TODO implement
        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

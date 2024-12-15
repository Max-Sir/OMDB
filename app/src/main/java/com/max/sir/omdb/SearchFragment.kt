package com.max.sir.omdb

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.max.sir.omdb.R
import dagger.hilt.android.AndroidEntryPoint
import com.max.sir.omdb.databinding.FragmentSearchBinding

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SearchViewModel by viewModels()

    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MoviesAdapter(viewModel::toggleFavorite)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            adapter.submitList(movies)
        }

        binding.searchButton.setOnClickListener {
            val query = binding.searchField.text.toString()
            viewModel.searchMovies(query)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

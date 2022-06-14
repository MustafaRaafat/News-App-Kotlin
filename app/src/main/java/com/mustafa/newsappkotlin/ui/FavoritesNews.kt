package com.mustafa.newsappkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.mustafa.newsappkotlin.R
import com.mustafa.newsappkotlin.databinding.FragmentFavoritesNewsBinding
import com.mustafa.newsappkotlin.models.HeadLinesModel
import com.mustafa.newsappkotlin.ui.adapters.FavoritesAdapter
import com.mustafa.newsappkotlin.viewModels.NewsViewModel


class FavoritesNews : Fragment() {
    private val newsViewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFavoritesNewsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private var _binding: FragmentFavoritesNewsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoritesAdapter = FavoritesAdapter()
        binding.favoritesNewsRecycler.adapter = favoritesAdapter

        newsViewModel.headLines.observe(viewLifecycleOwner, Observer<HeadLinesModel> { t ->
            favoritesAdapter.setData(t.articles)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
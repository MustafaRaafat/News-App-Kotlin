package com.mustafa.newsappkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.mustafa.newsappkotlin.databinding.FragmentBreakingNewsBinding
import com.mustafa.newsappkotlin.models.HeadLinesModel
import com.mustafa.newsappkotlin.ui.adapters.HeadLinesAdapter
import com.mustafa.newsappkotlin.viewModels.NewsViewModel

class BreakingNews : Fragment() {
    private val newsViewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBreakingNewsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    private var _binding: FragmentBreakingNewsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val headLinesAdapter = HeadLinesAdapter()
        binding.breakingNewsRecycler.adapter = headLinesAdapter

        newsViewModel.headLines.observe(viewLifecycleOwner, Observer<HeadLinesModel> { t ->
            headLinesAdapter.setData(t.articles)
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
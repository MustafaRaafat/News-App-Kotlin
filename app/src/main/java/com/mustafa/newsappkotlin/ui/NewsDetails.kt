package com.mustafa.newsappkotlin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mustafa.newsappkotlin.databinding.FragmentNewsDetailsBinding

class NewsDetails : Fragment() {
    private var _binding: FragmentNewsDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: NewsDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNewsDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleDetails.text = args.title
        binding.descriptionDetails.text = args.description
        binding.publishedAtDeatails.text = args.publishedAt
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
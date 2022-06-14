package com.mustafa.newsappkotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.mustafa.newsappkotlin.databinding.FragmentBreakingNewsBinding
import com.mustafa.newsappkotlin.models.ArticlesModel
import com.mustafa.newsappkotlin.models.HeadLinesModel
import com.mustafa.newsappkotlin.ui.adapters.HeadLinesAdapter
import com.mustafa.newsappkotlin.viewModels.NewsViewModel


class BreakingNews : Fragment() {
    val headLinesAdapter = HeadLinesAdapter()
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
        binding.breakingNewsRecycler.adapter = headLinesAdapter

        newsViewModel.headLines.observe(viewLifecycleOwner, Observer<HeadLinesModel> { t ->
            headLinesAdapter.setData(t.articles)
        })

        setupSwipe()


        binding.goToFavorites.setOnClickListener {
            val action=BreakingNewsDirections.actionBreakingNewsToFavoritesNews()
            view.findNavController().navigate(action)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //    function to send data to fav
    private fun setupSwipe() {
        val simpleCallback: ItemTouchHelper.SimpleCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val sw = viewHolder.adapterPosition
                    val dd: ArticlesModel = headLinesAdapter.getArticle(sw)
                    newsViewModel.insertNewsFav(dd)
                }
            }
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.breakingNewsRecycler)
    }
}
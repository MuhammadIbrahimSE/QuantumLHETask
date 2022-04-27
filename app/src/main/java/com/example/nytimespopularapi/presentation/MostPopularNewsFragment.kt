package com.example.nytimespopularapi.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.example.nytimespopularapi.R
import com.example.nytimespopularapi.databinding.FragmentMostPopularNewsBinding
import com.example.nytimespopularapi.model.MostPopularNewsApiResponse
import com.example.nytimespopularapi.presentation.adapter.MostPopularNewsAdapter
import com.example.nytimespopularapi.utils.Resource
import com.example.nytimespopularapi.utils.gone
import com.example.nytimespopularapi.utils.visible


class MostPopularNewsFragment : Fragment(R.layout.fragment_most_popular_news) {

    private var _binding: FragmentMostPopularNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsAdapter: MostPopularNewsAdapter
    private val mostPopularNewsViewModel: MostPopularNewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMostPopularNewsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mostPopularNewsViewModel.newsList.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.pbLoading.visible()
                }
                is Resource.Success -> {
                    binding.pbLoading.gone()
                    populateData(it.data as List<MostPopularNewsApiResponse.Result>)
                }
                is Resource.Error -> {
                    binding.pbLoading.gone()

                }
            }
        }
    }

    fun populateData(data: List<MostPopularNewsApiResponse.Result>) {
        newsAdapter = MostPopularNewsAdapter(
            data as MutableList<MostPopularNewsApiResponse.Result>
        ) { data, pos ->
            //TODO:
        }
        binding.rvPopularNews.adapter = newsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
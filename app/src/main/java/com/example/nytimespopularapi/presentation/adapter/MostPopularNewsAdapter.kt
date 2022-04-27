package com.example.nytimespopularapi.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimespopularapi.R
import com.example.nytimespopularapi.databinding.LayoutMostPopularNewsItemBinding
import com.example.nytimespopularapi.model.MostPopularNewsApiResponse

class MostPopularNewsAdapter(
    val list: MutableList<MostPopularNewsApiResponse.Result>,
    val clickCallBack: (a: MostPopularNewsApiResponse.Result, b: Int) -> Unit,
) : RecyclerView.Adapter<MostPopularNewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_most_popular_news_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = list[position]

        holder.binding.apply {
            model = dataItem
            dataItem.media?.let {
                metadata = dataItem.media!!.get(0)?.mediaMetadata!![0]
            }
            this.root.setOnClickListener {
                clickCallBack(dataItem, position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(val binding: LayoutMostPopularNewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}
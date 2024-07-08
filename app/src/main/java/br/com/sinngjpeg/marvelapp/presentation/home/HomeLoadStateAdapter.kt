package br.com.sinngjpeg.marvelapp.presentation.home

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class HomeLoadStateAdapter(
    private val retry: () -> Unit,
) : LoadStateAdapter<HomeLoadStateViewHolder>() {
    override fun onBindViewHolder(
        holder: HomeLoadStateViewHolder,
        loadState: LoadState,
    ) = holder.bind(loadState)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState,
    ): HomeLoadStateViewHolder = HomeLoadStateViewHolder.create(parent, retry)
}

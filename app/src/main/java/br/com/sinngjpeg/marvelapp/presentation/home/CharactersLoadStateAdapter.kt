package br.com.sinngjpeg.marvelapp.presentation.home

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class CharactersLoadStateAdapter(
    private val retry: () -> Unit,
) : LoadStateAdapter<CharactersLoadStateViewHolder>() {
    override fun onBindViewHolder(
        holder: CharactersLoadStateViewHolder,
        loadState: LoadState,
    ) = holder.bind(loadState)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState,
    ): CharactersLoadStateViewHolder = CharactersLoadStateViewHolder.create(parent, retry)
}

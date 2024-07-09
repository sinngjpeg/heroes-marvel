package br.com.sinngjpeg.marvelapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import br.com.sinngjpeg.marvelapp.databinding.CharactersLoadMoreStateItemBinding

class CharactersLoadStateViewHolder(
    itemBinding: CharactersLoadMoreStateItemBinding,
    retry: () -> Unit,
) : RecyclerView.ViewHolder(itemBinding.root) {

    private val binding = CharactersLoadMoreStateItemBinding.bind(itemView)
    private val progressBarLoading = binding.progressBarLoading
    private val textTryAgain = binding.textTryAgain.also {
            it.setOnClickListener {
                retry()
            }
        }

    fun bind(loadState: LoadState) {
        progressBarLoading.isVisible = loadState is LoadState.Loading
        textTryAgain.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): CharactersLoadStateViewHolder {
            val itemBinding = CharactersLoadMoreStateItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
            return CharactersLoadStateViewHolder(itemBinding, retry)
        }
    }
}

package br.com.sinngjpeg.marvelapp.presentation.home

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import br.com.jpegsinng.core.domain.model.Character
import br.com.sinngjpeg.marvelapp.framework.imageloader.ImageLoader
import br.com.sinngjpeg.marvelapp.utils.OnCharacterItemClick
import javax.inject.Inject

class CharactersAdapter @Inject constructor(
    private val imageLoader: ImageLoader,
    private val onItemClick: OnCharacterItemClick
) : PagingDataAdapter<Character, CharactersViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder.create(parent, imageLoader, onItemClick)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}

package br.com.sinngjpeg.marvelapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.jpegsinng.core.domain.model.Character
import br.com.sinngjpeg.marvelapp.databinding.ItemCharacterBinding
import br.com.sinngjpeg.marvelapp.framework.imageloader.ImageLoader
import br.com.sinngjpeg.marvelapp.utils.OnCharacterItemClick

class CharactersViewHolder(
    itemCharacterBinding: ItemCharacterBinding,
    private val imageLoader: ImageLoader,
    private val onItemClick: OnCharacterItemClick
) : RecyclerView.ViewHolder(itemCharacterBinding.root) {

    private val textName = itemCharacterBinding.textName
    private val imageCharacter = itemCharacterBinding.imageCharacter

    fun bind(character: Character) {
        textName.text = character.name
        imageCharacter.transitionName = character.name
        imageLoader.load(imageCharacter, character.imageUrl)

        itemView.setOnClickListener {
            onItemClick.invoke(character, imageCharacter)
        }

    }

    companion object{
        fun create(
            parent: ViewGroup,
            imageLoader: ImageLoader,
            onItemClick: OnCharacterItemClick
        ): CharactersViewHolder{
            val inflater  = LayoutInflater.from(parent.context)
            val itemCharacterBinding = ItemCharacterBinding.inflate(inflater, parent, false)
            return CharactersViewHolder(itemCharacterBinding, imageLoader, onItemClick)
        }
    }

}

package br.com.sinngjpeg.marvelapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.jpegsinng.core.domain.model.Character
import br.com.sinngjpeg.marvelapp.R
import br.com.sinngjpeg.marvelapp.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide

class CharactersViewHolder(
    itemCharacterBinding: ItemCharacterBinding,
) : RecyclerView.ViewHolder(itemCharacterBinding.root) {
    private val imageCharacter = itemCharacterBinding.imageCharacter
    private val textName = itemCharacterBinding.textName

    fun bind(character: Character) {
        textName.text = character.name
        Glide
            .with(itemView)
            .load(character.thumbnail)
            .fallback(R.drawable.ic_image_error)
            .into(imageCharacter)
    }

    companion object{
        fun create(parent: ViewGroup): CharactersViewHolder{
            val inflater  = LayoutInflater.from(parent.context)
            val itemCharacterBinding = ItemCharacterBinding.inflate(inflater, parent, false)
            return CharactersViewHolder(itemCharacterBinding)
        }
    }

}

package com.example.interviewapplicationadt.view

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.interviewapplicationadt.R
import com.example.interviewapplicationadt.databinding.ItemCharacterBinding
import com.example.interviewapplicationadt.model.Character

class CharacterAdapter(
    private val listener: (Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    private val characters = mutableListOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            .let { CharacterViewHolder(it, listener) }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.loadCharacter(characters[position])
    }

    override fun getItemCount() = characters.size

    fun load(data: List<Character>) {
        characters.clear()
        characters.addAll(data)
        notifyDataSetChanged()
    }

    class CharacterViewHolder(
        private val binding: ItemCharacterBinding,
        private val listener: (Character) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun loadCharacter(character: Character) = with(binding) {
            ivPhoto.load(character.image)
            tvName.text = character.name
            tvSpecies.text = character.species
            tvName.apply { text = context.getString(R.string.name, character.name) }
            tvSpecies.apply { text = context.getString(R.string.species, character.species) }
            tvStatus.apply { text = context.getString(R.string.status, character.status) }
            root.setOnClickListener { listener.invoke(character) }
        }
    }

}

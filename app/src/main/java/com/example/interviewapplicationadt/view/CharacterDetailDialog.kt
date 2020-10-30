package com.example.interviewapplicationadt.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.example.interviewapplicationadt.R
import com.example.interviewapplicationadt.databinding.DialogCharacterDetailBinding

class CharacterDetailDialog : DialogFragment() {

    private lateinit var binding: DialogCharacterDetailBinding
    private val args: CharacterDetailDialogArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DialogCharacterDetailBinding.inflate(layoutInflater, container, false)
        .also { binding = it }.root

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadCharacterData()
    }

    private fun loadCharacterData() = with(binding) {
        locationName.text = args.character.location?.name
    }
}
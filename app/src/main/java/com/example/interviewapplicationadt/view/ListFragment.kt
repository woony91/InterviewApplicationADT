package com.example.interviewapplicationadt.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.interviewapplicationadt.databinding.FragmentListBinding
import com.example.interviewapplicationadt.model.Character
import com.example.interviewapplicationadt.model.CharacterResponse
import com.example.interviewapplicationadt.util.ApiState
import com.example.interviewapplicationadt.viewmodel.MainViewModel

class ListFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentListBinding.inflate(inflater, container, false)
        .also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservables()
    }

    private fun setupRecyclerView() = with(binding.rvCharacters) {
        layoutManager = LinearLayoutManager(context)
        adapter = CharacterAdapter(::characterSelected)
    }

    private fun setupObservables() = with(viewModel.charactersObservable) {
        observe(viewLifecycleOwner) { state ->
            when (state) {
                is ApiState.Loading -> binding.loading(true)
                is ApiState.Success -> binding.success(state)
                is ApiState.Error -> binding.error(state)
            }
        }
    }

    private fun characterSelected(character: Character) = with(ListFragmentDirections) {
        findNavController().navigate(showCharacterDetail(character))
    }

    private fun FragmentListBinding.loading(isLoading: Boolean) {
        progress.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun FragmentListBinding.success(state: ApiState.Success<CharacterResponse>) {
        loading(false)
        (binding.rvCharacters.adapter as CharacterAdapter).load(state.data.results)
    }

    private fun FragmentListBinding.error(state: ApiState.Error) {
        loading(false)
    }
}
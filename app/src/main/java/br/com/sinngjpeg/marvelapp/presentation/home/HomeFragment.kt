package br.com.sinngjpeg.marvelapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.jpegsinng.core.domain.model.Character
import br.com.sinngjpeg.marvelapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val charactersAdapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = FragmentHomeBinding
        .inflate(inflater, container, false)
        .apply {
            _binding = this
        }.root

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        initCharactersAdapter()
        charactersAdapter.submitList(
            listOf(
                Character("3D-Man", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"),
                Character("3D-Man", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"),
                Character("3D-Man", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"),
                Character("3D-Man", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"),
                Character("3D-Man", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"),
                Character("3D-Man", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784"),
                Character("3D-Man", "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784")
            ),
        )
    }

    private fun initCharactersAdapter() {
        with(binding.recyclerCharacters) {
            setHasFixedSize(true)
            adapter = charactersAdapter
        }
    }
}

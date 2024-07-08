package br.com.sinngjpeg.marvelapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import br.com.sinngjpeg.marvelapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    private val viewModel: CharactersViewModel by viewModels()

    private lateinit var charactersAdapter: CharactersAdapter

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
        observeInitialLoadState()

        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.charactersPagingData("").collect { pagingData ->
                    charactersAdapter.submitData(pagingData)
                }
            }
        }
    }

    private fun initCharactersAdapter() {
        charactersAdapter = CharactersAdapter()
        with(binding.recyclerCharacters) {
            scrollToPosition(0)
            setHasFixedSize(true)
            adapter = charactersAdapter.withLoadStateFooter(
                    footer = HomeLoadStateAdapter(
                        charactersAdapter::retry
                    )
                )
        }
    }

    private fun observeInitialLoadState() {
        lifecycleScope.launch {
            charactersAdapter.loadStateFlow.collectLatest { loadState ->
                binding.flipperHome.displayedChild =
                    when (loadState.refresh) {
                        is LoadState.Loading -> {
                            setShimmerVisibility(true)
                            FLIPPER_CHILD_LOADING
                        }

                        is LoadState.NotLoading -> {
                            setShimmerVisibility(false)
                            FLIPPER_CHILD_CHARACTERS
                        }

                        is LoadState.Error -> {
                            setShimmerVisibility(false)
                            buttonReloadClick()
                            FLIPPER_CHILD_ERROR
                        }
                    }
            }
        }
    }

    private fun buttonReloadClick() {
        binding.viewHomeErrorState.buttonRetry.setOnClickListener {
            charactersAdapter.refresh()
        }
    }

    private fun setShimmerVisibility(visibility: Boolean) {
        binding.viewHomeLoadingState.shimmerHome.run {
            isVisible = visibility
            if (visibility) {
                startShimmer()
            } else {
                stopShimmer()
            }
        }
    }

    companion object {
        private const val FLIPPER_CHILD_LOADING = 0
        private const val FLIPPER_CHILD_CHARACTERS = 1
        private const val FLIPPER_CHILD_ERROR = 2
    }
}

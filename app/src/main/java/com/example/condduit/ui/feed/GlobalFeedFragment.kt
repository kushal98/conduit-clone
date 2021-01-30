package com.example.condduit.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.condduit.databinding.FragmentFeedBinding

class GlobalFeedFragment : Fragment() {

    private  var _binding: FragmentFeedBinding? = null
    private var _viewModel: FeedViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        _binding =  FragmentFeedBinding.inflate(inflater,container , false)

        _binding?.feedFetchBtn?.setOnClickListener{
            _viewModel?.fetchGlobalFeed()
        }

        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
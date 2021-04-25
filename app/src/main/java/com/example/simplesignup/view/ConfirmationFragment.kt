package com.example.simplesignup.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simplesignup.databinding.FragmentConfirmationBinding
import com.example.simplesignup.viewModel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ConfirmationFragment : Fragment() {

    private val signUpViewModel by sharedViewModel<SignUpViewModel>()
    private lateinit var binding: FragmentConfirmationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false).also { binding ->
            binding.viewmodel = signUpViewModel
            binding.lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }
}
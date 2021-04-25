package com.example.simplesignup.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.simplesignup.R
import com.example.simplesignup.databinding.FragmentProfileCreationBinding
import com.example.simplesignup.viewModel.SignUpViewModel
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileCreationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileCreationFragment : Fragment() {

    private val signUpViewModel by sharedViewModel<SignUpViewModel>()
    private lateinit var binding: FragmentProfileCreationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentProfileCreationBinding.inflate(inflater, container, false).also { binding ->
                binding.viewmodel = signUpViewModel
                binding.lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener {
            findNavController().navigate(ProfileCreationFragmentDirections.actionProfileCreationFragmentToConfirmationFragment())
        }
        subscribeUi()
    }

    private fun subscribeUi() {
        signUpViewModel.apply {
            isEmailInputValid.observe(viewLifecycleOwner) { isValid ->
                if (!isValid) {
                    binding.emailAddressLayout.error = "Email Address Input is invalid"
                }
            }

            isFirstNameValid.observe(viewLifecycleOwner) { isValid ->
                if (!isValid) {
                    binding.firstNameLayout.error = "only allow to input from letters a-z or A-Z"
                }
            }

            isWebsiteValid.observe(viewLifecycleOwner) { isValid ->
                if (!isValid) {
                    binding.websiteLayout.error = "web url is invalid"
                }
            }
        }
    }
}
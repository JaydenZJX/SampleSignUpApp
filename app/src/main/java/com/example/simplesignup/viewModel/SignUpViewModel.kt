package com.example.simplesignup.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplesignup.validateEmailAddress
import com.example.simplesignup.validateFirstName
import com.example.simplesignup.validateWebUrl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SignUpViewModel() }
}

class SignUpViewModel : ViewModel() {

    var firstName = MutableLiveData("")
    var email = MutableLiveData("")
    var password = MutableLiveData("")
    var website = MutableLiveData("")

    var isFirstNameValid = MutableLiveData(true)
    var isEmailInputValid = MutableLiveData(true)
    var isWebsiteValid = MutableLiveData(true)

    fun onFirstNameTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        isFirstNameValid.value = validateFirstName(s)
    }

    fun onEmailTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        isEmailInputValid.value = validateEmailAddress(s)
    }

    fun onWebsiteTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        isWebsiteValid.value = validateWebUrl(s)
    }
}
package com.example.simplesignup.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.simplesignup.R
import com.example.simplesignup.viewModel.SignUpViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpActivity : AppCompatActivity() {

    private val signUpViewModel by viewModel<SignUpViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
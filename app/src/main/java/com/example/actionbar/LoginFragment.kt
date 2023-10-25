package com.example.actionbar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.actionbar.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    //buat binding dulu
     lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Set click listener for the login button
        with(binding) {
            btnLogin.setOnClickListener {
                val username = editTxtUsernameLogin.text.toString()
                val password = editTxtPasswordLogin.text.toString()

                if (username.isEmpty()) {
                    editTxtUsernameLogin.error = "Masukkan username"
                    return@setOnClickListener
                }

                if (password.isEmpty()) {
                    editTxtPasswordLogin.error = "Masukkan password"
                    return@setOnClickListener
                }

                if (username.isEmpty() && password.isEmpty()) {
                    val intent = Intent(activity, SecondActivity::class.java)
                    startActivity(intent)

                    editTxtUsernameLogin.text.clear()
                    editTxtPasswordLogin.text.clear()

                    binding.checkboxLogin.isChecked = false

                }
            }
            // Set click listener for the "Register" text
            binding.txtRegister.setOnClickListener {
                MainActivity.viewPager2.setCurrentItem(0)
            }
            return binding.root
        }
    }
}
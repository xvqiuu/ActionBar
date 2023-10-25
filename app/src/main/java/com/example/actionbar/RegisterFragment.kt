package com.example.actionbar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.actionbar.MainActivity
import com.example.actionbar.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    //utk memanggil variabel di suatu kelas tanpa melalui sebuah objek
    companion object {
        var username = ""
        var email = ""
        var phone = ""
        var password = ""
    }

    lateinit var binding : FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        // Set click listener for the login button
        with(binding) {
            btnRegister.setOnClickListener {
                val inputUsername = editTxtUsernameRegister.text.toString()
                val inputEmail = editTxtEmailRegister.text.toString()
                val inputPhone = editTxtPhoneRegister.text.toString()
                val inputPassword = editTxtPasswordRegister.text.toString()

                if (inputUsername.isEmpty()) {
                    editTxtUsernameRegister.error = "Username harus diisi"
                    return@setOnClickListener
                }

                if (inputEmail.isEmpty()) {
                    editTxtEmailRegister.error = "Email harus diisi"
                    return@setOnClickListener
                }

                if (inputPhone.isEmpty()) {
                    editTxtPhoneRegister.error = "Phone harus diisi"
                    return@setOnClickListener
                }

                if (inputPassword.isEmpty()) {
                    editTxtPasswordRegister.error = "Password harus diisi"
                    return@setOnClickListener
                }

                username = inputUsername
                email = inputEmail
                phone = inputPhone
                password = inputPassword

                editTxtUsernameRegister.text.clear()
                editTxtEmailRegister.text.clear()
                editTxtPhoneRegister.text.clear()
                editTxtPasswordRegister.text.clear()

                binding.checkboxRegister.isChecked = false

                MainActivity.viewPager1Companion.setCurrentItem(1)

            }
        }
        // Set click listener for the "Register" text
        binding.txtLogin.setOnClickListener {
           MainActivity.viewPager1Companion.setCurrentItem(1)
        }
        return binding.root
    }
}


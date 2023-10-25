package com.example.actionbar

import RegisterFragment.Companion.password
import RegisterFragment.Companion.username
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val inputUsername = view.findViewById<EditText>(R.id.edit_txt_username_login)
        val inputPassword = view.findViewById<EditText>(R.id.edit_txt_password_login)

        view.findViewById<View>(R.id.btn_login).setOnClickListener() {
            if (inputUsername.text.toString().isEmpty()) {
                view.findViewById<EditText>(R.id.edit_txt_username_login).error = "Masukkan username"
                return@setOnClickListener
            }

            if (inputPassword.text.toString().isEmpty()) {
                view.findViewById<EditText>(R.id.edit_txt_password_login).error = "Masukkan password"
                return@setOnClickListener
            }

            if (inputUsername.text.toString() == username && inputPassword.text.toString() == password) {
                val intent = Intent(activity, SecondActivity::class.java)

                inputUsername.text.clear()
                inputPassword.text.clear()

                with(view){
                    findViewById<CheckBox>(R.id.checkbox_login).isChecked = false
                }

                startActivity(intent)
            }

        }

        with(view){
            findViewById<View>(R.id.txt_register).setOnClickListener() {
                MainActivity.viewPager2.setCurrentItem(0)
            }
        }

        return view
    }
}
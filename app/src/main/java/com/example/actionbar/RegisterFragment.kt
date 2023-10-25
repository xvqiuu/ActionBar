import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.actionbar.MainActivity
import com.example.actionbar.SecondActivity
import com.example.actionbar.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
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
                val username = editTxtUsernameRegister.text.toString()
                val email = editTxtEmailRegister.text.toString()
                val phone = editTxtPhoneRegister.text.toString()
                val password = editTxtPasswordRegister.text.toString()

                if (username.isEmpty()) {
                    editTxtUsernameRegister.error = "Masukkan username"
                    return@setOnClickListener
                }

                if (email.isEmpty()) {
                    editTxtEmailRegister.error = "Masukkan password"
                    return@setOnClickListener
                }

                if (phone.isEmpty()) {
                    editTxtPhoneRegister.error = "Masukkan password"
                    return@setOnClickListener
                }

                if (password.isEmpty()) {
                    editTxtPasswordRegister.error = "Masukkan password"
                    return@setOnClickListener
                }

                if (username.isEmpty() && password.isEmpty()) {

                    editTxtUsernameRegister.text.clear()
                    editTxtEmailRegister.text.clear()
                    editTxtPhoneRegister.text.clear()
                    editTxtPasswordRegister.text.clear()
                    checkboxRegister.isChecked = false
                }
            }
            // Set click listener for the "Register" text
            binding.txtLogin.setOnClickListener {
                MainActivity.viewPager2.setCurrentItem(0)
            }
            return binding.root
        }
    }
}

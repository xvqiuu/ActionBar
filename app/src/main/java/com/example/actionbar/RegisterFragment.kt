import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.actionbar.MainActivity.Companion.viewPager2
import com.example.actionbar.R

class RegisterFragment : Fragment() {
    companion object {
        var username = ""
        var email = ""
        var phone = ""
        var password = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_register, container, false)

        val inputUsername = view.findViewById<EditText>(R.id.edit_txt_username_register)
        val inputPhone = view.findViewById<EditText>(R.id.edit_txt_phone_register)
        val inputEmail = view.findViewById<EditText>(R.id.edit_txt_email_register)
        val inputPassword = view.findViewById<EditText>(R.id.edit_txt_password_register)

        view.findViewById<View>(R.id.btn_register).setOnClickListener() {
            if (inputUsername.text.toString().isEmpty()) {
                view.findViewById<EditText>(R.id.edit_txt_username_register).error = "Masukkan username"
                return@setOnClickListener
            }

            if (inputPhone.text.toString().isEmpty()) {
                view.findViewById<EditText>(R.id.edit_txt_phone_register).error = "Masukkan phone"
                return@setOnClickListener
            }

            if (inputEmail.text.toString().isEmpty()) {
                view.findViewById<EditText>(R.id.edit_txt_email_register).error = "Masukkan email"
                return@setOnClickListener
            }

            if (inputPassword.text.toString().isEmpty()) {
                view.findViewById<EditText>(R.id.edit_txt_password_register).error = "Masukkan password"
                return@setOnClickListener
            }

            username = inputUsername.text.toString()
            password = inputPassword.text.toString()
            phone = inputPhone.text.toString()
            email = inputEmail.text.toString()

            inputUsername.text.clear()
            inputPassword.text.clear()
            inputEmail.text.clear()
            inputPhone.text.clear()

            with(view) {
                findViewById<CheckBox>(R.id.checkbox_register).isChecked = false
            }
            viewPager2.setCurrentItem(1)
        }
        view.findViewById<View>(R.id.txt_login).setOnClickListener() {
            viewPager2.setCurrentItem(1)
        }
        return view
    }
}


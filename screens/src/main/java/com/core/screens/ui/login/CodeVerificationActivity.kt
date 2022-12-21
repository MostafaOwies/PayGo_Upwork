package com.core.screens.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.core.screens.MainActivity
import com.core.screens.R
import com.core.screens.databinding.ActivityCodeVerificationBinding
import com.core.utils.EditTextCodeUtil.Companion.moveToNextCodeInput


class CodeVerificationActivity : AppCompatActivity(), ICodeVerificationActivity {
    private var _binding: ActivityCodeVerificationBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_code_verification)

        setUpUi()

    }

    override fun setUpUi() {

        val mCode1ET = binding.code1EditText
        val mCode2ET = binding.code2EditText
        val mCode3ET = binding.code3EditText
        val mCode4ET = binding.code4EditText
        val mCode5ET = binding.code5EditText
        val mCode6ET = binding.code6EditText

        moveToNextCodeInput(mCode1ET, mCode1ET, mCode2ET, false)
        moveToNextCodeInput(mCode2ET, mCode1ET, mCode3ET, false)
        moveToNextCodeInput(mCode3ET, mCode2ET, mCode4ET, false)
        moveToNextCodeInput(mCode4ET, mCode3ET, mCode5ET, false)
        moveToNextCodeInput(mCode5ET, mCode4ET, mCode6ET, false)
        moveToNextCodeInput(mCode6ET, mCode5ET, mCode6ET, true)

        binding.confirmCodeBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
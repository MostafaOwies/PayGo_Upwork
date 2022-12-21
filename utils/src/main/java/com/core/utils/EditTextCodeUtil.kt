package com.core.utils

import android.text.Editable
import android.text.TextWatcher
import com.google.android.material.textfield.TextInputEditText

class EditTextCodeUtil {

    companion object {

        fun moveToNextCodeInput(
            inputEditText: TextInputEditText,
            previousEditText: TextInputEditText,
            nextEditText: TextInputEditText,
            isLastInput: Boolean
        ) {
            inputEditText.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    val inputSize = inputEditText.text.toString().length
                    if (inputSize == 1) {
                        nextEditText.requestFocus()
                    } else if (inputSize == 0) {
                        previousEditText.requestFocus()
                    }
                }

                override fun afterTextChanged(s: Editable) {

                }
            })
        }
    }
}
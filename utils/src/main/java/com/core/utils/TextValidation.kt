package com.core.utils

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

fun showErrorEditText(editText: View, errorId: Int) {
    editText.requestFocus()
    shake(editText)
}

fun shake(v: View) {
    val shake: Animation = AnimationUtils.loadAnimation(v.context, R.anim.shake)
    v.startAnimation(shake)
}

fun isInputEmpty(input: String?): Boolean {
    return input == null || input.trim().isEmpty()
}

fun isInputEmpty(input: Int?): Boolean {
    return input == null
}

fun isNotEqual(password: String, confirmPassword: String): Boolean {
    return password != confirmPassword
}

fun isEmailValid(email: String?): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email ?: "").matches()
}

fun isNameValid(name: String): Boolean {
    return name.length >= 4
}
//
// fun isPhoneValid(phone: String): Boolean {
//    val phoneUtil = PhoneNumberUtil.getInstance()
//    return try {
//        phoneUtil.isValidNumber(phoneUtil.parse(phone, "KW"))
//    } catch (e: NumberParseException) {
//        false
//    }
// }
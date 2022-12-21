package com.core.base

import com.google.gson.annotations.SerializedName

open class BaseResponse(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @SerializedName(value = "status", alternate = ["state"])
    val status: Int? = null
)
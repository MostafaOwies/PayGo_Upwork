package com.core.network.exception

import com.core.network.exception.Failure.FeatureFailure
import retrofit2.Response

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific failure should extend [FeatureFailure] class.
 */
sealed class Failure {

    var response: Response<*>? = null
    var errorMsg: String? = null

    object NetworkConnection : Failure()
    object ServerError : Failure()
    object FeatureError : Failure()

    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure : Failure()
}

package com.core.network.functional


/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Failure] or [Success].
 *
 * @see Failure
 * @see Success
 */
sealed class Either<out ERROR, out DATA> {
    data class Failure<out ERROR>(val error: ERROR) : Either<ERROR, Nothing>()

    data class Success<out DATA>(val data: DATA) : Either<Nothing, DATA>()

    /**
     * Returns true if this is a Success, false otherwise.
     * @see Success
     */
    val isSuccess get() = this is Success<DATA>

    /**
     * Returns true if this is a Failure, false otherwise.
     * @see Failure
     */
    val isError get() = this is Failure<ERROR>

    /**
     * Creates a Failure type.
     * @see Failure
     */
    fun <ERROR> failure(error: ERROR) = Failure(error)

    /**
     * Creates a Success type.
     * @see Success
     */
    fun <DATA> success(data: DATA) = Success(data)

    /**
     * Applies fnL if this is a Failure or fnR if this is a Success.
     * @see Failure
     * @see Success
     */
    fun fold(fnL: (ERROR) -> Any, fnR: (DATA) -> Any): Any =
        when (this) {
            is Failure -> fnL(error)
            is Success -> fnR(data)
        }
}

/**
 * Composes 2 functions
 * See <a href="https://proandroiddev.com/kotlins-nothing-type-946de7d464fb">Credits to Alex Hart.</a>
 */
fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

/**
 * Success-biased flatMap() FP convention which means that Success is assumed to be the default case
 * to operate on. If it is Failure, operations like map, flatMap, ... return the Failure value unchanged.
 */
fun <T, ERROR, DATA> Either<ERROR, DATA>.flatMap(fn: (DATA) -> Either<ERROR, T>): Either<ERROR, T> =
    when (this) {
        is Either.Failure -> Either.Failure(error)
        is Either.Success -> fn(data)
    }

/**
 * Success-biased map() FP convention which means that Success is assumed to be the default case
 * to operate on. If it is Failure, operations like map, flatMap, ... return the Failure value unchanged.
 */
fun <T, ERROR, DATA> Either<ERROR, DATA>.map(fn: (DATA) -> (T)): Either<ERROR, T> =
    this.flatMap(fn.c(::success))

/** Returns the value from this `Success` or the given argument if this is a `Failure`.
 *  Success(12).getOrElse(17) RETURNS 12 and Failure(12).getOrElse(17) RETURNS 17
 */
fun <ERROR, DATA> Either<ERROR, DATA>.getOrElse(value: DATA): DATA =
    when (this) {
        is Either.Failure -> value
        is Either.Success -> data
    }

/**
 * Failure-biased onFailure() FP convention dictates that when this class is Failure, it'll perform
 * the onFailure functionality passed as a parameter, but, overall will still return an either
 * object so you chain calls.
 */
fun <ERROR, DATA> Either<ERROR, DATA>.onFailure(fn: (failure: ERROR) -> Unit): Either<ERROR, DATA> =
    this.apply { if (this is Either.Failure) fn(error) }

/**
 * Success-biased onSuccess() FP convention dictates that when this class is Success, it'll perform
 * the onSuccess functionality passed as a parameter, but, overall will still return an either
 * object so you chain calls.
 */
fun <ERROR, DATA> Either<ERROR, DATA>.onSuccess(fn: (success: DATA) -> Unit): Either<ERROR, DATA> =
    this.apply { if (this is Either.Success) fn(data) }

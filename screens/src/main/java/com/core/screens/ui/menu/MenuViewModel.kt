package com.core.screens.ui.menu

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.core.base.BaseViewModel
import com.core.data.data.category.repo.CategoryRepo
import com.core.domain.entities.category.Category
import com.core.domain.entities.category.CategoryDto
import com.core.utils.constants.Constants
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MenuViewModel
@Inject constructor(
    private val categoryRepo: CategoryRepo
) : BaseViewModel() {

    val mFireStore = Firebase.firestore

    fun saveCategories(category: Category) = viewModelScope.launch {
        categoryRepo.insertCategory(category)
    }

    fun getCategoryList() = categoryRepo.getAllCategories()

    fun deleteCates(category: Category) = viewModelScope.launch {
        categoryRepo.deleteCategory(category)
    }
    //suspend fun getFireBaseCate() = categoryRepo.getFireBaseCategory()

     suspend fun getFireBaseCategory() {
        try {
            withContext(Dispatchers.IO) {
                mFireStore.collection(Constants.CATEGORY)
                    .get()
                    .addOnSuccessListener { cate ->
                        val cateList : ArrayList<CategoryDto> = ArrayList()
                        for (document in cate) {
                            Log.d(TAG, "MY CATEGORY LIST ${document.id} => ${document.data}")
                            val categoryDto = document.toObject(CategoryDto::class.java)
                            //category.categoryId=document.id.toInt()
                            cateList.add(categoryDto)
                        }
                        viewModelScope.launch {
                            cateList.forEach { saveCategories(it.toCategory()) }
                        }
                    }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}
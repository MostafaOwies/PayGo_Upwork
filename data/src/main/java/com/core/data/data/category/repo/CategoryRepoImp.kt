package com.core.data.data.category.repo

import com.core.data.data.category.dao.CategoryDao
import com.core.domain.entities.category.Category
import com.core.domain.relations.onetomany.CategoryWithProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CategoryRepoImp @Inject constructor(private val categoryDao: CategoryDao) : CategoryRepo {


    //val cateList : ArrayList<Category> = ArrayList()





    override suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    override suspend fun deleteCategory(category: Category) {
        categoryDao.deleteCategory(category)
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories()
    }

    override fun getCategoryWithProduct(categoryId: Int): Flow<List<CategoryWithProduct>> {
        return categoryDao.getCategoryWithProduct(categoryId)
    }

    override fun getCategoryList(categoryId: Int): Flow<List<Category>> {
        return categoryDao.getCategoryList(categoryId)
    }
}

package com.core.data.data.category.di

import com.core.data.PayGoDatabase
import com.core.data.data.category.dao.CategoryDao
import com.core.data.data.category.repo.CategoryRepo
import com.core.data.data.category.repo.CategoryRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CategoryModule {

    @Provides
    @Singleton
    fun provideCategoryDao(db: PayGoDatabase): CategoryDao {
        return db.getCategoryDao()
    }

    @Provides
    @Singleton
    fun provideCategoryRepo(categoryRepoImp: CategoryRepoImp): CategoryRepo {
        return categoryRepoImp
    }
}
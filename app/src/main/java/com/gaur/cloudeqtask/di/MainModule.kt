package com.gaur.cloudeqtask.di

import com.gaur.cloudeqtask.network.APiService
import com.gaur.cloudeqtask.repository.FirstRepository
import com.gaur.cloudeqtask.repository.SecondRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object MainModule {

    const val BASE_URL="https://fakestoreapi.com/"

    @Provides
    fun provideFirstRepo(): FirstRepository {
        return FirstRepository()
    }

    @Provides
    fun provideSecondRepo(aPiService: APiService):SecondRepository{
        return SecondRepository(apiService = aPiService)
    }

    @Provides
    fun provideApiService(): APiService {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(APiService::class.java)
    }

}
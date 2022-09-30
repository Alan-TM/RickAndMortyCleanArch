package com.alan.rickandmortycleanarch.di

import com.alan.rickandmortycleanarch.commons.StringUtils.BASE_URL
import com.alan.rickandmortycleanarch.data.remote.RickAndMortyService
import com.alan.rickandmortycleanarch.data.repository.RickAndMortyRepositoryImpl
import com.alan.rickandmortycleanarch.domain.repository.RickAndMortyRepository
import com.alan.rickandmortycleanarch.domain.use_case.GetCharactersUseCase
import com.alan.rickandmortycleanarch.presentation.characters.CharactersViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<RickAndMortyService> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .build()
            .create(RickAndMortyService::class.java)
    }

    single<RickAndMortyRepository> {
        RickAndMortyRepositoryImpl(get())
    }

    single {
        GetCharactersUseCase(get())
    }

    viewModel {
        CharactersViewModel(get())
    }
}

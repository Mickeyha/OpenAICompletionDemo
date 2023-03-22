package com.mickey.openaicompletiondemo.data

import com.mickey.openaicompletiondemo.network.OpenAIApiService
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val openAIRepository: OpenAIRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://api.openai.com/"
    private val API_KEY = "Please enter your API Key here"

    private var client: OkHttpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $API_KEY")
            .addHeader("Content-Type", "application/json")
            .addHeader("OpenAI-Organization", "org-e6U6oLRWsvyq9kZHJoJa7ZNG")
            .build()
        chain.proceed(newRequest)
    }.build()

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: OpenAIApiService by lazy {
        retrofit.create(OpenAIApiService::class.java)
    }

    /**
     * DI implementation for OpenAI repository
     */
    override val openAIRepository: OpenAIRepository by lazy {
        NetworkOpenAIRepository(retrofitService)
    }
}
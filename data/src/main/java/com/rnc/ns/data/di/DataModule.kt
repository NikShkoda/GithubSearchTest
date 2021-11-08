package com.rnc.ns.data.di

import com.rnc.ns.data.remote.api.GithubApi
import com.rnc.ns.data.remote.datasource.GithubRepoRemoteDataSource
import com.rnc.ns.data.repository.GithubRepoRepositoryImpl
import com.rnc.ns.domain.repository.GithubRepoRepository
import com.rnc.ns.domain.usecase.GetGithubReposUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [NetworkModule::class])
object DataModule {

    @Provides
    @Singleton
    internal fun provideGithubRepoDataSource(githubApi: GithubApi): GithubRepoRemoteDataSource {
        return GithubRepoRemoteDataSource(githubApi)
    }

    @Provides
    @Singleton
    internal fun provideGithubRepoRepository(githubRepoDataSource: GithubRepoRemoteDataSource): GithubRepoRepository {
        return GithubRepoRepositoryImpl(githubRepoDataSource)
    }

    @Provides
    @Singleton
    internal fun provideGetAppealsUseCase(repository: GithubRepoRepository): GetGithubReposUseCase {
        return GetGithubReposUseCase(repository)
    }
}
package com.max.sir.omdb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideNavigator(navigatorProvider: NavigatorProvider): Navigator {
        return navigatorProvider.provideNavigator()
    }
}

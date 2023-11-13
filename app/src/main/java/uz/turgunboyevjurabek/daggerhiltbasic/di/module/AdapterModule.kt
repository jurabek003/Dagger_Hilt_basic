package uz.turgunboyevjurabek.daggerhiltbasic.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.turgunboyevjurabek.daggerhiltbasic.adapter.RvAdapter
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AdapterModule {


    @Singleton
    @Provides
    fun provideRvAdapter():RvAdapter{
        return RvAdapter()
    }

}
package uz.turgunboyevjurabek.daggerhiltbasic.repo

import uz.turgunboyevjurabek.daggerhiltbasic.network.ApiService
import javax.inject.Inject

class AppRepozitory @Inject constructor(private val apiService: ApiService){

    suspend fun getAllClients()=apiService.getAllClients()

}
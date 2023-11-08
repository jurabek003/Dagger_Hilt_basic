package uz.turgunboyevjurabek.daggerhiltbasic.network

import retrofit2.http.GET
import uz.turgunboyevjurabek.daggerhiltbasic.madels.ClientsGet

interface ApiService {

    @GET("clientlar/")
    suspend fun getAllClients():ArrayList<ClientsGet>
}
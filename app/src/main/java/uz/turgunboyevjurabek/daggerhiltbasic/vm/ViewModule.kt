package uz.turgunboyevjurabek.daggerhiltbasic.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import uz.turgunboyevjurabek.daggerhiltbasic.madels.ClientsGet
import uz.turgunboyevjurabek.daggerhiltbasic.repo.AppRepozitory
import uz.turgunboyevjurabek.daggerhiltbasic.utils.Recourse
import javax.inject.Inject

@HiltViewModel
class ViewModule @Inject constructor(val appRepozitory: AppRepozitory) :ViewModel() {
    private val getAllLiveData=MutableLiveData<Recourse<ArrayList<ClientsGet>>>()

    init {
        getAllClients()
    }

     fun getAllClients():MutableLiveData<Recourse<ArrayList<ClientsGet>>> {
        viewModelScope.launch {
            getAllLiveData.postValue(Recourse.loading("loading"))
            coroutineScope{
                withContext(Dispatchers.IO){
                    try {
                        val users=async {
                            appRepozitory.getAllClients()
                        }.await()
                        getAllLiveData.postValue(Recourse.success(users))
                    }catch (e:Exception){
                        getAllLiveData.postValue(Recourse.error(e.message))

                    }
                }
            }
        }
         return getAllLiveData
    }
}
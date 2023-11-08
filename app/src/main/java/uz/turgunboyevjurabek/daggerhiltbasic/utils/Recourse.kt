package uz.turgunboyevjurabek.daggerhiltbasic.utils

data class Recourse<out T>(val status: Status,val data:T?, val massage:String? ) {

    companion object{
        fun <T>success(data:T):Recourse<T>{
            return Recourse(Status.SUCCESS,data,null)
        }
        fun <T>error(massage: String?):Recourse<T>{
            return Recourse(Status.ERROR, null,massage)
        }

        fun <T>loading(loading:String):Recourse<T>{
            return Recourse(Status.LOADING,null,loading)
        }

    }


}
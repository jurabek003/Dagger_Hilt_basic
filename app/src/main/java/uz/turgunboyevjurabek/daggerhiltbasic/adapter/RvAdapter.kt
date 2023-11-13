package uz.turgunboyevjurabek.daggerhiltbasic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.turgunboyevjurabek.daggerhiltbasic.databinding.ItemRvBinding
import uz.turgunboyevjurabek.daggerhiltbasic.madels.ClientsGet

class RvAdapter:RecyclerView.Adapter<RvAdapter.Vh>() {
    private val list=ArrayList<ClientsGet>()
    inner class Vh(val itemRvBinding: ItemRvBinding):ViewHolder(itemRvBinding.root){
        fun onBind( clientsGet: ClientsGet){
            itemRvBinding.thtItem.text=clientsGet.ism.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
    fun upDateData( data:List<ClientsGet>){
        if (list.isNotEmpty()){
            list.clear()
        }
        list.addAll(data)
    }
}
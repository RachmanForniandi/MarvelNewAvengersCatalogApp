package rachman.forniandi.thenewavengerscatalogapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rachman.forniandi.marvelnewavengerscatalogapp.R
import rachman.forniandi.marvelnewavengerscatalogapp.databinding.ItemCarrouselBinding
import rachman.forniandi.thenewavengerscatalogapp.models.HeroMember

class CarrouselAdapter(private val data: ArrayList<HeroMember>, private var onClickListener: OnItemCarrouselClickListener): RecyclerView.Adapter<CarrouselAdapter.CarrouselHolder>() {

    class CarrouselHolder (itemView: ItemCarrouselBinding):RecyclerView.ViewHolder(itemView.root){
        val imgCarrousel = itemView.imgCarrousel
        val nameCarrousel = itemView.txtNameCarrousel

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarrouselHolder {
        return CarrouselHolder(ItemCarrouselBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CarrouselHolder, position: Int) {
        val item= data[position]
        val layoutParams = holder.itemView.layoutParams
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        holder.itemView.layoutParams = layoutParams
        holder.nameCarrousel.text = item.name
        holder.imgCarrousel.setImageResource(item.image ?: R.drawable.place_holder)

        holder.itemView.setOnClickListener {
            onClickListener.onClickItemCarrousel(position,item)
        }
    }

    interface OnItemCarrouselClickListener{
        fun onClickItemCarrousel(position: Int,hero:HeroMember)
    }
}
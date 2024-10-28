package rachman.forniandi.thenewavengerscatalogapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import rachman.forniandi.marvelnewavengerscatalogapp.R
import rachman.forniandi.marvelnewavengerscatalogapp.databinding.ItemMemberBinding
import rachman.forniandi.thenewavengerscatalogapp.models.HeroMember

class MemberAdapter(private val data: ArrayList<HeroMember>, private var onClickListener: OnItemClickListener?): RecyclerView.Adapter<MemberAdapter.MemberHolder>()  {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberHolder {
        return MemberHolder(ItemMemberBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MemberHolder, position: Int) {
        val item= data[position]
        holder.nameHero.text = item.name
        holder.realName.text = item.alias
        holder.imgHero.setImageResource(item.image ?: R.drawable.place_holder)
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position,item)
        }
    }

    inner class MemberHolder (itemView: ItemMemberBinding):RecyclerView.ViewHolder(itemView.root){
        val imgHero = itemView.imgHero
        val nameHero = itemView.tvNameMember
        val realName = itemView.tvAliasNameMember
    }


    interface OnItemClickListener{
        fun onClick(position: Int,hero:HeroMember)
    }
}
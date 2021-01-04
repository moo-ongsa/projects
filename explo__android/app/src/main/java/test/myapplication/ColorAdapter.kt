package test.myapplication

import android.content.Context
import android.graphics.Color.parseColor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_user.view.*

class ColorAdapter(private val list:ArrayList<Color>) : RecyclerView.Adapter<ColorHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user,parent,false)
        return ColorHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        holder.itemId.text = "ID : "+list[position].id.toString()
        holder.itemFN.text = "Name : "+list[position].name
        holder.itemLN.text = "Year : "+list[position].year
        holder.itemEmail.text = "Pantone value :"+list[position].pantone//list[position].color
        holder.itemImage.setBackgroundColor(android.graphics.Color.parseColor(list[position].color))
        Glide.with(holder.itemView.context).load("").into(holder.itemImage)
    }


}

 class ColorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemId = itemView.itemIDUser
    val itemEmail = itemView.itemEmailUser
    val itemFN = itemView.itemFNUser
    val itemLN = itemView.itemLNUser
    val itemImage = itemView.itemImageUser
}

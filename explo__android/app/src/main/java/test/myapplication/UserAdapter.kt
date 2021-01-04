package test.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_user.view.*

class UserAdapter(private val list:ArrayList<Users>) : RecyclerView.Adapter<UserHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_user,parent,false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.itemId.text = "ID : "+list[position].id.toString()
        holder.itemFN.text = "Firstname : "+list[position].firstName
        holder.itemLN.text = "Lastname : "+list[position].lastName
        holder.itemEmail.text = "Email :"+list[position].email
        holder.itemImage.setImageResource(R.mipmap.ic_launcher)
        Glide.with(holder.itemView.context).load(list[position].image).into(holder.itemImage)
    }


}
class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val itemId = itemView.itemIDUser
    val itemEmail = itemView.itemEmailUser
    val itemFN = itemView.itemFNUser
    val itemLN = itemView.itemLNUser
    val itemImage = itemView.itemImageUser
}

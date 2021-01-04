package test.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_create.view.*

class CreateAdapter(private val list: ArrayList<Create>) : RecyclerView.Adapter<CreateAdapter.UpdateHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdateHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_create,parent,false)
        return UpdateHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UpdateHolder, position: Int) {
        holder.itemCreateID.text = "ID : "+ list[position].id
        holder.itemCraeteName.text = "Name : "+ list[position].name
        holder.itemCreateJob.text = "Job : "+ list[position].job
        holder.itemCreateAt.text = "Created at : "+ list[position].CreateAt
    }
    inner class UpdateHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemCreateID = itemView.itemCreateID
        val itemCraeteName = itemView.itemCreateName
        val itemCreateJob = itemView.itemCreateJob
        val itemCreateAt = itemView.itemCreateAt
    }
}




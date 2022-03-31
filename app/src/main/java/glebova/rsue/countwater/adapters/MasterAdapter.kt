package glebova.rsue.countwater.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import glebova.rsue.countwater.databinding.ListsItemBinding
import glebova.rsue.countwater.models.MasterModel

class MasterAdapter(var lists: List<MasterModel>, private val callback: MasterAdapterCallBack) :
    RecyclerView.Adapter<MasterAdapter.MasterViewHolder>() {

        fun interface MasterAdapterCallBack {
            fun onClick()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MasterViewHolder = MasterViewHolder(
            ListsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun onBindViewHolder(holder: MasterViewHolder, position: Int) = holder.bind()

        override fun getItemCount(): Int = lists.size

        inner class MasterViewHolder(private val binding: ListsItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind() {
                binding.nameLists.text = lists.get(position).title
                binding.buttonMaster.setOnClickListener {
                    callback.onClick()
                }
            }
        }
    }
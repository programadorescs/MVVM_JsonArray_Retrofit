package pe.pcs.mvvm_jsonarray_retrofit.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.pcs.mvvm_jsonarray_retrofit.R
import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel
import pe.pcs.mvvm_jsonarray_retrofit.ui.interfaces.ClickItemListener
import pe.pcs.mvvm_jsonarray_retrofit.ui.viewholder.UsuarioViewHolder

class UsuarioAdapter(private val lista: List<UsuarioModel>, private val clickItemListener: ClickItemListener):
    RecyclerView.Adapter<UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        return UsuarioViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_usuario, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val entidad = lista[position]

        holder.enlazar(entidad)

        holder.itemView.setOnClickListener {
            clickItemListener.itemClick(entidad)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}
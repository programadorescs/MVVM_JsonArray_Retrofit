package pe.pcs.mvvm_jsonarray_retrofit.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel
import pe.pcs.mvvm_jsonarray_retrofit.databinding.ItemUsuarioBinding

class UsuarioViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemUsuarioBinding.bind(view)

    fun enlazar(entidad: UsuarioModel) {
        binding.tvNombre.text = entidad.name
        binding.tvEmail.text = entidad.email
        binding.tvTelefono.text = entidad.phone
    }
}
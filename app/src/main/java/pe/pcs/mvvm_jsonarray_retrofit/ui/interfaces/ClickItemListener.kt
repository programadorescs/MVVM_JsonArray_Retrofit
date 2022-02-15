package pe.pcs.mvvm_jsonarray_retrofit.ui.interfaces

import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel

interface ClickItemListener {
    fun itemClick(entidad: UsuarioModel)
}
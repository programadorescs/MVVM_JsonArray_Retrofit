package pe.pcs.mvvm_jsonarray_retrofit.data.repository

import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel
import pe.pcs.mvvm_jsonarray_retrofit.data.network.UsuarioService

class UsuarioRepository {

    private val api = UsuarioService()

    suspend fun getTodosLosUsuarios(): List<UsuarioModel> {

        // Aqui (api.getUsuarios()) esta la lista de Quotes [{},{},...]
        val response = api.getUsuarios()

        // Pasamos la lista al proveedor UsuarioResponse.usuarios que servira como base de datos local ;)
        //UsuarioResponse.usuarios = response

        // Retorna la lista
        return response
    }

}
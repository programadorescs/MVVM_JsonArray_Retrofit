package pe.pcs.mvvm_jsonarray_retrofit.data.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.pcs.mvvm_jsonarray_retrofit.core.RetrofitHelper
import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel

class UsuarioService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getUsuarios(): List<UsuarioModel> {

        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UsuarioApiService::class.java).getTodosUsuarios()
            response.body() ?: emptyList()
        }

    }

}
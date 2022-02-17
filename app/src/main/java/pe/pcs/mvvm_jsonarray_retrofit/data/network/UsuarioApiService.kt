package pe.pcs.mvvm_jsonarray_retrofit.data.network

import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel
import retrofit2.Response
import retrofit2.http.GET

interface UsuarioApiService {
    @GET("users")
    suspend fun getTodosUsuarios(): Response<List<UsuarioModel>> // Lee arrayJson [{},{},{}]
}
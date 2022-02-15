package pe.pcs.mvvm_jsonarray_retrofit.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pe.pcs.mvvm_jsonarray_retrofit.data.repository.UsuarioRepository
import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel

class HomeViewModel : ViewModel() {

    val listaUsuarioModel = MutableLiveData<List<UsuarioModel>>()
    private val _progressBar = MutableLiveData<Boolean>()
    var progressBar: LiveData<Boolean> = _progressBar

    // Metodo que llenara la lista (listaUsuarioModel)
    // con los datos que trae el metodo getWebService
    fun listarUsuario() {
        _progressBar.value = true

        viewModelScope.launch {
            listaUsuarioModel.value = UsuarioRepository().getTodosLosUsuarios()
        }
    }

}
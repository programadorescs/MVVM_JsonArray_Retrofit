package pe.pcs.mvvm_jsonarray_retrofit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import pe.pcs.mvvm_jsonarray_retrofit.databinding.FragmentDetalleUsuarioBinding
import pe.pcs.mvvm_jsonarray_retrofit.ui.viewmodel.HomeViewModel

class DetalleUsuarioFragment : Fragment() {

    private lateinit var binding : FragmentDetalleUsuarioBinding
    private lateinit var viewModel : HomeViewModel
    // inicializa el viewmodel a nivel de activity para ser compartido en multiples fragment o activity
    //private val viewModel : HomeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // requireActivity() es usado para compartir el viewmodel en multiples fragment o activity
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        // this usado para crear una nueva istancia del viewmodel por fragment o activity
        //viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        binding = FragmentDetalleUsuarioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // obervamos al itemUsuario que es un LiveData
        viewModel.itemUsuario.observe(viewLifecycleOwner, Observer {
            binding.tvNombre.text = "NOMBRE: ${it.name}"
            binding.tvNombreUsuario.text = "USUARIO: ${it.username}"
            binding.tvEmail.text = "EMAIL: ${it.email}"
            binding.tvCalle.text = "CALLE: ${it.address.street}"
            binding.tvSuite.text = "SUITE: ${it.address.suite}"
            binding.tvCiudad.text = "CUIDAD: ${it.address.city}"
            binding.tvZipcode.text = "ZIPCODE: ${it.address.zipcode}"
            binding.tvLatitud.text = "LATITUD: ${it.address.geo.lat.toString()}"
            binding.tvLongitud.text = "LONGITUD: ${it.address.geo.lng.toString()}"
            binding.tvTelefono.text = "TELEFONO: ${it.phone}"
            binding.tvWebsite.text = "SITIO WEB: ${it.website}"
            binding.tvNombreCompania.text = "COMPAÑIA: ${it.company.name}"
            binding.tvCatchPhrase.text = "ESLOGAN: ${it.company.catchPhrase}"
            binding.tvBs.text = "BS: ${it.company.bs}"
        })
    }
}
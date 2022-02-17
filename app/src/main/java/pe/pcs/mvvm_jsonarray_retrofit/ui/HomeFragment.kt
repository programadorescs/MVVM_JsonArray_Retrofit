package pe.pcs.mvvm_jsonarray_retrofit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import pe.pcs.mvvm_jsonarray_retrofit.R
import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel
import pe.pcs.mvvm_jsonarray_retrofit.databinding.FragmentHomeBinding
import pe.pcs.mvvm_jsonarray_retrofit.ui.adapter.UsuarioAdapter
import pe.pcs.mvvm_jsonarray_retrofit.ui.interfaces.ClickItemListener
import pe.pcs.mvvm_jsonarray_retrofit.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment(), ClickItemListener {

    private var _binding: FragmentHomeBinding? = null
    lateinit var viewModel: HomeViewModel
    // inicializa el viewmodel a nivel de activity para ser compartido en multiples fragment o activity
    //private val viewModel : HomeViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // requireActivity() es usado para compartir el viewmodel en multiples fragment o activity
        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
        // this usado para crear una nueva istancia del viewmodel por fragment o activity
        //viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        // Recyclerview
        binding.rvLista.layoutManager = LinearLayoutManager(context)

        // Creamos el observador de la listaUsuarioModel
        viewModel.listaUsuarioModel.observe(viewLifecycleOwner, Observer {
            // Pasamos el adaptador al recyclerview
            binding.rvLista.adapter = UsuarioAdapter(it, this)
            // Una vez cargado la info, oculta el progressBar
            binding.progressBar.isInvisible = true
        })

        // Creamos el observador del progressBar
        viewModel.progressBar.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = it
        })

        viewModel.listarUsuario()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun itemClick(entidad: UsuarioModel) {
        viewModel.setItemUsuario(entidad)

        Navigation.findNavController(requireView()).navigate(R.id.action_nav_home_to_detalleUsuarioFragment)
    }
}
package pe.pcs.mvvm_jsonarray_retrofit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pe.pcs.mvvm_jsonarray_retrofit.data.model.UsuarioModel
import pe.pcs.mvvm_jsonarray_retrofit.databinding.FragmentHomeBinding
import pe.pcs.mvvm_jsonarray_retrofit.ui.adapter.UsuarioAdapter
import pe.pcs.mvvm_jsonarray_retrofit.ui.interfaces.ClickItemListener
import pe.pcs.mvvm_jsonarray_retrofit.ui.viewmodel.HomeViewModel

class HomeFragment : Fragment(), ClickItemListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

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
        Toast.makeText(requireContext(), entidad.address.city.toString(), Toast.LENGTH_LONG).show()
    }
}
package com.androiddgsa.ejercicio_1_bmr.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.semantics.text
import androidx.fragment.app.Fragment
import com.androiddgsa.ejercicio_1_bmr.data.ReservaData
import com.androiddgsa.ejercicio_1_bmr.databinding.FragmentReservaBinding

class ReservaFragment : Fragment() {

    private lateinit var binding: FragmentReservaBinding

    companion object {
        private const val ARG_RESERVA_DATA = "reserva_data"

        fun newInstance(reservaData: ReservaData): ReservaFragment {
            val fragment = ReservaFragment()
            val args = Bundle()
            args.putParcelable(ARG_RESERVA_DATA, reservaData)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentReservaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reservaData = arguments?.getParcelable<ReservaData>(ARG_RESERVA_DATA)
        if (reservaData != null) {
            binding.tvNombres.text = reservaData.nombres
            binding.tvApellidos.text = reservaData.apellidos
            binding.tvEmail.text = reservaData.email
            binding.tvOrigen.text = reservaData.origen
            binding.tvDestino.text = reservaData.destino
            binding.tvFechaSalida.text = reservaData.fechaSalida
            binding.tvFechaRegreso.text = reservaData.fechaRegreso
        }
    }
}
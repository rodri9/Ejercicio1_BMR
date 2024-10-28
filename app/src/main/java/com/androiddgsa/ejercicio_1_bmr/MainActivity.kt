package com.androiddgsa.ejercicio_1_bmr

import android.os.Bundle
import android.text.Editable
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androiddgsa.ejercicio_1_bmr.databinding.ActivityMainBinding
import android.text.TextWatcher
import android.util.Patterns
import androidx.core.view.isEmpty
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        nameFocusListener()
        apellidoFocusListener()
        emailFocusListener()
        origenFocusListener()
        destinoFocusListener()
        salidaFocusListener()

        val opciones_destinos = resources.getStringArray(R.array.opciones_destinos)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, opciones_destinos)
        binding.acDestino.setAdapter(arrayAdapter)

        val tf_Salida = binding.etSalida
        tf_Salida.setOnClickListener {
            showDatePickerDialog()
        }

        val tf_Regreso = binding.etRegreso
        tf_Regreso.setOnClickListener {
            showDatePickerDialogRegreso()
        }

        binding.bttnReservar.setOnClickListener {
            hacerReserva()
        }

    }

    private fun checkRequiredFields(): Boolean {
        val validName = binding.tfNombres.helperText == null
        val validApellido = binding.tfApellidos.helperText == null
        val validEmail = binding.tfEmail.helperText == null

        if (validName && validApellido && validEmail) {
            return true
        } else {
            return false
        }
    }

    private fun hacerReserva() {
        if (checkRequiredFields()) Toast.makeText(this, "AAAAA", Toast.LENGTH_LONG).show()
        else Toast.makeText(this, "NOOOOO", Toast.LENGTH_LONG).show()
    }

    private fun nameFocusListener() {
        binding.etNombres.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tfNombres.helperText = validName()
            }
        }
    }

    private fun validName(): String? {
        val nameText = binding.etNombres.text.toString()
        if ( nameText.isEmpty() ) {
            return getString(R.string.requerido)
        }
        return null
    }

    private fun validApellido(): String? {
        val apellidoText = binding.etApellidos.text.toString()
        if ( apellidoText.isEmpty() ) {
            return getString(R.string.requerido)
        }
        return null
    }

    private fun apellidoFocusListener() {
        binding.etApellidos.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tfApellidos.helperText = validApellido()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.etEmail.text.toString()
        if ( !Patterns.EMAIL_ADDRESS.matcher(emailText).matches() ) {
            return "Email Inválido"
        }
        return null
    }

    private fun emailFocusListener() {
        binding.etEmail.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tfEmail.helperText = validEmail()
            }
        }
    }

    private fun validOrigen(): String? {
        val origenText = binding.etOrigen.text.toString()
        if ( origenText.isEmpty() ) {
            return getString(R.string.requerido)
        }
        return null
    }

    private fun origenFocusListener() {
        binding.etOrigen.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tfOrigen.helperText = validOrigen()
            }
        }
    }

    private fun validDestino(): String? {
        val destinoText = binding.acDestino.text.toString()
        if ( destinoText.isEmpty() ) {
            return getString(R.string.requerido)
        }
        return null
    }

    private fun destinoFocusListener() {
        binding.acDestino.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tfDestino.helperText = validDestino()
            }
        }
    }

    private fun validSalida(): String? {
        val salidaText = binding.etSalida.text.toString()
        if ( salidaText.isEmpty() ) {
            return getString(R.string.requerido)
        }
        return null
    }

    private fun salidaFocusListener() {
        binding.etSalida.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.tfSalida.helperText = validSalida()
            }
        }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment{ day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelected(day: Int, month: Int, year: Int) {
        val selectedDate = day.toString() + '/' + (month + 1) + '/' + year
        binding.etSalida.setText(selectedDate)
    }

    private fun showDatePickerDialogRegreso() {
        val datePicker = DatePickerFragmentRegreso{ day, month, year -> onDateSelectedRegreso(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    private fun onDateSelectedRegreso(day: Int, month: Int, year: Int) {
        val selectedDate = day.toString() + '/' + (month + 1) + '/' + year
        binding.etRegreso.setText(selectedDate)
    }
}
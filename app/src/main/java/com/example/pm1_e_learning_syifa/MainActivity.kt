package com.example.pm1_e_learning_syifa

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private lateinit var etPhone: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnPickDate: Button
    private lateinit var btnShowAlert: Button
    private lateinit var btnShowToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etPhone = findViewById(R.id.etPhone)
        tvResult = findViewById(R.id.tvResult)
        btnPickDate = findViewById(R.id.btnPickDate)
        btnShowAlert = findViewById(R.id.btnShowAlert)
        btnShowToast = findViewById(R.id.btnShowToast)

        // Tampilkan DatePicker
        btnPickDate.setOnClickListener {
            showDatePicker()
        }

        // Tampilkan Alert
        btnShowAlert.setOnClickListener {
            showAlertDialog()
        }

        // Tampilkan Toast
        btnShowToast.setOnClickListener {
            val phone = etPhone.text.toString()
            if (phone.isNotBlank()) {
                Toast.makeText(this, getString(R.string.toast_phone, phone), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, getString(R.string.toast_enter_phone), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${month + 1}/$year"
                tvResult.text = getString(R.string.label_selected_date, selectedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(getString(R.string.alert_title))
        builder.setMessage(getString(R.string.alert_message))
        builder.setPositiveButton(getString(R.string.alert_yes)) { _, _ ->
            Toast.makeText(this, getString(R.string.toast_yes), Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton(getString(R.string.alert_no)) { _, _ ->
            Toast.makeText(this, getString(R.string.toast_no), Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }
}


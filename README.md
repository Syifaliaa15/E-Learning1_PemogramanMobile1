# Penjelasan Fitur Aplikasi

## 1. DateTime (Pemilih Tanggal)

Fungsi untuk memilih tanggal menggunakan `DatePickerDialog` telah diimplementasikan dalam method `showDatePicker()`. Berikut penjelasannya:

### Kode yang digunakan:

```kotlin
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
```
### penjelasan
<ul>DatePickerDialog: Sebuah dialog yang memungkinkan pengguna untuk memilih tanggal.
<li>o	Parameter pertama adalah konteks (this), yang merujuk ke aktivitas saat ini.</li>
<li>o	Parameter kedua adalah DatePickerDialog.OnDateSetListener, yang akan dipanggil ketika pengguna memilih tanggal.</li>
<li>o	calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), dan calendar.get(Calendar.DAY_OF_MONTH) digunakan untuk menetapkan nilai default berdasarkan tanggal saat ini.</li>
<li>Setelah pengguna memilih tanggal, tanggal yang dipilih akan ditampilkan di TextView (tvResult) dengan format dd/MM/yyyy</li>
</ul>


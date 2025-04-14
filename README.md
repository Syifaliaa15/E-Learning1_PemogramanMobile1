# Penjelasan Projek E-Learning Input Control

## 1. DateTime (Pemilih Tanggal)
Fungsi untuk memilih tanggal menggunakan DatePickerDialog telah diimplementasikan dalam method `showDatePicker()`. Berikut penjelasannya:

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

### Penjelasan:
<p>a. DatePickerDialog: Sebuah dialog yang memungkinkan pengguna untuk memilih tanggal.
b. Parameter pertama adalah konteks (this), yang merujuk ke aktivitas saat ini.
c. Parameter kedua adalah DatePickerDialog.OnDateSetListener, yang akan dipanggil ketika pengguna memilih tanggal.
d. calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), dan calendar.get(Calendar.DAY_OF_MONTH) digunakan untuk menetapkan nilai default berdasarkan tanggal saat ini.
e. Setelah pengguna memilih tanggal, tanggal yang dipilih akan ditampilkan di TextView (tvResult) dengan format dd/MM/yyyy.</p>


## 2. Alert (Dialog Konfirmasi)
Fungsi untuk menampilkan dialog konfirmasi menggunakan AlertDialog.Builder. Dialog ini memiliki dua tombol: "Yes" dan "No".

### Kode yang digunakan:

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

### Penjelasan:
a. AlertDialog.Builder: Digunakan untuk membangun dan menampilkan dialog konfirmasi.
b. setTitle(): Menetapkan judul dialog.
c. setMessage(): Menetapkan pesan dalam dialog.
d. setPositiveButton() dan setNegativeButton(): Menetapkan dua tombol di dialog (Yes dan No). Masing-masing tombol memiliki aksi yang akan dilakukan ketika diklik. Dalam hal ini, sebuah Toast ditampilkan sebagai umpan balik, sesuai dengan pilihan pengguna.
e. builder.show(): Menampilkan dialog di layar.


## 3. Toast (Pesan Singkat)
Fungsi untuk menampilkan pesan singkat menggunakan Toast agar memberi umpan balik kepada pengguna.

### Kode yang digunakan:

btnShowToast.setOnClickListener {
    val phone = etPhone.text.toString()
    if (phone.isNotBlank()) {
        Toast.makeText(this, getString(R.string.toast_phone, phone), Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(this, getString(R.string.toast_enter_phone), Toast.LENGTH_SHORT).show()
    }
}

### Penjelasan:
a. Toast.makeText(): Membuat dan menampilkan pesan Toast.
b. Parameter pertama adalah konteks (this), yang merujuk ke aktivitas saat ini.
c. Parameter kedua adalah pesan yang akan ditampilkan.
d. Parameter ketiga adalah durasi tampilnya toast, yang dalam hal ini adalah Toast.LENGTH_SHORT (durasi singkat).
e. Di dalam kode ini, aplikasi memeriksa apakah input nomor telepon kosong atau tidak. Jika tidak kosong, aplikasi akan menampilkan toast dengan nomor telepon yang dimasukkan. Jika kosong, aplikasi akan menampilkan pesan yang meminta pengguna untuk mengisi nomor telepon.


## 4. Input Nomor Telepon
Fungsi untuk mengizinkan pengguna memasukkan nomor telepon di dalam EditText dan menampilkan nomor yang dimasukkan dalam sebuah Toast.

### Kode yang digunakan:

etPhone = findViewById(R.id.etPhone)
btnShowToast.setOnClickListener {
    val phone = etPhone.text.toString()
    if (phone.isNotBlank()) {
        Toast.makeText(this, getString(R.string.toast_phone, phone), Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(this, getString(R.string.toast_enter_phone), Toast.LENGTH_SHORT).show()
    }
}

### Penjelasan:
a. findViewById(R.id.etPhone): Menghubungkan EditText dengan kode, sehingga pengguna dapat memasukkan nomor telepon.
b. etPhone.text.toString(): Mengambil teks yang dimasukkan di EditText sebagai string.
c. if (phone.isNotBlank()): Mengecek apakah pengguna telah memasukkan nomor telepon atau tidak.
d. Jika nomor telepon ada, aplikasi menampilkan Toast yang menunjukkan nomor telepon yang dimasukkan.
e. Jika nomor telepon kosong, aplikasi menampilkan Toast yang meminta pengguna untuk memasukkan nomor telepon.


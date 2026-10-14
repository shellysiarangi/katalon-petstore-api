# Katalon Petstore API

Project otomasi pengujian **API** menggunakan **Katalon Studio** untuk
[Swagger Petstore](https://petstore.swagger.io/) (endpoint **Pet**).

---

## 📋 Deskripsi Project

Project ini menguji empat endpoint Pet dengan skenario positif dan negatif, ditambah satu alur
end-to-end (E2E). Data uji dibuat dinamis (ID pet acak) dan semua nilai konfigurasi dibaca dari Global Variable.

* **Target API** : https://petstore.swagger.io (base path `/v2`)
* **Tools** : Katalon Studio 10.4.3 (Web Service)
* **Bahasa** : Groovy

---

## 📂 Struktur Folder

| Folder | Isi |
| --- | --- |
| `Object Repository/API_Pet/` | Request `Post_pet`, `Put_Pet`, `Get_Pet`, `Delete_Pet` |
| `Object Repository/API_User/` | Request endpoint User (tambahan, tidak masuk Test Suite) |
| `Keywords/pet_store/` | Custom keyword: `Pet` (generate data dan assertion), `Post_Pet`, `Put_Pet`, `Get_Pet`, `Delete_Pet` |
| `Test Cases/` | 9 test case |
| `Test Suites/` | 5 test suite |
| `Profiles/default.glbl` | Global Variable |
| `Screenshoot/Pet/`, `Response/Pet/` | Bukti request dan response endpoint Pet |
| `Report-Sample/` | Contoh hasil eksekusi Test Suite (HTML, CSV, JUnit XML) |

---

## 🚀 Cara Menjalankan

> **Prasyarat:** Katalon Studio 10.x dan koneksi internet. Tidak perlu akun atau token karena Swagger Petstore bersifat publik.

1. Clone repository: git clone https://github.com/shellysiarangi/katalon-petstore-api.git
2. Buka Katalon Studio, pilih **File > Open Project**, lalu pilih `katalon-petstore-api.prj`.
3. Buka folder **Test Suites**, pilih satu Test Suite (mis. `e2e_Pet`).
4. Klik **Run**.
5. Hasil eksekusi muncul di folder **Reports** (otomatis dibuat Katalon, tidak di-commit).


## 🔑 Global Variable

Tidak ada data yang di-hardcode di test case. Variable ada di `Profiles/default.glbl`:

| Variable | Nilai / Fungsi |
| --- | --- |
| `base_url` | 'https://petstore.swagger.io' |
| `pet_id`, `pet_name`, `pet_name_update` | Diisi dinamis oleh keyword `generatePetData` (ID acak) |
| `pet_status`, `pet_status_update` | `available`, `sold` |
| `success`, `bad_input`, `not_found` | Status code yang diharapkan: 200, 400, 404 |
| `invalid_pet_id` | ID tidak valid untuk test negatif |
| `message_not_found`, `message_bad_input` | Pesan error yang diharapkan |

---

## 🧪 Test Suite

| Test Suite | Test Case |
| --- | --- |
| `Post_Pet` | `Post_Pet_Positif_TestCase`, `Post_Pet_Negatif_TestCase` |
| `Put_Pet` | `Put_Pet_Positif_TestCase`, `Put_Pet_Negatif_TestCase` |
| `Get_Pet` | `Get_Pet_Positif_TestCase`, `Get_Pet_Negatif_TestCase` |
| `Delete_Pet` | `Delete_Pet_Positif_TestCase`, `Delete_Pet_Negatif_TestCase` |
| `e2e_Pet` | `e2e_Pet` |

---

## 📊 Test Coverage

| Endpoint | Positif | Negatif |
| --- | --- | --- |
| `POST /v2/pet` | Buat pet baru: status 200, `id`, `name`, `status` sesuai | ID tidak valid: status 400, pesan `invalid input` |
| `PUT /v2/pet` | Update nama dan status pet: status 200, data hasil update sesuai | ID tidak valid: status 400, pesan `invalid input` |
| `GET /v2/pet/{petId}` | Ambil pet yang sudah dibuat: status 200, data sesuai | ID tidak ada: status 404, pesan `Pet not found` |
| `DELETE /v2/pet/{petId}` | Hapus pet: status 200, `message` berisi ID pet, GET setelahnya 404 | ID tidak ada: status 404 |

**E2E (`e2e_Pet`):** POST pet, GET (verifikasi data), PUT (update), GET (verifikasi update),
DELETE, lalu GET lagi dan pastikan 404 `Pet not found`.

Total: **9 test case**, **5 test suite**. Setiap pengecekan memakai assertion status code dan isi response.
Contoh report ada di folder `Report-Sample/`.

---

## 📝 Catatan

* Swagger Petstore adalah layanan publik bersama. Data bisa berubah atau dihapus pihak lain,
dan respon kadang lambat. Karena itu ID pet dibuat acak setiap eksekusi.
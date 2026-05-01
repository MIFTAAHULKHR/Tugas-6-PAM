# Tugas 6 - News Reader App (KMP)

Aplikasi pembaca berita sederhana yang dibangun menggunakan Kotlin Multiplatform (Android, iOS, Desktop).

## Fitur
- **Fetch API**: Mengambil berita terkini dari NewsAPI.
- **Daftar Berita**: Menampilkan list artikel dengan gambar, judul, dan deskripsi.
- **Detail Berita**: Menampilkan detail artikel saat item diklik.
- **Refresh**: Fitur untuk memperbarui daftar berita.
- **State Management**: Menangani kondisi Loading, Success, dan Error dengan rapi.

## API yang Digunakan
- **NewsAPI.org**
- **Endpoint**: `https://newsapi.org/v2/top-headlines`
- **Library**: 
  - Ktor (Network)
  - Kamel (Image Loading)
  - Kotlinx Serialization (JSON Parsing)

## Struktur Proyek
- `org.example.project.data`: Berisi model data, API service, dan Repository.
- `org.example.project.ui`: Berisi ViewModel untuk logika UI.
- `App.kt`: Entry point untuk tampilan utama dan navigasi.

---
*Catatan: Masukkan screenshot aplikasi Anda di sini setelah dijalankan.*

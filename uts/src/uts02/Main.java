package uts02;
 //nama alfonsius kino kesu
//kelas x


   import java.util.Scanner;

class Pencatatan {
    private final String[] catatan; // Array untuk menyimpan catatan
    private int count; // Jumlah catatan yang ada

    // Constructor
    public Pencatatan(int size) {
        catatan = new String[size]; // Inisialisasi array dengan ukuran tertentu
        count = 0; // Inisialisasi count
    }

    // Menambah catatan
    public void tambahCatatan(String catatanBaru) {
        if (count < catatan.length) {
            catatan[count] = catatanBaru; // Menyimpan catatan baru
            count++; // Meningkatkan jumlah catatan
            System.out.println("Catatan berhasil ditambahkan.");
        } else {
            System.out.println("Array penuh, tidak bisa menambah catatan.");
        }
    }

    // Menampilkan semua catatan
    public void tampilkanCatatan() {
        if (count == 0) {
            System.out.println("Tidak ada catatan.");
            return;
        }
        System.out.println("Daftar Catatan:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + catatan[i]); // Menampilkan catatan
        }
    }

    // Mengubah catatan
    public void ubahCatatan(int index, String catatanBaru) {
        if (index >= 0 && index < count) {
            catatan[index] = catatanBaru; // Mengubah catatan pada index tertentu
            System.out.println("Catatan berhasil diubah.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }

    // Menghapus catatan
    public void hapusCatatan(int index) {
        if (index >= 0 && index < count) {
            for (int i = index; i < count - 1; i++) {
                catatan[i] = catatan[i + 1]; // Menggeser catatan
            }
            catatan[count - 1] = null; // Menghapus referensi catatan terakhir
            count--; // Mengurangi jumlah catatan
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Pencatatan pencatatan = new Pencatatan(10); // Ukuran array 10
            int pilihan;
            
            do {
                System.out.println("\nMenu Aplikasi Pencatatan:");
                System.out.println("1. Tambah Catatan");
                System.out.println("2. Tampilkan Catatan");
                System.out.println("3. Ubah Catatan");
                System.out.println("4. Hapus Catatan");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline
                
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan catatan: ");
                        String catatanBaru = scanner.nextLine();
                        pencatatan.tambahCatatan(catatanBaru);
                        break;
                    case 2:
                        pencatatan.tampilkanCatatan();
                        break;
                    case 3:
                        System.out.print("Masukkan index catatan yang ingin diubah: ");
                        int indexUbah = scanner.nextInt() - 1; // Mengurangi 1 untuk index
                        scanner.nextLine(); // Membersihkan newline
                        System.out.print("Masukkan catatan baru: ");
                        String catatanBaruUbah = scanner.nextLine();
                        pencatatan.ubahCatatan(indexUbah, catatanBaruUbah);
                        break;
                    case 4:
                        System.out.print("Masukkan index catatan yang ingin dihapus: ");
                        int indexHapus = scanner.nextInt() - 1; // Mengurangi 1 untuk index
                        pencatatan.hapusCatatan(indexHapus);
                        break;
                    case 5:
                        System.out.println("Keluar dari aplikasi.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } while (pilihan != 5);
        } // Ukuran array 10
    }
}

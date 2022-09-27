package my_restaurant;

import java.util.Scanner;

public class Produk {

    // Atribut atau Properties
    private static byte id = 0;
    private String[] nama_produk;
    private long[] harga;
    private int[] jumlah;

    // Constructor Produk
    public Produk(int jml) {
        nama_produk = new String[jml];
        harga = new long[jml];
        jumlah = new int[jml];
    }

    // Getters & Setters
    public String[] get_nama_produk() {
        return nama_produk;
    }

    public void set_nama_produk(String[] nama_produk) {
        this.nama_produk = nama_produk;
    }

    public long[] get_harga() {
        return harga;
    }

    public void set_harga(long[] harga) {
        this.harga = harga;
    }

    public int[] get_jumlah() {
        return jumlah;
    }

    public void set_jumlah(int[] jumlah) {
        this.jumlah = jumlah;
    }

    public static byte get_id() {
        return id;
    }

    // Inisialisasi Produk Awal
    public void inisialisasi_produk() {
        tambah_produk("Nasi Ayam", 25000, 100);
        tambah_produk("Nasi Goreng", 15000, 100);
        tambah_produk("Coto Makassar", 32000, 100);
        tambah_produk("Soto Bandung", 25000, 100);
        tambah_produk("Ikan Goreng", 15000, 100);
        tambah_produk("Ayam Bakar", 22000, 100);
        tambah_produk("Bebek Goreng", 10000, 100);
        tambah_produk("Cappuccino Ice", 20000, 100);
        tambah_produk("Susu Soda", 10000, 100);
        tambah_produk("Milk Tea", 15000, 100);
    }

    // Menambah Produk Makanan
    public void tambah_produk(String nama, long harga, int jumlah) {
        this.nama_produk[id] = nama;
        this.harga[id] = harga;
        this.jumlah[id] = jumlah;
        id++;
    }

    // Menampilkan Semua Menu Makanan
    public void tampil_produk() {
        System.out.println("============================== Daftar Menu ==============================\n");
        for (int i = 0; i <= id; i++) {
            if (nama_produk[i] != null) {
                System.out.printf("%d. %-20s Harga: %-20d jumlah: %d \n", i + 1, this.nama_produk[i], this.harga[i], this.jumlah[i]);
            } else {
                System.out.println("");
            }
        }
        System.out.println("=========================================================================\n");
    }

    // Input Tambah Menu Baru
    public void tambah_produk() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Silahkan masukkan menu yang ingin ditambahkan");
        while (true) {
            System.out.print("Nama Produk: ");
            String nama_produk_temp = scan.nextLine();

            System.out.print("Harga: Rp");
            long harga_produk_temp = scan.nextLong();

            System.out.print("jumlah: ");
            int jumlah_produk_temp = scan.nextInt();

            boolean valid = is_produk_exist(nama_produk_temp);
            if (!valid) {
                tambah_produk(nama_produk_temp, harga_produk_temp, jumlah_produk_temp);
                System.out.println("Produk Berhasil Ditambahkan!\n");
            } else {
                System.out.println("Produk Sudah Terdaftar atau Produk Yang Anda Inputkan Kosong!\n");
            }

            System.out.print("Apakah kamu ingin menambah menu lagi? (Y/T)");
            char ulang = scan.next().charAt(0);
            ulang = Character.toUpperCase(ulang);
            if (ulang != 'Y') {
                System.out.println("");
                break;
            }
            System.out.println("");
            scan.nextLine();
        }
    }

    // Cek ada tidaknya produk
    public boolean is_produk_exist(String produk) {
        if (produk.isEmpty()) {
            return true;
        } else {
            for (int i = 0; i <= id; i++) {
                String s = nama_produk[i];
                if (nama_produk[i] != null) {
                    boolean is_produk_exist = s.equalsIgnoreCase(produk);
                    if (is_produk_exist == true) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

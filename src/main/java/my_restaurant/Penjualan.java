package my_restaurant;

import java.util.Scanner;

public class Penjualan {

    // Attributes
    private String[] nama_produk;
    private int[] jumlah;
    private long[] harga_satuan;
    private long[] sub_total;
    private long harga_total;

    // Getters & Setters
    public String[] get_nama_produk() {
        return nama_produk;
    }

    public void set_nama_produk(String[] nama_produk) {
        this.nama_produk = nama_produk;
    }

    public int[] get_jumlah() {
        return jumlah;
    }

    public void set_jumlah(int[] jumlah) {
        this.jumlah = jumlah;
    }

    public long[] get_harga_satuan() {
        return harga_satuan;
    }

    public void set_harga_satuan(long[] harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    public long[] get_sub_total() {
        return sub_total;
    }

    public void set_sub_total(long[] sub_total) {
        this.sub_total = sub_total;
    }

    public long get_harga_total() {
        return harga_total;
    }

    public void set_harga_total(long harga_total) {
        this.harga_total = harga_total;
    }

    // Constructor
    public Penjualan(int jml) {
        nama_produk = new String[jml];
        harga_satuan = new long[jml];
        jumlah = new int[jml];
        sub_total = new long[jml];
        harga_total = 0;
    }

    // Tambah Data Penjualan
    public void tambah_penjualan(Produk pd, int jumbel, byte pilihan, byte index) {
        byte id_order = this.cek_order(pd, pd.get_nama_produk()[pilihan]);
        if (id_order == -1) {
            this.nama_produk[index] = pd.get_nama_produk()[pilihan];
            this.harga_satuan[index] = pd.get_harga()[pilihan];
            this.jumlah[index] = jumbel;
            pd.get_jumlah()[pilihan] -= jumbel;
            this.sub_total[index] = this.jumlah[index] * this.harga_satuan[index];
            this.harga_total = 0;
            for (int i = 0; i < pd.get_id(); i++) {
                if (this.nama_produk[i] != null) {
                    this.harga_total += this.sub_total[i];
                }
            }
        } else {
            this.jumlah[id_order] += jumbel;
            pd.get_jumlah()[pilihan] -= jumbel;
            this.sub_total[index] = this.jumlah[index] * this.harga_satuan[index];
            this.harga_total = 0;
            for (int i = 0; i < pd.get_id(); i++) {
                if (this.nama_produk[i] != null) {
                    this.harga_total += this.sub_total[i];
                }
            }
        }
    }

    // Order Menu
    public void order_menu(Produk menu) {
        Scanner scan = new Scanner(System.in);
        byte index = 0;

        while (true) {
            System.out.println("Silahkan pilih menu yang ingin dibeli berdasarkan nomor");
            System.out.print("Pilihan: ");
            byte pilihan = scan.nextByte();
            System.out.print("Jumlah Beli: ");
            int jumbel = scan.nextInt();
            pilihan -= 1;
            System.out.println("");

            if (pilihan < menu.get_id() && pilihan >= 0) {
                if (jumbel > 0 && jumbel <= menu.get_jumlah()[pilihan]) {
                    tambah_penjualan(menu, jumbel, pilihan, index);
                    index ++;
                } else {
                    System.out.println("Jumlah Beli tidak valid!\n");
                }
            } else {
                System.out.println("Pilihan tidak valid!\n");
            }

            System.out.print("Apakah kamu ingin memesan menu lainnya? (Y/T)");
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

    // Menampilkan Order
    public void tampil_order(Produk menu) {
        System.out.println("========================================== Rekap Penjualan ==========================================\n");
        for (int i = 0; i < menu.get_id(); i++) {
            if (this.get_nama_produk()[i] != null) {
                System.out.printf("%d. %-20s Harga: Rp%-20d Jumlah: %-20d SubTotal: Rp%-20d\n", i + 1, this.nama_produk[i], this.harga_satuan[i], this.jumlah[i], this.sub_total[i]);
            }
        }
        System.out.println("\nTotal Order: Rp" + this.harga_total + ",00\n");
        System.out.println("====================================================================================================\n");
    }

    // Membayar Order
    public void bayar_order() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Silahkan masukkan sejumlah uang untuk membayar pesanan!");
        while (true) {
            System.out.print("Jumlah uang: Rp");
            long uang = scan.nextInt();

            if (uang >= this.harga_total) {
                System.out.println("\nPembayaran berhasil, terima kasih!\n");
                break;
            } else {
                System.out.println("\nJumlah uang tidak cukup, silahkan masukkan jumlah uang dengan benar!\n");
            }
        }
    }

    // Cek ada tidaknya barang pada daftar order, jika ada return ID barang tersebut
    public byte cek_order(Produk menu, String produk) {
        for (byte i = 0; i < menu.get_id(); i++) {
            String s = nama_produk[i];
            if (nama_produk[i] != null) {
                boolean is_produk_exist = s.equalsIgnoreCase(produk);
                if (is_produk_exist == true) {
                    return i;
                }
            }
        }
        return -1;
    }
}

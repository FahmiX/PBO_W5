package my_restaurant;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Produk menu = new Produk(50);
        Penjualan jual = new Penjualan(50);
        Scanner scan = new Scanner(System.in);

        // Inisialisasi Produk Awal
        menu.inisialisasi_produk();
       
        while (true) {
            menu.tampil_produk(); 
            System.out.println("Silahkan pilih fitur yang akan digunakan: ");
            System.out.println("1. Tambah Menu");
            System.out.println("2. Order Menu");
            System.out.println("3. Exit\n");
            System.out.print("Pilihan: ");
            byte pilihan = scan.nextByte();
            System.out.println("");
            switch (pilihan) {
                case 1:
                    menu.tambah_produk();
                    break;
                case 2:
                    jual.order_menu(menu);
                    jual.tampil_order(menu);
                    jual.bayar_order();
                    break;
                case 3:
                    System.out.print("Keluar dari program!");
                    System.exit(0);
            }
        }
    }
}

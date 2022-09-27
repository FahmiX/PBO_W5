package W5;

import java.util.Scanner;

public class Restaurant {
    
    // Attributes
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;
    
    // Setter & Getter
    public String[] getNama_makanan() {
        return nama_makanan;
    }

    public void setNama_makanan(String[] nama_makanan) {
        this.nama_makanan = nama_makanan;
    }

    public double[] getHarga_makanan() {
        return harga_makanan;
    }

    public void setHarga_makanan(double[] harga_makanan) {
        this.harga_makanan = harga_makanan;
    }

    public int[] getStok() {
        return stok;
    }

    public void setStok(int[] stok) {
        this.stok = stok;
    }

    public static byte getId() {
        return id;
    }

    // Initialize Data 
    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int [10];
    }
    
    public void tambahMenuMakanan(String nama, double harga, int stok){
        this.getNama_makanan()[getId()] = nama;
        this.getHarga_makanan()[getId()] = harga;
        this.getStok()[getId()] = stok;
    }
    
    public void tampilMenuMakanan(){
        for(int i = 0; i <= getId(); i++){
            if(!isOutOfStock(i)){
                System.out.println(i+1 + ". " + getNama_makanan()[i] + "["+getStok()[i]+"]" + "\tRp. "+getHarga_makanan()[i]);
            }
        }
    }
    
    public boolean isOutOfStock(int id){
        if(getStok()[getId()] == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public static void nextId(){
        id ++;
    }
    
    public void updateStok(byte Id, int jumlahBeli){
        this.getStok() [Id-1] -= jumlahBeli;
    }
    
    public void orderMakanan(byte Id, int jumlahBeli){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Silahkan Pesan Makanan Berdasarkan Nomor.");
        System.out.print("Pilihan: ");
        Id = scan.nextByte();
        System.out.print("Jumlah Beli: ");
        jumlahBeli = scan.nextInt();
        
        updateStok(Id, jumlahBeli);
    }
}

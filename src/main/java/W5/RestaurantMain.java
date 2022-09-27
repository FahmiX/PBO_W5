package W5;

public class RestaurantMain {

    public static void main(String[] args) {
        byte pilihan = 0;
        int jumlahBeli = 0;

        Restaurant menu = new Restaurant();
        menu.tambahMenuMakanan("Bala-Bala", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Gehu", 1_000, 20);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Tahu", 1_000, 0);
        Restaurant.nextId();
        menu.tambahMenuMakanan("Molen", 1_000, 20);

        System.out.println("\n===== Menu Kondisi Awal =====\n");
        menu.tampilMenuMakanan();

        System.out.println("");
        menu.orderMakanan(pilihan, jumlahBeli);

        System.out.println("\n===== Menu Sesudah Order =====\n");
        menu.tampilMenuMakanan();
    }
}

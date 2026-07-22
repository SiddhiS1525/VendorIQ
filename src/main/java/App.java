import ui.VendorUI;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VendorUI vendorUI = new VendorUI();

        while (true) {

            System.out.println("\n========== VendorIQ ==========");
            System.out.println("1. Add Vendor");
            System.out.println("2. View All Vendors");
            System.out.println("0. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    vendorUI.addVendor();
                    break;

                case 2:
                    vendorUI.viewAllVendors();
                    break;

                case 0:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
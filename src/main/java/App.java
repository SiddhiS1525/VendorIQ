import ui.ProductUI;
import ui.PurchaseOrderUI;
import ui.VendorUI;
import ui.InvoiceUI;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VendorUI vendorUI = new VendorUI();
        ProductUI productUI = new ProductUI();
        PurchaseOrderUI purchaseOrderUI = new PurchaseOrderUI();
        InvoiceUI invoiceUI = new InvoiceUI();

        while (true) {

            System.out.println("\n========== VendorIQ ==========");
            System.out.println("1. Vendor Module");
            System.out.println("2. Product Module");
            System.out.println("3. Purchase Order Module");
            System.out.println("4. Invoice Module");
            System.out.println("0. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= Vendor Module =================
                case 1:

                    while (true) {

                        System.out.println("\n====== Vendor Module ======");
                        System.out.println("1. Add Vendor");
                        System.out.println("2. View All Vendors");
                        System.out.println("0. Back");
                        System.out.print("Enter Choice : ");

                        int vendorChoice = sc.nextInt();
                        sc.nextLine();

                        switch (vendorChoice) {

                            case 1:
                                vendorUI.addVendor();
                                break;

                            case 2:
                                vendorUI.viewAllVendors();
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Invalid Choice!");
                        }

                        if (vendorChoice == 0)
                            break;
                    }

                    break;

                // ================= Product Module =================
                case 2:

                    while (true) {

                        System.out.println("\n====== Product Module ======");
                        System.out.println("1. Add Product");
                        System.out.println("2. View All Products");
                        System.out.println("3. Search Product");
                        System.out.println("4. Update Product");
                        System.out.println("5. Delete Product");
                        System.out.println("6. Increase Stock");
                        System.out.println("7. Decrease Stock");
                        System.out.println("8. Check Stock");
                        System.out.println("0. Back");
                        System.out.print("Enter Choice : ");

                        int productChoice = sc.nextInt();
                        sc.nextLine();

                        switch (productChoice) {

                            case 1:
                                productUI.addProduct();
                                break;

                            case 2:
                                productUI.viewAllProducts();
                                break;

                            case 3:
                                productUI.searchProduct();
                                break;

                            case 4:
                                productUI.updateProduct();
                                break;

                            case 5:
                                productUI.deleteProduct();
                                break;

                            case 6:
                                productUI.increaseStock();
                                break;

                            case 7:
                                productUI.decreaseStock();
                                break;

                            case 8:
                                productUI.checkStock();
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Invalid Choice!");
                        }

                        if (productChoice == 0)
                            break;
                    }

                    break;

                // ================= Purchase Order Module =================
                case 3:

                    while (true) {

                        System.out.println("\n====== Purchase Order Module ======");
                        System.out.println("1. Create Purchase Order");
                        System.out.println("2. View Purchase Orders");
                        System.out.println("3. Update Status");
                        System.out.println("0. Back");
                        System.out.print("Enter Choice : ");

                        int orderChoice = sc.nextInt();
                        sc.nextLine();

                        switch (orderChoice) {

                            case 1:
                                purchaseOrderUI.addOrder();
                                break;

                            case 2:
                                purchaseOrderUI.viewOrders();
                                break;

                            case 3:
                                purchaseOrderUI.updateStatus();
                                break;

                            case 0:
                                break;

                            default:
                                System.out.println("Invalid Choice!");
                        }

                        if (orderChoice == 0)
                            break;
                    }

                    break;

                // ================= Exit =================
                case 4:

    while (true) {

        System.out.println("\n====== Invoice Module ======");
        System.out.println("1. Create Invoice");
        System.out.println("2. View All Invoices");
        System.out.println("0. Back");
        System.out.print("Enter Choice : ");

        int invoiceChoice = sc.nextInt();
        sc.nextLine();

        switch (invoiceChoice) {

            case 1:
                invoiceUI.createInvoice();
                break;

            case 2:
                invoiceUI.viewInvoices();
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid Choice!");
        }

        if (invoiceChoice == 0)
            break;
    }

    break;
                case 0:
                    System.out.println("\nThank You for using VendorIQ!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
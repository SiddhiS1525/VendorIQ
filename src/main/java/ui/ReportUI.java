package ui;

import dao.ReportDAO;

import java.util.Scanner;

public class ReportUI {

    Scanner sc = new Scanner(System.in);

    ReportDAO reportDAO = new ReportDAO();

    public void showReportsMenu() {

        while (true) {

            System.out.println("\n========== Reports Module ==========");
            System.out.println("1. Vendor Report");
            System.out.println("2. Product Report");
            System.out.println("3. Purchase Order Report");
            System.out.println("4. Invoice Report");
            System.out.println("5. Payment Report");
            System.out.println("0. Back");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    reportDAO.vendorReport();
                    break;

                case 2:
                    reportDAO.productReport();
                    break;

                case 3:
                    reportDAO.purchaseOrderReport();
                    break;

                case 4:
                    reportDAO.invoiceReport();
                    break;

                case 5:
                    reportDAO.paymentReport();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
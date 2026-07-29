package ui;

import dao.AnalyticsDAO;
import java.util.Scanner;

public class AnalyticsUI {

    private Scanner sc = new Scanner(System.in);
    private AnalyticsDAO analyticsDAO = new AnalyticsDAO();

    public void showAnalyticsMenu() {

        while (true) {

            System.out.println("\n========== Analytics Module ==========");
            System.out.println("1. Top Rated Vendors");
            System.out.println("2. Low Rated Vendors");
            System.out.println("3. Low Stock Products");
            System.out.println("4. Revenue Summary");
            System.out.println("0. Back");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    analyticsDAO.topRatedVendors();
                    break;

                case 2:
                    analyticsDAO.lowRatedVendors();
                    break;

                case 3:
                    analyticsDAO.lowStockProducts();
                    break;

                case 4:
                    analyticsDAO.revenueSummary();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
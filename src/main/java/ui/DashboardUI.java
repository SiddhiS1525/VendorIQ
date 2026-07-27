package ui;

import dao.DashboardDAO;

public class DashboardUI {

    DashboardDAO dashboardDAO = new DashboardDAO();

    public void showDashboard() {

        System.out.println("\n========================================");
        System.out.println("         VendorIQ Dashboard");
        System.out.println("========================================");

        System.out.println("Total Vendors          : " + dashboardDAO.getTotalVendors());
        System.out.println("Total Products         : " + dashboardDAO.getTotalProducts());
        System.out.println("Total Purchase Orders  : " + dashboardDAO.getTotalPurchaseOrders());
        System.out.println("Total Invoices         : " + dashboardDAO.getTotalInvoices());
        System.out.println("Total Payments         : " + dashboardDAO.getTotalPayments());

        System.out.println("========================================");
    }
}
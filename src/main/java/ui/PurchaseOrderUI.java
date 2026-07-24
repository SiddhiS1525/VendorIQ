package ui;

import dao.PurchaseOrderDAO;
import model.PurchaseOrder;

import java.util.Scanner;

public class PurchaseOrderUI {

    Scanner sc = new Scanner(System.in);

    PurchaseOrderDAO orderDAO = new PurchaseOrderDAO();

    // Create Purchase Order
    public void addOrder() {

        PurchaseOrder order = new PurchaseOrder();

        System.out.println("\n===== Create Purchase Order =====");

        System.out.print("Vendor ID : ");
        order.setVendorId(sc.nextInt());

        System.out.print("Total Amount : ");
        order.setTotalAmount(sc.nextDouble());
        sc.nextLine();

        System.out.print("Order Date (YYYY-MM-DD) : ");
        order.setOrderDate(sc.nextLine());

        System.out.print("Status : ");
        order.setStatus(sc.nextLine());

        if (orderDAO.addOrder(order)) {
            System.out.println("\n✅ Purchase Order Created Successfully!");
        } else {
            System.out.println("\n❌ Failed to Create Purchase Order!");
        }
    }

    // View Purchase Orders
    public void viewOrders() {

        orderDAO.viewAllOrders();

    }

    // Update Status
    public void updateStatus() {

        System.out.print("Enter PO ID : ");
        int poId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Status : ");
        String status = sc.nextLine();

        if (orderDAO.updateStatus(poId, status)) {
            System.out.println("\n✅ Status Updated Successfully!");
        } else {
            System.out.println("\n❌ Failed to Update Status!");
        }
    }
}
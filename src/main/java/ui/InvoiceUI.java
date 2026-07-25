package ui;

import dao.InvoiceDAO;
import model.Invoice;

import java.util.Scanner;

public class InvoiceUI {

    Scanner sc = new Scanner(System.in);

    InvoiceDAO invoiceDAO = new InvoiceDAO();

    // Create Invoice
    public void createInvoice() {

        Invoice invoice = new Invoice();

        System.out.println("\n===== Create Invoice =====");

        System.out.print("Purchase Order ID : ");
        invoice.setPurchaseOrderId(sc.nextInt());

        System.out.print("Invoice Amount : ");
        invoice.setTotalAmount(sc.nextDouble());
        sc.nextLine();

        System.out.print("Invoice Date (YYYY-MM-DD) : ");
        invoice.setInvoiceDate(sc.nextLine());

        System.out.print("Status : ");
        invoice.setStatus(sc.nextLine());

        if (invoiceDAO.createInvoice(invoice)) {
            System.out.println("\n✅ Invoice Created Successfully!");
        } else {
            System.out.println("\n❌ Failed to Create Invoice!");
        }
    }

    // View All Invoices
    public void viewInvoices() {

        invoiceDAO.viewAllInvoices();

    }
}
package ui;

import dao.PaymentDAO;
import model.Payment;

import java.sql.Date;
import java.util.Scanner;

public class PaymentUI {

    Scanner sc = new Scanner(System.in);

    PaymentDAO paymentDAO = new PaymentDAO();

    // Record Payment
    public void recordPayment() {

        Payment payment = new Payment();

        System.out.println("\n===== Record Payment =====");

        // Invoice ID
        System.out.print("Invoice ID : ");
        int invoiceId = sc.nextInt();
        sc.nextLine();

        if (invoiceId <= 0) {
            System.out.println("❌ Invalid Invoice ID!");
            return;
        }
        payment.setInvoiceId(invoiceId);

        // Amount
        System.out.print("Amount : ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (amount <= 0) {
            System.out.println("❌ Amount must be greater than 0!");
            return;
        }
        payment.setAmount(amount);

        // Payment Date
        System.out.print("Payment Date (YYYY-MM-DD) : ");
        String paymentDate = sc.nextLine();

        try {
            Date.valueOf(paymentDate);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid Date! Use YYYY-MM-DD format.");
            return;
        }

        payment.setPaymentDate(paymentDate);

        // Payment Mode
        System.out.print("Payment Mode (Cash/UPI/Bank Transfer/Cheque) : ");
        String paymentMode = sc.nextLine();

        if (paymentMode.trim().isEmpty()) {
            System.out.println("❌ Payment Mode cannot be empty!");
            return;
        }

        payment.setPaymentMethod(paymentMode);

        // Payment Status
        System.out.print("Status (Pending/Completed/Failed) : ");
        String status = sc.nextLine();

        if (status.trim().isEmpty()) {
            System.out.println("❌ Status cannot be empty!");
            return;
        }

        payment.setStatus(status);

        if (paymentDAO.recordPayment(payment)) {
            System.out.println("\n✅ Payment Recorded Successfully!");
        } else {
            System.out.println("\n❌ Failed to Record Payment!");
        }
    }

    // View All Payments
    public void viewPayments() {

        paymentDAO.viewPayments();

    }
}
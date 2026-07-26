package ui;

import dao.PaymentDAO;
import model.Payment;

import java.util.Scanner;

public class PaymentUI {

    Scanner sc = new Scanner(System.in);

    PaymentDAO paymentDAO = new PaymentDAO();

    // Record Payment
    public void recordPayment() {

        Payment payment = new Payment();

        System.out.println("\n===== Record Payment =====");

        System.out.print("Invoice ID : ");
        payment.setInvoiceId(sc.nextInt());

        System.out.print("Amount : ");
        payment.setAmount(sc.nextDouble());
        sc.nextLine();

        System.out.print("Payment Date (YYYY-MM-DD) : ");
        payment.setPaymentDate(sc.nextLine());

        System.out.print("Payment Mode (Cash/UPI/Bank Transfer/Cheque) : ");
        payment.setPaymentMethod(sc.nextLine());

        System.out.print("Status (Pending/Completed/Failed) : ");
        payment.setStatus(sc.nextLine());

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
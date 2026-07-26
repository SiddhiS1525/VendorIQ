package dao;

import model.Payment;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PaymentDAO {

    // Record Payment
    public boolean recordPayment(Payment payment) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO payments(invoice_id, payment_date, amount, payment_mode, payment_status) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, payment.getInvoiceId());
            ps.setString(2, payment.getPaymentDate());
            ps.setDouble(3, payment.getAmount());
            ps.setString(4, payment.getPaymentMethod());
            ps.setString(5, payment.getStatus());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // View Payments
    public void viewPayments() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM payments";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Payments ==========\n");

            while (rs.next()) {

                System.out.println("Payment ID     : " + rs.getInt("payment_id"));
                System.out.println("Invoice ID     : " + rs.getInt("invoice_id"));
                System.out.println("Payment Date   : " + rs.getDate("payment_date"));
                System.out.println("Amount         : " + rs.getDouble("amount"));
                System.out.println("Payment Mode   : " + rs.getString("payment_mode"));
                System.out.println("Status         : " + rs.getString("payment_status"));
                System.out.println("----------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package dao;

import model.Invoice;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InvoiceDAO {

    // Create Invoice
    public boolean createInvoice(Invoice invoice) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO invoices(po_id, invoice_date, amount, status) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, invoice.getPurchaseOrderId());
            ps.setString(2, invoice.getInvoiceDate());
            ps.setDouble(3, invoice.getTotalAmount());
            ps.setString(4, invoice.getStatus());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // View All Invoices
    public void viewAllInvoices() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM invoices";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Invoice List ==========\n");

            while (rs.next()) {

                System.out.println("Invoice ID   : " + rs.getInt("invoice_id"));
                System.out.println("PO ID        : " + rs.getInt("po_id"));
                System.out.println("Invoice Date : " + rs.getDate("invoice_date"));
                System.out.println("Amount       : " + rs.getDouble("amount"));
                System.out.println("Status       : " + rs.getString("status"));
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
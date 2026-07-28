package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDAO {

    // Vendor Report
    public void vendorReport() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM vendors";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Vendor Report ==========\n");

            while (rs.next()) {

                System.out.println("Vendor ID      : " + rs.getInt("vendor_id"));
                System.out.println("Vendor Name    : " + rs.getString("vendor_name"));
                System.out.println("Company Name   : " + rs.getString("company_name"));
                System.out.println("Email          : " + rs.getString("email"));
                System.out.println("Phone          : " + rs.getString("phone"));
                System.out.println("Category       : " + rs.getString("category"));
                System.out.println("Rating         : " + rs.getDouble("rating"));
                System.out.println("Status         : " + rs.getString("status"));
                System.out.println("--------------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Product Report
    public void productReport() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Product Report ==========\n");

            while (rs.next()) {

                System.out.println("Product ID     : " + rs.getInt("product_id"));
                System.out.println("Product Name   : " + rs.getString("product_name"));
                System.out.println("Category       : " + rs.getString("category"));
                System.out.println("Price          : " + rs.getDouble("price"));
                System.out.println("Stock          : " + rs.getInt("stock"));
                System.out.println("--------------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Purchase Order Report
    public void purchaseOrderReport() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM purchase_orders";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Purchase Order Report ==========\n");

            while (rs.next()) {

                System.out.println("PO ID          : " + rs.getInt("po_id"));
                System.out.println("Vendor ID      : " + rs.getInt("vendor_id"));
                System.out.println("Order Date     : " + rs.getDate("order_date"));
                System.out.println("Total Amount   : " + rs.getDouble("total_amount"));
                System.out.println("Status         : " + rs.getString("status"));
                System.out.println("--------------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Invoice Report
    public void invoiceReport() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM invoices";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Invoice Report ==========\n");

            while (rs.next()) {

                System.out.println("Invoice ID     : " + rs.getInt("invoice_id"));
                System.out.println("PO ID          : " + rs.getInt("po_id"));
                System.out.println("Invoice Date   : " + rs.getDate("invoice_date"));
                System.out.println("Amount         : " + rs.getDouble("amount"));
                System.out.println("Status         : " + rs.getString("status"));
                System.out.println("--------------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Payment Report
    public void paymentReport() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM payments";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Payment Report ==========\n");

            while (rs.next()) {

                System.out.println("Payment ID     : " + rs.getInt("payment_id"));
                System.out.println("Invoice ID     : " + rs.getInt("invoice_id"));
                System.out.println("Payment Date   : " + rs.getDate("payment_date"));
                System.out.println("Amount         : " + rs.getDouble("amount"));
                System.out.println("Payment Mode   : " + rs.getString("payment_mode"));
                System.out.println("Status         : " + rs.getString("payment_status"));
                System.out.println("--------------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
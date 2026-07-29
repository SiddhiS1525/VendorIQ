package dao;

import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnalyticsDAO {

    // Top Rated Vendors
    public void topRatedVendors() {

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM vendors ORDER BY rating DESC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Top Rated Vendors ==========\n");

            while (rs.next()) {

                System.out.println("Vendor ID   : " + rs.getInt("vendor_id"));
                System.out.println("Vendor Name : " + rs.getString("vendor_name"));
                System.out.println("Company     : " + rs.getString("company_name"));
                System.out.println("Rating      : " + rs.getDouble("rating"));
                System.out.println("----------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Low Rated Vendors
    public void lowRatedVendors() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM vendors ORDER BY rating ASC";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Low Rated Vendors ==========\n");

            while (rs.next()) {

                System.out.println("Vendor ID   : " + rs.getInt("vendor_id"));
                System.out.println("Vendor Name : " + rs.getString("vendor_name"));
                System.out.println("Company     : " + rs.getString("company_name"));
                System.out.println("Rating      : " + rs.getDouble("rating"));
                System.out.println("----------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Low Stock Products
    public void lowStockProducts() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products WHERE stock_quantity < 10";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Low Stock Products ==========\n");

            while (rs.next()) {

                System.out.println("Product ID   : " + rs.getInt("product_id"));
                System.out.println("Product Name : " + rs.getString("product_name"));
                System.out.println("Category     : " + rs.getString("category"));
                System.out.println("Stock        : " + rs.getInt("stock_quantity"));
                System.out.println("----------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Revenue Summary
    public void revenueSummary() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT SUM(amount) AS totalRevenue FROM payments WHERE payment_status='Completed'";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Revenue Summary ==========\n");

            if (rs.next()) {

                System.out.println("Total Revenue : ₹" + rs.getDouble("totalRevenue"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
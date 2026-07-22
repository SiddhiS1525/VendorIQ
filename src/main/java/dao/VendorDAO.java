package dao;

import model.Vendor;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VendorDAO {

    // Add Vendor
    public boolean addVendor(Vendor vendor) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO vendors(vendor_name, company_name, email, phone, address, category, rating, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, vendor.getVendorName());
            ps.setString(2, vendor.getCompanyName());
            ps.setString(3, vendor.getEmail());
            ps.setString(4, vendor.getPhone());
            ps.setString(5, vendor.getAddress());
            ps.setString(6, vendor.getCategory());
            ps.setDouble(7, vendor.getRating());
            ps.setString(8, vendor.getStatus());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // View All Vendors
    public void viewAllVendors() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM vendors";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Vendor List ==========\n");

            while (rs.next()) {

                System.out.println("Vendor ID    : " + rs.getInt("vendor_id"));
                System.out.println("Vendor Name  : " + rs.getString("vendor_name"));
                System.out.println("Company Name : " + rs.getString("company_name"));
                System.out.println("Email        : " + rs.getString("email"));
                System.out.println("Phone        : " + rs.getString("phone"));
                System.out.println("Address      : " + rs.getString("address"));
                System.out.println("Category     : " + rs.getString("category"));
                System.out.println("Rating       : " + rs.getDouble("rating"));
                System.out.println("Status       : " + rs.getString("status"));
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
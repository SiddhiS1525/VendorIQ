package dao;

import model.PurchaseOrder;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PurchaseOrderDAO {

    // Create Purchase Order
    public boolean addOrder(PurchaseOrder order) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO purchase_orders(vendor_id, total_amount, order_date, status) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, order.getVendorId());
            ps.setDouble(2, order.getTotalAmount());
            ps.setString(3, order.getOrderDate());
            ps.setString(4, order.getStatus());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // View Purchase Orders
    public void viewAllOrders() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM purchase_orders";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Purchase Orders ==========\n");

            while (rs.next()) {

                System.out.println("PO ID         : " + rs.getInt("po_id"));
                System.out.println("Vendor ID     : " + rs.getInt("vendor_id"));
                System.out.println("Total Amount  : " + rs.getDouble("total_amount"));
                System.out.println("Order Date    : " + rs.getDate("order_date"));
                System.out.println("Status        : " + rs.getString("status"));
                System.out.println("---------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Status
    public boolean updateStatus(int orderId, String status) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE purchase_orders SET status=? WHERE po_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, orderId);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
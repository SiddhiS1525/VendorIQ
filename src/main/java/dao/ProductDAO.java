package dao;

import model.Product;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {

    // Add Product
    public boolean addProduct(Product product) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO products(product_name, category, unit_price, stock_quantity) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getCategory());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStockQuantity());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // View All Products
    public void viewAllProducts() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== Product List ==========\n");

            while (rs.next()) {

                System.out.println("Product ID      : " + rs.getInt("product_id"));
                System.out.println("Product Name    : " + rs.getString("product_name"));
                System.out.println("Category        : " + rs.getString("category"));
                System.out.println("Unit Price      : " + rs.getDouble("unit_price"));
                System.out.println("Stock Quantity  : " + rs.getInt("stock_quantity"));
                System.out.println("---------------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search Product
    public void searchProduct(int productId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM products WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== Product Found =====");

                System.out.println("Product ID      : " + rs.getInt("product_id"));
                System.out.println("Product Name    : " + rs.getString("product_name"));
                System.out.println("Category        : " + rs.getString("category"));
                System.out.println("Unit Price      : " + rs.getDouble("unit_price"));
                System.out.println("Stock Quantity  : " + rs.getInt("stock_quantity"));

            } else {

                System.out.println("\nProduct Not Found!");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Product
    public boolean updateProduct(Product product) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE products SET product_name=?, category=?, unit_price=?, stock_quantity=? WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getCategory());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getStockQuantity());
            ps.setInt(5, product.getProductId());

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete Product
    public boolean deleteProduct(int productId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM products WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, productId);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Increase Stock
    public boolean increaseStock(int productId, int quantity) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE products SET stock_quantity = stock_quantity + ? WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, productId);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Decrease Stock
    public boolean decreaseStock(int productId, int quantity) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "UPDATE products SET stock_quantity = stock_quantity - ? WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quantity);
            ps.setInt(2, productId);

            int rows = ps.executeUpdate();

            ps.close();
            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check Stock
    public void checkStock(int productId) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT stock_quantity FROM products WHERE product_id=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("Current Stock : " + rs.getInt("stock_quantity"));

            } else {

                System.out.println("Product Not Found!");

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
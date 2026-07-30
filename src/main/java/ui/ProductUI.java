package ui;

import dao.ProductDAO;
import model.Product;

import java.util.Scanner;

public class ProductUI {

    Scanner sc = new Scanner(System.in);

    ProductDAO productDAO = new ProductDAO();

    // Add Product
    public void addProduct() {

        Product product = new Product();

        System.out.println("\n===== Add Product =====");

        // Product Name
        System.out.print("Product Name : ");
        String productName = sc.nextLine();

        if (productName.trim().isEmpty()) {
            System.out.println("❌ Product Name cannot be empty!");
            return;
        }
        product.setProductName(productName);

        // Category
        System.out.print("Category : ");
        String category = sc.nextLine();

        if (category.trim().isEmpty()) {
            System.out.println("❌ Category cannot be empty!");
            return;
        }
        product.setCategory(category);

        // Unit Price
        System.out.print("Unit Price : ");
        double price = sc.nextDouble();

        if (price < 0) {
            System.out.println("❌ Price cannot be negative!");
            return;
        }
        product.setPrice(price);

        // Stock Quantity
        System.out.print("Stock Quantity : ");
        int stock = sc.nextInt();
        sc.nextLine();

        if (stock < 0) {
            System.out.println("❌ Stock cannot be negative!");
            return;
        }
        product.setStockQuantity(stock);

        if (productDAO.addProduct(product)) {
            System.out.println("\n✅ Product Added Successfully!");
        } else {
            System.out.println("\n❌ Failed to Add Product!");
        }
    }

    // View All Products
    public void viewAllProducts() {
        productDAO.viewAllProducts();
    }

    // Search Product
    public void searchProduct() {

        System.out.print("Enter Product ID : ");
        int productId = sc.nextInt();
        sc.nextLine();

        productDAO.searchProduct(productId);
    }

    // Update Product
    public void updateProduct() {

        Product product = new Product();

        System.out.print("Enter Product ID : ");
        product.setProductId(sc.nextInt());
        sc.nextLine();

        // Product Name
        System.out.print("New Product Name : ");
        String productName = sc.nextLine();

        if (productName.trim().isEmpty()) {
            System.out.println("❌ Product Name cannot be empty!");
            return;
        }
        product.setProductName(productName);

        // Category
        System.out.print("New Category : ");
        String category = sc.nextLine();

        if (category.trim().isEmpty()) {
            System.out.println("❌ Category cannot be empty!");
            return;
        }
        product.setCategory(category);

        // Price
        System.out.print("New Unit Price : ");
        double price = sc.nextDouble();

        if (price < 0) {
            System.out.println("❌ Price cannot be negative!");
            return;
        }
        product.setPrice(price);

        // Stock
        System.out.print("New Stock Quantity : ");
        int stock = sc.nextInt();
        sc.nextLine();

        if (stock < 0) {
            System.out.println("❌ Stock cannot be negative!");
            return;
        }
        product.setStockQuantity(stock);

        if (productDAO.updateProduct(product)) {
            System.out.println("\n✅ Product Updated Successfully!");
        } else {
            System.out.println("\n❌ Product Update Failed!");
        }
    }

    // Delete Product
    public void deleteProduct() {

        System.out.print("Enter Product ID : ");
        int productId = sc.nextInt();
        sc.nextLine();

        if (productDAO.deleteProduct(productId)) {
            System.out.println("\n✅ Product Deleted Successfully!");
        } else {
            System.out.println("\n❌ Product Delete Failed!");
        }
    }

    // Increase Stock
    public void increaseStock() {

        System.out.print("Enter Product ID : ");
        int productId = sc.nextInt();

        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("❌ Quantity must be greater than 0!");
            return;
        }

        if (productDAO.increaseStock(productId, quantity)) {
            System.out.println("\n✅ Stock Increased Successfully!");
        } else {
            System.out.println("\n❌ Failed!");
        }
    }

    // Decrease Stock
    public void decreaseStock() {

        System.out.print("Enter Product ID : ");
        int productId = sc.nextInt();

        System.out.print("Enter Quantity : ");
        int quantity = sc.nextInt();
        sc.nextLine();

        if (quantity <= 0) {
            System.out.println("❌ Quantity must be greater than 0!");
            return;
        }

        if (productDAO.decreaseStock(productId, quantity)) {
            System.out.println("\n✅ Stock Decreased Successfully!");
        } else {
            System.out.println("\n❌ Failed!");
        }
    }

    // Check Stock
    public void checkStock() {

        System.out.print("Enter Product ID : ");
        int productId = sc.nextInt();
        sc.nextLine();

        productDAO.checkStock(productId);
    }
}
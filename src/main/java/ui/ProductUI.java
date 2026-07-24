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

        System.out.print("Product Name : ");
        product.setProductName(sc.nextLine());

        System.out.print("Category : ");
        product.setCategory(sc.nextLine());

        System.out.print("Unit Price : ");
        product.setPrice(sc.nextDouble());

        System.out.print("Stock Quantity : ");
        product.setStockQuantity(sc.nextInt());
        sc.nextLine();

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

        System.out.print("New Product Name : ");
        product.setProductName(sc.nextLine());

        System.out.print("New Category : ");
        product.setCategory(sc.nextLine());

        System.out.print("New Unit Price : ");
        product.setPrice(sc.nextDouble());

        System.out.print("New Stock Quantity : ");
        product.setStockQuantity(sc.nextInt());
        sc.nextLine();

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
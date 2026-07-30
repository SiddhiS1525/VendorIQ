package ui;

import dao.VendorDAO;
import model.Vendor;

import java.util.Scanner;

public class VendorUI {

    Scanner sc = new Scanner(System.in);

    VendorDAO vendorDAO = new VendorDAO();

    // Add Vendor
    public void addVendor() {

        Vendor vendor = new Vendor();

        System.out.println("\n===== Add Vendor =====");

        // Vendor Name
        System.out.print("Vendor Name : ");
        String vendorName = sc.nextLine();

        if (vendorName.trim().isEmpty()) {
            System.out.println("❌ Vendor Name cannot be empty!");
            return;
        }
        vendor.setVendorName(vendorName);

        // Company Name
        System.out.print("Company Name : ");
        String companyName = sc.nextLine();

        if (companyName.trim().isEmpty()) {
            System.out.println("❌ Company Name cannot be empty!");
            return;
        }
        vendor.setCompanyName(companyName);

        // Email
        System.out.print("Email : ");
        String email = sc.nextLine();

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.println("❌ Invalid Email Address!");
            return;
        }
        vendor.setEmail(email);

        // Phone
        System.out.print("Phone : ");
        String phone = sc.nextLine();

        if (!phone.matches("\\d{10}")) {
            System.out.println("❌ Phone Number must contain exactly 10 digits!");
            return;
        }
        vendor.setPhone(phone);

        // Address
        System.out.print("Address : ");
        vendor.setAddress(sc.nextLine());

        // Category
        System.out.print("Category : ");
        String category = sc.nextLine();

        if (category.trim().isEmpty()) {
            System.out.println("❌ Category cannot be empty!");
            return;
        }
        vendor.setCategory(category);

        // Rating
        System.out.print("Rating : ");
        double rating = sc.nextDouble();
        sc.nextLine();

        if (rating < 0 || rating > 5) {
            System.out.println("❌ Rating must be between 0 and 5!");
            return;
        }
        vendor.setRating(rating);

        // Status
        System.out.print("Status : ");
        String status = sc.nextLine();

        if (status.trim().isEmpty()) {
            System.out.println("❌ Status cannot be empty!");
            return;
        }
        vendor.setStatus(status);

        boolean result = vendorDAO.addVendor(vendor);

        if (result) {
            System.out.println("\n✅ Vendor Added Successfully!");
        } else {
            System.out.println("\n❌ Failed to Add Vendor!");
        }
    }

    // View All Vendors
    public void viewAllVendors() {
        vendorDAO.viewAllVendors();
    }
}
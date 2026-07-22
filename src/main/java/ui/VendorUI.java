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

        System.out.print("Vendor Name : ");
        vendor.setVendorName(sc.nextLine());

        System.out.print("Company Name : ");
        vendor.setCompanyName(sc.nextLine());

        System.out.print("Email : ");
        vendor.setEmail(sc.nextLine());

        System.out.print("Phone : ");
        vendor.setPhone(sc.nextLine());

        System.out.print("Address : ");
        vendor.setAddress(sc.nextLine());

        System.out.print("Category : ");
        vendor.setCategory(sc.nextLine());

        System.out.print("Rating : ");
        vendor.setRating(sc.nextDouble());
        sc.nextLine();

        System.out.print("Status : ");
        vendor.setStatus(sc.nextLine());

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
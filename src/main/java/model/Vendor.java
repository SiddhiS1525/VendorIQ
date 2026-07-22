package model;

public class Vendor {

    private int vendorId;
    private String vendorName;
    private String companyName;
    private String email;
    private String phone;
    private String address;
    private String category;
    private double rating;
    private String status;

    public Vendor() {
    }

    public Vendor(int vendorId, String vendorName, String companyName,
                  String email, String phone, String address,
                  String category, double rating, String status) {

        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.companyName = companyName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.category = category;
        this.rating = rating;
        this.status = status;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendorId=" + vendorId +
                ", vendorName='" + vendorName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", category='" + category + '\'' +
                ", rating=" + rating +
                ", status='" + status + '\'' +
                '}';
    }
}
CREATE DATABASE  vendoriq;

USE vendoriq;

-
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('Admin', 'Manager') DEFAULT 'Manager',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE vendors (
    vendor_id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_name VARCHAR(100) NOT NULL,
    company_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15) NOT NULL,
    address TEXT,
    gst_number VARCHAR(20) UNIQUE,
    category VARCHAR(50),
    status ENUM('Active','Inactive') DEFAULT 'Active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    unit_price DECIMAL(10,2) NOT NULL,
    stock_quantity INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE vendor_products (
    vendor_product_id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_id INT NOT NULL,
    product_id INT NOT NULL,
    price DECIMAL(10,2),
    lead_time INT,
    FOREIGN KEY (vendor_id) REFERENCES vendors(vendor_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);



CREATE TABLE purchase_orders (
    po_id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_id INT NOT NULL,
    order_date DATE NOT NULL,
    total_amount DECIMAL(10,2),
    status ENUM('Pending','Approved','Completed','Cancelled') DEFAULT 'Pending',
    FOREIGN KEY (vendor_id) REFERENCES vendors(vendor_id)
);



CREATE TABLE contracts (
    contract_id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_id INT NOT NULL,
    start_date DATE,
    end_date DATE,
    contract_value DECIMAL(10,2),
    status ENUM('Active','Expired','Terminated') DEFAULT 'Active',
    FOREIGN KEY (vendor_id) REFERENCES vendors(vendor_id)
);



CREATE TABLE invoices (
    invoice_id INT AUTO_INCREMENT PRIMARY KEY,
    po_id INT NOT NULL,
    invoice_date DATE,
    amount DECIMAL(10,2),
    status ENUM('Pending','Paid','Overdue') DEFAULT 'Pending',
    FOREIGN KEY (po_id) REFERENCES purchase_orders(po_id)
);



CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT NOT NULL,
    payment_date DATE,
    amount DECIMAL(10,2),
    payment_mode ENUM('Cash','UPI','Bank Transfer','Cheque'),
    payment_status ENUM('Pending','Completed','Failed') DEFAULT 'Pending',
    FOREIGN KEY (invoice_id) REFERENCES invoices(invoice_id)
);



CREATE TABLE vendor_performance (
    performance_id INT AUTO_INCREMENT PRIMARY KEY,
    vendor_id INT NOT NULL,
    quality_score DECIMAL(5,2),
    delivery_score DECIMAL(5,2),
    communication_score DECIMAL(5,2),
    overall_score DECIMAL(5,2),
    FOREIGN KEY (vendor_id) REFERENCES vendors(vendor_id)
);
USE vendoriq;

-- Users
INSERT INTO users (full_name, email, password, role)
VALUES
('Arjun Mehta', 'arjun@vendoriq.com', 'admin123', 'Admin'),
('Priya Sharma', 'priya@vendoriq.com', 'manager123', 'Manager');

-- Vendors
INSERT INTO vendors
(vendor_name, company_name, email, phone, address, gst_number, category, status)
VALUES
('Rajesh Kumar', 'TechNova Solutions Pvt Ltd', 'rajesh@technova.com', '9876543210', 'Pune', '27ABCDE1234F1Z5', 'Electronics', 'Active'),

('Sneha Verma', 'OfficeMart India', 'sneha@officemart.com', '9123456780', 'Mumbai', '27PQRSX5678L1Z2', 'Office Supplies', 'Active'),

('Vikram Singh', 'Industrial Edge Pvt Ltd', 'vikram@industrialedge.com', '9988776655', 'Nashik', '27LMNOP9876K1Z8', 'Hardware', 'Active');

-- Products
INSERT INTO products
(product_name, category, unit_price, stock_quantity)
VALUES
('Dell Laptop', 'Electronics', 65000, 20),
('HP Printer', 'Electronics', 15000, 15),
('Office Chair', 'Furniture', 5500, 30),
('Mechanical Keyboard', 'Accessories', 2500, 80),
('Wireless Mouse', 'Accessories', 1200, 100);

-- Vendor Products
INSERT INTO vendor_products
(vendor_id, product_id, price, lead_time)
VALUES
(1,1,63000,5),
(1,2,14500,4),
(2,3,5200,3),
(3,4,2300,2),
(3,5,1100,2);

-- Purchase Orders
INSERT INTO purchase_orders
(vendor_id, order_date, total_amount, status)
VALUES
(1,'2026-07-18',126000,'Approved'),
(2,'2026-07-19',15600,'Pending'),
(3,'2026-07-20',6800,'Completed');

-- Contracts
INSERT INTO contracts
(vendor_id,start_date,end_date,contract_value,status)
VALUES
(1,'2026-01-01','2027-01-01',800000,'Active'),
(2,'2026-02-01','2027-02-01',450000,'Active'),
(3,'2026-03-01','2027-03-01',350000,'Active');

-- Invoices
INSERT INTO invoices
(po_id,invoice_date,amount,status)
VALUES
(1,'2026-07-19',126000,'Paid'),
(2,'2026-07-20',15600,'Pending'),
(3,'2026-07-21',6800,'Paid');

-- Payments
INSERT INTO payments
(invoice_id,payment_date,amount,payment_mode,payment_status)
VALUES
(1,'2026-07-19',126000,'Bank Transfer','Completed'),
(2,NULL,NULL,NULL,'Pending'),
(3,'2026-07-22',6800,'UPI','Completed');

-- Vendor Performance
INSERT INTO vendor_performance
(vendor_id,quality_score,delivery_score,communication_score,overall_score)
VALUES
(1,9.6,9.2,9.4,9.40),
(2,8.9,8.6,8.8,8.77),
(3,9.3,9.1,9.2,9.20);
--Brand

INSERT INTO Brand (brand_id, name) VALUES (1, 'Alfa Romeo');
INSERT INTO Brand (brand_id, name) VALUES (2, 'VW');
INSERT INTO Brand (brand_id, name) VALUES (3, 'Audi');
INSERT INTO Brand (brand_id, name) VALUES (4, 'Peugeot');
INSERT INTO Brand (brand_id, name) VALUES (5, 'Ford');
INSERT INTO Brand (brand_id, name) VALUES (6, 'Mercedes');

--Model

INSERT INTO Model (model_id, name, brand_brand_id) VALUES (1, 'Julia', 1);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (2, 'Mito', 1);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (3, 'Golf 4', 2);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (4, 'T-ROC', 2);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (5, 'A3', 3);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (6, 'R8', 3);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (7, '2008', 4);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (8, '3008', 4);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (9, 'Puma', 5);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (10, 'Focus', 5);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (11, 'GLC SUV', 6);
INSERT INTO Model (model_id, name, brand_brand_id) VALUES (12, 'GLA', 6);

--Seller
INSERT INTO Seller (seller_id, name, email, phone_number, tax_number, address) VALUES (1, 'Joaquim Marante', 'joamarante@example.com', 911028982, 298765432, 'Rua de Nossa Senhora');
INSERT INTO Seller (seller_id, name, email, phone_number, tax_number, address) VALUES (2, 'Joana Var', 'joavar@example.com', 911111111, 299999992, 'Rua de Deus');

--Vehicle
INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId,vehicle_type,seller_seller_id)
VALUES ('4Y1SL65848Z411439', 'ABC123', 1, 2023, 5, 1, 1, 'Grey', 0, 0, 45000.0, 40000.0, 100000, 5, 0, 0, 4,1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('1A2B3C4D5E6F7G8H', 'XYZ789', 2, 2023, 5, 2, 2, 'Red', 0, 0, 35000.0, 30000.0, 80000, 4, 0, 0, 1, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('9J8H7G6F5E4D3C2B', 'LMN456', 3, 2022, 5, 1, 0, 'Blue', 0, 1, 42000.0, 38000.0, 90000, 5, 0, 0, 4, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('QWERTYUIOP1234567', 'DEF987', 4, 2024, 4, 3, 1, 'Black', 1, 1, 48000.0, 45000.0, 0, 3, 0, 0, 4, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('ZXC67890ASDFG123', 'GHI987', 5, 2023, 2, 0, 2, 'Silver', 0, 1, 120000.0, 110000.0, 30000, 2, 0, 0, 4, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('LKJHGFDSA09876543', 'JKL321', 6, 2022, 5, 2, 1, 'White', 1, 1, 38000.0, 35000.0, 0, 4, 0, 0, 4, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('09876ASDFG54321LKJH', 'VW9876', 7, 2023, 5, 3, 0, 'Green', 0, 1, 32000.0, 28000.0, 85000, 5, 0, 0, 1, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('POIUYTREWQ1234567', 'FORD123', 8, 2024, 5, 0, 2, 'Yellow', 1, 1, 29000.0, 25000.0, 0, 3, 0, 0, 1, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('MNBVCXZ0987654321', 'ABC987', 9, 2023, 5, 1, 1, 'Brown', 0, 1, 55000.0, 50000.0, 40000, 5, 0, 0, 4, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('ZXCVBNMASDFGHJKLQ', 'PEUGEOT1', 10, 2022, 5, 2, 0, 'Purple', 1, 1, 36000.0, 32000.0, 0, 4, 0, 0, 1, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('QWERTY0987654321UIO', 'MERCEDES1', 11, 2024, 5, 0, 1, 'Orange', 0, 1, 60000.0, 55000.0, 30000, 3, 0, 0, 2, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('ASDFG123456QWERTYU', 'ALFA1', 12, 2023, 5, 1, 2, 'Silver', 1, 1, 43000.0, 39000.0, 0, 5, 0, 0, 3, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('QWERTYUIOP7890123', 'JKL987', 1, 2023, 5, 2, 2, 'Blue', 0, 1, 38000.0, 35000.0, 75000, 4, 0, 0, 1, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('ZXC78901ASDFG234', 'GHI654', 2, 2022, 5, 1, 0, 'Green', 0, 1, 44000.0, 40000.0, 92000, 5, 0, 0, 4, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('LKJHGFDSA45678901', 'VW1234', 3, 2023, 2, 0, 2, 'White', 0, 1, 125000.0, 115000.0, 32000, 2, 0, 0, 4, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('ZXCVBNMASDFGHJKLW', 'JKL987', 4, 2023, 5, 3, 0, 'Silver', 0, 1, 33000.0, 29000.0, 88000, 5, 0, 0, 1, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('POIUYTREWQ7890123', 'FORD456', 5, 2024, 5, 0, 2, 'Yellow', 1, 1, 31000.0, 27000.0, 0, 3, 0, 0, 1, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('MNBVCXZ4567890123', 'ABC654', 6, 2023, 5, 1, 1, 'Brown', 0, 1, 58000.0, 53000.0, 42000, 5, 0, 0, 4, 2);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('ZXCVBNMASDFGHJKLY', 'PEUGEOT2', 7, 2022, 5, 2, 0, 'Purple', 1, 1, 34000.0, 30000.0, 0, 4, 0, 0, 1, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('QWERTY7890123UIO', 'MERCEDES2', 8, 2024, 5, 0, 1, 'Orange', 0, 1, 62000.0, 57000.0, 32000, 3, 0, 0, 2, 1);

INSERT INTO Vehicle (vin, license_plate, model_model_id, year_plate, seats, traction, fuel_type, colour, state, business_status, selling_price, purchase_price, mileage, doors, buyerId, transactionId, vehicle_type, seller_seller_id)
VALUES ('ASDFG456789QWERTYU', 'ALFA2', 9, 2023, 5, 1, 2, 'Silver', 1, 1, 45000.0, 41000.0, 0, 5, 0, 0, 3, 1);



--Stand

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
INSERT INTO Seller (seller_id, name, email, phone_number, tax_number, address) VALUES (1, 'Joaquim Marante', 'joamarante@example.com', 911028982, 298765432, "Rua de Nossa Senhora");
INSERT INTO Seller (seller_id, name, email, phone_number, tax_number, address) VALUES (2, 'Joana Var', 'joavar@example.com', 911111111, 299999992, "Rua de Deus");

--Vehicle
INSERT INTO Vehicle (vin, licence_plate, model_model_id, year_plate, number_of_seats, traction, fuel_type, colour, state, status, selling_price, purchase_price, kms, number_of_doors, id_buyer, id_transaction)
VALUES ('4Y1SL65848Z411439', 'ABC123', 'Julia', 2023, 5, 'AWD', 1, 'Grey', 0, 1, 45000.0, 40000.0, 100.0, 4, 0, 0);





--Stand

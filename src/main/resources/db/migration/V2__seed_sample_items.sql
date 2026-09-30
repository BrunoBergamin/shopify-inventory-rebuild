INSERT INTO  inventory_item (sku, name, description, quantity, unit_price, created_at, updated_at)
VALUES
    ('BOX-SMALL', 'Cardboard box (small)', '30 x 20 x 15 cm, single wall', 500, 1.50, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('PALLET-STD', 'Wooden pallet', '120 x 100cm, standard', 40, 45.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('TAPE-48', 'Packing tape', '48 mm x 100 m, transparent', 200, 6.90, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
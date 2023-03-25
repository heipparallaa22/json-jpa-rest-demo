
ALTER TABLE Address
DROP CONSTRAINT Address_FK_Purc_D_PurchaseOrder;

ALTER TABLE Item
DROP CONSTRAINT Item_FK_Purchas_D_PurchaseOrder;

ALTER TABLE PurchaseOrder
DROP CONSTRAINT PurchaseOrder_F_omerID_Customer;

-- -----------------------------------------------------------------------
-- Customer
-- -----------------------------------------------------------------------

DROP TABLE Customer CASCADE;

DROP SEQUENCE Customer_CustomerID_seq;

-- -----------------------------------------------------------------------
-- Address
-- -----------------------------------------------------------------------

DROP TABLE Address CASCADE;

DROP SEQUENCE Address_AddressID_seq;

-- -----------------------------------------------------------------------
-- Item
-- -----------------------------------------------------------------------

DROP TABLE Item CASCADE;

DROP SEQUENCE Item_ItemID_seq;

-- -----------------------------------------------------------------------
-- PurchaseOrder
-- -----------------------------------------------------------------------

DROP TABLE PurchaseOrder CASCADE;

DROP SEQUENCE PurchaseOrder_P_haseOrderID_seq;

-- -----------------------------------------------------------------------
-- PurchaseOrder
-- -----------------------------------------------------------------------

CREATE SEQUENCE PurchaseOrder_P_haseOrderID_seq;

CREATE TABLE PurchaseOrder
(
    PurchaseOrderID INTEGER NOT NULL UNIQUE DEFAULT nextval('PurchaseOrder_P_haseOrderID_seq'),
    PurchaseOrderNumber INTEGER,
    CustomerID INTEGER,
    DeliveryNotes VARCHAR(100),
    OrderDate DATE,
    PRIMARY KEY (PurchaseOrderID)
);

-- -----------------------------------------------------------------------
-- Item
-- -----------------------------------------------------------------------

CREATE SEQUENCE Item_ItemID_seq;

CREATE TABLE Item
(
    ItemID INTEGER NOT NULL UNIQUE DEFAULT nextval('Item_ItemID_seq'),
    Comment VARCHAR(100),
    PartNumber VARCHAR(100),
    ProductName VARCHAR(100),
    Quantity INTEGER,
    USPrice DOUBLE PRECISION,
    ShipDate DATE,
    PurchaseOrderID INTEGER NOT NULL,
    PRIMARY KEY (ItemID)
);

-- -----------------------------------------------------------------------
-- Address
-- -----------------------------------------------------------------------

CREATE SEQUENCE Address_AddressID_seq;

CREATE TABLE Address
(
    AddressID INTEGER NOT NULL UNIQUE DEFAULT nextval('Address_AddressID_seq'),
    Zip INTEGER,
    Type VARCHAR(100),
    State VARCHAR(100),
    Street VARCHAR(100),
    Country VARCHAR(100),
    City VARCHAR(100),
    Name VARCHAR(100),
    PurchaseOrderID INTEGER NOT NULL,
    PRIMARY KEY (AddressID)
);

-- -----------------------------------------------------------------------
-- Customer
-- -----------------------------------------------------------------------

CREATE SEQUENCE Customer_CustomerID_seq;

CREATE TABLE Customer
(
    CustomerID INTEGER NOT NULL UNIQUE DEFAULT nextval('Customer_CustomerID_seq'),
    Email VARCHAR(100),
    Id VARCHAR(100),
    Mobile INTEGER,
    Name VARCHAR(100),
    PRIMARY KEY (CustomerID)
);

ALTER TABLE PurchaseOrder
    ADD CONSTRAINT PurchaseOrder_F_omerID_Customer FOREIGN KEY (CustomerID) REFERENCES Customer (CustomerID);

ALTER TABLE Item
    ADD CONSTRAINT Item_FK_Purchas_D_PurchaseOrder FOREIGN KEY (PurchaseOrderID) REFERENCES PurchaseOrder (PurchaseOrderID);

ALTER TABLE Address
    ADD CONSTRAINT Address_FK_Purc_D_PurchaseOrder FOREIGN KEY (PurchaseOrderID) REFERENCES PurchaseOrder (PurchaseOrderID);


CREATE DATABASE inventory_control;

USE inventory_control;


#
# ENTERPRISE
#
CREATE TABLE enterprise (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    enterprise_name VARCHAR(45) NOT NULL,
    cnpj INT NOT NULL,
	subscription ENUM('ACTIVE', 'INACTIVE', 'TEST', 'BLOCKED') NOT NULL,
    UNIQUE(cnpj)
);

#
#    CREATE TABLE enterprise_contact (
#        id BIGINT PRIMARY KEY AUTO_INCREMENT,
#        enterprise_id BIGINT NOT NULL,
#        email VARCHAR(100) NOT NULL,
#        ddd INT NOT NULL,
#        phone INT NOT NULL,
#        UNIQUE(email, phone),
#        FOREIGN KEY(enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE
#    );
#
#    CREATE TABLE enterprise_address (
#        id BIGINT PRIMARY KEY AUTO_INCREMENT,
#        enterprise_id BIGINT NOT NULL,
#        country VARCHAR(45) NOT NULL,
#        state_name VARCHAR(45) NOT NULL,
#        city VARCHAR(45) NOT NULL,
#        zip_code INT NOT NULL,
#        neighborhood VARCHAR(70) NOT NULL,
#        street VARCHAR(70) NOT NULL,
#        building_number INT NOT NULL,
#        unit_number INT,
#        FOREIGN KEY (enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE
#    );
#


#
# PERSON
#
CREATE TABLE person (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    enterprise_id BIGINT NOT NULL,
    FOREIGN KEY(enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE
);


#
# LOGIN
#
CREATE TABLE login (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    keypass VARCHAR(250) NOT NULL,
    login_role ENUM('ADMIN', 'STOCKIST', 'SELLER') NOT NULL,
    login_status ENUM('ACTIVE', 'INACTIVE', 'BLOCKED') NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    person_id BIGINT NOT NULL,
    UNIQUE(username),
    FOREIGN KEY(person_id) REFERENCES person(id) ON DELETE CASCADE
);


#
# SUPPLIER
#
CREATE TABLE supplier (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    supplier_name VARCHAR(50) NOT NULL,
    email VARCHAR(100),
    ddd INT,
    phone INT,
    enterprise_id BIGINT NOT NULL,
    FOREIGN KEY(enterprise_id) REFERENCES category(enterprise_id) ON DELETE CASCADE
);


#
# CATEGORY
#
CREATE TABLE category (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(45) NOT NULL,
    category_status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
    enterprise_id BIGINT NOT NULL,
    FOREIGN KEY(enterprise_id) REFERENCES enterprise(id) ON DELETE CASCADE
);


#
# PRODUCT
#
CREATE TABLE product (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(50) NOT NULL,
    product_description TEXT,
    price DECIMAL(10,2) NOT NULL,
    product_status ENUM('ACTIVE', 'INACTIVE') NOT NULL,
    enterprise_id BIGINT NOT NULL,
    supplier_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    FOREIGN KEY(enterprise_id) REFERENCES category(enterprise_id) ON DELETE CASCADE,
    FOREIGN KEY(category_id) REFERENCES category(id) ON DELETE CASCADE
);


#
# STOCK
#
CREATE TABLE stock (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    min_quantity INT NOT NULL,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE
);


#
# STOCK_MOVEMENT
#
CREATE TABLE stock_movement (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    movement_type ENUM('ENTRY', 'EXIT', 'ADJUSTMENT'),
    quantity INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    person_id BIGINT NOT NULL,
    stock_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    FOREIGN KEY(person_id) REFERENCES person(id) ON DELETE CASCADE,
    FOREIGN KEY(stock_id) REFERENCES stock(id) ON DELETE CASCADE,
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE CASCADE
);

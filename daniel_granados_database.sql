-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS mydb DEFAULT CHARACTER SET utf8 ;
USE mydb ;

-- -----------------------------------------------------
-- Table mydb.customer
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.customer (
  cus_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
  cus_fullname VARCHAR(45) NOT NULL,
  cus_username VARCHAR(45) NOT NULL,
  cus_password VARCHAR(45) NOT NULL,
  cus_document VARCHAR(15) NOT NULL,
  cus_phone VARCHAR(15) NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NULL,
  PRIMARY KEY (cus_id),
  UNIQUE INDEX username (cus_username ASC) INVISIBLE,
  INDEX fullname (cus_fullname ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.service
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.service (
  serv_id INT NOT NULL AUTO_INCREMENT,
  serv_name VARCHAR(45) NOT NULL,
  serv_active VARCHAR(10) NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NULL,
  PRIMARY KEY (serv_id),
  INDEX serv_name (serv_name ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table mydb.employee
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS mydb.employee (
  emp_id INT NOT NULL AUTO_INCREMENT,
  emp_fullname VARCHAR(45) NOT NULL,
  emp_document VARCHAR(45) NOT NULL,
  emp_phone VARCHAR(45) NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at DATETIME NULL,
  PRIMARY KEY (emp_id),
  INDEX emp_name (emp_fullname ASC) INVISIBLE,
  INDEX emp_document (emp_document ASC) VISIBLE,
  UNIQUE INDEX emp_name_document (emp_fullname ASC, emp_document ASC) VISIBLE)
ENGINE = InnoDB;


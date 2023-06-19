SELECT * FROM propertymanagementsystem.property;
CREATE TABLE `propertymanagementsystem`.`Property` (
  `Property_ID` INT NOT NULL AUTO_INCREMENT,
  `P_Address` VARCHAR(255) NOT NULL,
  `Owner_ID` INT NOT NULL,
  `Owner_Name` VARCHAR(50) NOT NULL,
  `Owner_No` INT NOT NULL,
  `Rooms` INT NULL,
  `P_Type` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Property_ID`));

CREATE TABLE `propertymanagementsystem`.`owner` (
  `Owner_ID` INT NOT NULL AUTO_INCREMENT,
  `Owner_Name` VARCHAR(50) NOT NULL,
  `Owner_Email` VARCHAR(45) NULL,
  `Owner_No` INT NOT NULL,
  `Property_ID` INT NULL,
  PRIMARY KEY (`Owner_ID`));
  
  CREATE TABLE `propertymanagementsystem`.`client` (
  `Client_ID` INT NOT NULL,
  `Client_Name` VARCHAR(50) NOT NULL,
  `Client_No` INT NOT NULL,
  `Client_Email` VARCHAR(45) NULL,
  PRIMARY KEY (`Client_ID`));

CREATE TABLE `propertymanagementsystem`.`property_status` (
  `Property_ID` INT NOT NULL,
  `Availibility` VARCHAR(10) NOT NULL,
  `Rent/Sell` VARCHAR(15) NOT NULL,
  `Property_Rent` INT NOT NULL);

CREATE TABLE `propertymanagementsystem`.`tenant` (
  `Tenant_ID` INT NOT NULL AUTO_INCREMENT,
  `Tenant_No` INT NOT NULL,
  `Property_ID` INT NOT NULL,
  `P_Address` VARCHAR(50) NOT NULL,
  `Owner_ID` INT NOT NULL,
  `Owner_Name` VARCHAR(45) NOT NULL,
  `Property_Rent` INT NOT NULL,
  `Start_Date` DATE NULL,
  `End_Date` DATE NULL,
  PRIMARY KEY (`Tenant_ID`));

ALTER TABLE `propertymanagementsystem`.`property` 
ADD CONSTRAINT `Owner_ID`
  FOREIGN KEY (Owner_ID)
  REFERENCES `propertymanagementsystem`.`owner` (Owner_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `propertymanagementsystem`.`owner` 
CHANGE COLUMN `Property_ID` `Property_ID` INT NOT NULL;

ALTER TABLE `propertymanagementsystem`.`owner` 
ADD CONSTRAINT `Property_ID_FK`
  FOREIGN KEY (Property_ID)
  REFERENCES `propertymanagementsystem`.`property` (Property_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `propertymanagementsystem`.`client` 
ADD CONSTRAINT `Viewing_P_ID`
  FOREIGN KEY (`Viewing_P_ID`)
  REFERENCES `propertymanagementsystem`.`property` (`Property_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `propertymanagementsystem`.`property_status` 
ADD CONSTRAINT `Property_ID1`
  FOREIGN KEY (Property_ID)
  REFERENCES `propertymanagementsystem`.`property` (Property_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `propertymanagementsystem`.`tenant` 
ADD CONSTRAINT `Property_ID3`
  FOREIGN KEY (Property_ID)
  REFERENCES `propertymanagementsystem`.`property` (Property_ID)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `propertymanagementsystem`.`tenant` 
ADD CONSTRAINT `Owner_ID1`
  FOREIGN KEY (`Owner_ID`)
  REFERENCES `propertymanagementsystem`.`owner` (`Owner_ID`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;

ALTER TABLE `propertymanagementsystem`.`property_status` 
ADD COLUMN `Property_value` INT NULL AFTER `Property_Rent`,
CHANGE COLUMN `Property_Rent` `Property_Rent` INT NULL;
ALTER TABLE `propertymanagementsystem`.`property_status` 
ADD CONSTRAINT `Property_ID`
  FOREIGN KEY (`Property_ID`)
  REFERENCES `propertymanagementsystem`.`property` (`Property_ID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;








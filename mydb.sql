-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`estudiante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`estudiante` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NULL,
  `apellidos` VARCHAR(45) NULL,
  `dni` VARCHAR(8) NULL,
  `codigoPucp` VARCHAR(8) NULL,
  `fechaDeNacimiento` VARCHAR(45) NULL,
  `sexo` VARCHAR(1) NULL,
  `correoInstitucional` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `departamento` VARCHAR(45) NULL,
  `provincia` VARCHAR(45) NULL,
  `carrera` VARCHAR(45) NULL,
  `fechaDeRegistro` VARCHAR(45) NULL,
  `ultimaActualizacion` VARCHAR(45) NULL,
  `estado` TINYINT(1) NULL,
  `correoPersonal` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC) VISIBLE,
  UNIQUE INDEX `correoInstitucional_UNIQUE` (`correoInstitucional` ASC) VISIBLE,
  UNIQUE INDEX `codigoPucp_UNIQUE` (`codigoPucp` ASC) VISIBLE,
  UNIQUE INDEX `correoPersonal_UNIQUE` (`correoPersonal` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.26 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for orderdb
CREATE DATABASE IF NOT EXISTS `orderdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `orderdb`;

-- Dumping structure for table orderdb.customer
DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table orderdb.customer: ~2 rows (approximately)
DELETE FROM `customer`;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`id`, `email`, `first_name`, `gender`, `last_name`, `phone_number`) VALUES
	(1, 'ikatanyi@gmail.com', 'Ken', 'MALE', 'Ikatanyi', '254724135544'),
	(2, 'john@gmail.com', 'John', 'MALE', 'Mwangi', '254724135544');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table orderdb.orders
DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `installation_address` varchar(255) DEFAULT NULL,
  `installation_time` datetime(6) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  `product_package_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK624gtjin3po807j3vix093tlf` (`customer_id`),
  KEY `FK787ibr3guwp6xobrpbofnv7le` (`product_id`),
  KEY `FKlm557rbu1rxf4khop3sjwsu66` (`product_package_id`),
  CONSTRAINT `FK624gtjin3po807j3vix093tlf` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK787ibr3guwp6xobrpbofnv7le` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKlm557rbu1rxf4khop3sjwsu66` FOREIGN KEY (`product_package_id`) REFERENCES `product_package` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table orderdb.orders: ~4 rows (approximately)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` (`id`, `installation_address`, `installation_time`, `status`, `customer_id`, `product_id`, `product_package_id`) VALUES
	(1, '16300, Kasarani Seasons', '2022-08-31 18:26:22.411000', 'APPROVED', 1, 1, 2),
	(2, '16300, Kasarani Seasons', '2022-08-31 18:26:22.411000', 'PENDING', 1, 1, 2),
	(4, '16300, Kasarani Seasons', '2022-08-31 18:26:22.411000', 'PENDING', 2, 1, 5),
	(5, 'Kisumu, Kenya', '2022-09-01 19:38:30.904000', 'PENDING', 1, 1, 5);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Dumping structure for table orderdb.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table orderdb.product: ~4 rows (approximately)
DELETE FROM `product`;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `description`) VALUES
	(1, 'TV'),
	(2, 'INTERNET'),
	(3, 'TELEPHONY'),
	(4, 'MOBILE');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

-- Dumping structure for table orderdb.product_package
DROP TABLE IF EXISTS `product_package`;
CREATE TABLE IF NOT EXISTS `product_package` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8ynmpjkyue5pw52n8gq7x2r4t` (`product_id`),
  CONSTRAINT `FK8ynmpjkyue5pw52n8gq7x2r4t` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table orderdb.product_package: ~7 rows (approximately)
DELETE FROM `product_package`;
/*!40000 ALTER TABLE `product_package` DISABLE KEYS */;
INSERT INTO `product_package` (`id`, `description`, `product_id`) VALUES
	(1, 'string', 1),
	(2, 'string', 2),
	(3, 'string', 3),
	(4, 'string', 4),
	(5, '90 CHANNELS', 1),
	(6, '150 CHANNELS', 1),
	(7, '250 Mbs', 2),
	(8, 'Unlimited', 2);
/*!40000 ALTER TABLE `product_package` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

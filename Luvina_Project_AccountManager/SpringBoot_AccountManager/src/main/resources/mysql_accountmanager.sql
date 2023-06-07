DROP DATABASE IF EXISTS `luvina_database`;
CREATE DATABASE `luvina_database` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `luvina_database`;

CREATE TABLE `department` (
  `DepartmentID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`DepartmentID`),
  UNIQUE KEY `DepartmentName` (`DepartmentName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `position` (
  `PositionID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `PositionName` enum('Dev','Test','Scrum_Master','PM') NOT NULL,
  PRIMARY KEY (`PositionID`),
  UNIQUE KEY `PositionName` (`PositionName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `account` (
  `AccountID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `Email` varchar(30) NOT NULL,
  `UserName` varchar(30) NOT NULL,
  `FullName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DepartmentID` tinyint unsigned DEFAULT NULL,
  `PositionID` tinyint unsigned DEFAULT NULL,
  `CreateDate` date DEFAULT NULL,
  PRIMARY KEY (`AccountID`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `UserName` (`UserName`),
  UNIQUE KEY `FullName` (`FullName`),
  KEY `DepartmentID` (`DepartmentID`),
  KEY `PositionID` (`PositionID`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`),
  CONSTRAINT `account_ibfk_2` FOREIGN KEY (`PositionID`) REFERENCES `position` (`PositionID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- INSERT INTO Department
INSERT INTO `department`(`DepartmentID`, `DepartmentName`) VALUES
(1, 'Marketing'),
(2, 'Sale'),
(3, 'Security'),
(4, 'Human Resources'),
(5, 'Technical'),
(6, 'Finance'),
(7, 'Deputy Manager'),
(8, 'Manager'),
(9, 'Secretary'),
(10, 'Waiting');

-- INSERT INTO Position
INSERT INTO `position`(`PositionID`, `PositionName`) VALUES
(1, 'Dev'),
(2, 'Test'),
(3, 'Scrum_Master'),
(4, 'PM');
-- INSERT INTO Account
INSERT INTO `account`(`Email`, `UserName`, `FullName`, `DepartmentID`, `PositionID`, `CreateDate`) VALUES
('haibt@luvina.net', 'haibt', 'Bùi Thanh Hải', 8, 4, now()),
('huyenbt@luvina.net', 'huyenbt', 'Bùi Thanh Huyền', 1, 2, now()),
('dungnt@luvina.net', 'dungnt', 'Nguyễn Thế Dũng', 5, 4, now()),
('khoibn@luvina.net', 'khoibn', 'Bá Ngọc Khôi', 5, 2, now()),
('uynh@luvina.net', 'uynh', 'Nguyễn Hữu Uy', 7, 3, now()),
('thangnt@luvina.net', 'thangnt', 'Nguyễn Tiến Thắng', 5, 2, now()),
('chungth@luvina.net', 'chungth', 'Thế Hùng Chung', 8, 3, now()),
('haiqn@luvina.net', 'haiqn', 'Quách Ngọc Hải', 6, 1, now()),
('anhnt@luvina.net', 'anhnt', 'Nguyễn Tuấn Anh', 7, 1, now()),
('thangqd@luvina.net', 'thangqd', 'Quách Đình Thắng', 9, 1, now());

/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : localhost:3306
Source Database       : db_blog

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2018-06-05 11:12:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `content` text,
  `username` varchar(50) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `hasread` int(11) DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `username` (`username`),
  CONSTRAINT `article_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------

-- ----------------------------
-- Table structure for bloginfo
-- ----------------------------
DROP TABLE IF EXISTS `bloginfo`;
CREATE TABLE `bloginfo` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `eblogtitle` varchar(50) DEFAULT NULL,
  `idiograph` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`),
  CONSTRAINT `bloginfo_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bloginfo
-- ----------------------------

-- ----------------------------
-- Table structure for critique
-- ----------------------------
DROP TABLE IF EXISTS `critique`;
CREATE TABLE `critique` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AId` int(11) DEFAULT NULL,
  `content` text,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `AId` (`AId`),
  KEY `critique_ibfk_2` (`username`),
  CONSTRAINT `critique_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  CONSTRAINT `critique_ibfk_1` FOREIGN KEY (`AId`) REFERENCES `article` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of critique
-- ----------------------------

-- ----------------------------
-- Table structure for hits
-- ----------------------------
DROP TABLE IF EXISTS `hits`;
CREATE TABLE `hits` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `AId` int(11) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `AId` (`AId`),
  CONSTRAINT `hits_ibfk_1` FOREIGN KEY (`AId`) REFERENCES `article` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hits
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `question` varchar(50) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

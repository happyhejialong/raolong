/*
MySQL Data Transfer
Source Host: localhost
Source Database: bfwk
Target Host: localhost
Target Database: bfwk
Date: 2018-02-25 21:39:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_name` varchar(30) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `user_id` int(11) DEFAULT NULL,
  `permission` varchar(20) DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `category` int(4) DEFAULT NULL,
  `id` int(11) NOT NULL DEFAULT '0',
  `name` varchar(40) DEFAULT NULL,
  `image` varchar(40) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `phone` varchar(20) DEFAULT NULL,
  `card_id` varchar(50) DEFAULT NULL,
  `head_img` varchar(255) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` tinyint(4) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `user` VALUES ('15779556800', '12312312312', null, '100', '1', '1', '12', '1', '2018-02-07', '123456789', '123456789', '1231', '1');

/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db0

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-06 19:22:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_1
-- ----------------------------
INSERT INTO `t_order_1` VALUES ('1', '2', null);
INSERT INTO `t_order_1` VALUES ('3', '2', null);
INSERT INTO `t_order_1` VALUES ('5', '2', null);
INSERT INTO `t_order_1` VALUES ('7', '2', null);
INSERT INTO `t_order_1` VALUES ('9', '2', null);

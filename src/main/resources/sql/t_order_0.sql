/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : db0

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-06 19:22:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_0
-- ----------------------------
INSERT INTO `t_order_0` VALUES ('2', '2', '1');
INSERT INTO `t_order_0` VALUES ('4', '2', null);
INSERT INTO `t_order_0` VALUES ('6', '2', null);
INSERT INTO `t_order_0` VALUES ('8', '2', null);
INSERT INTO `t_order_0` VALUES ('10', '2', null);

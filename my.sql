/*
Navicat MySQL Data Transfer

Source Server         : stanwang
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : my

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-04-19 11:48:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for banji
-- ----------------------------
DROP TABLE IF EXISTS `banji`;
CREATE TABLE `banji` (
  `banji_id` int(11) NOT NULL,
  `banji` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`banji_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banji
-- ----------------------------
INSERT INTO `banji` VALUES ('10101', '软件工程一班', '101');
INSERT INTO `banji` VALUES ('10102', '软件工程二班', '101');
INSERT INTO `banji` VALUES ('10201', '信息一班', '102');
INSERT INTO `banji` VALUES ('10202', '信息二班', '102');
INSERT INTO `banji` VALUES ('10301', '物联网一班', '103');
INSERT INTO `banji` VALUES ('20101', '园林一班', '201');
INSERT INTO `banji` VALUES ('20102', '园林二班', '202');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` varchar(255) DEFAULT NULL,
  `jidu_id` varchar(255) DEFAULT NULL,
  `xueyuan_id` varchar(255) DEFAULT NULL,
  `office_id` varchar(255) DEFAULT NULL,
  `zhuanye_id` varchar(255) DEFAULT NULL,
  `course_id` varchar(255) CHARACTER SET utf16 DEFAULT NULL,
  `banji_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `dec` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', '考核', '春季', '计算机学院', '软件工程办公室', '软件工程', 'java程序设计', '13软件一班', null);
INSERT INTO `file` VALUES ('2', '实习', '秋季', '计算机学院', '软件工程办公室', '软件工程', '算法设计', '13软件一班', null);
INSERT INTO `file` VALUES ('3', '课设', '春季', '计算机学院', '软件工程办公室', '软件工程', '数据结构', '13软件一班', null);
INSERT INTO `file` VALUES ('4', '考核', '春季', '计算机学院', '软件工程办公室', '软件工程', 'java程序设计', '13软件一班', null);
INSERT INTO `file` VALUES ('5', '考核', '秋季', '1', null, '101', '计算机组成', '01', null);
INSERT INTO `file` VALUES ('7', 'a', 'a', '2', null, '201', 'a', '02', null);
INSERT INTO `file` VALUES ('8', '', '', '1', null, '101', '', '01', null);
INSERT INTO `file` VALUES ('9', '考核', '春季', '2', null, '201', '网页设计', '02', null);

-- ----------------------------
-- Table structure for jidu
-- ----------------------------
DROP TABLE IF EXISTS `jidu`;
CREATE TABLE `jidu` (
  `jidu_id` varchar(255) NOT NULL,
  `jidu_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jidu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jidu
-- ----------------------------
INSERT INTO `jidu` VALUES ('C', '春季');
INSERT INTO `jidu` VALUES ('Q', '秋季');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `role_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', 'admin');
INSERT INTO `role` VALUES ('2', '用户', 'user');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` varchar(255) NOT NULL,
  `type_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `password` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `dept` varchar(255) CHARACTER SET latin1 NOT NULL,
  `sex` varchar(100) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '7player', '18856439987', '123456', 'fg', 'd');
INSERT INTO `user` VALUES ('2', 'a', '1353434456', '12', 'ceshi', 'kk');
INSERT INTO `user` VALUES ('3', 'b', '13177865435', '12', 'h', 'f');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '3', '2');

-- ----------------------------
-- Table structure for xueyuan
-- ----------------------------
DROP TABLE IF EXISTS `xueyuan`;
CREATE TABLE `xueyuan` (
  `xueyuan_id` int(11) NOT NULL,
  `xueyuan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`xueyuan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xueyuan
-- ----------------------------
INSERT INTO `xueyuan` VALUES ('1', '计算机与信息工程学院');
INSERT INTO `xueyuan` VALUES ('2', '建筑学院');
INSERT INTO `xueyuan` VALUES ('3', '艺术学院');
INSERT INTO `xueyuan` VALUES ('4', '外国语学院');

-- ----------------------------
-- Table structure for zhuanye
-- ----------------------------
DROP TABLE IF EXISTS `zhuanye`;
CREATE TABLE `zhuanye` (
  `zhuanye_id` int(11) NOT NULL,
  `zhuanye` varchar(255) DEFAULT NULL,
  `pid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`zhuanye_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhuanye
-- ----------------------------
INSERT INTO `zhuanye` VALUES ('101', '软件工程专业', '1');
INSERT INTO `zhuanye` VALUES ('102', '信息工程', '1');
INSERT INTO `zhuanye` VALUES ('103', '物联网工程', '1');
INSERT INTO `zhuanye` VALUES ('201', '园林专业', '2');
INSERT INTO `zhuanye` VALUES ('202', '桥梁专业', '2');
INSERT INTO `zhuanye` VALUES ('301', '舞蹈专业', '3');
INSERT INTO `zhuanye` VALUES ('401', '英语专业', '4');

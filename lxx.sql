/*
Navicat MySQL Data Transfer

Source Server         : stanwang
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : lxx

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-03 19:09:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for banji
-- ----------------------------
DROP TABLE IF EXISTS `banji`;
CREATE TABLE `banji` (
  `id` varchar(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `zhuanye` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of banji
-- ----------------------------
INSERT INTO `banji` VALUES ('0101161', '16园林一班', '0101');
INSERT INTO `banji` VALUES ('0101162', '16园林二班', '0101');
INSERT INTO `banji` VALUES ('0700141', '14信息一班', '0700');
INSERT INTO `banji` VALUES ('0700142', '14信息二班', '0700');
INSERT INTO `banji` VALUES ('0702151', '15物联网一班', '0702');
INSERT INTO `banji` VALUES ('0707131', '13软件工程一班', '0707');
INSERT INTO `banji` VALUES ('0707132', '13软件工程二班', '0707');
INSERT INTO `banji` VALUES ('0707133', '13软件工程三班', '0707');
INSERT INTO `banji` VALUES ('0707141', '14软件工程一班', '0707');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` varchar(11) NOT NULL,
  `course` varchar(255) DEFAULT NULL,
  `pid` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('04', '计算机组成原理', '07');
INSERT INTO `course` VALUES ('05', '操作系统', '07');
INSERT INTO `course` VALUES ('06', '编译原理', '07');
INSERT INTO `course` VALUES ('08', '数据库原理', '07');
INSERT INTO `course` VALUES ('12', '计算机网络原理', '07');
INSERT INTO `course` VALUES ('13', '离散数学', '07');
INSERT INTO `course` VALUES ('17', '算法设计与分析', '07');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `jidu_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `xueyuan_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `office_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `zhuanye_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `course_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `banji_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `dec` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', '实习', '秋季', '计算机学院', '软件工程办公室', '软件工程', '算法设计', '13软件一班', null);
INSERT INTO `file` VALUES ('2', '课设', '春季', '计算机学院', '软件工程办公室', '软件工程', '数据结构', '13软件一班', null);
INSERT INTO `file` VALUES ('3', 'KH', 'C', '07', '03', '0707', '04', '0707131', null);
INSERT INTO `file` VALUES ('4', 'SJ', 'Q', '07', '11', '0707', '08', '0707141', null);
INSERT INTO `file` VALUES ('24', 'KH', 'C', '01', '01', '0101', '04', '0101161', null);
INSERT INTO `file` VALUES ('25', 'KH', 'C', '01', '01', '0101', '04', '0101161', null);
INSERT INTO `file` VALUES ('26', 'LW', 'Q', '07', '05', '0707', '08', '0707141', null);

-- ----------------------------
-- Table structure for jidu
-- ----------------------------
DROP TABLE IF EXISTS `jidu`;
CREATE TABLE `jidu` (
  `jidu_id` varchar(255) NOT NULL,
  `jidu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jidu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of jidu
-- ----------------------------
INSERT INTO `jidu` VALUES ('C', '春季');
INSERT INTO `jidu` VALUES ('Q', '秋季');

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office` (
  `office_id` varchar(11) NOT NULL,
  `office` varchar(255) DEFAULT NULL,
  `pid` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of office
-- ----------------------------
INSERT INTO `office` VALUES ('01', '电子与信息工程系', '07');
INSERT INTO `office` VALUES ('02', '系办公室', '07');
INSERT INTO `office` VALUES ('03', '学生工作办公室', '07');
INSERT INTO `office` VALUES ('04', '计算机基础教研室', '07');
INSERT INTO `office` VALUES ('05', '计算机应用教研室', '07');
INSERT INTO `office` VALUES ('06', '网络工程教研室', '07');
INSERT INTO `office` VALUES ('07', '电子信息工程教研室', '07');
INSERT INTO `office` VALUES ('08', '电气工程及其自动化教研室', '07');
INSERT INTO `office` VALUES ('09', '计算机综合实验室', '07');
INSERT INTO `office` VALUES ('10', '计算机教学实验中心', '07');
INSERT INTO `office` VALUES ('11', '电子信息工程实验室', '07');
INSERT INTO `office` VALUES ('12', '电气工程及其自动化实验室', '07');
INSERT INTO `office` VALUES ('13', '电工电子教学实验中心', '07');

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
  `type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('KH', '课程');
INSERT INTO `type` VALUES ('KS', '课设');
INSERT INTO `type` VALUES ('LW', '毕业论文');
INSERT INTO `type` VALUES ('SJ', ' 毕业设计');
INSERT INTO `type` VALUES ('SX', '实习');

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
  `id` varchar(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xueyuan
-- ----------------------------
INSERT INTO `xueyuan` VALUES ('01', '建筑学院');
INSERT INTO `xueyuan` VALUES ('04', '艺术学院');
INSERT INTO `xueyuan` VALUES ('06', '外国语学院');
INSERT INTO `xueyuan` VALUES ('07', '计算机与信息工程学院');

-- ----------------------------
-- Table structure for zhuanye
-- ----------------------------
DROP TABLE IF EXISTS `zhuanye`;
CREATE TABLE `zhuanye` (
  `id` varchar(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `xueyuan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zhuanye
-- ----------------------------
INSERT INTO `zhuanye` VALUES ('0101', '园林专业', '01');
INSERT INTO `zhuanye` VALUES ('0103', '桥梁专业', '01');
INSERT INTO `zhuanye` VALUES ('0403', '舞蹈专业', '04');
INSERT INTO `zhuanye` VALUES ('0602', '英语专业', '06');
INSERT INTO `zhuanye` VALUES ('0700', '信息工程', '07');
INSERT INTO `zhuanye` VALUES ('0702', '物联网工程', '07');
INSERT INTO `zhuanye` VALUES ('0707', '软件工程', '07');

/*
Navicat MySQL Data Transfer

Source Server         : lxx
Source Server Version : 50511
Source Host           : localhost:3306
Source Database       : lxx

Target Server Type    : MYSQL
Target Server Version : 50511
File Encoding         : 65001

Date: 2017-05-25 09:16:47
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
INSERT INTO `banji` VALUES ('0103141', '14桥梁一班', '0103');
INSERT INTO `banji` VALUES ('0106131', '13建筑一班', '0106');
INSERT INTO `banji` VALUES ('0401131', '13多媒体一班', '0401');
INSERT INTO `banji` VALUES ('0401151', '15多媒体一班', '0401');
INSERT INTO `banji` VALUES ('0402151', '15雕塑一班', '0402');
INSERT INTO `banji` VALUES ('0402152', '15雕塑二班', '0402');
INSERT INTO `banji` VALUES ('0403151', '15舞蹈一班', '0403');
INSERT INTO `banji` VALUES ('0601141', '14日语一班', '0601');
INSERT INTO `banji` VALUES ('0601142', '14日语二班', '0601');
INSERT INTO `banji` VALUES ('0602161', '16英语一班', '0602');
INSERT INTO `banji` VALUES ('0605141', '14西班牙语一班', '0605');
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
INSERT INTO `course` VALUES ('02', '泥塑', '04');
INSERT INTO `course` VALUES ('03', '现代舞', '04');
INSERT INTO `course` VALUES ('04', '计算机组成原理', '07');
INSERT INTO `course` VALUES ('05', '操作系统', '07');
INSERT INTO `course` VALUES ('06', '编译原理', '07');
INSERT INTO `course` VALUES ('07', '建模', '04');
INSERT INTO `course` VALUES ('08', '数据库原理', '07');
INSERT INTO `course` VALUES ('11', '结构力学', '01');
INSERT INTO `course` VALUES ('12', '计算机网络原理', '07');
INSERT INTO `course` VALUES ('13', '离散数学', '07');
INSERT INTO `course` VALUES ('14', '高等数学', '01');
INSERT INTO `course` VALUES ('16', '现代建筑史', '01');
INSERT INTO `course` VALUES ('17', '算法设计与分析', '07');
INSERT INTO `course` VALUES ('18', '西班牙语', '06');
INSERT INTO `course` VALUES ('19', '日语', '06');
INSERT INTO `course` VALUES ('20', '英语', '06');

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
  `count` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', '实习', '秋季', '计算机学院', '软件工程办公室', '软件工程', '算法设计', '13软件一班', '1');
INSERT INTO `file` VALUES ('2', '课设', '春季', '计算机学院', '软件工程办公室', '软件工程', '数据结构', '13软件一班', '3');
INSERT INTO `file` VALUES ('29', 'KS', 'C', '06', '01', '0602', '04', null, '2');
INSERT INTO `file` VALUES ('31', 'KH', 'C', '04', '04', '0403', '04', null, '1');
INSERT INTO `file` VALUES ('32', 'SX', 'C', '04', '11', '0403', '05', null, '3');
INSERT INTO `file` VALUES ('33', 'SX', 'C', '04', '01', '0403', '13', null, '2');
INSERT INTO `file` VALUES ('34', 'KH', 'Q', '06', '13', '0602', '13', null, '3');
INSERT INTO `file` VALUES ('35', 'KH', 'Q', '06', '13', '0602', '13', null, '2');
INSERT INTO `file` VALUES ('38', 'KH', 'C', '06', '11', '0602', '04', null, '1');
INSERT INTO `file` VALUES ('43', 'SX', 'Q', '06', '13', '0602', '17', null, '3');
INSERT INTO `file` VALUES ('44', 'KH', 'C', '04', '01', '0403', '04', null, '2');
INSERT INTO `file` VALUES ('46', 'KH', 'Q', '06', '12', '0602', '05', null, '2');
INSERT INTO `file` VALUES ('47', 'KH', 'C', '01', '01', '0101', '04', '0101161', '1');
INSERT INTO `file` VALUES ('48', 'KH', 'C', '04', '01', '0403', '04', null, '1');
INSERT INTO `file` VALUES ('50', 'KS', 'C', '01', '01', '0106', '02', '0106131', '1');
INSERT INTO `file` VALUES ('51', 'KH', 'C', '01', '01', '0101', '02', '0101161', '3');
INSERT INTO `file` VALUES ('52', 'KH', 'C', '01', '01', '0101', '02', '0101161', '1');
INSERT INTO `file` VALUES ('53', 'KH', 'C', '04', '01', '0401', '11', '0401131', '1');
INSERT INTO `file` VALUES ('54', 'KH', 'C', '06', '01', '0601', '02', '0601141', '3');
INSERT INTO `file` VALUES ('55', 'KH', 'C', '01', '01', '0101', '19', '0101161', '1');
INSERT INTO `file` VALUES ('56', 'SX', 'C', '07', '01', '0707', '13', '0707132', '3');

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
INSERT INTO `office` VALUES ('02', '系办公室', '01');
INSERT INTO `office` VALUES ('03', '学生工作办公室', '04');
INSERT INTO `office` VALUES ('04', '基础教研室', '01');
INSERT INTO `office` VALUES ('05', '应用教研室', '04');
INSERT INTO `office` VALUES ('06', '网络工程教研室', '07');
INSERT INTO `office` VALUES ('07', '电子信息工程教研室', '07');
INSERT INTO `office` VALUES ('08', '电气工程及其自动化教研室', '07');
INSERT INTO `office` VALUES ('09', '综合实验室', '06');
INSERT INTO `office` VALUES ('10', '教学学实验中心', '06');
INSERT INTO `office` VALUES ('11', '电子信息工程实验室', '07');
INSERT INTO `office` VALUES ('12', '电气工程及其自动化实验室', '07');
INSERT INTO `office` VALUES ('13', '教学实验中心', '04');
INSERT INTO `office` VALUES ('15', '教学中心', '04');

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
  `password` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `sex` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '钱玉', '18856439987', '123456', '建筑系', '女');
INSERT INTO `user` VALUES ('2', '王岩', '1353434456', '123321', '建筑系', '男');
INSERT INTO `user` VALUES ('3', '王钟付', '13177865435', '123457', '外语系', '女');
INSERT INTO `user` VALUES ('4', '李晓旭', '15102209775', '123456', '外语系', '男');
INSERT INTO `user` VALUES ('5', '李想', '13526547895', '789987', '计算机系', '男');
INSERT INTO `user` VALUES ('6', '王库', '15246585698', '456654', '计算机系', '男');
INSERT INTO `user` VALUES ('7', '赵玉', '15123654236', '147258', '教学实验中心', '女');
INSERT INTO `user` VALUES ('8', '张开度', '15425698745', 'gggg', '电子与信息工程系', '男');
INSERT INTO `user` VALUES ('9', '张瑟', '15104406547', 'bbb', '综合实验室', '男');
INSERT INTO `user` VALUES ('10', '丁咖', '138965454789', '55555', '电子与信息工程系', '男');
INSERT INTO `user` VALUES ('11', '李雨', '14547895632', '456789', '应用教研室', '男');

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
INSERT INTO `zhuanye` VALUES ('0101', '园林', '01');
INSERT INTO `zhuanye` VALUES ('0103', '桥梁', '01');
INSERT INTO `zhuanye` VALUES ('0106', '建筑', '01');
INSERT INTO `zhuanye` VALUES ('0401', '多媒体', '04');
INSERT INTO `zhuanye` VALUES ('0402', '雕塑', '04');
INSERT INTO `zhuanye` VALUES ('0403', '舞蹈', '04');
INSERT INTO `zhuanye` VALUES ('0601', '日语', '06');
INSERT INTO `zhuanye` VALUES ('0602', '英语', '06');
INSERT INTO `zhuanye` VALUES ('0605', '西班牙语', '06');
INSERT INTO `zhuanye` VALUES ('0700', '信息工程', '07');
INSERT INTO `zhuanye` VALUES ('0702', '物联网工程', '07');
INSERT INTO `zhuanye` VALUES ('0707', '软件工程', '07');

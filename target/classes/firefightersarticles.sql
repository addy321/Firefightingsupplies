/*
 Navicat Premium Data Transfer

 Source Server         : msyql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : firefightersarticles

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 04/02/2021 15:02:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apparatus
-- ----------------------------
DROP TABLE IF EXISTS `apparatus`;
CREATE TABLE `apparatus`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '消防用品id',
  `apparatus_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消防用品名称',
  `model` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '品牌型号',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '进货价格',
  `vendor_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商id',
  `storage_time` datetime(0) NULL DEFAULT NULL COMMENT '入库时间',
  `storage_classify` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放分类',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '存放位置',
  `uin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '唯一标识号',
  `Production_date` datetime(0) NULL DEFAULT NULL COMMENT '生产日期',
  `mtype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护类型',
  `next_m_time` datetime(0) NULL DEFAULT NULL COMMENT '下次维护时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `state` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '是否被领用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apparatus
-- ----------------------------
INSERT INTO `apparatus` VALUES (1, 'AAAAAA', 'AAAAAA', 20.00, '1', '2021-01-29 08:00:00', '4', 'AAAAAA', '767691139480091032', '2021-03-04 18:07:47', '4', '2021-01-12 08:00:00', 'AAAAAA', 1);
INSERT INTO `apparatus` VALUES (2, 'AAAAAA', 'AAAAAA', 20.00, '1', '2021-01-29 00:00:00', '4', 'AAAAAA', '344792419760017047', '2021-02-18 02:36:46', '3', '2021-01-12 00:00:00', 'AAAAAA', 1);
INSERT INTO `apparatus` VALUES (3, 'AAAAAA', 'AAAAAA', 20.00, '1', '2021-01-29 08:00:00', '3', 'AAAAAA', '747123470480043476', '2021-02-19 02:36:55', '5', '2021-01-05 08:00:00', '公司老总', 1);
INSERT INTO `apparatus` VALUES (4, 'AAAAAA', 'AAAAAA', 20.00, '1', '2021-01-29 08:00:00', '3', 'AAAAAA', '72719591616004156', '2021-02-25 02:37:01', '5', '2021-01-06 08:00:00', '公司老总', 1);
INSERT INTO `apparatus` VALUES (5, 'AAAAAA', 'AAAAAA', 20.00, '1', '2021-01-29 00:00:00', '3', 'AAAAAA', '1314110958631003520', '2021-02-24 02:37:08', '2', NULL, '社会人', 0);
INSERT INTO `apparatus` VALUES (6, 'BBBBBB', 'BBBBBB', 10.00, '1', '2021-01-29 08:00:00', '3', 'BBBBBB', '16250544061770017273', '2021-02-17 10:37:14', '4', NULL, 'BBBBBB', 1);

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `dept_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '财务部', '2021-01-29 07:17:50', '财务部财务部');
INSERT INTO `dept` VALUES (2, 'A部', '2021-01-29 07:34:56', 'A部A部');
INSERT INTO `dept` VALUES (3, 'B部', '2021-01-29 07:37:14', 'B部');
INSERT INTO `dept` VALUES (4, 'AAC部', '2021-01-29 07:37:57', 'AAC部');
INSERT INTO `dept` VALUES (5, 'Dd', '2021-01-29 07:38:42', 'DD');

-- ----------------------------
-- Table structure for purview
-- ----------------------------
DROP TABLE IF EXISTS `purview`;
CREATE TABLE `purview`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `roleid` int(0) NOT NULL COMMENT '角色id',
  `askurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跳转路径',
  `menuname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purview
-- ----------------------------
INSERT INTO `purview` VALUES (1, 2, '/purview/list', '权限管理');
INSERT INTO `purview` VALUES (2, 3, '/user/list', '用户管理');
INSERT INTO `purview` VALUES (3, 1, '/user/list', '用户管理');
INSERT INTO `purview` VALUES (4, 1, '/apparatus/list', '消防用品领取');
INSERT INTO `purview` VALUES (5, 2, '/apparatus/list', '消防用品领取');
INSERT INTO `purview` VALUES (8, 1, '/apparatus/saveData', '编辑消防用品');

-- ----------------------------
-- Table structure for receive
-- ----------------------------
DROP TABLE IF EXISTS `receive`;
CREATE TABLE `receive`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `apparatus_id` int(0) NULL DEFAULT NULL COMMENT '领用的消防用品id',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '领用用户id',
  `receive_time` date NULL DEFAULT NULL COMMENT '领用时间',
  `return_time` date NULL DEFAULT NULL COMMENT '约定归还时间',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of receive
-- ----------------------------
INSERT INTO `receive` VALUES (2, 7, 9, '2021-01-20', '2021-01-12', NULL, '公司老总');
INSERT INTO `receive` VALUES (9, 7, 1, '2021-02-01', '2021-02-01', '2021-02-01', '超级管理员领用了BBBBBB');
INSERT INTO `receive` VALUES (10, 2, 1, '2021-02-01', '2021-02-24', '2021-02-01', '超级管理员领用了AAAAAA备注：大萨达萨达');
INSERT INTO `receive` VALUES (11, 6, 1, '2021-02-01', '2021-02-23', '2021-02-01', '超级管理员领用了BBBBBB备注：大萨达萨达');
INSERT INTO `receive` VALUES (12, 2, 44, '2021-02-03', '2021-02-02', '2021-02-03', '社会人');
INSERT INTO `receive` VALUES (13, 1, 43, '2021-02-04', '2021-03-10', '2021-02-04', 'dasda领用了AAAAAA-备注：大萨达萨达');
INSERT INTO `receive` VALUES (14, 3, 43, '2021-02-04', '2021-02-23', '2021-02-04', 'dasda领用了AAAAAA-备注：大萨达萨达');
INSERT INTO `receive` VALUES (15, 4, 43, '2021-02-04', '2021-02-26', '2021-02-04', 'dasda领用了AAAAAA-备注：大萨达萨达');

-- ----------------------------
-- Table structure for restitution
-- ----------------------------
DROP TABLE IF EXISTS `restitution`;
CREATE TABLE `restitution`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `receive_id` int(0) NULL DEFAULT NULL COMMENT '领用id',
  `return_time` date NULL DEFAULT NULL COMMENT '实际归还时间',
  `state` int(0) NULL DEFAULT NULL COMMENT '归还状态',
  `create_time` date NULL DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of restitution
-- ----------------------------
INSERT INTO `restitution` VALUES (2, 9, '2021-02-06', 2, '2021-02-03', '公司总管');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '老板', '公司老总');
INSERT INTO `role` VALUES (2, '主管', '公司总管');
INSERT INTO `role` VALUES (3, '员工', '社会人');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `dept_id` int(0) NULL DEFAULT NULL COMMENT '部门id',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `employee_id` int(0) NULL DEFAULT NULL COMMENT '员工编号',
  `Login_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `mobile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '超级管理员', 1, 1, 1, 'admin', '123123', '111', '1111');
INSERT INTO `user` VALUES (43, 'dasda', 2, 1, 1111, 'bbbbbb', 'bbbbbb', '12313213132131', '969841502');
INSERT INTO `user` VALUES (44, '的撒大大', 5, 1, 1111, 'aaaaaa', 'dsad', '12313213132131', '969841502');
INSERT INTO `user` VALUES (45, '的撒大大', 1, 2, 132132, 'bbbbb', 'dsadsad', '12313213132131', '969841502');

-- ----------------------------
-- Table structure for vendor
-- ----------------------------
DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `vendor_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `vendor_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vendor
-- ----------------------------
INSERT INTO `vendor` VALUES (1, 'AA', '北京', '张三', '11110000000', '公司老啊大大');

SET FOREIGN_KEY_CHECKS = 1;

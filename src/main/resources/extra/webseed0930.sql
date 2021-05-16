/*
 Navicat MySQL Data Transfer

 Source Server         : 118.24.155.154
 Source Server Type    : MySQL
 Source Server Version : 50626
 Source Host           : 118.24.155.154:3306
 Source Schema         : webseed

 Target Server Type    : MySQL
 Target Server Version : 50626
 File Encoding         : 65001

 Date: 30/09/2018 15:19:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_admin
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin`;
CREATE TABLE `tbl_admin`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_status` int(11) NULL DEFAULT NULL COMMENT '-1：删除，0：正常，1冻结',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nick_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_admin
-- ----------------------------
INSERT INTO `tbl_admin` VALUES (5, '123', 'd94da04e5edfbafc1578cbfda466c52d', 'cd4eed40d4aa1acff9c59c1de4b378d5', 0, 't', NULL, '2018-09-28 10:32:23', '2018-09-28 10:32:23', '2018-08-28 04:15:47');
INSERT INTO `tbl_admin` VALUES (8, '13', 'd94da04e5edfbafc1578cbfda466c52d', 'cd4eed40d4aa1acff9c59c1de4b378d5', 0, NULL, NULL, NULL, NULL, '2018-08-28 23:00:48');
INSERT INTO `tbl_admin` VALUES (9, '132', '29633edecfdb065705dee3faa8e0f439', '30401ae3d1fd58812b9206d0c1d837cb', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:04:03');
INSERT INTO `tbl_admin` VALUES (10, '1322', '399692a59eb93cf3025864ee12f5b2a5', '57689460f8cdb70845c206fa6e088b3f', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:04:31');
INSERT INTO `tbl_admin` VALUES (15, '1321', 'b7220c4e98ac07458dae778c2e4efe7f', 'a32d19a010321dba628f5cfcd7a12ab8', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:03');
INSERT INTO `tbl_admin` VALUES (16, '1323', 'dc1db68407897cfea5dd0f3aecad740f', '95191b75a10d43d30cccecf3e56fadc4', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:07');
INSERT INTO `tbl_admin` VALUES (17, '1324', '57c24758ca688b5fd7d6a337e3d4d9c9', 'a891ac04e1bf31512570a6a8c0de6afd', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:09');
INSERT INTO `tbl_admin` VALUES (18, '1325', '4a0ff2c4d3ef4130e848374dae975201', '320cd335ac5c9ff17c0e2f2a4ecbcafc', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:11');
INSERT INTO `tbl_admin` VALUES (19, '1326', 'e462b4bf25b9808ef99d5a303d901d5f', 'd1f93b69409aa1502435454eb0849d7a', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:14');
INSERT INTO `tbl_admin` VALUES (20, '1327', 'b97b20a4924df193adfa05530ac9f5d2', '27ec80a52193be3726a709f2a71b7247', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:15');
INSERT INTO `tbl_admin` VALUES (21, '1328', 'f056afdee00988fadd4a34ee155e376e', 'fe9e8e0c74105ab1cf25f42d2e829824', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:18');
INSERT INTO `tbl_admin` VALUES (22, '1329', '0d78464a993ad405b2a456f1ebedbfd0', '9fa8fcc8b18a612218ca4b9efeb0a08d', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:20');
INSERT INTO `tbl_admin` VALUES (23, '1320', '63d221689d05c58ab8122f742e1dfdf1', '328c47435a12a56afc08c1084897927a', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:22');
INSERT INTO `tbl_admin` VALUES (24, '1331', '980b875f9d5b796e5f31283bd29a545a', '10ca1f8e879f0eb8da7d87c87a9d8b25', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:27');
INSERT INTO `tbl_admin` VALUES (25, '1332', '18e2a1d0fccc1aa8dd0048f768fca866', 'f989fb1f14848d23edace567333a8c34', 0, NULL, NULL, NULL, NULL, '2018-08-29 02:57:29');
INSERT INTO `tbl_admin` VALUES (26, '1333', '64adb6f34f60e9ee5b6eea17c9b342d5', '140f123cd8d15f0d847cedb25ff3da27', -1, NULL, NULL, NULL, NULL, '2018-08-29 02:57:31');
INSERT INTO `tbl_admin` VALUES (27, '1234', '2865a46e8faa9410be7374d15d2006aa', '17fc876ee3ba431b6e071beab514ede9', 0, '13266665555', NULL, '2018-09-05 01:17:15', '2018-09-05 01:17:15', '2018-08-29 02:57:33');
INSERT INTO `tbl_admin` VALUES (28, '1238', '5273dbf9cdd78932a1b26fe8c3202a8f', 'e32f8801704d3356449f1e202831feb0', 0, '12233333333', NULL, NULL, '2018-09-11 04:28:16', '2018-09-11 04:28:16');
INSERT INTO `tbl_admin` VALUES (29, '1324', '055f454563632e2d08bb7fee0abfe55a', 'd773d4c9d542c01811e4507ab8760939', 0, '12122223333', NULL, NULL, '2018-09-11 04:37:00', '2018-09-11 04:37:00');

-- ----------------------------
-- Table structure for tbl_device
-- ----------------------------
DROP TABLE IF EXISTS `tbl_device`;
CREATE TABLE `tbl_device`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_status` int(11) NULL DEFAULT 0 COMMENT '-1：删除，0：正常，1：冻结',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `online` int(11) NULL DEFAULT 0 COMMENT '0：离线，1：在线，2：故障',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `fk_merchant_id` bigint(20) NULL DEFAULT 0 COMMENT '所在商家名字',
  `fk_type_id` bigint(255) NULL DEFAULT NULL COMMENT '设备型号',
  `offline_time` datetime(0) NULL DEFAULT NULL COMMENT '离线时间',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_device
-- ----------------------------
INSERT INTO `tbl_device` VALUES (3, 'fgdf', 'dfsd', -1, '2018-09-05 22:59:15', '2018-09-05 22:59:15', 0, 'sdfsfsdfs', 'sdfsf', 0, NULL, NULL);
INSERT INTO `tbl_device` VALUES (4, 'fgdfdd', 'dfsd', -1, '2018-09-05 22:59:20', '2018-09-05 22:59:20', 0, 'sdfsfsdfs', 'sdfsf', 0, NULL, NULL);
INSERT INTO `tbl_device` VALUES (5, 'sds', 'sdf', -1, '2018-09-05 22:59:45', '2018-09-05 22:59:45', 0, 'sdf', 'sfd', 0, NULL, NULL);
INSERT INTO `tbl_device` VALUES (6, 'sdssdf', 'sdfd', -1, '2018-09-05 22:59:48', '2018-09-05 22:59:48', 0, 'sdf', 'sfd', 0, NULL, NULL);
INSERT INTO `tbl_device` VALUES (7, 'sdssdfd', 'sdfd', -1, '2018-09-05 22:59:51', '2018-09-05 22:59:51', 0, 'sdf', 'sfd', 0, NULL, NULL);
INSERT INTO `tbl_device` VALUES (8, 'sdssdfda', 'sdfd', 0, '2018-09-05 22:59:53', '2018-09-05 22:59:53', 0, 'sdf', 'sfd', 0, NULL, NULL);
INSERT INTO `tbl_device` VALUES (9, 'sfds', 's', 0, '2018-09-05 23:10:39', '2018-09-05 23:10:39', 0, 'd', 's', 0, NULL, NULL);
INSERT INTO `tbl_device` VALUES (10, 'ddv', 'sd', -1, '2018-09-05 23:10:45', '2018-09-05 23:10:45', 0, 'd', 'sd', 0, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_member
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member`;
CREATE TABLE `tbl_member`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `salt` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `data_status` int(11) NULL DEFAULT NULL COMMENT '-1：删除，0：正常，1冻结',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信用户的唯一标识',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `last_login_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `head_img_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `union_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_member
-- ----------------------------
INSERT INTO `tbl_member` VALUES (8, NULL, NULL, NULL, 0, NULL, 'ozqVc0XoaxqBv_QHCHuPOGJK7KwQ', '小钊', '2018-09-10 04:46:41', '2018-09-10 04:46:41', '2018-09-10 04:46:40', NULL, NULL);
INSERT INTO `tbl_member` VALUES (10, NULL, NULL, NULL, 0, NULL, 'ozqVc0VzImLHzu_NGlk_siyBH83U', '李晓', '2018-09-30 01:52:00', '2018-09-30 01:52:00', '2018-09-29 08:52:17', NULL, NULL);
INSERT INTO `tbl_member` VALUES (11, NULL, NULL, NULL, 0, NULL, '2088702456218319', '晓', '2018-09-30 01:56:55', '2018-09-30 01:56:55', '2018-09-30 01:56:53', NULL, NULL);

-- ----------------------------
-- Table structure for tbl_member_plus
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member_plus`;
CREATE TABLE `tbl_member_plus`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_member_id` bigint(20) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `language` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL,
  `city` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信普通用户个人资料填写的城市',
  `sex` int(11) NULL DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `province` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信用户个人资料填写的省份',
  `country` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信国家，如中国为CN',
  `privilege` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_member_plus
-- ----------------------------
INSERT INTO `tbl_member_plus` VALUES (3, 8, '2018-09-10 04:46:40', '2018-09-10 04:46:40', 'zh_CN', '', 0, '', '', '[]');
INSERT INTO `tbl_member_plus` VALUES (5, 10, '2018-09-29 08:52:17', '2018-09-29 08:52:17', 'zh_CN', '深圳', 1, '广东', '中国', '[]');
INSERT INTO `tbl_member_plus` VALUES (6, 11, '2018-09-30 01:56:53', '2018-09-30 01:56:53', NULL, '深圳市', NULL, '广东省', NULL, NULL);

-- ----------------------------
-- Table structure for tbl_merchant
-- ----------------------------
DROP TABLE IF EXISTS `tbl_merchant`;
CREATE TABLE `tbl_merchant`  (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商家名称',
  `data_status` int(36) NULL DEFAULT NULL COMMENT '-1：删除，0：未上架，1：上架',
  `address` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家地址',
  `contact` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '电话',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `device_count` int(30) NULL DEFAULT NULL COMMENT '设备数量',
  `bonus_cal_type` int(255) NULL DEFAULT NULL COMMENT '提成计算方式',
  `bonus_ratio` double(255, 0) NULL DEFAULT NULL COMMENT '提成系数',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_order
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE `tbl_order`  (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `total_fee` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额（元）',
  `pay_fee` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付金额（元）',
  `data_status` int(36) NULL DEFAULT NULL,
  `order_status` int(11) NULL DEFAULT NULL COMMENT '0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `fk_pay_id` bigint(36) NOT NULL COMMENT '支付记录id',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `fk_member_id` bigint(36) NOT NULL COMMENT '订单发起者id',
  `fk_item_id` bigint(36) NOT NULL COMMENT '商品id',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_pay_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_pay_record`;
CREATE TABLE `tbl_pay_record`  (
  `pk_id` bigint(36) NOT NULL,
  `out_trade_no` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。',
  `total_fee` decimal(10, 2) NULL DEFAULT NULL,
  `pay_way` int(11) NULL DEFAULT NULL COMMENT '0为微信支付，1为支付宝支付',
  `pay_status` int(11) NULL DEFAULT NULL COMMENT '0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭',
  `pay_time` datetime(0) NULL DEFAULT NULL,
  `attach` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `data_status` int(36) NULL DEFAULT NULL,
  `fk_order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tbl_product
-- ----------------------------
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE `tbl_product`  (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品名称',
  `title` varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品标题',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格（元）',
  `data_status` int(36) NULL DEFAULT NULL COMMENT '-1：删除，0：未上架，1：上架',
  `item_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品描述',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `pic_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '商品图片链接',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_product
-- ----------------------------
INSERT INTO `tbl_product` VALUES (1, '11111', '1111', 1.00, 0, '111111', '2018-09-12 03:30:13', '2018-09-12 03:30:13', '1111111', NULL);
INSERT INTO `tbl_product` VALUES (2, 'sdfsd', 'ddfsdf', 0.14, 0, 'sdf', '2018-09-12 03:54:54', '2018-09-12 03:54:54', 'sd', NULL);

SET FOREIGN_KEY_CHECKS = 1;

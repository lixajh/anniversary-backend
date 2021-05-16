/*
Navicat MySQL Data Transfer

Source Server         : 118.24.155.154
Source Server Version : 50626
Source Host           : 118.24.155.154:3306
Source Database       : webseed

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2018-10-14 13:32:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_admin
-- ----------------------------
DROP TABLE IF EXISTS `tbl_admin`;
CREATE TABLE `tbl_admin` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `data_status` int(11) DEFAULT NULL COMMENT '-1：删除，0：正常，1冻结',
  `phone` varchar(20) DEFAULT NULL,
  `nick_name` varchar(30) DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tbl_admin
-- ----------------------------
INSERT INTO `tbl_admin` VALUES ('5', '123', 'd94da04e5edfbafc1578cbfda466c52d', 'cd4eed40d4aa1acff9c59c1de4b378d5', '0', 't', null, '2018-10-09 09:01:04', '2018-10-09 09:01:04', '2018-08-28 04:15:47');
INSERT INTO `tbl_admin` VALUES ('8', '13', 'd94da04e5edfbafc1578cbfda466c52d', 'cd4eed40d4aa1acff9c59c1de4b378d5', '0', null, null, null, null, '2018-08-28 23:00:48');
INSERT INTO `tbl_admin` VALUES ('9', '132', '29633edecfdb065705dee3faa8e0f439', '30401ae3d1fd58812b9206d0c1d837cb', '0', null, null, null, null, '2018-08-29 02:04:03');
INSERT INTO `tbl_admin` VALUES ('10', '1322', '399692a59eb93cf3025864ee12f5b2a5', '57689460f8cdb70845c206fa6e088b3f', '-1', null, null, null, null, '2018-08-29 02:04:31');
INSERT INTO `tbl_admin` VALUES ('15', '1321', 'b7220c4e98ac07458dae778c2e4efe7f', 'a32d19a010321dba628f5cfcd7a12ab8', '-1', null, null, null, null, '2018-08-29 02:57:03');
INSERT INTO `tbl_admin` VALUES ('16', '1323', 'dc1db68407897cfea5dd0f3aecad740f', '95191b75a10d43d30cccecf3e56fadc4', '0', null, null, null, null, '2018-08-29 02:57:07');
INSERT INTO `tbl_admin` VALUES ('17', '1324', '57c24758ca688b5fd7d6a337e3d4d9c9', 'a891ac04e1bf31512570a6a8c0de6afd', '-1', null, null, null, null, '2018-08-29 02:57:09');
INSERT INTO `tbl_admin` VALUES ('18', '1325', '4a0ff2c4d3ef4130e848374dae975201', '320cd335ac5c9ff17c0e2f2a4ecbcafc', '-1', null, null, null, null, '2018-08-29 02:57:11');
INSERT INTO `tbl_admin` VALUES ('19', '1326', 'e462b4bf25b9808ef99d5a303d901d5f', 'd1f93b69409aa1502435454eb0849d7a', '-1', null, null, null, null, '2018-08-29 02:57:14');
INSERT INTO `tbl_admin` VALUES ('20', '1327', 'b97b20a4924df193adfa05530ac9f5d2', '27ec80a52193be3726a709f2a71b7247', '-1', null, null, null, null, '2018-08-29 02:57:15');
INSERT INTO `tbl_admin` VALUES ('21', '1328', 'f056afdee00988fadd4a34ee155e376e', 'fe9e8e0c74105ab1cf25f42d2e829824', '-1', null, null, null, null, '2018-08-29 02:57:18');
INSERT INTO `tbl_admin` VALUES ('22', '1329', '0d78464a993ad405b2a456f1ebedbfd0', '9fa8fcc8b18a612218ca4b9efeb0a08d', '0', null, null, null, null, '2018-08-29 02:57:20');
INSERT INTO `tbl_admin` VALUES ('23', '1320', '63d221689d05c58ab8122f742e1dfdf1', '328c47435a12a56afc08c1084897927a', '-1', null, null, null, null, '2018-08-29 02:57:22');
INSERT INTO `tbl_admin` VALUES ('24', '1331', '980b875f9d5b796e5f31283bd29a545a', '10ca1f8e879f0eb8da7d87c87a9d8b25', '-1', null, null, null, null, '2018-08-29 02:57:27');
INSERT INTO `tbl_admin` VALUES ('25', '1332', '18e2a1d0fccc1aa8dd0048f768fca866', 'f989fb1f14848d23edace567333a8c34', '0', null, null, null, null, '2018-08-29 02:57:29');
INSERT INTO `tbl_admin` VALUES ('26', '1333', '64adb6f34f60e9ee5b6eea17c9b342d5', '140f123cd8d15f0d847cedb25ff3da27', '-1', null, null, null, null, '2018-08-29 02:57:31');
INSERT INTO `tbl_admin` VALUES ('27', '1234', '2865a46e8faa9410be7374d15d2006aa', '17fc876ee3ba431b6e071beab514ede9', '0', '13266665555', null, '2018-09-05 01:17:15', '2018-09-05 01:17:15', '2018-08-29 02:57:33');
INSERT INTO `tbl_admin` VALUES ('28', '1238', '5273dbf9cdd78932a1b26fe8c3202a8f', 'e32f8801704d3356449f1e202831feb0', '0', '12233333333', null, null, '2018-09-11 04:28:16', '2018-09-11 04:28:16');
INSERT INTO `tbl_admin` VALUES ('29', '1324', '055f454563632e2d08bb7fee0abfe55a', 'd773d4c9d542c01811e4507ab8760939', '0', '12122223333', null, null, '2018-09-11 04:37:00', '2018-09-11 04:37:00');
INSERT INTO `tbl_admin` VALUES ('30', 'zhang_', 'dae454b3a1c76a8ca624afdc9286acde', 'd3eccf5c4d48f82d34cacdecee84073b', '0', '13122223333', null, null, '2018-10-09 07:49:36', '2018-10-09 07:49:36');
INSERT INTO `tbl_admin` VALUES ('31', 'zhang_1', '7a4d08b5daee1bcc9cb16a24f221dfcf', 'bd634fcf1aa39143c9d50582f2c6b434', '0', '13311112222', null, null, '2018-10-09 07:54:20', '2018-10-09 07:51:28');

-- ----------------------------
-- Table structure for tbl_device
-- ----------------------------
DROP TABLE IF EXISTS `tbl_device`;
CREATE TABLE `tbl_device` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `code` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `data_status` int(11) DEFAULT '0' COMMENT '-1：删除，0：正常，1：冻结',
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `online` int(11) DEFAULT '0' COMMENT '0：离线，1：在线，2：故障',
  `remark` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `address` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `fk_merchant_id` bigint(20) DEFAULT '0' COMMENT '所在商家id',
  `fk_type_id` bigint(255) DEFAULT NULL COMMENT '设备型号',
  `offline_time` datetime DEFAULT NULL COMMENT '离线时间',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_device
-- ----------------------------
INSERT INTO `tbl_device` VALUES ('3', 'fgdf', 'dfsd', '-1', '2018-09-05 22:59:15', '2018-09-05 22:59:15', '0', 'sdfsfsdfs', 'sdfsf', '0', null, null);
INSERT INTO `tbl_device` VALUES ('4', 'fgdfdd', 'dfsd', '-1', '2018-09-05 22:59:20', '2018-09-05 22:59:20', '0', 'sdfsfsdfs', 'sdfsf', '0', null, null);
INSERT INTO `tbl_device` VALUES ('5', 'sds', 'sdf', '-1', '2018-09-05 22:59:45', '2018-09-05 22:59:45', '0', 'sdf', 'sfd', '0', null, null);
INSERT INTO `tbl_device` VALUES ('6', 'sdssdf', 'sdfd', '-1', '2018-09-05 22:59:48', '2018-09-05 22:59:48', '0', 'sdf', 'sfd', '0', null, null);
INSERT INTO `tbl_device` VALUES ('7', 'sdssdfd', 'sdfd', '-1', '2018-09-05 22:59:51', '2018-09-05 22:59:51', '0', 'sdf', 'sfd', '0', null, null);
INSERT INTO `tbl_device` VALUES ('8', 'sdssdfda', 'sdfd', '0', '2018-09-05 22:59:53', '2018-09-05 22:59:53', '0', 'sdf', 'sfd', '1', '0', null);
INSERT INTO `tbl_device` VALUES ('9', 'sfds', 's', '0', '2018-09-05 11:10:39', '2018-09-05 11:10:39', '0', 'd', 's', '2', '0', null);
INSERT INTO `tbl_device` VALUES ('10', 'ddv', 'sd', '-1', '2018-09-05 23:10:45', '2018-09-05 23:10:45', '0', 'd', 'sd', '0', null, null);

-- ----------------------------
-- Table structure for tbl_member
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member`;
CREATE TABLE `tbl_member` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `salt` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `data_status` int(11) DEFAULT NULL COMMENT '-1：删除，0：正常，1冻结',
  `phone` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `open_id` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信用户的唯一标识',
  `nickname` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `head_img_url` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL,
  `union_id` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_member
-- ----------------------------
INSERT INTO `tbl_member` VALUES ('8', null, null, null, '0', null, 'ozqVc0XoaxqBv_QHCHuPOGJK7KwQ', '小钊', '2018-10-09 07:58:03', '2018-10-09 07:58:03', '2018-09-10 04:46:40', null, null);
INSERT INTO `tbl_member` VALUES ('10', null, null, null, '0', null, 'ozqVc0VzImLHzu_NGlk_siyBH83U', '李晓', '2018-10-09 08:17:04', '2018-10-09 08:17:04', '2018-09-29 08:52:17', null, null);
INSERT INTO `tbl_member` VALUES ('11', null, null, null, '0', null, '2088702456218319', '晓', '2018-10-08 21:10:33', '2018-10-08 21:10:33', '2018-09-30 01:56:53', null, null);
INSERT INTO `tbl_member` VALUES ('12', null, null, null, '0', null, 'ozqVc0Z35EpF8twgmFvIL16Jx6TM', 'Terry', '2018-10-09 08:16:41', '2018-10-09 08:16:41', '2018-10-09 08:16:40', null, null);

-- ----------------------------
-- Table structure for tbl_member_plus
-- ----------------------------
DROP TABLE IF EXISTS `tbl_member_plus`;
CREATE TABLE `tbl_member_plus` (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fk_member_id` bigint(20) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `language` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `city` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信普通用户个人资料填写的城市',
  `sex` int(11) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `province` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信用户个人资料填写的省份',
  `country` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信国家，如中国为CN',
  `privilege` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '微信用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_member_plus
-- ----------------------------
INSERT INTO `tbl_member_plus` VALUES ('3', '8', '2018-09-10 04:46:40', '2018-09-10 04:46:40', 'zh_CN', '', '0', '', '', '[]');
INSERT INTO `tbl_member_plus` VALUES ('5', '10', '2018-09-29 08:52:17', '2018-09-29 08:52:17', 'zh_CN', '深圳', '1', '广东', '中国', '[]');
INSERT INTO `tbl_member_plus` VALUES ('6', '11', '2018-09-30 01:56:53', '2018-09-30 01:56:53', null, '深圳市', null, '广东省', null, null);
INSERT INTO `tbl_member_plus` VALUES ('7', '12', '2018-10-09 08:16:40', '2018-10-09 08:16:40', 'zh_CN', '', '1', '', '贝宁', '[]');

-- ----------------------------
-- Table structure for tbl_merchant
-- ----------------------------
DROP TABLE IF EXISTS `tbl_merchant`;
CREATE TABLE `tbl_merchant` (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商家名称',
  `data_status` int(36) DEFAULT NULL COMMENT '-1：删除，0：未上架，1：上架',
  `address` varchar(200) CHARACTER SET utf8 DEFAULT NULL COMMENT '商家地址',
  `contact` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系人',
  `phone` varchar(30) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电话',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `device_count` int(30) DEFAULT NULL COMMENT '设备数量',
  `bonus_cal_type` int(255) DEFAULT NULL COMMENT '提成计算方式',
  `bonus_ratio` double(255,0) DEFAULT NULL COMMENT '提成系数',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_merchant
-- ----------------------------
INSERT INTO `tbl_merchant` VALUES ('1', '12345', '0', 'sdf', 'sdfsdf', '18520827756', '2018-09-30 02:53:23', '2018-09-30 02:53:23', null, null, null, 'ffd');
INSERT INTO `tbl_merchant` VALUES ('2', '1212', '0', 'sdfsd', '212w', '18520827725', '2018-09-30 04:22:59', '2018-09-30 04:22:59', null, null, null, 'dfsdff');

-- ----------------------------
-- Table structure for tbl_merchant_chart
-- ----------------------------
DROP TABLE IF EXISTS `tbl_merchant_chart`;
CREATE TABLE `tbl_merchant_chart` (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '报表名称 xx年xx月xx商家销售报表',
  `data_status` int(36) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL COMMENT '报表统计开始日期',
  `end_date` datetime DEFAULT NULL COMMENT '报表统计结束时间',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `order_count` int(30) DEFAULT NULL COMMENT '订单数量',
  `bonus_cal_type` int(255) DEFAULT NULL COMMENT '提成计算方式',
  `bonus_ratio` double(255,0) DEFAULT NULL COMMENT '提成系数',
  `total_amount` decimal(30,0) DEFAULT NULL COMMENT '总交易额',
  `pay_amount` decimal(30,0) DEFAULT NULL COMMENT '实际支付总额',
  `cal_bonus` decimal(30,0) DEFAULT NULL COMMENT '计算提成',
  `real_bonus` decimal(30,0) DEFAULT NULL COMMENT '实际提成',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `fk_merchant_id` bigint(20) DEFAULT NULL COMMENT '商家id',
  `year` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '年',
  `month` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '月',
  `type` int(255) DEFAULT NULL COMMENT '报表类型 1:月报表',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_merchant_chart
-- ----------------------------
INSERT INTO `tbl_merchant_chart` VALUES ('4', '12122018年10月销售报表', '0', '2018-09-30 11:00:00', '2018-10-31 11:00:00', '2018-10-11 01:04:15', '2018-10-11 01:04:15', '0', null, null, null, null, null, '0', null, '2', '2018', '10', '1');
INSERT INTO `tbl_merchant_chart` VALUES ('5', '123452018年10月销售报表', '0', '2018-09-30 11:00:00', '2018-10-31 11:00:00', '2018-10-11 01:04:16', '2018-10-11 01:04:16', '3', null, null, '0', '0', null, '0', null, '1', '2018', '10', '1');

-- ----------------------------
-- Table structure for tbl_order
-- ----------------------------
DROP TABLE IF EXISTS `tbl_order`;
CREATE TABLE `tbl_order` (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '订单号',
  `total_fee` decimal(10,2) DEFAULT NULL COMMENT '总金额（元）',
  `pay_fee` decimal(10,2) DEFAULT NULL COMMENT '实付金额（元）',
  `data_status` int(36) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL COMMENT '0:待支付，1支付成功，2支付失败,3设备工作中，4设备故障，5完成',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `fk_pay_id` bigint(36) DEFAULT NULL COMMENT '支付记录id',
  `remark` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `fk_member_id` bigint(36) DEFAULT NULL COMMENT '订单发起者id',
  `fk_product_id` bigint(36) DEFAULT NULL COMMENT '商品id',
  `fk_merchant_id` bigint(36) DEFAULT NULL COMMENT '商家id',
  `fk_device_id` bigint(36) DEFAULT NULL COMMENT '设备id',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_order
-- ----------------------------
INSERT INTO `tbl_order` VALUES ('1', '181008134154038804317', '0.14', '0.14', '0', '0', '2018-10-08 00:41:54', '2018-10-08 00:41:54', null, null, '10', '2', '1', '8');
INSERT INTO `tbl_order` VALUES ('2', '181008134618659122205', '0.14', '0.14', '0', '0', '2018-10-08 00:46:19', '2018-10-08 00:46:19', null, null, '11', '2', '1', '8');
INSERT INTO `tbl_order` VALUES ('4', '181008141204498452545', '0.14', '0.14', '0', '0', '2018-10-08 01:12:04', '2018-10-08 01:12:04', null, null, '11', '2', '1', '8');
INSERT INTO `tbl_order` VALUES ('5', '181008153030239900852', '1.00', '1.00', '0', '0', '2018-10-08 02:30:30', '2018-10-08 02:30:30', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('6', '181008153042393819099', '1.00', '1.00', '0', '0', '2018-10-08 02:30:42', '2018-10-08 02:30:42', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('7', '181008153043665626592', '1.00', '1.00', '0', '0', '2018-10-08 02:30:44', '2018-10-08 02:30:44', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('8', '181008153253485142951', '1.00', '1.00', '0', '0', '2018-10-08 02:32:53', '2018-10-08 02:32:53', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('9', '181008153356680985155', '1.00', '1.00', '0', '0', '2018-10-08 02:33:57', '2018-10-08 02:33:57', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('10', '181008153400384894166', '1.00', '1.00', '0', '0', '2018-10-08 02:34:00', '2018-10-08 02:34:00', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('11', '181008153445143088440', '1.00', '1.00', '0', '0', '2018-10-08 02:34:45', '2018-10-08 02:34:45', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('12', '181008153549814930644', '1.00', '1.00', '0', '0', '2018-10-08 02:35:50', '2018-10-08 02:35:50', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('13', '181008153553099572765', '1.00', '1.00', '0', '0', '2018-10-08 02:35:53', '2018-10-08 02:35:53', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('14', '181008153653453482699', '1.00', '1.00', '0', '0', '2018-10-08 02:36:53', '2018-10-08 02:36:53', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('15', '181008153734384795352', '1.00', '1.00', '0', '0', '2018-10-08 02:37:34', '2018-10-08 02:37:34', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('16', '181008153818725262273', '1.00', '1.00', '0', '0', '2018-10-08 02:38:19', '2018-10-08 02:38:19', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('17', '181008211359139350434', '0.01', '0.01', '0', '0', '2018-10-08 08:13:59', '2018-10-08 08:13:59', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('18', '181009101144494011727', '0.01', '0.01', '0', '1', '2018-10-08 21:11:44', '2018-10-08 21:25:48', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('19', '181009101506240942624', '0.01', '0.01', '0', '1', '2018-10-08 21:15:06', '2018-10-08 21:19:50', null, null, '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('20', '181009101719117830962', '0.01', '0.01', '0', '1', '2018-10-08 21:17:19', '2018-10-09 07:24:21', null, 'sss23', '11', '1', '1', '8');
INSERT INTO `tbl_order` VALUES ('21', '181009103038549364031', '0.01', '0.01', '0', '0', '2018-10-08 21:30:39', '2018-10-08 21:30:39', null, null, '11', '1', '1', '8');

-- ----------------------------
-- Table structure for tbl_pay_record
-- ----------------------------
DROP TABLE IF EXISTS `tbl_pay_record`;
CREATE TABLE `tbl_pay_record` (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `out_trade_no` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。',
  `transaction_no` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '第三方支付号',
  `total_fee` decimal(10,2) DEFAULT NULL,
  `pay_way` int(11) DEFAULT NULL COMMENT '0为微信支付，1为支付宝支付',
  `pay_status` int(11) DEFAULT NULL COMMENT '0:待支付，1支付成功，2支付失败，3支付超时，4支付取消,5交易不存在 ，6交易关闭',
  `pay_time` datetime DEFAULT NULL,
  `attach` varchar(1000) CHARACTER SET utf8 DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `data_status` int(36) DEFAULT NULL,
  `fk_order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_pay_record
-- ----------------------------
INSERT INTO `tbl_pay_record` VALUES ('1', '181008141204498452545', '2018100822001418310586210770', '0.14', '2', '0', null, '', '2018-10-08 01:12:05', '2018-10-08 01:12:05', '0', '4');
INSERT INTO `tbl_pay_record` VALUES ('2', '181008153030239900852', '2018100822001418310586712553', '1.00', '2', '0', null, '', '2018-10-08 02:30:30', '2018-10-08 02:30:30', '0', '5');
INSERT INTO `tbl_pay_record` VALUES ('3', '181008153042393819099', '2018100822001418310586343151', '1.00', '2', '0', null, '', '2018-10-08 02:30:42', '2018-10-08 02:30:42', '0', '6');
INSERT INTO `tbl_pay_record` VALUES ('4', '181008153043665626592', '2018100822001418310586361684', '1.00', '2', '0', null, '', '2018-10-08 02:30:44', '2018-10-08 02:30:44', '0', '7');
INSERT INTO `tbl_pay_record` VALUES ('5', '181008153253485142951', '2018100822001418310586457565', '1.00', '2', '0', null, '', '2018-10-08 02:32:54', '2018-10-08 02:32:54', '0', '8');
INSERT INTO `tbl_pay_record` VALUES ('6', '181008153356680985155', '2018100822001418310586816202', '1.00', '2', '0', null, '', '2018-10-08 02:33:57', '2018-10-08 02:33:57', '0', '9');
INSERT INTO `tbl_pay_record` VALUES ('7', '181008153400384894166', '2018100822001418310585989399', '1.00', '2', '0', null, '', '2018-10-08 02:34:00', '2018-10-08 02:34:00', '0', '10');
INSERT INTO `tbl_pay_record` VALUES ('8', '181008153445143088440', '2018100822001418310586816240', '1.00', '2', '0', null, '', '2018-10-08 02:34:45', '2018-10-08 02:34:45', '0', '11');
INSERT INTO `tbl_pay_record` VALUES ('9', '181008153549814930644', '2018100822001418310586779605', '1.00', '2', '0', null, '', '2018-10-08 02:35:50', '2018-10-08 02:35:50', '0', '12');
INSERT INTO `tbl_pay_record` VALUES ('10', '181008153553099572765', '2018100822001418310586731251', '1.00', '2', '0', null, '', '2018-10-08 02:35:53', '2018-10-08 02:35:53', '0', '13');
INSERT INTO `tbl_pay_record` VALUES ('11', '181008153653453482699', '2018100822001418310586497242', '1.00', '2', '0', null, '', '2018-10-08 02:36:54', '2018-10-08 02:36:54', '0', '14');
INSERT INTO `tbl_pay_record` VALUES ('12', '181008153734384795352', '2018100822001418310586483210', '1.00', '2', '0', null, '', '2018-10-08 02:37:34', '2018-10-08 02:37:34', '0', '15');
INSERT INTO `tbl_pay_record` VALUES ('13', '181008153818725262273', '2018100822001418310587124112', '1.00', '2', '0', null, '', '2018-10-08 02:38:19', '2018-10-08 02:38:19', '0', '16');
INSERT INTO `tbl_pay_record` VALUES ('14', '181008211359139350434', '2018100822001418310588029257', '0.01', '2', '0', null, '', '2018-10-08 08:13:59', '2018-10-08 08:13:59', '0', '17');
INSERT INTO `tbl_pay_record` VALUES ('15', '181009101144494011727', '2018100922001418310589991559', '0.01', '2', '1', '2018-10-08 21:25:48', '', '2018-10-08 21:11:45', '2018-10-08 21:25:48', '0', '18');
INSERT INTO `tbl_pay_record` VALUES ('16', '181009101506240942624', '2018100922001418310589775301', '0.01', '2', '1', '2018-10-08 21:19:50', '', '2018-10-08 21:15:06', '2018-10-08 21:19:50', '0', '19');
INSERT INTO `tbl_pay_record` VALUES ('17', '181009101719117830962', '2018100922001418310590103727', '0.01', '2', '1', '2018-10-08 21:17:35', '', '2018-10-08 21:17:19', '2018-10-08 21:17:35', '0', '20');
INSERT INTO `tbl_pay_record` VALUES ('18', '181009103038549364031', '2018100922001418310590964671', '0.01', '2', '0', null, '', '2018-10-08 21:30:39', '2018-10-08 21:30:39', '0', '21');

-- ----------------------------
-- Table structure for tbl_product
-- ----------------------------
DROP TABLE IF EXISTS `tbl_product`;
CREATE TABLE `tbl_product` (
  `pk_id` bigint(36) NOT NULL AUTO_INCREMENT,
  `name` varchar(36) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品名称',
  `title` varchar(36) CHARACTER SET utf8 DEFAULT NULL COMMENT '商品标题',
  `price` decimal(10,2) DEFAULT NULL COMMENT '价格（元）',
  `data_status` int(36) DEFAULT NULL COMMENT '-1：删除，0：未上架，1：上架',
  `item_desc` varchar(500) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品描述',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `remark` varchar(500) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `pic_url` varchar(200) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '商品图片链接',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- ----------------------------
-- Records of tbl_product
-- ----------------------------
INSERT INTO `tbl_product` VALUES ('1', '11111', '1111', '0.01', '1', '111111', '2018-09-12 03:30:13', '2018-09-12 03:30:13', '1111111', null);
INSERT INTO `tbl_product` VALUES ('2', 'sdfsd', 'ddfsdf', '0.14', '1', 'sdf', '2018-09-12 03:54:54', '2018-09-12 03:54:54', 'sd', null);

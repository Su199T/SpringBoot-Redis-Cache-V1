/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : jubaopeng

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-04-27 15:06:39
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `log_bonus`
-- ----------------------------
DROP TABLE IF EXISTS `log_bonus`;
CREATE TABLE `log_bonus` (
  `log_bonus_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `bonus` double(20,0) NOT NULL DEFAULT '0' COMMENT '分红值',
  `type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '类型 1分红碗分红 2碎片分红',
  `status` tinyint(4) DEFAULT '0' COMMENT '状态 0未提现 1已提现',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_bonus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of log_bonus
-- ----------------------------

-- ----------------------------
-- Table structure for `log_exchange`
-- ----------------------------
DROP TABLE IF EXISTS `log_exchange`;
CREATE TABLE `log_exchange` (
  `log_exchange_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `type` tinyint(4) NOT NULL COMMENT '类型 如1元红包券',
  `cash_type` tinyint(4) NOT NULL COMMENT '现金类型 1微信 2支付宝',
  `cash` double(20,0) NOT NULL COMMENT '提现现金',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0 兑换中 1 已兑换',
  `deliver_time` datetime DEFAULT NULL COMMENT '发货时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_exchange_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of log_exchange
-- ----------------------------

-- ----------------------------
-- Table structure for `log_invite`
-- ----------------------------
DROP TABLE IF EXISTS `log_invite`;
CREATE TABLE `log_invite` (
  `log_invite_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '番号',
  `user_id` int(11) NOT NULL,
  `invite_code` varchar(20) NOT NULL COMMENT '邀请码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_invite_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of log_invite
-- ----------------------------

-- ----------------------------
-- Table structure for `log_item`
-- ----------------------------
DROP TABLE IF EXISTS `log_item`;
CREATE TABLE `log_item` (
  `log_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `item_index` int(11) NOT NULL COMMENT '卡片类型id',
  `count` int(11) NOT NULL COMMENT '购买次数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of log_item
-- ----------------------------
INSERT INTO `log_item` VALUES ('45', '29', '1', '15', '2020-04-27 14:42:57', '2020-04-27 14:47:35');
INSERT INTO `log_item` VALUES ('46', '30', '1', '2', '2020-04-27 14:55:42', '2020-04-27 14:55:47');
INSERT INTO `log_item` VALUES ('47', '31', '1', '32', '2020-04-27 15:00:14', '2020-04-27 15:04:32');

-- ----------------------------
-- Table structure for `log_share`
-- ----------------------------
DROP TABLE IF EXISTS `log_share`;
CREATE TABLE `log_share` (
  `log_share_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '番号',
  `user_id` int(11) NOT NULL,
  `platform` int(11) DEFAULT NULL COMMENT '分享平台 1qq 2微信 3朋友圈 4qq空间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_share_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of log_share
-- ----------------------------
INSERT INTO `log_share` VALUES ('1', '29', '2', '2020-04-27 14:47:22', '2020-04-27 14:47:22');
INSERT INTO `log_share` VALUES ('2', '31', '2', '2020-04-27 15:01:49', '2020-04-27 15:01:49');

-- ----------------------------
-- Table structure for `log_to_coupon`
-- ----------------------------
DROP TABLE IF EXISTS `log_to_coupon`;
CREATE TABLE `log_to_coupon` (
  `log_to_coupon_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `diamond` int(11) NOT NULL COMMENT '兑换用的钻石',
  `coupon` int(11) NOT NULL COMMENT '兑换的红包券',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_to_coupon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of log_to_coupon
-- ----------------------------

-- ----------------------------
-- Table structure for `log_wallet`
-- ----------------------------
DROP TABLE IF EXISTS `log_wallet`;
CREATE TABLE `log_wallet` (
  `log_wallet_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '番号',
  `user_id` int(11) NOT NULL,
  `record_index` int(11) NOT NULL COMMENT '日常记录类型',
  `diamond` int(11) DEFAULT NULL COMMENT '钻石奖励数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`log_wallet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of log_wallet
-- ----------------------------
INSERT INTO `log_wallet` VALUES ('163', '29', '11', '100', '2020-04-27 14:42:59', '2020-04-27 14:42:59');
INSERT INTO `log_wallet` VALUES ('164', '30', '11', '100', '2020-04-27 14:55:44', '2020-04-27 14:55:44');
INSERT INTO `log_wallet` VALUES ('165', '31', '11', '100', '2020-04-27 15:00:16', '2020-04-27 15:00:16');
INSERT INTO `log_wallet` VALUES ('166', '31', '11', '100', '2020-04-27 15:02:16', '2020-04-27 15:02:16');
INSERT INTO `log_wallet` VALUES ('167', '31', '11', '100', '2020-04-27 15:02:26', '2020-04-27 15:02:26');
INSERT INTO `log_wallet` VALUES ('168', '31', '11', '100', '2020-04-27 15:03:53', '2020-04-27 15:03:53');

-- ----------------------------
-- Table structure for `tb_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `tb_feedback`;
CREATE TABLE `tb_feedback` (
  `feedback_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '反馈番号',
  `user_id` int(11) NOT NULL,
  `feedback_index` tinyint(4) NOT NULL COMMENT '反馈类型id',
  `content` varchar(256) DEFAULT NULL COMMENT '内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_feedback
-- ----------------------------
INSERT INTO `tb_feedback` VALUES ('1', '31', '7', '其他异常', '2020-04-27 15:03:07', '2020-04-27 15:03:07');

-- ----------------------------
-- Table structure for `tb_fragment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_fragment`;
CREATE TABLE `tb_fragment` (
  `fragment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `fragment_index` int(11) NOT NULL COMMENT '物品类型id',
  `number` int(11) NOT NULL COMMENT '数量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`fragment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_fragment
-- ----------------------------
INSERT INTO `tb_fragment` VALUES ('26', '31', '1', '1', '2020-04-27 15:04:05', '2020-04-27 15:04:05');

-- ----------------------------
-- Table structure for `tb_job`
-- ----------------------------
DROP TABLE IF EXISTS `tb_job`;
CREATE TABLE `tb_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `job_index` int(11) NOT NULL COMMENT '工作类型id',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0 未开始 1已开始 2未领奖',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_job
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_log`
-- ----------------------------
DROP TABLE IF EXISTS `tb_log`;
CREATE TABLE `tb_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=870 DEFAULT CHARSET=utf8mb4 COMMENT='系统日志';

-- ----------------------------
-- Records of tb_log
-- ----------------------------
INSERT INTO `tb_log` VALUES ('855', '29', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[null]', '0', '112.28.150.189', '2020-04-27 14:15:21');
INSERT INTO `tb_log` VALUES ('856', '29', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[null]', '15', '112.28.150.189', '2020-04-27 14:36:15');
INSERT INTO `tb_log` VALUES ('857', '14', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[null]', '0', '112.28.174.189', '2020-04-27 14:37:57');
INSERT INTO `tb_log` VALUES ('858', '29', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[null]', '0', '112.28.174.189', '2020-04-27 14:39:28');
INSERT INTO `tb_log` VALUES ('859', '29', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[null]', '16', '112.28.150.189', '2020-04-27 14:42:19');
INSERT INTO `tb_log` VALUES ('860', '29', '微信登录', 'com.jubaopeng.modules.app.controller.AppUserController.wxLogin()', '[{\"state\":\"\",\"code\":\"061agF101aC97U1mG1201Ijx101agF1w\",\"mobile_type\":\"1\",\"system_version\":\"2\",\"resolution_high\":\"3\",\"resolution_width\":\"4\",\"operate_lng\":\"5\",\"operate_lat\":\"6\",\"mobile_brand\":\"7\",\"device_num\":\"8\",\"token\":\"\"}]', '1296', '122.96.41.6', '2020-04-27 14:42:54');
INSERT INTO `tb_log` VALUES ('861', '29', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[{\"userId\":29,\"nickName\":\"梧桐花开\",\"avatar\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/sfJwicrvCPCGGpR4Yp6okQbl30Auy3S21MfzfhJL4BFDfcmcX0ve6suqtRHGS2aEKbrzu3Bn1Enfbm79pr7E1iaw/132\",\"password\":\"\",\"status\":0,\"formation\":\"1,2,1,1,0,0,0,0,0,0,0,0\",\"coin\":38.0,\"diamond\":100,\"redCoupon\":0.0,\"inviteCode\":\"1883065886\",\"lastEarnTime\":\"Apr 27, 2020 2:43:07 PM\",\"signCount\":0,\"signPrizeCount\":0,\"mapId\":1,\"storeExpandCapacity\":0,\"unlockMapId\":1,\"unlockItemId\":2,\"dropCount\":0,\"fragmentStruct\":\"0,0,0,0,0,0\",\"speedTime\":\"Apr 27, 2020 2:42:54 PM\",\"speedCount\":0,\"redBowlCount\":0,\"redBowlFragmentCount\":0,\"isShare\":0,\"createTime\":\"Apr 27, 2020 2:42:54 PM\",\"updateTime\":\"Apr 27, 2020 2:43:07 PM\"}]', '63', '112.28.174.189', '2020-04-27 14:43:08');
INSERT INTO `tb_log` VALUES ('862', '29', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[{\"userId\":29,\"nickName\":\"梧桐花开\",\"avatar\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/sfJwicrvCPCGGpR4Yp6okQbl30Auy3S21MfzfhJL4BFDfcmcX0ve6suqtRHGS2aEKbrzu3Bn1Enfbm79pr7E1iaw/132\",\"password\":\"\",\"status\":0,\"formation\":\"1,0,2,0,0,0,0,0,0,0,2,0\",\"coin\":1856.0,\"diamond\":100,\"redCoupon\":0.0,\"inviteCode\":\"1883065886\",\"lastEarnTime\":\"Apr 27, 2020 2:44:45 PM\",\"signCount\":0,\"signPrizeCount\":0,\"mapId\":1,\"storeExpandCapacity\":0,\"unlockMapId\":1,\"unlockItemId\":2,\"dropCount\":0,\"fragmentStruct\":\"0,0,0,0,0,0\",\"speedTime\":\"Apr 27, 2020 2:42:54 PM\",\"speedCount\":0,\"redBowlCount\":0,\"redBowlFragmentCount\":0,\"isShare\":0,\"createTime\":\"Apr 27, 2020 2:42:54 PM\",\"updateTime\":\"Apr 27, 2020 2:44:45 PM\"}]', '32', '112.28.150.189', '2020-04-27 14:47:14');
INSERT INTO `tb_log` VALUES ('863', '19', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[null]', '0', '124.64.126.112', '2020-04-27 14:54:54');
INSERT INTO `tb_log` VALUES ('864', '30', '微信登录', 'com.jubaopeng.modules.app.controller.AppUserController.wxLogin()', '[{\"state\":\"\",\"code\":\"071U2Bpx0lWkYe1MVGox0icspx0U2Bp6\",\"mobile_type\":\"1\",\"system_version\":\"2\",\"resolution_high\":\"3\",\"resolution_width\":\"4\",\"operate_lng\":\"116.41125\",\"operate_lat\":\"39.983768\",\"mobile_brand\":\"7\",\"device_num\":\"8\",\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxOSIsImlhdCI6MTU4Nzk1ODE4MCwiZXhwIjoxNTg4NTYyOTgwfQ.vh0KP82RUd9cvVcrqDRsUHSaOfcRu-zSXYF6-Sw-EXGeFB4twYiGmoTlhaWg4tVSfOF0FkcXle0ZbdFqMzYbag\"}]', '609', '124.64.126.112', '2020-04-27 14:54:58');
INSERT INTO `tb_log` VALUES ('865', '30', '自动登录', 'com.jubaopeng.modules.app.controller.AppUserController.autoLogin()', '[{\"userId\":30,\"nickName\":\"xxjjgg2019\",\"avatar\":\"\",\"password\":\"\",\"status\":0,\"formation\":\"0,2,0,0,0,0,0,0,0,0,0,0\",\"coin\":1116.0,\"diamond\":100,\"redCoupon\":0.0,\"inviteCode\":\"4301944145\",\"lastEarnTime\":\"Apr 27, 2020 2:56:26 PM\",\"signCount\":0,\"signPrizeCount\":0,\"mapId\":1,\"storeExpandCapacity\":0,\"unlockMapId\":1,\"unlockItemId\":2,\"dropCount\":0,\"fragmentStruct\":\"0,0,0,0,0,0\",\"speedTime\":\"Apr 27, 2020 2:54:58 PM\",\"speedCount\":0,\"redBowlCount\":0,\"redBowlFragmentCount\":0,\"isShare\":0,\"createTime\":\"Apr 27, 2020 2:54:58 PM\",\"updateTime\":\"Apr 27, 2020 2:56:26 PM\"}]', '15', '124.64.126.112', '2020-04-27 14:56:27');
INSERT INTO `tb_log` VALUES ('866', '31', '微信登录', 'com.jubaopeng.modules.app.controller.AppUserController.wxLogin()', '[{\"state\":\"\",\"code\":\"0714Myok2JO55C0U22pk2qksok24Myo8\",\"mobile_type\":\"1\",\"system_version\":\"2\",\"resolution_high\":\"3\",\"resolution_width\":\"4\",\"operate_lng\":\"117.223246\",\"operate_lat\":\"31.825214\",\"mobile_brand\":\"7\",\"device_num\":\"8\",\"token\":\"\"}]', '500', '112.28.150.189', '2020-04-27 15:00:10');
INSERT INTO `tb_log` VALUES ('867', '31', '日常操作记录', 'com.jubaopeng.modules.app.controller.AppSystemController.walletLog()', '[{\"userId\":31,\"nickName\":\"诗和远方\",\"avatar\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/n1gS0knXOF67uNIX9h2CqJVGmOOKNuCoXf0CKnF1dzh6yMPGyZPU6wYGv8aoR0j2SNM5uvdibhR5fPKKZNecGXg/132\",\"password\":\"\",\"status\":0,\"formation\":\"1,2,1,1,0,0,0,0,0,0,0,0\",\"coin\":1662.0,\"diamond\":100,\"redCoupon\":0.0,\"inviteCode\":\"5056622894\",\"lastEarnTime\":\"Apr 27, 2020 3:01:45 PM\",\"signCount\":0,\"signPrizeCount\":0,\"mapId\":1,\"storeExpandCapacity\":0,\"unlockMapId\":1,\"unlockItemId\":2,\"dropCount\":0,\"fragmentStruct\":\"0,0,0,0,0,0\",\"speedTime\":\"Apr 27, 2020 3:00:10 PM\",\"speedCount\":0,\"redBowlCount\":0,\"redBowlFragmentCount\":0,\"isShare\":0,\"createTime\":\"Apr 27, 2020 3:00:10 PM\",\"updateTime\":\"Apr 27, 2020 3:01:45 PM\"}]', '32', '112.28.174.189', '2020-04-27 15:01:45');
INSERT INTO `tb_log` VALUES ('868', '31', '提交反馈信息', 'com.jubaopeng.modules.app.controller.AppSystemController.feedback()', '[{\"userId\":31,\"nickName\":\"诗和远方\",\"avatar\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/n1gS0knXOF67uNIX9h2CqJVGmOOKNuCoXf0CKnF1dzh6yMPGyZPU6wYGv8aoR0j2SNM5uvdibhR5fPKKZNecGXg/132\",\"password\":\"\",\"status\":0,\"formation\":\"1024,0,0,3,0,1,0,0,0,4,0,0\",\"coin\":3672.0,\"diamond\":300,\"redCoupon\":0.0,\"inviteCode\":\"5056622894\",\"lastEarnTime\":\"Apr 27, 2020 3:03:07 PM\",\"signCount\":0,\"signPrizeCount\":0,\"mapId\":1,\"storeExpandCapacity\":0,\"unlockMapId\":1,\"unlockItemId\":4,\"dropCount\":0,\"fragmentStruct\":\"0,0,0,0,0,0\",\"speedTime\":\"Apr 27, 2020 3:00:10 PM\",\"speedCount\":0,\"redBowlCount\":0,\"redBowlFragmentCount\":0,\"isShare\":0,\"createTime\":\"Apr 27, 2020 3:00:10 PM\",\"updateTime\":\"Apr 27, 2020 3:03:07 PM\"},{\"feedbackIndex\":\"7\",\"content\":\"其他异常\",\"token\":\"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIzMSIsImlhdCI6MTU4Nzk3MDgxMCwiZXhwIjoxNTg4NTc1NjEwfQ.s0z6-35O7IuJvYHiWk63re2DStF9QV5XgB2vaP3NetpvkRMSajR6_M8UMGnLRC-RqZ-hz4kj5P2PpjWciDgqBQ\"}]', '31', '112.28.174.189', '2020-04-27 15:03:07');
INSERT INTO `tb_log` VALUES ('869', '31', '日常操作记录', 'com.jubaopeng.modules.app.controller.AppSystemController.walletLog()', '[{\"userId\":31,\"nickName\":\"诗和远方\",\"avatar\":\"http://thirdwx.qlogo.cn/mmopen/vi_32/n1gS0knXOF67uNIX9h2CqJVGmOOKNuCoXf0CKnF1dzh6yMPGyZPU6wYGv8aoR0j2SNM5uvdibhR5fPKKZNecGXg/132\",\"password\":\"\",\"status\":0,\"formation\":\"1024,0,0,3,0,1,0,0,0,4,0,0\",\"coin\":4112.0,\"diamond\":300,\"redCoupon\":0.0,\"inviteCode\":\"5056622894\",\"lastEarnTime\":\"Apr 27, 2020 3:03:15 PM\",\"signCount\":0,\"signPrizeCount\":0,\"mapId\":1,\"storeExpandCapacity\":0,\"unlockMapId\":1,\"unlockItemId\":4,\"dropCount\":0,\"fragmentStruct\":\"0,0,0,0,0,0\",\"speedTime\":\"Apr 27, 2020 3:00:10 PM\",\"speedCount\":0,\"redBowlCount\":0,\"redBowlFragmentCount\":0,\"isShare\":0,\"createTime\":\"Apr 27, 2020 3:00:10 PM\",\"updateTime\":\"Apr 27, 2020 3:03:15 PM\"}]', '16', '112.28.174.189', '2020-04-27 15:03:16');

-- ----------------------------
-- Table structure for `tb_lottery`
-- ----------------------------
DROP TABLE IF EXISTS `tb_lottery`;
CREATE TABLE `tb_lottery` (
  `lottery_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `prize_index` int(11) NOT NULL COMMENT '奖励id',
  `lottery_index` int(11) NOT NULL COMMENT '抽奖类型id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`lottery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_lottery
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_mentor`
-- ----------------------------
DROP TABLE IF EXISTS `tb_mentor`;
CREATE TABLE `tb_mentor` (
  `mentor_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '番号',
  `user_id` int(11) NOT NULL COMMENT '徒弟id',
  `mentor_user_id` int(11) NOT NULL COMMENT '师傅id',
  `red_bowl_fragment_count` int(11) DEFAULT '0' COMMENT '红碗碎片个数',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`mentor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_mentor
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_open_id`
-- ----------------------------
DROP TABLE IF EXISTS `tb_open_id`;
CREATE TABLE `tb_open_id` (
  `user_id` int(11) unsigned NOT NULL,
  `open_id` varchar(32) NOT NULL COMMENT '第三方登录标识',
  `open_type` int(11) NOT NULL COMMENT '第三方登录类型 0微信1支付宝2qq',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_open_id
-- ----------------------------
INSERT INTO `tb_open_id` VALUES ('29', 'oHkOgt2Auay4yUILboZEmERU642o', '0', '2020-04-27 14:42:54', '2020-04-27 14:42:54');
INSERT INTO `tb_open_id` VALUES ('30', 'oHkOgtxNE2ChuUrxY-80OQXsiPjQ', '0', '2020-04-27 14:54:58', '2020-04-27 14:54:58');
INSERT INTO `tb_open_id` VALUES ('31', 'oHkOgt2gH8PZMVaRXYHZ-zoXWMWs', '0', '2020-04-27 15:00:10', '2020-04-27 15:00:10');

-- ----------------------------
-- Table structure for `tb_store`
-- ----------------------------
DROP TABLE IF EXISTS `tb_store`;
CREATE TABLE `tb_store` (
  `store_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `item_index` int(11) NOT NULL COMMENT '合成物类型id',
  `number` int(11) DEFAULT '0' COMMENT '状态 0 未开始 1已开始 2未领奖',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_store
-- ----------------------------

-- ----------------------------
-- Table structure for `tb_task`
-- ----------------------------
DROP TABLE IF EXISTS `tb_task`;
CREATE TABLE `tb_task` (
  `task_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `task_index` int(11) NOT NULL COMMENT '任务类型id',
  `value` int(11) NOT NULL COMMENT '完成度',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0未完成 1已完成 2已领取奖励',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`task_id`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_task
-- ----------------------------
INSERT INTO `tb_task` VALUES ('130', '29', '15', '3', '1', null, '2020-04-27 14:47:14');
INSERT INTO `tb_task` VALUES ('131', '29', '17', '7', '1', null, '2020-04-27 14:47:44');
INSERT INTO `tb_task` VALUES ('132', '29', '14', '7', '0', null, '2020-04-27 14:47:44');
INSERT INTO `tb_task` VALUES ('133', '29', '16', '1', '1', null, '2020-04-27 14:42:59');
INSERT INTO `tb_task` VALUES ('134', '29', '22', '2', '0', null, '2020-04-27 14:43:51');
INSERT INTO `tb_task` VALUES ('135', '29', '18', '1', '1', null, '2020-04-27 14:47:35');
INSERT INTO `tb_task` VALUES ('136', '30', '15', '2', '1', null, '2020-04-27 14:56:27');
INSERT INTO `tb_task` VALUES ('137', '30', '17', '1', '0', null, '2020-04-27 14:55:44');
INSERT INTO `tb_task` VALUES ('138', '30', '14', '1', '0', null, '2020-04-27 14:55:44');
INSERT INTO `tb_task` VALUES ('139', '30', '16', '1', '1', null, '2020-04-27 14:55:44');
INSERT INTO `tb_task` VALUES ('140', '30', '22', '1', '0', null, '2020-04-27 14:55:50');
INSERT INTO `tb_task` VALUES ('141', '31', '15', '1', '1', null, '2020-04-27 15:00:10');
INSERT INTO `tb_task` VALUES ('142', '31', '17', '26', '1', null, '2020-04-27 15:04:30');
INSERT INTO `tb_task` VALUES ('143', '31', '14', '26', '0', null, '2020-04-27 15:04:30');
INSERT INTO `tb_task` VALUES ('144', '31', '16', '4', '1', null, '2020-04-27 15:03:53');
INSERT INTO `tb_task` VALUES ('145', '31', '22', '1', '0', null, '2020-04-27 15:00:20');
INSERT INTO `tb_task` VALUES ('146', '31', '18', '3', '1', null, '2020-04-27 15:04:01');
INSERT INTO `tb_task` VALUES ('147', '31', '21', '2', '1', null, '2020-04-27 15:04:32');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(256) DEFAULT NULL COMMENT '头像',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `salt` varchar(10) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '0' COMMENT '状态 0正常 1冻结 2注销',
  `formation` varchar(255) DEFAULT NULL COMMENT '排列',
  `fragment_struct` varchar(255) DEFAULT NULL COMMENT '排列',
  `coin` double(255,0) DEFAULT '0' COMMENT '金币',
  `diamond` int(11) DEFAULT '0' COMMENT '钻石',
  `red_coupon` double(20,2) DEFAULT '0.00' COMMENT '红包券',
  `invite_code` varchar(20) DEFAULT NULL COMMENT '邀请码',
  `last_earn_time` datetime DEFAULT NULL COMMENT '上次获利时间',
  `sign_count` int(11) DEFAULT '0' COMMENT '签到次数',
  `sign_time` datetime DEFAULT NULL COMMENT '签到时间',
  `sign_prize_count` int(11) DEFAULT '0' COMMENT '签到奖励次数',
  `map_id` int(11) DEFAULT '1' COMMENT '当前地图id',
  `store_expand_capacity` int(11) DEFAULT '0' COMMENT '背包扩容容量',
  `drop_count` int(11) DEFAULT '0' COMMENT '掉落次数',
  `unlock_map_id` int(11) DEFAULT '1' COMMENT '解锁的地图id',
  `unlock_item_id` int(11) DEFAULT '0' COMMENT '解锁的卡片等级',
  `speed_time` datetime DEFAULT NULL COMMENT '加速到的时间',
  `speed_count` int(11) DEFAULT '0' COMMENT '加速次数',
  `red_bowl_count` int(11) DEFAULT '0' COMMENT '红碗个数',
  `red_bowl_fragment_count` int(11) DEFAULT '0' COMMENT '红碗碎片个数',
  `is_share` tinyint(4) DEFAULT '0' COMMENT '是否使用邀请码 0未使用 1使用',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('29', '梧桐花开', 'http://thirdwx.qlogo.cn/mmopen/vi_32/sfJwicrvCPCGGpR4Yp6okQbl30Auy3S21MfzfhJL4BFDfcmcX0ve6suqtRHGS2aEKbrzu3Bn1Enfbm79pr7E1iaw/132', null, '', null, '0', '0,2,2,0,0,2,0,2,2,2,2,0', '0,0,0,0,0,0', '4422', '100', '0.00', '1883065886', '2020-04-27 14:48:02', '0', null, '0', '1', '0', '0', '1', '2', '2020-04-27 14:42:54', '0', '0', '0', '0', '2020-04-27 14:48:02', '2020-04-27 14:42:54');
INSERT INTO `tb_user` VALUES ('30', 'xxjjgg2019', '', null, '', null, '0', '0,2,0,0,0,0,0,0,0,0,0,0', '0,0,0,0,0,0', '1172', '100', '0.00', '4301944145', '2020-04-27 14:56:33', '0', null, '0', '1', '0', '0', '1', '2', '2020-04-27 14:54:58', '0', '0', '0', '0', '2020-04-27 14:56:33', '2020-04-27 14:54:58');
INSERT INTO `tb_user` VALUES ('31', '诗和远方', 'http://thirdwx.qlogo.cn/mmopen/vi_32/n1gS0knXOF67uNIX9h2CqJVGmOOKNuCoXf0CKnF1dzh6yMPGyZPU6wYGv8aoR0j2SNM5uvdibhR5fPKKZNecGXg/132', null, '', null, '0', '1,1,3,0,0,2,1024,1022,4,0,5,1002', '0,0,0,0,0,0', '2656', '400', '0.00', '5056622894', '2020-04-27 15:04:49', '0', null, '0', '1', '0', '3', '1', '5', '2020-04-27 15:00:10', '0', '0', '0', '0', '2020-04-27 15:04:49', '2020-04-27 15:00:10');

-- ----------------------------
-- Table structure for `tb_user_ext`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_ext`;
CREATE TABLE `tb_user_ext` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile_type` int(11) DEFAULT NULL COMMENT '手机系统类型',
  `system_version` varchar(50) DEFAULT NULL COMMENT '系统版本',
  `resolution_high` int(11) DEFAULT NULL COMMENT '分辨率高',
  `resolution_width` int(11) DEFAULT NULL COMMENT '分辨率宽',
  `operate_lng` double(20,0) DEFAULT NULL COMMENT '定位经度',
  `operate_lat` double(20,0) DEFAULT NULL COMMENT '定位纬度',
  `mobile_brand` varchar(20) DEFAULT '0' COMMENT '设备品牌',
  `device_num` varchar(20) DEFAULT NULL COMMENT '设备号',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT '0' COMMENT '年龄',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_user_ext
-- ----------------------------
INSERT INTO `tb_user_ext` VALUES ('23', '1', '2', '3', '4', '5', '6', '7', '8', '0', '0', '2020-04-27 14:42:54', '2020-04-27 14:42:54');
INSERT INTO `tb_user_ext` VALUES ('24', '1', '2', '3', '4', '116', '40', '7', '8', '0', '0', '2020-04-27 14:54:58', '2020-04-27 14:54:58');
INSERT INTO `tb_user_ext` VALUES ('25', '1', '2', '3', '4', '117', '32', '7', '8', '1', '0', '2020-04-27 15:00:10', '2020-04-27 15:00:10');

-- ----------------------------
-- Table structure for `tb_video`
-- ----------------------------
DROP TABLE IF EXISTS `tb_video`;
CREATE TABLE `tb_video` (
  `video_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `user_id` int(11) NOT NULL,
  `video_index` int(11) NOT NULL COMMENT '视频类型index',
  `value` double(255,0) NOT NULL COMMENT '通用值',
  `count` int(11) NOT NULL COMMENT '当天看视频次数',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0未完成 1已完成并领取奖励',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of tb_video
-- ----------------------------
INSERT INTO `tb_video` VALUES ('74', '29', '5', '100', '0', '0', null, '2020-04-27 14:42:55');
INSERT INTO `tb_video` VALUES ('75', '29', '8', '100', '0', '0', null, '2020-04-27 14:42:59');
INSERT INTO `tb_video` VALUES ('76', '29', '2', '214', '0', '0', null, '2020-04-27 14:43:08');
INSERT INTO `tb_video` VALUES ('77', '29', '9', '3000', '0', '0', null, '2020-04-27 14:47:15');
INSERT INTO `tb_video` VALUES ('78', '30', '5', '100', '0', '0', null, '2020-04-27 14:55:00');
INSERT INTO `tb_video` VALUES ('79', '30', '8', '100', '0', '0', null, '2020-04-27 14:55:44');
INSERT INTO `tb_video` VALUES ('80', '31', '5', '100', '0', '0', null, '2020-04-27 15:00:11');
INSERT INTO `tb_video` VALUES ('81', '31', '8', '100', '0', '0', null, '2020-04-27 15:00:16');
INSERT INTO `tb_video` VALUES ('82', '31', '2', '963', '0', '0', null, '2020-04-27 15:04:33');
INSERT INTO `tb_video` VALUES ('83', '31', '11', '1', '0', '0', null, '2020-04-27 15:04:05');

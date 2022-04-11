/*
 Navicat Premium Data Transfer

 Source Server         : Qwz_local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mall_payment

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 12/04/2022 02:40:27
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oms_payment_info
-- ----------------------------
DROP TABLE IF EXISTS `oms_payment_info`;
CREATE TABLE `oms_payment_info`
(
    `id`               bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `order_sn`         char(32)       DEFAULT NULL COMMENT '?????ţ?????ҵ???ţ?',
    `order_id`         bigint         DEFAULT NULL COMMENT '????id',
    `alipay_trade_no`  varchar(50)    DEFAULT NULL COMMENT '֧??????????ˮ?',
    `total_amount`     decimal(18, 4) DEFAULT NULL COMMENT '֧???ܽ',
    `subject`          varchar(200)   DEFAULT NULL COMMENT '???????',
    `payment_status`   varchar(20)    DEFAULT NULL COMMENT '֧??״̬',
    `create_time`      datetime       DEFAULT NULL COMMENT '????ʱ?',
    `confirm_time`     datetime       DEFAULT NULL COMMENT 'ȷ??ʱ?',
    `callback_content` varchar(4000)  DEFAULT NULL COMMENT '?ص????',
    `callback_time`    datetime       DEFAULT NULL COMMENT '?ص?ʱ?',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='֧????Ϣ?';

-- ----------------------------
-- Table structure for oms_refund_info
-- ----------------------------
DROP TABLE IF EXISTS `oms_refund_info`;
CREATE TABLE `oms_refund_info`
(
    `id`              bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `order_return_id` bigint         DEFAULT NULL COMMENT '?˿??Ķ???',
    `refund`          decimal(18, 4) DEFAULT NULL COMMENT '?˿??',
    `refund_sn`       varchar(64)    DEFAULT NULL COMMENT '?˿????ˮ?',
    `refund_status`   tinyint(1) DEFAULT NULL COMMENT '?˿?״̬',
    `refund_channel`  tinyint        DEFAULT NULL COMMENT '?˿?????[1-֧??????2-΢?ţ?3-??????4-???',
    `refund_content`  varchar(5000)  DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?˿???Ϣ';

SET
FOREIGN_KEY_CHECKS = 1;

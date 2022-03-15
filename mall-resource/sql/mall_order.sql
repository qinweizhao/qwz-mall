/*
 Navicat Premium Data Transfer

 Source Server         : Qwz_local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mall_order

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 15/03/2022 16:36:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `member_id` bigint DEFAULT NULL COMMENT 'member_id',
  `order_sn` char(32) DEFAULT NULL COMMENT '?????',
  `coupon_id` bigint DEFAULT NULL COMMENT 'ʹ?õ??Ż?ȯ',
  `create_time` datetime DEFAULT NULL COMMENT 'create_time',
  `member_username` varchar(200) DEFAULT NULL COMMENT '?û??',
  `total_amount` decimal(18,4) DEFAULT NULL COMMENT '?????ܶ',
  `pay_amount` decimal(18,4) DEFAULT NULL COMMENT 'Ӧ???ܶ',
  `freight_amount` decimal(18,4) DEFAULT NULL COMMENT '?˷ѽ',
  `promotion_amount` decimal(18,4) DEFAULT NULL COMMENT '?????Ż?????????ۡ??????????ݼۣ?',
  `integration_amount` decimal(18,4) DEFAULT NULL COMMENT '???ֵֿ۽',
  `coupon_amount` decimal(18,4) DEFAULT NULL COMMENT '?Ż?ȯ?ֿ۽',
  `discount_amount` decimal(18,4) DEFAULT NULL COMMENT '??̨????????ʹ?õ??ۿ۽',
  `pay_type` tinyint DEFAULT NULL COMMENT '֧????ʽ??1->֧??????2->΢?ţ?3->?????? 4->?????????',
  `source_type` tinyint DEFAULT NULL COMMENT '??????Դ[0->PC??????1->app????]',
  `status` tinyint DEFAULT NULL COMMENT '????״̬??0->?????1->????????2->?ѷ?????3->?????ɣ?4->?ѹرգ?5->??Ч??????',
  `delivery_company` varchar(64) DEFAULT NULL COMMENT '??????˾(???ͷ?ʽ)',
  `delivery_sn` varchar(64) DEFAULT NULL COMMENT '???????',
  `auto_confirm_day` int DEFAULT NULL COMMENT '?Զ?ȷ??ʱ?䣨?죩',
  `integration` int DEFAULT NULL COMMENT '???Ի??õĻ',
  `growth` int DEFAULT NULL COMMENT '???Ի??õĳɳ?ֵ',
  `bill_type` tinyint DEFAULT NULL COMMENT '??Ʊ????[0->??????Ʊ??1->???ӷ?Ʊ??2->ֽ?ʷ?Ʊ]',
  `bill_header` varchar(255) DEFAULT NULL COMMENT '??Ʊ̧ͷ',
  `bill_content` varchar(255) DEFAULT NULL COMMENT '??Ʊ???',
  `bill_receiver_phone` varchar(32) DEFAULT NULL COMMENT '??Ʊ?˵绰',
  `bill_receiver_email` varchar(64) DEFAULT NULL COMMENT '??Ʊ?????',
  `receiver_name` varchar(100) DEFAULT NULL COMMENT '?ջ??????',
  `receiver_phone` varchar(32) DEFAULT NULL COMMENT '?ջ??˵绰',
  `receiver_post_code` varchar(32) DEFAULT NULL COMMENT '?ջ????ʱ',
  `receiver_province` varchar(32) DEFAULT NULL COMMENT 'ʡ??/ֱϽ?',
  `receiver_city` varchar(32) DEFAULT NULL COMMENT '???',
  `receiver_region` varchar(32) DEFAULT NULL COMMENT '?',
  `receiver_detail_address` varchar(200) DEFAULT NULL COMMENT '??ϸ??ַ',
  `note` varchar(500) DEFAULT NULL COMMENT '??????ע',
  `confirm_status` tinyint DEFAULT NULL COMMENT 'ȷ???ջ?״̬[0->δȷ?ϣ?1->??ȷ??]',
  `delete_status` tinyint DEFAULT NULL COMMENT 'ɾ??״̬??0->δɾ????1->??ɾ?',
  `use_integration` int DEFAULT NULL COMMENT '?µ?ʱʹ?õĻ',
  `payment_time` datetime DEFAULT NULL COMMENT '֧??ʱ?',
  `delivery_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `receive_time` datetime DEFAULT NULL COMMENT 'ȷ???ջ?ʱ?',
  `comment_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `modify_time` datetime DEFAULT NULL COMMENT '?޸?ʱ?',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='????';

-- ----------------------------
-- Records of oms_order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` bigint DEFAULT NULL COMMENT 'order_id',
  `order_sn` char(32) DEFAULT NULL COMMENT 'order_sn',
  `spu_id` bigint DEFAULT NULL COMMENT 'spu_id',
  `spu_name` varchar(255) DEFAULT NULL COMMENT 'spu_name',
  `spu_pic` varchar(500) DEFAULT NULL COMMENT 'spu_pic',
  `spu_brand` varchar(200) DEFAULT NULL COMMENT 'Ʒ?',
  `category_id` bigint DEFAULT NULL COMMENT '??Ʒ????id',
  `sku_id` bigint DEFAULT NULL COMMENT '??Ʒsku???',
  `sku_name` varchar(255) DEFAULT NULL COMMENT '??Ʒsku?',
  `sku_pic` varchar(500) DEFAULT NULL COMMENT '??ƷskuͼƬ',
  `sku_price` decimal(18,4) DEFAULT NULL COMMENT '??Ʒsku?۸',
  `sku_quantity` int DEFAULT NULL COMMENT '??Ʒ???????',
  `sku_attrs_vals` varchar(500) DEFAULT NULL COMMENT '??Ʒ???????????ϣ?JSON??',
  `promotion_amount` decimal(18,4) DEFAULT NULL COMMENT '??Ʒ?????ֽ??',
  `coupon_amount` decimal(18,4) DEFAULT NULL COMMENT '?Ż?ȯ?Żݷֽ??',
  `integration_amount` decimal(18,4) DEFAULT NULL COMMENT '?????Żݷֽ??',
  `real_amount` decimal(18,4) DEFAULT NULL COMMENT '????Ʒ?????Żݺ??ķֽ??',
  `gift_integration` int DEFAULT NULL COMMENT '???ͻ',
  `gift_growth` int DEFAULT NULL COMMENT '???ͳɳ?ֵ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='????????Ϣ';

-- ----------------------------
-- Records of oms_order_item
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oms_order_operate_history
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_operate_history`;
CREATE TABLE `oms_order_operate_history` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` bigint DEFAULT NULL COMMENT '????id',
  `operate_man` varchar(100) DEFAULT NULL COMMENT '??????[?û???ϵͳ????̨????Ա]',
  `create_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `order_status` tinyint DEFAULT NULL COMMENT '????״̬??0->?????1->????????2->?ѷ?????3->?????ɣ?4->?ѹرգ?5->??Ч??????',
  `note` varchar(500) DEFAULT NULL COMMENT '??ע',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??????????ʷ??¼';

-- ----------------------------
-- Records of oms_order_operate_history
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oms_order_return_apply
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_apply`;
CREATE TABLE `oms_order_return_apply` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_id` bigint DEFAULT NULL COMMENT 'order_id',
  `sku_id` bigint DEFAULT NULL COMMENT '?˻???Ʒid',
  `order_sn` char(32) DEFAULT NULL COMMENT '???????',
  `create_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `member_username` varchar(64) DEFAULT NULL COMMENT '??Ա?û??',
  `return_amount` decimal(18,4) DEFAULT NULL COMMENT '?˿??',
  `return_name` varchar(100) DEFAULT NULL COMMENT '?˻??????',
  `return_phone` varchar(20) DEFAULT NULL COMMENT '?˻??˵绰',
  `status` tinyint(1) DEFAULT NULL COMMENT '????״̬[0->????????1->?˻??У?2->?????ɣ?3->?Ѿܾ',
  `handle_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `sku_img` varchar(500) DEFAULT NULL COMMENT '??ƷͼƬ',
  `sku_name` varchar(200) DEFAULT NULL COMMENT '??Ʒ?',
  `sku_brand` varchar(200) DEFAULT NULL COMMENT '??ƷƷ?',
  `sku_attrs_vals` varchar(500) DEFAULT NULL COMMENT '??Ʒ????????(JSON)',
  `sku_count` int DEFAULT NULL COMMENT '?˻??',
  `sku_price` decimal(18,4) DEFAULT NULL COMMENT '??Ʒ???',
  `sku_real_price` decimal(18,4) DEFAULT NULL COMMENT '??Ʒʵ??֧?????',
  `reason` varchar(200) DEFAULT NULL COMMENT 'ԭ?',
  `description?` varchar(500) DEFAULT NULL COMMENT '???',
  `desc_pics` varchar(2000) DEFAULT NULL COMMENT 'ƾ֤ͼƬ???Զ??Ÿ',
  `handle_note` varchar(500) DEFAULT NULL COMMENT '??????ע',
  `handle_man` varchar(200) DEFAULT NULL COMMENT '??????Ա',
  `receive_man` varchar(100) DEFAULT NULL COMMENT '?ջ',
  `receive_time` datetime DEFAULT NULL COMMENT '?ջ?ʱ?',
  `receive_note` varchar(500) DEFAULT NULL COMMENT '?ջ???ע',
  `receive_phone` varchar(20) DEFAULT NULL COMMENT '?ջ??绰',
  `company_address` varchar(500) DEFAULT NULL COMMENT '??˾?ջ???ַ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?????˻????';

-- ----------------------------
-- Records of oms_order_return_apply
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oms_order_return_reason
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_reason`;
CREATE TABLE `oms_order_return_reason` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT '?˻?ԭ?',
  `sort` int DEFAULT NULL COMMENT '???',
  `status` tinyint(1) DEFAULT NULL COMMENT '????״̬',
  `create_time` datetime DEFAULT NULL COMMENT 'create_time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?˻?ԭ?';

-- ----------------------------
-- Records of oms_order_return_reason
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oms_order_setting
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_setting`;
CREATE TABLE `oms_order_setting` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `flash_order_overtime` int DEFAULT NULL COMMENT '??ɱ??????ʱ?ر?ʱ??(??)',
  `normal_order_overtime` int DEFAULT NULL COMMENT '??????????ʱʱ??(??)',
  `confirm_overtime` int DEFAULT NULL COMMENT '???????Զ?ȷ???ջ?ʱ?䣨?죩',
  `finish_overtime` int DEFAULT NULL COMMENT '?Զ????ɽ???ʱ?䣬?????????˻????죩',
  `comment_overtime` int DEFAULT NULL COMMENT '???????ɺ??Զ?????ʱ?䣨?죩',
  `member_level` tinyint DEFAULT NULL COMMENT '??Ա?ȼ???0-???޻?Ա?ȼ???ȫ??ͨ?ã?????-??Ӧ????????Ա?ȼ???',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??????????Ϣ';

-- ----------------------------
-- Records of oms_order_setting
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oms_payment_info
-- ----------------------------
DROP TABLE IF EXISTS `oms_payment_info`;
CREATE TABLE `oms_payment_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_sn` char(32) DEFAULT NULL COMMENT '?????ţ?????ҵ???ţ?',
  `order_id` bigint DEFAULT NULL COMMENT '????id',
  `alipay_trade_no` varchar(50) DEFAULT NULL COMMENT '֧??????????ˮ?',
  `total_amount` decimal(18,4) DEFAULT NULL COMMENT '֧???ܽ',
  `subject` varchar(200) DEFAULT NULL COMMENT '???????',
  `payment_status` varchar(20) DEFAULT NULL COMMENT '֧??״̬',
  `create_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `confirm_time` datetime DEFAULT NULL COMMENT 'ȷ??ʱ?',
  `callback_content` varchar(4000) DEFAULT NULL COMMENT '?ص????',
  `callback_time` datetime DEFAULT NULL COMMENT '?ص?ʱ?',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='֧????Ϣ?';

-- ----------------------------
-- Records of oms_payment_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for oms_refund_info
-- ----------------------------
DROP TABLE IF EXISTS `oms_refund_info`;
CREATE TABLE `oms_refund_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `order_return_id` bigint DEFAULT NULL COMMENT '?˿??Ķ???',
  `refund` decimal(18,4) DEFAULT NULL COMMENT '?˿??',
  `refund_sn` varchar(64) DEFAULT NULL COMMENT '?˿????ˮ?',
  `refund_status` tinyint(1) DEFAULT NULL COMMENT '?˿?״̬',
  `refund_channel` tinyint DEFAULT NULL COMMENT '?˿?????[1-֧??????2-΢?ţ?3-??????4-???',
  `refund_content` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?˿???Ϣ';

-- ----------------------------
-- Records of oms_refund_info
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : Qwz_local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mall_activity

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 15/03/2022 16:35:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ams_coupon
-- ----------------------------
DROP TABLE IF EXISTS `ams_coupon`;
CREATE TABLE `ams_coupon` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_type` tinyint(1) DEFAULT NULL COMMENT '?Żݾ?????[0->ȫ????ȯ??1->??Ա??ȯ??2->??????ȯ??3->ע????ȯ]',
  `coupon_img` varchar(2000) DEFAULT NULL COMMENT '?Ż?ȯͼƬ',
  `coupon_name` varchar(100) DEFAULT NULL COMMENT '?Żݾ??',
  `num` int DEFAULT NULL COMMENT '?',
  `amount` decimal(18,4) DEFAULT NULL COMMENT '?',
  `per_limit` int DEFAULT NULL COMMENT 'ÿ?????????',
  `min_point` decimal(18,4) DEFAULT NULL COMMENT 'ʹ???ż',
  `start_time` datetime DEFAULT NULL COMMENT '??ʼʱ?',
  `end_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `use_type` tinyint(1) DEFAULT NULL COMMENT 'ʹ??????[0->ȫ??ͨ?ã?1->ָ?????ࣻ2->ָ????Ʒ]',
  `note` varchar(200) DEFAULT NULL COMMENT '??ע',
  `publish_count` int DEFAULT NULL COMMENT '?????',
  `use_count` int DEFAULT NULL COMMENT '??ʹ???',
  `receive_count` int DEFAULT NULL COMMENT '??ȡ?',
  `enable_start_time` datetime DEFAULT NULL COMMENT '??????ȡ?Ŀ?ʼ???',
  `enable_end_time` datetime DEFAULT NULL COMMENT '??????ȡ?Ľ??????',
  `code` varchar(64) DEFAULT NULL COMMENT '?Ż??',
  `member_level` tinyint(1) DEFAULT NULL COMMENT '??????ȡ?Ļ?Ա?ȼ?[0->???޵ȼ???????-??Ӧ?ȼ?]',
  `publish` tinyint(1) DEFAULT NULL COMMENT '????״̬[0-δ??????1-?ѷ???]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?Ż?ȯ??Ϣ';

-- ----------------------------
-- Records of ams_coupon
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_coupon_history
-- ----------------------------
DROP TABLE IF EXISTS `ams_coupon_history`;
CREATE TABLE `ams_coupon_history` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` bigint DEFAULT NULL COMMENT '?Ż?ȯid',
  `member_id` bigint DEFAULT NULL COMMENT '??Աid',
  `member_nick_name` varchar(64) DEFAULT NULL COMMENT '??Ա?',
  `get_type` tinyint(1) DEFAULT NULL COMMENT '??ȡ??ʽ[0->??̨???ͣ?1->??????ȡ]',
  `create_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `use_type` tinyint(1) DEFAULT NULL COMMENT 'ʹ??״̬[0->δʹ?ã?1->??ʹ?ã?2->?ѹ???]',
  `use_time` datetime DEFAULT NULL COMMENT 'ʹ??ʱ?',
  `order_id` bigint DEFAULT NULL COMMENT '????id',
  `order_sn` bigint DEFAULT NULL COMMENT '?????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?Ż?ȯ??ȡ??ʷ??¼';

-- ----------------------------
-- Records of ams_coupon_history
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_coupon_spu_category_relation
-- ----------------------------
DROP TABLE IF EXISTS `ams_coupon_spu_category_relation`;
CREATE TABLE `ams_coupon_spu_category_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` bigint DEFAULT NULL COMMENT '?Ż?ȯid',
  `category_id` bigint DEFAULT NULL COMMENT '??Ʒ????id',
  `category_name` varchar(64) DEFAULT NULL COMMENT '??Ʒ?????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?Ż?ȯ????????';

-- ----------------------------
-- Records of ams_coupon_spu_category_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_coupon_spu_relation
-- ----------------------------
DROP TABLE IF EXISTS `ams_coupon_spu_relation`;
CREATE TABLE `ams_coupon_spu_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coupon_id` bigint DEFAULT NULL COMMENT '?Ż?ȯid',
  `spu_id` bigint DEFAULT NULL COMMENT 'spu_id',
  `spu_name` varchar(255) DEFAULT NULL COMMENT 'spu_name',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='?Ż?ȯ????Ʒ????';

-- ----------------------------
-- Records of ams_coupon_spu_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_home_adv
-- ----------------------------
DROP TABLE IF EXISTS `ams_home_adv`;
CREATE TABLE `ams_home_adv` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) DEFAULT NULL COMMENT '?',
  `pic` varchar(500) DEFAULT NULL COMMENT 'ͼƬ??ַ',
  `start_time` datetime DEFAULT NULL COMMENT '??ʼʱ?',
  `end_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `status` tinyint(1) DEFAULT NULL COMMENT '״̬',
  `click_count` int DEFAULT NULL COMMENT '???',
  `url` varchar(500) DEFAULT NULL COMMENT '???????????ӵ?ַ',
  `note` varchar(500) DEFAULT NULL COMMENT '??ע',
  `sort` int DEFAULT NULL COMMENT '???',
  `publisher_id` bigint DEFAULT NULL COMMENT '?????',
  `auth_id` bigint DEFAULT NULL COMMENT '?????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??ҳ?ֲ????';

-- ----------------------------
-- Records of ams_home_adv
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_home_subject
-- ----------------------------
DROP TABLE IF EXISTS `ams_home_subject`;
CREATE TABLE `ams_home_subject` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT 'ר???',
  `title` varchar(255) DEFAULT NULL COMMENT 'ר?????',
  `sub_title` varchar(255) DEFAULT NULL COMMENT 'ר?⸱???',
  `status` tinyint(1) DEFAULT NULL COMMENT '??ʾ״̬',
  `url` varchar(500) DEFAULT NULL COMMENT '???????',
  `sort` int DEFAULT NULL COMMENT '???',
  `img` varchar(500) DEFAULT NULL COMMENT 'ר??ͼƬ??ַ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??ҳר??????jd??ҳ?????ܶ?ר?⣬ÿ??ר???????µ?ҳ?棬չʾר????Ʒ??Ϣ??';

-- ----------------------------
-- Records of ams_home_subject
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_home_subject_spu
-- ----------------------------
DROP TABLE IF EXISTS `ams_home_subject_spu`;
CREATE TABLE `ams_home_subject_spu` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT 'ר???',
  `subject_id` bigint DEFAULT NULL COMMENT 'ר??id',
  `spu_id` bigint DEFAULT NULL COMMENT 'spu_id',
  `sort` int DEFAULT NULL COMMENT '???',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='ר????Ʒ';

-- ----------------------------
-- Records of ams_home_subject_spu
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_member_price
-- ----------------------------
DROP TABLE IF EXISTS `ams_member_price`;
CREATE TABLE `ams_member_price` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint DEFAULT NULL COMMENT 'sku_id',
  `member_level_id` bigint DEFAULT NULL COMMENT '??Ա?ȼ?id',
  `member_level_name` varchar(100) DEFAULT NULL COMMENT '??Ա?ȼ??',
  `member_price` decimal(18,4) DEFAULT NULL COMMENT '??Ա??Ӧ?۸',
  `add_other` tinyint(1) DEFAULT NULL COMMENT '?ɷ??????????Ż?[0-???ɵ????Żݣ?1-?ɵ???]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??Ʒ??Ա?۸';

-- ----------------------------
-- Records of ams_member_price
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_seckill_promotion
-- ----------------------------
DROP TABLE IF EXISTS `ams_seckill_promotion`;
CREATE TABLE `ams_seckill_promotion` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT NULL COMMENT '????',
  `start_time` datetime DEFAULT NULL COMMENT '??ʼ???',
  `end_time` datetime DEFAULT NULL COMMENT '???????',
  `status` tinyint DEFAULT NULL COMMENT '??????״̬',
  `create_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `user_id` bigint DEFAULT NULL COMMENT '?????',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??ɱ?';

-- ----------------------------
-- Records of ams_seckill_promotion
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_seckill_session
-- ----------------------------
DROP TABLE IF EXISTS `ams_seckill_session`;
CREATE TABLE `ams_seckill_session` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(200) DEFAULT NULL COMMENT '?????',
  `start_time` datetime DEFAULT NULL COMMENT 'ÿ?տ?ʼʱ?',
  `end_time` datetime DEFAULT NULL COMMENT 'ÿ?ս???ʱ?',
  `status` tinyint(1) DEFAULT NULL COMMENT '????״̬',
  `create_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??ɱ????';

-- ----------------------------
-- Records of ams_seckill_session
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_seckill_sku_notice
-- ----------------------------
DROP TABLE IF EXISTS `ams_seckill_sku_notice`;
CREATE TABLE `ams_seckill_sku_notice` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `member_id` bigint DEFAULT NULL COMMENT 'member_id',
  `sku_id` bigint DEFAULT NULL COMMENT 'sku_id',
  `session_id` bigint DEFAULT NULL COMMENT '?????id',
  `subcribe_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `send_time` datetime DEFAULT NULL COMMENT '????ʱ?',
  `notice_type` tinyint(1) DEFAULT NULL COMMENT '֪ͨ??ʽ[0-???ţ?1-?ʼ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??ɱ??Ʒ֪ͨ???';

-- ----------------------------
-- Records of ams_seckill_sku_notice
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_seckill_sku_relation
-- ----------------------------
DROP TABLE IF EXISTS `ams_seckill_sku_relation`;
CREATE TABLE `ams_seckill_sku_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `promotion_id` bigint DEFAULT NULL COMMENT '?id',
  `promotion_session_id` bigint DEFAULT NULL COMMENT '?????id',
  `sku_id` bigint DEFAULT NULL COMMENT '??Ʒid',
  `seckill_price` decimal(10,0) DEFAULT NULL COMMENT '??ɱ?۸',
  `seckill_count` decimal(10,0) DEFAULT NULL COMMENT '??ɱ????',
  `seckill_limit` decimal(10,0) DEFAULT NULL COMMENT 'ÿ???޹??',
  `seckill_sort` int DEFAULT NULL COMMENT '???',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??ɱ???Ʒ????';

-- ----------------------------
-- Records of ams_seckill_sku_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_sku_full_reduction
-- ----------------------------
DROP TABLE IF EXISTS `ams_sku_full_reduction`;
CREATE TABLE `ams_sku_full_reduction` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint DEFAULT NULL COMMENT 'spu_id',
  `full_price` decimal(18,4) DEFAULT NULL COMMENT '?????',
  `reduce_price` decimal(18,4) DEFAULT NULL COMMENT '?????',
  `add_other` tinyint(1) DEFAULT NULL COMMENT '?Ƿ??????????Ż',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??Ʒ??????Ϣ';

-- ----------------------------
-- Records of ams_sku_full_reduction
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_sku_ladder
-- ----------------------------
DROP TABLE IF EXISTS `ams_sku_ladder`;
CREATE TABLE `ams_sku_ladder` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint DEFAULT NULL COMMENT 'spu_id',
  `full_count` int DEFAULT NULL COMMENT '?????',
  `discount` decimal(4,2) DEFAULT NULL COMMENT '?????',
  `price` decimal(18,4) DEFAULT NULL COMMENT '?ۺ',
  `add_other` tinyint(1) DEFAULT NULL COMMENT '?Ƿ??????????Ż?[0-???ɵ??ӣ?1-?ɵ???]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??Ʒ???ݼ۸';

-- ----------------------------
-- Records of ams_sku_ladder
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for ams_spu_bounds
-- ----------------------------
DROP TABLE IF EXISTS `ams_spu_bounds`;
CREATE TABLE `ams_spu_bounds` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `spu_id` bigint DEFAULT NULL,
  `grow_bounds` decimal(18,4) DEFAULT NULL COMMENT '?ɳ??',
  `buy_bounds` decimal(18,4) DEFAULT NULL COMMENT '?????',
  `work` tinyint(1) DEFAULT NULL COMMENT '?Ż???Ч????[1111???ĸ?״̬λ?????ҵ?????;0 - ???Żݣ??ɳ??????Ƿ?????;1 - ???Żݣ??????????Ƿ?????;2 - ???Żݣ??ɳ??????Ƿ?????;3 - ???Żݣ??????????Ƿ????͡?״̬λ0???????ͣ?1?????͡?]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='??Ʒspu???????';

-- ----------------------------
-- Records of ams_spu_bounds
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

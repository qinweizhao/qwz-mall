/*
 Navicat Premium Data Transfer

 Source Server         : Qwz_local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : mall_product

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 30/04/2022 01:05:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_attr
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr`;
CREATE TABLE `pms_attr`
(
    `attr_id`      bigint NOT NULL AUTO_INCREMENT COMMENT '属性id',
    `name`         char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     DEFAULT NULL COMMENT '属性名',
    `icon`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性图标',
    `value_select` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci    DEFAULT NULL COMMENT '可选值列表[用逗号分隔]',
    `value_type`   tinyint                                                       DEFAULT NULL COMMENT '值类型[0-单值，1-多值]',
    `search_type`  tinyint                                                       DEFAULT NULL COMMENT '是否需要检索[0-不需要，1-需要]',
    `type`         tinyint                                                       DEFAULT NULL COMMENT '属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]',
    `status`       bigint                                                        DEFAULT NULL COMMENT '启用状态[0 - 禁用，1 - 启用]',
    `category_id`  bigint                                                        DEFAULT NULL COMMENT '所属分类',
    `quick_show`   tinyint                                                       DEFAULT NULL COMMENT '快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整',
    `create_by`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '创建者',
    `update_by`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '更新者',
    `create_time`  datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`  datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`attr_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品属性';

-- ----------------------------
-- Table structure for pms_attr_attr_group
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr_attr_group`;
CREATE TABLE `pms_attr_attr_group`
(
    `id`            bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `attr_id`       bigint                                                        DEFAULT NULL COMMENT '属性id',
    `attr_group_id` bigint                                                        DEFAULT NULL COMMENT '属性分组id',
    `sort`          int                                                           DEFAULT NULL COMMENT '属性组内排序',
    `create_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '创建者',
    `update_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '更新者',
    `create_time`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='属性&属性分组关联';

-- ----------------------------
-- Table structure for pms_attr_group
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr_group`;
CREATE TABLE `pms_attr_group`
(
    `attr_group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分组id',
    `name`          char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     DEFAULT NULL COMMENT '组名',
    `sort`          int                                                           DEFAULT NULL COMMENT '排序',
    `description`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
    `icon`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组图标',
    `category_id`   bigint                                                        DEFAULT NULL COMMENT '所属分类id',
    `create_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '创建者',
    `update_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '更新者',
    `create_time`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`attr_group_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='属性分组';

-- ----------------------------
-- Table structure for pms_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand`
(
    `brand_id`     bigint NOT NULL AUTO_INCREMENT COMMENT '品牌id',
    `name`         char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      DEFAULT NULL COMMENT '品牌名',
    `logo`         varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌logo地址',
    `description`  longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '介绍',
    `status`       tinyint                                                        DEFAULT NULL COMMENT '显示状态[0-不显示；1-显示]',
    `first_letter` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci       DEFAULT NULL COMMENT '检索首字母',
    `sort`         int                                                            DEFAULT NULL COMMENT '排序',
    `create_by`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT '' COMMENT '创建者',
    `create_time`  datetime                                                       DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT '' COMMENT '更新者',
    `update_time`  datetime                                                       DEFAULT NULL COMMENT '更新时间',
    `remark`       varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '备注',
    PRIMARY KEY (`brand_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='品牌';

-- ----------------------------
-- Table structure for pms_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_category`;
CREATE TABLE `pms_category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '分类名称',
  `parent_id` bigint DEFAULT NULL COMMENT '父分类id',
  `level` int DEFAULT NULL COMMENT '层级',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '是否显示[0-不显示，1显示]',
  `sort` int DEFAULT NULL COMMENT '排序',
  `unit` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '计量单位',
  `count` int DEFAULT NULL COMMENT '商品数量',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1437 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品三级分类';

-- ----------------------------
-- Table structure for pms_category_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_category_brand`;
CREATE TABLE `pms_category_brand`
(
    `id`            bigint NOT NULL AUTO_INCREMENT,
    `brand_id`      bigint                                                        DEFAULT NULL COMMENT '品牌id',
    `category_id`   bigint                                                        DEFAULT NULL COMMENT '分类id',
    `brand_name`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌名称',
    `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分类名称',
    `create_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '创建者',
    `update_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '更新者',
    `create_time`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='分类&品牌关联';

-- ----------------------------
-- Table structure for pms_comment_replay
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment_replay`;
CREATE TABLE `pms_comment_replay`
(
    `id`         bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `comment_id` bigint                                                       DEFAULT NULL COMMENT '评论id',
    `replay_id`  bigint                                                       DEFAULT NULL COMMENT '回复id',
    `create_by`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品评价回复关系';

-- ----------------------------
-- Table structure for pms_sku_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_attr_value`;
CREATE TABLE `pms_sku_attr_value`
(
    `id`          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `sku_id`      bigint                                                        DEFAULT NULL COMMENT 'sku_id',
    `attr_id`     bigint                                                        DEFAULT NULL COMMENT 'attr_id',
    `name`        varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '销售属性名',
    `value`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '销售属性值',
    `sort`        int                                                           DEFAULT NULL COMMENT '顺序',
    `create_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '创建者',
    `update_by`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '更新者',
    `create_time` datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `remark`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='sku销售属性&值';

-- ----------------------------
-- Table structure for pms_sku_image
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_image`;
CREATE TABLE `pms_sku_image`
(
    `sku_id`        bigint NOT NULL COMMENT 'sku_id',
    `url`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片地址',
    `sort`          int                                                           DEFAULT NULL COMMENT '排序',
    `default_image` tinyint                                                       DEFAULT NULL COMMENT '默认图[0 - 不是默认图，1 - 是默认图]',
    `create_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '创建者',
    `update_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '更新者',
    `create_time`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='sku图片';

-- ----------------------------
-- Table structure for pms_sku_info
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_info`;
CREATE TABLE `pms_sku_info` (
  `sku_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'skuId',
  `spu_id` bigint DEFAULT NULL COMMENT 'spuId',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'sku名称',
  `desc` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'sku介绍描述',
  `category_id` bigint DEFAULT NULL COMMENT '所属分类id',
  `brand_id` bigint DEFAULT NULL COMMENT '品牌id',
  `default_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '默认图片',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `subtitle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '副标题',
  `price` decimal(18,4) DEFAULT NULL COMMENT '价格',
  `sale_count` bigint DEFAULT NULL COMMENT '销量',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='sku信息';

-- ----------------------------
-- Table structure for pms_spu_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_attr_value`;
CREATE TABLE `pms_spu_attr_value` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `spu_id` bigint DEFAULT NULL COMMENT '商品id',
  `attr_id` bigint DEFAULT NULL COMMENT '属性id',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性名',
  `value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性值',
  `sort` int DEFAULT NULL COMMENT '顺序',
  `quick_show` tinyint DEFAULT NULL COMMENT '快速展示【是否展示在介绍上；0-否 1-是】',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu属性值';

-- ----------------------------
-- Table structure for pms_spu_comment
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_comment`;
CREATE TABLE `pms_spu_comment`
(
    `id`               bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    `sku_id`           bigint                                                         DEFAULT NULL COMMENT 'sku_id',
    `spu_id`           bigint                                                         DEFAULT NULL COMMENT 'spu_id',
    `spu_name`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '商品名字',
    `member_nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '会员昵称',
    `star`             tinyint(1) DEFAULT NULL COMMENT '星级',
    `member_ip`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci   DEFAULT NULL COMMENT '会员ip',
    `show_status`      tinyint(1) DEFAULT NULL COMMENT '显示状态[0-不显示，1-显示]',
    `spu_attributes`   varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '购买时属性组合',
    `likes_count`      int                                                            DEFAULT NULL COMMENT '点赞数',
    `reply_count`      int                                                            DEFAULT NULL COMMENT '回复数',
    `resources`        varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]',
    `content`          text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '内容',
    `member_avatar`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '用户头像',
    `type`             tinyint                                                        DEFAULT NULL COMMENT '评论类型[0 - 对商品的直接评论，1 - 对评论的回复]',
    `create_by`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT '' COMMENT '创建者',
    `update_by`        varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci   DEFAULT '' COMMENT '更新者',
    `create_time`      datetime                                                       DEFAULT NULL COMMENT '创建时间',
    `update_time`      datetime                                                       DEFAULT NULL COMMENT '更新时间',
    `remark`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品评价';

-- ----------------------------
-- Table structure for pms_spu_image
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_image`;
CREATE TABLE `pms_spu_image`
(
    `spu_id`        bigint NOT NULL COMMENT 'spu_id',
    `name`          varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片名',
    `url`           varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片地址',
    `sort`          int                                                           DEFAULT NULL COMMENT '顺序',
    `default_image` tinyint                                                       DEFAULT NULL COMMENT '是否默认图',
    `create_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '创建者',
    `update_by`     varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  DEFAULT '' COMMENT '更新者',
    `create_time`   datetime                                                      DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                      DEFAULT NULL COMMENT '更新时间',
    `remark`        varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`spu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu图片';

-- ----------------------------
-- Table structure for pms_spu_info
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_info`;
CREATE TABLE `pms_spu_info` (
  `spu_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名称',
  `desc` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品描述',
  `category_id` bigint DEFAULT NULL COMMENT '所属分类id',
  `brand_id` bigint DEFAULT NULL COMMENT '品牌id',
  `weight` decimal(18,4) DEFAULT NULL,
  `status` tinyint DEFAULT NULL COMMENT '上架状态[0 - 下架，1 - 上架]',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`spu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu信息';

-- ----------------------------
-- Table structure for pms_spu_info_desc
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_info_desc`;
CREATE TABLE `pms_spu_info_desc` (
  `spu_id` bigint NOT NULL COMMENT '商品id',
  `desc` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '商品介绍',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '创建者',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '更新者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`spu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu信息介绍';

SET FOREIGN_KEY_CHECKS = 1;

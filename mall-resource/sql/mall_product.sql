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

 Date: 03/04/2022 03:24:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pms_attr
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr`;
CREATE TABLE `pms_attr` (
  `attr_id` bigint NOT NULL AUTO_INCREMENT COMMENT '属性id',
  `attr_name` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性名',
  `search_type` tinyint DEFAULT NULL COMMENT '是否需要检索[0-不需要，1-需要]',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性图标',
  `value_select` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '可选值列表[用逗号分隔]',
  `attr_type` tinyint DEFAULT NULL COMMENT '属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]',
  `enable` bigint DEFAULT NULL COMMENT '启用状态[0 - 禁用，1 - 启用]',
  `catelog_id` bigint DEFAULT NULL COMMENT '所属分类',
  `show_desc` tinyint DEFAULT NULL COMMENT '快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品属性';

-- ----------------------------
-- Records of pms_attr
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_attr_attrgroup_relation
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr_attrgroup_relation`;
CREATE TABLE `pms_attr_attrgroup_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attr_id` bigint DEFAULT NULL COMMENT '属性id',
  `attr_group_id` bigint DEFAULT NULL COMMENT '属性分组id',
  `attr_sort` int DEFAULT NULL COMMENT '属性组内排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='属性&属性分组关联';

-- ----------------------------
-- Records of pms_attr_attrgroup_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_attr_group
-- ----------------------------
DROP TABLE IF EXISTS `pms_attr_group`;
CREATE TABLE `pms_attr_group` (
  `attr_group_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分组id',
  `attr_group_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组名',
  `sort` int DEFAULT NULL COMMENT '排序',
  `descript` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '组图标',
  `catelog_id` bigint DEFAULT NULL COMMENT '所属分类id',
  PRIMARY KEY (`attr_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='属性分组';

-- ----------------------------
-- Records of pms_attr_group
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_brand
-- ----------------------------
DROP TABLE IF EXISTS `pms_brand`;
CREATE TABLE `pms_brand` (
  `brand_id` bigint NOT NULL AUTO_INCREMENT COMMENT '品牌id',
  `name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌名',
  `logo` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌logo地址',
  `descript` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '介绍',
  `show_status` tinyint DEFAULT NULL COMMENT '显示状态[0-不显示；1-显示]',
  `first_letter` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '检索首字母',
  `sort` int DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='品牌';

-- ----------------------------
-- Records of pms_brand
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_category
-- ----------------------------
DROP TABLE IF EXISTS `pms_category`;
CREATE TABLE `pms_category` (
  `cat_id` bigint NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `name` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分类名称',
  `parent_cid` bigint DEFAULT NULL COMMENT '父分类id',
  `cat_level` int DEFAULT NULL COMMENT '层级',
  `show_status` tinyint DEFAULT NULL COMMENT '是否显示[0-不显示，1显示]',
  `sort` int DEFAULT NULL COMMENT '排序',
  `icon` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图标地址',
  `product_unit` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '计量单位',
  `product_count` int DEFAULT NULL COMMENT '商品数量',
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品三级分类';

-- ----------------------------
-- Records of pms_category
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_category_brand_relation
-- ----------------------------
DROP TABLE IF EXISTS `pms_category_brand_relation`;
CREATE TABLE `pms_category_brand_relation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `brand_id` bigint DEFAULT NULL COMMENT '品牌id',
  `catelog_id` bigint DEFAULT NULL COMMENT '分类id',
  `brand_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '品牌名称',
  `catelog_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='分类&品牌关联';

-- ----------------------------
-- Records of pms_category_brand_relation
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_comment_replay
-- ----------------------------
DROP TABLE IF EXISTS `pms_comment_replay`;
CREATE TABLE `pms_comment_replay` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `comment_id` bigint DEFAULT NULL COMMENT '评论id',
  `reply_id` bigint DEFAULT NULL COMMENT '回复id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品评价回复关系';

-- ----------------------------
-- Records of pms_comment_replay
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_product_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_product_attr_value`;
CREATE TABLE `pms_product_attr_value` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `spu_id` bigint DEFAULT NULL COMMENT '商品id',
  `attr_id` bigint DEFAULT NULL COMMENT '属性id',
  `attr_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性名',
  `attr_value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性值',
  `attr_sort` int DEFAULT NULL COMMENT '顺序',
  `quick_show` tinyint DEFAULT NULL COMMENT '快速展示【是否展示在介绍上；0-否 1-是】',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu属性值';

-- ----------------------------
-- Records of pms_product_attr_value
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_sku_images
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_images`;
CREATE TABLE `pms_sku_images` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint DEFAULT NULL COMMENT 'sku_id',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片地址',
  `img_sort` int DEFAULT NULL COMMENT '排序',
  `default_img` int DEFAULT NULL COMMENT '默认图[0 - 不是默认图，1 - 是默认图]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='sku图片';

-- ----------------------------
-- Records of pms_sku_images
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_sku_info
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_info`;
CREATE TABLE `pms_sku_info` (
  `sku_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'skuId',
  `spu_id` bigint DEFAULT NULL COMMENT 'spuId',
  `sku_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'sku名称',
  `sku_desc` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT 'sku介绍描述',
  `catalog_id` bigint DEFAULT NULL COMMENT '所属分类id',
  `brand_id` bigint DEFAULT NULL COMMENT '品牌id',
  `sku_default_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '默认图片',
  `sku_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '标题',
  `sku_subtitle` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '副标题',
  `price` decimal(18,4) DEFAULT NULL COMMENT '价格',
  `sale_count` bigint DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`sku_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='sku信息';

-- ----------------------------
-- Records of pms_sku_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_sku_sale_attr_value
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_sale_attr_value`;
CREATE TABLE `pms_sku_sale_attr_value` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint DEFAULT NULL COMMENT 'sku_id',
  `attr_id` bigint DEFAULT NULL COMMENT 'attr_id',
  `attr_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '销售属性名',
  `attr_value` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '销售属性值',
  `attr_sort` int DEFAULT NULL COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='sku销售属性&值';

-- ----------------------------
-- Records of pms_sku_sale_attr_value
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_spu_comment
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_comment`;
CREATE TABLE `pms_spu_comment` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sku_id` bigint DEFAULT NULL COMMENT 'sku_id',
  `spu_id` bigint DEFAULT NULL COMMENT 'spu_id',
  `spu_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名字',
  `member_nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '会员昵称',
  `star` tinyint(1) DEFAULT NULL COMMENT '星级',
  `member_ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '会员ip',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `show_status` tinyint(1) DEFAULT NULL COMMENT '显示状态[0-不显示，1-显示]',
  `spu_attributes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '购买时属性组合',
  `likes_count` int DEFAULT NULL COMMENT '点赞数',
  `reply_count` int DEFAULT NULL COMMENT '回复数',
  `resources` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '内容',
  `member_icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户头像',
  `comment_type` tinyint DEFAULT NULL COMMENT '评论类型[0 - 对商品的直接评论，1 - 对评论的回复]',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品评价';

-- ----------------------------
-- Records of pms_spu_comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_spu_images
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_images`;
CREATE TABLE `pms_spu_images` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `spu_id` bigint DEFAULT NULL COMMENT 'spu_id',
  `img_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片名',
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '图片地址',
  `img_sort` int DEFAULT NULL COMMENT '顺序',
  `default_img` tinyint DEFAULT NULL COMMENT '是否默认图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu图片';

-- ----------------------------
-- Records of pms_spu_images
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_spu_info
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_info`;
CREATE TABLE `pms_spu_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `spu_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品名称',
  `spu_description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '商品描述',
  `catalog_id` bigint DEFAULT NULL COMMENT '所属分类id',
  `brand_id` bigint DEFAULT NULL COMMENT '品牌id',
  `weight` decimal(18,4) DEFAULT NULL,
  `publish_status` tinyint DEFAULT NULL COMMENT '上架状态[0 - 下架，1 - 上架]',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu信息';

-- ----------------------------
-- Records of pms_spu_info
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pms_spu_info_desc
-- ----------------------------
DROP TABLE IF EXISTS `pms_spu_info_desc`;
CREATE TABLE `pms_spu_info_desc` (
  `spu_id` bigint NOT NULL COMMENT '商品id',
  `decript` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '商品介绍',
  PRIMARY KEY (`spu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='spu信息介绍';

-- ----------------------------
-- Records of pms_spu_info_desc
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

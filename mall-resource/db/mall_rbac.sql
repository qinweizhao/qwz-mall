/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 8.0.25 : Database - mall_rbac
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mall_rbac` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `mall_rbac`;

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menu_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `parent_id` bigint unsigned NOT NULL COMMENT '父菜单ID，一级菜单为0',
  `biz_type` tinyint DEFAULT NULL COMMENT '业务类型 1 店铺菜单 2平台菜单',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '权限，需要有哪个权限才能访问该菜单',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '路径 就像uri',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '1.''Layout'' 为布局，不会跳页面 2.''components-demo/tinymce'' 跳转到该页面',
  `redirect` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '当设置 noRedirect 的时候该路由在面包屑导航中不可被点击',
  `always_show` tinyint DEFAULT NULL COMMENT '一直显示根路由',
  `hidden` tinyint DEFAULT NULL COMMENT '当设置 true 的时候该路由不会在侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题',
  `title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设置该路由在侧边栏和面包屑中展示的名字',
  `icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '设置该路由的图标，支持 svg-class，也支持 el-icon-x element-ui 的 icon',
  `no_cache` tinyint DEFAULT NULL COMMENT '如果设置为true，则不会被 <keep-alive> 缓存(默认 false)',
  `breadcrumb` tinyint DEFAULT NULL COMMENT '如果设置为false，则不会在breadcrumb面包屑中显示(默认 true)',
  `affix` tinyint DEFAULT NULL COMMENT '若果设置为true，它则会固定在tags-view中(默认 false)',
  `active_menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '当路由设置了该属性，则会高亮相对应的侧边栏。',
  `seq` int DEFAULT NULL COMMENT '排序，越小越靠前',
  PRIMARY KEY (`menu_id`) USING BTREE,
  KEY `idx_pid` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=328 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单管理';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (111, '2020-12-01 14:20:42', '2021-01-28 10:12:08', 0, 1, NULL, '/rbac', 'Layout', NULL, NULL, 0, '权限管理', '权限管理', 'el-icon-office-building', NULL, NULL, NULL, NULL, 99);
INSERT INTO `menu` VALUES (112, '2020-12-01 14:22:09', '2021-01-28 10:12:14', 111, 1, NULL, '/multishop/shop_user', 'multishop/shop-user', NULL, NULL, 0, '用户管理', '用户管理', '', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (134, '2020-12-03 16:49:48', '2021-01-28 10:12:22', 111, 1, NULL, 'role', 'rbac/role', NULL, NULL, 0, '角色管理', '角色管理', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (137, '2020-12-03 17:54:02', '2021-01-28 10:13:07', 141, 1, NULL, 'attr', 'product/attr', NULL, NULL, 0, '属性管理', '属性管理', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (139, '2020-12-03 17:54:02', '2021-01-28 10:13:20', 141, 1, NULL, 'category', 'product/category', NULL, NULL, 0, 'category', '分类管理', NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `menu` VALUES (141, '2020-12-03 17:55:22', '2021-01-01 09:01:48', 0, 1, NULL, '/product', 'Layout', NULL, NULL, 0, '商品管理', '商品管理', 'product', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (142, '2020-12-03 17:54:02', '2021-03-12 09:31:52', 141, 1, NULL, 'prod_info', 'product/prod-info', NULL, NULL, 0, '发布商品', '发布商品', NULL, NULL, NULL, NULL, NULL, 4);
INSERT INTO `menu` VALUES (145, '2020-12-04 10:08:17', '2021-01-28 10:13:47', 0, 1, NULL, '/multishop', 'Layout', NULL, NULL, 0, '店铺管理', '店铺管理', 'el-icon-house', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (146, '2020-12-04 10:09:38', '2021-01-28 10:13:53', 145, 1, NULL, 'index_img', 'multishop/index-img', NULL, NULL, 0, '轮播图管理', '轮播图管理', '', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (147, '2020-12-04 11:30:59', '2021-01-01 09:28:45', 0, 1, NULL, '/order', 'Layout', NULL, NULL, 0, '订单管理', '订单管理', 'order', NULL, NULL, NULL, NULL, 90);
INSERT INTO `menu` VALUES (148, '2020-12-04 11:32:46', '2021-01-28 09:52:10', 147, 1, NULL, 'order', 'order/order', NULL, NULL, 0, 'order', '订单管理', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (152, '2020-12-16 10:16:39', '2021-01-28 10:13:32', 141, 1, NULL, 'list', 'product/list', NULL, NULL, 0, '商品列表', '商品列表', '', NULL, NULL, NULL, NULL, 5);
INSERT INTO `menu` VALUES (155, '2020-12-01 14:20:42', '2021-04-22 10:30:44', 0, 2, NULL, '/rbac', 'Layout', NULL, NULL, 0, '权限管理', '权限管理', 'el-icon-office-building', NULL, NULL, NULL, NULL, 99);
INSERT INTO `menu` VALUES (156, '2020-12-01 14:22:09', '2021-04-22 10:30:44', 155, 2, NULL, '/platform/sys_user', 'platform/sys-user', NULL, NULL, 0, '用户管理', '用户管理', '', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (157, '2020-12-03 16:49:48', '2021-04-22 10:30:44', 155, 2, NULL, 'role', 'rbac/role', NULL, NULL, 0, '角色管理', '角色管理', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (158, '2020-12-03 16:49:48', '2021-04-22 10:30:44', 155, 2, NULL, 'menu', 'rbac/menu', NULL, NULL, 0, '平台菜单管理', '平台菜单管理', NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `menu` VALUES (159, '2020-12-03 16:49:48', '2021-04-22 10:30:44', 155, 2, NULL, 'menu_permission', 'rbac/menu-permission', NULL, NULL, 0, '菜单资源', '菜单资源', NULL, NULL, NULL, NULL, NULL, 3);
INSERT INTO `menu` VALUES (160, '2020-12-03 17:54:02', '2021-04-22 10:30:44', 164, 2, NULL, 'attr', 'product/attr', NULL, NULL, 0, '属性管理', '属性管理', NULL, NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (161, '2020-12-03 17:54:02', '2021-04-22 10:30:44', 164, 2, NULL, 'brand', 'product/brand', NULL, NULL, 0, '品牌管理', '品牌管理', NULL, NULL, NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (162, '2020-12-03 17:54:02', '2021-04-22 10:30:44', 164, 2, NULL, 'category', 'product/category', NULL, NULL, 0, 'category', '分类管理', NULL, NULL, NULL, NULL, NULL, 2);
INSERT INTO `menu` VALUES (164, '2020-12-03 17:55:22', '2021-04-22 10:30:44', 0, 2, NULL, '/product', 'Layout', NULL, NULL, 0, 'product', '商品管理', 'el-icon-shopping-bag-1', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (175, '2020-12-16 10:16:39', '2021-04-22 10:30:44', 164, 2, NULL, 'list', 'product/list', NULL, NULL, 0, '商品管理', '商品管理', '', NULL, NULL, NULL, NULL, 5);
INSERT INTO `menu` VALUES (178, '2020-12-22 09:26:41', '2021-04-22 10:30:44', 155, 2, NULL, 'shop-menu', 'rbac/shop-menu', NULL, NULL, 0, '店铺菜单管理', '店铺菜单管理', '', NULL, NULL, NULL, NULL, 2);
INSERT INTO `menu` VALUES (255, '2021-01-27 14:10:56', '2021-04-22 10:30:44', 0, 2, NULL, '/platform', 'Layout', NULL, NULL, 0, 'platform', '平台管理', 'tree', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (256, '2021-01-27 14:14:51', '2021-04-22 10:30:44', 255, 2, NULL, 'hot-search', 'platform/hot-search', NULL, NULL, 0, 'hot-search', '热搜管理', 'el-icon-search', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (257, '2021-01-28 09:48:39', '2021-04-22 10:30:44', 255, 2, NULL, 'index-img', 'platform/index-img', NULL, NULL, 0, '轮播图管理', '轮播图管理', 'el-icon-picture-outline', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (258, '2021-01-28 11:06:52', '2021-01-28 11:06:52', 145, 1, NULL, 'hot-search', 'multishop/hot-search', NULL, NULL, 0, 'hot-search', '热搜管理', '', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (302, '2021-05-13 19:02:02', '2021-05-13 19:02:20', 255, 2, NULL, 'shop-detail', 'platform/shop-detail', NULL, NULL, 1, '店铺详情', '店铺详情', '', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (306, '2021-05-14 17:32:04', '2021-05-14 17:34:08', 255, 2, NULL, 'shop-edit', 'platform/shop-edit', NULL, NULL, 1, '店铺编辑', '店铺编辑', '', NULL, NULL, NULL, NULL, 0);
INSERT INTO `menu` VALUES (327, '2021-06-30 20:22:45', '2021-06-30 20:25:49', 255, 2, NULL, 'shop-manage', 'platform/shop-manage', NULL, NULL, 0, '店铺管理', '店铺管理', 'el-icon-s-order', NULL, NULL, NULL, NULL, 3);

/*Table structure for table `menu_permission` */

DROP TABLE IF EXISTS `menu_permission`;

CREATE TABLE `menu_permission` (
  `menu_permission_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '菜单资源用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `menu_id` bigint NOT NULL COMMENT '资源关联菜单',
  `biz_type` tinyint NOT NULL COMMENT '业务类型 1 店铺菜单 2平台菜单',
  `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '权限对应的编码',
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源名称',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '资源对应服务器路径',
  `method` tinyint NOT NULL COMMENT '请求方法 1.GET 2.POST 3.PUT 4.DELETE',
  PRIMARY KEY (`menu_permission_id`) USING BTREE,
  UNIQUE KEY `uk_permission` (`permission`,`biz_type`) USING BTREE,
  KEY `idx_menuid` (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单资源';

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `role_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint unsigned NOT NULL COMMENT '创建者ID',
  `biz_type` tinyint DEFAULT NULL COMMENT '业务类型 1 店铺菜单 2平台菜单',
  `tenant_id` bigint DEFAULT NULL COMMENT '所属租户',
  PRIMARY KEY (`role_id`) USING BTREE,
  KEY `idx_tenant_id` (`tenant_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色';

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `role_id` bigint unsigned NOT NULL COMMENT '角色ID',
  `menu_id` bigint unsigned DEFAULT NULL COMMENT '菜单ID',
  `menu_permission_id` bigint unsigned DEFAULT NULL COMMENT '菜单资源用户id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_roleid_menu_permission_id` (`role_id`,`menu_id`,`menu_permission_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1924 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色与菜单对应关系';

/*Table structure for table `undo_log` */

DROP TABLE IF EXISTS `undo_log`;

CREATE TABLE `undo_log` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `branch_id` bigint NOT NULL,
  `xid` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `context` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '关联id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `user_id` bigint unsigned NOT NULL COMMENT '用户ID',
  `role_id` bigint unsigned NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_userid_roleid` (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=254 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与角色对应关系';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

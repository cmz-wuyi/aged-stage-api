/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : aged-stage-put

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 10/02/2022 09:57:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_department
-- ----------------------------
DROP TABLE IF EXISTS `auth_department`;
CREATE TABLE `auth_department`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `department_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '部门主键ID',
  `department_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '部门名称',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '父级部门ID',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '权限模块->部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_department
-- ----------------------------
INSERT INTO `auth_department` VALUES (44, 'bfc4244697f1223cac7519052f6ed72f', '炒股部', '0', 888, '2021-10-28 20:08:27', '2021-11-03 20:30:29', 2, '0');
INSERT INTO `auth_department` VALUES (45, '46d48c7d4384ff472825febb880b5793', '编程部', '0', 2, '2021-10-28 20:10:38', '2021-10-28 20:10:38', 2, '0');

-- ----------------------------
-- Table structure for auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `auth_menu`;
CREATE TABLE `auth_menu`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_menu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '系统菜单主键ID',
  `menu_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '菜单名称',
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '父级菜单ID\n',
  `path` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '前端path / 即跳转路由',
  `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '对应Vue组件',
  `perms` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '权限',
  `menu_icon` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '菜单图标',
  `menu_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '菜单类型 0->按钮,1->菜单',
  `order_num` int(1) NULL DEFAULT 2 COMMENT '序号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 536 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统权限->菜单表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_menu
-- ----------------------------
INSERT INTO `auth_menu` VALUES (1, '709308cc01fb72d06fae204acc0bcf95', '系统管理', '0', '/system', 'PageView', '', 'appstore-o', '0', 6, '2022-01-25 14:55:01', '2022-01-25 14:55:01', 2, '0');
INSERT INTO `auth_menu` VALUES (3, '4df8e55e6ebf32baa56f9e90f2d2fd66', '系统用户', '709308cc01fb72d06fae204acc0bcf95', '/system/auth-user/ItemList', 'system/auth-user/ItemList', 'user:view', 'team', '0', 1, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (4, '8c79ce8c49b3d8eb8e2a62a0186114a9', '角色管理', '709308cc01fb72d06fae204acc0bcf95', '/system/auth-role', 'system/auth-role/ItemList', 'role:view', 'idcard', '0', 1, '2022-01-25 14:55:21', '2022-01-25 14:55:21', 2, '0');
INSERT INTO `auth_menu` VALUES (11, '50fe30a5a0669bf5bb04e03fe932954a', '新增用户', '4df8e55e6ebf32baa56f9e90f2d2fd66', '', '', 'user:add', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (12, '8dd1f283775e1b4113779119a391c3e7', '修改用户', '4df8e55e6ebf32baa56f9e90f2d2fd66', '', '', 'user:update', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (13, '513c77c813532ffceeadb5d4833e55e1', '删除用户', '4df8e55e6ebf32baa56f9e90f2d2fd66', '', '', 'user:delete', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (14, 'a87e0f688835ca9184aaad6518db6a5d', '新增角色', '8c79ce8c49b3d8eb8e2a62a0186114a9', '', '', 'role:add', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (15, '7bc0cb66696b0d3aee2d8d74d0b4c798', '修改角色', '8c79ce8c49b3d8eb8e2a62a0186114a9', '', '', 'role:update', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (16, '5586b7b69349fa03d0f5704fe4a60122', '删除角色', '8c79ce8c49b3d8eb8e2a62a0186114a9', '', '', 'role:delete', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (20, 'd287f31353fe99843758e501905915e2', '新增部门', '089a07f917374c44974b1ee6ebe203f9', '', '', 'dept:add', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (21, 'f0f19daaa43e078557d62be15888b5e4', '修改部门', '089a07f917374c44974b1ee6ebe203f9', '', '', 'dept:update', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (22, '16a6b5341f47cd8b116124828f75e80d', '删除部门', '089a07f917374c44974b1ee6ebe203f9', '', '', 'dept:delete', '', '1', 0, '2019-08-22 12:02:44', '2019-08-22 12:02:44', 2, '0');
INSERT INTO `auth_menu` VALUES (135, '17f77194f4835c971c72b4e024884d5d', '密码重置', '4df8e55e6ebf32baa56f9e90f2d2fd66', '', '', 'authUser:resetPassword', '', '1', 0, '2021-07-16 11:26:16', '2021-07-16 11:26:16', 2, '0');
INSERT INTO `auth_menu` VALUES (182, '3f6cabca1bf27da17af2b8862477c467', '更新系统标签', 'e1ed308937684d4f3d77e0a5e5286660', NULL, NULL, 'system:updateSysTemTag', NULL, '1', NULL, '2020-07-07 12:45:32', '2020-07-07 12:45:32', 2, '0');
INSERT INTO `auth_menu` VALUES (183, '1f0ae74c234a0807ec236aac26aa4f36', '新增系统标签', 'e1ed308937684d4f3d77e0a5e5286660', NULL, NULL, 'system:addSysTemTag', NULL, '1', NULL, '2020-07-07 12:46:59', '2020-07-07 12:46:59', 2, '0');
INSERT INTO `auth_menu` VALUES (184, '1b59f317a32f6d39aaee47b245445a1c', '删除系统标签', 'e1ed308937684d4f3d77e0a5e5286660', NULL, NULL, 'system:deleteSysTemTag', NULL, '1', NULL, '2020-07-07 12:47:21', '2020-07-07 12:47:21', 2, '0');
INSERT INTO `auth_menu` VALUES (186, '8c86085f63ecd2ecf2cd05c824153990', '新增业务字典', '4036de2815e6ef844413117da6580e14', NULL, NULL, 'system:addBusinessDict', NULL, '1', NULL, '2020-07-07 14:02:40', '2020-07-07 14:02:40', 2, '0');
INSERT INTO `auth_menu` VALUES (187, '2868fd6c61c019d539a09eb45671a6ae', '更新业务字典', '4036de2815e6ef844413117da6580e14', NULL, NULL, 'system:updateBusinessDict', NULL, '1', NULL, '2020-07-07 14:03:00', '2020-07-07 14:03:00', 2, '0');
INSERT INTO `auth_menu` VALUES (188, '65fd91c00487a1eca1811eae7a21ddcd', '删除业务字典', '4036de2815e6ef844413117da6580e14', NULL, NULL, 'system:deleteBusinessDict', NULL, '1', NULL, '2020-07-07 14:03:21', '2020-07-07 14:03:21', 2, '0');
INSERT INTO `auth_menu` VALUES (499, 'e807c78e50b8f5ca8e0bb5ee1549c400', '老人信息', '0', '/old-sketch', 'PageView', 'oldSketch:itemList', 'fire', '0', 2, '2022-01-25 14:55:15', '2022-01-25 14:55:15', 2, '0');
INSERT INTO `auth_menu` VALUES (500, '6ea458441dedf531f7e45ac0badc7054', '老人信息管理', 'e807c78e50b8f5ca8e0bb5ee1549c400', '/old-sketch/ItemList', 'old-sketch/ItemList', 'oldSketch:itemList', 'fire', '0', 1, '2021-12-14 14:48:21', '2021-12-14 14:48:21', 2, '0');
INSERT INTO `auth_menu` VALUES (501, 'b33e4933cc19ce428ab5b3c56a065281', '更新数据', '6ea458441dedf531f7e45ac0badc7054', NULL, NULL, 'oldSketch:edit', NULL, '1', NULL, '2021-12-14 14:49:16', '2021-12-14 14:49:16', 2, '0');
INSERT INTO `auth_menu` VALUES (502, '61f6077c4106dec895ea4e78e4d22a10', '删除数据', '6ea458441dedf531f7e45ac0badc7054', NULL, NULL, 'oldSketch:batchDelete', NULL, '1', NULL, '2021-12-14 14:49:35', '2021-12-14 14:49:35', 2, '0');
INSERT INTO `auth_menu` VALUES (503, '9c63129ccaea01725557921b083c47f4', '新增数据', '6ea458441dedf531f7e45ac0badc7054', NULL, NULL, 'oldSketch:add', NULL, '1', NULL, '2021-12-14 14:49:55', '2021-12-14 14:49:55', 2, '0');
INSERT INTO `auth_menu` VALUES (504, '2b6f347a39a22283f3564f50957a9577', '个性化服务管理', '0', '/accident-record', 'PageView', 'accidentRecord:itemList', 'fire', '0', 3, '2022-02-07 11:33:16', '2022-02-07 11:33:16', 2, '0');
INSERT INTO `auth_menu` VALUES (505, '0e9b86afaba99991ec761928a4dd7326', '服务记录', '2b6f347a39a22283f3564f50957a9577', '/accident-record/ItemList', 'accident-record/ItemList', 'accidentRecord:itemList', 'fire', '0', 1, '2022-02-10 09:32:16', '2022-02-10 09:32:16', 2, '0');
INSERT INTO `auth_menu` VALUES (506, 'cae197b1556f27ca708b21ffa46351cc', '数据新增', '0e9b86afaba99991ec761928a4dd7326', NULL, NULL, 'accidentRecord:add', NULL, '1', NULL, '2022-02-07 11:33:22', '2022-02-07 11:33:22', 2, '0');
INSERT INTO `auth_menu` VALUES (507, '85521637f313ab1c706bbdfbb368f4c6', '数据删除', '0e9b86afaba99991ec761928a4dd7326', NULL, NULL, 'accidentRecord:batchDelete', NULL, '1', NULL, '2022-02-07 11:33:25', '2022-02-07 11:33:25', 2, '0');
INSERT INTO `auth_menu` VALUES (508, 'db0cae6899ef0146a6ede5d4de592466', '数据编辑', '0e9b86afaba99991ec761928a4dd7326', NULL, NULL, 'accidentRecord:edit', NULL, '1', NULL, '2022-02-07 11:33:27', '2022-02-07 11:33:27', 2, '0');
INSERT INTO `auth_menu` VALUES (509, 'afd0327f2287b3ff34af80e7c7e0afae', '活动管理', '0', '/bed-sketch', 'PageView', 'activity:itemList', 'fire', '0', 4, '2022-02-08 15:30:13', '2022-02-08 15:30:13', 2, '0');
INSERT INTO `auth_menu` VALUES (510, 'c41858385a4ac6096a0b8aceea9043a3', '活动信息', 'afd0327f2287b3ff34af80e7c7e0afae', '/bed-sketch/ItemList', 'bed-sketch/ItemList', 'activity:itemList', 'fire', '0', 1, '2022-02-10 09:34:21', '2022-02-10 09:34:21', 2, '0');
INSERT INTO `auth_menu` VALUES (511, '5034b9a9c8e2713b8e52c63ddb1d4fd5', '数据新增', 'c41858385a4ac6096a0b8aceea9043a3', NULL, NULL, 'activity:add', NULL, '1', NULL, '2022-02-08 15:30:20', '2022-02-08 15:30:20', 2, '0');
INSERT INTO `auth_menu` VALUES (512, 'a76854fa7241947a6ff60688609789a3', '数据删除', 'c41858385a4ac6096a0b8aceea9043a3', NULL, NULL, 'activity:batchDelete', NULL, '1', NULL, '2022-02-08 15:30:22', '2022-02-08 15:30:22', 2, '0');
INSERT INTO `auth_menu` VALUES (513, '238b867b9e016685cb56df2e8abe31fb', '数据编辑', 'c41858385a4ac6096a0b8aceea9043a3', NULL, NULL, 'activity:edit', NULL, '1', NULL, '2022-02-08 15:30:25', '2022-02-08 15:30:25', 2, '0');
INSERT INTO `auth_menu` VALUES (515, '733f510ebefbf8b4f9c07bb14c63cec2', '分配床位', 'e87771a49cf03bd7c97cb29ca90838a8', NULL, NULL, 'activity:allot', NULL, '1', NULL, '2022-02-08 15:30:28', '2022-02-08 15:30:28', 2, '0');
INSERT INTO `auth_menu` VALUES (516, 'be944363be36bad38ea60f01f6f0dcb8', '网格员管理', '0', '/nursing-salary', 'PageView', 'volunteerInfo:itemList', 'fire', '0', 5, '2022-02-09 10:09:48', '2022-02-09 10:09:48', 2, '0');
INSERT INTO `auth_menu` VALUES (517, 'ec1e786e41eabfbca57fa5ec4ed33b45', '网格员管理', 'be944363be36bad38ea60f01f6f0dcb8', '/nursing-salary/ItemList', 'nursing-salary/ItemList', 'volunteerInfo:itemList', 'fire', '0', 1, '2022-02-09 10:09:55', '2022-02-09 10:09:55', 2, '0');
INSERT INTO `auth_menu` VALUES (518, 'd04d5d613415d26ff6584d4dc1eedc80', '数据新增', 'ec1e786e41eabfbca57fa5ec4ed33b45', NULL, NULL, 'volunteerInfo:add', NULL, '1', NULL, '2022-02-09 10:09:58', '2022-02-09 10:09:58', 2, '0');
INSERT INTO `auth_menu` VALUES (519, '9f0c5280ff577bafe7857c7c59ef0fd0', '数据删除', 'ec1e786e41eabfbca57fa5ec4ed33b45', NULL, NULL, 'volunteerInfo:batchDelete', 'fire', '1', NULL, '2022-02-09 10:10:02', '2022-02-09 10:10:02', 2, '0');
INSERT INTO `auth_menu` VALUES (520, '37cf27cbfd7e79eb4c141fe80bf7813d', '数据编辑', 'ec1e786e41eabfbca57fa5ec4ed33b45', NULL, NULL, 'volunteerInfo:edit', NULL, '1', NULL, '2022-02-09 10:10:06', '2022-02-09 10:10:06', 2, '0');
INSERT INTO `auth_menu` VALUES (522, 'a48b55f65539f3e498c667a562c9a8f8', '志愿者请假管理', 'be944363be36bad38ea60f01f6f0dcb8', '/nursing-time-off/ItemList', 'nursing-time-off/ItemList', 'nursingTimeOff:itemList', 'fire', '0', 1, '2022-02-10 09:33:37', '2022-02-10 09:33:37', 2, '0');
INSERT INTO `auth_menu` VALUES (523, 'fb06b6e9470e3d222e4b1df9b5bcee00', '数据新增', 'a48b55f65539f3e498c667a562c9a8f8', NULL, NULL, 'nursingTimeOff:add', NULL, '1', NULL, '2021-12-15 09:49:33', '2021-12-15 09:49:33', 2, '0');
INSERT INTO `auth_menu` VALUES (524, '5bf2e4d515ce82300b28f60c7a361f49', '数据删除', 'a48b55f65539f3e498c667a562c9a8f8', NULL, NULL, 'nursingTimeOff:batchDelete', NULL, '1', NULL, '2021-12-15 09:49:47', '2021-12-15 09:49:47', 2, '0');
INSERT INTO `auth_menu` VALUES (525, 'c70ba840f15f74d0ab29d36a8229a7dd', '数据编辑', 'a48b55f65539f3e498c667a562c9a8f8', NULL, NULL, 'nursingTimeOff:edit', NULL, '1', NULL, '2021-12-15 09:49:59', '2021-12-15 09:49:59', 2, '0');
INSERT INTO `auth_menu` VALUES (526, '5e9414b31db45fb233e18d8c848cd649', '查询所有护工薪资', 'ec1e786e41eabfbca57fa5ec4ed33b45', NULL, NULL, 'volunteerInfo:queryAll', NULL, '1', NULL, '2022-02-09 10:10:08', '2022-02-09 10:10:08', 2, '0');
INSERT INTO `auth_menu` VALUES (527, 'f8117a59c2cac0f393b22fe5645028bc', '查询所有老人', '6ea458441dedf531f7e45ac0badc7054', NULL, NULL, 'oldSketch:queryAll', NULL, '1', NULL, '2021-12-31 12:01:23', '2021-12-31 12:01:23', 2, '0');
INSERT INTO `auth_menu` VALUES (528, 'f8117a59c2c1293b22fe5645028bc', '查询所有护工请假信息', 'a48b55f65539f3e498c667a562c9a8f8', NULL, NULL, 'nursingTimeOff:queryAll', NULL, '1', NULL, '2021-12-31 12:01:23', '2021-12-31 12:01:23', 2, '0');
INSERT INTO `auth_menu` VALUES (529, 'f8117a59c2c1293b22fe5645028bd', '服务配置', '2b6f347a39a22283f3564f50957a9577', '/service-template-config', 'service-template-config/ItemList', 'templateService:itemList', 'fire', '0', 2, '2022-01-27 09:34:08', '2022-01-27 09:34:08', 2, '0');
INSERT INTO `auth_menu` VALUES (533, '9c63129ccaea01725557921b083c47e5', '新增数据', 'f8117a59c2c1293b22fe5645028bd', NULL, NULL, 'templateService:add', NULL, '1', NULL, '2022-01-27 10:55:17', '2022-01-27 10:55:17', 2, '0');
INSERT INTO `auth_menu` VALUES (534, '9c63129ccaea01725557921b083c4723', '编辑数据', 'f8117a59c2c1293b22fe5645028bd', NULL, NULL, 'templateService:edit', NULL, '1', NULL, '2022-01-27 10:28:15', '2022-01-27 10:28:15', 2, '0');
INSERT INTO `auth_menu` VALUES (535, '9c63129ccaea01725557921b083c123e', '删除数据', 'f8117a59c2c1293b22fe5645028bd', NULL, NULL, 'templateService:batchDelete', NULL, '1', NULL, '2022-01-27 10:54:21', '2022-01-27 10:54:21', 2, '0');

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '系统菜单主键ID',
  `role_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `role_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色代码',
  `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色描述',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统权限->角色表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role` VALUES (13, 'd2429087d8bd666285a0846549517b2d', '普通管理员', 'COMMON_ADMIN', '普通管理员', '2021-04-27 01:25:57', '2021-07-16 11:28:10', 2, '0');
INSERT INTO `auth_role` VALUES (17, '599da1061da00b32e761f50233361bcb', '管理员', 'ADMIN_ACCOUNT', '管理员', '2021-05-24 23:37:56', '2021-05-25 07:58:20', 2, '0');
INSERT INTO `auth_role` VALUES (20, 'cf6dcc8fb622dded70be43fe670eac2f', '普通群众', 'COMMON_USER', '普通群众', '2021-11-03 19:41:30', '2021-11-17 03:39:57', 1, '0');
INSERT INTO `auth_role` VALUES (24, '0cb7990473e7681253bb118e5d45c936', '志愿者', 'NURSING_STAFF', '志愿者', '2022-01-07 11:00:59', '2022-01-25 14:30:49', 2, '0');
INSERT INTO `auth_role` VALUES (25, '1d08e5dae37d60dfa61e04d236dff429', 'hu', '1', '1', '2022-01-07 20:23:42', '2022-01-10 11:43:00', 1, '0');
INSERT INTO `auth_role` VALUES (26, 'e2d56b834fe1d8012b0bd2f0332c3daa', 'hugong', '123456', 'hugong', '2022-01-07 20:37:15', '2022-01-10 11:43:00', 1, '0');
INSERT INTO `auth_role` VALUES (27, 'bdc1fb820da5c2c414f75b2de0088449', '老人亲属', 'OLD_RELATIVE', '老人子女等亲属', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');

-- ----------------------------
-- Table structure for auth_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_menu`;
CREATE TABLE `auth_role_menu`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_role_menu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色-菜单中间主键ID',
  `menu_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '菜单ID',
  `auth_role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1690 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色-部门中间表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_role_menu
-- ----------------------------
INSERT INTO `auth_role_menu` VALUES (61, '474f07f163203ef6f984c1271800f222', '709308cc01fb72d06fae204acc0bcf95', '4a74ed2d12904f0b68b642fc45441d87', '2019-10-21 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (62, '758c3abf8070fb7de30b44e61b11922d', '4df8e55e6ebf32baa56f9e90f2d2fd66', '4a74ed2d12904f0b68b642fc45441d87', '2019-10-22 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (63, '28606d8e95c7efaf84599ad8cb7373b7', '8c79ce8c49b3d8eb8e2a62a0186114a9', '4a74ed2d12904f0b68b642fc45441d87', '2019-10-23 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (65, '279344c7b53e9ba3fbb6455173f7aaf7', '089a07f917374c44974b1ee6ebe203f9', '4a74ed2d12904f0b68b642fc45441d87', '2019-10-25 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (70, 'd08d86a4a15aa9c50b4062a9a7e3b571', 'ece9eee97491e8fdd8f65a36e71c37c3', '4a74ed2d12904f0b68b642fc45441d87', '2019-10-30 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (74, '6aa3c15233aec97720409695fdbba305', '7f5b8422a0cedabe0033b7ebc474cf15', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-03 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (76, '312a905873303a354a7393876e00cc04', '5eb1cb1204a15ab43fa533bf7d654a62', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-05 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (77, 'cf3d1eaaffc24a26dab721e825e242d6', '679304a41cf1ce185c757f81b935284f', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-06 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (78, '094ffd61c74bb9f812a84767665b81db', '1cb2fbe0953695cf2216d484f7cc2954', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-07 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (79, 'd5580166e7428899ce4ff78c4be80bdd', 'acaea40f7e4e00c8b1dd7151e9575ca1', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-08 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (80, '60def46fd2adb201d29595735561bf91', 'acaea40f7e4e00c8b1dd7151e9575ca1', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-09 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (81, 'ec24a4990da98f29fccfb13c1ee5426a', 'cd13ac908d1004e194a54883df182c29', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-10 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (82, 'e35ef48e92e11690f681dc493e0751cc', '369fd6c69c1de19a2f54d1c9005713c0', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-11 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (83, 'c0b08f032902358d3bbd3b2331d38e20', '718089921b0f84b24272ad27fab09927', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-12 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (84, '5745dc2b68673f24547118a2897140d0', '9a50897decf379b5e6783226edac06bc', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-13 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (85, '1b131c38f3c7a1bf581c149c850de71a', 'feff3319f3750e3f2f798d9fcc72fc15', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-14 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (86, 'd09d80a5c67b06632095eebbbe58bc25', '6753e6b33586af2b6e2e303839dba8cb', '4a74ed2d12904f0b68b642fc45441d87', '2019-11-15 11:30:14', '2019-08-22 12:37:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (87, '6a66ef7f9d1bc3cbe3a21320dcb7f749', '4df8e55e6ebf32baa56f9e90f2d2fd66', '37dc6b9b6bec44bed7e5a05610016af0', '2019-11-16 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (88, '3af4342343838e74aecaab81928880b3', '709308cc01fb72d06fae204acc0bcf95', '37dc6b9b6bec44bed7e5a05610016af0', '2019-11-17 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (89, '7b278a348e97a8411261ee42dbc3bfe2', '8c79ce8c49b3d8eb8e2a62a0186114a9', '37dc6b9b6bec44bed7e5a05610016af0', '2019-11-18 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (91, 'e649edb23144b34412cfe95a4250a090', '089a07f917374c44974b1ee6ebe203f9', '37dc6b9b6bec44bed7e5a05610016af0', '2019-11-20 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (96, 'af257bc61afed0c6344ea2b588336bb8', 'ece9eee97491e8fdd8f65a36e71c37c3', '37dc6b9b6bec44bed7e5a05610016af0', '2019-11-25 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (100, 'a43d16148eabaef15f916b276c727ef1', '7f5b8422a0cedabe0033b7ebc474cf15', '37dc6b9b6bec44bed7e5a05610016af0', '2019-11-29 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (102, '569d04d0a3b4927fe728cbcf380a03d5', '5eb1cb1204a15ab43fa533bf7d654a62', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-01 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (103, '9c9e075a6bd97873170cb3abd893411b', '679304a41cf1ce185c757f81b935284f', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-02 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (104, 'e75502cf081afee26ea0a2e057e03c6d', '1cb2fbe0953695cf2216d484f7cc2954', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-03 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (105, '1f6336fcbaa9ebc0dfa0144847d0704f', 'acaea40f7e4e00c8b1dd7151e9575ca1', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-04 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (106, '05d43119b2ad71e807e8d2a894b0dac4', '09537ce816a8436efa2eec44ed79169c', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-05 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (107, '6b4f0728dae21ca3b7272fc02b3b4d6b', 'cd13ac908d1004e194a54883df182c29', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-06 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (108, '480c191db6b1f78512d57b2d65da3b7f', '369fd6c69c1de19a2f54d1c9005713c0', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-07 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (109, 'aa21110f3a4100925e6b55b980a6280f', '718089921b0f84b24272ad27fab09927', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-08 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (110, '4d072b99a16f7e8509a2474cf5487896', '9a50897decf379b5e6783226edac06bc', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-09 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (112, '613da2bc81d8335c6a95020ec811d5d2', 'feff3319f3750e3f2f798d9fcc72fc15', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-11 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (113, '56a7c1047610b6ebb381afb1b3dce940', '6753e6b33586af2b6e2e303839dba8cb', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-12 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (114, '68c58e140057100b66d61455247ad561', 'b14cd26017aa42170bbebbaca50fef05', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-13 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (115, 'c8211df9840a601c773fc526ab905acd', 'a87e0f688835ca9184aaad6518db6a5d', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-14 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (117, 'bf155a020ec9409c6dd14940a4952bbd', '87b0cba0e5ca0524c7ca723510ef04c0', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-16 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (118, 'ff0c966073ef9ae101a46c785ba11240', 'd287f31353fe99843758e501905915e2', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-17 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (119, 'c36c01898c74a1a4bc4fd8a4fc3969e9', '97f9e42fcc5206984fb9b4966db58f08', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-18 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (121, '0ef89f16d7796f0abbe6484c5614daea', '08e35f586fdb37b1b993eaf185d04a4a', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-20 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (122, '2ac67b9e35af8503315c96cf97ff622e', '1f4b7490521a169d5090a27720090af1', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-21 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (123, '012e566dd7cb6ad328dc9c0e0bd204ff', '155003642cfe493de2ad5097cfa83243', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-22 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (124, '3e0cc6f8c5ec28dcf1e0d391d25f86ad', 'c2bb784df7b868926cb61fc0936bcb8b', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-23 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (125, '3e70c6851dcd3aba0ab5ef22e6c59ddb', '0ec7c24e48743812b0c88df403036a78', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-24 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (126, '78f5e6b35989df5fd90413b7948e257d', '19e7d2152a8b09018b50509b078f9198', '37dc6b9b6bec44bed7e5a05610016af0', '2019-12-25 11:30:14', '2019-08-22 12:38:04', 2, '0');
INSERT INTO `auth_role_menu` VALUES (144, '5aaa41023fbc98db4aac1feb997c2aba', '4abdd720b2ab4db02c18b8ec8330ba77', '210a71f81c54c40f08661309e3710843', '2019-09-25 16:53:11', '2019-09-25 16:53:11', 2, '0');
INSERT INTO `auth_role_menu` VALUES (145, '5c117559642f990ee603fd0f21c78db1', '779a82e848365b59ae6eb3aed7e8d320', '210a71f81c54c40f08661309e3710843', '2019-09-25 16:53:11', '2019-09-25 16:53:11', 2, '0');
INSERT INTO `auth_role_menu` VALUES (149, '455571ade860112abc90d9c54178622d', 'e4d7e537e2c56baca04f3fa0d348e980', '210a71f81c54c40f08661309e3710843', '2019-10-22 14:35:46', '2019-10-22 14:35:46', 2, '0');
INSERT INTO `auth_role_menu` VALUES (152, '3065ab5c4bc326369d784a25c00d8b00', 'e4b2b0c03b5a3bdab3e0c201353a4c73', '210a71f81c54c40f08661309e3710843', '2019-10-22 14:39:53', '2019-10-22 14:39:53', 2, '0');
INSERT INTO `auth_role_menu` VALUES (159, '9e96127543e9256b00de0aeb61c54f06', 'e3683c8ba46d1c987d15be8d8266a019', '210a71f81c54c40f08661309e3710843', '2019-11-22 07:04:43', '2019-11-22 07:04:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (160, 'ae81343be0d88c2a8f8426efa7b46aac', '08bb8faaf2ba45ac733922253c8d5aac', '210a71f81c54c40f08661309e3710843', '2019-11-22 07:04:43', '2019-11-22 07:04:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (161, '1756e08104099046e8c266f6d1050893', 'f406be1880652778fe8ef1104afb1049', '210a71f81c54c40f08661309e3710843', '2019-11-22 08:14:50', '2019-11-22 08:14:50', 2, '0');
INSERT INTO `auth_role_menu` VALUES (164, 'e367059de7065409dd200a0d3595f575', 'a73f9a308e77504f94062ccda633dd15', '210a71f81c54c40f08661309e3710843', '2019-11-27 11:26:37', '2019-11-27 11:26:37', 2, '0');
INSERT INTO `auth_role_menu` VALUES (165, '4d01f8ce8ff56fbb8f5926eb0906d17c', 'c2e9210edcc7d2dba6fc3a45ccd8920c', '210a71f81c54c40f08661309e3710843', '2019-11-27 11:26:37', '2019-11-27 11:26:37', 2, '0');
INSERT INTO `auth_role_menu` VALUES (168, '6d1cc8621756007d000e5cc30e63dbf2', '9e33c1085f654fbba161c048e232429a', '210a71f81c54c40f08661309e3710843', '2019-11-27 14:20:10', '2019-11-27 14:20:10', 2, '0');
INSERT INTO `auth_role_menu` VALUES (170, '4b4f9afee4347343b85345df957ab010', '6aa4286dbd666df33fdace50f68027fd', '210a71f81c54c40f08661309e3710843', '2019-11-27 15:47:15', '2019-11-27 15:47:15', 2, '0');
INSERT INTO `auth_role_menu` VALUES (172, '96308cd032573e1c1d7381e3b73a7b20', '5ab21a5790ed383b772c4d865805eab3', '210a71f81c54c40f08661309e3710843', '2019-11-28 10:20:00', '2019-11-28 10:20:00', 2, '0');
INSERT INTO `auth_role_menu` VALUES (174, '192abe4e8fea6ad6a4b2fca69d957b5a', '50dbfda02e2c2489b4c381d10bf6ccc5', '210a71f81c54c40f08661309e3710843', '2019-11-28 15:31:35', '2019-11-28 15:31:35', 2, '0');
INSERT INTO `auth_role_menu` VALUES (180, 'e9f64c6ba8bbba94a97f78a26376ea3b', '4abdd720b2ab4db02c18b8ec8330ba77', '10f4aed24c6889d616e8231801866e77', '2020-01-15 11:34:13', '2020-01-15 11:34:13', 2, '0');
INSERT INTO `auth_role_menu` VALUES (232, 'd6bd95efeafbf209ead636a1924ceb93', 'ccb1bc97e46b65bf2a86e3c52384246f', '210a71f81c54c40f08661309e3710843', '2020-06-28 19:29:06', '2020-06-28 19:29:06', 2, '0');
INSERT INTO `auth_role_menu` VALUES (237, '89ac33e2e02133d3346c3b0c9d078290', '53ab03d178905c13737c60837b157fb8', '210a71f81c54c40f08661309e3710843', '2020-07-03 17:27:47', '2020-07-03 17:27:47', 2, '0');
INSERT INTO `auth_role_menu` VALUES (254, '33b7917c2dc124e66dc93d80e7070e6e', 'f4a98430f388ec6c65203ea7c560cb5d', '91b058b5e34412b2af701001adbdbb8f', '2021-02-02 17:20:07', '2021-02-02 17:20:07', 2, '0');
INSERT INTO `auth_role_menu` VALUES (255, '808c211dda97748054e1c7ac2d7bb170', 'bfdb3d5105891ff8241f95077c055034', '91b058b5e34412b2af701001adbdbb8f', '2021-02-02 17:20:07', '2021-02-02 17:20:07', 2, '0');
INSERT INTO `auth_role_menu` VALUES (257, '0d3bb62ae2ec33d3b0d30615821931e4', '62f0ccb1aa5f96ca610836c2d5bea6a5', '91b058b5e34412b2af701001adbdbb8f', '2021-02-02 17:49:22', '2021-02-02 17:49:22', 2, '0');
INSERT INTO `auth_role_menu` VALUES (258, '916a4c018f1822b19050fdf9944623eb', '76003f4a0350280fb10fa7e5437ef19f', '91b058b5e34412b2af701001adbdbb8f', '2021-02-02 21:29:57', '2021-02-02 21:29:57', 2, '0');
INSERT INTO `auth_role_menu` VALUES (259, 'c549758608f31cfc0a6e2561bfc3c6bf', '31abae0159c82036aaee4c1f2bb6665d', '91b058b5e34412b2af701001adbdbb8f', '2021-02-02 21:40:01', '2021-02-02 21:40:01', 2, '0');
INSERT INTO `auth_role_menu` VALUES (265, '9f776a7050d02ae5d6dc257012e5dcd7', 'b34b4f94e339513b0ff43eede95d7998', '91b058b5e34412b2af701001adbdbb8f', '2021-02-03 17:18:19', '2021-02-03 17:18:19', 2, '0');
INSERT INTO `auth_role_menu` VALUES (269, '476d527bdfd80b64d76694ce4e1ad36e', 'f876dffa276d4b41efdf6ac1a5699ce7', '91b058b5e34412b2af701001adbdbb8f', '2021-02-03 20:51:51', '2021-02-03 20:51:51', 2, '0');
INSERT INTO `auth_role_menu` VALUES (270, 'eebc53c8ebd7823f7e1c82ebd539cbf8', '8cf0331845ba9a1fd600c6456c7ac493', '91b058b5e34412b2af701001adbdbb8f', '2021-02-03 20:51:52', '2021-02-03 20:51:52', 2, '0');
INSERT INTO `auth_role_menu` VALUES (271, '65b918537588b5b500900e448ce3de75', '78bf940a0593bb68c852ef408053cf5f', '91b058b5e34412b2af701001adbdbb8f', '2021-02-03 20:51:52', '2021-02-03 20:51:52', 2, '0');
INSERT INTO `auth_role_menu` VALUES (272, '171789d2948429e3240d6ec73078de2d', '5087634140e831fb1058ff02924959b0', '91b058b5e34412b2af701001adbdbb8f', '2021-02-03 20:51:52', '2021-02-03 20:51:52', 2, '0');
INSERT INTO `auth_role_menu` VALUES (273, 'e36ed6f7703dbc34483d6f0801025be0', 'a8c9f93029a98691d67800a7bda86279', '91b058b5e34412b2af701001adbdbb8f', '2021-02-03 20:51:53', '2021-02-03 20:51:53', 2, '0');
INSERT INTO `auth_role_menu` VALUES (276, 'afdf5d78006e8eb1b1d911788402a58a', 'fd92494e722909e00fd4f945badba47d', '91b058b5e34412b2af701001adbdbb8f', '2021-02-15 14:55:24', '2021-02-15 14:55:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (277, 'd65d986e5745a256416b409e7eae9566', '6a2788c197efd27e0a423eb4b68cc73e', '91b058b5e34412b2af701001adbdbb8f', '2021-02-15 14:55:24', '2021-02-15 14:55:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (279, '1bda1f5f2e23f890a715fc4d8a3810cf', 'e6d1e5ed4b132346bbcafd8e889a7e3f', '91b058b5e34412b2af701001adbdbb8f', '2021-02-15 15:20:07', '2021-02-15 15:20:07', 2, '0');
INSERT INTO `auth_role_menu` VALUES (281, '3c740f0e406814099707c96efdd9eb23', '2e8d535ed5670bc989809656f02a173b', '91b058b5e34412b2af701001adbdbb8f', '2021-02-15 15:25:11', '2021-02-15 15:25:11', 2, '0');
INSERT INTO `auth_role_menu` VALUES (283, '3a62c875ed6d8e79ed82dac42fdfea62', '8a348e6950d64b708b7d672acec68e9d', '91b058b5e34412b2af701001adbdbb8f', '2021-02-15 16:32:02', '2021-02-15 16:32:02', 2, '0');
INSERT INTO `auth_role_menu` VALUES (285, '3302f9242d4e9f45c03d64775b13ab37', 'b90b321814f9aaacb4bb960f9170da37', '91b058b5e34412b2af701001adbdbb8f', '2021-03-22 17:04:00', '2021-03-22 17:04:00', 2, '0');
INSERT INTO `auth_role_menu` VALUES (288, 'f70a7d27d7fbd7a4480958d6b2b86af5', '0f9a02f06149bf4949dcbb05987f2a85', '91b058b5e34412b2af701001adbdbb8f', '2021-03-22 17:49:08', '2021-03-22 17:49:08', 2, '0');
INSERT INTO `auth_role_menu` VALUES (289, 'f0fcf613b0770a09792ba9e72601ecec', 'd67ab8daebf5ab16a6c493f9a234a038', '91b058b5e34412b2af701001adbdbb8f', '2021-03-22 17:49:08', '2021-03-22 17:49:08', 2, '0');
INSERT INTO `auth_role_menu` VALUES (295, '5ec88dcd4a4f99a0eb52e0546ccf3406', '28568e2ca98013b8efea04a101c17ccc', '91b058b5e34412b2af701001adbdbb8f', '2021-03-23 12:13:10', '2021-03-23 12:13:10', 2, '0');
INSERT INTO `auth_role_menu` VALUES (296, '6f7aa4d68230946efe05bcbcb4229684', '2380a6cc039b091cf2e0c2c239b242b8', '91b058b5e34412b2af701001adbdbb8f', '2021-03-23 12:13:10', '2021-03-23 12:13:10', 2, '0');
INSERT INTO `auth_role_menu` VALUES (297, '8702d88252f6af99dd5692d5d5090138', '6a8455b7f0a2ba38a98702ba53ae2a95', '91b058b5e34412b2af701001adbdbb8f', '2021-03-23 12:13:11', '2021-03-23 12:13:11', 2, '0');
INSERT INTO `auth_role_menu` VALUES (298, '4bd81048af08941edb9151a2ef55acaa', 'f745892a32f1b03706f1a34e1b33b831', '91b058b5e34412b2af701001adbdbb8f', '2021-03-23 12:13:11', '2021-03-23 12:13:11', 2, '0');
INSERT INTO `auth_role_menu` VALUES (299, 'b9be077d2080a863cf0091dff5f82a7c', '7b053a9642dac3fb1dfb82b3345ea0b4', '91b058b5e34412b2af701001adbdbb8f', '2021-03-23 12:13:11', '2021-03-23 12:13:11', 2, '0');
INSERT INTO `auth_role_menu` VALUES (305, '7118dbb6a9aa73a9e67484f50a998933', 'bcecd83298ceb16602ad6e83f3971251', '91b058b5e34412b2af701001adbdbb8f', '2021-03-24 12:44:32', '2021-03-24 12:44:32', 2, '0');
INSERT INTO `auth_role_menu` VALUES (306, '7f811e667b7acfc2e216524326968f79', 'd66ae0c727b5fdebe83199978dc8a7fb', '91b058b5e34412b2af701001adbdbb8f', '2021-03-24 12:44:32', '2021-03-24 12:44:32', 2, '0');
INSERT INTO `auth_role_menu` VALUES (307, 'b388a3cd9abffdf5a62ec2b996ec0612', 'a321d7734c587196aa8835037ff1f52f', '91b058b5e34412b2af701001adbdbb8f', '2021-03-24 12:44:32', '2021-03-24 12:44:32', 2, '0');
INSERT INTO `auth_role_menu` VALUES (308, '59c867f9d001053608900b299ce75162', '7b8067136a00e9ae066991fcfb809d7b', '91b058b5e34412b2af701001adbdbb8f', '2021-03-24 12:44:32', '2021-03-24 12:44:32', 2, '0');
INSERT INTO `auth_role_menu` VALUES (309, '10151fbe30ead2e3c664409b6bd78194', '916aa2b8305729d32bdd492719681b9f', '91b058b5e34412b2af701001adbdbb8f', '2021-03-24 12:44:32', '2021-03-24 12:44:32', 2, '0');
INSERT INTO `auth_role_menu` VALUES (978, '1134525608a96bfb31fb1ccf03b364ed', '709308cc01fb72d06fae204acc0bcf95', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (979, '0d6c1048eda58681edef9137ad27cef2', '4df8e55e6ebf32baa56f9e90f2d2fd66', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (980, 'e2ec99837ff6d519828d97dbab4e890a', '8c79ce8c49b3d8eb8e2a62a0186114a9', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (983, '5512d1c05a35561f105b92d8f19dd9bd', '50fe30a5a0669bf5bb04e03fe932954a', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (984, '64e5c0f4687532e5d1ec9acaa1c701c8', '8dd1f283775e1b4113779119a391c3e7', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (985, '0c3c78ca250c4b5f2a1d8bfa07c0b248', '513c77c813532ffceeadb5d4833e55e1', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (987, '2b862afeb836d87794a51bb836bfd42b', '17f77194f4835c971c72b4e024884d5d', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (988, '67fcca2447df391325b659e297b9e1d1', 'a87e0f688835ca9184aaad6518db6a5d', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (989, '465c6be13d61c5b7c4e12a0936d17a4f', '7bc0cb66696b0d3aee2d8d74d0b4c798', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (990, 'f727fe729cfc56d43a5201fcfb09f5b7', '5586b7b69349fa03d0f5704fe4a60122', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:37:56', '2021-05-24 23:37:56', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1157, '1484f17cc0a32db005dcad342744e4a1', '513c77c813532ffceeadb5d4833e55e1', 'd2429087d8bd666285a0846549517b2d', '2021-06-02 15:13:41', '2021-06-02 15:13:41', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1158, '586a1707aefc21702d6b2ab6638dafbc', '4df8e55e6ebf32baa56f9e90f2d2fd66', 'd2429087d8bd666285a0846549517b2d', '2021-06-02 15:13:41', '2021-06-02 15:13:41', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1159, '48825c2066b5723880918dd8d2df2c93', '50fe30a5a0669bf5bb04e03fe932954a', 'd2429087d8bd666285a0846549517b2d', '2021-06-02 15:13:41', '2021-06-02 15:13:41', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1160, '38467c8a26d4eb7c48f1a80d06355960', '709308cc01fb72d06fae204acc0bcf95', 'd2429087d8bd666285a0846549517b2d', '2021-06-02 15:13:41', '2021-06-02 15:13:41', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1162, '38597385d26fa23ca5d75854d5d6a0f7', '17f77194f4835c971c72b4e024884d5d', 'd2429087d8bd666285a0846549517b2d', '2021-06-02 15:13:41', '2021-06-02 15:13:41', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1163, '67bd3102616d3736649b15f7b287e0d9', '8dd1f283775e1b4113779119a391c3e7', 'd2429087d8bd666285a0846549517b2d', '2021-06-02 15:13:41', '2021-06-02 15:13:41', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1603, 'c5327a8aaeafe3ce3041f8a1e108822c', '6ea458441dedf531f7e45ac0badc7054', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1604, 'a758c9a2dc49447429cd81d38d91a72d', 'db0cae6899ef0146a6ede5d4de592466', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1605, '5d3294a080cfb5afdede76697d411bf1', 'c41858385a4ac6096a0b8aceea9043a3', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1606, '33f5aa3ba3a917b64db5b5b9deef0e82', '37cf27cbfd7e79eb4c141fe80bf7813d', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1607, 'ca9c6ac529237f4eeb5b7fec1e5045d2', 'a76854fa7241947a6ff60688609789a3', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1608, 'ecf1af4c82c0b78815e0d0ea3a51a60d', 'afd0327f2287b3ff34af80e7c7e0afae', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1609, '0a7adab2e545e8ab6d5b28d26a6b5f46', 'a48b55f65539f3e498c667a562c9a8f8', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1610, '43aa6461714e88295104b923acba6775', '5034b9a9c8e2713b8e52c63ddb1d4fd5', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1611, '9efe8bdc976839126692939554df1c2f', '5e9414b31db45fb233e18d8c848cd649', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1612, '6f1024319c4d061de1fa587e70bb67b6', 'c70ba840f15f74d0ab29d36a8229a7dd', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1613, '37d4f80f95cc61a846ef42c8cd00ee50', 'be944363be36bad38ea60f01f6f0dcb8', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1614, '9b8f6250836336f95d0e316a321e0ab2', '57d11a6223b06f740092c42d75c20aab', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1615, '5f4189f6b3274668724556d4f0e7089e', '9f0c5280ff577bafe7857c7c59ef0fd0', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1616, 'd34df32d86c4fccfcd3c2d4bd3e11cbd', 'd04d5d613415d26ff6584d4dc1eedc80', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1617, 'e2c95901f2a1c5f923a7ac2c0940bbf6', 'fb06b6e9470e3d222e4b1df9b5bcee00', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1618, '5303a58f5ca6e1a5adcdbe760fa5a39f', '2b6f347a39a22283f3564f50957a9577', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1619, '6f54f56eab46ae24ec4d19831794476f', '85521637f313ab1c706bbdfbb368f4c6', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1620, '20faa2104b7e37d59720b8aac1b313cc', 'ec1e786e41eabfbca57fa5ec4ed33b45', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1621, '5acbb85dd020e8c7c429b6eccfa3839e', '61f6077c4106dec895ea4e78e4d22a10', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1622, '69b7fe1bc9931382109c68eb82728b34', 'b33e4933cc19ce428ab5b3c56a065281', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1624, '7653b27dd4d727129901ff2d6113013b', '733f510ebefbf8b4f9c07bb14c63cec2', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1626, '39a4360d4656e495cffab9a13d6ad3ca', '0e9b86afaba99991ec761928a4dd7326', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1627, '3ddeafcea2b41bf8367da7107ebeaece', '5bf2e4d515ce82300b28f60c7a361f49', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1628, 'b914c3c8805473ced15713c8644c531e', '9c63129ccaea01725557921b083c47f4', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1629, '72825188e17cf031a96675b035eb0681', 'f8117a59c2cac0f393b22fe5645028bc', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:43', '2022-01-07 10:55:43', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1630, '41281de39d764ea33a187cdc7e338699', 'e87771a49cf03bd7c97cb29ca90838a8', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:44', '2022-01-07 10:55:44', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1631, '958ca8833a6434360dab971d630b63aa', '238b867b9e016685cb56df2e8abe31fb', '599da1061da00b32e761f50233361bcb', '2022-01-07 10:55:44', '2022-01-07 10:55:44', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1632, '866eff9109c89af4e129ae3d61f7662e', 'e807c78e50b8f5ca8e0bb5ee1549c400', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1633, 'e550d8baa534b2d5fdfddf3716992830', '6ea458441dedf531f7e45ac0badc7054', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1638, 'a7e0a0e9ab8537ff97a4e0426aebf282', '2b6f347a39a22283f3564f50957a9577', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1639, '2dae848b5b412f61d400518a89de5ba0', '0e9b86afaba99991ec761928a4dd7326', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1640, 'f5137b0fa9c896c111b2985582e46600', 'cae197b1556f27ca708b21ffa46351cc', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1641, '9fd8733bf78660a3081fe0bd293e9d8b', '85521637f313ab1c706bbdfbb368f4c6', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1642, '202d57c848398a30b21d659c4575820f', 'db0cae6899ef0146a6ede5d4de592466', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1643, 'b8e04f7120e963ea894e8e77b610f6e7', 'afd0327f2287b3ff34af80e7c7e0afae', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1644, '445eba655c172bb125afde1981f41ed2', 'c41858385a4ac6096a0b8aceea9043a3', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1645, '33a15ae8923eac15cafc13426582b65b', 'e87771a49cf03bd7c97cb29ca90838a8', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1646, 'ddb28aea50d8040b7180520639250eb8', '5034b9a9c8e2713b8e52c63ddb1d4fd5', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1647, 'bd21a27d84f04f920b234cb9ea1a1459', 'a76854fa7241947a6ff60688609789a3', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1648, '93bf1e6d0890f5eaa19938a55445465a', '238b867b9e016685cb56df2e8abe31fb', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1649, '3620bd1ee29dd5526dfb232256bef6d2', '733f510ebefbf8b4f9c07bb14c63cec2', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1656, '7559e251cbaa6c144303093971e16e2d', '57d11a6223b06f740092c42d75c20aab', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1657, 'bc7c1537a4381b247bbe0db095d06e53', 'a48b55f65539f3e498c667a562c9a8f8', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 11:00:59', '2022-01-07 11:00:59', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1670, 'e44085df3bfb3f60547f3762126ca8a3', 'be944363be36bad38ea60f01f6f0dcb8', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 17:42:02', '2022-01-11 17:42:02', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1671, 'd6b9daec8717baecebb69e02db868c88', 'ec1e786e41eabfbca57fa5ec4ed33b45', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 17:42:02', '2022-01-11 17:42:02', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1672, '34ef9597b59c1b1f5d4581e6342885a3', 'f8117a59c2c1293b22fe5645028bc', '599da1061da00b32e761f50233361bcb', '2022-01-12 14:35:12', '2022-01-12 14:35:12', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1674, '37b9b13ec6cc38ac9297ea47d3fb710b', 'e807c78e50b8f5ca8e0bb5ee1549c400', '599da1061da00b32e761f50233361bcb', '2022-01-26 14:28:01', '2022-01-26 14:28:01', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1675, 'afe47e2d3593224e3b76d147756011ef', 'f8117a59c2c1293b22fe5645028bd', '599da1061da00b32e761f50233361bcb', '2022-01-27 08:58:23', '2022-01-27 08:58:23', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1676, 'c5a501c2572b72872ac6167fcca59acd', 'f8117a59c2cac0f393b22fe5645028tr', '599da1061da00b32e761f50233361bcb', '2022-01-27 09:20:47', '2022-01-27 09:20:47', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1677, 'fd0b31e80977c91a108112caaea86e62', '9c63129ccaea01725557921b083c4723', '599da1061da00b32e761f50233361bcb', '2022-01-27 10:28:49', '2022-01-27 10:28:49', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1678, 'f9be26ae93d03673fd9c5db3fba31bc6', '9c63129ccaea01725557921b083c47q3', '599da1061da00b32e761f50233361bcb', '2022-01-27 10:30:53', '2022-01-27 10:30:53', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1679, '91a2165e88ee56d5d7a74497f1fba1cc', '9c63129ccaea01725557921b083c47e5', '599da1061da00b32e761f50233361bcb', '2022-01-27 10:56:14', '2022-01-27 10:56:14', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1680, '43c65eedc79bf8f523c339198ff0efe2', '9c63129ccaea01725557921b083c123e', '599da1061da00b32e761f50233361bcb', '2022-01-27 10:56:14', '2022-01-27 10:56:14', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1681, '513cd3f2100a616ab2c5790eac39bc50', 'cae197b1556f27ca708b21ffa46351cc', '599da1061da00b32e761f50233361bcb', '2022-02-07 11:12:42', '2022-02-07 11:12:42', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1682, 'cba45f3c16591ce519390e2bca4ee1de', '6ea458441dedf531f7e45ac0badc7054', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1683, '671bb513352c794c36ee018e286ed53e', 'e807c78e50b8f5ca8e0bb5ee1549c400', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1684, '2a464d2fd885878afb9e60dc731fc799', 'f8117a59c2cac0f393b22fe5645028bc', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1685, 'd6a8f677b2e976a9e88251456569df1a', '9c63129ccaea01725557921b083c47f4', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1686, '55d097c251b09d2871cceadbf293a68b', '0e9b86afaba99991ec761928a4dd7326', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1687, 'e0bd44050896ec39b3c26a2c66913cb0', '2b6f347a39a22283f3564f50957a9577', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1688, 'c6521ef67accb0e7535d6660770e3325', 'afd0327f2287b3ff34af80e7c7e0afae', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');
INSERT INTO `auth_role_menu` VALUES (1689, '87b1f3869e2abb9a1fed0263206836ff', 'c41858385a4ac6096a0b8aceea9043a3', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:26:24', '2022-02-10 09:26:24', 2, '0');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户主键ID',
  `real_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '真实姓名',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `auth_password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '密码',
  `phone_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `department_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '部门ID',
  `auth_salt` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '密码盐',
  `avatar` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '用户头像',
  `description` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '描述',
  `last_login_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 142 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES (1, 'd880e9a54951d3d0991f8d48e75e0f4a', 'admin', 'admin', '0d425b2ea0c401e5a6adabf52ef22549', '17381852768', '46d48c7d4384ff472825febb880b5793', '9248ed764d392e9d0d52674dfa2bc86f', 'default.jpg', '系统最高管理员', '2022-02-10 09:34:40', '2019-08-22 11:14:06', '2022-02-10 09:34:40', 2, '0');
INSERT INTO `auth_user` VALUES (4, '6c2ed176209ddf235009ddfac641d0b2', '张山', '测试志愿者1', 'edad14e9c12f8b542d93ff0c65491b56', '17746758730', 'bfc4244697f1223cac7519052f6ed72f', '23f0215c3a5c664fd5fca3ea42603cf3', '', '', '2022-01-10 17:51:35', '2022-01-07 20:41:31', '2022-01-25 14:42:58', 2, '0');
INSERT INTO `auth_user` VALUES (5, 'e93e0f7db7fb259815e56402b1825e77', '李四', '志愿者2', 'a6d6630bcb4beb2031b94cac3f398b99', '13596743578', '', '8ffd49ebdb8b7d17532f7d985c27adba', '', '', '2022-01-10 19:48:20', '2022-01-10 19:48:20', '2022-01-25 14:42:52', 2, '0');
INSERT INTO `auth_user` VALUES (6, '63eb7243e84bbe1bdc0fdfa455eb03ec', '1221', '测试志愿者账号-01', '2800c31c42c10107caf806d0407a3a7a', '17678978788', '', 'dcc594d1ddc4b18f76175d373a8f48fd', '', '', '2022-01-11 11:16:09', '2022-01-11 11:16:09', '2022-01-25 14:43:10', 2, '0');
INSERT INTO `auth_user` VALUES (7, 'ffb2ffda1ba565e744a3c2e4512cdbf8', '12', '测试志愿者账号-02', 'c87fd7c1f9c8580518684c657c7de47c', '17688889898', '', '4175cb9c434af4de89b38ea00e4f4363', '', '', '2022-01-11 11:18:51', '2022-01-11 11:18:51', '2022-01-25 14:43:13', 2, '0');
INSERT INTO `auth_user` VALUES (8, 'f2699643bac6bfa46a80793d15b78b7b', '122', '测试志愿者账号-03', 'fead310a213ffac5dd884ba49249c403', '17687878787', '', '295bfcee9dac7243650436a1082c297d', '', '', '2022-01-11 11:40:51', '2022-01-11 11:40:51', '2022-01-25 14:43:16', 2, '0');
INSERT INTO `auth_user` VALUES (9, '76454950bbf857029675e384787942b8', '李民', '志愿者1', 'ba43b5288fd54519f4ad32c092a5cf18', '13846253743', '', 'cef42187db0f5560b0fea7000c582764', '', '', '2022-02-07 16:58:03', '2022-01-11 12:58:55', '2022-02-07 16:58:03', 2, '0');
INSERT INTO `auth_user` VALUES (10, 'bda375322437325415fc27d98788103c', '王浩', '志愿者3', 'b8ace454b84426416388bb52e60af77b', '14725638463', '', 'af1c7fed5c3f2c3dc23656ddbcf5ced6', '', '', '2022-01-11 17:34:02', '2022-01-11 17:34:02', '2022-01-25 14:43:03', 2, '0');
INSERT INTO `auth_user` VALUES (140, 'b363d1f07617c4c163f98139a2d0125f', '刘洋', '志愿者4', '6a455a57f1dde6a87a45ed90423ec752', '15387642567', '', 'a9e565ea4242acfbda32dfaae863b4e9', '', '', '2022-01-25 14:15:39', '2022-01-11 17:36:49', '2022-01-25 14:43:05', 2, '0');
INSERT INTO `auth_user` VALUES (141, '69eaf8999b4b2b6798fde3d76ec201b7', '你XX', '15712345678', 'fa93a69b0656d374989032a3ac09ee01', '15712345678', '', 'ed772dcdf7ba8978a931ba9d8f5c3ae8', '', '', '2022-02-10 09:33:55', '2022-02-10 09:27:17', '2022-02-10 09:33:55', 2, '0');

-- ----------------------------
-- Table structure for auth_user_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_user_role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户角色关联主键ID',
  `auth_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户业务主键ID',
  `auth_role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role` VALUES (2, 'd33f30ac043eb5e5642151a4e4cc4587', '549b8ea181d29bdaaddf35fc6569ee7b', '4a74ed2d12904f0b68b642fc45441d87', '2019-08-23 11:14:06', '2019-08-22 12:44:11', 2, '0');
INSERT INTO `auth_user_role` VALUES (3, 'f22d7c637250ad010e66467cbe8fc861', 'f22d7c637250ad010e66467cbe8fc861', '37dc6b9b6bec44bed7e5a05610016af0', '2019-08-24 11:14:06', '2019-08-22 12:44:13', 2, '0');
INSERT INTO `auth_user_role` VALUES (9, 'fd527649510865cdaf4403aaba75c4b2', 'd880e9a54951d3d0991f8d48e75e0f4a', '599da1061da00b32e761f50233361bcb', '2019-09-02 10:32:02', '2019-09-02 10:32:02', 2, '0');
INSERT INTO `auth_user_role` VALUES (12, '55023337a66888742c08d37b8af2493f', 'd0c556fc898bed4d09a688c0fddbb295', '1b69e87a29ea9f7dcd135083d1221080', '2019-09-02 15:56:57', '2019-09-02 15:56:57', 2, '0');
INSERT INTO `auth_user_role` VALUES (13, '5049b5d09b1378f8af20e9564d981494', '54a9c7068c6b1cb5b0486650dbe4dc2b', '210a71f81c54c40f08661309e3710843', '2019-09-25 16:58:45', '2019-09-25 16:58:45', 2, '0');
INSERT INTO `auth_user_role` VALUES (14, '711928eec48fad6bcd55e31542cdd71b', 'f5a793812019cc795dbf788babc43e7e', '210a71f81c54c40f08661309e3710843', '2020-01-14 21:37:46', '2020-01-14 21:37:46', 2, '0');
INSERT INTO `auth_user_role` VALUES (15, '72f5e91ad5aee23d3cd858f7f7e81c7d', '487efeb32243eadac28195765d9c9496', '210a71f81c54c40f08661309e3710843', '2020-01-16 11:51:05', '2020-01-16 11:51:05', 2, '0');
INSERT INTO `auth_user_role` VALUES (16, 'a14317ba83a6e02f4e503b64938ef74e', '61d069725905f507b32d45cb2e5b00e4', '210a71f81c54c40f08661309e3710843', '2020-01-17 10:38:32', '2020-01-17 10:38:32', 2, '0');
INSERT INTO `auth_user_role` VALUES (17, '3b04c144d1547c3712eb5402c1e74596', '84e57b1300d30bcf2a2863fc4e1f4ab1', '210a71f81c54c40f08661309e3710843', '2020-01-17 10:40:58', '2020-01-17 10:40:58', 2, '0');
INSERT INTO `auth_user_role` VALUES (18, '307b07e579747798dae1a747927a30c3', 'aca86f89b509aeb44955891d34a7685d', '210a71f81c54c40f08661309e3710843', '2020-01-17 10:44:39', '2020-01-17 10:44:39', 2, '0');
INSERT INTO `auth_user_role` VALUES (19, '14af8d1774d9f97f12947a269a5cb5c3', 'ece5a1ae26d6c556375a1603db0ce3e1', '210a71f81c54c40f08661309e3710843', '2020-01-17 10:46:24', '2020-01-17 10:46:24', 2, '0');
INSERT INTO `auth_user_role` VALUES (20, '0ebfc13d719c1005d1594399ec04113c', '20fb611e2e628dbb6191bd6b3398f7f2', '210a71f81c54c40f08661309e3710843', '2020-01-17 15:03:22', '2020-01-17 15:03:22', 2, '0');
INSERT INTO `auth_user_role` VALUES (21, '52203110ac21d90df1f9e83f581a8cb8', '3c3aa646abe23441417dc4ca7a45d948', '210a71f81c54c40f08661309e3710843', '2020-01-17 19:27:47', '2020-01-17 19:27:47', 2, '0');
INSERT INTO `auth_user_role` VALUES (22, 'be2f00b4abd502b5d7efb7c7f2802fdc', '6eb3d43011c49e9158c88a57924a4662', '210a71f81c54c40f08661309e3710843', '2020-01-17 19:32:19', '2020-01-17 19:32:19', 2, '0');
INSERT INTO `auth_user_role` VALUES (24, '35cfe38ba121b730729d988cea70d082', '3569cc9e6130f8707c29d1a31cc1aa64', '599da1061da00b32e761f50233361bcb', '2021-02-02 17:20:27', '2021-02-02 17:20:27', 2, '0');
INSERT INTO `auth_user_role` VALUES (25, '87264ced75b86d389774a558a778e0e4', 'aa65e9d46eeebcc27501e6a4b4269a6c', '6439df85019a918ef9c18a6ede06e1aa', '2021-04-06 21:02:13', '2021-04-06 21:02:13', 2, '0');
INSERT INTO `auth_user_role` VALUES (26, '3c2c5dad8ed7ce4402b4140d9377f524', '3cd0e9616e86dd91813d6cf34bdbca04', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-06 21:06:04', '2021-04-06 21:06:04', 2, '0');
INSERT INTO `auth_user_role` VALUES (27, '61d1d7aefa4b4be935f2bbc8d1dcd770', 'fbf741150e7574551a76b9caa1c26884', '6439df85019a918ef9c18a6ede06e1aa', '2021-04-08 15:26:59', '2021-04-08 15:26:59', 2, '0');
INSERT INTO `auth_user_role` VALUES (28, 'c03c90b9078c0f0591da9fd9be8d53f3', 'b6af8e1a0f03157c67d375140dd212ce', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-08 15:36:35', '2021-04-08 15:36:35', 2, '0');
INSERT INTO `auth_user_role` VALUES (29, '83ddf19d7ad97a19f9c2961fa4ab0508', '1b6c4c703deb614cce76d2d46276f802', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-09 11:36:45', '2021-04-09 11:36:45', 2, '0');
INSERT INTO `auth_user_role` VALUES (30, '8472222abcadd3d25f2a5ea95e9279fc', 'f294266afccee560b35eb54cd86e020b', '6439df85019a918ef9c18a6ede06e1aa', '2021-04-09 11:51:46', '2021-04-09 11:51:46', 2, '0');
INSERT INTO `auth_user_role` VALUES (31, '9df70b240ecb947aa3684421e1afa051', 'ee8248443bf272ba9fbd3032de96042b', 'e01938fe7c7637442a34342af2ed4c0d', '2021-04-09 11:52:21', '2021-04-09 11:52:21', 2, '0');
INSERT INTO `auth_user_role` VALUES (32, '14c60c585190a33b7670e9093b42f866', '380c472917763ea4cc5f9ec610c8cdfd', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-09 14:50:58', '2021-04-09 14:50:58', 2, '0');
INSERT INTO `auth_user_role` VALUES (33, 'e167649c417c2a38f0784f714dc40911', 'f0adbf87400179bc73deac593cf12c4e', '6439df85019a918ef9c18a6ede06e1aa', '2021-04-09 14:51:30', '2021-04-09 14:51:30', 2, '0');
INSERT INTO `auth_user_role` VALUES (34, '1dbd99f03a924941af595c79e44a6395', '739c6c06b8708e36308a064354e8e07a', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-11 10:34:02', '2021-04-11 10:34:02', 2, '0');
INSERT INTO `auth_user_role` VALUES (35, 'b9102dc3c1d835bac99eba9ae1906566', '360c3523d74d44b4a6707556d64c7cd7', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-11 14:14:42', '2021-04-11 14:14:42', 2, '0');
INSERT INTO `auth_user_role` VALUES (36, '4a2aab073703bbc1736575b16e9cba3f', '915d6c84042413baabe06ad7eb273d53', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-11 14:15:05', '2021-04-11 14:15:05', 2, '0');
INSERT INTO `auth_user_role` VALUES (37, '25fa9b435febdc2048e68dcb5a1237c6', '307b2563cae6547ee196945ff954f33c', 'e01938fe7c7637442a34342af2ed4c0d', '2021-04-17 16:35:45', '2021-04-17 16:35:45', 2, '0');
INSERT INTO `auth_user_role` VALUES (38, '5305d2e07e36222b805b578dbfc8131b', '50a9b07027e513b916fbcbe3d7ac7f75', '6439df85019a918ef9c18a6ede06e1aa', '2021-04-17 23:01:36', '2021-04-17 23:01:36', 2, '0');
INSERT INTO `auth_user_role` VALUES (39, '287421f1743eac5c9e395f5411aa54b2', '9f54af57130bd1efae2c40b7561fb92c', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-17 23:15:28', '2021-04-17 23:15:28', 2, '0');
INSERT INTO `auth_user_role` VALUES (40, '8d0171446e37dcacf648f47eed1706a9', 'd3c190e7c468ca16d508c3ebd608835d', '6439df85019a918ef9c18a6ede06e1aa', '2021-04-18 11:18:42', '2021-04-18 11:18:42', 2, '0');
INSERT INTO `auth_user_role` VALUES (41, 'da2254deda36ce743096b36ca4c95f90', 'b8d9e90912560f967911cf40a42e9b62', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-18 11:18:57', '2021-04-18 11:18:57', 2, '0');
INSERT INTO `auth_user_role` VALUES (42, '52f979bc5c363e2d214bcc9e68921d61', 'd01ea0e8d4d01f2f1974865733a02ef1', '6439df85019a918ef9c18a6ede06e1aa', '2021-04-18 11:20:04', '2021-04-18 11:20:04', 2, '0');
INSERT INTO `auth_user_role` VALUES (43, 'b854343e63f188909bf51bbc2450eeba', '754bd2fafee531c6b1d9f82505bf53cf', 'ada6f53f0561a95583689bf26b6efa03', '2021-04-18 11:24:52', '2021-04-18 11:24:52', 2, '0');
INSERT INTO `auth_user_role` VALUES (44, '774b9e68c403bdfc56cfb24c0eaca31f', '5cf2eed1c5f5de87dd43dd463f71eb17', '5981c32b1bdb12c60c321a2864851e09', '2021-04-27 02:16:42', '2021-04-27 02:16:42', 2, '0');
INSERT INTO `auth_user_role` VALUES (45, '3271324c48b4b846e1ef10e532c96b7d', '432c42aacf63bdeda53aca95f65b0727', '6079121de2302ae6116c5b4d95546529', '2021-04-27 09:59:06', '2021-04-27 09:59:06', 2, '0');
INSERT INTO `auth_user_role` VALUES (46, 'c0a760e037e91cf8529c44e6c9116d6a', 'b291ac80d015203b7fdac23777c5470c', '5981c32b1bdb12c60c321a2864851e09', '2021-04-27 11:14:01', '2021-04-27 11:14:01', 2, '0');
INSERT INTO `auth_user_role` VALUES (47, '72435addc0ae0ac09ea1d1e346ad3cf1', '998b0bbdbbdee82a5671fe61df1b5c9e', '5981c32b1bdb12c60c321a2864851e09', '2021-04-27 11:51:54', '2021-04-27 11:51:54', 2, '0');
INSERT INTO `auth_user_role` VALUES (48, '1f2415f9bbbf1fe6403136d2e93135e9', 'ef05ba67083f524a1005d002ef4a5a52', '5981c32b1bdb12c60c321a2864851e09', '2021-04-28 01:30:32', '2021-04-28 01:30:32', 2, '0');
INSERT INTO `auth_user_role` VALUES (49, 'c27f0069263ebb56ca46204012a1d5ce', 'a590dd7d3d829de797c51b26295d9f57', '5981c32b1bdb12c60c321a2864851e09', '2021-05-05 21:04:43', '2021-05-05 21:04:43', 2, '0');
INSERT INTO `auth_user_role` VALUES (50, '0bda9664ed3cf9f9e178a4acb68b3a85', '7cc9c6dcc38b049c1727e05e7415f2f5', '5981c32b1bdb12c60c321a2864851e09', '2021-05-09 23:32:43', '2021-05-09 23:32:43', 2, '0');
INSERT INTO `auth_user_role` VALUES (51, 'aa192988e8f627c4104c87a12e9d97d4', '69d5abc3a88101369005e9c34018c193', '5981c32b1bdb12c60c321a2864851e09', '2021-05-09 23:35:15', '2021-05-09 23:35:15', 2, '0');
INSERT INTO `auth_user_role` VALUES (52, 'e27c6f2aa7f4561414e5a1fb79e1a480', 'bfb4861e6f13f395ed3715c2d1526b49', '5981c32b1bdb12c60c321a2864851e09', '2021-05-10 13:54:10', '2021-05-10 13:54:10', 2, '0');
INSERT INTO `auth_user_role` VALUES (53, '16a25a607a2e374880af3799ec4fdff5', 'f106845bbd3da91c372961882156b584', '5981c32b1bdb12c60c321a2864851e09', '2021-05-11 01:56:20', '2021-05-11 01:56:20', 2, '0');
INSERT INTO `auth_user_role` VALUES (54, 'a37b5587c5063867c242593116441475', '17723a33fa32cd2c7723c8966121c978', '5981c32b1bdb12c60c321a2864851e09', '2021-05-11 02:01:05', '2021-05-11 02:01:05', 2, '0');
INSERT INTO `auth_user_role` VALUES (55, '4d5e151942e2bfeffee0cea8faa1ae1c', '2dd25ba5480396059d5d280236f9e90d', '5981c32b1bdb12c60c321a2864851e09', '2021-05-17 21:38:51', '2021-05-17 21:38:51', 2, '0');
INSERT INTO `auth_user_role` VALUES (62, '6e8cd012465350e9dab6d5fcdfe731a0', '7daa2c4760e87682b675a18909c6a149', '5981c32b1bdb12c60c321a2864851e09', '2021-05-24 20:03:22', '2021-05-24 20:03:22', 2, '0');
INSERT INTO `auth_user_role` VALUES (63, '5427a308e04051bcdb871a4f48334290', 'f9b155eb0faec92d4c75575cde405c7d', '599da1061da00b32e761f50233361bcb', '2021-05-24 23:38:45', '2021-05-24 23:38:45', 2, '0');
INSERT INTO `auth_user_role` VALUES (64, 'c96cc9d82769ad1dd3678f941b5bc3cb', '306d919185c1c513bee3497b42ae0a97', '6079121de2302ae6116c5b4d95546529', '2021-05-25 10:46:15', '2021-05-25 10:46:15', 2, '0');
INSERT INTO `auth_user_role` VALUES (65, '34ed0cdefb46b54a73795d0b251cd847', '4a6dbfe893888ec800a7ea089f266c68', '6079121de2302ae6116c5b4d95546529', '2021-05-25 11:03:25', '2021-05-25 11:03:25', 2, '0');
INSERT INTO `auth_user_role` VALUES (68, '35115304b8c3983175d3fab021219995', '07101473e63eaad4ebd45d1dae89c0f2', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 14:34:28', '2021-05-25 14:34:28', 2, '0');
INSERT INTO `auth_user_role` VALUES (69, '66034553568b190ecf4c4be132343dce', '26903e96aff1ad3a4a37b1027147ee4e', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 15:43:58', '2021-05-25 15:43:58', 2, '0');
INSERT INTO `auth_user_role` VALUES (70, '8934c001476796f3a1e1fb52cdcf482d', '6010bf8626251f2738b14613bfa08a85', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 15:45:57', '2021-05-25 15:45:57', 2, '0');
INSERT INTO `auth_user_role` VALUES (71, '511e68b55de00b8617ed669850384689', 'd116ab2ac4b247ca7146daeb0a6adf23', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 15:47:04', '2021-05-25 15:47:04', 2, '0');
INSERT INTO `auth_user_role` VALUES (72, 'fdb513a0d1a70af73a9312590e70c771', '915db54c8e631b9006eeefd8e07e7954', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 15:48:01', '2021-05-25 15:48:01', 2, '0');
INSERT INTO `auth_user_role` VALUES (73, '4ac31271ff42eb0449e5551f868ad237', '30e2531c24c2c93b968ca4d4d0d63a9b', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 16:52:15', '2021-05-25 16:52:15', 2, '0');
INSERT INTO `auth_user_role` VALUES (74, 'b4f48157c48c845426356381c7abe4b0', '3c92a8c22be09b7dd2bf8ddfc5dc20f3', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 16:55:50', '2021-05-25 16:55:50', 2, '0');
INSERT INTO `auth_user_role` VALUES (75, '9974e6473d421da248ce90c53cde69f6', '71634fb2b672eaa97b7d23abc88de1ef', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 17:00:40', '2021-05-25 17:00:40', 2, '0');
INSERT INTO `auth_user_role` VALUES (76, '8c4ddc32d568d77b4a520769825e683a', '4677c6abef1a7cca2d11a1efef355b06', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 17:01:55', '2021-05-25 17:01:55', 2, '0');
INSERT INTO `auth_user_role` VALUES (77, 'f76b56778d8d0c3f5e9787b6a64a1f6f', '5bf596eb51ad24618cab3a6f8d75fe2d', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 17:05:33', '2021-05-25 17:05:33', 2, '0');
INSERT INTO `auth_user_role` VALUES (78, '7e7db7201c95c56df145a5b026fce8fa', 'a49e1d60f99b0d682a2a51f5873a8302', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 17:10:22', '2021-05-25 17:10:22', 2, '0');
INSERT INTO `auth_user_role` VALUES (79, 'd89f84c3925141ef63ed54b6e5520065', 'f459d01a0b252d0585fc2c407e45a887', '5981c32b1bdb12c60c321a2864851e09', '2021-05-25 17:18:14', '2021-05-25 17:18:14', 2, '0');
INSERT INTO `auth_user_role` VALUES (82, '58ac21f007d5ce70d662dd562b1c00df', 'ef57e3a4faccb47a4850374042f27651', '5981c32b1bdb12c60c321a2864851e09', '2021-05-26 20:13:47', '2021-05-26 20:13:47', 2, '0');
INSERT INTO `auth_user_role` VALUES (87, '1fa3a427887b3e08ab1d3255f902793b', '623a4f626b332ba7e96cc3e6f5ecb389', '5981c32b1bdb12c60c321a2864851e09', '2021-06-01 09:34:10', '2021-06-01 09:34:10', 2, '0');
INSERT INTO `auth_user_role` VALUES (88, '0cc085509bb86cd9fa52dbd43a8eac38', '1bcb8593f83e92bed8fad3b2427942c5', '5981c32b1bdb12c60c321a2864851e09', '2021-06-01 09:35:05', '2021-06-01 09:35:05', 2, '0');
INSERT INTO `auth_user_role` VALUES (139, 'f3460bcdea5dfa80c0a792172ed01ab9', '6c2ed176209ddf235009ddfac641d0b2', '0cb7990473e7681253bb118e5d45c936', '2022-01-07 20:41:31', '2022-01-07 20:41:31', 2, '0');
INSERT INTO `auth_user_role` VALUES (140, '497f04ef91bfe668a814482d912ced55', 'e93e0f7db7fb259815e56402b1825e77', '0cb7990473e7681253bb118e5d45c936', '2022-01-10 19:48:20', '2022-01-10 19:48:20', 2, '0');
INSERT INTO `auth_user_role` VALUES (142, 'c144392c8b4db2d5c7ba14e7ac085ed0', '63eb7243e84bbe1bdc0fdfa455eb03ec', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 11:16:09', '2022-01-11 11:16:09', 2, '0');
INSERT INTO `auth_user_role` VALUES (143, 'f60d5779476c179d28234ee81857cd6a', 'ffb2ffda1ba565e744a3c2e4512cdbf8', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 11:18:51', '2022-01-11 11:18:51', 2, '0');
INSERT INTO `auth_user_role` VALUES (144, '0656bea48088e62bb807c02a57c09595', 'f2699643bac6bfa46a80793d15b78b7b', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 11:40:52', '2022-01-11 11:40:52', 2, '0');
INSERT INTO `auth_user_role` VALUES (145, '40f3b2a46573fad3a6595775bdc7e6a7', '76454950bbf857029675e384787942b8', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 12:58:55', '2022-01-11 12:58:55', 2, '0');
INSERT INTO `auth_user_role` VALUES (146, 'a2bfbec43ed23e278961d62a97e44ec3', 'bda375322437325415fc27d98788103c', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 17:34:02', '2022-01-11 17:34:02', 2, '0');
INSERT INTO `auth_user_role` VALUES (147, '32bac4b5d1727f1f1912292ef2c9ad12', 'b363d1f07617c4c163f98139a2d0125f', '0cb7990473e7681253bb118e5d45c936', '2022-01-11 17:36:49', '2022-01-11 17:36:49', 2, '0');
INSERT INTO `auth_user_role` VALUES (148, '464ccf7df176b4f7d7f8d5fbcde92de5', '69eaf8999b4b2b6798fde3d76ec201b7', 'bdc1fb820da5c2c414f75b2de0088449', '2022-02-10 09:27:17', '2022-02-10 09:27:17', 2, '0');

-- ----------------------------
-- Table structure for auth_user_sketch
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_sketch`;
CREATE TABLE `auth_user_sketch`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `auth_user_sketch_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '业务主键ID',
  `auth_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户业务主键ID',
  `gender` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '性别，跟随枚举',
  `age` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '年龄',
  `address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 367 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统用户简略信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of auth_user_sketch
-- ----------------------------
INSERT INTO `auth_user_sketch` VALUES (335, 'c3b424bb5e5ac511b96312e81408688e', 'd880e9a54951d3d0991f8d48e75e0f4a', 'man', 1212, '12', '2021-10-08 16:20:21', '2021-10-08 16:20:21', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (357, '8cc147c9e0ed49ad839058ab300df172', '6c2ed176209ddf235009ddfac641d0b2', 'man', 12, '1', '2022-01-07 20:41:31', '2022-01-07 20:41:31', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (358, '1cc2812b21d2d68fa859af5d678d23c6', 'e93e0f7db7fb259815e56402b1825e77', 'man', 36, '北京市南区', '2022-01-10 19:48:20', '2022-01-10 19:48:20', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (360, '20db884aa6a5af937a85f60fd7615972', '63eb7243e84bbe1bdc0fdfa455eb03ec', 'man', 12, '12', '2022-01-11 11:16:09', '2022-01-11 11:16:09', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (361, 'dfad0155f7998ae33d9375b4f74fd571', 'ffb2ffda1ba565e744a3c2e4512cdbf8', 'man', 1, '21', '2022-01-11 11:18:52', '2022-01-11 11:18:52', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (362, 'bfe1434e3d348084b1983c349a50ff46', 'f2699643bac6bfa46a80793d15b78b7b', 'man', 12, '122122', '2022-01-11 11:40:52', '2022-01-11 11:40:52', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (363, '15bcfc7d9a04313f5ba9ccf77dc066a1', '76454950bbf857029675e384787942b8', 'woman', 35, '北京市7区', '2022-01-11 12:58:56', '2022-01-11 12:58:56', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (364, '447f6d9223f2822c0db8aa05654f5351', 'bda375322437325415fc27d98788103c', 'woman', 24, '北京市3区', '2022-01-11 17:34:02', '2022-01-11 17:34:02', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (365, 'a4c73c97dc5eccbb04b7c8adc2b8385e', 'b363d1f07617c4c163f98139a2d0125f', 'man', 34, '北京市4区', '2022-01-11 17:36:49', '2022-01-11 17:36:49', 2, '0');
INSERT INTO `auth_user_sketch` VALUES (366, 'a9784273b77b6d0bda094c478b92e932', '69eaf8999b4b2b6798fde3d76ec201b7', 'man', 35, '重庆市渝北区黄杨路123号', '2022-02-10 09:27:17', '2022-02-10 09:27:17', 2, '0');

-- ----------------------------
-- Table structure for ip_address
-- ----------------------------
DROP TABLE IF EXISTS `ip_address`;
CREATE TABLE `ip_address`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ip_address_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT 'IP地址主键ID',
  `long_ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '长整型号IP',
  `ipv4` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'ipV4地址',
  `isp` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'ISP提供商',
  `ip_location` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'IP地址详细地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = 'IP地址表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ip_address
-- ----------------------------

-- ----------------------------
-- Table structure for nursing_time_off
-- ----------------------------
DROP TABLE IF EXISTS `nursing_time_off`;
CREATE TABLE `nursing_time_off`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `nursing_time_off_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '业务主键ID',
  `auth_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '护工ID',
  `time_off_begin` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请假开始时间',
  `time_off_end` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '请假结束时间',
  `time_off_remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '请假缘由',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '护工请假表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of nursing_time_off
-- ----------------------------
INSERT INTO `nursing_time_off` VALUES (2, '36cb1c7203bc6f7cd37153dbd9de1073', 'e93e0f7db7fb259815e56402b1825e77', '2021-12-15 00:00:00', '2021-12-16 00:00:00', '请假请假', '2021-12-15 10:35:16', '2021-12-15 10:35:16', 2, 'd880e9a54951d3d0991f8d48e75e0f4a');
INSERT INTO `nursing_time_off` VALUES (3, '9de904f6d9f4eaf394a8bece16143392', '76454950bbf857029675e384787942b8', '2021-01-11 00:00:00', '2021-01-14 00:00:00', '生病', '2022-01-11 17:44:03', '2022-01-11 17:44:03', 2, 'd880e9a54951d3d0991f8d48e75e0f4a');

-- ----------------------------
-- Table structure for old_sketch
-- ----------------------------
DROP TABLE IF EXISTS `old_sketch`;
CREATE TABLE `old_sketch`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `old_sketch_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '业务主键ID',
  `real_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '姓名',
  `gender` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '性别，跟随枚举',
  `age` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '年龄',
  `body_state` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '身体状况',
  `census_register` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '户籍',
  `id_card_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '身份证号码',
  `contacts` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '联系人',
  `contacts_phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '联系人号码',
  `home_address` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '家庭住址',
  `nursing_worker_num` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '志愿者',
  `intake_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登记时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '老人信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of old_sketch
-- ----------------------------
INSERT INTO `old_sketch` VALUES (1, 'a3a98452abaf444badc25a2239d83c52', '金希澈', 'woman', 76, '健康', '云南省', '21', '乐然', '12', '上海市', '76454950bbf857029675e384787942b8', '2021-12-14 00:00:00', '2021-12-14 16:52:39', '2022-01-26 10:15:13', 2, 'd880e9a54951d3d0991f8d48e75e0f4a');
INSERT INTO `old_sketch` VALUES (2, 'bd2527a88bfd80a02554f67ae6081f44', '张家帅', 'man', 85, '身体健康', '北京市三环', '5329320000000000000', '儿子张少峰', '12355756867', '北京市书院', '76454950bbf857029675e384787942b8', '2020-11-30 00:00:00', '2021-12-15 13:27:17', '2021-12-31 03:54:55', 2, 'd880e9a54951d3d0991f8d48e75e0f4a');
INSERT INTO `old_sketch` VALUES (3, '14706b3e14a5ef4ffd20b7990b2fe133', '张三', 'man', 70, '健康', '重庆市渝北区', '500112195501266416', '张二哈', '15712345678', '重庆市渝北区金山街道', '', '2022-01-25 00:00:00', '2022-01-26 09:26:13', '2022-01-26 09:26:13', 2, 'd880e9a54951d3d0991f8d48e75e0f4a');

-- ----------------------------
-- Table structure for se_activity
-- ----------------------------
DROP TABLE IF EXISTS `se_activity`;
CREATE TABLE `se_activity`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `activity_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '业务主键ID',
  `activity_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '床位编号',
  `activity_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动内容',
  `remark` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '床位备注',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否被占用',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  `activity_start_time` datetime NULL DEFAULT NULL COMMENT '活动开始时间',
  `activity_end_time` datetime NULL DEFAULT NULL COMMENT '活动结束时间',
  `activity_place` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '活动地点',
  `activity_num` int(11) NULL DEFAULT NULL COMMENT '活动人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '床位表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of se_activity
-- ----------------------------
INSERT INTO `se_activity` VALUES (2, '2f4ec99383bd87af9402062edf7140f3', '全民健身', '大家9点准时在活动地点集合', '我是备注', b'0', '2021-12-14 19:16:40', '2022-02-08 16:01:02', 1, 'd880e9a54951d3d0991f8d48e75e0f4a', '2022-02-08 14:26:01', '2022-02-09 14:26:03', '渝北区中央公园', 50);
INSERT INTO `se_activity` VALUES (3, '8231b85b48cc08e1f89841980cb0fcee', '春游', '大家9点准时在活动地点集合', '备注一', b'0', '2021-12-14 19:16:49', '2022-02-08 14:30:19', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '2022-02-08 14:26:06', '2022-02-10 14:26:09', '江北区广阳岛', 40);
INSERT INTO `se_activity` VALUES (4, 'f9bb689f2cbad618a6449386739f4f7b', '秋游', '大家9点准时在活动地点集合', '备注二', b'1', '2021-12-31 12:55:32', '2022-02-08 14:30:19', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '2022-02-07 14:26:14', '2022-02-10 14:26:18', '九龙坡区彩云湖', 30);
INSERT INTO `se_activity` VALUES (5, '6145c900b42c996a2e53a67c42bf88a2', '看江景', '大家9点准时在活动地点集合', '备注三', b'1', '2021-12-31 12:55:55', '2022-02-08 14:30:20', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '2022-02-07 14:26:22', '2022-02-08 14:26:26', '南岸区长嘉汇', 40);
INSERT INTO `se_activity` VALUES (6, 'f994a571a594a88ecc16fa8eeaa64e2e', '打麻将', '', '备注', b'1', '2022-02-08 15:50:12', '2022-02-08 15:50:12', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '2022-02-08 15:50:00', '2022-02-08 18:00:00', '小区棋牌室', 4);
INSERT INTO `se_activity` VALUES (7, 'ee2fbc2a650938fb0bc2215cc08839fa', '我是活动内容', '', '备注', b'1', '2022-02-08 16:29:50', '2022-02-08 16:29:50', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '2022-02-08 16:29:00', '2022-02-09 09:00:00', '活动地点', 23);
INSERT INTO `se_activity` VALUES (8, '29e9c110fe2c023d90ba08b3d2eac4df', '活动名称11', '内容234', '备注22', b'1', '2022-02-08 16:33:19', '2022-02-08 16:33:19', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '2022-02-08 16:40:00', '2022-02-10 09:00:00', '活动地点33', 24);

-- ----------------------------
-- Table structure for se_old_service
-- ----------------------------
DROP TABLE IF EXISTS `se_old_service`;
CREATE TABLE `se_old_service`  (
  `id` int(11) NOT NULL,
  `service_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务ID',
  `temp_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务模板ID',
  `old_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务老人Id',
  `service_time` datetime NULL DEFAULT NULL COMMENT '服务时间',
  `service_duration` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务时长',
  `nursing_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '志愿者ID',
  `status` tinyint(2) NULL DEFAULT NULL COMMENT '服务状态：1未开始 2服务中 3已结束 4已取消',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of se_old_service
-- ----------------------------

-- ----------------------------
-- Table structure for se_template_service
-- ----------------------------
DROP TABLE IF EXISTS `se_template_service`;
CREATE TABLE `se_template_service`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' ',
  `service_template_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务主键ID',
  `service_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '服务内容_名称',
  `service_money` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '服务费',
  `delete_status` int(1) NOT NULL COMMENT '是否删除 1删除 2未删除',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `operator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of se_template_service
-- ----------------------------
INSERT INTO `se_template_service` VALUES (1, '3168ff7065eef0e02882ed4a0d2c2ba6', '保洁', '20', 1, '2022-01-27 10:06:08', '2022-01-27 10:06:08', 'd880e9a54951d3d0991f8d48e75e0f4a');
INSERT INTO `se_template_service` VALUES (2, 'e447be6e8891dce1aa1caf37e3f2d4a7', '代购物', '0', 2, '2022-01-27 10:20:32', '2022-01-27 10:20:32', 'd880e9a54951d3d0991f8d48e75e0f4a');
INSERT INTO `se_template_service` VALUES (3, 'd21252d46187ec22866f315306b4629f', '上门体检', '101', 2, '2022-01-27 10:20:49', '2022-01-27 10:20:49', 'd880e9a54951d3d0991f8d48e75e0f4a');
INSERT INTO `se_template_service` VALUES (4, 'dc5bf033d9438156e765e67a1bcb98a6', '保洁', '40', 2, '2022-01-27 11:32:57', '2022-01-27 11:32:57', 'd880e9a54951d3d0991f8d48e75e0f4a');

-- ----------------------------
-- Table structure for service_record
-- ----------------------------
DROP TABLE IF EXISTS `service_record`;
CREATE TABLE `service_record`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `service_record_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '业务主键ID',
  `old_sketch_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '老人ID',
  `other_sketch` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '其他事项',
  `start_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  `status` int(1) NULL DEFAULT NULL COMMENT '状态 1待接单 2进行中 3已完成 9已取消',
  `service_template_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '模板id',
  `duration` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '时长 以分钟来计算',
  `auth_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '接单人',
  `temp_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '服务记录表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of service_record
-- ----------------------------
INSERT INTO `service_record` VALUES (2, '583b1139409cefb26ba722ed857c6c49', 'a3a98452abaf444badc25a2239d83c52', '1222', '2021-12-15 00:00:00', '2021-12-14 17:54:16', '2022-02-07 16:57:06', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 1, NULL, NULL, NULL, NULL);
INSERT INTO `service_record` VALUES (3, '494f3ed6ebb87b0c479368fa34846e33', 'bd2527a88bfd80a02554f67ae6081f44', '破坏公共用品', '2021-12-08 00:00:00', '2022-01-14 09:52:17', '2022-02-07 16:57:30', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 3, NULL, NULL, 'd880e9a54951d3d0991f8d48e75e0f4a', NULL);
INSERT INTO `service_record` VALUES (4, 'd832c5c85cd51f88bf1740126f20e289', '14706b3e14a5ef4ffd20b7990b2fe133', '', '2022-02-07 14:05:00', '2022-02-07 14:05:19', '2022-02-07 16:03:50', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 9, '', '20', '', '上门体检');
INSERT INTO `service_record` VALUES (5, '2273294ab0b8cb8d614a95c4bd512ac2', 'bd2527a88bfd80a02554f67ae6081f44', '我是备注', '2022-02-07 14:31:00', '2022-02-07 14:31:24', '2022-02-07 16:03:50', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 3, 'dc5bf033d9438156e765e67a1bcb98a6', '20', '', '保洁');
INSERT INTO `service_record` VALUES (6, '02727f6332fc4d3af02c21e0abec9c7c', 'a3a98452abaf444badc25a2239d83c52', '请带拖把', '2022-02-07 16:16:00', '2022-02-07 16:16:46', '2022-02-07 16:16:46', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 1, 'dc5bf033d9438156e765e67a1bcb98a6', '30', '', '保洁');
INSERT INTO `service_record` VALUES (7, 'e2ea242bc83a664f95929861fab1f63f', '14706b3e14a5ef4ffd20b7990b2fe133', '买点2斤五花肉，1斤青椒', '2022-02-07 16:49:00', '2022-02-07 16:49:36', '2022-02-07 16:49:51', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 3, 'e447be6e8891dce1aa1caf37e3f2d4a7', '20', 'd880e9a54951d3d0991f8d48e75e0f4a', '代购物');
INSERT INTO `service_record` VALUES (8, '67968c908adf4e04a62a294acd9eda5b', 'bd2527a88bfd80a02554f67ae6081f44', '日常保洁', '2022-02-08 10:19:00', '2022-02-07 16:58:35', '2022-02-08 10:20:00', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 1, 'dc5bf033d9438156e765e67a1bcb98a6', '50', '', '保洁');
INSERT INTO `service_record` VALUES (9, '70698561d64310f81c0ed6ddfc8a8579', 'bd2527a88bfd80a02554f67ae6081f44', '', '2022-02-08 15:46:00', '2022-02-08 15:46:18', '2022-02-08 15:46:18', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', 1, 'd21252d46187ec22866f315306b4629f', '70', '', '上门体检');

-- ----------------------------
-- Table structure for system_login_log
-- ----------------------------
DROP TABLE IF EXISTS `system_login_log`;
CREATE TABLE `system_login_log`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `system_login_log_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '系统登陆日志ID',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
  `location` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '登录地',
  `login_ip` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '登陆IP',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 256 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统登陆日志表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_login_log
-- ----------------------------
INSERT INTO `system_login_log` VALUES (175, '230ceca8f41a321bb45e797e293c4412', 'admin', '2022-01-09 21:24:07', '127.0.0.1', '127.0.0.1', '2022-01-09 21:24:07', '2022-01-09 21:24:07', 2, '0');
INSERT INTO `system_login_log` VALUES (176, 'e9fbb266268816797ef637ce478f9138', 'admin', '2022-01-10 17:23:53', '127.0.0.1', '127.0.0.1', '2022-01-10 17:23:53', '2022-01-10 17:23:53', 2, '0');
INSERT INTO `system_login_log` VALUES (177, '2572f57a328ef40e55889a7a6e6b9794', 'admin', '2022-01-10 17:33:55', '127.0.0.1', '127.0.0.1', '2022-01-10 17:33:55', '2022-01-10 17:33:55', 2, '0');
INSERT INTO `system_login_log` VALUES (178, 'd76899d2857d9b4ebcf82e6498f88eae', 'hugong', '2022-01-10 17:51:34', '127.0.0.1', '127.0.0.1', '2022-01-10 17:51:34', '2022-01-10 17:51:34', 2, '0');
INSERT INTO `system_login_log` VALUES (179, '057e5fa09758661303d8da18450711a5', 'admin', '2022-01-10 17:52:20', '127.0.0.1', '127.0.0.1', '2022-01-10 17:52:20', '2022-01-10 17:52:20', 2, '0');
INSERT INTO `system_login_log` VALUES (180, '840966dcc5ce1e0b8b14f9d67de55be2', 'admin', '2022-01-10 18:03:03', '127.0.0.1', '127.0.0.1', '2022-01-10 18:03:03', '2022-01-10 18:03:03', 2, '0');
INSERT INTO `system_login_log` VALUES (181, '0147efe25b07fd081792350ec5ef3aa9', 'admin', '2022-01-10 18:09:59', '127.0.0.1', '127.0.0.1', '2022-01-10 18:09:59', '2022-01-10 18:09:59', 2, '0');
INSERT INTO `system_login_log` VALUES (182, '589d3d1f97227f0b7d33fd18e1b018fd', 'admin', '2022-01-10 18:14:59', '127.0.0.1', '127.0.0.1', '2022-01-10 18:14:59', '2022-01-10 18:14:59', 2, '0');
INSERT INTO `system_login_log` VALUES (183, 'e82591c1cbb89f4d57751b6aaa001313', 'admin', '2022-01-10 19:42:07', '127.0.0.1', '127.0.0.1', '2022-01-10 19:42:07', '2022-01-10 19:42:07', 2, '0');
INSERT INTO `system_login_log` VALUES (184, '30614d4f9dc13fb43dc4efbc6ddb6d71', 'admin', '2022-01-11 09:49:47', '127.0.0.1', '127.0.0.1', '2022-01-11 09:49:47', '2022-01-11 09:49:47', 2, '0');
INSERT INTO `system_login_log` VALUES (185, '30457775078aefc1d57d08fad0a443fe', 'admin', '2022-01-11 10:32:57', '127.0.0.1', '127.0.0.1', '2022-01-11 10:32:57', '2022-01-11 10:32:57', 2, '0');
INSERT INTO `system_login_log` VALUES (186, '5fc899d6b75134cb156ff8807803fb7d', 'admin', '2022-01-11 12:57:55', '127.0.0.1', '127.0.0.1', '2022-01-11 12:57:55', '2022-01-11 12:57:55', 2, '0');
INSERT INTO `system_login_log` VALUES (187, '435dea57a4a50d8f8f6a1fbc228c83c3', 'admin', '2022-01-11 13:21:07', '127.0.0.1', '127.0.0.1', '2022-01-11 13:21:07', '2022-01-11 13:21:07', 2, '0');
INSERT INTO `system_login_log` VALUES (188, 'a6bd13dbad436490cfd5fa8a0d5dbdd6', 'admin', '2022-01-11 15:19:50', '127.0.0.1', '127.0.0.1', '2022-01-11 15:19:50', '2022-01-11 15:19:50', 2, '0');
INSERT INTO `system_login_log` VALUES (189, 'c7758eda8459f2adfdf79a1c1fea2be7', 'admin', '2022-01-11 17:24:14', '127.0.0.1', '127.0.0.1', '2022-01-11 17:24:14', '2022-01-11 17:24:14', 2, '0');
INSERT INTO `system_login_log` VALUES (190, '83c751437cca660ab0cb15b3db0c196a', '护工1', '2022-01-11 17:38:40', '127.0.0.1', '127.0.0.1', '2022-01-11 17:38:40', '2022-01-11 17:38:40', 2, '0');
INSERT INTO `system_login_log` VALUES (191, '495f64a6c4c77d05cae060350e702a72', 'admin', '2022-01-11 17:40:59', '127.0.0.1', '127.0.0.1', '2022-01-11 17:40:59', '2022-01-11 17:40:59', 2, '0');
INSERT INTO `system_login_log` VALUES (192, '129bd18d1f2346e9cb7fabb0e0b8fc32', '护工1', '2022-01-11 17:42:16', '127.0.0.1', '127.0.0.1', '2022-01-11 17:42:16', '2022-01-11 17:42:16', 2, '0');
INSERT INTO `system_login_log` VALUES (193, '9091c3035b247e8f92dfdcb11a7951e4', 'admin', '2022-01-11 17:43:24', '127.0.0.1', '127.0.0.1', '2022-01-11 17:43:24', '2022-01-11 17:43:24', 2, '0');
INSERT INTO `system_login_log` VALUES (194, 'c3c065e4557a1bd9853e066a53ab739e', 'admin', '2022-01-11 17:58:28', '127.0.0.1', '127.0.0.1', '2022-01-11 17:58:28', '2022-01-11 17:58:28', 2, '0');
INSERT INTO `system_login_log` VALUES (195, 'decbeb74800344f61fd760bfebd30e56', 'admin', '2022-01-12 14:25:16', '127.0.0.1', '127.0.0.1', '2022-01-12 14:25:16', '2022-01-12 14:25:16', 2, '0');
INSERT INTO `system_login_log` VALUES (196, '26c25bca2c17eea2a371f45ce3bfa801', '护工4', '2022-01-12 14:26:00', '127.0.0.1', '127.0.0.1', '2022-01-12 14:26:00', '2022-01-12 14:26:00', 2, '0');
INSERT INTO `system_login_log` VALUES (197, 'b952b9f82f21c24cf554a7b248f20e12', 'admin', '2022-01-12 14:28:35', '127.0.0.1', '127.0.0.1', '2022-01-12 14:28:35', '2022-01-12 14:28:35', 2, '0');
INSERT INTO `system_login_log` VALUES (198, '9fd5354624eb09f0d3eb2947c76315d8', 'admin', '2022-01-12 14:29:01', '127.0.0.1', '127.0.0.1', '2022-01-12 14:29:01', '2022-01-12 14:29:01', 2, '0');
INSERT INTO `system_login_log` VALUES (199, 'a86ad7afb975ec3c1f8a61b050c7d19e', '护工4', '2022-01-12 14:29:16', '127.0.0.1', '127.0.0.1', '2022-01-12 14:29:16', '2022-01-12 14:29:16', 2, '0');
INSERT INTO `system_login_log` VALUES (200, '867fcd6beba59dd209b77e13344c173b', 'admin', '2022-01-12 14:32:22', '127.0.0.1', '127.0.0.1', '2022-01-12 14:32:22', '2022-01-12 14:32:22', 2, '0');
INSERT INTO `system_login_log` VALUES (201, '4382ea0be6cf7cc5c6977f62dd991c4b', '护工4', '2022-01-12 14:35:41', '127.0.0.1', '127.0.0.1', '2022-01-12 14:35:41', '2022-01-12 14:35:41', 2, '0');
INSERT INTO `system_login_log` VALUES (202, '20016fff472dc29349c40c5d86cbe397', 'admin', '2022-01-12 17:15:38', '127.0.0.1', '127.0.0.1', '2022-01-12 17:15:38', '2022-01-12 17:15:38', 2, '0');
INSERT INTO `system_login_log` VALUES (203, '56b78e62fa429cfd0c87974e24e43c5a', '护工1', '2022-01-12 19:54:34', '127.0.0.1', '127.0.0.1', '2022-01-12 19:54:34', '2022-01-12 19:54:34', 2, '0');
INSERT INTO `system_login_log` VALUES (204, '41d3b117022e2b8aef1ba8c4df55c969', 'admin', '2022-01-12 19:55:34', '127.0.0.1', '127.0.0.1', '2022-01-12 19:55:34', '2022-01-12 19:55:34', 2, '0');
INSERT INTO `system_login_log` VALUES (205, 'fea9331bc401bd3990c89848ae8f77cb', 'admin', '2022-01-13 20:22:04', '127.0.0.1', '127.0.0.1', '2022-01-13 20:22:04', '2022-01-13 20:22:04', 2, '0');
INSERT INTO `system_login_log` VALUES (206, '642cfcfcf9f9de06b8bb6cd0e2dd4ea6', '护工1', '2022-01-14 08:33:52', '127.0.0.1', '127.0.0.1', '2022-01-14 08:33:52', '2022-01-14 08:33:52', 2, '0');
INSERT INTO `system_login_log` VALUES (207, 'd36e56cac4c841b7bc910aa836ddf656', 'admin', '2022-01-14 08:35:10', '127.0.0.1', '127.0.0.1', '2022-01-14 08:35:10', '2022-01-14 08:35:10', 2, '0');
INSERT INTO `system_login_log` VALUES (208, '3bd12ee9baa3a7216c0ecd1e63bef099', 'admin', '2022-01-14 08:38:00', '127.0.0.1', '127.0.0.1', '2022-01-14 08:38:00', '2022-01-14 08:38:00', 2, '0');
INSERT INTO `system_login_log` VALUES (209, 'f4ba7e6f718df7b82c36e9f1c93372a6', '护工1', '2022-01-14 09:44:06', '127.0.0.1', '127.0.0.1', '2022-01-14 09:44:06', '2022-01-14 09:44:06', 2, '0');
INSERT INTO `system_login_log` VALUES (210, 'eaeefa7fc5337f53c21e78ab6310689a', 'admin', '2022-01-14 09:45:17', '127.0.0.1', '127.0.0.1', '2022-01-14 09:45:17', '2022-01-14 09:45:17', 2, '0');
INSERT INTO `system_login_log` VALUES (211, '6c80901807d66e7b2a5aea3e6040a2f1', '护工1', '2022-01-14 09:46:41', '127.0.0.1', '127.0.0.1', '2022-01-14 09:46:41', '2022-01-14 09:46:41', 2, '0');
INSERT INTO `system_login_log` VALUES (212, '8a91a32b974bd56311864c79791827b4', 'admin', '2022-01-14 09:52:48', '127.0.0.1', '127.0.0.1', '2022-01-14 09:52:48', '2022-01-14 09:52:48', 2, '0');
INSERT INTO `system_login_log` VALUES (213, '1b6e59439f506d3d50fc6a93843ae6f6', 'admin', '2022-01-19 17:42:15', '127.0.0.1', '127.0.0.1', '2022-01-19 17:42:15', '2022-01-19 17:42:15', 2, '0');
INSERT INTO `system_login_log` VALUES (214, 'd7ea7ed206ec2012d1c1ec0831f7697b', 'admin', '2022-01-25 09:50:37', '127.0.0.1', '127.0.0.1', '2022-01-25 09:50:37', '2022-01-25 09:50:37', 2, '0');
INSERT INTO `system_login_log` VALUES (215, 'b8ad3fe99b39565d0990499828e77800', 'admin', '2022-01-25 13:59:57', '127.0.0.1', '127.0.0.1', '2022-01-25 13:59:57', '2022-01-25 13:59:57', 2, '0');
INSERT INTO `system_login_log` VALUES (216, '122304b0d1ccdafe1f95ffce77768e20', '护工4', '2022-01-25 14:15:39', '127.0.0.1', '127.0.0.1', '2022-01-25 14:15:39', '2022-01-25 14:15:39', 2, '0');
INSERT INTO `system_login_log` VALUES (217, '444dd7cffd2b6edb8ffcb33ad1fe5ff7', 'admin', '2022-01-25 14:19:07', '127.0.0.1', '127.0.0.1', '2022-01-25 14:19:07', '2022-01-25 14:19:07', 2, '0');
INSERT INTO `system_login_log` VALUES (218, '1ad0008e283a4a2662900e1d9a3faee8', 'admin', '2022-01-25 14:40:45', '127.0.0.1', '127.0.0.1', '2022-01-25 14:40:45', '2022-01-25 14:40:45', 2, '0');
INSERT INTO `system_login_log` VALUES (219, 'b1a4550edff022ea6f36820dab813d48', 'admin', '2022-01-25 14:54:06', '127.0.0.1', '127.0.0.1', '2022-01-25 14:54:06', '2022-01-25 14:54:06', 2, '0');
INSERT INTO `system_login_log` VALUES (220, 'dbd4618f7eeaf3608cf8791787daa9ea', 'admin', '2022-01-25 14:55:53', '127.0.0.1', '127.0.0.1', '2022-01-25 14:55:53', '2022-01-25 14:55:53', 2, '0');
INSERT INTO `system_login_log` VALUES (221, 'a2e2cd42ba17d1cdc01fb0689ef891fb', 'admin', '2022-01-25 15:53:53', '127.0.0.1', '127.0.0.1', '2022-01-25 15:53:53', '2022-01-25 15:53:53', 2, '0');
INSERT INTO `system_login_log` VALUES (222, 'dfbc5df8fa218d10bec93dbbfd9a99d3', 'admin', '2022-01-25 16:57:47', '127.0.0.1', '127.0.0.1', '2022-01-25 16:57:47', '2022-01-25 16:57:47', 2, '0');
INSERT INTO `system_login_log` VALUES (223, '45247f7ac94c00f9383d397e4eeeaced', 'admin', '2022-01-26 08:34:40', '127.0.0.1', '127.0.0.1', '2022-01-26 08:34:40', '2022-01-26 08:34:40', 2, '0');
INSERT INTO `system_login_log` VALUES (224, '6f7648602361bd0468eb9bfaa7f6b3f4', 'admin', '2022-01-26 10:39:03', '127.0.0.1', '127.0.0.1', '2022-01-26 10:39:03', '2022-01-26 10:39:03', 2, '0');
INSERT INTO `system_login_log` VALUES (225, '7f5921e52e15fbef61b7de759bf5a9b9', 'admin', '2022-01-26 14:01:55', '127.0.0.1', '127.0.0.1', '2022-01-26 14:01:55', '2022-01-26 14:01:55', 2, '0');
INSERT INTO `system_login_log` VALUES (226, '3e7f1d15b53f770f59e219ad8cb18aa9', 'admin', '2022-01-26 14:12:24', '127.0.0.1', '127.0.0.1', '2022-01-26 14:12:24', '2022-01-26 14:12:24', 2, '0');
INSERT INTO `system_login_log` VALUES (227, 'af5410cdf748ec4860531cfb70f123be', 'admin', '2022-01-26 14:28:24', '127.0.0.1', '127.0.0.1', '2022-01-26 14:28:24', '2022-01-26 14:28:24', 2, '0');
INSERT INTO `system_login_log` VALUES (228, 'ff047e1094c514e84baae16f6b7d5f06', 'admin', '2022-01-27 08:58:00', '127.0.0.1', '127.0.0.1', '2022-01-27 08:58:00', '2022-01-27 08:58:00', 2, '0');
INSERT INTO `system_login_log` VALUES (229, 'a52bccf0b310ade90f26cbfe5a71ae86', 'admin', '2022-01-27 09:22:59', '127.0.0.1', '127.0.0.1', '2022-01-27 09:22:59', '2022-01-27 09:22:59', 2, '0');
INSERT INTO `system_login_log` VALUES (230, '73beab6ff465e72a9be8bde6f3a417cf', 'admin', '2022-01-27 09:33:24', '127.0.0.1', '127.0.0.1', '2022-01-27 09:33:24', '2022-01-27 09:33:24', 2, '0');
INSERT INTO `system_login_log` VALUES (231, 'ecc4a3b76162a05f03db6a99f9e37e3a', 'admin', '2022-01-27 09:34:34', '127.0.0.1', '127.0.0.1', '2022-01-27 09:34:34', '2022-01-27 09:34:34', 2, '0');
INSERT INTO `system_login_log` VALUES (232, '62ce6e025ae6c69207f8323ea786d917', 'admin', '2022-01-27 09:58:15', '127.0.0.1', '127.0.0.1', '2022-01-27 09:58:15', '2022-01-27 09:58:15', 2, '0');
INSERT INTO `system_login_log` VALUES (233, 'a3fc00bb77782a701ac90f8df627eaf0', 'admin', '2022-01-27 10:29:34', '127.0.0.1', '127.0.0.1', '2022-01-27 10:29:34', '2022-01-27 10:29:34', 2, '0');
INSERT INTO `system_login_log` VALUES (234, '094a51a1b33e7883ef8c9730c39aec77', 'admin', '2022-01-27 10:56:56', '127.0.0.1', '127.0.0.1', '2022-01-27 10:56:56', '2022-01-27 10:56:56', 2, '0');
INSERT INTO `system_login_log` VALUES (235, '33f83a985fcdb0151afe25ef759a2b24', 'admin', '2022-01-27 11:37:33', '127.0.0.1', '127.0.0.1', '2022-01-27 11:37:33', '2022-01-27 11:37:33', 2, '0');
INSERT INTO `system_login_log` VALUES (236, '8e9b702ae90120fd412d10983f7aa046', 'admin', '2022-01-27 13:43:58', '127.0.0.1', '127.0.0.1', '2022-01-27 13:43:58', '2022-01-27 13:43:58', 2, '0');
INSERT INTO `system_login_log` VALUES (237, '543f40c4fa0d613527f8ea7a04d9bbd2', 'admin', '2022-02-07 08:27:18', '127.0.0.1', '127.0.0.1', '2022-02-07 08:27:18', '2022-02-07 08:27:18', 2, '0');
INSERT INTO `system_login_log` VALUES (238, '7ffac415664c3f6ca8ed134c3f484d07', 'admin', '2022-02-07 10:44:23', '127.0.0.1', '127.0.0.1', '2022-02-07 10:44:23', '2022-02-07 10:44:23', 2, '0');
INSERT INTO `system_login_log` VALUES (239, '2d85e4f2e391e357fc322671c1b54740', 'admin', '2022-02-07 13:43:48', '127.0.0.1', '127.0.0.1', '2022-02-07 13:43:48', '2022-02-07 13:43:48', 2, '0');
INSERT INTO `system_login_log` VALUES (240, 'f7f74acd78a03bd2925337e6126717a5', 'admin', '2022-02-07 15:45:22', '127.0.0.1', '127.0.0.1', '2022-02-07 15:45:22', '2022-02-07 15:45:22', 2, '0');
INSERT INTO `system_login_log` VALUES (241, '42bf749eb915c6ffdf3fc3bcaf9aabd2', 'admin', '2022-02-07 16:57:45', '127.0.0.1', '127.0.0.1', '2022-02-07 16:57:45', '2022-02-07 16:57:45', 2, '0');
INSERT INTO `system_login_log` VALUES (242, '827400919983a46aaced2b9dc739d9df', '志愿者1', '2022-02-07 16:58:03', '127.0.0.1', '127.0.0.1', '2022-02-07 16:58:03', '2022-02-07 16:58:03', 2, '0');
INSERT INTO `system_login_log` VALUES (243, 'b7e58061288e4511696fe81066508a8d', 'admin', '2022-02-08 08:33:34', '127.0.0.1', '127.0.0.1', '2022-02-08 08:33:34', '2022-02-08 08:33:34', 2, '0');
INSERT INTO `system_login_log` VALUES (244, '07f28f9eae4bc37a0212cde94bbf41c4', 'admin', '2022-02-08 09:11:01', '127.0.0.1', '127.0.0.1', '2022-02-08 09:11:01', '2022-02-08 09:11:01', 2, '0');
INSERT INTO `system_login_log` VALUES (245, 'dce3fd6cdc1e73675ee39b56116d9d49', 'admin', '2022-02-08 11:11:11', '127.0.0.1', '127.0.0.1', '2022-02-08 11:11:11', '2022-02-08 11:11:11', 2, '0');
INSERT INTO `system_login_log` VALUES (246, 'c1f18df8b1b9354d0af68a3b38adf167', 'admin', '2022-02-08 13:46:36', '127.0.0.1', '127.0.0.1', '2022-02-08 13:46:36', '2022-02-08 13:46:36', 2, '0');
INSERT INTO `system_login_log` VALUES (247, '37f6516161865b37bff1b719f7cb7bf8', 'admin', '2022-02-08 15:35:16', '127.0.0.1', '127.0.0.1', '2022-02-08 15:35:16', '2022-02-08 15:35:16', 2, '0');
INSERT INTO `system_login_log` VALUES (248, '10e7fb086b6b7023781c36e218e7d7b1', 'admin', '2022-02-09 09:06:00', '127.0.0.1', '127.0.0.1', '2022-02-09 09:06:00', '2022-02-09 09:06:00', 2, '0');
INSERT INTO `system_login_log` VALUES (249, '855d669c4fb312d631c19e0b1da50615', 'admin', '2022-02-09 10:12:47', '127.0.0.1', '127.0.0.1', '2022-02-09 10:12:47', '2022-02-09 10:12:47', 2, '0');
INSERT INTO `system_login_log` VALUES (250, 'db87cc8dac81f5cb3d7d091a077a7812', 'admin', '2022-02-09 13:54:56', '127.0.0.1', '127.0.0.1', '2022-02-09 13:54:56', '2022-02-09 13:54:56', 2, '0');
INSERT INTO `system_login_log` VALUES (251, 'b00d7e2db83670d75b8ec9128fc2ad54', 'admin', '2022-02-10 08:27:05', '127.0.0.1', '127.0.0.1', '2022-02-10 08:27:05', '2022-02-10 08:27:05', 2, '0');
INSERT INTO `system_login_log` VALUES (252, '9f9055506913e598e65f39a5d8043a30', '15712345678', '2022-02-10 09:27:40', '127.0.0.1', '127.0.0.1', '2022-02-10 09:27:40', '2022-02-10 09:27:40', 2, '0');
INSERT INTO `system_login_log` VALUES (253, 'c21083c32fc6a509472aa8e2db933176', 'admin', '2022-02-10 09:32:41', '127.0.0.1', '127.0.0.1', '2022-02-10 09:32:41', '2022-02-10 09:32:41', 2, '0');
INSERT INTO `system_login_log` VALUES (254, 'c182a1bca3e9d54c24d1a506d16968b5', '15712345678', '2022-02-10 09:33:55', '127.0.0.1', '127.0.0.1', '2022-02-10 09:33:55', '2022-02-10 09:33:55', 2, '0');
INSERT INTO `system_login_log` VALUES (255, '0b94e09b93518b289ec3ffbb5cdcfa4b', 'admin', '2022-02-10 09:34:40', '127.0.0.1', '127.0.0.1', '2022-02-10 09:34:40', '2022-02-10 09:34:40', 2, '0');

-- ----------------------------
-- Table structure for system_notify
-- ----------------------------
DROP TABLE IF EXISTS `system_notify`;
CREATE TABLE `system_notify`  (
  `id` int(11) NOT NULL,
  `notify_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '业务ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通知内容',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '要通知的人',
  `old_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老人ID',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '1 未读 2 已读 3 已删除',
  `create_user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_notify
-- ----------------------------

-- ----------------------------
-- Table structure for system_user_config
-- ----------------------------
DROP TABLE IF EXISTS `system_user_config`;
CREATE TABLE `system_user_config`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `system_user_config_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户系统配置主键ID',
  `auth_user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '用户业务主键ID',
  `theme` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '系统主题 dark暗色风格，light明亮风格',
  `layout` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '系统布局 side侧边栏，head顶部栏',
  `multi_page` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '页面风格 1多标签页 0单页',
  `fix_sider_bar` int(1) NOT NULL DEFAULT 2 COMMENT '页面滚动是否固定侧边栏 1固定 0不固定',
  `fix_header` int(1) NOT NULL DEFAULT 2 COMMENT '页面滚动是否固定顶栏 1固定 0不固定',
  `color` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '主题颜色 RGB值',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户系统配置表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of system_user_config
-- ----------------------------
INSERT INTO `system_user_config` VALUES (1, '89ef021dfa6c40e1e0d8e991899d206f', 'd880e9a54951d3d0991f8d48e75e0f4a', 'dark', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2019-08-22 11:30:06', '2019-08-22 11:31:55', 2, '0');
INSERT INTO `system_user_config` VALUES (2, '5a93177df79057b13d1d4bad01b8452a', '549b8ea181d29bdaaddf35fc6569ee7b', 'dark', 'side', '0', 1, 1, 'rgb(24, 144, 255)', '2019-08-22 11:30:14', '2019-08-22 11:32:10', 2, '0');
INSERT INTO `system_user_config` VALUES (3, 'ef8acbf583a5ca3f87733d49a66131d9', 'f22d7c637250ad010e66467cbe8fc861', 'dark', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2019-08-22 11:30:19', '2019-08-22 11:32:11', 2, '0');
INSERT INTO `system_user_config` VALUES (4, 'ef8acbf583a5ca3f87733d49a66131e9', '54a9c7068c6b1cb5b0486650dbe4dc2b', 'dark', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2019-08-22 11:30:19', '2019-09-25 10:05:18', 2, '0');
INSERT INTO `system_user_config` VALUES (5, 'a55f5948de1777a00b35a961cb04a5e1', 'f5a793812019cc795dbf788babc43e7e', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-14 21:37:46', '2020-01-14 21:37:46', 2, '0');
INSERT INTO `system_user_config` VALUES (6, '00dd0930a5e8bf4c49c07168fff97a32', '487efeb32243eadac28195765d9c9496', 'light', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-16 11:51:05', '2020-01-16 11:51:05', 2, '0');
INSERT INTO `system_user_config` VALUES (7, '736d39b6096f0837e6c05d1b6c28acb5', '61d069725905f507b32d45cb2e5b00e4', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-17 10:38:32', '2020-01-17 10:38:32', 2, '0');
INSERT INTO `system_user_config` VALUES (8, '48e791bceda3477f6215f1d16eb5713c', '84e57b1300d30bcf2a2863fc4e1f4ab1', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-17 10:40:58', '2020-01-17 10:40:58', 2, '0');
INSERT INTO `system_user_config` VALUES (9, '320304eba76e59189d4f80448b293b47', 'aca86f89b509aeb44955891d34a7685d', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-17 10:44:39', '2020-01-17 10:44:39', 2, '0');
INSERT INTO `system_user_config` VALUES (10, '641b95c6ed91a07e6d80646dcd98ddf0', 'ece5a1ae26d6c556375a1603db0ce3e1', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-17 10:46:24', '2020-01-17 10:46:24', 2, '0');
INSERT INTO `system_user_config` VALUES (11, '0fa725cbf54e1503897cf86d95361521', '20fb611e2e628dbb6191bd6b3398f7f2', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-17 15:03:22', '2020-01-17 15:03:22', 2, '0');
INSERT INTO `system_user_config` VALUES (12, 'e653c4e59cb7eb64e3482c52fa20ed4f', '3c3aa646abe23441417dc4ca7a45d948', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-17 19:27:47', '2020-01-17 19:27:47', 2, '0');
INSERT INTO `system_user_config` VALUES (13, '248c3b34bf4eb7cc35e0b0143ef9dc54', '6eb3d43011c49e9158c88a57924a4662', '1', 'side', '1', 1, 1, 'rgb(66, 185, 131)', '2020-01-17 19:32:19', '2020-01-17 19:32:19', 2, '0');
INSERT INTO `system_user_config` VALUES (14, 'a8a0a98d349997d90c544c58a2713a80', '3d3d05136e9e6248f9e128b975631a58', 'dark', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2020-06-28 17:44:57', '2020-06-28 17:44:57', 2, '0');
INSERT INTO `system_user_config` VALUES (15, '11883fa811cd4c6356f883de4906126c', '3569cc9e6130f8707c29d1a31cc1aa64', 'dark', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-02-02 17:20:27', '2021-02-02 17:20:27', 2, '0');
INSERT INTO `system_user_config` VALUES (16, 'c1be21a6c2e03e8a4196063a28a934b3', 'aa65e9d46eeebcc27501e6a4b4269a6c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-06 21:02:27', '2021-04-06 21:02:27', 2, '0');
INSERT INTO `system_user_config` VALUES (17, '0bd468c668dbfb73916cf2709a03efef', '3cd0e9616e86dd91813d6cf34bdbca04', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-06 21:06:04', '2021-04-06 21:06:04', 2, '0');
INSERT INTO `system_user_config` VALUES (18, '92c89bae49491079b6ebfb5788b269c7', 'fbf741150e7574551a76b9caa1c26884', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-08 15:26:59', '2021-04-08 15:26:59', 2, '0');
INSERT INTO `system_user_config` VALUES (19, 'c594ebd4fc387ad8aac4ff1dc13452bc', 'b6af8e1a0f03157c67d375140dd212ce', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-08 15:36:35', '2021-04-08 15:36:35', 2, '0');
INSERT INTO `system_user_config` VALUES (20, 'a8920a286f8dd8f3272451924d0a099c', '1b6c4c703deb614cce76d2d46276f802', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-09 11:36:45', '2021-04-09 11:36:45', 2, '0');
INSERT INTO `system_user_config` VALUES (21, '90576e4f7302f7c963c9ce4847bca575', 'f294266afccee560b35eb54cd86e020b', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-09 11:51:46', '2021-04-09 11:51:46', 2, '0');
INSERT INTO `system_user_config` VALUES (22, '1fc45ca83b34f4cb0bae677125b332d1', 'ee8248443bf272ba9fbd3032de96042b', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-09 11:52:21', '2021-04-09 11:52:21', 2, '0');
INSERT INTO `system_user_config` VALUES (23, '847cef2e4a9f655c2bd1989fb01e42a3', '380c472917763ea4cc5f9ec610c8cdfd', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-09 14:50:58', '2021-04-09 14:50:58', 2, '0');
INSERT INTO `system_user_config` VALUES (24, '0b4464e18f30b20524366d0eb5cc6681', 'f0adbf87400179bc73deac593cf12c4e', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-09 14:51:30', '2021-04-09 14:51:30', 2, '0');
INSERT INTO `system_user_config` VALUES (25, '1fe435dfce4c841b15e502b4a4f6e7b1', '739c6c06b8708e36308a064354e8e07a', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-11 10:34:02', '2021-04-11 10:34:02', 2, '0');
INSERT INTO `system_user_config` VALUES (26, '10903f980b9da924f758d87141b0bebb', '360c3523d74d44b4a6707556d64c7cd7', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-11 14:14:42', '2021-04-11 14:14:42', 2, '0');
INSERT INTO `system_user_config` VALUES (27, '978deab8558bb6221e207933d9448a9f', '915d6c84042413baabe06ad7eb273d53', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-11 14:15:05', '2021-04-11 14:15:05', 2, '0');
INSERT INTO `system_user_config` VALUES (28, '5e188a545ac824a9a97ad3ae2af600d9', '307b2563cae6547ee196945ff954f33c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-17 16:35:45', '2021-04-17 16:35:45', 2, '0');
INSERT INTO `system_user_config` VALUES (29, 'd8fa4b77e75ea03d1d6d4ca0e285fb46', '50a9b07027e513b916fbcbe3d7ac7f75', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-17 23:01:36', '2021-04-17 23:01:36', 2, '0');
INSERT INTO `system_user_config` VALUES (30, '94a3268b57dd3726cbb4bafe68f69f3b', '9f54af57130bd1efae2c40b7561fb92c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-17 23:15:28', '2021-04-17 23:15:28', 2, '0');
INSERT INTO `system_user_config` VALUES (31, 'e6f9f83befe1375e4042aa1a1a22615c', 'd3c190e7c468ca16d508c3ebd608835d', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-18 11:18:42', '2021-04-18 11:18:42', 2, '0');
INSERT INTO `system_user_config` VALUES (32, '4cb2e79fd6fd5c2be21046ce1defd785', 'b8d9e90912560f967911cf40a42e9b62', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-18 11:18:57', '2021-04-18 11:18:57', 2, '0');
INSERT INTO `system_user_config` VALUES (33, 'aa542b47f83eb90c5546f01017d92821', 'd01ea0e8d4d01f2f1974865733a02ef1', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-18 11:20:04', '2021-04-18 11:20:04', 2, '0');
INSERT INTO `system_user_config` VALUES (34, 'b8d30082523495fe443e4e57b875ed8a', '754bd2fafee531c6b1d9f82505bf53cf', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-18 11:24:52', '2021-04-18 11:24:52', 2, '0');
INSERT INTO `system_user_config` VALUES (35, '7d2fe40334f1f5e0502cf7fb881ad929', '5cf2eed1c5f5de87dd43dd463f71eb17', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-27 02:16:42', '2021-04-27 02:16:42', 2, '0');
INSERT INTO `system_user_config` VALUES (36, '90426e46d4af252c4dd70eaf68ddaed0', '432c42aacf63bdeda53aca95f65b0727', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-27 09:59:06', '2021-04-27 09:59:06', 2, '0');
INSERT INTO `system_user_config` VALUES (37, 'a57344a41ee5bb4358ec47c4a28eb4b2', 'b291ac80d015203b7fdac23777c5470c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-27 11:14:01', '2021-04-27 11:14:01', 2, '0');
INSERT INTO `system_user_config` VALUES (38, '98b93840b77371082039efaaa832f373', '998b0bbdbbdee82a5671fe61df1b5c9e', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-27 11:51:54', '2021-04-27 11:51:54', 2, '0');
INSERT INTO `system_user_config` VALUES (39, 'b7549684b22417e7bc11e90d7cead219', 'ef05ba67083f524a1005d002ef4a5a52', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-04-28 01:30:32', '2021-04-28 01:30:32', 2, '0');
INSERT INTO `system_user_config` VALUES (40, 'b9c81c5e8556f5ff1bdcb0760a1414a2', 'a590dd7d3d829de797c51b26295d9f57', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-05 21:04:43', '2021-05-05 21:04:43', 2, '0');
INSERT INTO `system_user_config` VALUES (41, 'afaaf24e1a3193ff48058dd86c81c054', '7cc9c6dcc38b049c1727e05e7415f2f5', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-09 23:32:43', '2021-05-09 23:32:43', 2, '0');
INSERT INTO `system_user_config` VALUES (42, '07907db7bf5028637cdd4343a88a170b', '69d5abc3a88101369005e9c34018c193', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-09 23:35:15', '2021-05-09 23:35:15', 2, '0');
INSERT INTO `system_user_config` VALUES (43, 'fbd72f27fef8ee9e11a76ca91048b3a4', 'bfb4861e6f13f395ed3715c2d1526b49', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-10 13:54:10', '2021-05-10 13:54:10', 2, '0');
INSERT INTO `system_user_config` VALUES (44, '91babdc45a3a79d439a906f2147f2f70', 'f106845bbd3da91c372961882156b584', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-11 01:56:20', '2021-05-11 01:56:20', 2, '0');
INSERT INTO `system_user_config` VALUES (45, 'eda493e5d1a6196e73c9168f08a003e5', '17723a33fa32cd2c7723c8966121c978', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-11 02:01:05', '2021-05-11 02:01:05', 2, '0');
INSERT INTO `system_user_config` VALUES (46, 'bd2e7876c0c5c6bcab7859190469ae98', '2dd25ba5480396059d5d280236f9e90d', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-17 21:38:51', '2021-05-17 21:38:51', 2, '0');
INSERT INTO `system_user_config` VALUES (47, 'bf8274c79d75e82db0b28d1912e0c665', 'bfb52edc62385d0cfbce25df92b3335d', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-18 14:08:44', '2021-05-18 14:08:44', 2, '0');
INSERT INTO `system_user_config` VALUES (48, '87c8bbc257f2b00bc11882ddadc21a4f', '7f9b1437fe22f14420df2a8eaa1aff00', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-18 14:13:24', '2021-05-18 14:13:24', 2, '0');
INSERT INTO `system_user_config` VALUES (49, 'e334078d6b03dda213d3a99f36422701', '707a51a157b4d60fd4b53ffcf251bd0c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-18 14:22:10', '2021-05-18 14:22:10', 2, '0');
INSERT INTO `system_user_config` VALUES (53, '433abd0da467730e4a1c0cd047277027', '7daa2c4760e87682b675a18909c6a149', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-24 20:03:22', '2021-05-24 20:03:22', 2, '0');
INSERT INTO `system_user_config` VALUES (54, 'cdd561ceecaf6475c904c4053d3ca34c', 'f9b155eb0faec92d4c75575cde405c7d', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-24 23:38:45', '2021-05-24 23:38:45', 2, '0');
INSERT INTO `system_user_config` VALUES (55, '1e1e39ae112821dadee016eb9780c05f', '306d919185c1c513bee3497b42ae0a97', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 10:46:15', '2021-05-25 10:46:15', 2, '0');
INSERT INTO `system_user_config` VALUES (56, 'f19d970092c3bb769194362efc9c61dd', '4a6dbfe893888ec800a7ea089f266c68', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 11:03:25', '2021-05-25 11:03:25', 2, '0');
INSERT INTO `system_user_config` VALUES (58, 'ec75377e288da053960d0b4430b1719e', '35d18ac5c8fde4f8cf73055e8f5e9f72', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 11:45:00', '2021-05-25 11:45:00', 2, '0');
INSERT INTO `system_user_config` VALUES (59, 'a16fe2c49c59d7860c4736d61474a0ab', '07101473e63eaad4ebd45d1dae89c0f2', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 14:34:28', '2021-05-25 14:34:28', 2, '0');
INSERT INTO `system_user_config` VALUES (60, '1eaf2c31f0b0376b74fb55f0c4a73d7d', '26903e96aff1ad3a4a37b1027147ee4e', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 15:43:58', '2021-05-25 15:43:58', 2, '0');
INSERT INTO `system_user_config` VALUES (61, '9164d2ac7862104ff535ed5a969d95a5', '6010bf8626251f2738b14613bfa08a85', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 15:45:58', '2021-05-25 15:45:58', 2, '0');
INSERT INTO `system_user_config` VALUES (62, 'b4caf34f440738fbd8d08a9e3fe4759a', 'd116ab2ac4b247ca7146daeb0a6adf23', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 15:47:04', '2021-05-25 15:47:04', 2, '0');
INSERT INTO `system_user_config` VALUES (63, 'f959943ea0ac3323ffc0982f039c8d51', '915db54c8e631b9006eeefd8e07e7954', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 15:48:01', '2021-05-25 15:48:01', 2, '0');
INSERT INTO `system_user_config` VALUES (64, '139d7ead1c818f04108c22013c5ce666', '30e2531c24c2c93b968ca4d4d0d63a9b', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 16:52:15', '2021-05-25 16:52:15', 2, '0');
INSERT INTO `system_user_config` VALUES (65, '5fcd83c264d90350f11b012b9e7657d4', '3c92a8c22be09b7dd2bf8ddfc5dc20f3', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 16:55:50', '2021-05-25 16:55:50', 2, '0');
INSERT INTO `system_user_config` VALUES (66, '43ca9eb82ea16d9cafff08f5c9f76492', '71634fb2b672eaa97b7d23abc88de1ef', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 17:00:40', '2021-05-25 17:00:40', 2, '0');
INSERT INTO `system_user_config` VALUES (67, 'adaa6f4236b51e30c762e48dc059ad6a', '4677c6abef1a7cca2d11a1efef355b06', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 17:01:55', '2021-05-25 17:01:55', 2, '0');
INSERT INTO `system_user_config` VALUES (68, '00459e5b1d98abe276b54b8659aa7480', '5bf596eb51ad24618cab3a6f8d75fe2d', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 17:05:33', '2021-05-25 17:05:33', 2, '0');
INSERT INTO `system_user_config` VALUES (69, 'fce38731ac68638d87987886509e41ea', 'a49e1d60f99b0d682a2a51f5873a8302', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 17:10:22', '2021-05-25 17:10:22', 2, '0');
INSERT INTO `system_user_config` VALUES (70, '38ee58a4d3622e1b045012d4d02924b3', 'f459d01a0b252d0585fc2c407e45a887', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 17:18:14', '2021-05-25 17:18:14', 2, '0');
INSERT INTO `system_user_config` VALUES (71, '5a236871ba5074fb34a203a32b6ed6f3', '7b3727a5e5f94a695327352e28731a7d', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 21:04:09', '2021-05-25 21:04:09', 2, '0');
INSERT INTO `system_user_config` VALUES (72, '805becfc28794c641f4ef34402875db0', 'd81718e134cc793a9c756eb3a979ad81', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-25 21:24:11', '2021-05-25 21:24:11', 2, '0');
INSERT INTO `system_user_config` VALUES (73, '2cbabf6b8d143c0dcb405e8b8585c454', 'ef57e3a4faccb47a4850374042f27651', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-26 20:13:47', '2021-05-26 20:13:47', 2, '0');
INSERT INTO `system_user_config` VALUES (74, 'fa5bb1fc253043ecc2cb68b39bcaba75', 'e93c4a30da46ddf7a832d2a0f9c820b6', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-05-26 20:19:29', '2021-05-26 20:19:29', 2, '0');
INSERT INTO `system_user_config` VALUES (75, 'fee2c4393f9525f8c9cf3f731bb50b68', '6fe0322306021009d33c00acd7017b34', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 09:24:55', '2021-06-01 09:24:55', 2, '0');
INSERT INTO `system_user_config` VALUES (76, 'e234d813e1ecafcd12cb0667489ed966', '2a90ad13ce90cf054c755cbccf576441', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 09:26:00', '2021-06-01 09:26:00', 2, '0');
INSERT INTO `system_user_config` VALUES (77, '2e4652c6cb81a55a4dc7dcbb316fb82b', '2a75c66449f6f022b879e3aaadf66e80', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 09:27:43', '2021-06-01 09:27:43', 2, '0');
INSERT INTO `system_user_config` VALUES (78, 'f9c8364ba5bcb6d3e95386ab8d395f63', '623a4f626b332ba7e96cc3e6f5ecb389', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 09:34:10', '2021-06-01 09:34:10', 2, '0');
INSERT INTO `system_user_config` VALUES (79, '22a23069ad3c67cfcc734edc375e6c38', '1bcb8593f83e92bed8fad3b2427942c5', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 09:35:05', '2021-06-01 09:35:05', 2, '0');
INSERT INTO `system_user_config` VALUES (80, '7047aba49bcb1535d8974e0e11507ffd', 'dab0b602bd2a4c44a71999392e3995c0', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 15:05:55', '2021-06-01 15:05:55', 2, '0');
INSERT INTO `system_user_config` VALUES (81, 'c9326bd1a6cce7876a6207c00c75a11e', '76efe2fa1ef4ba9d5b997f7110379f32', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 16:31:21', '2021-06-01 16:31:21', 2, '0');
INSERT INTO `system_user_config` VALUES (82, 'c15bafd0acdc0688a9915ba117ee9c8c', '2c1fcad550afd674e8f99c451dbcf8cd', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-01 17:02:10', '2021-06-01 17:02:10', 2, '0');
INSERT INTO `system_user_config` VALUES (83, 'de8d3029728fd98dd3ba8c3f814b03f6', 'e35484b5f3af88d78face028b126f8c9', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 09:25:37', '2021-06-02 09:25:37', 2, '0');
INSERT INTO `system_user_config` VALUES (84, '7b7089e0b591771fa6409226a6dd1c2f', '4d8cbd8b9824010f86712af2b0b4020d', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 09:26:16', '2021-06-02 09:26:16', 2, '0');
INSERT INTO `system_user_config` VALUES (85, '6553b876e76eb44e3774f8d51fe5c665', 'b3ec6851b7918e3654c14fc3bf33c3b6', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 09:26:50', '2021-06-02 09:26:50', 2, '0');
INSERT INTO `system_user_config` VALUES (86, '9706c63a58e5979be56e76b3c4a7dd02', 'c88c5db8d574f7621bcb76f2bb96d955', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 09:27:30', '2021-06-02 09:27:30', 2, '0');
INSERT INTO `system_user_config` VALUES (87, '8663c8a5c4113b282c2866df44412179', 'd618fae2749426bf77361abaa35987b7', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 09:28:27', '2021-06-02 09:28:27', 2, '0');
INSERT INTO `system_user_config` VALUES (88, '707d445d165b91df63a7a0f46919167d', '8cf8dcb50ab3b0e2c6094e87a8d010e7', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 09:29:00', '2021-06-02 09:29:00', 2, '0');
INSERT INTO `system_user_config` VALUES (89, '0fe6ac99998067d9decc8b8414c3ad62', 'a6d235d9aacfd99b1560611ac3c662fc', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 09:29:28', '2021-06-02 09:29:28', 2, '0');
INSERT INTO `system_user_config` VALUES (90, '9ee131b883323bae7a169362d413fd2e', '82c68e098b8f1299ec04b9cc69c8c4a0', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 11:49:36', '2021-06-02 11:49:36', 2, '0');
INSERT INTO `system_user_config` VALUES (91, 'd60d674079db9562708ba65c1f290bb2', '2ab11567f0878bca708d45d51555ff5e', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 15:02:30', '2021-06-02 15:02:30', 2, '0');
INSERT INTO `system_user_config` VALUES (92, 'd3b84f7fe028d2cfed4fc9fdf2425e56', 'c142e6a42108d2557ea7f23c432c86cd', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 15:59:27', '2021-06-02 15:59:27', 2, '0');
INSERT INTO `system_user_config` VALUES (93, '2b45977bed908c34d2990bd149b36740', '6d54062452dc53cb139898e8e2531fed', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 15:59:27', '2021-06-02 15:59:27', 2, '0');
INSERT INTO `system_user_config` VALUES (94, '20e909f87d1edebfb48bfb5ad3b8f89c', 'e7bbebcb9bc9e81b78f7b777c9b98a1c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 15:59:27', '2021-06-02 15:59:27', 2, '0');
INSERT INTO `system_user_config` VALUES (95, 'a8015d08d1589d3fa193c4a7e59a9e52', '9077a41eafe993c143bca3c240692038', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 15:59:28', '2021-06-02 15:59:28', 2, '0');
INSERT INTO `system_user_config` VALUES (96, 'd4625e73314455e191ef7dc4d5c6d5c4', 'a4ee99312dc4038c7c6a0cf2d6639239', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 15:59:28', '2021-06-02 15:59:28', 2, '0');
INSERT INTO `system_user_config` VALUES (97, '2b9eaae610a3ee186ed1715cee58e1c1', 'f689cc31b401bf65570d16460a4ac50b', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 15:59:28', '2021-06-02 15:59:28', 2, '0');
INSERT INTO `system_user_config` VALUES (98, '2fa73f53da0afdfdd90f422c244f36cb', '5d62a303b5cbb6585161f5c93aadfed7', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-02 16:39:06', '2021-06-02 16:39:06', 2, '0');
INSERT INTO `system_user_config` VALUES (99, 'd841d0711a1d82881f918baf59b7db14', '6048cb0dec95a0162be0d8b1aa00f6d9', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-17 15:04:08', '2021-06-17 15:04:08', 2, '0');
INSERT INTO `system_user_config` VALUES (100, '252139609fa35fa193d7a17c699852fe', 'f892c03bf0eb23b47206882b82c61f77', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-06-23 11:46:19', '2021-06-23 11:46:19', 2, '0');
INSERT INTO `system_user_config` VALUES (101, '37b4e5afbf40d38bc8717762063a603c', '698f4223fb3d7db636ac1e73ed7cbd68', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-07-19 16:55:39', '2021-07-19 16:55:39', 2, '0');
INSERT INTO `system_user_config` VALUES (102, '18c985e10c91ef039f25eebb37623f56', '447daeec311d596a304c1ed0e6cf7299', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-07-19 16:57:22', '2021-07-19 16:57:22', 2, '0');
INSERT INTO `system_user_config` VALUES (103, '21967ca61a2ef20538956c22be0d7616', 'bdc0982d8e5aaecbb9be29c09f52cb50', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-07-19 17:03:37', '2021-07-19 17:03:37', 2, '0');
INSERT INTO `system_user_config` VALUES (104, '9abc809aa5aa45ebb3f8db0c27b65541', '11adbaef5ab00d4b7681aec7a88fdf03', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-07-23 01:05:48', '2021-07-23 01:05:48', 2, '0');
INSERT INTO `system_user_config` VALUES (105, '24fc995253bcb3c05fabcf31d674d8f8', '56b33bf835f26ab20915118d00e2ca39', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-07-23 01:07:13', '2021-07-23 01:07:13', 2, '0');
INSERT INTO `system_user_config` VALUES (106, 'e80a808c3e568df5b0c44d238b1f3b5c', '554b8175a6626e819362482838bbe2d7', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-07-23 16:15:56', '2021-07-23 16:15:56', 2, '0');
INSERT INTO `system_user_config` VALUES (107, 'd074a8763a1edaf883e8c2e86de787cd', 'b8f502072062c5fa7c97185ce85485e4', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-07-27 14:06:54', '2021-07-27 14:06:54', 2, '0');
INSERT INTO `system_user_config` VALUES (114, 'da9ee3027f9a958e04f477f358dacf16', '52213d78d1df91f7bedb5389812f314c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-08-03 18:00:32', '2021-08-03 18:00:32', 2, '0');
INSERT INTO `system_user_config` VALUES (115, '28d704ee5a8f024272fce4c83a2a497b', '86ffa9ed231dfa941fee7a1529eaa599', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-08-09 21:26:17', '2021-08-09 21:26:17', 2, '0');
INSERT INTO `system_user_config` VALUES (116, '4e90e4244755e07ba868562e0a159f2f', '0bcdddc10fac10e567427decbea767f4', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2021-08-09 21:40:40', '2021-08-09 21:40:40', 2, '0');
INSERT INTO `system_user_config` VALUES (129, '0683ded307929cf1c93cd1acdda5bb6a', '6c2ed176209ddf235009ddfac641d0b2', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-07 20:41:31', '2022-01-07 20:41:31', 2, '0');
INSERT INTO `system_user_config` VALUES (130, '73286841749101d7561efeba85271f93', 'e93e0f7db7fb259815e56402b1825e77', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-10 19:48:20', '2022-01-10 19:48:20', 2, '0');
INSERT INTO `system_user_config` VALUES (131, 'f6b1cdecd7e417cbb8289d0d57f7b6c7', 'aa6bfd8f848eb4b4b30394d8c1008b26', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-11 11:12:30', '2022-01-11 11:12:30', 2, '0');
INSERT INTO `system_user_config` VALUES (132, 'b6e39da887f625ebb901ac6b71a17ca6', '63eb7243e84bbe1bdc0fdfa455eb03ec', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-11 11:16:09', '2022-01-11 11:16:09', 2, '0');
INSERT INTO `system_user_config` VALUES (133, '52bc6e224f75f8701f0eedeaeda71b00', 'ffb2ffda1ba565e744a3c2e4512cdbf8', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-11 11:18:52', '2022-01-11 11:18:52', 2, '0');
INSERT INTO `system_user_config` VALUES (134, 'c4026ee134f5459dfb58f92ea54fa3ac', 'f2699643bac6bfa46a80793d15b78b7b', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-11 11:40:52', '2022-01-11 11:40:52', 2, '0');
INSERT INTO `system_user_config` VALUES (135, 'c0f5e29b1af57e0b20e0dcb5e9ea9ed8', '76454950bbf857029675e384787942b8', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-11 12:58:55', '2022-01-11 12:58:55', 2, '0');
INSERT INTO `system_user_config` VALUES (136, 'e25699d090af180b9f72cb64dcbe4319', 'bda375322437325415fc27d98788103c', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-11 17:34:02', '2022-01-11 17:34:02', 2, '0');
INSERT INTO `system_user_config` VALUES (137, '377dcaf7aebe4cf5a083af6d27fec351', 'b363d1f07617c4c163f98139a2d0125f', 'light', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-01-11 17:36:49', '2022-01-11 17:36:49', 2, '0');
INSERT INTO `system_user_config` VALUES (138, 'f300e4928d4a43212d7887dd8c000d42', '69eaf8999b4b2b6798fde3d76ec201b7', 'dark', 'side', '1', 1, 1, 'rgb(24, 144, 255)', '2022-02-10 09:27:17', '2022-02-10 09:27:17', 2, '0');

-- ----------------------------
-- Table structure for volunteer_info
-- ----------------------------
DROP TABLE IF EXISTS `volunteer_info`;
CREATE TABLE `volunteer_info`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `volunteer_info_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '业务主键ID',
  `main_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要工作内容',
  `num` int(3) NULL DEFAULT NULL COMMENT '招募人数',
  `type` int(2) NULL DEFAULT NULL COMMENT '类型 1.全职 2.兼职',
  `service_time` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `delete_status` int(1) NOT NULL DEFAULT 2 COMMENT '是否删除 1删除 2未删除',
  `operator_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '操作人',
  `phone` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发布人联系方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '护工薪资表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of volunteer_info
-- ----------------------------
INSERT INTO `volunteer_info` VALUES (2, '87d450de24debf03b5da66d8549cb786', '帮助老人打扫卫生', 10, 2, '上午9点到11点', '2021-12-15 09:35:50', '2022-02-09 10:41:06', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '15712345678');
INSERT INTO `volunteer_info` VALUES (3, '787ac35c00b6c6175256210b1a58c4e1', '检查老人身体健康', 5, 2, '下午2点到5点', '2021-12-24 11:09:37', '2022-02-09 10:41:09', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '15712345678');
INSERT INTO `volunteer_info` VALUES (4, '3bf798f306ad78be2143aa8300df0b6c', '帮助老人购物', 10, 2, '全天', '2021-12-24 11:13:30', '2022-02-09 10:41:10', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '15712345678');
INSERT INTO `volunteer_info` VALUES (5, '2c03cbdd1338e10f795e039ee57da8c7', '带老人遛弯儿', 10, 1, '下午3点到5点', '2021-12-24 11:14:14', '2022-02-09 10:41:11', 2, 'd880e9a54951d3d0991f8d48e75e0f4a', '15712345678');
INSERT INTO `volunteer_info` VALUES (6, '5fa84322c3bed9ea307ec703bfbfd5a8', '洗衣煮饭11', 11, 2, '中午11点-下午2点', '2022-02-09 14:00:24', '2022-02-09 15:10:18', 1, 'd880e9a54951d3d0991f8d48e75e0f4a', '13323456789');

SET FOREIGN_KEY_CHECKS = 1;

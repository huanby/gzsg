/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL5.7_LOCALHOST
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : gzsg

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 26/08/2020 14:57:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_major_text
-- ----------------------------
DROP TABLE IF EXISTS `b_major_text`;
CREATE TABLE `b_major_text`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `majorId` int(11) NOT NULL COMMENT '文档id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` int(1) NOT NULL DEFAULT 2 COMMENT '文档所属类型，1：学校、2：专业 3：专业群',
  `state` int(1) NOT NULL DEFAULT 1 COMMENT '文档状态，1：未评价、2：已评价',
  `isdel` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0：未删除、1：删除',
  `createtime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updatetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `t1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业（群）名称',
  `t2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业所属大类',
  `t3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '龙头专业代码',
  `t4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所在院（系）',
  `t5` datetime(0) NULL DEFAULT NULL COMMENT '专业批准设置时间',
  `t6` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否国示或省重专业及批准时间',
  `t7` datetime(0) NULL DEFAULT NULL COMMENT '首届学生毕业时间',
  `t8` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `t9` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '性别',
  `t10` datetime(0) NULL DEFAULT NULL COMMENT '出生年月',
  `t11` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '参加工作时学历及所学专业',
  `t12` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '最后学历及所学专业',
  `t13` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '专业技术职称',
  `t14` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证书擅长专业领域',
  `t15` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职务',
  `t16` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职业资格（含行业企业认证）',
  `t17` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要社会兼职',
  `t18` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要业绩（含企业实践）及相关荣誉',
  `t19` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否入选“吉林省普通高等学校高水平专业（群）建设计划',
  `t20` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否选入国家、省级重点专业',
  `t21` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否入选“吉林省现代职业教育改革发展示范校建设计划项目”',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人ID',
  `t22` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申报学校',
  `t23` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申报类别',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_major_text
-- ----------------------------
INSERT INTO `b_major_text` VALUES (13, 13, NULL, 2, 1, 0, '2020-08-19 14:24:34', '2020-08-26 14:47:02', '测试专业111', '资源环境与安全大类', '0002', '测试', '2020-08-18 00:00:00', '是', '2020-08-16 00:00:00', '测试', '女', '2020-08-02 00:00:00', '测试', '测试', '测试', '测试', '测试', '测试', '测试', '测试', '1', '1,2,3,4', '否', 40, '测试', '专业群');
INSERT INTO `b_major_text` VALUES (16, 690640499, NULL, 2, 1, 0, '2020-08-19 14:59:10', '2020-08-26 14:48:13', '测试专业7', '资源环境与安全大类', '0009', '测试', '2020-08-02 00:00:00', '否', '2020-08-21 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, '测试aaa2', '特色专业');
INSERT INTO `b_major_text` VALUES (21, 204136131, NULL, 2, 1, 0, '2020-08-20 09:56:36', '2020-08-26 14:43:48', '测试专业1', '资源环境与安全大类', '0002', '测试6', NULL, '是', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (22, 376294292, NULL, 2, 1, 0, '2020-08-20 10:00:40', '2020-08-26 14:43:48', '测试专业11', '资源环境与安全大类', '00011', '测试11', NULL, '是', NULL, '测试11', '女', NULL, '测试11', '测试11', '测试11', '测试11', '测试11', '测试11', '测试11', '测试11', '0', '1,2,3,4,5', '是', 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (23, 1467329725, NULL, 2, 1, 0, '2020-08-20 10:05:33', '2020-08-26 14:43:48', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, '是', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (32, 1240607124, NULL, 2, 1, 0, '2020-08-20 14:11:05', '2020-08-26 14:43:48', '测试20', '资源环境与安全大类', '000020', '测试20', '2020-08-18 00:00:00', '是', '2020-08-18 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (33, 1143251198, NULL, 2, 1, 0, '2020-08-20 15:35:47', '2020-08-26 14:43:48', '测试专业123', '公安与司法大类', '0002', '测试1', '2020-08-18 00:00:00', '是', '2020-08-18 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 39, NULL, NULL);
INSERT INTO `b_major_text` VALUES (39, 550608583, NULL, 2, 1, 0, '2020-08-21 11:44:03', '2020-08-26 14:43:48', '测试专业11', '公安与司法大类', '0002', '测试', '2020-08-18 00:00:00', '是', '2020-08-18 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (40, 45015436, NULL, 2, 1, 0, '2020-08-21 11:46:32', '2020-08-26 14:43:48', '测试专业1', '公安与司法大类', '0002', '测试6', '2020-08-18 00:00:00', '是', '2020-08-18 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (41, 168826308, NULL, 2, 1, 0, '2020-08-21 11:57:41', '2020-08-26 14:43:48', '测试专业11111', '公共管理与服务大类', '0002', '测试', '2020-07-30 00:00:00', '是', '2020-08-18 00:00:00', '测试', '男', '2020-08-02 00:00:00', '测试', '测试', '测试', '测试', '测试', '测试11', '测试', '测试', '1', '1,2', '是', 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (42, 66246747, NULL, 2, 1, 0, '2020-08-21 12:08:51', '2020-08-26 14:43:48', '测试专业12', '公安与司法大类', '0002', '测试', '2020-08-18 00:00:00', '是', '2020-08-18 00:00:00', '测试', '女', '2020-08-02 00:00:00', '测试', '测试', '测试', '测试', '测试', '测试', '测试', '测试', NULL, NULL, NULL, 40, NULL, NULL);
INSERT INTO `b_major_text` VALUES (43, 1073291305, NULL, 2, 1, 0, '2020-08-26 12:08:21', '2020-08-26 14:43:48', '测试aaa1', '资源环境与安全大类', '0002', '测试', '2020-08-18 00:00:00', '是', '2020-08-18 00:00:00', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1', '是', 40, '测试', '专业群');

SET FOREIGN_KEY_CHECKS = 1;

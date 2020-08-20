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

 Date: 20/08/2020 09:53:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_major_number
-- ----------------------------
DROP TABLE IF EXISTS `b_major_number`;
CREATE TABLE `b_major_number`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `majorId` int(11) NOT NULL COMMENT '专业文档id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` int(1) NOT NULL DEFAULT 2 COMMENT '文档所属类型，1：学校、2：专业 3：专业群',
  `state` int(1) NOT NULL DEFAULT 1 COMMENT '文档状态，1：未评价、2：已评价',
  `isdel` int(1) NOT NULL DEFAULT 0 COMMENT '是否删除：0：未删除、1：删除',
  `createtime` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `updatetime` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `n1` int(11) NULL DEFAULT NULL COMMENT '专业在校生数（含顶岗实习学生人数）',
  `n2` int(11) NULL DEFAULT NULL COMMENT '2017年专业招生人数/专业在校生人数（人）',
  `n3` int(11) NULL DEFAULT NULL COMMENT '2018年专业招生人数/专业在校生人数（人）',
  `n4` int(11) NULL DEFAULT NULL COMMENT '2019年专业招生人数/专业在校生人数（人）',
  `n5` int(11) NULL DEFAULT NULL COMMENT '2017年毕业生数',
  `n6` int(11) NULL DEFAULT NULL COMMENT '2018年毕业生数',
  `n7` int(11) NULL DEFAULT NULL COMMENT '2019年毕业生数',
  `n8` double(30, 2) NULL DEFAULT NULL COMMENT '2018届毕业生年底就业率（%）',
  `n9` double(30, 2) NULL DEFAULT NULL COMMENT '2018届毕业生用人单位满意或基本满意比例（%）',
  `n10` int(11) NULL DEFAULT NULL COMMENT '校内专任教师数（人）',
  `n11` double(30, 2) NULL DEFAULT NULL COMMENT '专任教师双师素质比例（%）',
  `n12` int(11) NULL DEFAULT NULL COMMENT '校内专任教师高级职称人数（人）',
  `n13` double(30, 2) NULL DEFAULT NULL COMMENT '专任教师研究生以上学历人数比例（%）',
  `n14` int(11) NULL DEFAULT NULL COMMENT '2018-20198学年兼职教师总数（人）',
  `n15` double(30, 2) NULL DEFAULT NULL COMMENT '兼职教师人数占专业课教师总数的比例（%）',
  `n16` int(11) NULL DEFAULT NULL COMMENT '校内实训基地数（个）',
  `n17` int(11) NULL DEFAULT NULL COMMENT '校内实训基地工位数（个）',
  `n18` double(30, 2) NULL DEFAULT NULL COMMENT '校内实训基地生均设备值（万元/生）',
  `n19` double(30, 2) NULL DEFAULT NULL COMMENT '2018-2019学年校内实训基地使用频率（人时）',
  `n20` int(11) NULL DEFAULT NULL COMMENT '校外实习实训基地数（个）',
  `n21` int(11) NULL DEFAULT NULL COMMENT '2018-2019学年校外实习实训基地接受半年顶岗实习学生数（人）',
  `n22` int(11) NULL DEFAULT NULL COMMENT '校外实习实训基地接收2019届毕业生就业数（人）',
  `n23` int(11) NULL DEFAULT NULL COMMENT '本专业合作企业总数（个）',
  `n24` int(11) NULL DEFAULT NULL COMMENT '本专业合作企业订单培养总数（人）',
  `n25` int(11) NULL DEFAULT NULL COMMENT '本专业合作企业共同开发课程总数（门）',
  `n26` int(11) NULL DEFAULT NULL COMMENT '本专业合作企业支持学校兼职教师总数（人）',
  `n27` double(30, 2) NULL DEFAULT NULL COMMENT '合作企业对本专业准捐赠设备总值（万元）',
  `n28` double(30, 2) NULL DEFAULT NULL COMMENT '合作企业对本专业捐赠设备总值（万元）',
  `n29` double(30, 2) NULL DEFAULT NULL COMMENT '本专业为企业培训员工总数（人天）',
  `n30` int(11) NULL DEFAULT NULL COMMENT '骨干专业国家级现代学徒制试点项目数（个）',
  `n31` int(11) NULL DEFAULT NULL COMMENT '骨干专业省级现代学徒制试点项目数（个）',
  `n32` int(11) NULL DEFAULT NULL COMMENT '近两届骨干专业国家级教学成果奖数（个）',
  `n33` int(11) NULL DEFAULT NULL COMMENT '近两届骨干专业省级教学成果奖数（个）',
  `n34` int(11) NULL DEFAULT NULL COMMENT '专业群学生国赛获奖数（个）',
  `n35` int(11) NULL DEFAULT NULL COMMENT '专业群学生省赛获奖数（个）',
  `n36` int(11) NULL DEFAULT NULL COMMENT '专业群教师队伍建设成果数，（国家职业教育教师教学创新团队、省级及以上黄大年式教学团队、长白山技能名师、省级及以上教师教学大赛获奖）（个）',
  `n37` int(11) NULL DEFAULT NULL COMMENT '专业群三年累计社会培训和鉴定人数（个）',
  `n38` int(11) NULL DEFAULT NULL COMMENT '国家级科研成果、论文与专利数（个）',
  `n39` int(11) NULL DEFAULT NULL COMMENT '省级科研成果、论文与专利数（个）',
  `n40` int(11) NULL DEFAULT NULL COMMENT '骨干专业在校生规模（人数）',
  `n41` int(11) NULL DEFAULT NULL COMMENT '专业（群）实训基地建设成果数（个）',
  `n42` int(11) NULL DEFAULT NULL COMMENT '专业群服务“一带一路”战略的国际交流与合作项目数（个）',
  `n43` double(30, 2) NULL DEFAULT NULL COMMENT '专业群建设各级专项资金投入（单位：万元）',
  `n44` int(11) NULL DEFAULT NULL COMMENT '其他省级以上标志性成果数（个）',
  `create_id` int(11) NULL DEFAULT NULL COMMENT '创建人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_major_number
-- ----------------------------
INSERT INTO `b_major_number` VALUES (1, 1, NULL, 2, 1, 0, '2020-08-17 14:34:24', '2020-08-19 14:42:47', NULL, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `b_major_number` VALUES (2, 2, NULL, 2, 1, 0, '2020-08-19 12:20:57', '2020-08-19 14:42:47', NULL, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (3, 3, NULL, 2, 1, 0, '2020-08-19 12:22:03', '2020-08-19 14:42:47', NULL, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (4, 4, NULL, 2, 1, 0, '2020-08-19 12:24:13', '2020-08-19 14:42:47', 10, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (5, 5, NULL, 2, 1, 0, '2020-08-19 12:27:04', '2020-08-19 14:42:47', 14, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (6, 6, NULL, 2, 1, 0, '2020-08-19 12:28:06', '2020-08-19 14:42:47', 15, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (7, 7, NULL, 2, 1, 0, '2020-08-19 13:02:49', '2020-08-19 14:42:47', 10, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (8, 8, NULL, 2, 1, 0, '2020-08-19 13:03:31', '2020-08-19 14:42:47', 10, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (9, 9, NULL, 2, 1, 0, '2020-08-19 13:05:45', '2020-08-19 14:42:47', 10, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (10, 10, NULL, 2, 1, 0, '2020-08-19 13:06:34', '2020-08-19 14:42:47', NULL, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `b_major_number` VALUES (11, 11, NULL, 2, 1, 0, '2020-08-19 13:22:13', '2020-08-19 14:42:47', 16, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (12, 12, NULL, 2, 1, 0, '2020-08-19 13:33:28', '2020-08-19 14:42:47', 18, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (13, 13, NULL, 2, 1, 0, '2020-08-19 14:24:34', '2020-08-19 14:42:47', NULL, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (14, 14, NULL, 2, 1, 0, '2020-08-19 14:29:28', '2020-08-19 14:42:47', NULL, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (15, 946755037, NULL, 2, 1, 0, '2020-08-19 14:34:23', '2020-08-19 14:46:09', 10, 1, 1, 1, 1, 1, 1, 1.00, 1.28, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (16, 690640499, NULL, 2, 1, 0, '2020-08-19 14:59:10', '2020-08-19 15:01:30', 17, 1, 1, 1, 7, 1, 1, 1.00, 1.56, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (17, 847103882, NULL, 2, 1, 0, '2020-08-19 15:49:07', '2020-08-19 15:49:07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (18, 1037207013, NULL, 2, 1, 0, '2020-08-19 15:51:02', '2020-08-19 15:52:35', 19, 1, 1, 1, 1, 1, 1, 1.00, 1.00, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (19, 928580036, NULL, 2, 1, 0, '2020-08-19 15:58:23', '2020-08-19 15:58:23', 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_number` VALUES (20, 1866264666, NULL, 2, 1, 0, '2020-08-20 09:50:08', '2020-08-20 09:50:08', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.23, 1, 40);

SET FOREIGN_KEY_CHECKS = 1;


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
  `t6` datetime(0) NULL DEFAULT NULL COMMENT '是否国示或省重专业及批准时间',
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_major_text
-- ----------------------------
INSERT INTO `b_major_text` VALUES (2, 2, NULL, 2, 1, 0, '2020-08-19 10:18:34', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `b_major_text` VALUES (3, 3, NULL, 2, 1, 0, '2020-08-19 12:20:57', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (4, 4, NULL, 2, 1, 0, '2020-08-19 12:22:03', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (5, 5, NULL, 2, 1, 0, '2020-08-19 12:24:13', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (6, 6, NULL, 2, 1, 0, '2020-08-19 12:27:04', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (7, 7, NULL, 2, 1, 0, '2020-08-19 12:28:06', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (8, 8, NULL, 2, 1, 0, '2020-08-19 13:02:50', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (9, 9, NULL, 2, 1, 0, '2020-08-19 13:03:32', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (10, 10, NULL, 2, 1, 0, '2020-08-19 13:05:45', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (11, 11, NULL, 2, 1, 0, '2020-08-19 13:22:13', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (12, 12, NULL, 2, 1, 0, '2020-08-19 13:33:28', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (13, 13, NULL, 2, 1, 0, '2020-08-19 14:24:34', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (14, 14, NULL, 2, 1, 0, '2020-08-19 14:29:28', '2020-08-19 15:00:13', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (15, 946755037, NULL, 2, 1, 0, '2020-08-19 14:34:23', '2020-08-19 14:46:10', '测试专业1', '资源环境与安全大类', '0002', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (16, 690640499, NULL, 2, 1, 0, '2020-08-19 14:59:10', '2020-08-19 15:02:31', '测试专业7', '资源环境与安全大类', '0009', '测试', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (17, 847103882, NULL, 2, 1, 0, '2020-08-19 15:49:07', '2020-08-19 15:49:07', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '测试', '男', NULL, '测试', '测试', '测试', '测试', '测试', '测试', '测试', '测试', NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (18, 1037207013, NULL, 2, 1, 0, '2020-08-19 15:51:02', '2020-08-19 15:55:05', '测试专业9', '资源环境与安全大类', '0009', '测试9', NULL, NULL, NULL, '测试2', '女', NULL, '测试2', '测试2', '测试2', '测试2', '测试2', '测试2', '测试2', '测试2', NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (19, 928580036, NULL, 2, 1, 0, '2020-08-19 15:58:23', '2020-08-19 15:58:23', '测试专业10', '资源环境与安全大类', '00010', '测试10', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40);
INSERT INTO `b_major_text` VALUES (20, 1866264666, NULL, 2, 1, 0, '2020-08-20 09:50:08', '2020-08-20 09:50:08', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1,2', '1,2', '是', 40);

SET FOREIGN_KEY_CHECKS = 1;




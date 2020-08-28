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

 Date: 26/08/2020 14:57:19
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
  `score_end` decimal(30, 2) NULL DEFAULT NULL COMMENT '评分结果',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_major_number
-- ----------------------------
INSERT INTO `b_major_number` VALUES (13, 13, NULL, 2, 1, 0, '2020-08-19 14:24:34', '2020-08-20 16:48:53', 10, 1, 1, 1, 1, 1, 1, 1.00, 1.27, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 11.00, 1.00, 10.20, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.23, 1, 40, 40.20);
INSERT INTO `b_major_number` VALUES (16, 690640499, NULL, 2, 1, 0, '2020-08-19 14:59:10', '2020-08-19 15:01:30', 17, 1, 1, 1, 7, 1, 1, 1.00, 1.56, 1, 1.00, 1, 1.00, 1, 1.00, 1, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 1.00, 1.00, 1.00, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL);
INSERT INTO `b_major_number` VALUES (21, 204136131, NULL, 2, 1, 0, '2020-08-20 09:56:36', '2020-08-20 09:56:36', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL);
INSERT INTO `b_major_number` VALUES (22, 376294292, NULL, 2, 1, 0, '2020-08-20 10:00:40', '2020-08-20 10:02:48', 11, 1, 1, 1, 1, 1, 1, 1.24, 1.24, 1, 1.24, 10, 1.24, 1, 1.24, 20, 1, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 1.00, 1.24, 1.00, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.27, 1, 40, NULL);
INSERT INTO `b_major_number` VALUES (23, 1467329725, NULL, 2, 1, 0, '2020-08-20 10:05:33', '2020-08-20 10:05:33', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL);
INSERT INTO `b_major_number` VALUES (32, 1240607124, NULL, 2, 1, 0, '2020-08-20 14:11:05', '2020-08-20 14:11:05', 20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL);
INSERT INTO `b_major_number` VALUES (33, 1143251198, NULL, 2, 1, 0, '2020-08-20 15:35:47', '2020-08-21 11:06:59', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 39, NULL);
INSERT INTO `b_major_number` VALUES (39, 550608583, NULL, 2, 1, 0, '2020-08-21 11:44:03', '2020-08-21 11:44:03', 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL);
INSERT INTO `b_major_number` VALUES (40, 45015436, NULL, 2, 1, 0, '2020-08-21 11:46:32', '2020-08-21 11:46:32', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL);
INSERT INTO `b_major_number` VALUES (41, 168826308, NULL, 2, 1, 0, '2020-08-21 11:57:41', '2020-08-21 11:59:05', 10, 1, 1, 1, 1, 11, 1, 1.00, 1.00, 1, 1.00, 111, 1.00, 11, 1.00, 11, 1, 1.00, 1.00, 1, 1, 10, 1, 1, 11, 1, 1.00, 1.00, 1.00, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.23, 1, 40, NULL);
INSERT INTO `b_major_number` VALUES (42, 66246747, NULL, 2, 1, 0, '2020-08-21 12:08:51', '2020-08-21 12:08:51', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 40, NULL);
INSERT INTO `b_major_number` VALUES (43, 1073291305, NULL, 2, 1, 0, '2020-08-26 12:08:21', '2020-08-26 12:08:47', 10, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1.00, 1, 40, NULL);

SET FOREIGN_KEY_CHECKS = 1;

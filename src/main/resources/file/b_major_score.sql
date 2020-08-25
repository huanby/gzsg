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

 Date: 21/08/2020 17:07:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_major_score
-- ----------------------------
DROP TABLE IF EXISTS `b_major_score`;
CREATE TABLE `b_major_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `majorId` int(11) NOT NULL COMMENT '专业文档id',
  `create_id` int(11) NOT NULL COMMENT '评价者ID',
  `score` double(30,2) DEFAULT NULL COMMENT '得分',
  `isdel` int(1) NOT NULL DEFAULT '0' COMMENT '是否删除：0：未删除、1：删除',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `remark` text COMMENT '评价说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : jonty
 Source Server Type    : MySQL
 Source Server Version : 50733
 Source Host           : localhost:3306
 Source Schema         : blogdb

 Target Server Type    : MySQL
 Target Server Version : 50733
 File Encoding         : 65001

 Date: 17/05/2021 15:55:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentId` int(10) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `author` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `postId` bigint(20) NULL DEFAULT NULL,
  `status` int(1) NULL DEFAULT NULL COMMENT '0 表示未审核, 1 表示审核通过',
  PRIMARY KEY (`commentId`) USING BTREE,
  INDEX `fk_post_comm`(`postId`) USING BTREE,
  CONSTRAINT `fk_post_comm` FOREIGN KEY (`postId`) REFERENCES `post` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (24, '来咯', '雷', '', 29, 1);
INSERT INTO `comment` VALUES (28, '雷猴', '正正', '123456@qq.com', 35, 1);
INSERT INTO `comment` VALUES (30, '雷猴', '正正', '123456@qq.com', 35, 1);
INSERT INTO `comment` VALUES (43, '踩一踩', '德华', '', 30, 1);
INSERT INTO `comment` VALUES (44, '一条新的评论', '', '', 30, 1);
INSERT INTO `comment` VALUES (45, '测试', '', '', 30, 1);
INSERT INTO `comment` VALUES (49, '这篇水仙花写得好', '正正', '123456@qq.com', 30, 1);
INSERT INTO `comment` VALUES (50, '这篇文章写得好', '雷锋', '123456@qq.com', 64, 1);

SET FOREIGN_KEY_CHECKS = 1;

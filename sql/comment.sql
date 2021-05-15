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

 Date: 16/05/2021 00:43:56
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
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (24, '来咯', '雷', '', 29, 1);
INSERT INTO `comment` VALUES (25, '俺也一样', '张飞', '', 29, 0);
INSERT INTO `comment` VALUES (28, '雷猴', '正正', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (29, '雷猴', '正正', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (30, '雷猴', '正正', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (31, '整一波', '整整', '3207961486@qq.com', 35, 0);
INSERT INTO `comment` VALUES (32, '你好, 警察', '警察', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (33, '你好, 警察', '警察', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (34, '你好, 警察', '警察', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (35, '你好, 警察', '警察', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (36, '你好, 警察', '警察', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (37, ' 警察 警察 警察 警察 警察 警察', '警察', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (39, '222', 'zheng jonty', 'jontyzhen@gmail.com', 35, 0);
INSERT INTO `comment` VALUES (40, 'eee', 'zheng jonty', '123456@qq.com', 35, 0);
INSERT INTO `comment` VALUES (41, 'uuu', 'zheng jonty', '123456@qq.com', 34, 0);
INSERT INTO `comment` VALUES (43, '踩一踩', '德华', '', 30, 0);
INSERT INTO `comment` VALUES (44, '一条新的评论', '', '', 30, 0);
INSERT INTO `comment` VALUES (45, '测试', '', '', 30, 0);
INSERT INTO `comment` VALUES (46, '测试不输入姓名', '', '', 30, 0);
INSERT INTO `comment` VALUES (47, '测试不输入邮箱', 'eee', '', 30, 0);
INSERT INTO `comment` VALUES (48, '完整的评论内容', '完整的ID', '完整的邮箱', 30, 0);

SET FOREIGN_KEY_CHECKS = 1;

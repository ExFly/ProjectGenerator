/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mis_exfly

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-12-17 19:56:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) unsigned NOT NULL,
  `newstittle` varchar(36) NOT NULL,
  `newscontent` varchar(256) NOT NULL,
  `publictime` datetime NOT NULL,
  `private` int(11) DEFAULT '8',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  CONSTRAINT `newsuserid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '2', 'title1', 'content1', '2016-12-01 16:09:34', '0');
INSERT INTO `news` VALUES ('2', '1', 'title2', 'content2', '2016-12-01 16:09:54', '8');
INSERT INTO `news` VALUES ('3', '2', 'title3', 'content3', '2016-12-21 17:53:41', '8');
INSERT INTO `news` VALUES ('4', '2', 'title4', 'content4', '2016-12-20 17:54:00', '0');
INSERT INTO `news` VALUES ('5', '2', 'title5', 'content5', '2016-12-14 17:54:20', '0');
INSERT INTO `news` VALUES ('6', '2', '中文测试', '中文测试content', '2016-12-08 19:06:14', '8');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `username` char(16) NOT NULL,
  `password` char(16) NOT NULL,
  `private` int(11) NOT NULL DEFAULT '8',
  `usergroup` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0000000001', 'root', 'toor', '0', null);
INSERT INTO `user` VALUES ('0000000002', 'test', 'test', '8', null);

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userinfoid` int(11) NOT NULL,
  `userid` int(10) unsigned NOT NULL,
  `nickname` char(16) DEFAULT NULL,
  `phonenumber` char(16) DEFAULT NULL,
  PRIMARY KEY (`userinfoid`),
  KEY `userinfouserid` (`userid`),
  CONSTRAINT `userinfouserid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------

/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : mis_exfly

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2016-12-28 22:19:57
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('7', '1', '中央发文：这项工作没做好 一把手别想升迁', '14日，一份由中办、国办印发的文件正式面世，让所有政法君为之瞩目。', '2016-12-08 19:59:20', '8');
INSERT INTO `news` VALUES ('8', '1', '解放军发布疑似我军轰6K战机与台湾玉山合影(图)', '12月16日晚，解放军空军官方微博@空军发布发表图片，并配发文字“周末，分享一幅很有意义的照片！”。照片中显示轰-6K战略轰炸机正在云上飞行，远处可以看到两座相邻的山峰。从山峰形状看，这很可能是台湾南投县境内的玉山主峰，其标高为3952米，距离海岸线50公里。从照片中“玉山”南北两峰位置关系看，图中的轰炸机正在由北向南飞行，表明这是解放军空军编队11月25日环绕台湾飞行演训时所拍摄的照片。', '2016-12-21 19:59:58', '0');
INSERT INTO `news` VALUES ('9', '1', '日外交官：中国崛起带来不安 请考虑邻国感受', '[石川浩司：请中方考虑周边国家的感受]日本驻华大使馆政务公使石川浩司在#环球时报2017年会#上说：中国的崛起，周边国家适应新的崛起，对这一点，可能韩国有同样的感受，中国崛起，中国发展，可能是历史性的潮流，但是与此同时，如果可能的话，请给我们提供发展的条件。比如中国海军在西太平洋军事演习，2009', '2016-12-14 20:00:33', '0');
INSERT INTO `news` VALUES ('10', '2', '整个青年班子沦陷 不到30岁的“女一号”干了啥', '“政事儿”（微信ID：gcxxjgzh）注意到，去年6月，该违纪案件被湘潭县纪委查处。时任团县委书记万子萱，副书记陈泰宏、胡巧，青年服务中心主任黄怿，办公室主任周琼宇共5人受到处分。', '2016-11-29 20:01:00', '0');
INSERT INTO `news` VALUES ('11', '2', '广西北海公证处每天限号12个 民众通宵排队抢号', '央广网北海12月17日消息（记者许大为 广西台记者曾宇佳 蔡俊聪）据中国之声《新闻晚高峰》报道，从今年8月开始，广西北海市公证处实施限号办理业务，每天只发放12个号。几个月来，不少群众为了能尽快办理到业务，不得不通宵排队抢号。对此，北海市公证处相关负责人表示，由于工作人员紧缺，限号办理业务还将继续。', '2016-11-09 20:01:43', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0000000001', 'root', 'toor', '0', null);
INSERT INTO `user` VALUES ('0000000002', 'test', 'test', '5', null);
INSERT INTO `user` VALUES ('0000000003', 'exfly', 'exfly', '8', null);

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

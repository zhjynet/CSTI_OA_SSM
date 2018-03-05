/*
 Navicat Premium Data Transfer

 Source Server         : 本地mysql
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : db_cstioa

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 25/02/2018 18:12:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for csti_group
-- ----------------------------
DROP TABLE IF EXISTS `csti_group`;
CREATE TABLE `csti_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of csti_group
-- ----------------------------
BEGIN;
INSERT INTO `csti_group` VALUES (1, 'ACM', '2018-02-16 23:31:42', '2018-02-16 23:31:42');
INSERT INTO `csti_group` VALUES (2, 'ARM', '2018-02-16 23:31:42', '2018-02-16 23:31:42');
INSERT INTO `csti_group` VALUES (3, 'IGM', '2018-02-16 23:31:42', '2018-02-16 23:31:42');
INSERT INTO `csti_group` VALUES (4, 'NS', '2018-02-16 23:31:42', '2018-02-16 23:31:42');
INSERT INTO `csti_group` VALUES (5, 'UI', '2018-02-16 23:31:42', '2018-02-16 23:31:42');
INSERT INTO `csti_group` VALUES (6, 'WEB', '2018-02-16 23:31:42', '2018-02-16 23:31:42');
COMMIT;

-- ----------------------------
-- Table structure for csti_user
-- ----------------------------
DROP TABLE IF EXISTS `csti_user`;
CREATE TABLE `csti_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_number` varchar(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `image_path` longtext,
  `group_id` int(11) DEFAULT NULL,
  `is_signin_today` int(1) unsigned zerofill DEFAULT NULL,
  `small_group` int(1) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of csti_user
-- ----------------------------
BEGIN;
INSERT INTO `csti_user` VALUES (1, '20166671', '张靖宇', 'CZHjy0521', '../../image/user/1/HAzEVTYuQX.png', 6, 1, NULL, '2018-02-16 23:26:31', '2018-02-24 18:30:26');
INSERT INTO `csti_user` VALUES (2, '20155564', '冯搏奇', '20155564', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (3, '20155484', '闫滢钰', '20155484', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (4, '20166118', '郑心宁', '20166118', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (5, '20166102', '王博', '20166102', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (6, '20166664', '杨松', '20166664', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (7, '20166093', '卜瑶瑶', '20166093', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (8, '20166092', '张雪妍', '20166092', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (10, '20166672', '叶鹏飞', '20166672', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (11, '20165989', '宋佳俊', '20165989', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (12, '20166510', '赵蓉', '20166510', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (13, '20174453', '曾兆辉', '20174453', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 2, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (14, '20172745', '崔迪', '20172745', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 1, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (15, '20175347', '姬思琦', '20175347', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 2, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (16, '20172751', '金大川', '20172751', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 1, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (17, '20172826', '李赫楠', '20172826', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 0, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (18, '20172835', '孙霜铭', '20172835', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 0, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (19, '20172736', '张世博', '20172736', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 1, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (20, '20175975', '张夏越', '20175975', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 2, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (21, '20175862', '夏心茹', '20175862', '../../img/profile/picjumbo.com_HNCK4153_resize.jpg', 6, 0, 0, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
INSERT INTO `csti_user` VALUES (22, '20166666', '陈朝忆', '20166666', '../../image/user/22/Kxcdp8Y2r3.jpg', 2, 0, NULL, '2018-02-16 23:26:31', '2018-02-24 17:50:39');
COMMIT;

-- ----------------------------
-- Table structure for oa_config
-- ----------------------------
DROP TABLE IF EXISTS `oa_config`;
CREATE TABLE `oa_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `config_name` varchar(255) DEFAULT NULL,
  `config_value` longtext,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of oa_config
-- ----------------------------
BEGIN;
INSERT INTO `oa_config` VALUES (1, 'notice_switch', '0', '2018-02-16 23:40:12', '2018-02-21 12:30:53');
INSERT INTO `oa_config` VALUES (2, 'notice_content', '培训通知\r\n时间：上午9:00-12:00\r\n下午13:30-16:30\r\n晚上6:00之后直到封楼都在实验室自习\r\n地点在各组的实验室', '2018-02-16 23:40:12', '2018-02-18 09:47:20');
INSERT INTO `oa_config` VALUES (3, 'running_time', '23', '2018-02-16 23:40:12', '2018-02-23 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for oa_message
-- ----------------------------
DROP TABLE IF EXISTS `oa_message`;
CREATE TABLE `oa_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `message_time` timestamp NULL DEFAULT NULL,
  `message_ip` varchar(255) DEFAULT NULL,
  `message_ua` longtext,
  `message_info` longtext,
  `message_user_id` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of oa_message
-- ----------------------------
BEGIN;
INSERT INTO `oa_message` VALUES (1, '2018-02-04 02:20:45', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '测试', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (4, '2018-02-04 02:25:03', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '测试1', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (5, '2018-02-04 02:25:19', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2测试2', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (6, '2018-02-04 10:22:47', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '@Controller @RequestMapping(\"\") public class MessageController {     @Autowired     MessageService messageService;      @RequestMapping(\"send_message\")     public ModelAndView send_message(HttpSession session, HttpServletRequest request,String messageinfo){         ModelAndView mav = new ModelAndView();         Message message = new Message();         User user = (User)session.getAttribute(\"user\");         message.setMessageUserid(user.getId());         message.setMessageUa(request.getHeader(\"user-agent\"));         message.setMessageIp(GetIPUtils.getIpAddr(request));         message.setMessageTime(new Timestamp(System.currentTimeMillis()));         message.setMessageInfo(messageinfo);         messageService.add(message);         mav.setViewName(\"redirect:index\");         return mav;      } }', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (7, '2018-02-04 10:41:13', '192.168.2.190', 'Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; MI 6 Build/OPR1.170623.027) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.5.0', '真的假的', 10, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (8, '2018-02-04 10:41:52', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '目录 1 基础知识 ▪ 原理 ▪ 攻击 ▪ 防护 2 注入方法 ▪ 方法1 ▪ 方法2 ▪ 方法3 ▪ 小结 3 SQL注入技术 4 SQL注入防范 5 语句特征 基础知识 原理 SQL注入攻击指的是通过构建特殊的输入作为参数传入Web应用程序，而这些输入大都是SQL语法里的一些组合，通过执行SQL语句进而执行攻击者所要的操作，其主要原因是程序没有细致地过滤用户输入的数据，致使非法数据侵入系统。 根据相关技术原理，SQL注入可以分为平台层注入和代码层注入。前者由不安全的数据库配置或数据库平台的漏洞所致；后者主要是由于程序员对输入未进行细致地过滤，从而执行了非法的数据查询。基于此，SQL注入的产生原因通常表现在以下几方面：①不当的类型处理；②不安全的数据库配置；③不合理的查询集处理；④不当的错误处理；⑤转义字符处理不合适；⑥多个提交处理不当。 攻击 当应用程序使用输入内容来构造动态sql语句以访问数据库时，会发生sql注入攻击。如果代码使用存储过程，而这些存储过程作为包含未筛选的用户输入的字符串来传递，也会发生sql注入。sql注入可能导致攻击者使用应用程序登陆在数据库中执行命令。相关的SQL注入可以通过测试工具pangolin进行。如果应用程序使用特权过高的帐户连接到数据库，这种问题会变得很严重。在某些表单中，用户输入的内容直接用来构造动态sql命令，或者作为存储过程的输入参数，这些表单特别容易受到sql注入的攻击。而许多网站程序在编写时，没有对用户输入的合法性进行判断或者程序中本身的变量处理不当，使应用程序存在安全隐患。这样，用户就可以提交一段数据库查询的代码，根据程序返回的结果，获得一些敏感的信息或者控制整个服务器，于是sql注入就发生了。', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (9, '2018-02-13 19:40:51', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', '123123123', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (10, '2018-02-14 18:58:50', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', NULL, 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (11, '2018-02-14 19:00:16', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', '在空间对了师傅考虑到经费克里斯蒂尖峰时刻劳动纠纷上课', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (12, '2018-02-14 19:07:17', '192.168.2.190', 'Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; MI 6 Build/OPR1.170623.027) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.5.0', 'hxhxbbdbdbxxjxjxnxnsns', 10, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (13, '2018-02-14 19:09:15', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', '从V阿斯顿彻底消除执行程序存在', 1, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (14, '2018-02-14 19:13:20', '192.168.2.190', 'Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; MI 6 Build/OPR1.170623.027) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.5.0', 'dddddxxzq', 10, '2018-02-17 00:16:37', '2018-02-17 00:16:37');
INSERT INTO `oa_message` VALUES (15, '2018-02-17 12:47:05', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', '12312312312', 1, NULL, NULL);
INSERT INTO `oa_message` VALUES (16, '2018-02-19 19:04:14', '171.124.43.79', 'Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; MI 6 Build/OPR1.170623.027) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.5.0', 'bxbdjxxjxjxjxj', 10, NULL, NULL);
INSERT INTO `oa_message` VALUES (17, '2018-02-19 19:48:56', '171.124.43.79', 'Mozilla/5.0 (Linux; Android 8.0; MI 6 Build/OPR1.170623.027; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/043808 Mobile Safari/537.36 V1_AND_SQ_7.5.0_794_YYB_D QQ/7.5.0.3430 NetType/WIFI WebP/0.3.0 Pixel/1080', 'bddbdnddn', 22, NULL, NULL);
INSERT INTO `oa_message` VALUES (18, '2018-02-19 20:03:06', '171.124.43.79', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', '测试测试jksdlfjlksj', 1, NULL, NULL);
INSERT INTO `oa_message` VALUES (19, '2018-02-19 20:04:47', '171.124.43.79', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', '需现场V兴冲冲', 1, NULL, NULL);
INSERT INTO `oa_message` VALUES (20, '2018-02-19 20:06:29', '171.124.43.79', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', '0987654321', 1, '2018-02-19 20:06:29', '2018-02-19 20:06:29');
INSERT INTO `oa_message` VALUES (21, '2018-02-19 20:13:02', '117.136.56.162', 'Mozilla/5.0 (Linux; Android 5.1.1; OPPO R9 Plusm A Build/LMY47V; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/043906 Mobile Safari/537.36 V1_AND_SQ_7.5.0_794_YYB_D QQ/7.5.0.3430 NetType/4G WebP/0.3.0 Pixel/1080', '啦啦啦', 4, '2018-02-19 20:13:02', '2018-02-19 20:13:02');
INSERT INTO `oa_message` VALUES (22, '2018-02-19 20:19:02', '223.104.17.162', 'Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_1 like Mac OS X) AppleWebKit/604.4.7 (KHTML, like Gecko) Mobile/15C153 QQ/7.5.0.407 V1_IPH_SQ_7.5.0_1_APP_A Pixel/1080 Core/UIWebView Device/Apple(iPhone 6sPlus) NetType/4G QBWebViewType/1', '哈哈', 5, '2018-02-19 20:19:02', '2018-02-19 20:19:02');
INSERT INTO `oa_message` VALUES (23, '2018-02-19 20:21:42', '117.136.56.162', 'Mozilla/5.0 (Linux; Android 5.1.1; OPPO R9 Plusm A Build/LMY47V; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/043906 Mobile Safari/537.36 V1_AND_SQ_7.5.0_794_YYB_D QQ/7.5.0.3430 NetType/4G WebP/0.3.0 Pixel/1080', '', 5, '2018-02-19 20:21:42', '2018-02-19 20:21:42');
INSERT INTO `oa_message` VALUES (24, '2018-02-19 20:23:32', '223.104.17.162', 'Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_1 like Mac OS X) AppleWebKit/604.4.7 (KHTML, like Gecko) Mobile/15C153 QQ/7.5.0.407 V1_IPH_SQ_7.5.0_1_APP_A Pixel/1080 Core/UIWebView Device/Apple(iPhone 6sPlus) NetType/4G QBWebViewType/1', '啦啦啦', 5, '2018-02-19 20:23:32', '2018-02-19 20:23:32');
COMMIT;

-- ----------------------------
-- Table structure for oa_signin
-- ----------------------------
DROP TABLE IF EXISTS `oa_signin`;
CREATE TABLE `oa_signin` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `signin_user_id` int(8) DEFAULT NULL,
  `signin_time` datetime DEFAULT NULL,
  `signin_ip` varchar(255) DEFAULT NULL,
  `signin_ua` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of oa_signin
-- ----------------------------
BEGIN;
INSERT INTO `oa_signin` VALUES (1, 1, '2017-11-30 21:21:54', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (2, 1, '2017-11-30 21:25:08', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (3, 1, '2017-12-01 10:06:39', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (4, 1, '2017-12-01 10:06:55', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (5, 1, '2017-12-01 10:06:56', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (6, 1, '2017-12-01 12:03:33', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (7, 1, '2017-12-01 12:04:09', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (8, 1, '2017-12-01 12:28:03', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (9, 1, '2017-12-01 12:54:24', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (10, 1, '2017-12-01 14:29:12', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (11, 1, '2017-12-01 14:29:40', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (12, 1, '2017-12-01 14:29:42', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (13, 1, '2017-12-01 14:29:48', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (14, 1, '2017-12-01 14:33:52', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (15, 1, '2017-12-02 12:12:42', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (16, 1, '2017-12-02 18:10:51', '192.168.123.162', 'Mozilla/5.0 (Linux; U; Android 7.1.1; en-us; MI 6 Build/NMF26X) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.146 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.3.8', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (17, 1, '2017-12-02 19:15:25', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (18, 1, '2017-12-03 02:28:50', '192.168.43.1', 'Mozilla/5.0 (Linux; U; Android 7.1.1; en-us; MI 6 Build/NMF26X) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.146 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.3.8', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (19, 1, '2017-12-04 19:56:19', '192.168.16.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (20, 1, '2017-12-18 14:19:24', '192.168.29.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3236.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (21, 10, '2018-01-05 16:08:07', '10.10.28.3', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3278.0 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (30, 1, '2018-02-02 01:10:17', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (31, 1, '2018-02-02 01:10:36', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (32, 1, '2018-02-02 01:10:38', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (33, 1, '2018-02-02 01:10:38', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (34, 1, '2018-02-02 01:10:41', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (35, 1, '2018-02-02 01:12:53', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (36, 1, '2018-02-02 01:18:40', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (37, 10, '2018-02-05 22:58:45', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3298.4 Safari/537.36', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (38, 22, '2018-02-05 23:17:24', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:58.0) Gecko/20100101 Firefox/58.0', '2018-02-17 00:19:44', '2018-02-17 00:19:44');
INSERT INTO `oa_signin` VALUES (39, 1, '2018-02-17 00:26:19', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', NULL, NULL);
INSERT INTO `oa_signin` VALUES (40, 1, '2018-02-17 00:29:51', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', NULL, NULL);
INSERT INTO `oa_signin` VALUES (41, 1, '2018-02-17 00:40:33', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', NULL, NULL);
INSERT INTO `oa_signin` VALUES (42, 22, '2018-02-17 00:44:26', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', NULL, NULL);
INSERT INTO `oa_signin` VALUES (43, 1, '2018-02-17 19:23:45', '192.168.2.125', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.19 Safari/537.36', NULL, NULL);
INSERT INTO `oa_signin` VALUES (44, 10, '2018-02-18 01:05:23', '192.168.2.190', 'Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; MI 6 Build/OPR1.170623.027) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/61.0.3163.128 Mobile Safari/537.36 XiaoMi/MiuiBrowser/9.5.0', '2018-02-18 01:05:23', '2018-02-18 01:05:23');
INSERT INTO `oa_signin` VALUES (45, 1, '2018-02-22 23:42:27', '192.168.2.207', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.167 Safari/537.36', '2018-02-22 23:42:27', '2018-02-22 23:42:27');
INSERT INTO `oa_signin` VALUES (46, 1, '2018-02-24 18:30:26', '192.168.2.207', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36', '2018-02-24 18:30:26', '2018-02-24 18:30:26');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

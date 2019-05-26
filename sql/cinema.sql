-- MySQL dump 10.13  Distrib 5.7.18
--
-- Host: 47.101.183.63    Database: auror
-- ------------------------------------------------------
-- Server version	5.7.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
# /*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `tbl_movie`
--
DROP TABLE IF EXISTS `tbl_movie`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_movie`
(
    `id`            int(11)   NOT NULL AUTO_INCREMENT,
    `poster_url`    varchar(255)   DEFAULT NULL,
    `director`      varchar(255)   DEFAULT NULL,
    `screen_writer` varchar(255)   DEFAULT NULL,
    `starring`      varchar(255)   DEFAULT NULL,
    `type`          varchar(255)   DEFAULT NULL,
    `country`       varchar(255)   DEFAULT NULL,
    `language`      varchar(255)   DEFAULT NULL,
    `length`        int(11)        DEFAULT NULL,
    `start_date`    timestamp NULL DEFAULT NULL,
    `name`          varchar(255)   DEFAULT NULL,
    `description`   text,
    `status`        int(11)        DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `tbl_movie`
--
LOCK TABLES `tbl_movie` WRITE;
/*!40000 ALTER TABLE `tbl_movie`
    DISABLE KEYS */;
INSERT INTO `tbl_movie`
VALUES (10, 'http://n.sinaimg.cn/translate/640/w600h840/20190312/ampL-hufnxfm4278816.jpg', '大森贵弘 /伊藤秀樹', '',
        '神谷浩史 /井上和彦 /高良健吾 /小林沙苗 /泽城美雪', '动画', NULL, NULL, NULL, NULL, '夏目友人帐',
        '在人与妖怪之间过着忙碌日子的夏目，偶然与以前的同学结城重逢，由此回忆起了被妖怪缠身的苦涩记忆。此时，夏目认识了在归还名字的妖怪记忆中出现的女性·津村容莉枝。和玲子相识的她，现在和独子椋雄一同过着平稳的生活。夏目通过与他们的交流，心境也变得平和。但这对母子居住的城镇，却似乎潜伏着神秘的妖怪。在调查此事归来后，寄生于猫咪老师身体的“妖之种”，在藤原家的庭院中，一夜之间就长成树结出果实。而吃掉了与自己形状相似果实的猫咪老师，竟然分裂成了3个',
        0),
       (11, '', '安娜·波顿', NULL, '布利·拉尔森', '动作/冒险/科幻', NULL, NULL, NULL, NULL, '惊奇队长',
        '漫画中的初代惊奇女士曾经是一名美国空军均情报局探员，暗恋惊奇先生。。。', 0),
       (12, '', '1', NULL, '1', '1', NULL, NULL, NULL, NULL, '1', '1', 0),
       (13, '2', '2', NULL, '2', '2', NULL, NULL, NULL, NULL, '2', '2', 0),
       (14, '', '2', NULL, '2', '2', NULL, NULL, NULL, NULL, '2', '2', 0),
       (15, '', 'a', NULL, 'a', 'a', NULL, NULL, NULL, NULL, 'a', 'a', 0),
       (16, 'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549523952.webp', '林孝谦', 'abcˆ', '陈意涵', '爱情',
        '大陆', NULL, 123, '2019-03-22 11:00:00', '比悲伤更悲伤的故事',
        '唱片制作人张哲凯(刘以豪)和王牌作词人宋媛媛(陈意涵)相依为命，两人自幼身世坎坷只有彼此为伴，他们是亲人、是朋友，也彷佛是命中注定的另一半。父亲罹患遗传重症而被母亲抛弃的哲凯，深怕自己随时会发病不久人世，始终没有跨出友谊的界线对媛媛展露爱意。眼见哲凯的病情加重，他暗自决定用剩余的生命完成他们之间的终曲，再为媛媛找个可以托付一生的好男人。这时，事业有 成温柔体贴的医生(张书豪)适时的出现让他成为照顾媛媛的最佳人选，二人按部就班发展着关系。一切看似都在哲凯的计划下进行。然而，故事远比这里所写更要悲伤......',
        NULL);
/*!40000 ALTER TABLE `tbl_movie`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `tbl_favorite_record`
--
DROP TABLE IF EXISTS `tbl_favorite_record`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_favorite_record`
(
    `movie_id`    int(11)   NOT NULL,
    `user_id`     int(11)   NOT NULL,
    `choose_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`movie_id`, `user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `tbl_favorite_record`
--
LOCK TABLES `tbl_favorite_record` WRITE;
/*!40000 ALTER TABLE `tbl_favorite_record`
    DISABLE KEYS */;
INSERT INTO `tbl_favorite_record`
VALUES (10, 2, '2019-03-23 09:57:13'),
       (11, 1, '2019-03-22 09:38:12'),
       (11, 2, '2019-03-23 09:38:12'),
       (11, 3, '2019-03-22 08:38:12'),
       (12, 1, '2019-03-23 09:48:46'),
       (14, 1, '2019-03-23 09:38:12'),
       (16, 2, '2019-03-23 15:27:48');
/*!40000 ALTER TABLE `tbl_favorite_record`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `tbl_role`
--
DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role`
(
    `id`   int(11)     NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `tbl_role_id_uindex` (`id`),
    UNIQUE KEY `tbl_role_name_uindex` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `tbl_role`
--
LOCK TABLES `tbl_role` WRITE;
/*!40000 ALTER TABLE `tbl_role`
    DISABLE KEYS */;
INSERT INTO `tbl_role`
VALUES (1, 'customer'),
       (2, 'movie_manager'),
       (3, 'administrator');
/*!40000 ALTER TABLE `tbl_role`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `tbl_permission`
--
DROP TABLE IF EXISTS `tbl_permission`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_permission`
(
    `id`   int(11)     NOT NULL AUTO_INCREMENT,
    `name` varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `tbl_permission_id_uindex` (`id`),
    UNIQUE KEY `tbl_permission_name_uindex` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `tbl_permission`
--
LOCK TABLES `tbl_permission` WRITE;
/*!40000 ALTER TABLE `tbl_permission`
    DISABLE KEYS */;
INSERT INTO `tbl_permission`
VALUES (1, 'normal'),
       (2, 'movie_manage'),
       (3, 'role_manage');
/*!40000 ALTER TABLE `tbl_permission`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `tbl_user`
--
DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user`
(
    `id`                       int(11)      NOT NULL AUTO_INCREMENT,
    `username`                 varchar(50)  NOT NULL,
    `password`                 varchar(255) NOT NULL,
    `last_logout_time`         timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
    `last_password_reset_time` timestamp    NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    UNIQUE KEY `tbl_user_id_uindex` (`id`),
    UNIQUE KEY `tbl_user_username_uindex` (`username`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `user`
--
LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user`
    DISABLE KEYS */;
INSERT INTO `tbl_user`
VALUES (1, 'testname', '123456', '2019-04-06 20:30:00', '2019-04-06 20:30:00'),
       (2, 'test', '123456', '2019-04-06 20:30:00', '2019-04-06 20:30:00'),
       (3, 'root', '123456', '2019-04-06 20:30:00', '2019-04-06 20:30:00'),
       (4, 'admin', '123456', '2019-04-06 20:30:00', '2019-04-06 20:30:00');
/*!40000 ALTER TABLE `tbl_user`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `user_role`
--
DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role`
(
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    foreign key (user_id) references tbl_user (id),
    foreign key (role_id) references tbl_role (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `user_role`
--
LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role`
    DISABLE KEYS */;
INSERT INTO `user_role`
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (3, 2),
       (4, 1),
       (4, 2),
       (4, 3);
/*!40000 ALTER TABLE `user_role`
    ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `role_permission`
--
DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission`
(
    `role_id`       int(11) NOT NULL,
    `permission_id` int(11) NOT NULL,
    PRIMARY KEY (`role_id`, `permission_id`),
    foreign key (role_id) references tbl_role (id),
    foreign key (permission_id) references tbl_permission (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `user_role`
--
LOCK TABLES `role_permission` WRITE;
/*!40000 ALTER TABLE `role_permission`
    DISABLE KEYS */;
INSERT INTO `role_permission`
VALUES (1, 1),
       (2, 2),
       (3, 3);
/*!40000 ALTER TABLE `role_permission`
    ENABLE KEYS */;
UNLOCK TABLES;

/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2019-03-24 22:02:05


DROP TABLE IF EXISTS `tbl_scene`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_scene`
(
    `id`            int(11)        NOT NULL AUTO_INCREMENT,
    `movie_id`      int(11)        NOT NULL,
    `hall_id`       int(11)        NOT NULL,
    `start_time`    timestamp      NOT NULL,
    `end_time`      timestamp      NOT NULL,
    `show_time`     DATE           NOT NULL,
    `seats`         text           NOT NULL,
    `movie_version` varchar(30)    NOT NULL,
    `price`         decimal(10, 2) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_coupon`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_coupon`
(
    `id`          int(11)        NOT NULL AUTO_INCREMENT,
    `user_id`     int(11)        NOT NULL,
    `event_id`    int(11)        NOT NULL,
    `name`        varchar(255)   NOT NULL,
    `description` text,
    `picture_url` varchar(255)   NOT NULL,
    `start_time`  timestamp      NOT NULL,
    `end_time`    timestamp      NOT NULL,
    `expiration`  int(11)        NOT NULL,
    `threshold`   decimal(20, 2) NOT NULL,
    `discount`    decimal(20, 2) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_event`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_event`
(
    `id`                 int(11)        NOT NULL AUTO_INCREMENT,
    `name`               varchar(255)   NOT NULL,
    `description`        text,
    `picture_url`        varchar(255)   NOT NULL,
    `start_time`         timestamp      NOT NULL,
    `end_time`           timestamp      NOT NULL,
    `expiration`         int(11)        NOT NULL,
    `credit`             decimal(20, 2) NOT NULL,
    `all_movie_included` tinyint        NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_hall`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_hall`
(
    `id`    int(11)      NOT NULL AUTO_INCREMENT,
    `name`  varchar(255) NOT NULL,
    `seats` text         NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_member`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_member`
(
    `id`             int(11)        NOT NULL AUTO_INCREMENT,
    `user_id`        int(11)        NOT NULL,
    `member_card_id` int(11)        NOT NULL,
    `picture_url`    varchar(255)   NOT NULL,
    `credit`         decimal(20, 2) NOT NULL,
    `discount_rate`  decimal(10, 2) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_member_card`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_member_card`
(
    `id`                 int(11)        NOT NULL AUTO_INCREMENT,
    `name`               varchar(255)   NOT NULL,
    `picture_url`        varchar(255)   NOT NULL,
    `purchase_threshold` decimal(20, 2) NOT NULL,
    `discount_rate`      decimal(10, 2) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_refund_strategy`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_refund_strategy`
(
    `id`                      int(11)        NOT NULL AUTO_INCREMENT,
    `min_distance_to_playing` int(11)        NOT NULL,
    `refund_rate`             decimal(10, 2) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_ticket_order`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_ticket_order`
(
    `id`          int(11)        NOT NULL AUTO_INCREMENT,
    `user_id`     int(11)        NOT NULL,
    `scene_id`    int(11)        NOT NULL,
    `init_time`   timestamp DEFAULT CURRENT_TIMESTAMP,
    `ticket_num`  tinyint        NOT NULL,
    `seats`       varchar(255)   NOT NULL,
    `cost`        decimal(10, 2) NOT NULL,
    `status`      tinyint        NOT NULL,
    `ticket_code` varchar(255)   NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_member_order`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_member_order`
(
    `id`        int(11)        NOT NULL AUTO_INCREMENT,
    `user_id`   int(11)        NOT NULL,
    `member_id` int(11)        NOT NULL,
    `init_time` timestamp DEFAULT CURRENT_TIMESTAMP,
    `cost`      decimal(10, 2) NOT NULL,
    `status`    tinyint        NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_message`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_message`
(
    `id`                  int(11)      NOT NULL AUTO_INCREMENT,
    `user_id`             int(11)      NOT NULL,
    `type`                tinyint      NOT NULL,
    `title`               varchar(255) NOT NULL,
    `content`             text         NOT NULL,
    `init_time`           timestamp DEFAULT CURRENT_TIMESTAMP,
    `status`              tinyint      NOT NULL,
    `additional_movie_id` int(11)      NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `tbl_comment`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_comment`
(
    `id`        int(11)        NOT NULL AUTO_INCREMENT,
    `user_id`   int(11)        NOT NULL,
    `movie_id`  int(11)        NOT NULL,
    `score`     decimal(10, 2) NOT NULL,
    `init_time` timestamp DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

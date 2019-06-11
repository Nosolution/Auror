-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            Movie表，负责存储Movie相关但不包含演员，导演，数据内容
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_movie`
(
	`id` 					bigint not null auto_increment comment'电影Id',
    `movie_name`			varchar(50) comment '电影名称',
    `description`			varchar(255) comment '电影简介',
    `visible_date`		date comment '用户可见时间',
    `start_date`			date comment '上映起始时间',
    `end_date`			date comment '上映结束时间',
    `movie_type`			varchar(100) comment '电影类型',
    `movie_country`		varchar(50) comment '国家',
    `movie_language`		varchar(50) comment '语言',
    `poster_url`			varchar(255) comment '海报',
    `length`				Integer comment '时长',
    `movie_year`			varchar(255),
    `movie_status`			int,
    primary key (id)
);
alter table tbl_movie comment '电影表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            电影演职关系表，负责构建并指定职责
-- =============================================================================================================
--            2010-06-01        ：           修改cast_role,字符串.......
-- =============================================================================================================

create table `tbl_cast_movie`
(
	`id` 		bigint not null auto_increment comment'影职关系Id',
    `movie_id`	bigint comment '电影Id',
    `cast_id`	bigint comment '演职人员Id',
    `cast_role`	varchar(255) comment '演职人员职责',
    primary key(id)
);
alter table tbl_cast_movie comment '电影演职关系表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            演职人员
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_cast`
(
	`id` 			bigint not null auto_increment comment'演职Id',
    `cast_name`		varchar(50) comment '演职人员姓名',
    `poster_url`	varchar(255) comment '演职人员图片地址',
    primary key(id)
);
alter table tbl_cast_movie comment '电影演职关系表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            电影偏好关系表
-- =============================================================================================================
--            2010-06-11        ：           增加insert_time
-- =============================================================================================================

create table `tbl_movie_favor`
(
    `movie_id`		bigint comment '电影id',
    `user_id`		bigint comment '用户id',
    `insert_time`	date comment '插入时间'
);
alter table tbl_movie_favor comment '电影偏好关系表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            电影评论关系表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_movie_comment`
(
	`id`			bigint not null auto_increment comment'评论Id',
    `movie_id`		bigint comment '电影id',
    `user_id`		bigint comment '用户id',
    `score`			int comment '评分',
    `comment`		varchar(255) comment'电影评论',
    `time`			timestamp,
    primary key(id)
);
alter table tbl_movie_comment comment '电影评论关系表';

    
    
-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            HGZ
--            Create Date       :            2019-06-01
--            Description       :            职责表
-- =============================================================================================================
--            2010-06-03        ：             
--            2010-06-01        ：           
-- =============================================================================================================

DROP TABLE IF EXISTS `tbl_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_role`
(
    `id`   	bigint   NOT NULL AUTO_INCREMENT,
    `castName` varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `tbl_role_id_uindex` (`id`),
    UNIQUE KEY `tbl_role_name_uindex` (`castName`)
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
-- -- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            HGZ
--            Create Date       :            2019-06-01
--            Description       :            权限表
-- =============================================================================================================
--            2010-06-01        ：           
-- =============================================================================================================

--
DROP TABLE IF EXISTS `tbl_permission`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_permission`
(
    `id`   bigint    NOT NULL AUTO_INCREMENT,
    `castName` varchar(50) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `tbl_permission_id_uindex` (`id`),
    UNIQUE KEY `tbl_permission_name_uindex` (`castName`)
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
-- 


-- -- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            HGZ
--            Create Date       :            2019-06-01
--            Description       :            用户表
-- =============================================================================================================
--            2010-06-01        ：           
-- =============================================================================================================

--
DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user`
(
    `id`                       bigint      NOT NULL AUTO_INCREMENT,
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
-- -- -- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            HGZ
--            Create Date       :            2019-06-01
--            Description       :            用户职责表
-- =============================================================================================================
--            2010-06-01        ：           
-- =============================================================================================================

--
DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role`
(
    `user_id` bigint NOT NULL,
    `role_id` bigint NOT NULL,
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
-- -- -- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            HGZ
--            Create Date       :            2019-06-01
--            Description       :            职责权限表
-- =============================================================================================================
--            2010-06-01        ：           
-- =============================================================================================================

--
DROP TABLE IF EXISTS `role_permission`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission`
(
    `role_id`       bigint NOT NULL,
    `permission_id` bigint NOT NULL,
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



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            影厅表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_hall`
(
	`id`				bigint not null auto_increment comment'影厅id',
    `hall_seats`		varchar(255) comment '座位数组',
    `hall_name`			varchar(50) comment '影厅名',  
    primary key(id)
);
alter table tbl_hall comment '影厅表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            排片表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_scene`
(
	`id`				bigint not null auto_increment comment'排片id',
    `movie_id`			bigint comment '电影Id',
    `start`				timestamp comment '起始时间',
	`end`				timestamp comment '终止时间',
	`hall_id`			bigint comment '影厅Id',
    `price`				Integer comment '票价',
    `date`				date comment '日期',
    primary key(id)
);
alter table tbl_scene comment '排片表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            订单表
-- =============================================================================================================
--            2010-06-08        ：           增加movieId
-- =============================================================================================================

create table `tbl_order`
(
	`id`				bigint not null auto_increment comment'订单Id',
    `scene_id`			bigint comment '场次Id',
    `status`			Integer comment '订单状态',
    `cost`				Integer comment '金额',
    `code`				varchar(50) comment '取票码',
    `create_time`		timestamp comment '创立时间',
	`user_id`			bigint comment '用户id',
    `pay_method`		Integer comment '支付方式',
    `movie_id`			bigint comment '电影Id',
    primary key(id)
);
alter table tbl_order comment '订单表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            电影票表
-- =============================================================================================================
--            2010-06-08        ：           增加orderId
-- =============================================================================================================

create table `tbl_ticket`
(
	`id`				bigint not null auto_increment comment'票Id',
    `row`				Integer comment '排',
    `column`				Integer comment '列',
    `scene_id`				bigint,
    `order_id`				bigint,
    primary key(id)
);
alter table tbl_ticket comment '电影票表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            优惠券表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_coupon`
(
	`id`				bigint not null auto_increment comment'优惠券Id',
    `coupon_name`		varchar(50) comment '优惠券名',
    `description`		varchar(255) comment '优惠券描述',
	`discount`			float(3) comment '折扣',
    `threshold`			Integer comment '门栏',
    `url`				varchar(255) comment'图片',
    primary key(id)
);
alter table tbl_coupon comment '优惠券表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            用户优惠券关系表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_user_coupon`
(
	`id`				bigint not null auto_increment comment'用户优惠券关系Id',
    `coupon_id`			bigint comment '优惠券Id',
    `user_id`			bigint comment '用户Id',
	`start`				date comment '起始日期',
    `end`				date comment '终止日期',
    status				Integer comment '使用状态',
    primary key(id)
);
alter table tbl_user_coupon comment '用户优惠券关系表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            会员卡表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_member`
(
	`id`				bigint not null auto_increment comment'会员卡表Id',
    `strategy_id`		bigint comment '会员策略等级',
    `threshold`			Integer comment '余额',
    `user_id`			bigint comment'用户Id',
    primary key(id)
);
alter table tbl_member comment '会员卡表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            会员策略
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_member_strategy`
(
	`id`				bigint not null auto_increment comment'会员策略Id',
    `castName`				varchar(50) comment '会员名???',
	`url`				varchar(255) comment '会员图片',
    `threshold`			Integer comment '余额',
    `rate`				float(3) comment '折扣',
    primary key(id)
);
alter table tbl_member_strategy comment '会员策略表';




-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            退票策略
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_refund`
(
	`description`		varchar(255) comment '描述',
    `rate`				float(3) comment '折扣',
    `before_time`		int comment '距开场时间'
);
alter table tbl_refund comment '退票策略';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            充值记录
-- =============================================================================================================
--            2010-06-08        ：           增加type，用于区别是购买还是充值
-- =============================================================================================================

create table `tbl_recharge`
(
    `id`           bigint not null auto_increment comment '充值记录',
    `user_id`      bigint comment '用户id',
    `comment_time` timestamp comment '充值时间',
    `cost`         Integer comment '充值金额',
    `type`         Integer,
    primary key(id)
);
alter table tbl_recharge comment '充值记录表';

-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-06
--            Description       :            优惠活动
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================
create table `tbl_event`
(
	`id`				bigint not null auto_increment comment'充值记录',
    `startTime`			timestamp comment '起始时间',
    `endTime`			timestamp comment '结束时间',
    `description`		varchar(255) comment'描述',
    `coupon_id`			bigint comment'优惠券id',
    `event_name`		varchar(255),
    primary key(id)
);
alter table tbl_event comment '优惠活动';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-06
--            Description       :            电影优惠
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_event_movie`
(
	`event_id`		bigint not null,
    `movie_id`		bigint not null
);



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-08
--            Description       :            消息表
-- =============================================================================================================
--            2010-06-01        ：           修改cast_role,字符串.......
-- =============================================================================================================

create table `tbl_message`
(
	`id`		bigint not null auto_increment,
    `message_type`	Integer,
    `message_title`	varchar(50),
    `message_content`	varchar(255),
    `init_time`		timestamp,
    `message_status`	Integer,
	`movie_id`		bigint,
	`use_id`		bigint,
	primary key(id) 
);

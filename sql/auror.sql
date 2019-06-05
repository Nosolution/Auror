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
    primary key (id)
);
alter table tbl_movie comment '电影表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            电影演职关系表，负责构建并指定职责
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_cast_movie`
(
	`id` 		bigint not null auto_increment comment'影职关系Id',
    `movie_id`	bigint comment '电影Id',
    `cast_id`	bigint comment '演职人员Id',
    `cast_role`	bigint comment '演职人员职责',
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
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_movie_favor`
(
    `movie_id`		bigint comment '电影id',
    `user_id`		bigint comment '用户id'
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
    `score`			float(3) comment '评分',
    `comment`		varchar(255) comment'电影评论',
    primary key(id)
);
alter table tbl_movie_comment comment '电影评论关系表';

    
    
-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            用户表
-- =============================================================================================================
--            2010-06-03        ：           增加last_logout_time  timestamp
--            2010-06-01        ：           增加last_password_reset_time
-- =============================================================================================================

create table `tbl_user`
(
	`id`				bigint not null auto_increment comment'用户Id',
    `user_hostname`		varchar(255) comment '用户名',
    `user_password`		varchar(255) comment '用户密码',
    `user_role`			varchar(50) comment '用户职责',
    `last_logout_time`	timestamp comment '登出时间',
    `last_password_reset_time` timestamp comment '密码修改时间',
    primary key(id)
);
alter table tbl_user comment '用户表';    



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
    primary key(id)
);
alter table tbl_scene comment '排片表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            订单表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
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
    primary key(id)
);
alter table tbl_order comment '订单表';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            电影票表
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_ticket`
(
	`id`				bigint not null auto_increment comment'票Id',
    `row`				Integer comment '排',
    `column`				Integer comment '列',
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
    `befor_time`		timestamp comment '距开场时间'
);
alter table tbl_refund comment '退票策略';



-- =============================================================================================================
--            Function        	:            ...
--            Auhtor            :            JYH
--            Create Date       :            2019-06-01
--            Description       :            充值记录
-- =============================================================================================================
--            2010-06-01        ：           修改....增加.......
-- =============================================================================================================

create table `tbl_recharge`
(
	`id`				bigint not null auto_increment comment'充值记录',
    `user_id`			bigint comment '用户id',
    `commenttime`				timestamp comment '充值时间',
	`cost`				Integer comment '充值金额',
    primary key(id)
);
alter table tbl_recharge comment '充值记录表';
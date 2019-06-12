##模板
# insert into tbl_cast (id, cast_name, poster_url) VALUES (1, '','');


-- ==========================================================================================================================
##X战警黑凤凰
insert into tbl_movie(id, movie_name, description, visible_date, start_date, end_date, movie_type, movie_country,
                      movie_language, poster_url, length, movie_year, movie_status)
VALUES (101, 'X战警：黑凤凰 Dark Phoenix',
        '影片剧情围绕X战警中最受欢迎成员之一的琴·葛蕾展开，讲述她逐渐转化为黑凤凰的故事。在一次危及生命的太空营救行动中，琴被神秘的宇宙力量击中，成为最强大的变种人。此后琴·葛蕾不仅要设法掌控日益增长、极不稳定的力量，更要与自己内心的恶魔抗争，她的失控让整个X战警大家庭分崩离析，也让整个星球陷入毁灭的威胁之中。《X战警：黑凤凰》是迄今为止气氛最紧张、情感最丰富的一部《X战警》电影，是《X战警》系列20年来的集大成之作，大家非常熟悉和热爱的变种人大家庭即将面对最为强大的敌人——而她恰恰还是他们中的一员。',
        '2019-06-03', '2019-06-06', '2019-07-15', '动作 / 科幻 / 冒险', '美国', '英语',
        'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2555886490.jpg',
        114, 2019, 2);

insert into tbl_cast (id, cast_name, poster_url)
VALUES (1, '西蒙·金伯格 Simon Kinberg',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525519509.24.jpg'),
       (2, '迈克尔·法斯宾德 Michael Fassbender',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32214.jpg'),
       (3, '詹姆斯·麦卡沃伊 James McAvoy', 'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p93.jpg'),
       (4, '苏菲·特纳 Sophie Turner',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360321984.03.jpg'),
       (5, '尼古拉斯·霍尔特 Nicholas Hoult',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1371701601.6.jpg'),
       (6, '泰伊·谢里丹 Tye Sheridan',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.jpg');

insert into cast_movie (movie_id, cast_id, cast_role)
VALUES (101, 1, 'Director'),
       (101, 2, 'Actor'),
       (101, 3, 'Actor'),
       (101, 4, 'Actor'),
       (101, 5, 'Actor'),
       (101, 6, 'Actor');


-- ==========================================================================================================================

-- ==========================================================================================================================
##大侦探皮卡丘
insert into tbl_movie(id, movie_name, description, visible_date, start_date, end_date, movie_type, movie_country,
                      movie_language, poster_url, length, movie_year, movie_status)
VALUES (102, '大侦探皮卡丘 Pokémon Detective Pikachu',
        '好莱坞真人电影《大侦探皮卡丘》（暂译）讲述了蒂姆·古德曼（贾 斯 提·史密斯饰） 为寻找下落不明的父亲来到莱姆市，意外与父亲的前宝可梦搭档大侦探皮卡丘相遇，并惊讶地发现自己是唯一能听懂皮卡丘说话的人类，他们决定组队踏上揭开真相的刺激冒险之路。探案过程中他们邂逅了各式各样 的宝可梦，并意外发现了一个足以毁灭整个宝可梦宇宙的惊天阴谋。该电影改编自任天堂3DS同名游戏，由罗伯·莱特曼导演，瑞安·雷诺兹为大侦探皮卡丘配音，贾斯提斯·史密斯、凯瑟琳·纽顿等主演。',
        '2019-05-08', '2019-05-10', '2019-07-01', '喜剧 / 动画 / 奇幻 / 冒险', '美国 / 日本', '英语 / 日语',
        'https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2555538168.jpg', 104, 2019, 2);

insert into tbl_cast (id, cast_name, poster_url)
VALUES (7, '罗伯·莱特曼 Rob Letterman',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1446386865.82.jpg'),
       (8, '瑞安·雷诺兹 Ryan Reynolds', 'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48608.jpg'),
       (9, '贾斯蒂斯·史密斯 Justice Smith',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1523860646.23.jpg'),
       (10, '凯瑟琳·纽顿 Kathryn Newton',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1430023168.56.jpg');

insert into cast_movie (movie_id, cast_id, cast_role)
VALUES (102, 7, 'Director'),
       (102, 8, 'Actor'),
       (102, 9, 'Actor'),
       (102, 10, 'Actor');

-- ==========================================================================================================================

-- ==========================================================================================================================
##阿拉丁
insert tbl_movie(id, movie_name, description, visible_date, start_date, end_date, movie_type, movie_country,
                 movie_language,
                 poster_url, length, movie_year, movie_status)
VALUES (103, '阿拉丁 Aladdin',
        '在充满异域风情的古代阿拉伯王国，善良的穷小子阿拉丁（莫纳·马苏德 饰）和勇敢的茉莉公主（娜奥米·斯科特 饰）浪漫邂逅，在可以满足主人三个愿望的神灯精灵（威尔·史密斯 饰）的帮助下，两人踏上了一次寻找真爱和自我的魔幻冒险。',
        '2019-05-20', '2019-05-24', '2019-07-01', '爱情 / 奇幻 / 冒险', '美国', '英语',
        'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2553992741.jpg', 128, 2019, 2);

insert into tbl_cast (id, cast_name, poster_url)
VALUES (11, '盖·里奇 Guy Ritchie', 'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p47189.jpg'),
       (12, '梅纳·玛索德 Mena Massoud',
        'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500145110.49.jpg'),
       (13, '娜奥米·斯科特 Naomi Scott',
        'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1558931683.7.jpg'),
       (14, '威尔·史密斯 Will Smith', 'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p41483.jpg');

insert into cast_movie (movie_id, cast_id, cast_role)
VALUES (103, 11, 'Director'),
       (103, 12, 'Actor'),
       (103, 13, 'Actor'),
       (103, 14, 'Actor');
-- ==========================================================================================================================

-- ==========================================================================================================================
## 无所不能
insert into tbl_movie(id, movie_name, description, visible_date, start_date, end_date, movie_type, movie_country,
                      movie_language, poster_url, length, movie_year, movie_status)
VALUES (104, '无所不能 Kaabil', '罗汉是个盲人，但他对生活积极向上的态度让他跟平常人没什么两样。经人介绍，他认识了独立自信的盲人女孩苏皮莉亚。本来不想结婚的苏皮莉亚在罗汉的带领下慢慢意识到了幸福是存在的，现实生活中两个负也可以得正。
　　本应该“从此幸福生活在一起”的他们却在人生中遇到了最大的考验，第一次感觉到了自己是软弱的。
　　两人到底遇到了什么事？罗汉会不会证明自己的爱是强大的？反正我看完后又一次相信了爱情。', '2019-06-03', '2019-06-05', '2019-07-18', '动作 / 悬疑 / 犯罪', '印度', '印度语',
        'https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2557589889.jpg', 133, 2019, 2);

insert into tbl_cast (id, cast_name, poster_url)
VALUES (15, '桑吉·古普塔 Sanjay Gupta',
        'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1431011756.78.jpg'),
       (16, '赫里尼克·罗斯汉 Hrithik Roshan',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1432029328.95.jpg'),
       (17, '亚米·高塔姆 Yami Gautam',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1391846193.64.jpg');

insert into cast_movie (movie_id, cast_id, cast_role)
VALUES (104, 15, 'Director'),
       (104, 16, 'Actor'),
       (104, 17, 'Actor');
-- ==========================================================================================================================

-- ==========================================================================================================================
##哆啦A梦
insert into tbl_movie(id, movie_name, description, visible_date, start_date, end_date, movie_type, movie_country,
                      movie_language, poster_url, length, movie_year, movie_status)
values (105, '哆啦A梦：大雄的月球探险记 映画ドラえもん のび太の月面探査記',
        '月球探测器在月亮上捕捉到了白影，大雄认为这道白影是月亮上的兔子，惹来了大家的耻笑，于是哆啦A 梦为了帮助大雄，利用道具“异说俱乐部徽章”，在月球背面制造了一个兔子王国。一天，神秘少年露卡转学而来，与大雄和伙伴们一同前往月亮上的月兔王国展开了一场别开生面的浪漫想象力之旅。',
        '2019-05-25',
        '2019-06-01',
        '2019-07-01',
        '剧情 / 动画',
        '日本',
        '日语',
        'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2557500825.jpg', 111, 2019, 2);

insert into tbl_cast (id, cast_name, poster_url)
VALUES (18, '八锹新之介 Shinnosuke Yakuwa',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1469190483.72.jpg'),
       (19, '水田山葵 Wasabi Mizuta',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1375424738.93.jpg'),
       (20, '大原惠美 Megumi Oohara',
        'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1358580306.49.jpg');

insert into cast_movie (movie_id, cast_id, cast_role)
VALUES (105, 18, 'Director'),
       (105, 19, 'Actor'),
       (105, 20, 'Actor');

-- ==========================================================================================================================

-- ==========================================================================================================================
## 最好的我们
insert into tbl_movie (id, movie_name, description, visible_date, start_date, end_date, movie_type, movie_country,
                       movie_language, poster_url, length, movie_year, movie_status)
VALUES (106, '最好的我们', '每个人的心里大概都藏着一个念念不忘的人。一个偶然被提及的名字，让女摄影师耿耿（何蓝逗 饰）内心掀起万千波澜，触动了回忆的开关，那个撩人心动的少年余淮（陈飞宇 饰）再度闯进她的思绪。
　　那是记忆里最好的时光，“学渣”耿耿和“学霸”余淮成了同桌，还结识了简单（王初伊 饰）、贝塔（周楚濋 饰）、徐延亮（陈帅 饰）。校园里充盈着专属少男少女们的懵懂、青涩、怦然心动和勇敢，耿耿余淮也拥有了他们的约定。高考后，当耿耿满怀期待憧憬约定兑现之时，余淮却忽然消失不见了。七年后两人重逢，余淮当年未说出口的那句话、他不辞而别的秘密，耿耿能否得到解答？这段耿耿于怀的过往，让两人再度面临情感的抉择……
　　本片根据八月长安同名小说作品改编。', '2019-06-03', '2019-06-06', '2019-06-30', '剧情 / 爱情', '中国', '汉语普通话',
        'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2557157554.jpg', 110, 2019, 2);

insert into tbl_cast (id, cast_name, poster_url)
VALUES (21, '章笛沙 Disha Zhang', 'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1559625802.98.jpg'),
       (22, '陈飞宇 Feiyu Chen',
        'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1500201702.37.jpg'),
       (23, '何蓝逗 Lan He',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1499156488.33.jpg'),
       (24, '惠英红 Kara Wai Ying Hung',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1352363438.56.jpg');

insert into cast_movie (movie_id, cast_id, cast_role)
VALUES (106, 21, 'Director'),
       (106, 22, 'Actor'),
       (106, 23, 'Actor'),
       (106, 24, 'Actor');
-- ==========================================================================================================================

-- ==========================================================================================================================
##哥斯拉2
insert into tbl_movie (id, movie_name, description, visible_date, start_date, end_date, movie_type, movie_country,
                       movie_language, poster_url, length, movie_year, movie_status)
values (107, '哥斯拉2：怪兽之王 Godzilla: King of the Monsters',
        '随着《哥斯拉》和《金刚：骷髅岛》在全球范围内取得成功，传奇影业和华纳兄弟影业联手开启了怪兽宇宙系列电影的新篇章—一部史诗级动作冒险巨制。在这部电影中，哥斯拉将和众多大家在流行文化中所熟知的怪兽展开较量。全新故事中，研究神秘动物学的机构“帝王组织”将勇敢直面巨型怪兽，其中强大的哥斯拉也将和魔斯拉、拉顿和它的死对头——三头王者基多拉展开激烈对抗。当这些只存在于传说里的超级生物再度崛起时，它们将展开王者争霸，人类的命运岌岌可危……',
        '2019-05-23', '2019-05-31', '2019-07-10', '动作 / 科幻 / 冒险 / 灾难', '美国', '英语',
        'https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2554370800.jpg', 132, 2019, 2);

insert into tbl_cast (id, cast_name, poster_url)
values (25, '迈克尔·道赫蒂 Michael Dougherty',
        'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34473.jpg'),
       (26, '凯尔·钱德勒 Kyle Chandler', 'https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p20877.jpg'),
       (27, '维拉·法米加 Vera Farmiga', 'https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p11871.jpg');

insert into cast_movie (movie_id, cast_id, cast_role)
VALUES (107, 25, 'Director'),
       (107, 26, 'Actor'),
       (107, 27, 'Actor');


-- ==========================================================================================================================

-- ==========================================================================================================================
insert into tbl_hall (id, hall_seats, hall_name)
VALUES (1,
        '1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;',
        '一号厅'),
       (1,
        '0,0,0,1,1,1,1,1,1,0,0,0;0,0,1,1,1,1,1,1,1,1,0,1;0,1,1,1,1,1,1,1,1,1,1,0;0,1,1,1,1,1,1,1,1,1,1,0;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;1,1,1,1,1,1,1,1,1,1,1,1;',
        '二号厅');

-- ==========================================================================================================================

-- ==========================================================================================================================
insert into tbl_scene(id, movie_id, start_time, end_time, hall_id, price, date)
VALUES (1, 101, '2019-06-08 10:00:00', '2019-06-08 11:54:00', 1, 50, '2019-06-08'),
       (2, 101, '2019-06-08 12:00:00', '2019-06-08 13:54:00', 2, 60, '2019-06-08'),
       (3, 101, '2019-06-08 13:30:00', '2019-06-08 15:24:00', 1, 55, '2019-06-08'),
       (4, 101, '2019-06-08 14:00:00', '2019-06-08 15:54:00', 2, 50, '2019-06-08'),
       (5, 101, '2019-06-08 16:00:00', '2019-06-08 17:54:00', 1, 44.99, '2019-06-08'),
       (6, 101, '2019-06-08 16:00:00', '2019-06-08 17:54:00', 2, 49.98, '2019-06-08'),
       (7, 101, '2019-06-08 23:00:00', '2019-06-09 01:44:00', 1, 50, '2019-06-08'),
       (8, 101, '2019-06-09 00:00:00', '2019-06-09 01:54:00', 2, 50, '2019-06-09'),


       (9, 102, '2019-05-30 10:00:00', '2019-05-30 11:44:00', 1, 40, '2019-05-30'),
       (10, 102, '2019-05-31 12:00:00', '2019-06-08 13:44:00', 1, 50, '2019-05-31'),
       (11, 102, '2019-06-08 18:00:00', '2019-06-08 18:44:00', 2, 60, '2019-06-08'),
       (12, 102, '2019-06-08 18:30:00', '2019-06-08 19:14:00', 1, 55, '2019-06-08'),
       (13, 102, '2019-06-08 20:00:00', '2019-06-08 21:44:00', 2, 50, '2019-06-08'),
       (14, 102, '2019-06-08 19:30:00', '2019-06-08 21:14:00', 1, 44.99, '2019-06-08');


-- ==========================================================================================================================
insert into tbl_movie_favor(movie_id, user_id, init_time)
VALUES (101, 1, '2019-06-07 10:00:00'),
       (102, 1, '2019-06-07 11:00:00'),
       (103, 1, '2019-06-07 12:00:00'),
       (101, 2, '2019-06-08 10:00:00'),
       (102, 5, '2019-06-01 10:00:00');
-- ==========================================================================================================================


-- ==========================================================================================================================
insert into tbl_coupon(id, coupon_name, description, benefit, threshold, url)
VALUES (1, '优惠券1', '折扣较小的优惠券', 15, 49, 'xxx'),
       (2, '优惠券2', '折扣较大的优惠券', 20, 49, 'xxx');

insert into tbl_event(id, event_name, start_time, end_time, description, coupon_id)
VALUES (1, '夏季大优惠', '2019-06-01', '2019-08-30', '这里是描述', 1),
       (2, '电影节', '2019-06-01', '2019-07-01', '这里也是描述', 2);

insert into user_coupon(id, coupon_id, user_id, start, end, status)
VALUES (1, 1, 1, '2019-06-04', '2019-06-11', 0),
       (2, 1, 1, '2019-06-04', '2019-06-11', 0),
       (3, 2, 1, '2019-06-04', '2019-06-11', 0),
       (4, 1, 1, '2019-06-04', '2019-06-11', 0),
       (5, 2, 5, '2019-06-04', '2019-06-11', 0);

insert into event_movie (event_id, movie_id)
values (1, 101),
       (1, 102),
       (2, 101),
       (2, 102),
       (2, 103);
-- ==========================================================================================================================


-- ==========================================================================================================================
insert into tbl_member_strategy(id, member_name, url, price, rate)
values (1, '小会员', 'xxx', 100, 0.8),
       (2, '大会员', 'xxx', 300, 0.7);

insert into tbl_member(id, strategy_id, credit, user_id)
VALUES (1, 2, 80, 1),
       (2, 1, 30, 2);
-- ==========================================================================================================================


-- ==========================================================================================================================
insert into tbl_order(id, scene_id, status, cost, code, create_time, user_id, pay_method, movie_id)
VALUES (1, 1, 1, 50, '6s3j0l', '2019-06-05 08:30:31', 1, 1, 101),
       (2, 1, 1, 50, '7sfkjb', '2019-06-06 13:24:51', 2, 1, 101),
       (3, 3, 1, 55, 'dsiu34', '2019-06-07 21:43:02', 5, 1, 101),
       (4, 12, 2, 55, 'sdg2vc', '2019-06-07 22:11:23', 1, 0, 102),
       (5, 13, 2, 50, 'skh3s7', '2019-06-07 19:68:23', 2, 0, 102);


-- ==========================================================================================================================

-- ==========================================================================================================================
insert into tbl_refund(description, rate, before_time)
values ('退票策略', 0.9, 3);



-- ==========================================================================================================================


-- ==========================================================================================================================
insert into event_movie (event_id, movie_id)
values (1, 101),
       (1, 102),
       (2, 101),
       (2, 102),
       (2, 103);


-- ==========================================================================================================================

-- ==========================================================================================================================
insert into tbl_recharge (id, user_id, init_time, cost, type)
values (1, 1, '2019-05-15 08:43:13', 200, 1);

insert into tbl_recharge (id, user_id, init_time, cost, type)
values (2, 1, '2019-05-20 09:13:23', 100, 1);

-- ==========================================================================================================================

-- ==========================================================================================================================
insert into tbl_movie_comment (id, movie_id, user_id, score, comment, time)
values (1, 101, 1, 8, '不知所云', '2019-06-08 21:14:30'),
       (2, 101, 2, 7, '点点点', '2019-06-08 22:30:42'),
       (3, 101, 5, 9, '特效爽就完事了', '2019-06-08 17:30:23');


-- ==========================================================================================================================


-- ==========================================================================================================================
insert into tbl_ticket (id, row, column, scene_id, order_id)
values (1, 3, 4, 2, 1);


-- ==========================================================================================================================


-- ==========================================================================================================================
insert into tbl_message (id, message_type, message_title, message_content, init_time, message_status, movie_id, user_id)
values (1, 5, '消息1', '这里是一条消息', '2019-06-03 16:28:31', 0, 0, 1),
       (2, 5, '消息2', '这里也是一条消息', '2019-06-04 14:23:44', 0, 0, 1),
       (3, 0, '获得优惠券', '因为您在我们影院的活跃活动，我们决定赠送您一张面值为20元的优惠券', '2019-06-01 22:12:2', 0, 0, 1),
       (4, 1, '您想看的电影已上映', '您想看的的电影:哥斯拉2已上映，欢迎购票', '2019-06-02 14:00:00', 0, 0, 1),
       (5, 3, '欢迎点评', 'X战警：黑凤凰观感如何，快来点评吧', '2019-06-08 21:00:00', 0, 101, 1),
       (6, 4, '新优惠活动已上线，欢迎参加', 'xxx', '2019-06-02 00:00:00', 0, 0, 1);


-- ==========================================================================================================================


DROP TABLE IF EXISTS t_en_recite_plan_info;

CREATE TABLE t_en_recite_plan_info (
    book_id   Integer(11) not null comment '关联书本',
    user_id   Integer(11) not null comment '用户ID',
    plan_word_num   Integer(11) not null comment '计划词汇数量',
    plan_phrase_num   Integer(11) not null comment '计划短语数量',
    total_word_num   Integer(11) not null comment '词汇总数量',
    total_phrase_num   Integer(11) not null comment '短语总数量',
    recited_word_num   Integer(11) not null comment '已背诵词汇数量',
    recited_phrase_num   Integer(11) not null comment '已背诵短语数量',
    repeat_times   Integer(11) not null comment '重复次数',
    clockin_times   Integer(11) not null comment '打卡次数,
    recite_status   varchar(8) not null comment '背诵状态：未开始/进行中/已结束,
    created_by   varchar(32) default null comment '创建用户',
    created_date   timestamp default current_timestamp comment '创建日期',
    updated_by   varchar(32) not null comment '更新用户',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '更新日期',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
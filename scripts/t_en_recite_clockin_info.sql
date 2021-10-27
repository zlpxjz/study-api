DROP TABLE IF EXISTS t_en_recite_clockin_info;

CREATE TABLE t_en_recite_clockin_info (
    user_id   Integer(11) not null comment '用户ID',
    book_id   Integer(11) not null comment '打卡书本',
    word_id   Integer(11) not null comment '打卡开始词汇ID',
    word_num   Integer(11) not null comment '打卡词汇数量',
    phrase_id   Integer(11) not null comment '打卡开始短语ID',
    phrase_num   Integer(11) not null comment '打卡短语数量',
    dictation_id   Integer(11) not null comment '打卡开始默写ID',
    dictation_num   Integer(11) not null comment '打卡默写数量',
    dictation_right_num   Integer(11) not null comment '打卡默写正确数量',
    dictation_wrong_num   Integer(11) not null comment '打卡默写错误数量',
    clockin_date   timestamp default current_timestamp comment '打卡日期',
    created_by   varchar(32) default null comment '创建用户',
    created_date   timestamp default current_timestamp comment '创建日期',
    updated_by   varchar(32) not null comment '更新用户',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '更新日期',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
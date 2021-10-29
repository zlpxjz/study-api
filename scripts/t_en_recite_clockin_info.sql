DROP TABLE IF EXISTS t_en_recite_clockin_info;

CREATE TABLE t_en_recite_clockin_info (
    user_id   varchar(32) not null comment '用户ID',
    plan_id   varchar(32) not null comment '学习ID',
    book_id   varchar(32) not null comment '打卡书本',
    first_word_id   varchar(32) not null comment '开始词汇ID',
    last_word_id   varchar(32) not null comment '结束词汇ID',
    word_num   Integer(11) not null comment '词汇数量',
    first_phrase_id   Integer(11) not null comment '开始短语ID',
    last_phrase_id   Integer(11) not null comment '结束短语ID',
    phrase_num   Integer(11) not null comment '短语数量',
    dictation_id   Integer(11) not null comment '开始默写ID',
    dictation_num   Integer(11) not null comment '默写数量',
    dictation_right_num   Integer(11) not null comment '打卡默写正确数量',
    dictation_wrong_num   Integer(11) not null comment '打卡默写错误数量',
    clockin_date   timestamp default current_timestamp comment '打卡日期',
    id    varchar(32) not null ,
    created_by   varchar(32) default null comment '创建用户',
    created_date   timestamp default current_timestamp comment '创建日期',
    updated_by   varchar(32) not null comment '更新用户',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '更新日期',
    is_deleted   char(1) default 'N' not null comment 'Y/N',
    PRIMARY KEY (,id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
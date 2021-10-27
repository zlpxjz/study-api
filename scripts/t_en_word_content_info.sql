DROP TABLE IF EXISTS t_en_word_content_info;

CREATE TABLE t_en_word_content_info (
    word_id   Integer(11) not null comment '单词',
    category   varchar(16) not null comment '大类。音标、释义、词组短语、同近义词、同根词、词语辨析、双语例句',
    sub_category   varchar(16) not null comment '类型:词汇/短语',
    content_1   varchar(512) not null comment '内容1',
    content_2   varchar(512) not null comment '内容2',
    content_3   varchar(512) not null comment '内容3',
    created_by   varchar(32) default null comment '创建用户',
    created_date   timestamp default current_timestamp comment '创建日期',
    updated_by   varchar(32) not null comment '更新用户',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '更新日期',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
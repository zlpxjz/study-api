DROP TABLE IF EXISTS t_note_info;

CREATE TABLE t_note_info (
    real_name   varchar(32) not null comment '主题',
    id    varchar(32) not null ,
    created_by   varchar(32) default null comment '创建用户',
    created_date   timestamp default current_timestamp comment '创建日期',
    updated_by   varchar(32) not null comment '更新用户',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '更新日期',
    is_deleted   char(1) default 'N' not null comment 'Y/N',
    PRIMARY KEY (,id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
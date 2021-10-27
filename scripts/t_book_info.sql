DROP TABLE IF EXISTS t_book_info;

CREATE TABLE t_book_info (
    parent_id   Integer(11) not null comment '关联书本',
    name   varchar(32) not null comment '书名',
    course_name   varchar(32) not null comment '课程名',
    created_by   varchar(32) default null comment '创建用户',
    created_date   timestamp default current_timestamp comment '创建日期',
    updated_by   varchar(32) not null comment '更新用户',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '更新日期',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
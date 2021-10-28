DROP TABLE IF EXISTS t_sys_user_profile_info;

CREATE TABLE t_sys_user_profile_info (
    real_name   varchar(32) not null comment '实名',
    phone   varchar(16) comment '电话号码',
    email   varchar(16) comment 'Email地址',
    user_id   Integer(11) not null comment '账户ID',
    created_by   varchar(32) default null comment '创建用户',
    created_date   timestamp default current_timestamp comment '创建日期',
    updated_by   varchar(32) not null comment '更新用户',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '更新日期',
    is_deleted   char(1) default 'N' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
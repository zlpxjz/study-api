DROP TABLE IF EXISTS t_sys_user_profile_info;

CREATE TABLE t_sys_user_profile_info (
    real_name   varchar(32) not null comment 'ʵ��',
    phone   varchar(16) comment '�绰����',
    email   varchar(16) comment 'Email��ַ',
    user_id   Integer(11) not null comment '�˻�ID',
    created_by   varchar(32) default null comment '�����û�',
    created_date   timestamp default current_timestamp comment '��������',
    updated_by   varchar(32) not null comment '�����û�',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '��������',
    is_deleted   char(1) default 'N' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
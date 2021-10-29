DROP TABLE IF EXISTS t_note_info;

CREATE TABLE t_note_info (
    real_name   varchar(32) not null comment '����',
    id    varchar(32) not null ,
    created_by   varchar(32) default null comment '�����û�',
    created_date   timestamp default current_timestamp comment '��������',
    updated_by   varchar(32) not null comment '�����û�',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '��������',
    is_deleted   char(1) default 'N' not null comment 'Y/N',
    PRIMARY KEY (,id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
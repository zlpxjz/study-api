DROP TABLE IF EXISTS t_en_word_info;

CREATE TABLE t_en_word_info (
    word   varchar(64) not null comment '�ʻ�',
    word_type   varchar(8) not null comment '����:�ʻ�/����',
    created_by   varchar(32) default null comment '�����û�',
    created_date   timestamp default current_timestamp comment '��������',
    updated_by   varchar(32) not null comment '�����û�',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '��������',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
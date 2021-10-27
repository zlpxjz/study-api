DROP TABLE IF EXISTS t_en_word_content_info;

CREATE TABLE t_en_word_content_info (
    word_id   Integer(11) not null comment '����',
    category   varchar(16) not null comment '���ࡣ���ꡢ���塢������ͬ����ʡ�ͬ���ʡ����������˫������',
    sub_category   varchar(16) not null comment '����:�ʻ�/����',
    content_1   varchar(512) not null comment '����1',
    content_2   varchar(512) not null comment '����2',
    content_3   varchar(512) not null comment '����3',
    created_by   varchar(32) default null comment '�����û�',
    created_date   timestamp default current_timestamp comment '��������',
    updated_by   varchar(32) not null comment '�����û�',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '��������',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
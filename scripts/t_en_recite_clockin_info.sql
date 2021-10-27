DROP TABLE IF EXISTS t_en_recite_clockin_info;

CREATE TABLE t_en_recite_clockin_info (
    user_id   Integer(11) not null comment '�û�ID',
    book_id   Integer(11) not null comment '���鱾',
    word_id   Integer(11) not null comment '�򿨿�ʼ�ʻ�ID',
    word_num   Integer(11) not null comment '�򿨴ʻ�����',
    phrase_id   Integer(11) not null comment '�򿨿�ʼ����ID',
    phrase_num   Integer(11) not null comment '�򿨶�������',
    dictation_id   Integer(11) not null comment '�򿨿�ʼĬдID',
    dictation_num   Integer(11) not null comment '��Ĭд����',
    dictation_right_num   Integer(11) not null comment '��Ĭд��ȷ����',
    dictation_wrong_num   Integer(11) not null comment '��Ĭд��������',
    clockin_date   timestamp default current_timestamp comment '������',
    created_by   varchar(32) default null comment '�����û�',
    created_date   timestamp default current_timestamp comment '��������',
    updated_by   varchar(32) not null comment '�����û�',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '��������',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
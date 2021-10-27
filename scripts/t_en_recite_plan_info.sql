DROP TABLE IF EXISTS t_en_recite_plan_info;

CREATE TABLE t_en_recite_plan_info (
    book_id   Integer(11) not null comment '�����鱾',
    user_id   Integer(11) not null comment '�û�ID',
    plan_word_num   Integer(11) not null comment '�ƻ��ʻ�����',
    plan_phrase_num   Integer(11) not null comment '�ƻ���������',
    total_word_num   Integer(11) not null comment '�ʻ�������',
    total_phrase_num   Integer(11) not null comment '����������',
    recited_word_num   Integer(11) not null comment '�ѱ��дʻ�����',
    recited_phrase_num   Integer(11) not null comment '�ѱ��ж�������',
    repeat_times   Integer(11) not null comment '�ظ�����',
    clockin_times   Integer(11) not null comment '�򿨴���,
    recite_status   varchar(8) not null comment '����״̬��δ��ʼ/������/�ѽ���,
    created_by   varchar(32) default null comment '�����û�',
    created_date   timestamp default current_timestamp comment '��������',
    updated_by   varchar(32) not null comment '�����û�',
    updated_date   timestamp default current_timestamp on update current_timestamp comment '��������',
    is_deleted   char(1) default 'n' not null comment 'Y/N',
    PRIMARY KEY ()
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
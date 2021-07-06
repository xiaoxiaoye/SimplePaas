create table if not exists sps.user
(
    id        int auto_increment comment 'userID'
        primary key,
    name      varchar(32)          null comment '姓名',
    phone     char(11)             null comment '手机号码',
    telephone varchar(16)          null comment '住宅电话',
    address   varchar(64)          null comment '联系地址',
    enabled   tinyint(1) default 1 null,
    username  varchar(255)         null comment '用户名',
    password  varchar(255)         null comment '密码',
    userface  varchar(255)         null,
    remark    varchar(255)         null
)
    charset = utf8;


create table sps.repository
(
    id       int auto_increment,
    name     varchar(255)      null comment '仓库名称',
    status   tinyint default 0 null comment '仓库状态 0-异常 1-正常',
    username varchar(255)      null comment '用户名称',
    host     varchar(15)       null comment '仓库IP地址',
    port     int               null comment '仓库端口',
    constraint repository_pk
        primary key (id)
)
    comment '镜像仓库';
DROP TABLE IF EXISTS `sys_im_customer_config`;
DROP TABLE IF EXISTS `sys_im_customer`;
DROP TABLE IF EXISTS `sys_im_customer_cnt`;

DROP TABLE IF EXISTS `send_message`;
DROP TABLE IF EXISTS `send_message_reciver`;

DROP TABLE IF EXISTS `tim_trtc_house`;
DROP TABLE IF EXISTS `tim_trtc_house_account`;

CREATE TABLE `sys_im_customer_config` (
  `id` bigint(20) NOT NULL,
  `group_id` varchar(64) NOT NULL COMMENT '分组id 1(系统客服id)或用户id',
  `type` varchar(10) NOT NULL COMMENT '类型 0:轮询 1:指定',
  `ser_max_count` int(10) unsigned zerofill DEFAULT NULL COMMENT '接待服务最大数量',
  `ret_contact` varchar(10) NOT NULL COMMENT '最近联系人优先 0:否 1:是',
  `dep_no_admin` varchar(10) NOT NULL COMMENT '管理员不参与自动分配 0:否 1:是',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客服管理配置表';

CREATE TABLE `sys_im_customer` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `group_id` varchar(64) NOT NULL COMMENT '分组id 1(系统客服id)或用户id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `is_admin` varchar(10) NOT NULL COMMENT '是否管理员 0:否 1:是',
  `status` varchar(1) NOT NULL COMMENT '状态(0:离线 1:在线)',
  `ser_count` int(10) unsigned zerofill NOT NULL COMMENT '当前服务数量',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客服管理表';

CREATE TABLE `sys_im_customer_cnt` (
  `group_id` varchar(64) NOT NULL COMMENT '分组id',
  `customer_id` bigint(20) NOT NULL COMMENT '客服id',
  `user_id` bigint(20) NOT NULL COMMENT '被接待的用户id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客服接待关系表';


CREATE TABLE `send_message` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `title` varchar(30) DEFAULT NULL COMMENT '发送标题',
  `summary` varchar(100) DEFAULT NULL COMMENT '发送摘要',
  `content` mediumtext DEFAULT NULL COMMENT '发送详细内容',
  `scope` varchar(1) DEFAULT NULL COMMENT '发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)',
  `message_type` varchar(5) DEFAULT NULL COMMENT '消息类型',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发送通知表';

CREATE TABLE `send_message_reciver` (
  `msg_id` bigint(20) NOT NULL COMMENT '消息ID',
  `memb_id` bigint(20) DEFAULT NULL COMMENT '会员ID',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知接收表';


CREATE TABLE `tim_trtc_house` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `house_num` int(9) DEFAULT NULL COMMENT '房间号',
  `on_use` varchar(1)  COMMENT '正在使用 0:否 1:是',
  `create_by` varchar(32)  COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32)  COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255)  COMMENT '备注',
  `del_flag` char(1)  COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实时音视频房间表';

CREATE TABLE `tim_trtc_house_account` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `house_id` bigint(20) NOT NULL COMMENT '房间id',
  `account_id` bigint(20) NOT NULL COMMENT '进入者ID',
  `create_by` varchar(32)  COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32)  COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255)  COMMENT '备注',
  `del_flag` char(1)  COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实时音视频房间成员表';
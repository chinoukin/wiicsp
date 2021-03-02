DROP TABLE IF EXISTS `sys_im_customer_config`;
DROP TABLE IF EXISTS `sys_im_customer`;
DROP TABLE IF EXISTS `sys_im_customer_cnt`;

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
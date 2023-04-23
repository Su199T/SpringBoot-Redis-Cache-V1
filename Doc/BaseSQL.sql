

DROP TABLE IF EXISTS `tb_base`;
CREATE TABLE `tb_base` (
  `video_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `user_id` int(11) NOT NULL,
  `video_index` int(11) NOT NULL COMMENT '视频类型index',
  `value` double(255,0) NOT NULL COMMENT '通用值',
  `count` int(11) NOT NULL COMMENT '当天看视频次数',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态 0未完成 1已完成并领取奖励',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`video_id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8mb4 COMMENT='用户';



drop table if exists tb_base ;
create table tb_base(


)
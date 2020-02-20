USE biubiubiu;
CREATE TABLE `user` (
  `uid` INT(32) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL ,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE INDEX(`username`)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `user`(username,PASSWORD) VALUES('admin','admin');
INSERT INTO `user`(username,PASSWORD) VALUES('lisi','123');


CREATE TABLE `role` (
  `rid` INT(11) NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(64) DEFAULT NULL,
  `role_name_zh` VARCHAR(64) DEFAULT NULL COMMENT '角色名称',
  CONSTRAINT `user_role_pk` PRIMARY KEY (`rid`)
) ENGINE=INNODB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
INSERT INTO role(role_name,role_name_zh) VALUES('admin','管理员');
INSERT INTO role(role_name,role_name_zh) VALUES('normal_user','普通用户');

CREATE TABLE `user_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `uid` INT(32),
  `rid` INT(11) ,
  CONSTRAINT `user_role_pk` PRIMARY KEY (`id`),
  CONSTRAINT `user_role_ibfk_1`  FOREIGN KEY(`uid`) REFERENCES `user`(`uid`),
  CONSTRAINT `user_role_ibfk_2`  FOREIGN KEY(`rid`) REFERENCES `role`(`rid`)
) ENGINE=INNODB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

INSERT INTO user_role(uid,rid) SELECT a.uid,b.rid FROM (SELECT uid FROM `user` WHERE username='admin') a ,(SELECT rid FROM role WHERE role_name='admin') b;


-- add table resource and role_resource
-- 搜索的时候 都是拿url来搜，所以加个index好效率应该要好些

CREATE TABLE `resource` (
  `res_id` INT(11) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(32),
  `res_name` VARCHAR(64) ,
  CONSTRAINT `resource_pk` PRIMARY KEY (`res_id`),
  CONSTRAINT `resource_res_name_uk` UNIQUE INDEX(`url`)
 
) ENGINE=INNODB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;


INSERT INTO resource(url,res_name) VALUES('/admin','管理员资源');

CREATE TABLE `role_resource` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `role_id` INT(11),
  `res_id` INT(11) ,
  CONSTRAINT `resource_pk` PRIMARY KEY (`id`),
  CONSTRAINT `role_resource_role_fk` FOREIGN KEY(`role_id`) REFERENCES `role`(`rid`),
  CONSTRAINT `role_resource_res_fk` FOREIGN KEY(`res_id`) REFERENCES `resource`(`res_id`)
) ENGINE=INNODB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

INSERT INTO role_resource(role_id,res_id) VALUES(22,75);



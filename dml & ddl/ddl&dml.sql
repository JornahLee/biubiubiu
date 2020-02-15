
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

INSERT INTO user_role(uid,rid) `role``role`SELECT a.uid,b.rid FROM (SELECT uid FROM USER WHERE username='admin') a ,(SELECT rid FROM role WHERE role_name='admin') b;

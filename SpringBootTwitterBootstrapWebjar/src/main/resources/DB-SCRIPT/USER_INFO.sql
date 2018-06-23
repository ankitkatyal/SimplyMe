create database lotus;

drop TABLE lotus.user_info;
CREATE  TABLE lotus.user_info (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) DEFAULT NULL,
  `middle_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `primary_contact` varchar(15) DEFAULT NULL,
  `secondry_contanct` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `aadhar_number` varchar(15) default NULL,
  `password` varchar(100) NOT NULL,
  `type` varchar(15) DEFAULT NULL,
  `stat_ind` int(1) DEFAULT 0,
  `create_date` date,
  `update_date` date,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `role_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8

rename table lotus.user to lotus.user_info;

insert into lotus.role_info(`role`) value('GUEST');

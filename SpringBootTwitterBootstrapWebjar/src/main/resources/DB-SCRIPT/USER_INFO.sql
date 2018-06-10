create database lotus;

CREATE TABLE lotus.user (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(25) DEFAULT NULL,
  `middle_name` varchar(25) DEFAULT NULL,
  `last_name` varchar(25) DEFAULT NULL,
  `primary_contact` varchar(15) DEFAULT NULL,
  `second_contact` varchar(15) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `aadhar_number` varchar(15) default NULL,
  `password` varchar(10) NOT NULL,
  `type` varchar(15) DEFAULT NULL,
  `stat_ind` int(1) DEFAULT 0,
  `create_dt` date,
  `update_dt` date,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
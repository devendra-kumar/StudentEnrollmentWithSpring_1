DROP TABLE IF EXISTS `client`.`student`;
CREATE TABLE  `client`.`student` (
  `id` bigint(20) NOT NULL auto_increment,
  `dateOfBirth` datetime NOT NULL,
  `emailAddress` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(8) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `Active` int(11) default '1',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `client`.`Question`;
CREATE TABLE  `client`.`Question` (
  `QuestionID` bigint(20) NOT NULL auto_increment,
  `QuestionFileName` varchar(255) default NULL,
  `AnswerFileName1` varchar(255) default NULL,
  `AnswerFileName2` varchar(255)  default NULL,
  `AnswerFileName3` varchar(255) default NULL,
  `AnswerFileName4` varchar(255) default NULL,
  `QuestionText` varchar(4000)  default NULL,
  `QuestionType` varchar(10) default NULL,  
  `Active` int(11) default '1',
  PRIMARY KEY  (`QuestionID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

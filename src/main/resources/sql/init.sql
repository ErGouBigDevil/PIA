CREATE DATABASE IF NOT EXISTS pia;

USE pia;

CREATE TABLE IF NOT EXISTS user(
    id INT(32) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    email_address VARCHAR(50)
);

INSERT INTO `user` (id,`username`,`password`,`email_address`) VALUES (16200,"ErGouBigDevil","admin","kengdad@live.com");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Hasad","1618091853499","adipiscing.elit.Aliquam@Sedeu.net");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Orlando","1676050600899","tellus@sitametrisus.ca");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Valentine","1631070872499","enim.nec.tempus@massa.net");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Colin","1638062331099","nunc.interdum.feugiat@turpisnonenim.ca");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Garth","1677082398499","nunc.est@quismassaMauris.org");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Ulric","1646061230199","Duis.gravida@ornareelitelit.net");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Garrison","1634120255299","enim.Etiam.imperdiet@etmagnis.org");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Zachary","1654080965799","Ut.tincidunt@sed.com");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Gil","1677081369099","mi@Namconsequatdolor.com");
INSERT INTO `user` (`username`,`password`,`email_address`) VALUES ("Thomas","1612112347199","Donec@consectetuer.co.uk");









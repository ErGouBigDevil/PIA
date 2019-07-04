CREATE TABLE IF NOT EXISTS contact(
    user_id INT(32) NOT NULL,
    name varchar(50),
    phone varchar(13),
    email varchar(50),
    company varchar(50),
    address varchar(64),
    FOREIGN KEY(user_id) REFERENCES user(id)
);

INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Samson","14547079923","fermentum.convallis@velquam.net","Eu Augue Corporation","North Island");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Vernon","17767244324","a@etrutrum.net","Ut Tincidunt Industries","Luxemburg");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Howard","12349286617","et.netus@maurisanunc.org","Euismod In Ltd","Leinster");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Darius","15081503573","nisi.magna@ultriciesornareelit.net","Vel Mauris Integer Consulting","AS");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Jonas","16121010756","sem.ut.cursus@blandit.net","Sed Leo Cras Corporation","Missouri");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Cullen","11775015285","urna@necenim.org","Non Ante Industries","Vienna");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Baker","11368026096","quam.vel@purusgravidasagittis.edu","Consectetuer Rhoncus Nullam Foundation","Ontario");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Garth","18567048087","non.enim.Mauris@orciluctus.edu","Rutrum Corporation","Leinster");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Kasper","11561510696","vulputate.mauris.sagittis@ac.co.uk","Malesuada Integer Id Foundation","PD");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Acton","11026130234","dui@eleifendnec.co.uk","Velit Cras Lorem Foundation","Ontario");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Bert","15557570869","vitae.aliquet@ipsumPhasellusvitae.co.uk","Et Netus Foundation","TN");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Bevis","11896272688","magna.nec.quam@pede.ca","Tincidunt Adipiscing Mauris Ltd","Caithness");
INSERT INTO `contact` (user_id,`name`,`phone`,`email`,`company`,`address`) VALUES (16200,"Quentin","12079699969","Aliquam@maurissapien.net","Nec Metus Facilisis Consulting","Hamburg");
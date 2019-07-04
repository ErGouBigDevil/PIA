CREATE TABLE IF NOT EXISTS pass(
    user_id INT(32) NOT NULL,
    website VARCHAR(50),
    username VARCHAR(50),
    password VARCHAR(50),
    FOREIGN KEY(user_id) REFERENCES user(id)
);

INSERT INTO `pass`(user_id,`website`,`username`,`password`) VALUES (16200, 'Tencent', 'tencenttest','test');
INSERT INTO `pass`(user_id,`website`,`username`,`password`) VALUES (16200, 'Baidu', 'baidutest','test');
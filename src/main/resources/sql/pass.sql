CREATE TABLE IF NOT EXISTS pass
(
    pass_id  INT(32) PRIMARY KEY AUTO_INCREMENT,
    user_id  INT(32) NOT NULL,
    website  VARCHAR(50),
    username VARCHAR(50),
    password VARCHAR(50),
    FOREIGN KEY (user_id) REFERENCES user (id)
);

INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16200, 'Tencent', 'tencenttest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16200, 'Baidu', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16200, 'Tencent', 'tencenttest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16200, '百度', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16200, '阿里巴巴', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16200, '腾讯', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16200, '美团', 'baidutest', 'test');


INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16201, 'Tencent', 'tencenttest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16201, 'Baidu', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16201, 'Tencent', 'tencenttest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16201, '百度', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16201, '阿里巴巴', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16201, '腾讯', 'baidutest', 'test');
INSERT INTO `pass`(user_id, `website`, `username`, `password`)
VALUES (16201, '美团', 'baidutest', 'test');
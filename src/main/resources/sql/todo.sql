CREATE TABLE IF NOT EXISTS todo(
    user_id INT(32) NOT NULL,
    title VARCHAR(50),
    deadline DATETIME ,
    site VARCHAR(50),
    note VARCHAR(200),
    FOREIGN KEY(user_id) REFERENCES user(id)
);

INSERT INTO `todo`(user_id,`title`,`deadline`,`site`,`note`) VALUES (16200, "集团会议", 20190709132500,"集团六楼会议室","带好笔记本电脑，汇报工作");
INSERT INTO `todo`(user_id,`title`,`deadline`,`site`,`note`) VALUES (16200, "家庭聚会", 20190710182500,"海底捞","早点出发");
INSERT INTO `todo`(user_id,`title`,`deadline`,`site`,`note`) VALUES (16200, "同学聚会", 20190711112500,"哥老官","早点去排队！");

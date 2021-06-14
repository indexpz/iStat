CREATE DATABASE
    istat
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

ALTER DATABASE
    serwer31807_istat7
    CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE meters
(id int AUTO_INCREMENT,
 data date NOT NULL ,
 hot_water double(7,2) NOT NULL ,
 cold_water double(7,2) NOT NULL ,
 electricity int(7) NOT NULL ,
 heat_meter double(8,3),
 PRIMARY KEY (id)
);

Drop table meters;

ALTER TABLE meters ADD description VARCHAR(500);
DROP TABLE meters;

INSERT INTO meters (data, hot_water, cold_water, electricity, heat_meter) VALUES (?,?,?,?,?);
INSERT INTO meters (data, hot_water, cold_water, electricity, heat_meter) VALUES (2017-04-31, '103.7', '114.86', '3849', '33.608');

DESCRIBE meters;
select now();


SET time_zone = 'UTC';

select * FROM meters;

DELETE FROM meters WHERE description = null;

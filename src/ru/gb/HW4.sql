CREATE TABLE `cinema`.`films` ( `ID` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(40) NOT NULL, 'duration' int ) ENGINE = MyISAM;
CREATE TABLE `cinema`.`sessions` ( `ID` INT NOT NULL AUTO_INCREMENT, `start_time` DATETIME NOT NULL, 'Duration' int, 'Film_id' int,
                                    FOREIGN KEY ('Film_id') REFERENCES 'films'('ID') ) ENGINE = MyISAM;
CREATE TABLE `cinema`.`tickets` ( `ID` INT NOT NULL AUTO_INCREMENT, `price` DECIMAL);
CREATE TABLE `cinema`.`tickets_session` (`ID` INT NOT NULL AUTO_INCREMENT, 'ticket' INT NOT NULL, 'session_id' INT NOT NULL,
                                                FOREIGN KEY ('ticket') REFERENCES `tickets`('ID'),
                                                FOREIGN KEY ('session_id') REFERENCES `sessions`('ID'));

#1
WITH intervals as ( SELECT A.film_id,
                           A.id AS session_id,
                           B.title,
                           A.start_time,
                           date_add(A.start_time, interval B.duration MINUTE) AS end_time)
                    FROM cinema.sessions AS A
                    INNER JOIN cinema.films AS B on A.film_id = B.id)
SELECT I1.session_id, I2.session_id,
       I1.title, I1.start_time, I1.end_time,
       I2.title, I2.start_time, I2.end_time
FROM intervals AS I1 INNER JOIN intervals AS I2 ON I1.start_time < I2.end_time AND I1.end_time > I2.start_time
AND I1.session_id <> I2.session_id
AND I1.seesion_id < I2.session_id;

#2

WITH intervals as ( SELECT A.film_id,
                           A.id AS session_id,
                           B.title,
                           A.start_time,
                           date_add(A.start_time, interval B.duration MINUTE) AS end_time)
FROM cinema.sessions AS A
    INNER JOIN cinema.films AS B on A.film_id = B.id)
SELECT I1.title, I1.start_time, I1.end_time,
       I2.title, I2.start_time, I2.end_time,
       TIMESTAMPDIFF(MINUTE, I1.end_time, I2.start_time)
FROM intervals AS I1
            INNER JOIN intervals AS I2 on I1.end_time < I2.start_time;



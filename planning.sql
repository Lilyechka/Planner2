USE planner;
CREATE TABLE users (
    id_user BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) ,
    role VARCHAR(10) ,
    password VARCHAR(100) ,
    email VARCHAR(50) ,
    date_of_birth DATE
);

CREATE TABLE tasks (
    id_task BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_user BIGINT,
    topic VARCHAR(500),
    date_of_creation DATETIME DEFAULT CURRENT_TIMESTAMP,
    deadline DATETIME,
    description_task VARCHAR(10000),
    FOREIGN KEY (id_user) REFERENCES users (id_user) ON DELETE CASCADE
);

INSERT INTO users (username, role, password, email, date_of_birth)
 VALUES 
('Oksana', 'ADMIN', '$2a$10$Zd4QVimJZnaso/W7ruNAL.9jwEw3zER6nR4mjOkLjpCEGjm45VQNy', 'Oksana@example.com','1994-04-15'), -- password: Oksana.123@
('Julia', 'ADMIN', '$2a$10$BJ7wXKyyvZhfL4umXrgCKO6Iy2WJfU71Z7x8QaQ9y1pKkPuqsui1K', 'Julia@example.com','2002-09-08'), -- password: Julia.123@
('Kira', 'USER', '$2a$10$liUNKJucPOijptbsSBUq.Oi/iDVZONpT7JSdgKQnxCx2/QyoUuHQm', 'Kira@example.com', '2001-11-19'), -- password: Kira.123@
('Mira', 'USER', '$2a$10$uRxaBt.vj4/1TPhF4Z/4Z.CNPmH4j1dqCGusTl6i4VNJ1Z0LXSz86', 'Mira@example.com', '2003-11-18'); -- password: Mira.123@



INSERT INTO tasks (id_user, topic, deadline, description_task)
 VALUES 
(1, 'Task for Oksana', '2024-06-17T12:00:00', 'Description for Oksana`s task'),
(2, 'Task for Julia', '2024-06-15T12:00:00', 'Description for Julia`s task'),
(3, 'Task for Kira', '2024-06-20T12:00:00', 'Description for Kira`s task'),
(4, 'Task for Mira', '2024-06-17T12:00:00', 'Description for Mira`s task');


-- drop table users
-- drop table tasks




-- ('Katy', 'USER', '$2a$10$ef6yMetWjPcjRjQ8nKZ51eVqQXxVZXZrshBiMqpGGt5AjxYuDg3Fm’, 'Katy@example.com'); -- password: Katy.123@

CREATE DATABASE hospital;
CREATE USER 'user'@'localhost' IDENTIFIED BY 'weak';
GRANT ALL ON hospital.* TO 'user'@'localhost';
FLUSH PRIVILEGES;



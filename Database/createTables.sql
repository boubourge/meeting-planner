CREATE TABLE meetingUser
(
    id INT PRIMARY KEY NOT NULL,
    username VARCHAR(100),
    firstName VARCHAR(100),
    lastName VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    phone VARCHAR(100),
    userStatus VARCHAR(5)
);

CREATE TYPE materialType AS ENUM ('ECRAN', 'PIEUVRE', 'TABLEAU', 'WEBCAM');
CREATE TABLE room
(
    name VARCHAR(5) PRIMARY KEY NOT NULL,
    capacity integer,
    material materialType[]
);

CREATE TYPE reunionType AS ENUM ('VC', 'SPEC', 'RS', 'RC');
CREATE TABLE reservation
(
    id INT PRIMARY KEY NOT NULL,
    reservationDate timestamp,
    type reunionType,
    roomName VARCHAR(100),
    userName VARCHAR(100),
    participantNumber integer
);
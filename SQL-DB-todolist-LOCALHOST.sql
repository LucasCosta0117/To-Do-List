CREATE DATABASE todolist;

USE todolist;

CREATE TABLE project (
	id			SMALLINT 	NOT NULL 	AUTO_INCREMENT,
    name		VARCHAR(20) NOT NULL,
    description	VARCHAR(150),
    createdAt	DATETIME 	NOT NULL,
    updatedAt	DATETIME 	NOT NULL,
    
    PRIMARY KEY (id)
);
CREATE TABLE task (
	id 			SMALLINT 	NOT NULL 	AUTO_INCREMENT,
	idProject 	SMALLINT 	NOT NULL,
    name 		VARCHAR(50) NOT NULL,
    description	VARCHAR(150),
    notes		VARCHAR(255),
    isCompleted BOOLEAN 	NOT NULL,
    deadline	DATETIME 	NOT NULL,
    createdAt	DATETIME 	NOT NULL,
    updatedAt	DATETIME 	NOT NULL,
    
    PRIMARY KEY (id)
);

ALTER TABLE task 
ADD FOREIGN KEY (idProject)
REFERENCES project (id);

DESCRIBE task;
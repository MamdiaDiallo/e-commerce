
CREATE TABLE IF NOT EXISTS users (
    id int(11) NOT NULL PRIMARY KEY,
    email VARCHAR(255) ,
    first_name VARCHAR(255) ,
    last_name VARCHAR(255) ,
    role VARCHAR(255),
    created_date TIMESTAMP ,
    date_of_birth TIMESTAMP ,
	password VARCHAR(255) 
);

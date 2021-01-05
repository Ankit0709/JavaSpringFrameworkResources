CREATE TABLE USER(
  USER_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
  USERNAME VARCHAR(128) NOT NULL UNIQUE,
  PASSWORD VARCHAR(256) NOT NULL
);

CREATE TABLE AUTH_GROUP(
    AUTH_USER_GROUP_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR(128) NOT NULL,
    AUTH_GROUP VARCHAR(128) NOT NULL,
    CONSTRAINT USER_AUTH_USERGROUP_FK FOREIGN KEY(USERNAME) REFERENCES USER(USERNAME),
    UNIQUE (USERNAME, AUTH_GROUP)
);
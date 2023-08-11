CREATE TABLE MEMBER(
	MID VARCHAR(10) PRIMARY KEY,
	MPW VARCHAR(10) NOT NULL,
	NAME VARCHAR(20) NOT NULL,
	ROLE VARCHAR(20) NOT NULL
);

INSERT INTO MEMBER VALUES('admin','1234','관리자','ADMIN');
INSERT INTO MEMBER VALUES('test','1234','사용자','USER');

SELECT * FROM MEMBER;
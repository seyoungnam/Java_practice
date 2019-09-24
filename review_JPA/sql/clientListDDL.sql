-- 기 존재하는 동일 이름의 테이블 삭제
DROP TABLE clientlst cascade constraint;

-- 기 존재하는 sequence도 삭제
DROP SEQUENCE clientlist_id_seq;

-- 테이블 만들기
CREATE SEQUENCE clientlist_id_seq;
CREATE TABLE clientlist (
       id		          	NUMBER(5)  PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       country  	       	VARCHAR2(10) NOT NULL,
       age                	NUMBER(5) NOT NULL
);

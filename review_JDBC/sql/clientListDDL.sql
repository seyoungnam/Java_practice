-- �� �����ϴ� ���� �̸��� ���̺� ����
DROP TABLE clientlst cascade constraint;

-- �� �����ϴ� sequence�� ����
DROP SEQUENCE clientlist_id_seq;

-- ���̺� �����
CREATE SEQUENCE clientlist_id_seq;
CREATE TABLE clientlist (
       id		          	NUMBER(5)  PRIMARY KEY,
       name               	VARCHAR2(20) NOT NULL,
       country  	       	VARCHAR2(10) NOT NULL,
       age                	NUMBER(5) NOT NULL
);

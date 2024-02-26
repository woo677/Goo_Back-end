-- insert 하기
create table employees(
	emp_no int(3),
	first_name varchar(3),
	family_name varchar(1),
	email varchar(50),
	mobile varchar(13),
	salary int(100),
	depart_no varchar(6),
	commission float(4,2)
);
desc employees;

select * from employees;

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no)
VALUES(117,'상민','전','susemi@naver.com','01012341234',4500000,'dev003');

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no)
VALUES(118,'준','유','seller@email.co.kr','01012341234',7400000,'dev003');

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(119,'항오','조','search@daum.net','01012341234',4500000,'dev003',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(120,'지훈','김','sunset@naver.com','01012341234',2000000,'dev003',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(121,'형진','박','see@daum.net','01012341234',5600000,'dev004',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(122,'덕기','이','zero10clzls@email.co.kr','01012341234',8900000,'dev004',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(123,'혁준','권','sky11clzls@naver.com','01012341234',6300000,'dev004',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(124,'기빈','고','zero12clzls@daum.net','01012341234',4400000,'dev004',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(125,'강인','최','sky13clzls@email.co.kr','01012341234',3700000,'dev005',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(126,'두원','김','zero14clzls@naver.com','01012341234',2000000,'dev005',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(127,'상헌','류','zet15clzls@email.co.kr','01012341234',2000000,'dev005',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(128,'태안','김','zet00clzls@email.co.kr','01012341234',1100000,'dev002',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(129,'태근','김','sky01clzls@daum.net','01011112222',3900000,'dev001',10);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no)
VALUES(130,'태건','김','zet02clzls@email.co.kr','01012341234',2000000,'dev001');

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no,commission)
VALUES(131,'성환','유','sky03clzls@naver.com','01012341234',4500000,'dev002',90);

INSERT INTO employees(emp_no,first_name,family_name,email,mobile,salary,depart_no)
VALUES(132,'영준','박','sky04clzls@email.co.kr','01012341234',1200000,'dev002');

select * from employees;


-- 2. 데이터 삭제(복구 불가능)(진짜 조심)
-- DELETE FROM [테이블명]
 delete from data;--무조건 안됨


-- commision 이 null 인 값을 지워 보자
 delete from employees where commission is null;-- where(웨얼) 문을 넣어야 된다
 
 -- 3.데이터 수정
--  UPDATE [테이블명] SET [컬럼]= [값] WHERE [조건] (조건을 주지않으면 모든 데이터를 바꾸기 때문에 조건을 조야한다)
-- depart_on 가 dec005인 row 에 대해서 commision 을 30 으로 변경
 update employees set commission = 30 where depart_no = 'dev005';
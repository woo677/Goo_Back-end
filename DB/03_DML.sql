/*DML(DAata Manipulation Language)
 * 데이터를 다루는 : 언어(SELECT,INSERT,UPDARE,DELETE,UPSERT)
 */

select * from employees; -- 테이블 안에 있는 데이터를 보여준다
desc employees; -- 테이블이 어떻게 생겻는지 확인 하는거(컬럼과 로우를 보여준다)
-- 1.데이터 삽입
-- INSERT(인썰트) INTO [테이블](컬럼명,.....) VALUES (컬럼명에 넣을 값,....)
insert into employees(emp_no,first_name,family_name,email_name,mobile,salary,depart_no,commision) 
values(111,'지훈','김','sadf@naver.com','0102202002',99999999,'dev01',90);

insert into employees(
emp_no,
first_name,
family_name,
email_name,
mobile,
salary
)values(
	122,
	'태근',
	'김',
	'dfas@nage.com',
	'01000000',
	999999
);

insert into employees(
	emp_no,
	family_name,
	email_name,
	mobile,
	salary
)values(
	122,
	'김',
	'dfas@nage.com',
	'01000000',
	999999
);
delete from employees;
select * from employees;
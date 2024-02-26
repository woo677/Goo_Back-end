-- DDL
-- 1.PRIMARY KEY(기본키 제약조건)
-- 중복과 NULL을 허용하지 않는다
-- 데이블 종속적 이다(종속관계 어디를 가지 못한다)(하나의 테이블에 하나의PK)
-- 하나의 컬럼으로 하나의 PK를 만들수 있지만, 여러개의 컬럼을 합쳐서 만들 수도 있다(최대 16개 까지 조합 가능)

-- 1.테이블 생성시 함께 생성(가장 많이 활용)
create table pk_test(
	fist_col int(3) primary key, -- 키 생성 법
	second_col varchar(4)

);

desc pk_test;-- prl(PRIMARY KEY)의 약자

delete from employees where emp_no = 119;




-- 2.테이블 생성 후 추가(실수로 만드는걸 까먹었을 떄)
desc employees;
-- ALTER TABLE [테이블명] ADD CONSTRAINT [제약조건 타입](적용필드);
alter table employees add constraint primary key (emp_no);
alter table employees add primary key (emp_no);

-- 일부로 중복 데이터 넣어보기
select * from employees order by emp_no;
insert  into employees (emp_no,first_name,family_name,email,mobile,salary)
	values(119,'항요','조','qwer@naver.com','01000000000',4500000);


-- UPSERT(업사이트) 중복되는 키값이 있으면 수정, 없으면 삽입
insert  into employees (emp_no,first_name,family_name,email,mobile,salary)
	values(112,'태그','야','13wer@naver.com','0112100000',4500000)
on duplicate key update email= 'email@naver.com', salary=9999;



-- 복합키(combination key)주민번호 앞,뒤가 중복될수도 있어서 2개의 컬럼을 조합에서 쓴다
-- 하나의 컬럼으로 하나의 기본키를 구성하는 것이 가장 좋으나,어쩔수 없는 경우 가수의 컬럼을 조합해서 기본키를 생성
-- 최대 16개 까자
-- 외래키를 이용하는 복합키를 만드는 경우 있는데, 이경우 update 나 insert에 제한을 주므로 사용하지 않는것이 좋다
create table pk_tow_test(
	first_col int(5),
	second_col varchar(10),
	third_col date,
	primary key(first_col,second_col)-- 키를 여러개 지정해 줄수 있다
);

desc pk_tow_test; 



-- 2. 제약조건 NOT NULL(NULL을 허용 하지 않음)
-- NOT NULL 은 제약 조건이지만 속성으로 취급
-- 태이블 생성 후에 NOT NULL 넣기
-- ALTER TABLE [테이블명] MODIFY [컬럼명](사이즈);
ALTER table pk_test  modify second_col varchar(4) not null ;-- 태이블 생성 후에 NOT NULL 넣기
desc pk_test;

-- 제약조건 확인 
select * from information_schema.table_CONSTRAINTS where TABLE_NAME = 'pk_tow_test';
-- 제약조건 삭제
-- alter TABLE [테이블] DROP [제약조건 종류];
alter table pk_tow_test drop primary key;  







select * from pk_test;
select @@autocommt;




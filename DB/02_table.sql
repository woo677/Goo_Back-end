select *from mysql.user;

/*DDL(Data Define Language) - 데이터 베이스나 테이블 등을 생성하는 언어
 * 데이터를 정의한다 (초창기에만 쓴다)
 * */

-- 데이터 베이스 목록 보기
show databases;


-- 데이터 베이스 생성
-- CREATE DATABASE [데이터베이스 이름]
create database mydb;


-- 데이터 베이스 삭제
-- DROP DATABASE [데이터베이스 이름]


-- 데이터 베이스 생성
-- USE [데이터베이스 이름]
use mydb;


-- 테이블 목록 확인
show tables;

drop table employees1;
-- 테이블 생성
/* CREATE TABLE [테이블명](
	[컬럼명] [데이터타입](크기)크기를 지정해 야한다,
	....
	);
*/



/*데이터타입 종류(자주 쓰는 일부)
 * 1.문자 타입
 * 
 * 고정형 - 한번정해진 크기가 변하지 않음 중요!!(2글자로 선언 했으니 1글자로 오면 남은 한자리는 공백(빈칸) 처리 됨)
 * char(바이트수)
 * 
 * 가변형 - (보통 이 걸 많이 쓴다)정해진 크기보다 적게 들어오면 알아서 줄여준다(고정형보다 조금은 느릴수도 있다)
 * varchar(바이트수)
 * 
 * 굉장히 큰 변수(이미지를 문자로 바꿀때 등....)
 * text : 65.535 byte (큰 데이터가 들어간다)
 * 
 * longtext : 4,294,967,295 byte (개 큰 데이터가 들어간다)
 * 
 * 
 * 2.숫자 타입 - int,long,float,double
 * 
 * boolean(잘 쓰이진 않는다)
 * 
 * 
 * 3.날짜 타입
 * DATE      : 년-월-일(0000-00-00)
 * DATETIME  : 년-월-일-시:분:초 (0000-00-00 00:00:00)
 * TIMESTAMP : DATETIME 과 같지만 time zone(대한민국 시간..)에 따라 시간이 변경 된다
 * 
 * */

-- 카멜 표기법X
-- 스네이크 표기법O

create table teat_table( -- 테이블의 이름을 teat_table로 생성
	user_name varchar(50),
	age int(3),
	mobile varchar(11),-- 전화번호
	reg_date date default current_date -- 등록 날자(default current_date : 기본으로 현제 날짜를 넣는다) 
);

-- 테이블 구조 보기 (이 방버을 추천)
desc teat_table;



/*데이블을 아래와 같이 만들어 보자
 * 테이블 명 : employees
 * emp_ no 숫자형 3자리
 * first_name 문자열 8자
 * last_name 문자열 2자
 * email 문자열 50자
 * mobile 문자열 11자
 * salary 숫자형 11자 
 * reg_date 날짜 기본으로 입력 된다
 */
 
create table employees(
	emp_no int(3),
	first_name varchar(8), -- 성
	last_name varchar(2),-- 이름
	email_name varchar(50),
	mobile varchar(13), -- 전화번호
	salary int(8),
	reg_date date default current_timestamp
);

desc employees; -- 테이블의 구조를 보여준다
show tables; -- 테이블의 목록을 보여준다


-- 테이블 삭제
-- DROP TABLE [테이블명]
drop table teat_table;	


-- CREATE(크리에이트) 로 생성한 녀석은 DROP 으로 삭제하고 ALTER 로 수정한다
-- 테이블 수정((컬럼에 대한 수정)중간중간에 수정은 하면 안된다(수정은 초기에 진행해야한다))
-- 여기에서 중간에 수정하면 오류기 나거나 날라갈수도 있다
  
-- 1.컬럼 이름 변경(기존데이터 삭제된다(이름 안에 있는 기존데이터가 날라간다)(함부로 바꾸면 안된다))
-- ALTER TABLE[테이블명] RENAME COLUMN [변경전 이름]TO[변경후 이름];
 
ALTER table employees RENAME COLUMN last_name to family_name;
desc employees;


-- 2.컬럼 추가 (은 괞찬다)
-- ALTER(알터) TABLE[테이블명] ADD ([컬럼명] [테이터타입] (크기));
 
ALTER table employees  ADD (depart_no varchar(10));-- depart_no 문자열 10바이트 추가
-- commision 문자열 10바이트
ALTER table employees  ADD (commision varchar(10));-- commision 문자열 10바이트 추가
-- etc 문자열 100바이드
ALTER table employees  ADD (etc varchar(100));-- etc 문자열 100바이트 추가


-- 3.컬럼 속성 변경(주의 사항 : 해당 컬럼이 비어 있어야 한다(다른 변수가 있으면 오류가 난다))
-- ALTER TABLE[테이블명] MODIFY COLUMN [컬럼명][데이터타입](크기);
ALTER table employees MODIFY COLUMN commision float(4,2); -- float(천체자릿수,소숫점자릴수)-->00.00
desc employees;


-- 4.컬럼 삭제
-- ALTER TABLE[테이블명] DROP COLUMN [컬럼명];
-- etc 삭제 해 보기
alter table employees drop column etc; 

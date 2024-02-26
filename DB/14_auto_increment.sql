-- auto_increment 는 자동 증가하는 속성()
-- 중복되지 않고,반드시 들어가며 테이블에 종속적이므로 PK 에 자주 사용된다
-- 생성법 1 : 테이블 생성시 함께 생성
-- Auto_ increment는 키가 설정 되있는 곳에만 쓸수 있다
create table auto_inc(
	no int(10) primary key auto_increment
	,name varchar(10) not null
);
desc auto_inc;

insert into auto_inc (name)values('kim');
insert into auto_inc (name)values('lee');
insert into auto_inc (name)values('park');

select * from auto_inc;

-- 생성법 2 : 이미 생성된 테이블에 추가

create table test(
	no int(10)
	,name varchar(10) not null
);
desc test;

insert into test(no,name)values(1,'a');

-- auto_increment는 해당 컬럼에 키가 설정되어 있어야만 한다
-- 기존에 있는 테이블에 데이터를 넣는다
alter table test modify no int(10) primary key auto_increment;

insert into test(name)values('b');
insert into test(name)values('c');


select * from test;


-- 속성 초기화 (auto_increment 값을 수정 할 수 있다)
alter table test auto_increment = 100;

insert into test(name)values('d');
insert into test(name)values('e');





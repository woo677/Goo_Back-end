-- 07_references
-- RDBMS (Relation Data Managenent System)
-- 관계형 데이터 베이스(뭔가를 상속 받을수 있다)

-- 1. 참조 제약 조건(외래키 제약조건)
-- 1)테이블 생성시 추가
create table parent_table(
	user_id varchar(30) primary key,
	user_name varchar(20),
	user_phone varchar(20),
	user_addr varchar(100)
);

-- 부모의 기본 키를 외부에서 참조해 온다
create table child_table(
	order_id int(10)
	,user_id varchar(30) -- 이러면 ,때문에 오류가나는 걸 줄일수있다
	,priduct_name varchar(30)
	,price int(10)
	,qiy int(5)
	-- ,foreign key(user_id) references parent_table(user_id) -- 외례키 를 가져온다 누구를 참도 할거냐 (부모의 기본키를 가져다 쓴다)
);



-- 2)테이블 생성 후 주가
-- ALTER TABLE[테이블명] ADD CONSTRAINT [제약조건종류](적용필드) REFERENCES [가져올 테이블](가져올 컬럼)
alter table child_table add constraint foreign key(user_id) references parent_table(user_id);

select * from information_schema.table_CONSTRAINTS where TABLE_NAME = 'child_table';

desc child_table;

/*부모자식 관계란 부모의 기본키를 자식이 가져다 쓰는 관계이다
 * 이때 부모의 기본키를 나의 기본키로 사용하는 경우를 '식별 관계'라고 한다(부모의 키를 가져다 쓰면)
 * 그렇지 않을 경우는 '비식별 관계'라고 한다
 * */


-- 식별 관계
create table iden_table(
	user_id varchar(30) primary key,
	foreign key(user_id) references parent_table(user_id)

);


-- 2. 연계 참조 무결성 제약조건
-- 부모자식간에 논리적으로 앞뒤 말이 맞아야 한다(하극상,패륜)
-- 부모가 먼저 있고 자식이 있는거(글은 없고 댓글만 있을떄,상품평만 있고 상품이 없을때)


-- 모든 컬럼에 값을 넣을 경우 컬럼명을 생략 해도 된다(권장하는 방법은 아님 )
-- insert into parent_table(user_id,user_name,user_phone,user_addr)values('user01','김철수','01012341324','서울');
-- 부모
insert into parent_table values('user01','김철수','01012141324','서울');
insert into parent_table values('user02','김아수','01012344324','서울');
insert into parent_table values('user03','김사수','01012342324','서울');

select * from parent_table;

-- 자식
insert into child_table values(1,'user01','의류',6000,1);
insert into child_table values(2,'user02','의류',6000,1);
insert into child_table values(3,'user03','의류',6000,1);

select * from child_table;


-- 부모한테 없는 값을 외래키에 넣으려고 하면 에러가 나타난다
-- 연계참조 무결성이 깨졌다
-- 부모테이블의 기본키는 user04 가 없지만,자식이 그것을 쓰려고 했다 ->부모없는 자식을 만들려고 함ㄴ
insert into child_table values(4,'user04','의류',6000,1);

-- 부모를 지워 보자(부모 없는 자식을 않 만들려고 한다)
-- 자식을 지운다음 부모를 지우면 된다
delete from child_table where user_id='user01'
delete from parent_table where user_id='user01';

-- 연계참조 무결성을 해치지 않고 삭제 하려면 자식이 먼저 삭제되고, 이후 부모가 삭제 되어야 한다
-- 이 과정을 자동으로 수행해 주는 ON DELETE CASCADE 옵션이 있다(테이블 생성 할때 넣어야한다)
-- 1개 테이블에 여러 자식이 있을때

create table supplier(
	sup_id int(10)primary key
	,sup_name varchar(50) not null -- null을 허용 하지 않는다
	,phone varchar(12)
);

create table prdoucts(
	pd_id int(10) primary key
	,sup_id int(10)
	,sup_name int(10)
	,phone int(10)
	,foreign key(sup_id) references supplier(sup_id) on delete cascade
);

insert into supplier values(1,'김철수','01012141324');
insert into supplier values(2,'김아수','01012344324');
insert into supplier values(3,'김사수','01012342324');

select * from parent_table;


insert into prdoucts values(1111,1,6000);
insert into prdoucts values(1112,2,6000);
insert into prdoucts values(1113,3,6000);

select * from supplier;
select * from prdoucts;

-- 부모와 관련된 자식들을 찾아네고 삭제 한다
delete from supplier where sup_id = 1;





-- unique(유니크) 제약조건
-- 중복을 허용하지 않는 제약조건
-- 테이블에 다수 존대할 수 있다
-- unique + not null = pk(키가 될수도 있다)(후보키)
-- 후보키 - 기본키가 될 수 있는 조건은 갖을 수 있으므로..
-- ALTER TABLE[테이블명] ADD CONSTRAINT [제약조건종류](컬럼명);
alter table supplier add constraint unique(sup_name);
desc supplier;
select * from information_schema.table_CONSTRAINTS where TABLE_NAME = 'supplier';

-- Duplicate entry '박철수' for key 'sup_name'
insert into supplier values(4,'박철수',0102123456);

select * from supplier;



-- check(체크) 제약조건
-- 조건이 맞지 않으면 받지 않는 제약조건
-- ALTER TABLE[테이블명] ADD CONSTRAINT [제약조건종류](조건);
-- price 가 5000원인 미만인 경우만 받겠다
-- 주의 사항 : 조건은 기존 데이터가 만족해야할 조건을 걸어야 한다(유연성이 떨어진다)
alter table prdoucts add constraint check(phone<5000);

-- price 가 6000원인 경우만 받겠다
alter table prdoucts add constraint check(phone<=6000);
-- 6000원 보다 크면 않들어 간다
insert into prdoucts values(1115,2,6000);

select * from prdoucts;

-- 안쓰는 이유
-- 1.조건의 유연성이 떨어진다
-- 2.조건 변경시 DDL 을 수정해샤 한다(DB를 계속 건드린다) (치명적이다)
-- 어떤 조건이 걸려있는지 파악하기가 쉽지 않다

-- 찾는 방법
-- 소스에서는 없고 뭔가가 작동 하는거 같을때 찾는 방법
select * from information_schema.table_CONSTRAINTS where TABLE_NAME ='prdoucts' ;



-- 1) 뷰
-- 여러 테이블의 데이터를 모아서 만든 가상 테이블 이다
-- 복잡한 서브쿼리나 조인이 필요한 쿼리문을 한번만 사용해서 뷰를 만들어 놓으면 이후 편리하게 사용 할 수 있다
-- 뷰는 자신만의 인텍스를 가질 수 없다
-- 뷰에 인덱스를 넣고 싶다면 컬럼의 워본 테이블에서 인덱스를 넣어야 한다

-- 2) 뷰 생성 문법
-- CREATE [OR REPLACE] VIEW [뷰이름] AS [뷰를 생성할 쿼리]
-- OR REPLACE : 생성에는 사용 하지 말아라
-- OR REPLACE : 기본 뷰를 수정할때 사용 한다(왠만하면 붇이지 않는다)(같은 이름이 있느면 덥어 쓴다)(수정,삭제를 조심해라)
-- 뷰는 *로 쓰지 말아라 (그럼 쓰는 이유가 없다) 보여주고 싶은 내용만 써라

create view name_query as 
	select e.ename, d.deptname from emp e join dept d 
		on e.deptno = d.deptno;
	
-- 3) 뷰 확인
-- show create view [뷰이름]	
show create view name_query; -- 구성 쿼리도 보여줌
show full tables where table_type = 'VIEW'; -- 항목만 보여줌

-- 4) 뷰 사용 : 테이블 사용과 같음
select * from name_query;

-- 뷰에서 수정을 가하면 원본 테이블의 데이터도 수정 된다
update name_query set ename = 'oh' where ename = 'kim';
select * from emp;

-- kim중에서 바뀌지 않는 내용이 있다
-- 이유 : 부모와의 관계를 끊어서 또는 부모에 없는 키 값이어서(emp와 dept의 deptno가 중복이 않되서 뷰를 만들때 (6)들어가지 않음)
-- kim이 남아있는 이유는 6번의 경우 등가조인의 조건에 맞지 않아 뷰에 포함되지 않았기 때문네 뷰에서 수정 했을때 영향을 받지 않는다

-- 5 ) 뷰 수정
-- ALTER 로 수정이 가능 하지만 일반적으로 OR REPLACE를 사용 한다(수정을 할때는 쓰는게 좋다(뷰가 없으면 많들어준다))
-- 있으면 수정하고,없으면 만들기 때문에(수정할 건지 만들건지를 확실하게 해야한다)
create or replace view name_query as
	select e.ename, d.deptname,d.loc from emp e join dept d 
		on e.deptno = d.deptno;

select * from name_query;

-- 6) WITH CHECK OPTION : 뷰를 생성한 조건식을 만족하는 컬럼에 대해서는 수정을 막는 옵션 (뷰를 특정 값의 수정을 막는다)
create view chk_option as select ename,job, deptno from emp where deptno = 1 with check option;
select * from chk_option;
-- 일반적인 수정은 모두 가능 하다.
update chk_option set job = 'manager' where ename = 'lee';

-- 뷰를 만든 조건인 deptno 는 수정 불가능 하다
update chk_option set deptno = '1' where ename = 'lee';

-- 변경해 주고 싶다면 원본 데이블에서 수정해야 한다
update emp set deptno = '2' where ename = 'lee' and job = 'manager';-- (수정을 할때는 꼭 조심해야 된다)
select * from emp e ;



-- 7 ) 뷰 삭제
-- DROP VIEW [뷰리름];
drop view chk_option;
drop view name_query;

show full tables where table_type='VIEW';-- 테이블의 뷰를 보는 방법















-- 서브쿼리 : 쿼리안의 쿼리
-- 하나의 쿼리문으로 받아온 데이터를 바탕으로 다른 내용을 검색 할때
-- 1.추출된 결과로 다른 내용을 검색시
-- 2.검색된 내용을 가상의 컬럼으로 볼때


create table dept( -- 부서
 	deptno varchar(10) primary key
 	,deptname varchar(20)
 	,loc varchar(10)
);

create table emp( -- 사원
	ename varchar(20)
	,job varchar(50)
	,deptno varchar(10)
	,hiredat date
); -- 부모자직X
drop table emp;
-- 자식이 부모의 키를 가져온다
alter table emp add constraint foreign key(deptno) references dept(deptno);

-- dept에 데이터를 삽입한
insert into dept(deptno,deptname,loc)values('1','sales','newyork');
insert into dept(deptno,deptname,loc)values('2','dev01','la');
insert into dept(deptno,deptname,loc)values('3','personnel','newyork');
insert into dept(deptno,deptname,loc)values('4','delevery','boston');

-- 데이터가 제데로 들어 갔는지 확인한다
select * from dept;

-- 부모 deptno 1,2,3,4 만들어 갈수있다
insert into emp(ename,job,deptno,hiredat)
values('kim','manger','1',str_to_date('16/01/02','%Y/%m/%d')); -- Y는 4글자로 표현 하겠다

insert into emp(ename,job,deptno,hiredat)
values('lee','staff','1',str_to_date('15/01/02','%Y/%m/%d'));

insert into emp(ename,job,deptno,hiredat)
values('han','staff','1',str_to_date('16/03/02','%Y/%m/%d'));

insert into emp(ename,job,deptno,hiredat)
values('kim','assistant','1',str_to_date('15/09/22','%Y/%m/%d'));

select * from emp;


insert into emp(ename,job,deptno,hiredat)
values('ahn','staff','2',str_to_date('15/12/02','%Y/%m/%d'));

insert into emp(ename,job,deptno,hiredat)
values('hwang','manger','2',str_to_date('15/08/12','%Y/%m/%d'));

insert into emp(ename,job,deptno,hiredat)
values('cha','assistant','2',str_to_date('12/03/02','%Y/%m/%d'));

insert into emp(ename,job,deptno,hiredat)
values('hong','staff','2',str_to_date('14/08/02','%Y/%m/%d'));

insert into emp(ename,job,deptno,hiredat)
values('gang','staff','2',str_to_date('10/01/02','%Y/%m/%d'));

select * from emp;

insert into emp(ename,job,deptno,hiredat)
values('name','leader','4',str_to_date('10/01/02','%Y/%m/%d')); -- str_to_date : 문자열을 날자형으로 바꾼다
-- str_to_date : str(string) : 문자열을 date :날자형으로 to :바꾼다
select * from emp;


-- 1.문제 : 'han'의 근무 부서는?
select * from dept;
select * from emp;

-- emp 테이블에서 han의 deptno 를 알아낸다
select deptno from emp where ename = 'han';

-- deptno 를 통해 dept 의 deptname 을 알아낸다
select deptname from dept where deptno = '1';


-- 해결 > 
-- select * from emp where ename = 'han'; -> 결과를 가지고 
select deptno from dept where deptno = '1'; -- 실행

select deptname,loc from dept where deptno = (select deptno from emp where ename = 'han');


-- 2. 문제 > 부서 위치가 'la' 또는 'boston'인 부서 소속의 사람들에 이름,직책은?
select * from dept;
select * from emp;

-- 부서 위치 : deptno,loc 2번'la' 4번'boston' 
-- 1. 방법
select deptno,loc from dept where loc = 'la' or loc = 'boston' ; -- 이 결과를 가지고 다음중 실행
-- 2. 방법
 select deptno,loc from dept where loc in('la','boston') ;

-- 소속의 사람 이름,직잭 :  ename : 이름 job'직책'
select ename,job from emp where deptno ='2' or deptno = '4';
-- 2. 방법
select ename,job from emp where deptno in('2','4');

-- 해결 >
select ename,job from emp where deptno in('2','4');



-- 문제3 > salse 부서 근무하는 사원 데이터(ename,job,hiredat) 가져오기
select * from dept;
select * from emp;

-- dept 에서 salse의 부서 deptno 뽑기
select deptno from dept where deptname = 'sales';
-- deptno을 가지고 ename,job,hiredat을 뽑아낸다
select ename,job,hiredat from emp where deptno = '1' ;

-- select ename,job,hiredat from emp where deptno = (select * from dept where deptname = 'sales') ;
-- 이러면 dept에 모든 값을 보여주기 때문에 오류가 난다
-- 해결법 * 말고 deptno쓰면된다

-- 해결 >
select ename,job,hiredat from emp where deptno = '1' ;



-- 문제 4 > 직책(job)이 manager 인 사원들(여러명일 경우 빠른 직원 기준)보다 입사일 빠른 직원(ename,job,hiredat)은?
select * from emp;

select hiredat from emp where job='manger' order by hiredat asc limit 1 ; -- 2015-08-12 --limit 1; 하나만 가져와

select ename,job,hiredat from emp order by hiredat asc ;
select * from emp where hiredat<'2015-08-12'order by hiredat asc;

-- 해결 > 
select ename,job,hiredat from emp where hiredat< (select min(hiredat) from emp where job='manger')order by hiredat asc;
-- min() : 최소값을 가져와


-- 문제 5> 부서별(depton,deptname)로 직원이 몇명인지 확인
select * from dept;
select * from emp;

-- 부서의 deptno,deptname을 알아네기
select deptno,deptname from dept where deptno =1;
select deptno,deptname from dept where deptno =2;
select deptno,deptname from dept where deptno =4;

-- 부서별로 직원이 몇명인 인지 확인
select count(deptno) from emp where deptno =1;  -- count()숫자를 세준다 --값이 없는 놈도 센다
select count(deptno)  from emp where deptno =2; -- count()숫자를 세준다
select * from emp where deptno =3; -- null
select count(deptno) from emp where deptno =4;  -- count()숫자를 세준다

-- 상하 관계 쿼리
-- 서브쿼리의 결과물이 본 쿼리의 일부로 사용될 경우
-- 컬럼, 테이블 로 활용이 된다.
select deptno,deptname,(select count(deptno) from emp where deptno =1)as cnt from dept where deptno =1;
select deptno,deptname,(select count(deptno) from emp where deptno =2)as cnt from dept where deptno =2;
select deptno,deptname,(select count(deptno) from emp where deptno =4)as cnt from dept where deptno =4;

-- 간소화
select deptno,deptname,(select count(deptno) from emp where deptno=d.deptno)as cnt 
from dept as d;

-- from dept(에 이름을 정한다음) as d에 있는 값을 -> 넣을거다 deptno=d.deptno

-- group by사용 -- 값이 없는 놈은 안센다
select deptno,count(deptno)as cnt  from emp group by deptno;

-- group by사용 상하관계 쿼리
-- 문제점 : 코드가 굉장히 길어진다
select deptno,
	(select deptname from dept where deptno=e.deptno) as deptname, 
	count(deptno)as cnt  
from emp e group by deptno;











-- join 이란?
-- 둘 이상의 테이블을 연결하여 데이터를 검색하는 방법 이다
-- 두개의 테이블이 조인하기 위해서는 적어도 하나의 공통된 컬럼이 존재 해야 한다
-- 그래서 일반적으로 부모(PK)와 자식(FK)간에 조인이 수월하게 이루어 진다


-- JOIN의 종류
-- CROSS JOIN은 JOIN에 시초라 간단하게 배우는 거임
-- CROSS JOIN, EQUI JOIN(등가조인,내부조인(얘를 많이씀))
-- NON-EQUI JOIN(거의 안쓰이기 때문에 다루지 않음)
-- SLEF JOIN, OUTER JOIN

-- 0. CROSS(클론) JOIN(거의 안씀)
-- 두개의 테이블을 카다시안(경우의 수를 다 따져본다) 곱을 수행한다
-- emp(10) dept(4)= 4개씩 해서 40이 나옴 


-- FROM [테이블A] CROSS JOIN [테이블B]
select e.ename,d.deptname from emp e cross join dept d; -- 정제되지 않은 조인

-- CROSS JOIN은 생략 가능( , )
select e.ename,d.deptname from emp e ,dept d;

-- CROSS JOIN은 아직 정제되지 않은 순수한 조인 형태(생 양파)
-- 그래서 조건을 주어서 원하는 데이터를 뽑아낸다


-- 1.EQUI JOIN(이퀄 조인) - 조인 하는 두 테이블 모두에 값이 있을 때만 보여준다
-- 가장 일반적으로 사용하는 조인( = 를 사용)(가장 만만함)

-- 1)등가조인(가장 많이 씀)(a에 있는 값이 b에도 있어야 한다)
select e.ename,d.deptname from emp e ,dept d where e.deptno = d.deptno;

insert into dept(deptno,deptname,loc)values('5','dev02','floride');
/*양쪽에 데이터 불균형이 있을 경우
 * ename,deptname
 * (NULL), personnel
 * (NULL),dev02
 * 이런식으론 보여주지 않음
 * 
 * */

select * from dept;
select * from emp e;

-- 2)내부조인(INNER JOIN)
-- FROM [테이블A] INNER JOIN [테이블B]
-- inner 생략 가능, 조인을 위한 조건은 where 가아닌 on 사용
select e.ename,d.deptname from emp e inner join dept d on e.deptno = d.deptno;

select e.ename,d.deptname from emp e join dept d on e.deptno = d.deptno;
-- using(유징) 을 사용하여 조건을 줄 수 있다
-- 장점 : using(서브쿼리) 가 가능 하다
select e.ename,d.deptname from emp e inner join dept d using(deptno);


-- 3)네츄럴 조인(자연조인(자연스러운 조인))
-- 네츄럴 조인은 두 테이블사이 공통되는 컬럼이 있으면 자동으로 합쳐지게 된다
-- 그래서 조인을 위한 조건절이 필요 없다
-- 주의 사항 : 공통되는 컬럼명은 단축명은 사용하지 않는다(일부 DB에서 에러 날 수 있음)
select e.ename,d.deptname from emp e natural join dept d;

-- 2.셀프조인 (SLEF JOIN)
-- EQUI JOIN 과 똑같다 다만 두개의 테이블이 둘다 자신이라는 것만 다르다(a와 a 조인)
-- 셀프 조인을 하면 두 데이터간 카다시안 곱을 수행한다
select a.ename,b.job from emp a, emp b where a.deptno = b.deptno;


-- 3.외부조인
-- [테이블A] [left | right]outer join [테이블B] ON 조건절
-- LEFT(왼쪽을 기준으로 더 있는 값을 보여줌)
-- RIGHT(오른쪽을 기준으로 더 있는 값을 보여줌)
-- FULL(서로 없는 값을 보여줌(오라클은 지원을 안함))
-- outer 는 생략 가능
-- 데이터가 없는 데이터를 출력할때 쓴다
-- 조인문의 왼쪽,오른쪽에 있는 테이블의 모든 결과를 가져 온 후 오른쪽,왼쪽 테이블의 데이터를 매칭하고, 매칭되는 데이터가 없는 경우 NULL로 표시한다.
select d.deptno,e.ename,d.deptname from emp e right outer join dept d on e.deptno = d.deptno ;

-- emp 에 deptno 6번을 추가
insert into emp(deptno,ename,job,hiredat)values('6','kim','assistant',str_to_date('14/06/02','%Y/%m/%d'));
-- 연계참조 무결성 제약조건에 의해서 부모(dept)에게 없는 6번을 자식(emp)이 넣을 수 없다
-- 그래서 부모-자식 관계를 해제->FK를 삭제

select * from information_schema.table_CONSTRAINTS where TABLE_NAME = 'emp';-- (제약조건 확인)
-- alter table emp drop constraint[제약조건]
alter table emp drop constraint emp_ibfk_1;

select * from emp;

select * from dept;

select e.deptno,e.ename,d.deptname 
from emp e left outer join dept d on e.deptno = d.deptno ;

/*left  join : join을 기준으로 외쪽 테이블의 데이터를 기준으로 보여준다(오른쪽에 없는 내용은 null 처리) - 1,2,4,6
 *right join : join을 기준으로 오른쪽 테이블의 데이터를 기중으로 보여준다(왼쪽에 업는 내용은 null 처리) - 1,2,3,4,5
 *서로 없는 내용을 보여줄수 있는 방법 : full outer join
 * */
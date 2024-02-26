-- 집합(Set)
-- 다수의 테이블을 집합 연산 할 수 있다
-- 합집합(UNION, UNION ALL), 교집합(INTERSECT), 차집합(MINUS) 이 존재 한다
-- 중복 제거를 해 주는 UNION 은 성능저하 문제로 권장하지 않는다.
-- [qry1] [UNIN ALL | INTERSRCT | MINUS] [qry2]
-- 두개의 테이블을 합친다
-- 유니온은 스스로 중복을 제거한다
-- 유니온올은 진짜로 더한다


-- 1. UNION : 중복을 제거한 합집합(두게 쿼리를 합친다)(하나하나 확인한다)(중복제거)
select deptno from emp
	union
select deptno from dept order by deptno;

-- left join 과 right join 을 union 하면 full outer join 효과를 얻을 수 있다.
select e.deptno, e.ename, d.deptname from emp e left join dept d on e.deptno = d.deptno
	union
select d.deptno, e.ename, d.deptname from emp e right join dept d on e.deptno = d.deptno;



-- 2.UNION ALL : 중복제거 없이 합집합 실행(두개 쿼리를 않 합친다)
-- UNION ALL을 순수하게 실행한다기 보다는 정제해서 사용 한다
 select deptno from emp
	union all
select deptno from dept order by deptno;



-- 3.INTERSECT :양 테이블에 존재하는 중복된 데이터만 확인 한다
 select deptno from emp
	intersect 
select deptno from dept order by deptno;


-- 4.MINUS : 마라아디비에서는 차집합 지원하지 않는다 (존제 하지않은건 무엇이냐?)(존제 하는건 무엇이냐)
select distinct deptno from emp; -- 1,2,4,6
select distinct deptno from dept; -- 1,2,3,4,5

-- emp - dept = 6
select deptno from emp where deptno not in(select deptno from dept) ;

-- in : 포함된거
-- not in : 포함된거 빼고

-- dept - emp = 3,5
select deptno from dept where deptno not in(select deptno from emp) ;


-- emp와 dept 를 합집합 한 내용 을 emp와 교집합

select deptno from emp
	union
select deptno from dept
	intersect
select deptno from emp;

-- union 을 대채할 경우?
-- 1.일단 합친다
-- 2.합친 내용을 가지고 중복 제거
select distinct u.deptno from(
select deptno from emp
	union all
select deptno from dept) u order by u.deptno asc; 

-- 데이터를 확보한다음 움직이는게 빠르다


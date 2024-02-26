-- 이것들을 쓰는 이유 (코드는 안봐끼고 부둥호만 바낄거 같을데)

/*IN & EXISTS(엑시스츠)*/ -- (쿼리문에 속도가 안나올때 2번째 방법)(쿼리 튜닝)
-- EXISTS : 메인쿼리가 먼저 실행되고, 이후 서브쿼리가 실행 된다.
-- 부서가 LA 또는 Boston에 있는 직원의 이름과 직책
select deptno from dept where loc in('la','boston');
select ename, job from emp where deptno in ('2','4');

-- 1. IN : '=' 비교만 가능(크다, 작다 비교 안됨), OR 조건의 검색 결과 내용을 가져온다.
-- 서브쿼리가 먼저 실행되고 그 결과를 가지고 메인 쿼리를 실행 한다.
select ename, job from emp where deptno in (select deptno from dept where loc in('la','boston'));


-- 2. EXISTS : 메인쿼리의 비교 조건이 서브쿼리의 결과 중에서 '만족하는 값이 하나라도 존재 한다면' 참(1)/거짓(0)으로 반환
-- 메인쿼리 실행 후 데이터를 exists 조건이 참이 되면 모든 내용을 보여주고(따로 논다)
-- 메인쿼리가 먼저 실행되고, 이후 서브쿼리가 실행 된다.
select ename,job,deptno from emp where 
	exists (select deptno from dept where loc = 'LA' or loc = 'BOSTON');

select * from emp where 1;

-- 참이 아니라면 아무것도 보여주지 않는다.
select ename,job,deptno from emp where 
	exists (select deptno from dept where loc = 'korea');

select * from emp where 0;


--  위 특성을 가지고 어떻게 써먹을 것인가?
-- 1) 메인쿼리가 실행되어 데이터를 확보하고
select ename, job, deptno from emp;

-- 2) 확보한 데이터로 부터 dept 와 연결 해 준다.
-- 양쪽 둘 다 있는 데이터만 가져옴
-- 아까 같이 왜 모든 데이터를 보여주지 않는가?(6번은 안보여 줬음)
-- 메인 쿼리와 서브쿼리 간에 공통된 컬럼을 조건으로 걸고 있어서(묶어서 움직임)
select ename, job, deptno 
	from emp e where exists (select deptno from dept d where e.deptno = d.deptno);

-- 3) 걸러낸 녀석들 중에서 dept 에서 loc가 al 이거나 boston 인 녀셕만 골라내면 된다.
select ename, job, deptno 
	from emp e where exists (
		select deptno from dept d where e.deptno = d.deptno and (d.loc='boston'  or d.loc ='la'));
	
-- 속도가 빠른이유 (데이터를 확보한다음 실행을 해서)(메인쿼리 먼저 돌고 실행)
/*IN 이 EXISTS 보다 사용은 쉽지만 속도는 느리다
 * SQL 에서는 데이커를 확보해 놓고 다음작업을 진행하는것이 빠르기 때문이다
 * EXISTS 는 메인쿼리를 통해 데이터를 확보하고, 서브쿼리 내용으로 일치하는 내용을 보여주기 때문에 속도가 더 빠르다 
 * */


/*ANY & ALL*/
-- 3. ANY(앤이) : 메인 쿼리의 비교조건이 서브쿼리의 결과중에 하나라도 일치하면 참
-- IN 처럼 쓸 수도 있고, 크다/작다를 활용 할 수 있다
-- 1) =ANY : IN 과 같은 효과
select ename, job from emp where deptno in (select deptno from dept where loc in('la','boston'));
select ename, job from emp where deptno = any (select deptno from dept where loc in('la','boston'));



-- 직책이 manager 인 직원중 입사일이 가장 빠른 사람보다, 늦게 입사한 사람의 직책과 입사일
select min(hiredat) from emp where job = 'manger' order by hiredat;

select job ,hiredat  from emp where hiredat >'2015-08-12' order by hiredat ;


select job ,hiredat  from emp where hiredat >(select min(hiredat) from emp where job = 'manger' order by hiredat) order by hiredat ;

-- 2) > ANY : 최소값 보다 크면
select job ,hiredat  from emp where hiredat > any(select hiredat from emp where job = 'manger' order by hiredat) order by hiredat ;



-- 직책이 manager 인 직원중 입사일이 가장 늦은 사람보다, 빨리 입사한 사람의 직책과 입사일
select job ,hiredat  from emp where hiredat < (select max(hiredat) from emp where job = 'manger') order by hiredat ;

-- 3) < ANY : 최소값 보다 작으면
select job ,hiredat  from emp where hiredat < any(select hiredat from emp where job = 'manger' order by hiredat) order by hiredat ;


-- 4.ALL : ANY 와 반대
-- 1) =ALL : =ANY 와 같지만 AND 조건 이다
-- 오류 원인
select * from dept ;
-- select ename,job  from emp where deptno = all(select deptno from dept where loc='newyork' );
-- 서브쿼리 안의 값이 여러개가 나타날 경우 사용하면 안된다(단일 값만 사용 가능)
select ename,job  from emp where deptno = all(select deptno from dept where loc='boston' );

-- 2) > ALL : 최소값 보다 크면
-- 직책이 manger 인 직원중 입사일이 가장 늦은 사람보다, 더 늦게 입사한 사람의 직책과 입사일
select max(hiredat) from emp ; -- max : 최대값

select hiredat from emp where job = 'manger' order by hiredat desc ;
select job,hiredat from emp where hiredat > '2016-01-02';

select job,hiredat  from emp where hiredat > all(select hiredat  from emp where job = 'manger');


-- 3) < ALL : 최소값 보다 작으면
-- 직책이 manger 인 직원중 입사일이 가장 빠른 사람보다, 더 빨리 입사한 사람의 직책과 입사일
select min(hiredat) from emp ; -- min : 최소값

select hiredat from emp where job = 'manger' order by hiredat;
select job,hiredat from emp where hiredat < '2015-08-12';

select job,hiredat  from emp where hiredat < all(select hiredat  from emp where job = 'manger' order by hiredat desc);





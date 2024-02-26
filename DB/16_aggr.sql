-- 집계 함수 :  여러행 또는 테이블 전체 행으로 하나의 결과값을 변환하는 함수


-- 1) COUNT(column) : 검색된 행의 갯수 변환
select count(deptno) from dept d ;

-- 2) MAX : 최대 값
select max(salary) from employees e ;

-- 3) MIN : 최소 값
select min(salary) from employees e ;

-- 최대 급여를 받는 사람과,최소 급여를 받는 사람의 이름과 급려를 출력 하세요
select * from employees e ;
select max(salary) from employees e ;
select min(salary) from employees e ;

select first_name ,family_name,salary  from employees e where salary = (select max(salary) from employees e)
union all -- 이거는 꼭 알았으면 한다
select first_name ,family_name,salary  from employees e where salary = (select min(salary) from employees e);

select first_name ,family_name,salary  from employees
	where salary in((select max(salary) from employees),(select min(salary) from employees ));


-- AVG : 평균 반환
-- round() : 소숫점 1자리에서 반올림
select round(avg(salary),1) from employees;

-- SUM : 총 합계 반환
select sum(salary) from employees where depart_no = 'dev004';








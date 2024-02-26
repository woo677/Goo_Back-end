use employees;
show tables;


-- 테이블 분석
-- 테이블을 분석할때는 limit 걸어서 보자 ()


-- 현재 사원 정보 : 현제 사원들의 정보와 부서,입사일,퇴사일(현제 고용상테)
select * from current_dept_emp limit 5;-- 테이블을 분석할때는 limit
desc current_dept_emp;


-- 팀 목록(오타를 방지하기 위해서 키를 부여해 버린다)
-- 부서 : 부서 번호,부서명이 있다
select * from departments;
desc departments;


-- 특정 부서 팀원 히스토리(employees,dept(자식))(팀을 여기저기 옴겨 다니는 사람이 있다)
-- 직원 현황(퇴사자 포함) : 직원 정보와 부서 번호(정보),입사일이,퇴사일 있다
select * from dept_emp;
desc dept_emp;


-- 직원 입사,퇴사일 : 직원 입사,퇴사 정보가 있다
select * from dept_emp_latest_date;
desc dept_emp_latest_date;


-- 특정 부서 매니저 히스토리(employees,dept)
-- 부서_관리자 : 부서 관리자들의 정보(직원정보,부서,입사일,퇴사일)가 있다
select * from dept_manager;
desc dept_manager;


-- 사원정보
-- 직원 인적사항 : 직원들의 번호,생일,이름,성별,입사일이 있다 (개인 정보가 들어있다)
select * from employees;
desc employees;


-- 급여내역
-- 급여 : 직원들의 연봉 (employees의 자식)
select * from salaries;
desc salaries;

-- 직책 히스토리(employees의 자식)
-- 지원들의 직급 현황 : 지원들의 직급(사원번호 중복시 승진) (emp의 자식)
select * from titles;
desc titles;





-- 문제 1: > 사원들의 이름(성,이름을 합쳐서)과 입사일,직책을 입사일이 빠른 순으로 보요주세요
-- 이름을 불러낸다 > 합친다 >

select * from employees limit 10;

select emp_no, concat(first_name,last_name)as name,hire_date  from employees order by hire_date; -- 이름을 부르고 성,이름을 합친다

select distinct emp_no ,title from titles order by from_date asc  limit 10 ; -- 직책과 입사일


-- 조인
select concat(e.first_name,e.last_name)as name,e.hire_date,t.title  
	from employees e,titles t where e.emp_no = t.emp_no order by e.hire_date ;


-- 서브쿼리 X
 select
 	concat(first_name,last_name)as name
 	,e.hire_date
 	,(select title from titles t where e.emp_no=t.emp_no)
	from employees e order by e.hire_date ;


-- 왜? : e.emp_no=t.emp_no 가 1:1이 아닌가

-- 테이블의 크기 비교
select count(emp_no)from employees
union all
select count(emp_no)from titles ;

-- 중복제거
select count(distinct emp_no)from titles
union all
select count(emp_no)from employees;


select * from employees limit 10;
select * from titles limit 10;





-- 문제 3> dept_emp 를 기준으로 여러팀을 거져간 사원의 이름을 구하세요

-- step1
select emp_no,count(emp_no)as cat  from  dept_emp group by emp_no having cat>1;

-- step2
select e.emp_no,concat(first_name,' ',last_name) 
	from employees e where e.emp_no in(select emp_no from  dept_emp group by emp_no having count(emp_no)>1);


select e.emp_no,concat(first_name,' ',last_name)as name
	from (select emp_no from  dept_emp group by emp_no having count(emp_no)>1)de 
	join employees e 
	on e.emp_no =de.emp_no;




-- 문제 3> 각 인원이 어떤 팀에서 어떤 팀으로 이동했는지 보여주세요
-- 사원번호,팀번호,시작일,종료일

-- 팀을 이동한 사람을 찾는다
select e.emp_no,concat(first_name,' ',last_name) 
	from employees e 
	where e.emp_no in(select emp_no from  dept_emp group by emp_no having count(emp_no)>1);

-- 그 사람이 어떤팀에서 어떤팀으로 이동했는지 알아낸다
select emp_no ,dept_no ,from_date ,to_date  from dept_emp de 
	where emp_no in(select emp_no from  dept_emp group by emp_no having count(emp_no)>1)
;

select emp_no from  dept_emp group by emp_no having count(emp_no)>1;

-- 사원명, 팀명, 시작일, 종료일(쿼리 3개 연결)
select concat(first_name,' ',last_name) as name from employees e;
select dept_name from departments d;

select
	concat(e.first_name,' ',e.last_name) as name,d.dept_name,de.from_date, de.to_date
from
	(select * from dept_emp 
		where emp_no in (select emp_no  from dept_emp group by emp_no having count(emp_no) > 1)) de 
	join employees e on de.emp_no = e.emp_no 
	join departments d on de.dept_no = d.dept_no;

select * from dept_emp de ;
select * from employees e ;
select * from departments;






-- 문제 4>현 매니저들의 이름, 성별, 입사일, 직책, 직책 기간(from, to)

-- 현 팀장의 인적 정보 추가
select 
	concat(e.first_name,' ',e.last_name) as name, gender, hire_date 
from employees e where emp_no in(select emp_no from dept_manager where to_date > curdate()); 

-- 위 데이터에 titles 를 조인
select 
	dm.name, 
	dm.gender, 
	dm.hire_date, 
	t.title, 
	t.from_date, 
	t.to_date 
from(
	select 
		emp_no, 
		concat(e.first_name,' ',e.last_name) as name, 
		gender, 
		hire_date 
	from employees e where emp_no in(select emp_no from dept_manager where to_date > curdate())
) dm 	join titles t on dm.emp_no = t.emp_no;


select count(emp_no) from titles t where to_date > curdate(); 


select count(emp_no) from titles
union
select count(emp_no)  from titles t where t.emp_no >curdate() ;



select emp_no from dept_manager where to_date ='9999-01-01'; -- 매니저 정보

select * from titles; -- 직책,직책 기간

select * from employees; -- 이름,성별,입사일



-- 서브쿼리대 서브쿼리 조인
select 
	dm.name, 
	dm.gender, 
	dm.hire_date, 
	t.title, 
	t.from_date, 
	t.to_date 
from(
	select 
		emp_no, 
		concat(e.first_name,' ',e.last_name) as name, 
		gender, 
		hire_date 
	from employees e where emp_no in(select emp_no from dept_manager where to_date > curdate())
) dm join (select emp_no,title,from_date,to_date from titles t where to_date > curdate()) t on dm.emp_no = t.emp_no
;

select to_date > curdate() from dept_manager where to_date > curdate() -- curdate(): 현재 날짜를 반환한다


-- 문제 5 > 사원들의 사번,이름,현재 현 직책과 급여
-- 어떤 데이터를 어떻게 가져올지 생각한다

select count(emp_no)  from employees
union all
select count(emp_no)  from titles t where t.to_date >curdate()
union all
select count(emp_no)  from salaries s where s.to_date >curdate(); 


-- 459ms
select 
	e.emp_no
	,e.name
	,t.title
	,s.salary
from (select emp_no  
	,concat(first_name,last_name) as name
from employees  where  emp_no in(select emp_no  from salaries  where to_date = '9999-01-01')
)e join titles t on e.emp_no = t.emp_no 
join (select emp_no,salary  from salaries s where to_date = '9999-01-01')s on e.emp_no = s.emp_no 
;





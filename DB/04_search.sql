-- 1. 데이터 조회
-- 1)특정 컬럼 조회
-- SELECT [조회할 컬럼] FROM [테이블명];
select * from employees;
-- 내가 보여주고 싶은 것만 보여준다 
select first_name,family_name,mobile from employees;

-- 산술 표현(보여 줄 때만)
-- 숫자로된 컬럼에 대해서는 계산해서 보여 줄 수 있다(실제로 계산되는 건 아님)(/[숫자])(즉석으로 만든컬럼)
select first_name,family_name  ,salary/10000 as 급여 from employees;
-- 컬러명을 임시로 변경해서 보여 줄 수도 있다.(as[이름])

-- 보여주는 순서 변경 가능
select family_name ,first_name ,salary/10000 as 급여 from employees;

-- 문자열을 합칠 수도 있다(콘켓)(문자열만됨(문자+숫자 가능)(숫자+숫자 불가능))
select concat(family_name ,first_name ),salary/10000 as 급여 from employees;

-- 컬러명 이름 변경(as[이름])
select  concat(family_name ,first_name )as 이름,salary/10000 as 급여 from employees;

-- 문자열을 합칠 수도 있다(콘켓)
select concat(family_name ,first_name )as 이름,
concat(truncate( salary/1000,0),'만원' )as 급여 from employees;

-- 이 모든건 실제 데이터를 가공해서 보여중 뿐이지 조작 되진 않는다


-- 2. 특정 조건의 데이터를 조회
-- SELECT[조회할 컬럼] FROM [테이블] WHERE [조건]
-- 대입이라는 계념이 없다
select *from employees where family_name='김';-- if(name == '김')
select *from employees where salary = salary > 3000000; -- if(salary > 3000000)

-- && -> AND = (family_name=='김' && salary > 3000000)
-- (salary >= 1000000 && salary >= 3000000)
select * from employees where salary >=1000000 and salary <= 3000000;


-- || -> OR  (family_name=='김' || salary > 3000000)
select * from  employees where family_name = '김' or salary = 2000000;

-- BETWEEN AND(특정값 사이를 구할때 사용)
-- AND 조건을 이용 해서 salary 가 50만원 보다 크거나 같고, 400만원 보다 작거나 같은 사람의 first_name,family_name,salary를 구하시요
-- 부등호가 가끔 오류가 난다 
select first_name,family_name,salary  from  employees where salary >=500000 and salary <=4000000;

-- 부등호가 특수문자로 인식되는 경우가 있어서 피하고자 할때 종종 사용된다 (요즘은 않그런다) (이렇게 할 수도 있다)
select first_name,family_name,salary  from  employees where salary between 500000 and 4000000;

-- 3. 중복제거
-- SELECT DEISTINCT(디스인트)[출력할 컬럼] FROM [테이블]
select distinct family_name  from employees where salary = 2000000;
-- distinct 는 하나의 컬럼만 사용 할때 가장 정확한 효과가 나타난다(단일 컬럼만 활용하자)
select distinct family_name,first_name  from employees where salary = 2000000;

-- 4. IN(OR 하고 똑같다)
-- family_name 이 '김'또는 '이'또는 '박'인 사람의 모든 정보를 가져와라(지금 당장은 or라도 제대로 써라)
select * from employees where family_name = '김' or family_name ='이' or family_name ='박';
-- or로 비교하는 컬럼이 모두 동일 해야함(속도가 훨씬 빠르다)
select * from employees where family_name in ('김','이','박');

-- 5.IS NULL(IS:가져와라) || IS NOT NULL;
select * from employees;
-- commission 이 10인 녀석을 찾아서 null로 만들어라
update employees set commission = null where commission =  10;

-- commission 값이 null만 출력
select * from employees where commission is null;
-- commission 값이 null만 빼고 출력
select * from employees where commission is not null;


-- 6.LIKE(라이크)(검색 대충 맞으면 출력)(문자열에만 사용)
-- 일부 비숫한 문자열을 검색 - 검색 기능을 사용할때 가장 많이 사용(데이터가 많으면 절때 쓰면 안된다)(쓰면 쓸수록 느려진다)
-- WHERE [컬럼명] LIKE '%[문자열]%' 
-- 남발할 경우 속도 저하가 심하다

-- ze%    :	ze로 시작하지만 뒤에는 아무거나 와도 된 			-> ze로 시작하는..
-- %com   :	앞에 아무거나 와도 되지만 뒤는 com 으로 끝아야 한다	-> com 으로 끝나는...
-- %se%   :	se 앞뒤에 아무거나 와도 된다						-> se를 포함하는...
-- %s%e%  :	s와 e 사이에 아무거나 와도 된다					-> s또는 e를 포함하는....

select * from employees;

select * from employees where email like 'ze%';
select * from employees where email like '%com';
select * from employees where email like '%se%';
select * from employees where email like '%s%e%';

select * from employees;


-- 7)ORDER BY(정렬)
-- 특정 컬럼을 기준으로 정렬
-- 오름차순(1234(삼각형▲))ASC 내림차순(4321(역삼각형▼))DESC
-- SELECT * FROM[테이블명] ORDER(오더) BY[컬럼명][ASC|DESC];
select * from employees order by salary desc;
select * from employees order by family_name asc;
select * from employees order by family_name;-- asc는 생략이 가능 하다

-- 김씨 중에서 급여가 높은 순으로 정렬 하시요(왠만하면 데이터를 뽑아놓고 order by는 맨 뒤로간다)
select * from employees where family_name = '김' order by salary desc;

-- (컬럼을 한글로 쓰면오류가 날확율이 생기기 때문에 가능한 영어도 쓰자)
-- 연봉이 높은 순으로 정렬 하세요
select family_name,first_name ,email,salary*12 as ann_sal from employees order by ann_sal desc;

-- 다중정렬(,)(1차 정렬후 동률의 데이터 에서 2차 정렬을 진행)
select * from employees order by family_name,salary ; -- 1번째을 기준으로 정렬을 시키고 그 데이터로 또 2차 정렬을 한다


-- 8) GROUP(구룹) BY
-- 데이터를 특정 컬럼을 기준으로 묶어서 자져오는 경우 사용(통계)
-- SELECT [컬럼1],[컬럼2]..... FROM[테이블이름] GROUP BY [묶어줄 컬럼]
-- 주의!! 조회되는 컬럼들은 묶어주는 기준 컬럼 이거나, 집계되는 컬럼 이어야 한다

-- 부서별로 급여 합산(depart_no기준으로 계산)
select * from employees;
select * from employees where depart_no = 'dev001';
select depart_no,sum(salary) from employees where depart_no = 'dev002';
select depart_no,sum(salary) from employees where depart_no = 'dev002';
select depart_no,sum(salary) from employees where depart_no = 'dev003';
select depart_no,sum(salary) from employees where depart_no = 'dev004';
select depart_no,sum(salary) from employees where depart_no = 'dev005';

-- 위 내용을 그룹바이로 변환
select depart_no,sum(salary) from employees GROUP by depart_no;

-- 그룹의 기준이 되는 컬럼과,집계 컬럼 외의 다른 컬럼이 들어간다면
-- 나 오긴 하지만 그 의미를 알 수 없다 -> 각 그룹의 가장 첫값을 보여준다
-- 다른 DB 에서는 이경우 에러를 발생 시킬수도 있다
select depart_no,sum(salary),family_name  from employees GROUP by depart_no;

-- 부서별 급여 평균 -AVG(column컬럼)
select depart_no,truncate( avg(salary),0)as sal_avg  from employees GROUP by depart_no;

-- HAVIG(해빙)(조건문)
-- GROUP BY 에서 WHERE 처럼 조건을 주고 싶을때 사용
-- 합계 급여가 500만원 이상인 팀을 추출
-- having(해빙)은 별칭은 사용하면 안된다(total 대신sum(salary)를 써야한다 )
-- 마리아에서는 허용 해 주지만 몇몀ㅊ 디비에서는 에러가 발생한다
select depart_no,sum(salary)as toral,family_name  from employees GROUP by depart_no having toral>5000000;

-- 급여 합계가 500만원 이상인 부서들을 합계 습여가 높은 순으로 정렬 하세요
select sum(salary) from employees group by depart_no having sum(salary)>5000000 order by sum(salary)desc; 




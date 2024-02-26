-- transacrion -> TX -> tranx

-- 1) AUTO COMMIT(오토 커및) 여부
select @@autocommit; -- 1:설정 , 0:미설정
-- 커밋을 하면 데이터를 되돌릴수 없다
-- 중요한 내용은 오토커밋을 끄고 해라

-- 설정 | 미설정
set autocommit=1; -- 오토커밋 설정 on
set autocommit=0; -- 오토커밋 설정 off


-- commit 과 rollback 은 데이터(DML)에 한정 한다
-- DCL,DDL은 되돌릴 수 없다

-- 현재 상태를 저장하는 것이commit;
select * from employees;
update employees set commission = 10 when emp_no =120;
commit;

delete from employees ;
-- rollback : commit 하지 않은 내용에 대해서 되돌릴 수 있다
rollback;
-- 백업 파일을(dump) 테이터베이스로 복원하는 법
-- 1. 복원할 데이터 베이스를 생성(없다면)
create database employees;
show databases;

-- 2. mariadb 가 설치되어 있는 bin 폴더로 접근

-- C:\Program Files\MariaDB 11.3\bin
-- cmd 창을 열어서 다음 명령어 실행
-- [mysql | mariadb] -u [관리자계정] -p [복원일데이터베이스명] < [백업파일 위치] -- <(화살표)
mysql -u root -p employees < C:/test_data/employees.sql

-- ERROR at line 113: Failed to open file 'load_departments.dump', error: 2
-- 발생시 employees.sql 파일을 열어서 source 부분을 수정 해 준다.
-- 예> source C:/test_data/load_salaries3.dump ;
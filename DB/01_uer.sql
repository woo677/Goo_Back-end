-- 주석
/*1.유저 생성*/
-- CREATE USER [유저이름]@[접근 가능한 IP] IDENTIFIED BY [비밀번호]
-- 대문자는 바뀌지 않는 명령어


-- web_user 는 모든 IP에서 접근 가능하고,비밀번호는 pass 로 만들어라
-- %아무나 접근가능(와일드카드)
-- *은 관련된 것을 다 가져와
-- 자바처럼 한번쓰고 날리지 않고 영구 저장을 하기 때문이다

-- web_user 는 모든 IP에서 접근 가능하고,비밀번호는 pass로 만들어라 
create user 'web_user'@'%'identified by 'pass';
create user 'test01'@'%'identified by 'ijkl1104';

-- dba_user는 192.168로 시작되는 IP에서 접근 가능하고,비밀번호는 pass로 만들어라
-- 특정 IP대역만 접근 가능하게 할 경우
create user 'dba_user'@'192.168.%' identified by 'pass';

-- user002 는 192.168.38.70 IP 에서만 접근 가능하고, 비밀번호는 pass3로 만들어라
create user 'user002'@'192.168.38.70' identified by 'pass3';

-- 유저 생성 확인
select * from mysql.user;

/*2. 권한 부여 및 회수*/
-- 권한 부여(GRANT)(그랜트) TO누구에게
-- GRANT[권한종료] ON [데이터베이스.테이블] TO [유저명]
-- 데이터를 INSERT(추가), UPDATE(수정), SELECT(조회), DELETE(삭제)
-- ALL PRIVILEGES : GRANT OPTION 을 제외한 모든 권한 부여(데이터를 수정할수는 있지만 권한을 줄수는 없다)
-- GRANT OPTION : 권한을 주는 권한(고칠수 있는 권한을 다른 사람에게 또주는 것)

-- dba_user 에게 모든 데이터베이스에 모든 테이블의 데이터를 볼수 있는 권한을 준다
-- user 명시할때 IP도 함께 명시 해야 한다
grant select on *.*to 'dba_user'@'192.168.%';
grant all privileges on *.*to 'test01'@'%';

-- user002 에게 모든 데이터베이스의 모든 테이블에 데이터를 보고,추가하고,수정하고,삭제할 수 있는 권한을 준다
grant select,insert,update,delete on *.* to 'user002'@'192.168.38.70';

-- web_user에게 모든 데이터베이스에 모든 테이블의 데이터를 뭐든지 할 수 있는(권한 주는거 제외) 권한을 준다.
-- IP 가 % 인 경우는 생략 가능
grant all privileges on *.* to 'web_user'@'%';
grant all privileges on *.* to 'web_user';

-- 유저 권한은 user 확인에서 가능하다
select * from mysql.user;

/*권환 회수*/
-- REVOKE(리보크) [권한] ON [데이터베이스.테이블] FROM[유저명] : (FROM)누구로 부터
-- GRANT(그랜트)[권한종료] ON [데이터베이스.테이블] TO [유저명]: (TO)누구에게
-- 'user002'@'192.168.38.70' 에게 insert,update,delete 권한을 회수하기
revoke insert,update,delete on *.* from 'user002'@'192.168.38.70';

/*비밀번호 변경(일반 사용자가 비번을 일어버리면 바꿔줄수 있다(root는 비번을 잃어버리면 다시 찾을수 없다))*/
-- SET(쎗) PASSWORD FOR[사용자] = PASSWORD(패스워드);
-- 변경이 됬느는지는 
set password for 'user002'@'192.168.38.70' = password('ASDF');


/*유저 삭제*/
-- DPOP USER [유저이름]@[IP]
drop user 'dba_user'@'192.168.%';
drop user 'user002'@'192.168.38.70';

select * from mysql.user;

/*D.C.L(Data Control Language)
 * 데이터 사용 권한이나 유져를 다루는 언어 (일반 게발자 할일이 거의 없다)
 * (처음 설치하거나 그럴 때만 쓴다)
 * */

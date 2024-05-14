#dump 는 데이터베이스를 복사해서 백업하는 작업을 의미
#본래는 서버에 접속해서 dump 명령어로 가져와야 한다
#dbever 로 할 경우 데이터의 양과 테이블의 규모가 크면 잘 되지 않는다.

# 1. 덤프 파일을 받아낸다
# 2. 덤프받은 파일을 복원하기 위해 같은 이름의 데이터베이스를 생성한다
create database gdj78_semi_backcourt;
show databases;

# 3. 덤프 복원(버전에 따라서 다르다.)(덤프 복원 작업) 
# < : 화살표 
# 구 버전
# mysqldump -u root -p [데이터베이스명] < [덤프파일위치]

# 신 버전
# [mysql|mariadb] -u root -p [데이터베이스명] < [덤프파일위치]
mariadb -u root -p gdj78_semi_backcourt < F:\backup.sql


# 4. 복원 확인
use gdj78_semi_backcourt;
show tables;
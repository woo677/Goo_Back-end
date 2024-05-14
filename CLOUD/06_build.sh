# 1. mariadb 컨테이너 실행
# -v : 컨테이너의 특정 폴더와 서버의 특정 폴더를 연결해 주는 옵션
# -v 서버의 폴터 경로 : 커테이너의 폴더 경로
mkdir db #폴더 생성

docker run -d --name mariadb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=gudi@gdj78 -v /home/ec2-user/db:/var/lib/mysql mariadb:11.3

# 2.web_user 생성 및 권한 부여
CREATE user 'web_user'@'%' identified by 'admin@pass';
grant all privileges on *.* to 'web_user';
SELECT * FROM mysql.user;

# 3. DB 에서 덤프 해 오기
# [mysqldump|mariadb-dump] -u root -p [데이터베이스명] > [내보낼경로]
mariadb-dump -u root -p gdj78_semi_backcourt > F:/my_dump.sql

# 4. filezilla 를 통해 백업 파일 서버로 이동

# 컨테이너 이동
docker exec -it mariadb /bin/bash

# 5. 백업 파일을 컨테이너로 이동(복사)
docker cp ./my_dump.sql mariadb:/home/

# 6. 복구(하기 전에 해당 이름의 데이터베이스가 존재 해야 함)
CREATE database gdj78_semi_backcourt
# [mysql|mariadb] -u root -p [데이터베이스명] < [가져올경로]
docker exec -it mariadb /bin/bash
mariadb -u root -p gdj78_semi_backcourt < /home/my_dump.sql

# ====================================

# 톰캣 연동
# 1. 컨테이너 실행
docker run -d --name tomcat -p 80:8080 -v /home/ec2-user/webapps:/usr/local/tomcat/webapps tomcat:9.0

# 2. 404 발생 해결
cd webapps
mkdir ROOT
cd ROOT
mv ../../index.html ./index.html #mv : 파일 이동

# 3. webapps/photo 폴더 만든 후 이미지 넣기
# 15.164.99.254/photo/이미지명 으로 이미지 잘 나타나는지 확인


# 4. 소스 내에서 업로드 경로를 변경 해 준다.
# C:/upload -> /usr/local/tomcat/webapps/photo
# 필요한 경우 DB 의 IP 와 비밀번호도 변경 해 준다.
# 빌드

# 5. tomcat 컨테이너 정지 해 준다.
docker stop tomcat

# 6. war 파일 ROOT.war 로 변경 후 FIlezila 를 통해 업로드

# 7. 권한을 변경해 준다
sudo chmod -R 777 ROOT.war

# 8. 컨테이너 작동
docker start tomcat
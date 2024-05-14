# 버전 확인
SELECT version(); # 11.3.1 

# 1.mariadb image 검색
docker search mariadb

# 2.허브로 부터 image pull
docker pull mariadb:11.3
docker pull mariadb # 버전이 빠지면 최신버전으로 받는다.

# 확인
docker images

# 3. 컨테이너 실행 (컨테이너를 생성한다음 실행)
# -e : 환경설정
docker run -d --name mariadb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1111 mariadb:11.3

# 4.실행 확인
docker ps

# 이후 DBEVER 로 접속 확인 까지 해 준다
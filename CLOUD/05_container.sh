# 컨테이너 동작 관련 확인
docker ps -a
docker container ls -a

# 컨테이너 정지
# socker stop [컨네이너]
# 여러개의 컨테이너를 정지시키고 싶다면 계속 추가해 주면 된다.
docker stop tomcat mariadb

# 컨테이너 실행
# docker start [컨테이너 이름]
docker start tomcat mariadb

# 컨테이너 삭제(컨테이너가 먼저 정지되어 있어야 한다)
# rm : 완전 삭제
# -f : 어째든 지워
# docker container rm -f [컨네이너 이름]
docker container rm -f tomcat
docker container rm -f mariadb

# 다운로드 이미지 확인
docker images

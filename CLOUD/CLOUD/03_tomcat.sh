#현재 이미지 확인
docker images

# docker hud 에서 검색 (https://www.docker.com/)
# docker search [원하는 프로그램]
docker search tomcat
NAME DESCRIPTION  STARS     OFFICIAL
                  좋아요    공식 여부

# 다운로드 받기
# docker pull [프로그램]:[버전] (원하는 버전이 있을 때만)
docker pull tomcat:9.0

# 다운로드 이미지 확인
docker images

# 톰캣 구동 - 아래  명령어는 컨테이너를 생성 후 실행 하는 명령어
# docker run -d --name [컨테이너이름] -p [요청포트]:[연결포트] [이미지이름]:[버전]
docker run -d --name tomcat -p 8080:8080 tomcat:9.0
# --name 을 설정하기 않으면 임의로 이름을 지어버린다.
# -p 컨테이너 밖에서 8080 포트로 요청이 들어오면 컨테이너 내부의 8080포트와 연결 하겠다.
docker container ls #로 확인
docker ps


# 404 원인 파악?  
# 컨테이너 안으로 진입
# docker exec [옵션] [컨테이너명] /bin/bash
# -it : 푸티처럼 터미널로 컨테이너와 연결 하겠다.
docker exec -it tomcat /bin/bash
cd webapps
ls # 아무것도 없기 때문에
# ROOT 라는 폴더를 만들고
mkdir ROOT

# index.html 파일을 넣어줄 예정
# Filezila 를 통해서 파일을 AWS 서버안으로 이동
# 서버에서 컨테이너 안으로 파일 복사
# docker cp [복사할 파일] [보낼컨테이너 이름]:[컨테이너안의 경로]
docker cp ./index.html tomcat:/usr/local/tomcat/webapps/ROOT/


# 컨테이너에서 빠져나오고 싶다면..
exit

# 톰캣 컨테이너를 정지했다가 시작하기
docker stop tomcat
docker start tomcat

# docker에 실행 중인 파일을 보고 싶은때
docker ps
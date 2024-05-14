# docker 설치
yum install docker -y

# service 등록(서버 켜질때 도커도 같이 켜지도록)
# redhat 계열에서만..
# ubuntu 는?(systemctl 우분투)
sudo systemctl start docker

# 도커가 살아 있는지 확인
# grep : 잡아 놓다
ps -ef | grep docker #(현재 돌아가는 프로그램이 다 나온다)

# 도커의 이미지 리스트 확인
# docker [명령어]
docker images

# permission denied : 권한 없는 파일을 건드릴때 나는 메시지
ls -al /var/lib #/var/lib 경로에 있는 리스트의 상세 정보를 보여달라

# docker 내용만 보고 싶다면
la -al /var/lib | grep docker
# containerd 내용만 보고 싶다면
la -al /var/lib | grep containerd

drwx--x---. 12 root   root     171 May 14 09:25 docker

drwxr-xr-x. 10 root   root   16384 May 14 09:25 containerd

# sudo 를 붙여서 해도 된다
# 그런데 하나하나 sudo 붙이기가 귀찮으므로 이럴경우 권한을 변경해주면 된다